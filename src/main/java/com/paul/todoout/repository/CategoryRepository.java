package com.paul.todoout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paul.todoout.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
