package com.codelover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelover.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
