package com.codelover.serviceImpl;

import java.util.Date;
import java.util.List;

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
	public List<Category> GetAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		
		return categories;
	}

}
