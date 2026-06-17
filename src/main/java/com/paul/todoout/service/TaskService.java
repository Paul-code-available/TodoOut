package com.paul.todoout.service;

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
		
		if (task.getTitle() == null) {
			 throw new InvalidDataException("P012", "Title cannot be null");
		}
		
		if (task.getTitle().isBlank()) {
		    throw new InvalidDataException("P013", "Title cannot be empty");
		}
		
		 taskRepository.save(task);
		
	}
	
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	public Task updateTask(Long id, Task updateTask) {
		
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("530", "Task not found with id " + id));
		
		if (task.getTitle().isBlank()) {
		    throw new InvalidDataException("510", "Title cannot be empty");
		}
		
		
		return taskRepository.save(task);
		
	}
	
	public void deleteTask(Long id) {
		
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("530", "Task not found with id " + id));

		taskRepository.deleteById(id);
	}

}
