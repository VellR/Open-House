package com.platform.open_house.models;

public class Item extends ItemModel{
	
	public Item() {
		this.type = 1;
	}
	
	public Item(Integer itemId, Integer userId, String name, String description, String price, String expiration) {
		this.type = 1;
		this.id = itemId;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.expiration = expiration;
	}
	
	public Item(Integer userId, String name, String description, String price, String expiration) {
		this.type = 1;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.expiration = expiration;
	}

	public Item(String name, String description, String price, String expiration) {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
