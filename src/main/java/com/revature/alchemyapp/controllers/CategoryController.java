package com.revature.alchemyapp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.services.CategoryService;

@RestController // Automatically puts @ResponseBody over all of our methods
@RequestMapping(path = "/category")
public class CategoryController {
	private CategoryService categoryServ;
	
	public CategoryController(CategoryService categoryServ) {
		this.categoryServ=categoryServ;
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> category = categoryServ.getAllCategories();
		if (category != null) {
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
