package com.revature.alchemyapp.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class ShelfRequest {
	@JsonProperty
	private Long category;
	@JsonProperty
	private String book;
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}

	
}
