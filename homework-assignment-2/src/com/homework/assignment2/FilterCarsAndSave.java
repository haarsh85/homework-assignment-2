package com.homework.assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterCarsAndSave {
	
	public static void main(String[] args) {
		
		//Create an array of car objects. It is initialized to hold 5 car objects.
		Car[] cars = new Car[5];
		cars[0] = new Car(1, "BMW", "M3", 2013, "Black", 25000.00, "ABC123");
		cars[1] = new Car(2, "Toyota", "Corolla", 1966, "Silver", 20000.00, "DEF456");
		cars[2] = new Car(3, "Toyota", "Prius", 1997, "White", 22000.00, "GHI789");
		cars[3] = new Car(4, "Honda", "Civic", 2000, "Red", 30000.00, "JKL321");
		cars[4] = new Car(5, "Audi", "R8", 2023, "Red", 35000.00, "MNO654");
		
		//Options for filtering the results
		System.out.println("Select filtering criteria from below options (Select options a, b or c): ");
		System.out.println("a) Brand");
		System.out.println("b) Model and Minimum Years in Use");
		System.out.println("c) Year of Manufacture and Minimum Price");
		System.out.print("Please enter an option: ");
		
		//Create scanner object to get the user input
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
				
		//Filter by Brand
		if(option.equals("a")) {
			System.out.print("Enter the Brand to Filter: ");
			String brandToFilter = scanner.nextLine();	
			filterCarsAndSaveByBrand(cars, brandToFilter);
		}
		
		//Filter by Model and Years in Use
		else if(option.equals("b")) {
			System.out.print("Enter the Model to Filter: ");
            String modelToFilter = scanner.nextLine();
            System.out.print("Enter the Minimum Years in Use: ");
            int yearsInUse = scanner.nextInt();
            filterCarsAndSaveByModelAndYearsInUse(cars, modelToFilter, yearsInUse);
		}
		
		//Filter by Year of Manufacture and Given Price
		else if(option.equals("c")) {
			System.out.print("Enter the Year of Manufacture to Filter: ");
			int manufactureYear = scanner.nextInt();
			System.out.print("Enter the Minimum Price: ");
			double minimumPrice = scanner.nextDouble();
			filterCarsAndSaveByYearAndPrice(cars, manufactureYear, minimumPrice);	
		}
		
		else {
			System.out.println("Invalid option entered. Please enter option a, b or c");
		}
		scanner.close();
	}
	
	//Filter cars based on the brand
	public static void filterCarsAndSaveByBrand(Car[] cars, String brand) {
		List<Car> filteredCars = new ArrayList<>();
		for (int i = 0; i < cars.length; i++) {
			Car car = cars[i];
			
			if(car.getMake().equalsIgnoreCase(brand)) {
				filteredCars.add(car);
			}
		}
		if (filteredCars.isEmpty()) {
			System.out.println("Sorry, No cars found for the brand "+ brand + ".");
		}
		else {
			saveCarsToFile(filteredCars, "FilteredCarsByBrand.txt");
		}
	}
	
	//Filter cars based on model and years in use
	public static void filterCarsAndSaveByModelAndYearsInUse(Car[] cars, String model, int yearsInUse) {
		List<Car> filteredCars = new ArrayList<>();
		int currentYear = 2023;
		for (int i = 0; i < cars.length; i++) {
			Car car = cars[i];
			
			if(car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture() > yearsInUse)) {
				filteredCars.add(car);
			}
		}
		if (filteredCars.isEmpty()) {
			System.out.println("Sorry, No cars found for model "+ model + " and in use for more than " + yearsInUse + " years.");
		}
		else {
			saveCarsToFile(filteredCars, "FilteredCarsByModelAndYearsInUse.txt");
		}
	}
	
	//Filter cars based on year of manufacture and given price 
	public static void filterCarsAndSaveByYearAndPrice(Car[] cars, int year, double givenPrice) {
		List<Car> filteredCars = new ArrayList<>();
		for (int i = 0; i < cars.length; i++) {
			Car car = cars[i];
			
			if(car.getYearOfManufacture() == year && car.getPrice() > givenPrice) {
				filteredCars.add(car);
			}
		}
		if (filteredCars.isEmpty()) {
			System.out.println("Sorry, No cars found for year of manufacturer " + year + " and price higher than " + givenPrice + ".");
		}
		else {
			saveCarsToFile(filteredCars, "FilteredCarsByYearAndPrice.txt");
		}
	}
	
	//Save Cars to files
	public static void saveCarsToFile(List<Car> cars, String fileName) {
		
		try {
			FileWriter writer = new FileWriter(fileName);
			
			for(int i=0; i < cars.size(); i++) {
				Car car = cars.get(i);
				writer.write(car.toString()+"\n");
			}
			writer.close();
			System.out.println("Saved " + cars.size() + " cars to " + fileName);
			System.out.println("File Saved Path: " + new File(fileName).getAbsolutePath() );	
		} catch (IOException e) {
			System.err.println("Error saving cars to " + fileName);
			e.printStackTrace();
		}
	}

}