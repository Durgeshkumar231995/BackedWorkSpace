package com.example.demo.exception;


import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(FlightNotPrestBySpecificId.class)
	public ResponseEntity<ErrorMessage>  handlerForNoFlighById(FlightNotPrestBySpecificId ex,WebRequest req)
	{
		ErrorMessage em=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorMessage>(em,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FlightAlreadyExist.class)
	public ResponseEntity<ErrorMessage>  handlerForFlighAlreadyExist(FlightAlreadyExist ex,WebRequest req)
	{
		ErrorMessage em=new ErrorMessage(HttpStatus.CONFLICT,ex.getMessage());
		return new ResponseEntity<ErrorMessage>(em,HttpStatus.NOT_FOUND);
	}
//@ExceptionHandler(MethodArgumentNotValidException.class)
//	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
//	           HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//
//	    List<String> details = new ArrayList<>();
//	    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//	      details.add(error.getDefaultMessage());
//	    }
//	    //ErrorResponse error = new ErrorResponse("Validation Failed", details);
//	    return new ResponseEntity(details, HttpStatus.BAD_REQUEST);
//	  }
    }
