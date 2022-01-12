package com.hutech.payrollapp.api.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.exceptionhandler.ApiException;
import com.hutech.payrollapp.api.model.Document;
import com.hutech.payrollapp.api.service.DocumentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping("/addDocumentInfo")
	public String addDocumentInfo(@RequestBody Document document) {
		documentService.save(document);
		return "Document Informations Added...";

	}

	@PostMapping("/uploadDocument/{id}")
	public String addDocument(@RequestParam("document") MultipartFile document, @PathVariable Long id)
			throws ApiException, IOException {
		 if(document.getContentType().equals("application/pdf")){
				documentService.addFile(document, id);
				return "Document Uploaded Successfully !!!";
		 }
		 return "Uploaded File Format is not Supported. Please Upload PDF format for Document Upload !!!";
	}

	@GetMapping("/getDocumentDetails/{id}")
	public Optional<Document> getDocumentInfo(@PathVariable Long id) {
		return documentService.findById(id);
	}

	@GetMapping("/getDocument/{id}")
	public void showImage(@PathVariable("id") Long id, HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		Optional<Document> item = documentService.findById(id);
		response.setContentType("application/pdf");
		response.getOutputStream().write(item.get().getDocument());
		response.getOutputStream().close();
	}
}
