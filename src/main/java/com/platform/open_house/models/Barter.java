package com.platform.open_house.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Barter {
	@Id
	@GeneratedValue
	private Integer barterId;
	
	private Integer sellerItemId;
	private Integer buyerItemId;
	
	public Barter() {}
	
	public Barter(Integer barterId, Integer sellerItemId, Integer buyerItemId) {
		this.barterId = barterId;
		this.sellerItemId = sellerItemId;
		this.buyerItemId = buyerItemId;
	}

	public Integer getBarterId() {
		return barterId;
	}

	public void setBarterId(Integer barterId) {
		this.barterId = barterId;
	}

	public Integer getSellerItemId() {
		return sellerItemId;
	}

	public void setSellerItemId(Integer sellerItemId) {
		this.sellerItemId = sellerItemId;
	}

	public Integer getBuyerItemId() {
		return buyerItemId;
	}

	public void setBuyerItemId(Integer buyerItemId) {
		this.buyerItemId = buyerItemId;
	}
	
}
