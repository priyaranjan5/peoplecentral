package com.hutech.payrollapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.exceptionhandler.IdAlreadyExistException;
import com.hutech.payrollapp.api.exceptionhandler.NameAlreadyExistException;
import com.hutech.payrollapp.api.model.Department;
import com.hutech.payrollapp.api.service.DepartmentService;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/createDepartment")
	public String addDepartment(@RequestBody Department department)
			throws IdAlreadyExistException, NameAlreadyExistException {
		departmentService.save(department);
		return "Department Created.";
	}

	@GetMapping("/viewDepartment")
	public List<Department> viewDepartment() {
		return departmentService.get();

	}
}
