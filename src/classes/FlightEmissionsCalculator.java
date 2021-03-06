package classes;

import java.util.HashMap;
import java.util.Scanner;
//source: https://co2.myclimate.org/en/flight_calculators/new

public class FlightEmissionsCalculator {

	Scanner flightReader;
	FileWriterAndReader writer;
	
	double passengerLoadFactor = 0.82;
	double detourConstant = 95.0;
	double emissionFactor = 3.15;
	double preproduction = 0.54;
	double multiplier = 2.0;
	double aircraftFactor = 0.00038;
	double airportInfrastructure = 11.68;
	
	//using general averages
	double cargoFactorInverse = 0.835;
	double averageSeatNumber = 216.86;
	double classWeight = 1.21;
	
	public FlightEmissionsCalculator() {
		
		flightReader = new Scanner(System.in);
		writer = new FileWriterAndReader();
	}
	
	public double flightEmissions() {
		
		System.out.println("Now we will ask you about your flight usage.");
		double totalFlightEmissions = 0.0;
		
		double nonLinearModelContribution = HaulTypeHelper();
		double nonClassWeightMContribution = NonClassWeightMultiplicationContribution();
		double nonClassWeightAContribution = NonClassWeightAdditionContribution();
		
		totalFlightEmissions = nonLinearModelContribution/(classWeight*nonClassWeightMContribution+nonClassWeightAContribution);
		
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		emissions.put("flightEmissions", totalFlightEmissions);
		writer.appendToFile(emissions, "src/classes/calculatorResults.txt");
		return totalFlightEmissions;
	}
	
	private double NonClassWeightMultiplicationContribution() {
		
		return ((cargoFactorInverse)*(emissionFactor*multiplier+preproduction)*(1/(averageSeatNumber*passengerLoadFactor)));
	}
	
	private double NonClassWeightAdditionContribution() {
		
		return (aircraftFactor+airportInfrastructure);
	}
	
	
	private double HaulTypeHelper() {
		
		System.out.println("Is the flight short-haul or long-haul? Enter S for short-haul and L for long-haul.");
		String flightType = flightReader.nextLine();
		
		if (flightType.equals("S")) {
			
			return ShortHaulContributionWithNLMModel();
		}
		
		else if (flightType.equals("L")) {
			
			return LongHaulContributionWithNLMModel();
		}
		
		else {
			
			System.out.println("Invalid input, please try running the program again.");
			return 0.0;
		}
	}
	
	private double ShortHaulContributionWithNLMModel() {
		
		System.out.println("Enter your flight distance in kilometers.");
		double flightDistance = flightReader.nextDouble();
		
		double NLModelCoefficientA = 0.0;
		double NLModelCoefficientB = 2.714;
		double NLModelCoefficientC = 1166.52;
		
		return NLMModelContribution(NLModelCoefficientA,NLModelCoefficientB,NLModelCoefficientC, flightDistance);
	}
	
	private double LongHaulContributionWithNLMModel() {
		
		System.out.println("Enter your flight distance in kilometers.");
		double flightDistance = flightReader.nextDouble();
		
		double NLModelCoefficientA = 0.0001;
		double NLModelCoefficientB = 7.104;
		double NLModelCoefficientC = 5044.93;
		
		return NLMModelContribution(NLModelCoefficientA,NLModelCoefficientB,NLModelCoefficientC, flightDistance);
	}
	
	private double NLMModelContribution(double a, double b, double c, double totalFlightDistance) {
		
		return ((a*totalFlightDistance*totalFlightDistance) + (b*totalFlightDistance) + c);
	}
		
}
