package com.revature.alchemyapp.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.data.UserRepository;
import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;
import com.revature.alchemyapp.models.dto.UserRequest;
import com.revature.alchemyapp.services.ShelfService;
import com.revature.alchemyapp.services.UserService;
import com.revature.alchemyapp.services.UserServiceImpl;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private static final List<Shelf> Shelf = null;
	private UserService userServ;
	private UserServiceImpl userImpl;
	private UserRepository userRepo;
	private CategoryRepository categoryRepo;
	private ShelfService shelfServ;
	
	public UserController(UserService userServ, UserRepository userRepo, CategoryRepository categoryRepo, ShelfService shelfServ) {
		this.userServ = userServ;
		this.userRepo = userRepo;
		this.categoryRepo = categoryRepo;
		this.shelfServ = shelfServ;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userServ.getUser(userId);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(path="/login")
	public ResponseEntity<User> login(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
		User user = userServ.logIn(username, password);
		if(user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
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
	
	@PutMapping(path = "/{userId}/addbook/{shelfId}")
	public ResponseEntity<User> addShelf(@PathVariable("userId") Long userId, @PathVariable("shelfId") Long shelfId) {
		User user = userServ.getUser(userId);
		Shelf shelf = shelfServ.getShelf(shelfId);
		if (shelf != null && user != null) {
			user = userServ.addBook(shelf, user);
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("") Long id) {
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
