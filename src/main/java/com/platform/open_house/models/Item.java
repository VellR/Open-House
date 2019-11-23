package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Item {
	@Id
	@GeneratedValue
	private Integer itemId;
	
	private Integer userId;
	
	private String name;
	private String description;
	
	private Double price;
	
	private String expiration;
	
	public Item() {}
	
	public Item(Integer itemId, Integer userId, String name, String description, Double price, String expiration) {
		this.itemId = itemId;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.expiration = expiration;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

}
