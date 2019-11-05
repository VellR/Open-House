package com.platform.open_house;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CompleteTradeDAO {

private MariaConnection mariaConnection = new MariaConnection();
	
	public boolean completeTradeExist(int tradeId) {
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM activetrades");
			
			while(rs.next()) {
				int actualTradeId = rs.getInt("tradeId");
				
				if(actualTradeId == tradeId & actualTradeId == tradeId)
					return true;
			}
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	public Item getCompleteTrade(int tradeId) {
		Item item = null;
		int ownerId;
		int buyerId;
		int itemId;
		String name;
		String description;
		double price;
		boolean barter;
		String desiredBarter;
		Date expiration;
		
		try {
			Statement stmt = mariaConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM activetrades");
			
			while(rs.next()) {
				int actualTradeId = rs.getInt("tradeId");
				
				if(actualTradeId == tradeId) {
					ownerId = rs.getInt("ownerId");
					buyerId = rs.getInt("buyerId");
					itemId = rs.getInt("itemId");
					name = rs.getString("name");
					description = rs.getString("description");
					price = rs.getDouble("price");
					barter = rs.getBoolean("barter");
					desiredBarter = rs.getString("desiredBater");
					expiration = rs.getDate("expiration");
					
					item = new Item(ownerId, tradeId, buyerId, itemId, name, description, price, barter, desiredBarter, expiration);
				}
				return item;	
			}
			
			
		}catch(Exception e) {
			
		}
		
		return item;
	}
	
	public void addCompleteTrade(Item item) {
		int ownerId = item.getOwnerId();
		int tradeId = item.getTradeId();
		int buyerId = item.getBuyerId();
		int itemId = item.getItemId();
		String name = item.getName();
		String description = item.getDescription();
		double price = item.getPrice();
		boolean barter = item.isBarter();
		String desiredBarter = item.getDesiredBarter();
		Date expiration = item.getExpiration();
		
		try {
			
			String query = "INSERT INTO activetrades (ownerId, tradeId buyerId, itemId, name, description, price, barter, desiredBarter, expiration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, ownerId);
			statement.setInt(2, tradeId);
			statement.setInt(3, buyerId);
			statement.setInt(4, itemId);
			statement.setString(5, name);
			statement.setString(6, description);
			statement.setDouble(7, price);
			statement.setBoolean(8, barter);
			statement.setString(9, desiredBarter);
			statement.setDate(10, expiration);
			
			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to add user to database");
			}
		
	}
	
	public void removeCompleteTrade(int tradeId) {
		
		try {
			
			String query = "DELETE FROM activetrades WHERE itemId=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, tradeId);
			statement.executeUpdate();
			
			}catch(Exception e) {
			System.out.println("Failed to remove user from database");
		}
		
	}
	
	public void updateCompleteTrade(Item item) {
		
		int ownerId = item.getOwnerId();
		int tradeId = item.getTradeId();
		int buyerId = item.getBuyerId();
		int itemId = item.getItemId();
		String name = item.getName();
		String description = item.getDescription();
		double price = item.getPrice();
		boolean barter = item.isBarter();
		String desiredBarter = item.getDesiredBarter();
		Date expiration = item.getExpiration();
		
		try {
			
			String query = "UPDATE request SET ownerId=?, buyerId=?, itemId=?, name=?, description=?, price=?, barter=?, desiredBarter=?, expiration=? WHERE tradeId=?";
			 
			PreparedStatement statement = mariaConnection.getConnection().prepareStatement(query);
			statement.setInt(1, ownerId);
			statement.setInt(2, buyerId);
			statement.setInt(3, itemId);
			statement.setString(4, name);
			statement.setString(5, description);
			statement.setDouble(6, price);
			statement.setBoolean(7, barter);
			statement.setString(8, desiredBarter);
			statement.setDate(9, expiration);
			statement.setInt(10, tradeId);
			 
			statement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Failed to update first name.");
		}
	}

}
