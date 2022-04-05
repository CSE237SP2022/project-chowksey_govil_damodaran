package carbonFootprintCalculator;

import java.util.Scanner;

public class CarEmissionsCalculator {

	Scanner carReader;
	double weeksInAYear = 52.0;
	
	public CarEmissionsCalculator() {
		
		carReader = new Scanner(System.in);
	}
		
	public double carEmissions() {

		System.out.println("Now we will ask you about your car energy usage.");
		
		double carEmissions = 0.0;
		int numCars = numberOfCars();
		double averageDrivingMiles = averageMilesDrivenPerWeek();
		double averageFuelEconomy = averageHouseholdFuelEconomy();
		double averageCarbonFuelEmissions = averagePoundsOfCarbonPerGallon();
		
		carEmissions = numCars*((averageDrivingMiles*weeksInAYear)/(averageFuelEconomy*averageCarbonFuelEmissions));
	
		return carEmissions;
	}
	
	private int numberOfCars() {
		
		System.out.println("How many cars does your household have?");
		int totalCars = carReader.nextInt();
		return totalCars;
	}
	
	private double averageMilesDrivenPerWeek() {
		
		System.out.println("On average, how many miles do you drive one car per week?");
		double averageMiles = carReader.nextDouble();
		return averageMiles;
	}

	private double averageHouseholdFuelEconomy() {
		
		System.out.println("On average, what is the fuel economy of your vehicles? Typical values lie between 17.8 and 25.4 miles per gallon.");
		double averageFuelEconomy = carReader.nextDouble();
		return averageFuelEconomy;
	}
	
	private double averagePoundsOfCarbonPerGallon() {
		
		System.out.println("On average, how many pounds of carbon dioxide are emitted per gallon of fuel that you use? Typical values lie between 14.0 and 16.0 pounds.");
		double averagePoundsOfCarbonPerGallon = carReader.nextDouble();
		return averagePoundsOfCarbonPerGallon;
	}

}
