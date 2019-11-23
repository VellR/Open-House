package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	Integer userId;
	
	@Size(min=2, max=25,  message="First Name must be between 2 and 25 characters long.")
	@NotBlank(message="First Name is required.")
	private String firstName;
	@Size(min=2, max=25,  message="Last Name must be between 2 and 25 characters long.")
	@NotBlank(message="Last Name is required.")
	private String lastName;
	@Size(min=5, max=25,  message="Username must be between 5 and 25 characters long.")
	@NotBlank(message="Username is required.")
	private String username;
	@Size(min=5, max=50,  message="Password must be between 5 and 50 characters long.")
	@NotBlank(message="Password is required.")
	private String password;
	@Size(min=5, max=50,  message="Location must be between 5 and 50 characters long.")
	private String location;
	@Size(min=10, max=12,  message="Phone Number must be between 10 and 12 characters long.")
	private String phoneNumber;
	@Email(message="Please enter a valid email.")
	@NotBlank(message="Email is required.")
	private String email;
	private String birthday;
	
	private Boolean status;
	
	public User() {}
	
	public User(String firstName, String lastName, String username, String password, String location, String phoneNumber, String email, String birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
	}
	
	public User(Integer userId, String firstName, String lastName, String username, String password, String location, String phoneNumber, String email, String birthday) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
