package carbonFootprintCalculator;

import java.util.HashMap;
import java.util.Scanner;

public class WasteEmissionsCalculator {
	
	Scanner reader;
	FileWriter writer;
	
	public WasteEmissionsCalculator() {
		reader = new Scanner(System.in);
		writer = new FileWriter();
	}

	public double wasteEmissions() {
		
		System.out.println("Now we will ask you about your waste habits.");
		double wasteEmissions =  692;
		
		System.out.println("We assume that you produce 692 pounds of CO2 per year of waste based on EPA data. Now we will ask you a series of questions about your recycling habits.");
		
		
		int cans = askRecyclingQuestion("cans");	
		wasteEmissions = reduceIfRecycled(cans, 89.38, wasteEmissions);

		
		int plastic = askRecyclingQuestion("plastic");
		wasteEmissions = reduceIfRecycled(plastic, 89.38, wasteEmissions);
		
		
		int glass = askRecyclingQuestion("glass");
		wasteEmissions = reduceIfRecycled(glass, 89.38, wasteEmissions);
		

		int news = askRecyclingQuestion("news");
		wasteEmissions = reduceIfRecycled(news, 89.38, wasteEmissions);
		
		int magazines = askRecyclingQuestion("magazines");
		wasteEmissions = reduceIfRecycled(magazines, 89.38, wasteEmissions);
		
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		emissions.put("wastEmissions", wasteEmissions);
		writer.appendToFile(emissions, "src/carbonFootprintCalculator/calculatorResults.txt");
		
		return wasteEmissions;
	}
	
	
	private int askRecyclingQuestion(String recycledObject) {
		System.out.print(String.format("Do you recycle %s? Type 1 for yes or 2 for no", recycledObject));
		int choice = reader.nextInt();
		
		while(!(choice == 1 || choice == 2)) {
			System.out.println("Please type 1 for yes or 2 for no");
			choice = reader.nextInt();
		}
		
		return choice;
	}
	
	private double reduceIfRecycled(int choice, double amount, double currentTotal) {
		if(choice == 1) {
			currentTotal = currentTotal - amount;
		}
		return currentTotal;
	}
	
}
