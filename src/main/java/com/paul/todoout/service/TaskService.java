package com.paul.todoout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paul.todoout.entity.Task;
import com.paul.todoout.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task createTask(Task task) {
		
		
		
		return taskRepository.save(task);
	}
	
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	public Task updateTask(Long id, Task updateTask) {
		
		Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task no encontrada"));
		
		if (updateTask.getTitle() != null) {
			
			task.setTitle(updateTask.getTitle());
			
		}
		
		return taskRepository.save(task);
		
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

}
