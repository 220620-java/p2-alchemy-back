package com.revature.alchemyapp.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.alchemyapp.data.UserRepository;
import com.revature.alchemyapp.exceptions.UsernameAlreadyExistsException;
import com.revature.alchemyapp.models.User;

@SpringBootTest
public class UserServiceTest {
	@MockBean
	private UserRepository userRepo;
	@MockBean
	private UserService userServ;
	
	@Test
	void testGetAllUsers() {
		Mockito.when(userRepo.findAll()).thenReturn(new ArrayList<User>());
		assertNotNull(userServ.getAllUsers());
	}
	
	@Test
	void testGetUser() {
		User mockUser = new User();
		Mockito.when(userRepo.findById((long) 1)).thenReturn(Optional.of(mockUser));
		assertNotNull(userServ.getUser((long) 1));
	}
	
	@Test
	void testGetUserNotFound() {
		Mockito.when(userRepo.findById((long) 999)).thenReturn(Optional.empty());
		assertNull(userServ.getUser((long) 999));
	}
	
	@Test
	void testLogin() {
		String username = "koevgeniy";
		String password = "123456";
		User mockUser = new User();
		Mockito.when(userRepo.findByUsername(username)).thenReturn(Optional.of(mockUser));
		assertNotNull(userServ.logIn(username, password));
	}
	
	@Test
	void testLoginWrongCredentials() {
		String username = "wrong";
		String password = "credentials";
		User mockUser = new User();
		Mockito.when(userRepo.findByUsername(username)).thenReturn(Optional.of(mockUser));
		assertNull(userServ.logIn(username, password));
	}
	
	@Test
	void testRegisterUser() throws UsernameAlreadyExistsException {
		User mockUser = new User();
		mockUser.setUsername("NewUser");
		mockUser.setPassword("password");
		mockUser.setFirstName("Evgeniy");
		mockUser.setLastName("Ko");
		Mockito.when(userRepo.save(mockUser)).thenReturn(mockUser);
		
		User returnUser = userServ.registerUser(mockUser);
		
		assertNotNull(returnUser);
	}
	
	@Test
	void testRegisterUserUsernameExists() throws UsernameAlreadyExistsException {
		User mockUser = new User();
		mockUser.setUsername("koevgeniy");
		mockUser.setPassword("password");
		mockUser.setFirstName("Evgeniy");
		mockUser.setLastName("Ko");
		Mockito.when(userRepo.save(mockUser)).thenReturn(null);
		assertNull(userServ.registerUser(mockUser));
	}
	
	@Test
	void testUpdateUser() {
		User mockUser = new User();
		mockUser.setId((long) 1);
		mockUser.setUsername("koevgeniy");
		mockUser.setPassword("password");
		mockUser.setFirstName("ko");
		mockUser.setLastName("Evgeniy");
		assertNotNull(userServ.updateUser(mockUser));
	}

}
