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
	private Category category;
	
	public Shelf(int id, User user, String bookISBN, Category category) {
		this.id = id;
		this.user = user;
		this.bookISBN = bookISBN;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
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
