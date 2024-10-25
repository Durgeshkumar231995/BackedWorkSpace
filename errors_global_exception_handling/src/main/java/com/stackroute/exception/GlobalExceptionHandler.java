package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BlogNotFoundException.class)
	public ResponseMessage handleCustomerAlreadyExistsException(BlogNotFoundException ex) {
	    return new ResponseMessage(HttpStatus.CONFLICT.value(), ex.getMessage());
	}

}
