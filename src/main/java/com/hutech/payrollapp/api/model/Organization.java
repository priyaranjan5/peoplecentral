package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int organisationId;
	
	@NotEmpty
	@Size(min=3,max=25,message="ORGANIZATION NAME MUST BE BETWEEN 3 TO 25 CHARACTERS")
	private String organisationName;
	private String organisationWebsite;
	@NotEmpty
	@Size(min=5,max=50,message="ADDRESS MUST BE 5 TO 50 CHARACTERS")
	private String organisationAddress1;
	private String organisationAddress2;
	private String organisationPhoneNumber;
	private String organisationGSTNumber;
	private String organisationCINNumber;
//	private String fileName;

	@Lob
	private byte[] organisation_logo;

	public int getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationWebsite() {
		return organisationWebsite;
	}

	public void setOrganisationWebsite(String organisationWebsite) {
		this.organisationWebsite = organisationWebsite;
	}

	public String getOrganisationAddress1() {
		return organisationAddress1;
	}

	public void setOrganisationAddress1(String organisationAddress1) {
		this.organisationAddress1 = organisationAddress1;
	}

	public String getOrganisationAddress2() {
		return organisationAddress2;
	}

	public void setOrganisationAddress2(String organisationAddress2) {
		this.organisationAddress2 = organisationAddress2;
	}

	public String getOrganisationPhoneNumber() {
		return organisationPhoneNumber;
	}

	public void setOrganisationPhoneNumber(String organisationPhoneNumber) {
		this.organisationPhoneNumber = organisationPhoneNumber;
	}

	public String getOrganisationGSTNumber() {
		return organisationGSTNumber;
	}

	public void setOrganisationGSTNumber(String organisationGSTNumber) {
		this.organisationGSTNumber = organisationGSTNumber;
	}

	public String getOrganisationCINNumber() {
		return organisationCINNumber;
	}

	public void setOrganisationCINNumber(String organisationCINNumber) {
		this.organisationCINNumber = organisationCINNumber;
	}

	public byte[] getOrganisation_logo() {
		return organisation_logo;
	}

	public void setOrganisation_logo(byte[] organisation_logo) {
		this.organisation_logo = organisation_logo;
	}

	public Organization() {
		super();
	}

	public Organization(int organisationId, String organisationName, String organisationWebsite,
			String organisationAddress1, String organisationAddress2, String organisationPhoneNumber,
			String organisationGSTNumber, String organisationCINNumber, byte[] organisation_logo) {
		super();
		this.organisationId = organisationId;
		this.organisationName = organisationName;
		this.organisationWebsite = organisationWebsite;
		this.organisationAddress1 = organisationAddress1;
		this.organisationAddress2 = organisationAddress2;
		this.organisationPhoneNumber = organisationPhoneNumber;
		this.organisationGSTNumber = organisationGSTNumber;
		this.organisationCINNumber = organisationCINNumber;
		this.organisation_logo = organisation_logo;
	}
	
}
