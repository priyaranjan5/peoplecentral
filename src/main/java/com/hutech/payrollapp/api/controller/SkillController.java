package com.hutech.payrollapp.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hutech.payrollapp.api.model.Skill;
import com.hutech.payrollapp.api.service.SkillService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping("/createSkill")
	public String addSkill(@Valid @RequestBody Skill skill) {
		skillService.save(skill);
		return "Skill Added";
	}
}
