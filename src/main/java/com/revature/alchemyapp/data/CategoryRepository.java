package com.revature.alchemyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Category findByName(String name);
}
