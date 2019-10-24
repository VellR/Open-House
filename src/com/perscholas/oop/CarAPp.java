package com.perscholas.oop;

public class CarAPp {

	public static void main(String[] args) {
		Car tesla = new Car();
		
		tesla.setMake("Tesla");
		tesla.setModel("Roadster");
		tesla.setYearBuilt(2020);
		
		System.out.println(tesla.getMake());
		System.out.println(tesla.getModel());
		System.out.println(tesla.getYearBuilt());
		
		System.out.println(tesla.getMiles());
		tesla.driveForward();
		tesla.driveForward();
		System.out.println(tesla.getMiles());
		tesla.driveReverse();
		System.out.println(tesla.getMiles());
		
		Car ford = new Car();
		Car nissan = new Car(2014);
		Car honda = new Car("Honda", "Accord", 2017);
		
		System.out.println(ford.getMake());
		System.out.println(ford.getModel());
		System.out.println(ford.getYearBuilt());
		System.out.println(nissan.getMake());
		System.out.println(nissan.getModel());
		System.out.println(nissan.getYearBuilt());
		System.out.println(honda.getMake());
		System.out.println(honda.getModel());
		System.out.println(honda.getYearBuilt());
		
		ford.setMake("Ford");
		ford.setModel("Fussion");
		ford.setYearBuilt(2012);
		nissan.setMake("Nissan");
		nissan.setModel("Altima");
		System.out.println(ford.getMake());
		System.out.println(ford.getModel());
		System.out.println(ford.getYearBuilt());
		System.out.println(nissan.getMake());
		System.out.println(nissan.getModel());
		System.out.println(nissan.getYearBuilt());
		System.out.println(honda.getMake());
		System.out.println(honda.getModel());
		System.out.println(honda.getYearBuilt());
		
		ForeignCar jaguar = new ForeignCar();
		ForeignCar volvo = new ForeignCar(2020);
		ForeignCar fiat = new ForeignCar("Fiat", "spider", 2020);
		System.out.println(jaguar.getMake());
		System.out.println(jaguar.getModel());
		System.out.println(jaguar.getYearBuilt());
		System.out.println(volvo.getMake());
		System.out.println(volvo.getModel());
		System.out.println(volvo.getYearBuilt());
		System.out.println(fiat.getMake());
		System.out.println(fiat.getModel());
		System.out.println(fiat.getYearBuilt());

	}

}
