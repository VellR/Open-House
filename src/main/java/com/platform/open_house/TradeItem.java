package com.platform.open_house.servlets;

public class TradeItem extends Item{
	
	int tradeId;
	Buyer buyer;
	Seller seller;
	Item item;
	
	public TradeItem(String name, String description, int ownerId, double price, boolean barter, String barterItem) {
		super(barterItem, barterItem, ownerId, price, barter, barterItem);
	}
	
	public TradeItem(String name, String description, int ownerId, double price) {
		super(description, description, ownerId, price);
	}
	
	public TradeItem(String name, String description, int ownerId, boolean barter, String barterItem) {
		super(barterItem, barterItem, ownerId, barter, barterItem);
	}
	
	public int getTradeId() {
		return tradeId;
	}

	
	private void generateId() {
		
	}
	
	public String getBuyer() {
		return buyer.getUsername();
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller.getUsername();
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
