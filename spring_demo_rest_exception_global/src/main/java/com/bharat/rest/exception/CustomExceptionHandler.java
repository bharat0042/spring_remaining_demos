package com.bharat.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound exe) {
		StudentErrorResponse response = new StudentErrorResponse();
		response.setMessage(exe.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe) {
		StudentErrorResponse response = new StudentErrorResponse();
		response.setMessage(exe.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
