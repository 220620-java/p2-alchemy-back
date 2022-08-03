package com.revature.alchemyapp.controllers;
import java.util.ArrayList;
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
import com.revature.alchemyapp.services.UserService;
import com.revature.alchemyapp.services.UserServiceImpl;
import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.data.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	//private static final List<Shelf> Shelf = null;
	@Autowired private UserService userServ;
	@Autowired private UserRepository userRepository;
	@Autowired private CategoryRepository categoryRepo;

	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userServ.getUser(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody UserRequest userRequest) {
		try {
			User user = new User();
			user.setFirstName(userRequest.getFirstName());
			user.setLastName(userRequest.getLastName());
			user.setPassword(userRequest.getPassword());
			user.setShelves(new ArrayList());
			user.setUsername(userRequest.getUsername());
			user = userServ.registerUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (UsernameAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	
	
	@GetMapping(path = "/username/{username}/categories")
	public ResponseEntity<List<Category>> viewShelfCatagories(@PathVariable("username")String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
		    List<Category> selves =categoryRepo.findAll();
		    if (selves != null) {
		    	return ResponseEntity.ok(selves);
		    }
	    }
		return ResponseEntity.notFound().build();	
	}
	

	@GetMapping(path = "/username/{username}/shelves")
	public ResponseEntity<List<Shelf>> viewUserShelves(@PathVariable("username")String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
		    List<Shelf> selves = user.getShelves();
		    if (selves != null) {
		    	return ResponseEntity.ok(selves);
		    }
	    }
		return ResponseEntity.notFound().build();	
	}
	
	
	@PutMapping(path = "/{update}")
	public ResponseEntity<User> updateUser(@PathVariable("update") Long id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (!userOpt.isEmpty()) {
			User user = userOpt.get();
			user = userServ.updateUser(user);
			if (user != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	//	public User addBook(Shelf shelf, User user);
	//takes in a book isbn and a category. 
	
	//this.id = id;
	//this.bookISBN = bookISBN;
	//this.category = category;


	}

