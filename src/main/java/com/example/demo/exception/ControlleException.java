package com.example.demo.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ControlleException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNosuchElementException(NoSuchElementException exce){
		return new ResponseEntity<String>("There is No object present inDB, please change the input", HttpStatus.NOT_FOUND);
		
	}
	
	
	

	
}
