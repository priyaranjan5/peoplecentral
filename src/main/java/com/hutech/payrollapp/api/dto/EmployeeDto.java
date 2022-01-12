package com.hutech.payrollapp.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;
@Component
public class EmployeeDto {
	@NotEmpty
	@Email
	private String managerEmail;

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public EmployeeDto(String managerEmail) {
		super();
		this.managerEmail = managerEmail;
	}

	public EmployeeDto() {

	}
}
