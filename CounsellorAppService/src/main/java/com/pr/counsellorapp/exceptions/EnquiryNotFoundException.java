package com.pr.counsellorapp.exceptions;

public class EnquiryNotFoundException extends RuntimeException {
private String message;
	
	public EnquiryNotFoundException() {
	}
	
	public EnquiryNotFoundException(String msg) {
		message=msg;
	}
	@Override
	public String getMessage() {
		
		return message;
	}

}
