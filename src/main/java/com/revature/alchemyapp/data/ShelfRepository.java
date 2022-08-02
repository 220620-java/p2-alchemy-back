package com.revature.alchemyapp.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
<<<<<<< HEAD
	public List<Shelf> findByUser(User user);
	public List<Shelf> findByBookisbn(String bookISBN);
	public List<Shelf> findByUserAndCategory(User user, Category category);
=======
	public List<Shelf> findByBook(String bookISBN);
>>>>>>> 37443fa6229374d1fe799011cc9f8268ba93e99d
}
