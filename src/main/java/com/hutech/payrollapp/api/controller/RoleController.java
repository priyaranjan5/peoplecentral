package com.hutech.payrollapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Role;
import com.hutech.payrollapp.api.service.RoleService;

@RestController
@CrossOrigin(origins="*")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/createRole")
	public String addRole( @Valid @RequestBody Role role) {
		roleService.save(role);
		return "Role Created";
	}
	@GetMapping("/viewRole")
	public List<Role> viewRole() {
		return roleService.get();
		
	}
}
