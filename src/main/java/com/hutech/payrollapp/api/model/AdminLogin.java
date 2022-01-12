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
@Table(name = "admin_info", uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class AdminLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "userName")
	@Email
	private String empEmail;

	@Column(name = "password")
	private String password;
	
	private String resetPassword;

	private Boolean isAdmin;
	private Boolean isManager;
	private String adminToken;
	
	public String getAdminToken() {
		return adminToken;
	}

	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

/*	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/
	
	

	public String getPassword() {
		return password;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminLogin(@NotEmpty @Email String empEmail, Boolean isAdmin, Boolean isManager,
			@NotEmpty @Size(min = 8, message = "password should have at least 8 character") String password) {
		super();
		this.empEmail = empEmail;
		this.isAdmin = isAdmin;
		this.isManager = isManager;
		this.password = password;
	}

	public AdminLogin() {

	}

}
