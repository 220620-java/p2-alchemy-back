package com.revature.alchemyapp.services;

import java.util.List;

import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

public interface ShelfService {
	public Shelf createShelf(Shelf shelf);
	public Shelf getShelf(Long id);
	public List<Shelf> getAllShelves();
	public Shelf updateShelf(Shelf shelf);
}
