package com.paul.todoout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paul.todoout.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
}
