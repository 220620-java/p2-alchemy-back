package com.revature.alchemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.data.ShelfRepository;
import com.revature.alchemyapp.data.UserRepository;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.Admin;
import com.revature.alchemyapp.models.User;


@Service
public class AdminServiceImpl implements AdminService {
	private UserRepository adminRepo;
	private ShelfRepository shelfRepo;
	private CategoryRepository categoryRepo;

	@Override
	public List<Shelf> viewAllShelves() {
		return shelfRepo.findAll();
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	@Override
	public Category updateCategory(Category category) {
		if (categoryRepo.findById(category.getId()).isPresent()) {
			categoryRepo.save(category);
			
			Optional<Category> categoryOpt = categoryRepo.findById(category.getId());
			if (categoryOpt.isPresent()) {
				return categoryOpt.get();
			}
		}
		return null;
	}

}
