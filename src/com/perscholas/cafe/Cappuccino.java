package com.perscholas.cafe;

public class Cappuccino extends Product {
	
	private boolean peppermint;
	private boolean whippedCream;

	public Cappuccino() {
		super();
		setPeppermint(false);
		setWhippedCream(false);
	}
	
	public Cappuccino(String name, double price, String description, int quantity) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
		this.setQuantity(quantity);
	}

	@Override
	public double calculateProductSubtotal() {
		double pep = 0.00;
		double whip = 0.00;
		if(isPeppermint()) 
			pep = 2.00 * getQuantity();
		if(isWhippedCream())
			whip = 1.00 * getQuantity();
		return getPrice() * getQuantity() + pep + whip;
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

	@Override
	public void addOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printOptions() {
		int capQty = this.getQuantity();
		double capSubtotal = this.calculateProductSubtotal();
		
		String pepStr = "No";
		String whipStr = "No";
		
		if(this.isPeppermint()) {
			pepStr = "Yes (Add $2)";
		}
		
		if(this.isWhippedCream()) {
			whipStr = "Yes (Add $1)";
		}
		System.out.print("\nItem: Cappuccino	Price: $4.99" + " 		Qty: " + capQty
				+"\nExtra peppermint: " + pepStr + " 	Whipped Cream: " + whipStr
				+ "\nsubtotal: " + capSubtotal);
		
	}

	
}
