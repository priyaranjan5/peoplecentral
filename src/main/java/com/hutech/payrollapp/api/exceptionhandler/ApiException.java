package com.hutech.payrollapp.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final int status;

	public ApiException(int status,String message) {
		super(message);
		this.status=status;
	}
	public int getStatus() {
		return this.status;
	}
}