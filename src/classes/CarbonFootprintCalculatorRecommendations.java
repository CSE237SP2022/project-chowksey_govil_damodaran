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
			return sendRecommendationMessageWrapper(2243, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("natGasEmissions")) {
			return sendRecommendationMessageWrapper(3071, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("fuelOilEmissions")) {
			return sendRecommendationMessageWrapper(4848, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("elecGasEmissions")) {
			return sendRecommendationMessageWrapper(5455, amount, typeOfEmission);
		}		
		else if(typeOfEmission.equals("houseEmissions")) {
			return sendRecommendationMessageWrapper(15617, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("wasteEmissions")) {
			return sendRecommendationMessageWrapper(19702, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("flightEmissions")) {
			return sendRecommendationMessageWrapper(11905, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("carEmissions")) {
			return sendRecommendationMessageWrapper(10141, amount, typeOfEmission);
		}
		return 0;
	}
	
	private int sendRecommendationMessageWrapper(double average, double amount, String typeOfEmission) {
		double limit = average * 1.15; // 1.15 is a buffer
		if(amount >= limit) {
			sendRecommendationMessage(typeOfEmission, average, amount);
			return 1;
		}
		return 0;	
	}
	
	private int sendRecommendationMessageWrapper(double average, double amount, String typeOfEmission) {
		double limit = average * 1.15; // 1.15 is a buffer
		if(amount >= limit) {
			sendRecommendationMessage(typeOfEmission, average, amount);
			return 1;
		}
		return 0;
	}
	
	/*
	
	private int compareEnergyAmounts(String typeOfEmission, double amount) {
		if(typeOfEmission.equals("propEmissions")) {
			return sendRecommendationMessageWrapper(2243, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("natGasEmissions")) {
			return sendRecommendationMessageWrapper(3071, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("fuelOilEmissions")) {
			return sendRecommendationMessageWrapper(4848, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("elecGasEmissions")) {
			return sendRecommendationMessageWrapper(5455, amount, typeOfEmission);
		}		
		else if(typeOfEmission.equals("houseEmissions")) {
			return sendRecommendationMessageWrapper(15617, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("wasteEmissions")) {
			return sendRecommendationMessageWrapper(19702, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("flightEmissions")) {
			return sendRecommendationMessageWrapper(11905, amount, typeOfEmission);
		}
		else if(typeOfEmission.equals("carEmissions")) {
			return sendRecommendationMessageWrapper(10141, amount, typeOfEmission);
		}
		return 0;
	}
	*/
	private void sendRecommendationMessage(String typeOfEmission, double average, double amount) {
		double percentageDifference = (amount - average)/((amount+average)/2) * 100;
		System.out.println();
		System.out.println("Your " + typeOfEmission + " is at " + amount + " pounds of carbon dioxide per year.");
		System.out.println("The average person nationally only produces " + average + " pounds of carbon dioxide per year from " + typeOfEmission + ".");
		System.out.println("You are producing " + percentageDifference + "% more pounds of carbon dioxide per year from " + typeOfEmission + ".");
		System.out.println("This is somewhere where you can reduce your carbon footprint.");
		
	}

	
}
