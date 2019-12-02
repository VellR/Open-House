package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Request {
	@Id
	@GeneratedValue
	Integer requestId;
	Integer userId;
	
	String itemName;
	String itemDescription;
	Double itemPrice;
	Boolean barter;
	String barterItem;
	
	public Request() {}
	
	public Request(Integer userId, String itemName, String itemDescription, Double itemPrice, Boolean barter, String barterItem) {
		this.userId = userId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.barter = barter;
		this.barterItem = barterItem;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
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
