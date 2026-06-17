package com.paul.todoout.exception;

public class InvalidDataException extends RuntimeException {
	
	private String code;
	
	public InvalidDataException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
