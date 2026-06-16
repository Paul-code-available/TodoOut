package com.paul.todoout.exception;

public class TaskNotFoundException extends RuntimeException {
	
	private String code;
	
	public TaskNotFoundException(String code, Long id) {
		super("Task not found with id " + id);
		this.code = code;
	}

}
