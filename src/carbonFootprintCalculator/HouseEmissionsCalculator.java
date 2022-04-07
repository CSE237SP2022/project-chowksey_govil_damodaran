package carbonFootprintCalculator;

import java.util.Scanner;

public class HouseEmissionsCalculator {
	
	Scanner reader;
	
	public HouseEmissionsCalculator() {
		reader = new Scanner(System.in);
	}
	
	public double houseEmissions() {
		System.out.println("Now we will ask you about your house energy usage.");
		
		double houseEmissions = 0.0;
		
		double natGasEmissionValue = natGasEmissions();
		
		double elecEmissionValue = elecEmissions();

		double fuelOilEmissionValue = fuelOilEmissions();

		double propEmissionValue = propEmissions();

		houseEmissions = natGasEmissionValue + elecEmissionValue + fuelOilEmissionValue + propEmissionValue;
		return houseEmissions;
		
	}
	
	private double propEmissions() {
		System.out.println("How much propane does your household use per month in dollars?");
		
		double propDollars = reader.nextDouble();
		
		double propEmissionValue = (propDollars/2.47)*12.43*12;
		return propEmissionValue;
	}

	private double fuelOilEmissions() {
		System.out.println("How much fuel oil does your household use per month in dollars?");
		
		double fuelOilDollars = reader.nextDouble();
		
		double fuelOilEmissionValue = (fuelOilDollars/4.02)*22.61*12;
		return fuelOilEmissionValue;
	}

	private double elecEmissions() {
		System.out.println("Does your household purchase green power? Enter 1 for yes and 2 for no:");
		
		int greenPower = reader.nextInt();
		
		System.out.println("How much electricity does your household use per month in dollars?");
		
		double elecDollars = reader.nextDouble();
		
		double elecEmissions = 0.0;
		
		// the e_factor is for 63112 missouri zip code
		elecEmissions = (elecDollars/0.1188)*1.820425*12;
		
		if(greenPower == 1) {
			System.out.println("What portion of your household's total purchased electricity use is green power? Enter a number between 0 and 100");
			double greenPortion = reader.nextDouble();
			elecEmissions = elecEmissions * (100-greenPortion)/100;
		}
		
		return elecEmissions;
	}

	private double natGasEmissions() {
		System.out.println("How much natural gas does your household use per month in dollars?");
		
		double natGasDollars = reader.nextDouble();
		
		double natGasEmissionValue = (natGasDollars/10.68)*119.58*12;
		
		return natGasEmissionValue;
	}

}
