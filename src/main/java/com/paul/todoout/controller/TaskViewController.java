package com.paul.todoout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paul.todoout.entity.Task;
import com.paul.todoout.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskViewController {
	
	private final TaskService taskService;
	
	public TaskViewController(TaskService taskService) {
		this.taskService = taskService;	
	}
	
	@GetMapping
	public String showTasks(Model model) {
		model.addAttribute("tasks", taskService.getTasks());
		return "tasks";
	}
	
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("task", new Task());
		
		return "task-form";
		
	}

}
