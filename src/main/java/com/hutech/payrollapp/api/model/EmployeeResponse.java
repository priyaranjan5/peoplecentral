package com.hutech.payrollapp.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeResponse {
	private final String token;

    @NotEmpty
	@Email
	private String username;
	
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 character")
    private String password;

	
	  
	
	
   
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	



	public String getToken() {
		return token;
	}



	public EmployeeResponse(String token, @NotEmpty @Email String username,
			@NotEmpty @Size(min = 8, message = "password should have at least 8 character") String password
		) {
		super();
		this.token = token;
		this.username = username;
		this.password = password;
		
	}
	
}
