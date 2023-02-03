package com.restapi.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FlightExceptionController extends Exception {
	
	
	@ExceptionHandler(value = FlightNotAvailable.class)
	public ResponseEntity<Object> flightNotAvalible(FlightNotAvailable msg)
	{		
		ErrorMsgDetails err= new ErrorMsgDetails();
		err.setErrorTime(LocalDateTime.now());
		err.setMessage(msg.getMessage());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {FlightException.class,Exception.class})
	public ResponseEntity<Object> flightCreateException(RuntimeException  e,WebRequest request)
	{		
		ErrorMsgDetails err= new ErrorMsgDetails();
		err.setErrorTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

}
