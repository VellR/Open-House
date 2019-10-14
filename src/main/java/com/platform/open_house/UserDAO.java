package com.platform.open_house;

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
					
					if(barterFlag == 1) {
						user = new User(firstname, lastname, actualUsername, email, birthday, location, true);
						user.setStatus(true);
						return user;
					}else {
						user = new User(firstname, lastname, actualUsername, email, birthday, location);
						user.setStatus(true);
						return user;
					}				
					
				}
			}
			
			
		}catch(Exception e) {
			System.out.println("User not found");
		}
		
		return user;
	}
	
	
}
