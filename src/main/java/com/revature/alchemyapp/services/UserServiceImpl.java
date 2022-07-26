package com.revature.alchemyapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User registerUser(User user) throws UsernameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addBook(String bookISBN, User user, int category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> viewShelfCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shelf> viewUserBooks(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
