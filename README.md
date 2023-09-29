# Homework Assignment 2
Matriculation Number: 7218924 <br />
GitHub Link: https://github.com/haarsh85/homework-assignment-2.git

# Development Environment:
- java 20.0.2 2023-07-18
Java(TM) SE Runtime Environment (build 20.0.2+9-78)
Java HotSpot(TM) 64-Bit Server VM (build 20.0.2+9-78, mixed mode, sharing)

-	IDE
Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
Version: 2023-06 (4.28.0)

# Solution Description
This project has 02 classes namely `Cars.java` and `FilterCarsAndSave.java`. The contents are explained below;

Cars.java
- Code is packaged for better organization.
- Created class Car using the respective attributes.
- Created Constructor using the given attributes as parameteres.
- Added necessary getters to get the values during the implementation. No setters were used since objects will not be changed after creation.
- Overridden the `toString()` method to simplify printing the Car details into the text files later on.

FilterCarsAndSave.java
- This has the main method, which is used to run the code.
- Imported necessary classes from `java.io` and `java.util` to be used within the code.
- Created an array to hold 05 Car objects and created 05 Car objects. The current objects are as follows;

| Id | Make  | Model  | Year of Manufacture | Color | Price    | Registration Number |
|---:|-------|--------|---------------------|-------|----------|---------------------|
|   1| BMW   | M3     | 2013                | Black | 25,000.00| ABC123              |
|   2| Toyota| Corolla| 1966                | Silver| 20,000.00| DEF456              |
|   3| Toyota| Prius  | 1997                | White | 22,000.00| GHI789              |
|   4| Honda | Civic  | 2000                | Red   | 30,000.00| JKL321              |
|   5| Audi  | R8     | 2023                | Red   | 35,000.00| MNO654              |

- User is given 03 options to select (a / b / c). In order to filter and save the results, user should enter desired option in lower case. Otherwise, it says "Invalid option entered". The code has 03 filtering methods which will run based on the user's input.

Options:
```
Select filtering criteria from below options (Select options a, b or c): 
a) Brand
b) Model and Minimum Years in Use
c) Year of Manufacture and Minimum Price
Please enter an option: 
```
- The processing for each option is done by a dedicated filtering method.
  - Method to filter cars by brand (filterCarsAndSaveByBrand)
    - This method takes Car array and brand as input parameters.
    - New empty ArrayList named `filteredCars` is created to add the filtered results.
    - If any Car object's make matches with given brand it is added to the filteredCars.
    - If no matches found, gives no cars found message.
    - Finally, the results are saved to a file called `FilteredCarsByBrand.txt`using a seperate method which is explained later. The file is saved in the same directory where you have the code.

  - Method to filter cars by Model and Minimum Years in Use (filterCarsAndSaveByModelAndYearsInUse)
    - This method takes Car array, model and years in use as input parameteres.
    - New empty ArrayList named `filteredCars` is created to add the filtered results.
    - Current year is specified as 2023 for comparison later.
    - If any Car object matches with given model and year of manufacture greater than the user entered number of years, it is added to the filteredCars array.
    - If no matches found, gives no cars found message.
    - Finally, the results are saved to a file called `FilteredCarsByModelAndYearsInUse.txt` using a seperate method which is explained later. The file is saved in the same directory where you have the code.
   
  - Method to filter cars by year of manufacture and the price (filterCarsAndSaveByYearAndPrice)
    - This method takes Car array, year and price as input parameteres.
    - New empty ArrayList named `filteredCars` is created to add the filtered results.
    - If any car object matches with given year of manufacture and has a price greater than user entered price, it is added to the filteredCars array.
    - If no matches found, gives no cars found message.
    - Finally, the results are saved to a file called `FilteredCarsByYearAndPrice.txt` using a seperate method which is explained later. The file is saved in the same directory where you have the code.
   
  - Method to save result to a text file (saveCarsToFile)
    - This method takes List of cars and file name as input parameteres.
    - It will try to iterate through the list of cars and write the car object's details into a text file.
    - The text file is saved into the same directory as where you have the code.
    - If saved successfully, it will display a message with number of cars saved and file name. 

## Output
Option 1: Input Option: a, Input brand: toyota --> 02 cars macthed with the condition and result is saved to `FilteredCarsByBrand.txt` file.
```
Select filtering criteria from below options (Select options a, b or c): 
a) Brand
b) Model and Minimum Years in Use
c) Year of Manufacture and Minimum Price
Please enter an option: a
Enter the Brand to Filter: toyota
Saved 2 cars to FilteredCarsByBrand.txt
```
The `FilteredCarsByBrand.txt` file contents are as below;
```
Car{Id=2, Make=Toyota, Model=Corolla, Year=1966, Color=Silver, Price=20000.0, Registration Number=DEF456}
Car{Id=3, Make=Toyota, Model=Prius, Year=1997, Color=White, Price=22000.0, Registration Number=GHI789}
```

Option 2: Input Option: b, Input model: yaris, Input minimum years in use: 10 --> No cars are matched with both conditions. No file is saved.
```
Select filtering criteria from below options (Select options a, b or c): 
a) Brand
b) Model and Minimum Years in Use
c) Year of Manufacture and Minimum Price
Please enter an option: b
Enter the Model to Filter: yaris
Enter the Minimum Years in Use: 10
Sorry, No cars found for model yaris and in use for more than 10 years.
```

Option 3: Input Option: c, Input year of manufacture: 2000, Input minimum price = 10000 --> 01 car is matched with both conditions and result is saved to `FilteredCarsByYearAndPrice.txt` file.
```
Select filtering criteria from below options (Select options a, b or c): 
a) Brand
b) Model and Minimum Years in Use
c) Year of Manufacture and Minimum Price
Please enter an option: c
Enter the Year of Manufacture to Filter: 2000
Enter the Minimum Price: 10000
Saved 1 cars to FilteredCarsByYearAndPrice.txt
```
The `FilteredCarsByYearAndPrice.txt` file contents are as below;
```
Car{Id=4, Make=Honda, Model=Civic, Year=2000, Color=Red, Price=30000.0, Registration Number=JKL321}
```
