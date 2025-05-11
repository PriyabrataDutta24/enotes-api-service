package com.codelover.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.codelover.entity.Category;
import com.codelover.repository.CategoryRepository;
import com.codelover.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Boolean saveCategory(Category category) {
		category.setCreatedOn(new Date());
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		Category saveCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
<<<<<<< Updated upstream
	public List<Category> GetAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		
		return categories;
=======
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findByIsDeletedFalse();
		
		List<CategoryDto> categoryDtoList = categories.stream()
		.map(cat ->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtoList;
	}

	@Override
	public List<CategoryReponse> getActiveCategory() {
		List<Category> categories = categoryRepo.findByIsActiveTrueAndIsDeletedFalse();
		List<CategoryReponse> categorylist = categories.stream().map(cat->mapper.map(cat, CategoryReponse.class)).toList();
		return categorylist;
>>>>>>> Stashed changes
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Optional<Category> findByCategory = categoryRepo.findByIdAndIsDeletedFalse(id);
		if(findByCategory.isPresent())
		{
			Category category = findByCategory.get();
			return mapper.map(category, CategoryDto.class);
		}
		
		return null;
	}

	@Override
	public Boolean deleteCategory(Integer id) {
		Optional<Category> findByCategory = categoryRepo.findById(id);
		if(findByCategory.isPresent())
		{
			Category category = findByCategory.get();
			category.setIsDeleted(true);
			categoryRepo.save(category);
			return true;
		}
		return false;
	}

}
