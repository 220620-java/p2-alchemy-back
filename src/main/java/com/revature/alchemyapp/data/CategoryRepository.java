package com.revature.alchemyapp.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.Category;
import com.revature.alchemyapp.models.Shelf;


//@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryName(String categoryName);
}
