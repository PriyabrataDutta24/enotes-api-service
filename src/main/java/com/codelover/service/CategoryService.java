package com.codelover.service;

import java.util.List;
import com.codelover.dto.CategoryDto;
import com.codelover.dto.CategoryReponse;
import com.codelover.entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategory();

	public List<CategoryReponse> getActiveCategory();

	
}
