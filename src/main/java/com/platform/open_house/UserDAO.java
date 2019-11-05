package com.platform.open_house;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class UserDAO {
	private MariaConnection mariaConnection = new MariaConnection();
	
	public boolean userExist(int id) {
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
				int actualId = rs.getInt("id");
				
				if(actualId == id )
					return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	public User requestUser(int id) {
		String username;
		String password;
		String firstname;
		String lastname;
		String phonenumber;
		String location;
		String email;
		Date birthday;
		
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + id);
			
			while(rs.next()) {
//				int actualId = rs.getInt("id");
				
//				if(actualId == id) {
					username = rs.getString("username");
					password = rs.getString("password");
					firstname = rs.getString("firstname");
					lastname = rs.getString("lastname");
					phonenumber = rs.getString("phonenumber");
					location = rs.getString("location");
					email = rs.getString("email");
					birthday = rs.getDate("birthday");
					
					return new User(id, firstname, lastname, username, password, location, phonenumber, email, birthday);
//				}
					
			}
			
			
		}catch(Exception e) {
			System.out.println("Failed to get user request: " + e.getMessage());
		}
		return null;
	}
	
	public void addUser(User user) {
		
		String firstname = user.getFirstname();
		String lastname = user.getLastname();
		String username = user.getUsername();
		String password = user.getPassword();
		String location = user.getLocation();
		String phonenumber = user.getPhonenumber();
		String email = user.getEmail();
		Date birthday = user.getBirthday();
		int id = user.getId();

		try {
			
			String query = "INSERT INTO users (id, username, password, firstname, lastname, birthday, email, phonenumber, location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, id);
			statement.setString(2, username);
			statement.setString(3, password);
			statement.setString(4, firstname);
			statement.setString(5, lastname);
			statement.setDate(6, (java.sql.Date) birthday);
			statement.setString(7, email);
			statement.setString(8, phonenumber);
			statement.setString(9, location);

			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to add user to database: " + e.getMessage());
			}
		
	}
	
	public void removeUser(int id) {
		
		try {
			
			String query = "DELETE FROM users WHERE id=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to remove user from database: " + e.getMessage());
		}
		
	}
	
	public void updateUser(User user) {
		
		String firstname = user.getFirstname();
		String lastname = user.getLastname();
		String username = user.getUsername();
		String password = user.getPassword();
		String location = user.getLocation();
		String phonenumber = user.getPhonenumber();
		String email = user.getEmail();
		Date birthday = user.getBirthday();
		int id = user.getId();
		
		try {
			
			String query = "UPDATE users SET username=?, password=?, firstname=?, lastname=?, birthday=?, email=?, phonenumber=?, location=? WHERE id=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstname);
			statement.setString(4, lastname);
			statement.setDate(5, (java.sql.Date) birthday);
			statement.setString(6, email);
			statement.setString(7, phonenumber);
			statement.setString(8, location);
			statement.setInt(9, id);
			 
			statement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Failed to update user: " + e.getMessage());
		}
	}
	
//	public static void main(String[] args) {
//		UserDAO udao = new UserDAO();
//		
//		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//		
//		udao.addUser(new User(10, "a", "a", "a", "a", "a", "a", "a", sqlDate));
//	}
	
}
