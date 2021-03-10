package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	// add an exception handler for customer not found exception
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		// customer error reponse
		
		CustomerErrorResponse error = new CustomerErrorResponse(
										HttpStatus.NOT_FOUND.value(),
										exc.getMessage(),
										System.currentTimeMillis()
										);
		//return reponseentity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler .. to catch any exception 
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		CustomerErrorResponse error = new CustomerErrorResponse(
										HttpStatus.BAD_REQUEST.value(),
										exc.getMessage(),
										System.currentTimeMillis()
											);
		
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
