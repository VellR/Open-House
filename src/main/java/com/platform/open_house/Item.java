package com.platform.open_house;

import java.sql.Date;

public class Item {
	private int ownerId;
	private int tradeId;
	private int buyerId;
	private int itemId;
	private String name;
	private String description;
	private double price;
	private boolean barter;
	private String desiredBarter;
	private Date expiration;
	
	public Item(int ownerId, int tradeId, int buyerId, int itemId, String name, double price) {
		this.ownerId = ownerId;
		this.tradeId = tradeId;
		this.buyerId = buyerId;
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}
	
	public Item(int ownerId, int tradeId, int buyerId, int itemId, String name, String description, double price) {
		this.ownerId = ownerId;
		this.tradeId = tradeId;
		this.buyerId = buyerId;
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Item(int ownerId, int tradeId, int buyerId, int itemId, String name, String description, double price, boolean barter, String desiredBarter, Date expiration) {
		this.ownerId = ownerId;
		this.tradeId = tradeId;
		this.buyerId = buyerId;
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.barter = barter;
		this.desiredBarter = desiredBarter;
		this.expiration = expiration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesiredBarter() {
		return desiredBarter;
	}
	public void setDesiredBarter(String desiredBarter) {
		this.desiredBarter = desiredBarter;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public int getItemId() {
		return itemId;
	}
	public boolean isBarter() {
		return barter;
	}
	public Date getExpiration() {
		return expiration;
	}
	public int getTradeId() {
		return this.tradeId;
	}
	
	
}
