package com.hutech.payrollapp.api.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.model.Organization;

public interface OrganizationService {

	Organization save(MultipartFile file, Organization organization) throws IOException;

}
