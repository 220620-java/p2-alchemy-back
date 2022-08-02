package com.revature.alchemyapp.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.alchemyapp.models.Shelf;
import com.revature.alchemyapp.models.User;

/**
 * Data Transfer Object to prepare a User object to be sent in an HTTP response. 
 * Looks like a User but without the password.
 * @author SierraNicholes
 *
 */
public class UserDTO {
	private long id;
	private String username;
	private String firstName;
	private String lastName;
	private List<Shelf> shelves;
	
	public UserDTO() {
		super();
		this.id = 0;
		this.username = "";
		this.firstName = "";
		this.lastName = "";
		this.shelves = new ArrayList<>();
	}
	
	public UserDTO(int id, String username, String firstName, String lastName, List<Shelf> shelves) {
		super();
		setId(id);
		setUsername(username);
		setFirstName(firstName);
		setLastName(lastName);
		setShelves(shelves);
	}
	
	public UserDTO(User user) {
		super();
		setId(user.getId());
		setUsername(user.getUsername());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setShelves(user.getShelves());
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, shelves, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(shelves, other.shelves) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", shelves=" + shelves + "]";
	}
	
}
