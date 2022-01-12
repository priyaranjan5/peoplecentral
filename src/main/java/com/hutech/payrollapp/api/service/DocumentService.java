package com.hutech.payrollapp.api.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.exceptionhandler.ApiException;
import com.hutech.payrollapp.api.model.Document;

public interface DocumentService {

	String addFile(MultipartFile document, Long id) throws ApiException, IOException;

	String save(Document document);

	Optional<Document> findById(Long id);

}
