package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "login")
public class Login {

		@Id
		private Long id;
		
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

		public Login(@NotEmpty @Email String username,
				@NotEmpty @Size(min = 8, message = "password should have at least 8 character") String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public Login() {
			
		}

	  
}
