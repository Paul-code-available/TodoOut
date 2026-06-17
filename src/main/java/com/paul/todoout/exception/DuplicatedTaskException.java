package com.paul.todoout.exception;

public class DuplicatedTaskException extends RuntimeException {

	private String code;
	
	public DuplicatedTaskException(String code, String message) {
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
