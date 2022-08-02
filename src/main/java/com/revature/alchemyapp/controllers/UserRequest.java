package com.revature.alchemyapp.controllers;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.revature.alchemyapp.models.Shelf;

import lombok.Data;

@Data
public class UserRequest {
	@JsonProperty String password;
	@JsonProperty private String firstName;
	@JsonProperty private String lastName;
	@JsonProperty private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	
}
