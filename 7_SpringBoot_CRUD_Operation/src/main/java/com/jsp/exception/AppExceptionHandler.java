package com.jsp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	 public ResponseEntity<String> catchStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
		 return new ResponseEntity<>(studentNotFoundException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
