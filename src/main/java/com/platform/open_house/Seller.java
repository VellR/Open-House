package com.platform.open_house.servlets;

import java.util.ArrayList;
import java.util.Date;

public class Seller extends User{

	private ArrayList<String> selling = new ArrayList<String>();
	
	public Seller() {
		super();
	}
	
	public Seller(String username, String email, Date birthday, String location, boolean barter) {
		super();
	}
	
	public Seller(String username, String email, Date birthday, String location) {
		super();
	}
	
	public ArrayList<String> selling(){
		return selling;
	}
	
	public void removeFromSells(String item){
		selling.remove(item);
	}
	
	public void addToSells(String item) {
		selling.add(item);
	}
}
