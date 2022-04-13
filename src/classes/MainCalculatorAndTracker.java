package classes;

import java.util.Scanner;

public class MainCalculatorAndTracker {

	public static void main(String[] args) {
		
		System.out.println("Welcome to our carbon footprint calculator and tracker.");
		System.out.println("Press 1 to go to our carbon footprint calculator. Press 2 to go to our recommendation section. Press 3 to go to our tracker.");
		
		Scanner reader = new Scanner(System.in);
		int choice = reader.nextInt();
		
		
		if(choice == 1) {
			CarbonFootPrintCalculator cfp = new CarbonFootPrintCalculator();
			cfp.runCalculator();
		}
		else if(choice == 2) {
			Recommendation r = new Recommendation();
			r.recommend();
		}
		else if(choice == 3) {
			Tracker t = new Tracker();
		}
	}

}
