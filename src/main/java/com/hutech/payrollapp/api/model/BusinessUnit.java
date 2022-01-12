package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class BusinessUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int businessUnitId;
	
	@NotEmpty
	@Size(min=5,max=25,message="BUSINESS UNIT NAME MUST BE BETWEEN 5 TO 25 CHARACTERS")
	private String businessUnitName;
	private String phoneNumber;
	
	@NotEmpty
	@Size(min=5,max=50,message="ADDRESS LINE MUST BE BETWEEN 50 TO 50 CHARACTERS")
	private String addressLine1;
	private String addressLine2;
	private String description;

	public int getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(int businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BusinessUnit() {

	}

	public BusinessUnit(int businessUnitId, String businessUnitName, String phoneNumber, String addressLine1,
			String addressLine2, String description) {
		super();
		this.businessUnitId = businessUnitId;
		this.businessUnitName = businessUnitName;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.description = description;
	}

}
