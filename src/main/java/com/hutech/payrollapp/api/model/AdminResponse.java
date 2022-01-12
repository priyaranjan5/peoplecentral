package com.hutech.payrollapp.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AdminResponse {

	private final String token;

/*	@NotEmpty
	@Email
	private String username;*/
	private String empEmail;
	private Boolean isAdmin;
	private Boolean isManager;
	private Boolean isEmployee;
	
	

	public Boolean getIsEmployee() {
		return false;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

/*	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}*/

	public Boolean getIsAdmin() {
		return true;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = true;
	}

	public Boolean getIsManager() {
		return false;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = true;
	}

	public String getToken() {
		return token;
	}
	

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public AdminResponse(String token, @NotEmpty @Email String empEmail, Boolean isAdmin, Boolean isManager,Boolean isEmployee) {
		super();
		this.token = token;
		this.empEmail = empEmail;
		// this.password = password;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
		this.isEmployee=isEmployee;
	}
	

}
