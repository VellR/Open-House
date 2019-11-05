package com.platform.open_house;

import java.util.Date;

public class User {
	
	String firstname;
	String lastname;
	String username;
	String password;
	String location;
	String phonenumber;
	String email;
	Date birthday;
	int id;
	
	boolean status;
	boolean barter;
	
	
	public User(int id, String firstname, String lastname, String username, String password, String location, String phonenumber, String email, Date birthday) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.location = location;
		this.phonenumber = phonenumber;
		this.id = id;
	}
	
	public User(String firstname, String lastname, String username, String email, Date birthday, String location) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.birthday = birthday;
		this.location = location;
	}
	
	
	public String getPhonenumber() {
		return phonenumber;
	}

	
	public int getId() {
		return this.id;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setBarter(boolean barter) {
		this.barter = barter;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getDate() {
		return this.birthday;
	}
	
	
	public String getLocation() {
		return this.location;
	}
	
	public boolean isOnline() {
		return this.status;
	}
	
	public boolean willBarter() {
		return this.barter;
	}
	
}
