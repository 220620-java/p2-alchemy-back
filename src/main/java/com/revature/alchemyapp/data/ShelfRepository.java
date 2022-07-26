package com.revature.alchemyapp.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

//@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
	
	List<Shelf> findByUserId(Long userId);
	////public List<Shelf> findByBookisbn(String bookISBN);

}
