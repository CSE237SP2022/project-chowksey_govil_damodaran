package classes;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class CarbonFootprintCalculatorRecommendations {
	
	Scanner reader;
	FileWriterAndReader writer;
	public CarbonFootprintCalculatorRecommendations() {
		reader = new Scanner(System.in);
		writer = new FileWriterAndReader();
	}
	
	public int getRecommendation() {
		System.out.println("We will make recommendations on how you can reduce your carbon footprint based on your most recent carbon footprint calculator results. ");
		
		File tempFile = new File("src/classes/calculatorResults.txt");
		boolean exists = tempFile.exists();
		if(exists == false) {
			System.out.println("You have no results from the carbon footprint calculator. Please fill out the calculator first and then come back.");
			return 0;
		}
		
		HashMap<String, Double> emissions = writer.readFile("src/classes/calculatorResults.txt");
		int counter  = 0;
		for (String i : emissions.keySet()) {
			counter += compareEnergyAmounts(i, emissions.get(i));
		}
		return counter;
	}
	
	
	private int compareEnergyAmounts(String typeOfEmission, double amount) {
		if(typeOfEmission.equals("propEmissions")) {
			double limit = 2243 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 2243, amount);
				return 1;
			}
		}
		else if(typeOfEmission.equals("natGasEmissions")) {
			double limit = 3071 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 3071, amount);
				return 1;
			}
		}
		else if(typeOfEmission.equals("fuelOilEmissions")) {
			double limit = 4848 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 4848, amount);
				return 1;
			}
		}
		else if(typeOfEmission.equals("elecGasEmissions")) {
			double limit = 5455 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 5455, amount);
				return 1;
			}
		}
				
		else if(typeOfEmission.equals("houseEmissions")) {
			double limit = 15617 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 15617, amount);
				return 1;
			}
		}
		
		else if(typeOfEmission.equals("wasteEmissions")) {
			double limit = 19702 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 19702, amount);
				return 1;
			}
		}
		else if(typeOfEmission.equals("flightEmissions")) {
			double limit = 11905 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 11905, amount);
				return 1;
			}
		}
		
		else if(typeOfEmission.equals("carEmissions")) {
			double limit = 10141 * 1.15;
			if(amount >= limit) {
				sendRecommendationMessage(typeOfEmission, 10141, amount);
				return 1;
			}
		}
		return 0;

		
	}

	private void sendRecommendationMessage(String typeOfEmission, double average, double amount) {
		double percentageDifference = (amount - average)/((amount+average)/2) * 100;
		System.out.println();
		System.out.println("Your " + typeOfEmission + " is at " + amount + " pounds of carbon dioxide per year.");
		System.out.println("The average person nationally only produces " + average + " pounds of carbon dioxide per year from " + typeOfEmission + ".");
		System.out.println("You are producing " + percentageDifference + "% more pounds of carbon dioxide per year from " + typeOfEmission + ".");
		System.out.println("This is somewhere where you can reduce your carbon footprint.");
		
	}
	
}
