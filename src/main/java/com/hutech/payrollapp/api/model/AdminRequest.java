package com.hutech.payrollapp.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminRequest {

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String empEmail;
	private Boolean isAdmin;
	private Boolean isManager;
	private Boolean isEmployee;
	private String token;

	public Boolean getIsEmployee() {
		return true;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public String getToken() {
		return token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return false;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = true;
	}

	public Boolean getIsManager() {
		return false;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = false;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public AdminRequest(String token, String empEmail, String password, Boolean isAdmin, Boolean isManager,
			Boolean isEmployee) {
		this.token = token;
		this.empEmail = empEmail;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
		this.isEmployee = isEmployee;
	}

	public AdminRequest() {
		super();
	}
}
