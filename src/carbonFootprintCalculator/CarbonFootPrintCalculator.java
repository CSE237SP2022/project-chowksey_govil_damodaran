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
		reader = new Scanner(System.in);
		
		FlightEmissionsCalculator fec = new FlightEmissionsCalculator();
		reader = new Scanner(System.in);
		
	}
		
	
	public double flightEmissions(Scanner reader) {
		
		//source: https://co2.myclimate.org/en/flight_calculators/new
		
		double flightEmissions = 0.0;
		double classWeight = 1.0;
		
		
		System.out.println("Is the flight short-haul or long-haul? Enter S for short-haul and L for long-haul. This will largely determine the total flight carbon emission.");
		
		String flightType = reader.nextLine();
		
		System.out.println("Enter your cabin class type: economy (enter E), business (enter B), or first class (enter F).");
	
		String cabinClass = reader.nextLine();
		
		System.out.println("Enter your flight distance in kilometers.");
		
		double flightDistance = reader.nextDouble();
		
		if (cabinClass.equals("E")) {
			
			classWeight = 0.96;
		}
		
		else if (cabinClass.equals("B")) {
			
			classWeight = 1.26;
		}
		
		else if (cabinClass.equals("F")) {
			
			classWeight = 2.40;
		}
		
		if (flightType.equals("S")) {
			
			double cargoFactorInverse = 0.93;
			double averageSeatNumber = 153.51;
			double passengerLoadFactor = 0.82;
			double detourConstant = 95.0;
			double emissionFactor = 3.15;
			double preproduction = 0.54;
			double multiplier = 2.0;
			double aircraftFactor = 0.00038;
			double airportInfrastructure = 11.68;
			
			flightEmissions = flightDistance*(cargoFactorInverse)*(classWeight)*(emissionFactor*multiplier+preproduction)+aircraftFactor+airportInfrastructure;
		}
		
		else if (flightType.equals("L")) {
			
			double cargoFactorInverse = 0.74;
			double averageSeatNumber = 280.21;
			double passengerLoadFactor = 0.82;
			double detourConstant = 95.0;
			double emissionFactor = 3.15;
			double preproduction = 0.54;
			double multiplier = 2.0;
			double aircraftFactor = 0.00038;
			double airportInfrastructure = 11.68;
			
			flightEmissions = flightDistance*(cargoFactorInverse)*(classWeight)*(emissionFactor*multiplier+preproduction)+aircraftFactor+airportInfrastructure;
			
		}
		
		else {
			
			System.out.println("Invalid input, please try running the program again.");
		}
		
		
		return flightEmissions;
	}
	
	public double carEmissions() {
		
		double carEmissions = 0.0;
		
		Scanner reader = new Scanner(System.in); 
		
		//specific car calculations go here
		
		
		reader.close();
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to our carbon footprint calculator! Answer a series of questions and you should be able to figure out what your carbon footprint is.");
		
		CarbonFootPrintCalculator cpc = new CarbonFootPrintCalculator();
		
		System.out.println("First we will ask you about your flight travel.");

		double fe = cpc.fec.flightEmissions();
		System.out.println("Now we will ask you about your house energy usage.");
		double he = cpc.houseEmissions(cpc.reader);
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
