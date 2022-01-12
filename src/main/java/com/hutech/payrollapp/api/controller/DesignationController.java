package com.hutech.payrollapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Designation;
import com.hutech.payrollapp.api.service.DesignationService;

@RestController
@CrossOrigin(origins="*")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping("/createDesignation")
	public String addDesignation(@Valid @RequestBody Designation designation) throws IdAlreadyExistException,NameAlreadyExistException {
		designationService.save(designation);
		return "Designation Created";
	}
	@GetMapping("/viewDesignation")
	public List<Designation> viewDesignation() {
		return designationService.get();
		
	}
}
