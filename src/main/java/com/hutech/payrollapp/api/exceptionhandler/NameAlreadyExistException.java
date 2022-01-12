package com.hutech.payrollapp.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class NameAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final int status;
	
	public NameAlreadyExistException(String message,int status) {
		super(message);
		this.status=status;
	}
	
	public int getStatus() {
		return status;
	}

}
