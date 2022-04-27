package classes;

import java.util.Scanner;

public class Quiz {
	
	TrackerHelpers th;
	
	public Quiz(){

	}
		
	public void runQuiz() { 
		System.out.println("Here you will take a short quiz regarding carbon emissions.");
		
		Scanner scanner = new Scanner(System.in); 
		
		while (true) {
			System.out.println("Press 1 for a beginner quiz. Press 2 for an advanced quiz. Press 3 to exit.");
			int response = scanner.nextInt();
			
			if (response == 1) {
				easyQuiz();
			}
			else if (response == 2) {
				hardQuiz();
			}
			else if (response == 3) {
				break;
			}
			else {
				System.out.println("Invalid response, try again");
			}
		}

	}
	
	public int checkCorrect(String rightAns, String response, int counter) {
		
		if (response.equals(rightAns)) {
			counter++;
			System.out.println("That's correct, great job!");
		}
		else {
			System.out.println("Sorry the correct response was " + rightAns + ".");
		}
		
		return counter;
	}
	
	public void easyQuiz() {
	
		int counter = 0;
		Scanner scanner = new Scanner(System.in); 
	
		System.out.println("1.) How much carbon dioxide does the average American emit per year?");
		System.out.println("a.) 1 megaton ");
		System.out.println("b.) 15 tons");
		System.out.println("c.) 2.5 tons");
		
		counter = checkCorrect("b", scanner.nextLine(), counter);
		
		System.out.println("2.) What is the main source of human carbon dioxide emission?");
		System.out.println("a.) Deforestation ");
		System.out.println("b.) Cow Belching");
		System.out.println("c.) Fossil Fuels");
		
		counter = checkCorrect("c", scanner.nextLine(), counter);
		
		System.out.println("3.) Which action would have the greatest impact on reducing carbon emissions?");
		System.out.println("a.) Ridding all fossil fuel-burning vehicles.");
		System.out.println("b.) Shutting down all fossil fuel power plants.");
		System.out.println("c.) Replacing all fossil fuel stoves with renewable ones.");
		
		counter = checkCorrect("b", scanner.nextLine(), counter);
		
		System.out.println("4.) Which of the following gases is the main driver of warming?");
		System.out.println("a.) Carbon Dioxide.");
		System.out.println("b.) Nitrogen.");
		System.out.println("c.) Water Vapor.");
		
		counter = checkCorrect("a", scanner.nextLine(), counter);
		
		System.out.println("5.) What is the effect of rising global temperatures on precipitation?");
		System.out.println("a.) Averages precipitation increases.");
		System.out.println("b.) Averages precipitation stays the same.");
		System.out.println("c.) Averages precipitation decreases.");
		
		counter = checkCorrect("a", scanner.nextLine(), counter);
		
		System.out.println("You scored a " + counter + "/5");
		
	}
	
	public void hardQuiz() {
		
		int counter = 0;
		Scanner scanner = new Scanner(System.in); 
	
		System.out.println("1.) Under the Kyoto Protocols, how much did nations, on average, pledge to decrease emissions?");
		System.out.println("a.) 5.2% ");
		System.out.println("b.) 6.7%");
		System.out.println("c.) 3.4%");
		
		counter = checkCorrect("a", scanner.nextLine(), counter);
		
		System.out.println("2.) How much did the world's first commercial carbon capture and storage plant cost?");
		System.out.println("a.) $130M ");
		System.out.println("b.) $1.3B");
		System.out.println("c.) $13B");
		
		counter = checkCorrect("b", scanner.nextLine(), counter);
		
		System.out.println("3.) What do the INDCs stand for?");
		System.out.println("a.) Intentional National Diplomatic Cooperations.");
		System.out.println("b.) International negotiations to determine carbon reduction.");
		System.out.println("c.) Intended nationally determined contributions.");
		
		counter = checkCorrect("c", scanner.nextLine(), counter);
		
		System.out.println("4.) Which of the following gases does not trap heat?");
		System.out.println("a.) Nitrogen.");
		System.out.println("b.) Carbon Dioxide.");
		System.out.println("c.) Water Vapor.");
		
		counter = checkCorrect("a", scanner.nextLine(), counter);
		
		System.out.println("5.) Which country is the greatest investor into renewable energy?");
		System.out.println("a.) United Kingdom.");
		System.out.println("b.) Austrailia.");
		System.out.println("c.) China.");
		
		counter = checkCorrect("c", scanner.nextLine(), counter);
		
		System.out.println("You scored a " + counter + "/5");
		
	}

}