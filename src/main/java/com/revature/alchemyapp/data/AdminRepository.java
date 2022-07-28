package com.revature.alchemyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByUsername(String username);
	public Admin findById(int id);
	
}
