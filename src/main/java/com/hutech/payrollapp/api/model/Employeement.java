package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Employeement {
	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeementId;
	
	@Id
	@NotEmpty
	private String employeementName;

	public int getEmployeementId() {
		return employeementId;
	}

	public void setEmployeementId(int employeementId) {
		this.employeementId = employeementId;
	}

	public String getEmployeementName() {
		return employeementName;
	}

	public void setEmployeementName(String employeementName) {
		this.employeementName = employeementName;
	}

	public Employeement(int employeementId, String employeementName) {
		super();
		this.employeementId = employeementId;
		this.employeementName = employeementName;
	}

	public Employeement() {
		super();
	}

}
