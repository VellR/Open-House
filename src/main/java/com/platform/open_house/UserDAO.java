package com.platform.open_house;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class UserDAO {
	private MariaConnection mariaConnection = new MariaConnection();
	private User user;
	
	public boolean userExist(String username, String password) {
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
				String actualUsername = rs.getString("username");
				String actualPassword = rs.getString("password");
				
				if(actualUsername.equals(username) & actualPassword.equals(password))
					return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	public User requestUser(String username, String password) {
		String actualUsername;
		String actualPassword;
		String firstname;
		String lastname;
		String phonenumber;
		String location;
		String email;
		Date birthday;
		
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
				actualUsername = rs.getString("username");
				actualPassword = rs.getString("password");
				int barterFlag = rs.getInt("barter");
				
				if(actualUsername.equals(username) & actualPassword.equals(password)) {
					firstname = rs.getString("firstname");
					lastname = rs.getString("lastname");
					location = rs.getString("location");
					email = rs.getString("email");
					birthday = rs.getDate("birthday");
					phonenumber = rs.getString("phonenumber");
					
					if(barterFlag == 1) {
						user = new User(firstname, lastname, actualUsername, email, birthday, location, true);
						user.setStatus(true);
						user.setPhonenumber(phonenumber);
						return user;
					}else {
						user = new User(firstname, lastname, actualUsername, email, birthday, location);
						user.setStatus(true);
						user.setPhonenumber(phonenumber);
						return user;
					}				
					
				}
			}
			
			
		}catch(Exception e) {
			System.out.println("User not found");
		}
		
		return user;
	}
	
	public void addUser(String username, String password, String firstname, String lastname, Date birthday, String email, String phonenumber, boolean barter) {
try {
			
			String query = "INSERT INTO users (username, password, firstname, lastname, birthday, email, phonenumber, barter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstname);
			statement.setString(4, lastname);
			statement.setDate(5, (java.sql.Date) birthday); //may not function correctly
			statement.setString(6, email);
			statement.setString(7, phonenumber);
			statement.setBoolean(8, barter);
			

			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to add user to database");
			}
		
	}
	
	public void removeUser() {
		
	}
	
	public void modifyUser() {
		
	}
	
	
}
