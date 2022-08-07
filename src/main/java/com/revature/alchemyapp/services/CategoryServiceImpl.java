package com.revature.alchemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.models.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepo;
	
	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		this.categoryRepo=categoryRepo;
	}

	@Override
	public Category createCategory(Category category) {
		category = categoryRepo.save(category);
		return category;
	}

	@Override
	public Category getCategory(Long id) {
		Optional<Category> categoryOpt = categoryRepo.findById(id);
		if (categoryOpt.isPresent()) {
			return categoryOpt.get();
		} else {
			return null;
		}
	}

	@Override
	public Category getCategoryByName(String name) {
		Category category = categoryRepo.findByCategoryName(name);
		if (category != null) {
			return category;
		} else {
			return null;
		}
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();
		return categories;
	}

}
