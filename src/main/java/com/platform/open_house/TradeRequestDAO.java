package com.platform.open_house;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TradeRequestDAO {

	private MariaConnection mariaConnection = new MariaConnection();
	private TradeRequest tradeRequest;
	
	public boolean tradeRequestExist(int requestId) {
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM request");
			
			while(rs.next()) {
				int actualRequestId = rs.getInt("requestId");
				
				if(actualRequestId == requestId & actualRequestId == requestId)
					return true;
			}
			return false;
			
		}catch(Exception e) {
			System.out.println("Failed to check existence: " + e.getMessage());
			return false;
		}
	}
	
	public TradeRequest getTradeRequest(int requestId) {
		String name;
		double price;
		String description;
		boolean barter;
		String desiredBarter;
		
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM request");
			
			while(rs.next()) {
				int actualRequestId = rs.getInt("requestId");
				
				if(actualRequestId == requestId) {
					name = rs.getString("name");
					price = rs.getDouble("price");
					description = rs.getString("description");
					barter = rs.getBoolean("barter");
					desiredBarter = rs.getString("desiredbarter");
					
					tradeRequest = new TradeRequest(requestId, name, price, description, barter, desiredBarter);
				}
					
			}
			
			
		}catch(Exception e) {
			System.out.println("Failed to get trade request: " + e.getMessage());
		}
		
		return tradeRequest;
	}
	
	public void addTradeRequest(TradeRequest tradeRequest) {
		int requestId = tradeRequest.getRequestId();
		String name = tradeRequest.getName();
		double price = tradeRequest.getPrice();
		String description = tradeRequest.getDescription();
		boolean barter = tradeRequest.isBarter();
		String desiredBarter = tradeRequest.getDesiredBarter();
		
		try {
			
			String query = "INSERT INTO request (requestId, name, price, description, barter, desiredBarter) VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, requestId);
			statement.setString(2, name);
			statement.setDouble(3, price);
			statement.setString(4, description);
			statement.setBoolean(5, barter);
			statement.setString(6, desiredBarter);
			
			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to add trade request to database: " + e.getMessage());
			}
		
	}
	
	public void removeTradeRequest(int requestId) {
		
		try {
			
			String query = "DELETE FROM request WHERE requestId=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, requestId);
			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to remove trade request from database: " + e.getMessage());
		}
		
	}
	
	public void updateTradeRequest(TradeRequest tradeRequest) {
		
		int requestId = tradeRequest.getRequestId();
		String name = tradeRequest.getName();
		double price = tradeRequest.getPrice();
		String description = tradeRequest.getDescription();
		boolean barter = tradeRequest.isBarter();
		String desiredBarter = tradeRequest.getDesiredBarter();
		
		try {
			
			String query = "UPDATE request SET name=?, price=?, description=?, barter=?, desiredbarter=? WHERE requestId=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setString(1, name);
			statement.setDouble(2, price);
			statement.setString(3, description);
			statement.setBoolean(4, barter);
			statement.setString(5, desiredBarter);
			statement.setInt(6, requestId);
			 
			statement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Failed to update trade request: " + e.getMessage());
		}
	}

}
