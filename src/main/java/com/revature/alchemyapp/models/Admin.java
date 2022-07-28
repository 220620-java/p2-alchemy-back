package com.revature.alchemyapp.models;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity // Tells the ORM that this class exists in the database
@Table(name="admin") // Explicitly tells the ORM the name of the corresponding table in the database if it is different.
public class Admin {
	@Id // Specifies the Java field that corresponds to the database primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // Specifies that this property is automatically generated in the database via serial
	private int id;
	private String username;
	@Column(name="passwrd") // Does the same thing as @Table but with columns
	private String password;
	@Column(name="first_name")
	@JoinColumn(name="admin_id")
	private List<Shelf> shelves;
	private List<Category> categories;
	
	//------------------------- getters & setters -------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//--------------------------------------------------
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//--------------------------------------------------
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//--------------------------------------------------
	public List<Shelf> getShelves() {
		return shelves;
	}
	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}
	//--------------------------------------------------
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	//------------------------- methods -------------------------
	@Override
	public int hashCode() {
		return Objects.hash(categories, id, password, shelves, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(categories, other.categories) && id == other.id
				&& Objects.equals(password, other.password) && Objects.equals(shelves, other.shelves)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", shelves=" + shelves
				+ ", categories=" + categories + "]";
	}
}