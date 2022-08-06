package com.revature.alchemyapp.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shelf {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="book_isbn")
	private String bookISBN;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="category_id", referencedColumnName = "id")
	private Category category;
	@Column(name="user_id")
	private Long userId;
	@Column(name="book_cover")
	private String bookCover;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookISBN, category, id);
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

		return Objects.equals(bookISBN, other.bookISBN) && category == other.category && id == other.id;
	}
	@Override
	public String toString() {
		return "Shelf [id=" + id + ", bookISBN=" + bookISBN + ", category=" + category + "]";
	}
	public String getBookCover() {
		return bookCover;
	}
	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}
	
	
}
