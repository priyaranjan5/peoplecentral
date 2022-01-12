package com.hutech.payrollapp.api.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public ExceptionResponse emialExResponse(EmailAlreadyExistException emailException, WebRequest request) {
		ExceptionResponse exception = new ExceptionResponse(new Date(), emailException.getMessage(),
				request.getDescription(false), emailException.getStatus());
		return exception;
	}

	@ExceptionHandler(IdAlreadyExistException.class)
	public ExceptionResponse idExResponse(IdAlreadyExistException idException, WebRequest request) {
		ExceptionResponse exception = new ExceptionResponse(new Date(), idException.getMessage(),
				request.getDescription(false), idException.getStatus());
		return exception;
	}

	@ExceptionHandler(NameAlreadyExistException.class)
	public ExceptionResponse nameExResponse(NameAlreadyExistException nameException, WebRequest request) {
		ExceptionResponse exception = new ExceptionResponse(new Date(), nameException.getMessage(),
				request.getDescription(false), nameException.getStatus());
		return exception;
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> apiException(ApiException apiex, WebRequest request) {
		ApiResponse exception = new ApiResponse(new Date(), request.getDescription(false), apiex.getMessage(),
				apiex.getStatus());
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
}
