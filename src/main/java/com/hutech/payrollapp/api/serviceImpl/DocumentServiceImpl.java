package com.hutech.payrollapp.api.serviceImpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hutech.payrollapp.api.exceptionhandler.ApiException;
import com.hutech.payrollapp.api.model.Document;
import com.hutech.payrollapp.api.repository.DocumentRepository;
import com.hutech.payrollapp.api.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepo;

	@Override
	public String save(Document document) {
		documentRepo.save(document);
		return "Document Added...";
	}

	@Override
	public Optional<Document> findById(Long id) {
		return documentRepo.findById(id);
	}

	@Override
	public String addFile(MultipartFile document, Long id) throws ApiException, IOException {
		Document doc = documentRepo.findById(id)
				.orElseThrow(() -> new ApiException(404, "DOCUMENT INFORMATION NOT FOUND FOR THE ID : " + id));
		doc.setDocument(document.getBytes());
		documentRepo.save(doc);
		return "Document Saved";
	}
}
