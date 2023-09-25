package com.homework.assignment2;

public class Car {
	
	private int id;
	private String make;
	private String model;
	private int yearOfManufacture;
	private String color;
	private double price;
	private String registrationNumber;
	
	//Constructor
	public Car (int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber ) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.color = color;
		this.price = price;
		this.registrationNumber = registrationNumber;
	}
	
	// Getters for the attributes. No setter have been set because none will be used during implementation.
	public int getId() {
		return id;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	//Overridden the toString method to easily print the car details into the text file.
	@Override
	public String toString() {
		return "Car{" + "Id=" + id + ", Make=" + make + ", Model=" + model + ", Year=" + yearOfManufacture +
	            ", Color=" + color + ", Price=" + price + ", Registration Number=" + registrationNumber + "}";	
	}

}
