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
public class Designation {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int designationId;
	
	@Id
	@NotEmpty
	@Size(min=5,max=25,message="DESIGNATION NAME MUST BE BETWEEN 5 TO 25 CHARACTERS")
	private String designationName;
	
	@Size(min=1,max=100)
	private String description;
	
	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Designation() {

	}

	public Designation(int designationId, String designationName,String description) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.description = description;
	}

}
