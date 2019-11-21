package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Trade {
	@Id
	@GeneratedValue
	private Integer tradeId;
	
	private Integer itemId;
	private Integer sellerId;
	private Integer buyerId;
	
	public Trade() {}
	
	public Trade(Integer tradeId, Integer itemId, Integer sellerId, Integer buyerId) {
		this.tradeId = tradeId;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	
}
