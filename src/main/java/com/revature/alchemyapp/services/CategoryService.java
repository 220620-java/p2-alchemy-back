package com.revature.alchemyapp.services;

import java.util.List;

import com.revature.alchemyapp.models.Category;

public interface CategoryService {
	public Category createCategory(Category category);
	public Category getCategory(Long id);
	public Category getCategoryByName(String name);
	public List<Category> getAllCategories();
}
