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
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private int user;
	private String bookISBN;
	@ManyToOne
	@JoinColumn(name="category_id")
	private int category;

	//------------------------- constructors -------------------------
	public Shelf(int id, int user, String bookISBN, int category) {
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
	//--------------------------------------------------
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	//--------------------------------------------------
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	//--------------------------------------------------
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}

	//------------------------- methods -------------------------
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
