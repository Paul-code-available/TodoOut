package com.paul.todoout.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paul.todoout.entity.Task;
import com.paul.todoout.exception.InvalidDataException;
import com.paul.todoout.exception.TaskNotFoundException;
import com.paul.todoout.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public void createTask(Task task) {
		
		if (task.getTitle() == null || task.getTitle().isBlank()) {
			 throw new InvalidDataException("P012", "Title cannot be empty or null");
		}
		
		if (task.getDescription().length() > 500) {
			throw new InvalidDataException("P013", "Description cannot exceed 500 characters");
		}
		
		if (task.getStatus() == null) {
			 throw new InvalidDataException("P014", "Status cannot be null");
		}
		
		if (task.getPriority() == null) {
			 throw new InvalidDataException("P015", "Priority cannot be null");
		}
		
		if (task.getDueDate() == null) {
			throw new InvalidDataException("P016", "Due date is required");
		}

		if (task.getDueDate().isBefore(LocalDate.now())) {
			throw new InvalidDataException("P017", "Due date cannot be in the past");
		}

		taskRepository.save(task);
		
	}
	
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	public Task updateTask(Long id, Task updateTask) {
		
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("530", "Task not found with id " + id));
		
		if (task.getTitle() == null || task.getTitle().isBlank()) {
			 throw new InvalidDataException("P012", "Title cannot be empty or null");
		}
		
		if (task.getDescription().length() > 500) {
			throw new InvalidDataException("P013", "Description cannot exceed 500 characters");
		}
		
		if (task.getStatus() == null) {
			 throw new InvalidDataException("P014", "Status cannot be null");
		}
		
		if (task.getPriority() == null) {
			 throw new InvalidDataException("P015", "Priority cannot be null");
		}
		
		if (task.getDueDate() == null) {
			throw new InvalidDataException("P016", "Due date is required");
		}

		if (task.getDueDate().isBefore(LocalDate.now())) {
			throw new InvalidDataException("P017", "Due date cannot be in the past");
		}
		
		
		return taskRepository.save(task);
		
	}
	
	public void deleteTask(Long id) {
		
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("P030", "Task not found with id " + id));

		taskRepository.deleteById(id);
	}

}
