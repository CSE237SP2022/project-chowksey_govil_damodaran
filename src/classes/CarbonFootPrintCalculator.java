package classes;

import java.util.Scanner;

public class CarbonFootPrintCalculator {
	
	WasteEmissionsCalculator wec;
	FlightEmissionsCalculator fec;
	HouseEmissionsCalculator hec;
	CarEmissionsCalculator cec;

	Scanner reader;
	
	public CarbonFootPrintCalculator(){
		
		wec = new WasteEmissionsCalculator();
		hec = new HouseEmissionsCalculator();
		cec = new CarEmissionsCalculator();
		fec = new FlightEmissionsCalculator();
		reader = new Scanner(System.in);
		
	}
	
	public void runCalculator() {
		System.out.println("Welcome to our carbon footprint calculator! Answer a series of questions and you should be able to figure out what your carbon footprint is.");
		double he = hec.houseEmissions();
		System.out.println("First we will ask you about your flight travel.");
		double fe = fec.flightEmissions();
		double we = wec.wasteEmissions();
		System.out.println("Now we will ask you about your car emissions.");
		double ce = cec.carEmissions();
		System.out.print("Your total house emissions is: ");
		System.out.println(he);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.print("Your total emissions from flight is: ");
		System.out.println(fe);
		System.out.println("Your total emissions from waste is: ");
		System.out.println(we);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		
		System.out.println("Your total emissions from car usage is: ");
		System.out.print(ce);
		System.out.print(" pounds of carbon dioxide per year");

	}

}
