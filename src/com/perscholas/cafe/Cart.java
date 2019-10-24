package com.perscholas.cafe;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Product> cart = new ArrayList<>();
	
	public void addToCart(Product product) {
		cart.add(product);
	}
	
	public void checkOut() {
		System.out.println("Proceed to checkout.");
		double subtotal = 0.00;

		
		for(int i = 0; i < cart.size(); i++) {
			subtotal = subtotal + cart.get(i).calculateProductSubtotal();
			cart.get(i).printOptions();
			System.out.println();
		}
		
		
		double salesTax = 1.03;
		System.out.println("\nPurchase Subtotal: " + subtotal);
		System.out.println("Sales Tax: " + salesTax);
		System.out.printf("\nPurchase Total: %.2f",(subtotal + salesTax));
		
		
	}
}
