package com.codelover.service;

import java.util.List;

import com.codelover.entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	
<<<<<<< Updated upstream
	public List<Category> GetAllCategory();
=======
	public List<CategoryDto> getAllCategory();

	public List<CategoryReponse> getActiveCategory();

	public CategoryDto getCategoryById(Integer id);

	public Boolean deleteCategory(Integer id);
	
	 
>>>>>>> Stashed changes
	
}
