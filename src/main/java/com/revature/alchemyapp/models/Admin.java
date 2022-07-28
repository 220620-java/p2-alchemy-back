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
	public int getId() {
		return id;
	}

