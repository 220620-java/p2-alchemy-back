package com.revature.alchemyapp.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.revature.alchemyapp.models.dto.UserDTO;
import com.revature.alchemyapp.services.ShelfService;
import com.revature.alchemyapp.services.UserService;
import com.revature.alchemyapp.services.UserServiceImpl;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private static final List<Shelf> Shelf = null;
	private UserService userServ;
	private ShelfService shelfServ;
	
	public UserController(UserService userServ, ShelfService shelfServ) {
		this.userServ = userServ;
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
	
	@PostMapping(path="/login")
	public ResponseEntity<UserDTO> login(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
		User user = userServ.logIn(username, password);
		if(user != null) {
			UserDTO userDto = new UserDTO(user);
			return ResponseEntity.status(200).body(userDto);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@PostMapping
    public ResponseEntity<User> registerUser(@RequestBody Map<String, String> credentials) {
        try {
            User user = new User();
            user.setUsername(credentials.get("username"));
            user.setPassword(credentials.get("password"));
            user.setFirstName(credentials.get("firstname"));
            user.setLastName(credentials.get("lastname"));
            user.setShelves(new ArrayList());
            user = userServ.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UsernameAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


	@GetMapping(path = "/{id}/shelves")
	public ResponseEntity<List<Shelf>> viewUserShelves(@PathVariable("id")Long id) {
		User user = userServ.getUser(id);
		if (user != null) {
		    List<Shelf> shelves = user.getShelves();
		    if (shelves != null) {
		    	return ResponseEntity.ok(shelves);
		    }
	    }
		return ResponseEntity.notFound().build();	
	}
	
	@PutMapping(path = "/{id}/addbook/{shelfId}")
	public ResponseEntity<User> addShelf(@PathVariable("id") Long id, @PathVariable("shelfId") Long shelfId) {
		User user = userServ.getUser(id);
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
