package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ItemModel {
	protected Integer type;
	
	@Size(min=3, max=25, message="Item name must be betwen 3 and 25 characters")
	@NotBlank(message="Item must have a name")
	protected String name;
	@Size(min=10, max=50, message="Item description must be between 10 and 50 characters")
	protected String description;
	protected String expiration;
	
	@Digits(fraction=2, integer = 1000,  message="Please enter a valid price 0.00")
	protected Double price;
	
	@Id
	@GeneratedValue
	protected Integer id;
	protected Integer userId;
	
	public ItemModel() {}
	
	public ItemModel(String name, String description, Double price, String expiration) {
		this.name = name;
		this.description = description;
		this.price = price;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
