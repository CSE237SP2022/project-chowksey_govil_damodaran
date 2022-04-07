package carbonFootprintCalculator;

import java.util.Scanner;

public class CarbonFootPrintCalculator {
	
	WasteEmissionsCalculator wec;
	FlightEmissionsCalculator fec;
	HouseEmissionsCalculator hec;
	CarEmissionsCalculator cec;

	Scanner reader;
	
	public CarbonFootPrintCalculator(){
		
		WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
		HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
		CarEmissionsCalculator cec = new CarEmissionsCalculator();
		FlightEmissionsCalculator fec = new FlightEmissionsCalculator();
		reader = new Scanner(System.in);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to our carbon footprint calculator! Answer a series of questions and you should be able to figure out what your carbon footprint is.");
		
		CarbonFootPrintCalculator cpc = new CarbonFootPrintCalculator();
		
		System.out.println("First we will ask you about your flight travel.");

		double fe = cpc.fec.flightEmissions();
		System.out.println("Now we will ask you about your house energy usage.");
		double he = cpc.hec.houseEmissions();
		double we = cpc.wec.wasteEmissions();
		System.out.print("Your total house emissions is: ");
		System.out.print(he);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.print("Your total emissions from flight is: ");
		System.out.print(fe);
		System.out.print("Your total emissions from waste is: ");
		System.out.print(we);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.println("Now we will ask you about your car emissions.");
		double ce = cpc.cec.carEmissions();
		System.out.print("Your total emissions from car usage is: ");
		System.out.print(ce);
		System.out.print(" pounds of carbon dioxide per year");
		cpc.reader.close();
	}

}
