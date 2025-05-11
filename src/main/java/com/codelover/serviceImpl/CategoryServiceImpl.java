package com.codelover.serviceImpl;

import java.util.Date;
import java.util.List;


import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import com.codelover.dto.CategoryDto;
import com.codelover.dto.CategoryReponse;

import com.codelover.entity.Category;
import com.codelover.repository.CategoryRepository;
import com.codelover.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean saveCategory(CategoryDto categoryDto) {
		
//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
		
		Category category = mapper.map(categoryDto, Category.class);

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
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		
		List<CategoryDto> categoryDtoList = categories.stream()
		.map(cat ->mapper.map(cat, CategoryDto.class)).toList();
		return categoryDtoList;
	}

	@Override
	public List<CategoryReponse> getActiveCategory() {
		List<Category> categories = categoryRepo.findByIsActiveTrue();
		List<CategoryReponse> categorylist = categories.stream().map(cat->mapper.map(cat, CategoryReponse.class)).toList();
		return categorylist;
	}

}
