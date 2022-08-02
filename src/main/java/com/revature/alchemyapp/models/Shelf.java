package com.revature.alchemyapp.models;

import java.util.Objects;

import javax.persistence.Column;
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
	@Column(name="book_isbn")
	private String book;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
<<<<<<< HEAD

	//------------------------- constructors -------------------------
	public Shelf(int id, User user, String bookISBN, Category category) {
		this.id = id;
		this.user = user;
		this.bookISBN = bookISBN;
		this.category = category;
	}
	
	//------------------------- getters & setters -------------------------
=======
	
>>>>>>> 37443fa6229374d1fe799011cc9f8268ba93e99d
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD
	//--------------------------------------------------
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//--------------------------------------------------
	public String getBookISBN() {
		return bookISBN;
=======
	public String getBook() {
		return book;
>>>>>>> 37443fa6229374d1fe799011cc9f8268ba93e99d
	}
	public void setBook(String book) {
		this.book = book;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	//--------------------------------------------------
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	//------------------------- methods -------------------------
	@Override
	public int hashCode() {
		return Objects.hash(book, category, id);
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
		return Objects.equals(book, other.book) && category == other.category && id == other.id;
	}
	@Override
	public String toString() {
		return "Shelf [id=" + id + ", bookISBN=" + book + ", category=" + category + "]";
	}
	
	
}
