package com.revature.alchemyapp.controllers;

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
import com.revature.alchemyapp.models.User;
import com.revature.alchemyapp.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private UserService userServ;
	
	public UserController(UserService userServ) {
		this.userServ = userServ;
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
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
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
