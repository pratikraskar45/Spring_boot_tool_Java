package com.pr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<String> catchCounsellorNotFoundException(DoctorNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> name(AppointmentNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
