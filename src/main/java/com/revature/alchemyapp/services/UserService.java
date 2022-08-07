package com.revature.alchemyapp.services;

import java.util.List;

import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

public interface UserService {
	public User registerUser(User user) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password);
	public User getUser(Long id);
	public User addBook(Shelf shelf, User user);
	public List<Category> getCategories();
	public User updateUser(User user);
	public List<User> getAllUsers();
}
