package com.hutech.payrollapp.api.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.model.Organization;
import com.hutech.payrollapp.api.service.OrganizationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrganizationController {

	@Autowired
	private OrganizationService orgService;

	@PostMapping("/addOrganizationInfo")
	public Organization addOrganizationInfo(@Valid @RequestParam("file") MultipartFile file,
			@RequestPart Organization organization) throws IOException {
		Organization orgInfo = orgService.save(file, organization);

		return new Organization(orgInfo.getOrganisationId(), orgInfo.getOrganisationName(),
				orgInfo.getOrganisationWebsite(), orgInfo.getOrganisationAddress1(), orgInfo.getOrganisationAddress2(),
				orgInfo.getOrganisationPhoneNumber(), orgInfo.getOrganisationGSTNumber(),
				orgInfo.getOrganisationCINNumber(), file.getBytes());
	}
}
