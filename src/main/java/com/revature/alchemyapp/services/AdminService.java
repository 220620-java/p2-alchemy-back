package com.revature.alchemyapp.services;

import java.util.List;

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;

public interface AdminService {
	public List<Shelf> viewAllShelves();
	public Category editCategory(Category category);
}
