package com.revature.alchemyapp.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Shelf {
	public void setUser(User user) {
		this.user = user;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private String bookISBN;
	@ManyToOne
	@JoinColumn(name="category_id")
<<<<<<< HEAD
	private int category;

	//------------------------- constructors -------------------------
	public Shelf(int id, int user, String bookISBN, int category) {
=======
	private Category category;
	
	public Shelf(int id, User user, String bookISBN, Category category) {
>>>>>>> cb5589ef36b8cf9110204114f3ea93fa694c0fd1
		this.id = id;
		this.user = user;
		this.bookISBN = bookISBN;
		this.category = category;
	}
	
	//------------------------- getters & setters -------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD
	//--------------------------------------------------
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	//--------------------------------------------------
=======
>>>>>>> cb5589ef36b8cf9110204114f3ea93fa694c0fd1
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
<<<<<<< HEAD
	//--------------------------------------------------
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	//------------------------- methods -------------------------
=======
>>>>>>> cb5589ef36b8cf9110204114f3ea93fa694c0fd1
	@Override
	public int hashCode() {
		return Objects.hash(bookISBN, category, id, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shelf other = (Shelf) obj;
		return Objects.equals(bookISBN, other.bookISBN) && category == other.category && id == other.id
				&& user == other.user;
	}
	@Override
	public String toString() {
		return "Shelf [id=" + id + ", user=" + user + ", bookISBN=" + bookISBN + ", category=" + category + "]";
	}
	
	
}
