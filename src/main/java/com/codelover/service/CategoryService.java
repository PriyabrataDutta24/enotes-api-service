package com.codelover.service;

import java.util.List;

import com.codelover.entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> GetAllCategory();
	
}
