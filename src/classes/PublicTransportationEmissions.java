package classes;

import java.util.HashMap;
import java.util.Scanner;

public class PublicTransportationEmissions {
	
	Scanner reader;
	FileWriterAndReader writer;

	public PublicTransportationEmissions() {
		reader = new Scanner(System.in);
		writer = new FileWriterAndReader();
	}
	
	public double publicTransportEmissions() {
		System.out.println("Now we will ask you about your public transportation energy usage.");
		double busEmissions = busEmissions();
		double taxiEmissions = yellowTaxiEmissions();
		double subwayEmissions = subwayEmissions();
		double motorcycleEmissions = motorcycleEmissions();
		double ferryEmissions = ferryEmissions();
		double rickshawEmissions = rickshawEmissions();
		double totalPublicTransportEmissions = busEmissions + taxiEmissions + subwayEmissions + motorcycleEmissions + ferryEmissions + rickshawEmissions;
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		emissions.put("totalPublicTransportEmissions", totalPublicTransportEmissions);
		writer.appendToFile(emissions, "src/classes/calculatorResults.txt");
		
		return totalPublicTransportEmissions;
		
	}
	
	private double busEmissions() {
		System.out.println("Now we will ask you about your bus emissions.");
		System.out.println("Enter the total kilometers traveled using the bus: ");
		double totalKilometers = reader.nextDouble();
		//first constant is kg CO2 per km per passenger, second constant is converting kg to lbs
		return (0.069*totalKilometers*2.2);
	}
	
	private double yellowTaxiEmissions() {
		System.out.println("Now we will ask you about your yellow taxi emissions.");
		System.out.println("Enter the total kilometers traveled using the yellow taxi: ");
		double totalKilometers = reader.nextDouble();
		return (0.17*totalKilometers*2.2);
	}
	
	private double subwayEmissions() {
		System.out.println("Now we will ask you about your subway emissions.");
		System.out.println("Enter the total kilometers traveled using the subway: ");
		double totalKilometers = reader.nextDouble();
		return (0.065*totalKilometers*2.2);
	}
	
	private double motorcycleEmissions() {
		System.out.println("Now we will ask you about your motorcycle emissions.");
		System.out.println("Enter the total kilometers traveled using the motorcycle: ");
		double totalKilometers = reader.nextDouble();
		return (0.094*totalKilometers*2.2);
	}
	
	private double ferryEmissions() {
		System.out.println("Now we will ask you about your ferry emissions.");
		System.out.println("Enter the total kilometers traveled using the ferry: ");
		double totalKilometers = reader.nextDouble();
		return (0.115*totalKilometers*2.2);
	}
	
	private double rickshawEmissions() {
		System.out.println("Now we will ask you about your rickshaw emissions.");
		System.out.println("Enter the total miles kilometers using the rickshaw: ");
		double totalKilometers = reader.nextDouble();
		return (0.061*totalKilometers*2.2);
	}
}
