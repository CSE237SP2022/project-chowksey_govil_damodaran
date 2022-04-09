package recommendation;

import java.util.HashMap;
import java.util.Scanner;

import carbonFootprintCalculator.CarbonFootPrintCalculator;

public class Recommendation {
	
	Scanner reader;
	CarbonFootprintCalculatorRecommendations calcRecs;
	
	public Recommendation() {
		calcRecs = new CarbonFootprintCalculatorRecommendations();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to our recommendation section. Please choose one of the following:");
		System.out.println("(1) - Recommendations based on your carbon footprint. Note: Please have completed the Carbon Footprint Calculator first");
		System.out.println("(2) - Take some pledges to reduce your carbon footprint");
		
		Recommendation r = new Recommendation();
		
		r.calcRecs.getRecommendation();
		
		
	}

}
