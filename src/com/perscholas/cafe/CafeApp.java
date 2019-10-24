package com.perscholas.cafe;

import java.util.Scanner;
 
public class CafeApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please select from the following menu:");
		System.out.print("\n1: Coffee"
				+ "\n2: Cappuccino"
				+ "\n3: Espresso"
				+ "\n4: Check Out\n");
		
		Cart cart = new Cart();
		int selection = scan.nextInt();
		while(selection != 4) {
			switch(selection) {
			case 1:
				System.out.println("Do you want sugar?: ");
				boolean sugar = yesNo(scan.next());
				System.out.println("Do you want milk?: ");
				boolean milk = yesNo(scan.next());
				System.out.println("How many?: ");
				int cofQty = scan.nextInt();
				Coffee coffee = new Coffee("Coffee", 3.49, "", cofQty);
				if(sugar) coffee.setSugar(true);;
				if(milk) coffee.setMilk(true);
				cart.addToCart(coffee);
				break;
			case 2:
				System.out.println("Do you want peppermint?: ");
				boolean pep = yesNo(scan.next());
				System.out.println("Do you want whipped cream?: ");
				boolean whip = yesNo(scan.next());
				System.out.println("How many?: ");
				int capQty = scan.nextInt();
				Cappuccino cappuccino = new Cappuccino("Cappuccino", 4.99, "", capQty);
				if(pep) cappuccino.setPeppermint(true);
				if(whip) cappuccino.setWhippedCream(true);
				cart.addToCart(cappuccino);
				break;
			case 3:
				System.out.println("Do you want an extra shot?: ");
				boolean shot = yesNo(scan.next());
				System.out.println("Do you want it to be a macchiato?: ");
				boolean mac = yesNo(scan.next());
				System.out.println("How many?: ");
				int espQty = scan.nextInt();
				Espresso espresso = new Espresso("Espresso", 3.99, "", espQty);
				if(shot) {
					espresso.setExtraShot(true);
				}
				if(mac) espresso.setMacchiato(true);
				cart.addToCart(espresso);
				break;
			case 4:
				selection = 4;
				break;
			}
			selection = scan.nextInt();
		}
		cart.checkOut();
		scan.close();
		
	}
	
	public static boolean yesNo(String reply) {
		if(reply.toLowerCase().equals("yes")) {
			return true;
		}else if(reply.toLowerCase().equals("no")) {
			return false;
		}
		return false;
	}

}
