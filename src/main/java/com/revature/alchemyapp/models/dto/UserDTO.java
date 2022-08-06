package com.revature.alchemyapp.models.dto;

import java.util.ArrayList;
import java.util.List;

import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;


public class UserDTO {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private List<Shelf> shelves;
	
	public UserDTO() {
		super();
		this.setId(0);
		this.username="";
		this.firstName="";
		this.lastName="";
		this.setShelves(new ArrayList<>());
	}
	public UserDTO(User user) {
		super();
		this.setId(user.getId());
		this.username=user.getUsername();
		this.firstName=user.getFirstName();;
		this.lastName=user.getLastName();
		this.setShelves(user.getShelves());
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Shelf> getShelves() {
		return shelves;
	}
	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
