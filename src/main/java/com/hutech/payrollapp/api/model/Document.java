package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee_documents")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String documentId;
	private String idType;
	private String uploadedBy;
	private String proofFor;
	private String verification;

	@Lob
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] document;

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getProofFor() {
		return proofFor;
	}

	public void setProofFor(String proofFor) {
		this.proofFor = proofFor;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public Document(String documentId, String idType, String uploadedBy, String proofFor, byte[] document) {
		super();
		this.documentId = documentId;
		this.idType = idType;
		this.uploadedBy = uploadedBy;
		this.proofFor = proofFor;
		this.document = document;
	}

	public Document() {
		super();
	}

}
