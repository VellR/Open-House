package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Trade {
	@Id
	@GeneratedValue
	private Integer tradeId;
	
	private Integer itemId;
	private Integer ownerUserId;
	private Integer buyerId;
	
	public Trade() {}
	
	public Trade(Integer tradeId, Integer itemId, Integer ownerUserId, Integer buyerId) {
		this.tradeId = tradeId;
		this.itemId = itemId;
		this.ownerUserId = ownerUserId;
		this.buyerId = buyerId;
	}
	
	public Trade(Integer itemId, Integer ownerUserId, Integer buyerId) {
		this.itemId = itemId;
		this.ownerUserId = ownerUserId;
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

	public Integer getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Integer ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	
}
