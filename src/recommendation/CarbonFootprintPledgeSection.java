package recommendation;

import java.util.Scanner;

public class CarbonFootprintPledgeSection {
	
	Scanner reader;

	public CarbonFootprintPledgeSection() {
		
		reader = new Scanner(System.in);
	}
	
	public void mainPledgeMethod() {
		
		System.out.println("Here you will read, assess, and take several pledges regarding your carbon emissions.");
		housePledge();
		carPledge();
		wastePledge();
		flightPledge();
	}
	
	private void housePledge() {
		
		System.out.println("Here is the House Pledge section.");
		
		System.out.println("You should turn down your households heating thermostat on winter nights.");
		System.out.println("By how many degress Fahrenheit do you pledge to reduce the temperature of your households heating thermostat?");
		double tempReduce = reader.nextDouble();
		if (tempReduce > 0.0) {
			System.out.println("Great!");
		}
		else {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		
		System.out.println("You should wash your clothes in cold water instead of hot water. Will you do this? Enter 0 for no and 1 for yes.");
		int wc = reader.nextInt();
		if (wc == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}
		
		System.out.println("You should enable the sleep feature on your electronic devices. Will you do this? Enter 0 for no and 1 for yes.");
		int sf = reader.nextInt();
		if (sf == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}
		
		System.out.println("You should dry your clothes on a drying rack instead of using the dryer for about 50% of your loads. Will you do this? Enter 0 for no and 1 for yes.");
		int dr = reader.nextInt();
		if (dr == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}
	}
	
	private void carPledge() {
		
		System.out.println("Here is the Car Pledge section.");
		
		System.out.println("You should reduce the number of miles per week you drive your car.");
		System.out.println("By how many miles do you pledge to reduce your car travel per week?");
		double milesReduce = reader.nextDouble();
		if (milesReduce > 0.0) {
			System.out.println("Great!");
		}
		else {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		
		System.out.println("You should perform regular maintainence on your vehicles. Will you do this? Enter 0 for no and 1 for yes.");
		int rm = reader.nextInt();
		if (rm == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}
	}
	
	private void wastePledge() {
		
		System.out.println("Here is the Waste Pledge section.");
		
		System.out.println("You should start recycling materials that you do not currently recycle. Will you do this? Enter 0 for no and 1 for yes.");
		int r = reader.nextInt();
		if (r == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}	
	}
	
	private void flightPledge() {
		
		System.out.println("Here is the Flight Pledge section.");
		
		System.out.println("You should fly only when you have to, reducing trips when possible. Will you do this? Enter 0 for no and 1 for yes.");
		int f = reader.nextInt();
		if (f == 0) {
			System.out.println("It's okay. Try to reduce your carbon footprint elsewhere.");
		}
		else {
			System.out.println("Great!");
		}
	}
}
