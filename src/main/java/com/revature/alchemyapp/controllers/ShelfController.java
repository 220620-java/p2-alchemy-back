package com.revature.alchemyapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.dto.ShelfRequest;
import com.revature.alchemyapp.services.ShelfService;
import com.revature.alchemyapp.services.UserService;

@RestController
@RequestMapping(path="/shelf")
public class ShelfController {
	private ShelfService shelfServ;
	private UserService userServ;
	private CategoryRepository categoryRepo;
	
	public ShelfController(ShelfService shelfServ, UserService userServ, CategoryRepository categoryRepo) {
		this.shelfServ=shelfServ;
		this.userServ=userServ;
		this.categoryRepo=categoryRepo;
	}
	
	@PostMapping
	public ResponseEntity<Shelf> addShelf(@RequestBody ShelfRequest shelfRequest) {
		Shelf shelf = new Shelf();
		shelf.setBookISBN(shelfRequest.getBook());
		Optional<Category> category = categoryRepo.findById(shelfRequest.getCategory());
		shelf.setCategory(category.get());
		shelfServ.createShelf(shelf);
		return ResponseEntity.status(HttpStatus.CREATED).body(shelf);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<Shelf>> getShelves(@PathVariable("id") Long shelfId) {
		List<Shelf> shelf = shelfServ.getAllShelves();
		if (shelf != null) {
			return ResponseEntity.ok(shelf);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
