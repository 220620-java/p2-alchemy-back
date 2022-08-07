package com.revature.alchemyapp.controllers;

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

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.services.CategoryService;
import com.revature.alchemyapp.services.ShelfService;

@RestController
@RequestMapping(path="/shelf")
public class ShelfController {
	private ShelfService shelfServ;
	private CategoryService categoryServ;
	
	public ShelfController(ShelfService shelfServ, CategoryService categoryServ) {
		this.shelfServ=shelfServ;
		this.categoryServ=categoryServ;
	}
	
	@PostMapping
	public ResponseEntity<Shelf> addShelf(@RequestBody Map<String, String> book) {
		Shelf shelf = new Shelf();
		shelf.setBookISBN(book.get("book"));
		Category category = categoryServ.getCategoryByName(book.get("category"));
		shelf.setCategory(category);
		shelfServ.createShelf(shelf);
		return ResponseEntity.status(HttpStatus.CREATED).body(shelf);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<Shelf>> getShelves() {
		List<Shelf> shelf = shelfServ.getAllShelves();
		if (shelf != null) {
			return ResponseEntity.ok(shelf);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Shelf> updateShelf(@RequestBody Shelf shelf, @PathVariable("") Long id) {
		if (shelf.getId() == id) {
			shelf = shelfServ.updateShelf(shelf);
			if (shelf != null) {
				return ResponseEntity.ok(shelf);
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	} 
}
