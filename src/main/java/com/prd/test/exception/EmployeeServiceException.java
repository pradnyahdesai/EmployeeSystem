package com.prd.test;

import org.springframework.http.HttpStatus;

public class EmployeeServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4569658166296844866L;
	
	private HttpStatus errorCode= HttpStatus.BAD_REQUEST;
	

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public EmployeeServiceException(String message, HttpStatus errorCode){
		super(message);
		this.errorCode = errorCode;
	}
	
	public EmployeeServiceException(String message){
		super(message);
	}

}
