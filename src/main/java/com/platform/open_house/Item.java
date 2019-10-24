package com.platform.open_house;

public abstract class Item {
	private String name;
	private int id;
	private String description;
	private int ownerId;
	private double price;
	private boolean barter;
	private String barterItem;
	
	public Item(String name, String description, int ownerId, double price, boolean barter, String barterItem) {
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.price = price;
		this.barter = barter;
		this.barterItem = barterItem;
	}
	
	public Item(String name, String description, int ownerId, double price) {
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.price = price;
	}
	
	public Item(String name, String description, int ownerId, boolean barter, String barterItem) {
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.barter = barter;
		this.barterItem = barterItem;
	}
	
	
	public String getName() {
		return name;
	}

	private void generateId() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean willBarter() {
		return barter;
	}
	public void setBarter(boolean barter) {
		this.barter = barter;
	}
	public String getBarterItem() {
		return barterItem;
	}
	public void setBarterItem(String barterItem) {
		this.barterItem = barterItem;
	}
	
	
}
