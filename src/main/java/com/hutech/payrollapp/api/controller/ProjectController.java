package com.hutech.payrollapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Project;
import com.hutech.payrollapp.api.service.ProjectService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping("/addProject")
	public String addProject(@RequestBody Project project) {
		projectService.save(project);
		return "Project has added Sucessfully";
	}

	@GetMapping("/viewProject")
	public List<Project> getProject() {
		return projectService.viewProjectModule();
	}
}
