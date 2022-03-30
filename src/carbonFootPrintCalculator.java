package carbonFootprintCalculator;

import java.util.Scanner;

public class CarbonFootPrintCalculator {
		
		public double houseEmissions() {
			
			double houseEmissions = 0.0;
			
			Scanner reader = new Scanner(System.in); 
			
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
			
			reader.close();
			
			houseEmissions = natGasEmissions + elecEmissions + fuelOilEmissions + propEmissions;
			
			return houseEmissions;
			
		}
		
		public double flightEmissions() {
			
			//source: https://co2.myclimate.org/en/flight_calculators/new
			
			double flightEmissions = 0.0;
			double classWeight = 1.0;
			
			Scanner reader = new Scanner(System.in); 
			
			System.out.println("Is the flight short-haul or long-haul? Enter S for short-haul and L for long-haul. This will largely determine the total flight carbon emission.");
			
			String flightType = reader.nextLine();
			
			System.out.println("Enter your cabin class type: economy (enter E), business (enter B), or first class (enter F).");
		
			String cabinClass = reader.nextLine();
			
			if (cabinClass.equals("E")) {
				
				classWeight = 0.96;
			}
			
			if (cabinClass.equals("B")) {
				
				classWeight = 1.26;
			}
			
			if (cabinClass.equals("F")) {
				
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
				
				flightEmissions = (cargoFactorInverse)*(classWeight)*(emissionFactor*multiplier+preproduction)+aircraftFactor+airportInfrastructure;
			}
			
			if (flightType.equals("R")) {
				
				double cargoFactorInverse = 0.74;
				double averageSeatNumber = 280.21;
				double passengerLoadFactor = 0.82;
				double detourConstant = 95.0;
				double emissionFactor = 3.15;
				double preproduction = 0.54;
				double multiplier = 2.0;
				double aircraftFactor = 0.00038;
				double airportInfrastructure = 11.68;
				
				flightEmissions = (cargoFactorInverse)*(classWeight)*(emissionFactor*multiplier+preproduction)+aircraftFactor+airportInfrastructure;
				
			}
			
			else {
				
				System.out.println("Invalid input, please try running the program again.");
			}
			
			reader.close();
			
			return flightEmissions;
		}
		
		public double carEmissions() {
			
			double carEmissions = 0.0;
			
			Scanner reader = new Scanner(System.in); 
			
			//specific car calculations go here
			
			
			reader.close();
			
			return 0;
		}
	
}
