package carbonFootprintCalculator;

import java.util.Scanner;

public class CarbonFootPrintCalculator {
	
	WasteEmissionsCalculator wec;
	Scanner reader;
	
	public CarbonFootPrintCalculator(){
		WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
		reader = new Scanner(System.in);
	}
		
	public double houseEmissions(Scanner reader) {
		
		double houseEmissions = 0.0;

		System.out.println("How much natural gas does your household use per month in dollars?");
		
		double natGasDollars = reader.nextDouble();
		
		
		double natGasEmissions = (natGasDollars/10.68)*119.58*12;
		
		System.out.println("Does your household purchase green power? Enter 1 for yes and 2 for no:");
		
		int greenPower = reader.nextInt();
		
		
		System.out.println("How much electricity does your household use per month in dollars?");
		
		double elecDollars = reader.nextDouble();
		
		double elecEmissions = 0.0;
		
		if(greenPower == 2) {
			// the e_factor is for 63112 missouri zip code
			elecEmissions = (elecDollars/0.1188)*1.820425*12;
		}
		else {
			System.out.println("What portion of your household's total purchased electricity use is green power? Enter a number between 0 and 100");
			double greenPortion = reader.nextDouble();
			elecEmissions = elecEmissions * (1-greenPortion);
		}
		
		System.out.println("How much fuel oil does your household use per month in dollars?");
		
		double fuelOilDollars = reader.nextDouble();
		
		double fuelOilEmissions = (fuelOilDollars/4.02)*22.61*12;
		
		System.out.println("How much propane does your household use per month in dollars?");
		
		double propDollars = reader.nextDouble();
		
		double propEmissions = (propDollars/2.47)*12.43*12;
		
		
		houseEmissions = natGasEmissions + elecEmissions + fuelOilEmissions + propEmissions;
		
		return houseEmissions;
		
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
		double fe = cpc.flightEmissions(cpc.reader);
		System.out.println("Now we will ask you about your house energy usage.");
		double he = cpc.houseEmissions(cpc.reader);
		System.out.println("Now we will ask you about your waste habits.");
		double we = cpc.wec.wasteEmissions(cpc.reader);
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
		System.out.println("Coming soon, questions about your waste and car travel usage.");
		cpc.reader.close();
	}

}
