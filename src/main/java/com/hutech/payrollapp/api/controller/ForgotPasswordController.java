package com.hutech.payrollapp.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hutech.payrollapp.api.exceptionhandler.EmployeeNotFoundException;
import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.model.Utility;
import com.hutech.payrollapp.api.serviceImpl.EmployeeServiceImpl;

import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ForgotPasswordController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/forgotPasswordEmail")
	public ModelAndView forgotPasswordEmail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("email");
		return mv;
	}

	@PostMapping("/emp_forgot_password")
	public ModelAndView processForgotPassword(HttpServletRequest request, Model model) {

		String username = request.getParameter("username");
		String token = RandomString.make(45);
		
		try {
			employeeServiceImpl.updateResetPassword(token, username);
			String resetPasswordLink = Utility.getSiteURL(request) + "/emp_reset_password?token=" + token;
			sendEmail(username, resetPasswordLink);
			model.addAttribute("message", "We will be sending a reset password link to your email.please check");

		} catch (EmployeeNotFoundException e) {
			model.addAttribute("error", e.getMessage());

		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "error while sending email");
		}
		model.addAttribute("pageTitle", "Forgot password");
		ModelAndView md=new ModelAndView();
		md.setViewName("linksend");
		return md;
	}

	public void sendEmail(@Param("username") String username, String resetPasswordLink)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		//helper.setFrom("sasmita.hutech@gmail.com", "Sasmita Mandal");
		helper.setTo(username);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + resetPasswordLink
				+ "\">Change my password</a></p>" + "<br>" + "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);
	}
	@GetMapping("/emp_reset_password")
	public ModelAndView showResetPasswordForm(@Param(value = "token") String token, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reset_password_form");
		
		ModelAndView mv1=new ModelAndView();
		mv1.setViewName("message");;
		List<Employee> emp = employeeServiceImpl.getByResetPassword(token);
		if (emp == null) {
			model.addAttribute("title", "reset your password");
			model.addAttribute("message", "invalid token");
			return mv1;
		}
		model.addAttribute("token", token);
		model.addAttribute("pageTitle", "Reset your Password");
		return mv;
	}
	
	@PostMapping("/emp_reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");

		List<Employee> employee = employeeServiceImpl.getByResetPassword(token);
		model.addAttribute("title", "Reset your password");

		if (employee == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		} else {
			employeeServiceImpl.updatePassword(employee, password);

			model.addAttribute("message", "You have successfully changed your password.");
		}

		return "message";
	}
}
