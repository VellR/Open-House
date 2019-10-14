package com.platform.open_house.servlets;

import java.util.ArrayList;
import java.util.Date;

public class Seller extends User{

	private ArrayList<String> selling = new ArrayList<String>();
	int Id;
	
	public Seller(String username, String email, Date birthday, String location, boolean barter) {
		super(location, location, birthday, location, barter);
	}
	
	public Seller(String username, String email, Date birthday, String location) {
		super(location, location, birthday, location);
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
	
	public int getId() {
		return this.Id;
	}
}
