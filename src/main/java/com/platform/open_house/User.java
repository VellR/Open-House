package com.platform.open_house.servlets;

import java.util.Date;

public class User {
	
	String username;
	String email;
	Date birthday;
	String location;
	boolean status;
	boolean barter;
	
	
	public User(String username, String email, Date birthday, String location, boolean barter) {
		this.username = username;
		this.email = email;
		this.birthday = birthday;
		this.location = location;
		this.barter = barter;
	}
	
	public User(String username, String email, Date birthday, String location) {
		this.username = username;
		this.email = email;
		this.birthday = birthday;
		this.location = location;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
