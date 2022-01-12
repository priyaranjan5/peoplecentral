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

import com.hutech.payrollapp.api.model.Family;
import com.hutech.payrollapp.api.service.FamilyinfoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FamilyInfoController {

	@Autowired
	private FamilyinfoService familyinfoService;

	@PostMapping("/addFamilyInformation")
	public String addFamilyInfo(@RequestBody Family familyinfo) {
		familyinfoService.save(familyinfo);
		return "Family Informations Added...";
	}

	@GetMapping("/getFamilyInfoById/{familyId}")
	public Optional<Family> getFamily(@PathVariable Long familyId) {
		return familyinfoService.findById(familyId);
	}

	@DeleteMapping("/deleteFamilyInfo/{familyId}")
	public String deleteInfo(@PathVariable Long familyId) {
		familyinfoService.deleteById(familyId);
		return "Family Information Deleted...";
	}
}
