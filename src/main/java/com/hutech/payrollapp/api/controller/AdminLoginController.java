package com.hutech.payrollapp.api.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hutech.payrollapp.api.jwtUtill.JwtUtil;
import com.hutech.payrollapp.api.model.AdminLogin;
import com.hutech.payrollapp.api.model.AdminRequest;
import com.hutech.payrollapp.api.model.AdminResponse;
import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.repository.AdminRepository;
import com.hutech.payrollapp.api.repository.EmployeeRepository;
import com.hutech.payrollapp.api.serviceImpl.AdminLoginService;
import com.hutech.payrollapp.api.serviceImpl.EmployeeServiceImpl;

import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminLoginController {
	
	@GetMapping("/adminlogin")
	public String login() {
		return "adminLogin";
	}

	@GetMapping("/success")
	public String home() {
		return "index";
	}

	private static final @NotEmpty @Size(min = 8, message = "password should have at least 8 character") String String = null;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminLoginService loginService;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/logintoken")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AdminRequest adminrequest)
			throws UsernameNotFoundException {

		AdminLogin adminLog = adminRepository.findByEmpEmail(adminrequest.getEmpEmail());
		Employee emp = employeeRepository.findByEmpEmail(adminrequest.getEmpEmail());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (adminLog != null && adminLog.getPassword().equals(adminrequest.getPassword())) {
			final UserDetails userDetails = loginService.loadUserByUsername(adminrequest.getEmpEmail());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AdminResponse(token, adminrequest.getEmpEmail(), adminrequest.getIsAdmin(),
					adminrequest.getIsManager(), adminrequest.getIsEmployee()));
		}

		else if (emp.getEmpEmail().equals(adminrequest.getEmpEmail())
				&& passwordEncoder.matches(adminrequest.getPassword(), emp.getPassword())) {
			final UserDetails userDetails = employeeServiceImpl.loadUserByUsername(adminrequest.getEmpEmail());
			final String token = jwtTokenUtil.generateToken(userDetails);
			adminrequest.setIsAdmin(false);
			return ResponseEntity.ok(new AdminRequest(token, adminrequest.getEmpEmail(), adminrequest.getPassword(),
					adminrequest.getIsAdmin(), adminrequest.getIsManager(), adminrequest.getIsEmployee()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Incorrect username or password");
	}

	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody AdminLogin adminLogin) {
		String token = RandomString.make(64);
		adminLogin.setAdminToken(token);
		adminRepository.save(adminLogin);
		return "Admin Added";
	}
	@PostMapping("/findAdmin/{empEmail}")
	public String find(@PathVariable String empEmail) throws MessagingException {
		AdminLogin ad = adminRepository.findByEmpEmail(empEmail);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(ad.getEmpEmail());
		helper.setSubject("Password Reset Request");
		String content = "<center><h1>Welcome to PeopleCentral</h1>"
				+ "<h4>Please click the link below to reset your password</h4></center>" + "<center>"
				+ "https://hutechpayrollapp.herokuapp.com/application/reset_your_password" + "</center>";
		message.setContent(content, "text/html; charset=utf-8");
		javaMailSender.send(message);
		return "Message sent";
	}

	@GetMapping("/showform")
	public ModelAndView viewPwdForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reset_password_form");
		return mv;
	}

	@PostMapping("/forgot-admin-password")
	public String forgotPassword(String empEmail) throws MessagingException {

		String response = loginService.forgotPassword(empEmail);

		if (!response.startsWith("Invalid")) {
			response = "https://hutechpayrollapp.herokuapp.com/application/reset-admin-password?adminToken=" + response;
		}
		AdminLogin ad = adminRepository.findByEmpEmail(empEmail);
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(ad.getEmpEmail());
		helper.setSubject("Password Reset Request");
		String content = "<center><h1>Welcome to PeopleCentral</h1>"
				+ "<h4>Please click the link below to reset your password</h4></center>" + "<center>"
				+ "https://serene-leavitt-589e50.netlify.app/forgotpassword" + "</center>";
		message.setContent(content, "text/html; charset=utf-8");
		javaMailSender.send(message);
		// return "Please Check Your Registered Email Id for Password Reset Link!!!";
		return response;
	}

	@PutMapping("/reset-admin-password")
	public String resetPassword(@RequestParam String adminToken, @RequestParam String password) {
		return loginService.resetPassword(adminToken, password);
	}
}
