package com.platform.open_house;

public class TradeRequest {
	private int requestId;
	private String name;
	private double price;
	private String description;
	private boolean barter;
	private String desiredBarter;
	
	public TradeRequest(int requestId, String name, double price) {
		this.requestId = requestId;
		this.name = name;
		this.price = price;
	}
	
	public TradeRequest(int requestId, String name, double price, String description) {
		this.requestId = requestId;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public TradeRequest(int requestId, String name, double price, String description, boolean barter, String desiredBarter) {
		this.requestId = requestId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.barter = barter;
		this.desiredBarter = desiredBarter;
	}
	
	public TradeRequest(int requestId, String name, double price, boolean barter, String desiredBarter) {
		this.requestId = requestId;
		this.name = name;
		this.price = price;
		this.barter = barter;
		this.desiredBarter = desiredBarter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesiredBarter() {
		return desiredBarter;
	}

	public void setDesiredBarter(String desiredBarter) {
		this.desiredBarter = desiredBarter;
	}

	public int getRequestId() {
		return requestId;
	}

	public boolean isBarter() {
		return barter;
	}
	
	

}
