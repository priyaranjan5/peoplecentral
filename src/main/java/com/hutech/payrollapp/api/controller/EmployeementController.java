package com.hutech.payrollapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Employeement;
import com.hutech.payrollapp.api.service.EmployeementService;

@RestController
@CrossOrigin(origins="*")
public class EmployeementController {
	
	@Autowired
	private EmployeementService employeementService;
	
	@PostMapping("/createEmployeement")
	public String addemployeement(@Valid @RequestBody Employeement employeement) {
		 employeementService.save(employeement);
		 return "employeement created";
	}
	@GetMapping("/viewEmployeement")
	public List<Employeement> viewEmployeement() {
		return employeementService.get();
		
	}
}
