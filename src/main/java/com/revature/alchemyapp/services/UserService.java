package com.revature.alchemyapp.services;

import java.util.List;

import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

public interface UserService {
	public User registerUser(User user) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password);
	public User getUser(int id);
	public User addBook(String bookISBN, User user, int category);
	public List<Category> viewShelfCategories();
	public List<Shelf> viewUserBooks(User user);
	public User updateUser(User user);
	
}
