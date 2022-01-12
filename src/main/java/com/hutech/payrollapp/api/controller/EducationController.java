package com.hutech.payrollapp.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Education;
import com.hutech.payrollapp.api.service.EducationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EducationController {

	@Autowired
	private EducationService educationService;

	@PostMapping("addEducationDetails")
	public String addEducation(@RequestBody Education education) {
		educationService.save(education);
		return "Education Details Added";
	}

	@GetMapping("/getEducationDetails")
	public Optional<Education> getEducationDetails(@PathVariable Long courseId) {
		return educationService.findById(courseId);
	}

	@DeleteMapping("/deleteCourse/{courseId}")
	public String deleteEducationDetails(@PathVariable Long courseId) {
		educationService.deleteById(courseId);
		return "Course has Deleted for the ID: " + courseId;
	}

}
