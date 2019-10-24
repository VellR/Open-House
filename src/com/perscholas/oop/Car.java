package com.perscholas.oop;

public class Car {
	private String make;
	private String model;
	private int yearBuilt;
	private int miles;
	
	public Car() {
		
	}
	
	public Car(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	public Car(String make, String model, int yearBuilt) {
		this.make = make;
		this.model = model;
		this.yearBuilt = yearBuilt;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	public int getMiles() {
		return miles;
	}
	
	public void driveForward() {
		miles = miles + 10;
	}
	
	public void driveReverse() {
		miles = miles - 10;
	}
	
	public final void finalKeyWordDemo() {
		System.out.println("Final Method Demo.");
	}
	
	
}
