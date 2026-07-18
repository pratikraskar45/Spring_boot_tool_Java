package com.pr.exceptions;

public class AppointmentNotFoundException extends RuntimeException {
private String message;
	
	public AppointmentNotFoundException() {
	}
	
	public AppointmentNotFoundException(String msg) {
		message=msg;
	}
	@Override
	public String getMessage() {
		
		return message;
	}

}
