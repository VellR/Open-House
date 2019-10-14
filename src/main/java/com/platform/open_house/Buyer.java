package com.platform.open_house.servlets;

import java.util.ArrayList;
import java.util.Date;

public class Buyer extends User {

	private ArrayList<String> request = new ArrayList<String>();
	
	
	public Buyer(String username, String email, Date birthday, String location, boolean barter) {
		super(location, location, birthday, location);
	}
	
	public Buyer(String username, String email, Date birthday, String location) {
		super(location, location, birthday, location);
	}
	
	public ArrayList<String> wants(){
		return request;
	}
	
	public void removeFromWants(String item){
		request.remove(item);
	}
	
	public void addToWants(String item) {
		request.add(item);
	}
	
	
}
