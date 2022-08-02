package com.revature.alchemyapp.controllers;
import java.util.List;
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
import com.revature.alchemyapp.services.UserService;
import com.revature.alchemyapp.services.UserServiceImpl;
import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.data.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private static final List<Shelf> Shelf = null;
	private UserService userServ;
	private UserServiceImpl userImpl;
	private UserRepository userRepo;
	private CategoryRepository categoryRepo;
	
	public UserController(UserService userServ, UserRepository userRepo, CategoryRepository categoryRepo) {
		this.userServ = userServ;
		this.userRepo = userRepo;
		this.categoryRepo = categoryRepo;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId) {
		User user = userServ.getUser(userId);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		try {
			user = userServ.registerUser(user);
		} catch (UsernameAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	

	@GetMapping(path = "/{username}/shelves")
	public ResponseEntity<List<Shelf>> viewUserShelves(@PathVariable("username")String username) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
		    List<Shelf> selves = user.getShelves();
		    if (selves != null) {
		    	return ResponseEntity.ok(selves);
		    }
	    }
		return ResponseEntity.notFound().build();	
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("") Integer id) {
		if (user.getId() == id) {
			user = userServ.updateUser(user);
			if (user != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	} 
}
