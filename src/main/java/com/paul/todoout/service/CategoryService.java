package com.paul.todoout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paul.todoout.entity.Category;
import com.paul.todoout.exception.InvalidDataException;
import com.paul.todoout.exception.TaskNotFoundException;
import com.paul.todoout.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public void createCategory(Category category) {
		// validate
		if (category.getName() == null || category.getName().isBlank()) {
			throw new InvalidDataException("P012", "Name cannot be empty or null");
		}
		
		categoryRepository.save(category);
		
	}
	
	public void deleteCategory(Long id) {
		
		Category category = categoryRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("P030", "Task not found with id " + id)); 
		
		categoryRepository.deleteById(id);
		
	}
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

}
