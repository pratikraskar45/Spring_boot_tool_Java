package com.pr.exceptions;

public class DoctorNotFoundException extends RuntimeException {
	private String message;
	
	public DoctorNotFoundException() {
	}
	
	public DoctorNotFoundException(String msg) {
		message=msg;
	}
	@Override
	public String getMessage() {
		
		return message;
	}

}
