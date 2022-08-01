package com.revature.alchemyapp.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;
import com.revature.alchemyapp.models.Admin;
import com.revature.alchemyapp.services.AdminService;
import com.revature.alchemyapp.services.AdminServiceImpl;
import com.revature.alchemyapp.data.AdminRepository;
import com.revature.alchemyapp.data.CategoryRepository;


@RestController
@RequestMapping(path = "/Admins")
public class AdminController {
	
	private static final List<Shelf> Shelf = null;
	private AdminService adminServ;
	private AdminServiceImpl adminImpl;
	private AdminRepository adminRepository;
	//@Autowired
	private CategoryRepository categoryRepo;
	
	public AdminController(AdminService adminServ, AdminRepository adminRepository,CategoryRepository categoryRepo) {
		this.adminServ = adminServ;
		this.adminRepository = adminRepository;
		this.categoryRepo = categoryRepo;
	}
	
	
	//@GetMapping(path = "/{username}")
	/*public ResponseEntity<List<Category>> viewAllShelves(@PathVariable("username")String username) {
		Admin admin = adminRepository.findByUsername(username);
		if (admin != null) {
		    List<Category> selves = adminServ.getAllCategories();
		    if (selves != null) {
		    	return ResponseEntity.ok(selves);
		    }
	    }
		return ResponseEntity.notFound().build();	
	}
	*/
	
	
	public ResponseEntity<Category> updateCategory(Category category) {
		
		if(category!=null) {
			adminServ.updateCategory(category);
		}
		
		//if(categoryRepo.findByCategoryName(category.getCategoryName())==category) {
			//return ResponseEntity.ok(category);
		//}
		return null;
		
		
	}
	
	


	
	
	
}
