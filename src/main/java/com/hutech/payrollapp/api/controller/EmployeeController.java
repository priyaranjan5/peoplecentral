package com.hutech.payrollapp.api.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hutech.payrollapp.api.exceptionhandler.ApiException;
import com.hutech.payrollapp.api.exceptionhandler.EmailAlreadyExistException;
import com.hutech.payrollapp.api.jwtUtill.JwtUtil;
import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.model.EmployeeLoginRequest;
import com.hutech.payrollapp.api.model.EmployeeResponse;
import com.hutech.payrollapp.api.service.EmployeeService;
import com.hutech.payrollapp.api.serviceImpl.EmployeeLoginService;
import com.hutech.payrollapp.api.serviceImpl.EmployeeServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private EmployeeLoginService employeeLoginService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/addEmployee")
	public String onboardEmployee(@RequestBody Employee employee)
			throws MessagingException, EmailAlreadyExistException {
		employeeService.save(employee);
		return "Please Check Your Registered Email Id: " + employee.getEmpEmail() + " to Activate Your Account!!!";
	}

	@PutMapping("/addMultipartfile/{empId}")
	public String addMultipartFile(@RequestParam("image") MultipartFile image,
			@RequestParam("resume") MultipartFile resume, @PathVariable String empId) throws IOException, ApiException {
		/*
		 * if
		 * (image.getContentType().equals("image/jpeg")||image.getContentType().equals(
		 * "image/png")) { if
		 * (resume.getContentType().equals("application/pdf")||resume.getContentType().
		 * equals(
		 * "application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
		 */
		if (image.getContentType().equals("image/jpeg")||image.getContentType().equals("image/png")) {
				employeeService.addFile(image, resume, empId);
				return "File Uploaded Successfully!!!";
		}
			return "Uploaded File Format is not Supported. Please Upload jpeg/png for Image and pdf/doc for Resume!!!";
	}

	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployee(@PathVariable String empId) throws ApiException {
		return employeeService.findById(empId)
				.orElseThrow(() -> new ApiException(404, "EMPLOYEE INFORMATION NOT FOUND FOR THE ID : " + empId));
	}

	@GetMapping("/onboardedEmployees")
	public List<Employee> findall() {
		return (List<Employee>) employeeService.findAll();
	}

	@GetMapping("/createPassword")
	public ModelAndView openForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createPasswordPage");
		return mv;
	}

	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		List<Employee> employee = employeeServiceImpl.getByResetPassword(token);
		employeeServiceImpl.updatePassword(employee, password);
		model.addAttribute("message", "You have successfully changed your password.");
		return "message";
	}

	@GetMapping("/verifyEmployee")
	public ModelAndView verifyEmp(@Param("verificationToken") String verificationToken) {
		if (employeeServiceImpl.verifyEmp(verificationToken)) {
			ModelAndView activationsuccess = new ModelAndView();
			activationsuccess.setViewName("activationsuccessful");
			return activationsuccess;
		} else {
			ModelAndView activationfail = new ModelAndView();
			activationfail.setViewName("activationfailure");
			return activationfail;
		}
	}

/*	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}*/
	
	@GetMapping("/login")
	public RedirectView loginRedirection() {
		RedirectView view=new RedirectView();
		view.setUrl("https://ecstatic-joliot-113494.netlify.app/");
		return view;
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginSuccess");
		return mv;
	}

	@PostMapping("/emp")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody EmployeeLoginRequest loginRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmpEmail(), loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		final UserDetails userDetails = employeeLoginService.loadUserByUsername(loginRequest.getEmpEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new EmployeeResponse(token, loginRequest.getEmpEmail(), loginRequest.getPassword()));
	}

	@PostMapping("/employeeLogin")
	public String check(@RequestBody Employee loginRequest) {
		String msg = employeeService.findE(loginRequest);
		return msg;
	}
}

/*
 * @PostMapping("/onboardEmployee") public String
 * addEmployee(@Valid @RequestParam("image") MultipartFile
 * image,@RequestParam("resume") MultipartFile resume, @RequestPart Employee
 * employee) throws IOException, IdAlreadyExistException,
 * EmailAlreadyExistException, MessagingException { employeeService.save(image,
 * resume, employee); return
 * "Employee Onboarded. Please check your registered email id: " +
 * employee.getEmpEmail(); }
 */

/*
 * @PostMapping("/check") public ResponseEntity<?> empInfo(@RequestBody Employee
 * emp) { final UserDetails userDetails =
 * employeeServiceImpl.loadUserByUsername(emp.getEmpEmail()); return
 * ResponseEntity.ok(userDetails); }
 */

/*
 * MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
 * helper = new MimeMessageHelper(message);
 * helper.setTo(employee.getEmpEmail());
 * helper.setSubject("PeopleCentral Onboarding Verification"); String content =
 * "<center><h1>Welcome to PeopleCentral</h1>" + "<h3> Dear, " +
 * employee.getEmpFirstName() + "</h3>" +
 * "<h4>Please click the link below to Activate your account</h4></center>" +
 * "<center>" +
 * "http://localhost:8045/application/createPassword/verify?verificationCode=" +
 * "</center>"; message.setContent(content, "text/html; charset=utf-8");
 * mailSender.send(message);
 */