package com.paul.todoout.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paul.todoout.dto.ErrorDTO;
import com.paul.todoout.exception.InvalidDataException;

@RestControllerAdvice
public class AdviceController {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorDTO> handleInvalidDataException(InvalidDataException ex) {
		
		ErrorDTO error = new ErrorDTO(ex.getCode(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
}
