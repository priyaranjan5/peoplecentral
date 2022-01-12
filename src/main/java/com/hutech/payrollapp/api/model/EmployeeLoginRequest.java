package com.hutech.payrollapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin", uniqueConstraints = @UniqueConstraint(columnNames = "empEmail"))
public class EmployeeLoginRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empEmail")
	@NotEmpty
	@Email
	private String empEmail;

	@Column(name = "password")
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 character")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmployeeLoginRequest(@NotEmpty @Email String empEmail,
			@NotEmpty @Size(min = 8, message = "password should have at least 8 character") String password) {
		super();
		this.empEmail = empEmail;
		this.password = password;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public EmployeeLoginRequest() {

	}

}
