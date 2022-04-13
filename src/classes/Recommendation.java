package classes;

import java.util.HashMap;
import java.util.Scanner;

public class Recommendation {
	
	Scanner reader;
	CarbonFootprintPledgeSection pledgeVariable;
	CarbonFootprintCalculatorRecommendations calcRecs;
	
	public Recommendation() {
		
		pledgeVariable = new CarbonFootprintPledgeSection();
		calcRecs = new CarbonFootprintCalculatorRecommendations();
	}
	
	public void recommend() {
		System.out.println("Welcome to our recommendation section. Please choose one of the following:");
		System.out.println("(1) - Recommendations based on your carbon footprint. Note: Please have completed the Carbon Footprint Calculator first");
		System.out.println("(2) - Take some pledges to reduce your carbon footprint");
		
		Scanner reader = new Scanner(System.in);
		int choice = reader.nextInt();
		
		if(choice == 1) {
			Recommendation r = new Recommendation();
			r.calcRecs.getRecommendation();
		}
		else if(choice == 2) {
			Recommendation p = new Recommendation();
			p.pledgeVariable.mainPledgeMethod();
		}
		
	}

}
