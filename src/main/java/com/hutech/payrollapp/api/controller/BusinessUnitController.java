package com.hutech.payrollapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.BusinessUnit;
import com.hutech.payrollapp.api.service.BusinessUnitService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BusinessUnitController {
	
	@Autowired
	private BusinessUnitService buService;
	
	@PostMapping("/createBusinessUnit")
	public String addBusinessUnit(@Valid @RequestBody BusinessUnit businessUnit) {
		buService.save(businessUnit);
		return "Business Unit Added";
	}
	
	@GetMapping("/viewBusinessUnit")
	public List<BusinessUnit> findAllBusinessUnit() {
		return buService.findAll();
	}
}
