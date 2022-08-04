package com.revature.alchemyapp.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.alchemyapp.models.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
