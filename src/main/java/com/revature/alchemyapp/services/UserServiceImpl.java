package com.revature.alchemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.alchemyapp.data.CategoryRepository;
import com.revature.alchemyapp.data.ShelfRepository;
import com.revature.alchemyapp.data.UserRepository;
import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;
	private ShelfRepository shelfRepo;
	private CategoryRepository categoryRepo;
	
	public UserServiceImpl(UserRepository userRepo, ShelfRepository shelfRepo, CategoryRepository categoryRepo) {
		this.userRepo = userRepo;
		this.shelfRepo = shelfRepo;
		this.categoryRepo = categoryRepo;
	}
	@Override
	public User registerUser(User user) throws UsernameAlreadyExistsException {
		user.setId(0);
		user = userRepo.save(user);
		if (user.getId() == 0) {
			throw new UsernameAlreadyExistsException();
		}
		return user;
	}

	@Override
	public User logIn(String username, String password) {
		User user = userRepo.findByUsername(username);
		if (user != null && (password != null && password.equals(user.getPassword()))) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User getUser(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		} else {
			return null;
		}
	}

	@Override
	public User addBook(Shelf shelf, User user) {
		if (user == null || shelf == null) {
			return null;
		}
		List<Shelf> shelves = user.getShelves();
		shelves.add(shelf);
		user.setShelves(shelves);
		userRepo.save(user);
		shelfRepo.save(shelf);
		userRepo.save(user);
		return user;
	}

	@Override
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}


	@Override
	public User updateUser(User user) {
		if (userRepo.findById(user.getId()).isPresent()) {
			userRepo.save(user);
			
			Optional<User> userOpt = userRepo.findById(user.getId());
			if (userOpt.isPresent()) {
				return userOpt.get();
			}
		}
		return null;
	}

}
