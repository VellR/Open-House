package com.platform.open_house.models;

public class Request extends ItemModel{
	Boolean barter;
	String barterItem;
	
	public Request() {
		this.type = 2;
	}
	
	public Request(Integer userId, String name, String description, Double price, Boolean barter, String barterItem) {
		this.type = 2;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.barter = barter;
		this.barterItem = barterItem;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getBarter() {
		return barter;
	}

	public void setBarter(Boolean barter) {
		this.barter = barter;
	}

	public String getBarterItem() {
		return barterItem;
	}

	public void setBarterItem(String barterItem) {
		this.barterItem = barterItem;
	}
	
}
