package carbonFootprintCalculator;

import java.util.Scanner;

public class carbonFootprintCalculator {
	
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

}
