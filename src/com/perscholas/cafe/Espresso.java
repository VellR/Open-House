package com.perscholas.cafe;

public class Espresso extends Product {
	
	private boolean extraShot;
	private boolean macchiato;
	
	public Espresso() {
		super();
		extraShot = false;
		macchiato = false;
	}
	
	public Espresso(String name, double price, String description, int quantity) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
		this.setQuantity(quantity);
	}

	@Override
	public double calculateProductSubtotal() {
		double shot = 0.00;
		double mac = 0.00;
		if(isExtraShot()) 
			shot = 2.00 * getQuantity();
		if(isMacchiato())
			mac = 1.00 * getQuantity();
		return getPrice() * getQuantity() + shot + mac;
	}

	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}

	@Override
	public void addOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printOptions() {
		String shotStr = "No";
		String macStr = "No";
		int espQty = this.getQuantity();
		double espSubtotal = this.calculateProductSubtotal();
		
		if(this.isExtraShot()) {
			shotStr = "Yes (Add $2)";
		}
		
		if(this.isMacchiato()) {
			macStr = "Yes (Add $1)";
		}
		
		System.out.print("\nItem: Espresso	Price: $3.99" + " 		Qty: " + espQty
				+"\nExtra shot: " + shotStr + " 	Machiatto: " + macStr
				+ "\nsubtotal: " + espSubtotal);
	}


}
