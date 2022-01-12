package com.hutech.payrollapp.api.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hutech.payrollapp.api.model.Employee;
import com.hutech.payrollapp.api.model.Timesheet;
import com.hutech.payrollapp.api.repository.EmployeeRepository;
import com.hutech.payrollapp.api.service.TimesheetService;
import com.hutech.payrollapp.api.serviceImpl.MailServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TimesheetController {
	
	@Autowired
	private TimesheetService timesheetService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MailServiceImpl mailServiceImpl;
	
	@PostMapping("/addTimesheet")
	public String addTimesheet(@RequestBody Timesheet timeSheet) throws MessagingException {
		String empid = timeSheet.getEmployee().getEmpId();
		timesheetService.save(timeSheet);
		Employee e = employeeRepository.findByEmpId(empid);
		String mang = e.getManagerEmail();
		mailServiceImpl.sendEmail(mang,timeSheet);
		return "Mail has been sent to your Manager's Email for Approval: "+ mang;
	}
	@GetMapping("/verify")
	public ModelAndView verifyUser(@Param("verificationCode") String verificationCode) throws MessagingException {
		if (mailServiceImpl.verify(verificationCode)) {
			ModelAndView success = new ModelAndView();
			success.setViewName("success");
			return success;
		} else {
			ModelAndView error = new ModelAndView();
			error.setViewName("error");
			return error;
		}
	}
}
