package com.hutech.payrollapp.api.exceptionhandler;

import java.util.Date;

public class ApiResponse {

	private Date timeStamp;
	private String message;
	private String details;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponse(Date timeStamp, String details, String message, int status) {
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.message = message;
		this.status = status;
	}

}
