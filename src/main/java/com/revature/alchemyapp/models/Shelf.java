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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook() {
		return book;
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
