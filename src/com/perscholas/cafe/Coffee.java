package com.perscholas.cafe;

public class Coffee extends Product{
	
	private boolean sugar;
	private boolean milk;
	
	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public Coffee() {
		super();
		sugar = false;
		milk = false;
	}
	
	public Coffee(String name, double price, String description, int quantity) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
		this.setQuantity(quantity);
	}

	@Override
	public double calculateProductSubtotal() {
		return getPrice() * getQuantity();
	}

	@Override
	public void addOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printOptions() {
		String sugStr = "No";
		String milkStr = "No";
		int cofQty = this.getQuantity();
		double cofSubtotal = this.calculateProductSubtotal();
		if(this.isMilk()) {
			sugStr = "Yes";
		}
		
		if(this.isSugar()) {
			milkStr = "Yes";
		}
		
		System.out.print("\nItem: Coffee	Price: $3.49" + " 		Qty: " + cofQty
				+"\nExtra sugar: " + sugStr + " 	Milk: " + milkStr
				+ "\nsubtotal: " + cofSubtotal);
		
	}

}
