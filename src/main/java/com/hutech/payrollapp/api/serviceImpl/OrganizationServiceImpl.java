package com.hutech.payrollapp.api.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.model.Organization;
import com.hutech.payrollapp.api.repository.OrganizationRepository;
import com.hutech.payrollapp.api.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository orgRepo;

	@Override
	public Organization save(MultipartFile file, Organization organization) throws IOException {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Organization organizationInfo = new Organization(organization.getOrganisationId(),
				organization.getOrganisationName(), organization.getOrganisationWebsite(),
				organization.getOrganisationAddress1(), organization.getOrganisationAddress2(),
				organization.getOrganisationPhoneNumber(), organization.getOrganisationGSTNumber(),
				organization.getOrganisationCINNumber(), file.getBytes());
		return orgRepo.save(organizationInfo);
	}

}
