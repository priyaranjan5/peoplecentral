package com.hutech.payrollapp.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginResponse {
	
	private final String jwt;

    @NotEmpty
	@Email
	private String username;
	
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 character")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }    
    public LoginResponse(String jwt, @NotEmpty @Email String username,
			@NotEmpty @Size(min = 8, message = "password should have at least 8 character") String password) {
		super();
		this.jwt = jwt;
		this.username = username;
		this.password = password;
	}

	public String getJwt() {
        return jwt;
    }
}
