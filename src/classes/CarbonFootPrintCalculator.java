package classes;

import java.util.Scanner;

public class CarbonFootPrintCalculator {
	
	WasteEmissionsCalculator wec;
	FlightEmissionsCalculator fec;
	HouseEmissionsCalculator hec;
	CarEmissionsCalculator cec;
	PublicTransportationEmissions ptc;

	Scanner reader;
	
	public CarbonFootPrintCalculator(){
		
		wec = new WasteEmissionsCalculator();
		hec = new HouseEmissionsCalculator();
		cec = new CarEmissionsCalculator();
		fec = new FlightEmissionsCalculator();
		ptc = new PublicTransportationEmissions();
		reader = new Scanner(System.in);
		
	}
	
	public void runCalculator() {
		System.out.println("Welcome to our carbon footprint calculator! Answer a series of questions and you should be able to figure out what your carbon footprint is.");
		double he = hec.houseEmissions();
		System.out.println("We will ask you about your flight travel.");
		double fe = fec.flightEmissions();
		double we = wec.wasteEmissions();
		System.out.println("Now we will ask you about your car emissions.");
		double ce = cec.carEmissions();
		System.out.println("Now we will ask you about your public transport usage.");
		double pte = ptc.publicTransportEmissions();
		displayCarbonFootprint(he,fe,we,ce,pte);

	}
	
	private void displayCarbonFootprint(double he, double fe, double we, double ce, double pte) {
		System.out.print("Your total house emissions is: ");
		System.out.println(he);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.print("Your total emissions from flight is: ");
		System.out.println(fe);
		System.out.println("Your total emissions from waste is: ");
		System.out.println(we);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.println("Your total emissions from public transportation is: ");
		System.out.println(pte);
		System.out.print(" pounds of carbon dioxide per year");
		System.out.println();
		System.out.println("Your total emissions from car usage is: ");
		System.out.print(ce);
		System.out.print(" pounds of carbon dioxide per year");
		displayBreakdown( he, fe, we, ce, pte);
	}
	
	private void displayBreakdown(double he, double fe, double we, double ce, double pte) {
		double totalEmissions = he + fe + we + ce + pte;
		double houseEmissionsPercentage = (he/totalEmissions)*100;
		double flightEmissionsPercentage = (fe/totalEmissions)*100;
		double wasteEmissionsPercentage = (we/totalEmissions)*100;
		double carEmissionsPercentage = (ce/totalEmissions)*100;
		double ptEmissionsPercentage = (pte/totalEmissions)*100;
		System.out.println();
		System.out.println("Your house emissions makes up " + houseEmissionsPercentage + "% of your total emissions.");
		System.out.println("Your flight emissions makes up " + flightEmissionsPercentage + "% of your total emissions.");
		System.out.println("Your waste emissions makes up " + wasteEmissionsPercentage + "% of your total emissions.");
		System.out.println("Your car emissions makes up " + carEmissionsPercentage + "% of your total emissions.");
		System.out.println("Your public transport emissions makes up " + ptEmissionsPercentage + "% of your total emissions.");
	}

}
