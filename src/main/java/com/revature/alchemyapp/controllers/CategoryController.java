package com.revature.alchemyapp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.services.ShelfService;
import com.revature.alchemyapp.services.UserService;

@RestController // Automatically puts @ResponseBody over all of our methods
@RequestMapping(path = "/category")
public class CategoryController {
	private ShelfService shelfServ;
	private UserService userServ;
	private CategoryRepository categoryRepo;
	
	public CategoryController(ShelfService shelfServ, UserService userServ, CategoryRepository categoryRepo) {
		this.shelfServ=shelfServ;
		this.userServ=userServ;
		this.categoryRepo=categoryRepo;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> category = categoryRepo.findAll();
		if (category != null) {
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
