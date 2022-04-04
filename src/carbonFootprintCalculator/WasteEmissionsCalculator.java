package carbonFootprintCalculator;

import java.util.Scanner;

public class WasteEmissionsCalculator {
	
	public WasteEmissionsCalculator() {
		
	}

	public double wasteEmissions(Scanner reader) {		
		double wasteEmissions =  692;
		
		System.out.println("We assume that you produce 692 pounds of CO2 per year of waste based on EPA data. Now we will ask you a series of questions about your recycling habits.");
		
		
		int cans = askRecyclingQuestion("cans", reader);	
		wasteEmissions = reduceIfRecycled(cans, 89.38, wasteEmissions);

		
		int plastic = askRecyclingQuestion("plastic", reader);
		wasteEmissions = reduceIfRecycled(plastic, 89.38, wasteEmissions);
		
		
		int glass = askRecyclingQuestion("glass", reader);
		wasteEmissions = reduceIfRecycled(glass, 89.38, wasteEmissions);
		

		int news = askRecyclingQuestion("news", reader);
		wasteEmissions = reduceIfRecycled(news, 89.38, wasteEmissions);
		
		int magazines = askRecyclingQuestion("magazines", reader);
		wasteEmissions = reduceIfRecycled(magazines, 89.38, wasteEmissions);
		
		return wasteEmissions;
	}
	
	
	public int askRecyclingQuestion(String recycledObject, Scanner reader) {
		System.out.print(String.format("Do you recycle %s? Type 1 for yes or 2 for no", recycledObject));
		int choice = reader.nextInt();
		
		while(!(choice == 1 || choice == 2)) {
			System.out.println("Please type 1 for yes or 2 for no");
			choice = reader.nextInt();
		}
		
		return choice;
	}
	
	public double reduceIfRecycled(int choice, double amount, double currentTotal) {
		if(choice == 1) {
			currentTotal = currentTotal - amount;
		}
		return currentTotal;
	}
	
}
