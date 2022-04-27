package classes;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Tracker {
	
	TrackerHelpers th;
	
	public Tracker(){
		
		th = new TrackerHelpers();

	}
		
	public void runTracker() throws Exception { 
		
		String fileName = "src/classes/trackerResults";
		 
//		th.delete(fileName);
	
		if (!new File(fileName).exists()) {
			th.write(fileName, 0, 0, 0, LocalDate.now());
		} 
		
		Scanner scanner = new Scanner(System.in); 
		
		while (true) {
			
			System.out.println("Press 1 to view your stats. Press 2 to update your stats. Press 3 to exit.");
			int response = scanner.nextInt();
			
			if (response == 1) {
				th.read(fileName);
			}
			else if (response == 2) {
				System.out.println(" ");
				System.out.println("Please input how many miles you drove:");
				int miles = scanner.nextInt();
				
				System.out.println("Please input how many miles you flew:");
				int flight = scanner.nextInt();
				
				System.out.println("Please input how many pounds of trash you threw out.");
				int trash = scanner.nextInt();
				
				LocalDate date = th.parseTextDate(fileName, "Date:");
				miles = th.parseText(fileName, "Miles:", miles);
				flight = th.parseText(fileName, "Flight:", flight);
				trash = th.parseText(fileName, "Trash:", trash);
				
				th.write(fileName, miles, flight, trash, date);
				
				System.out.println(" ");
				System.out.println("Metrics Updated!");
			}
			else if (response == 3) {
				break;
			}
			else {
				System.out.println("Invalid response, try again");
			}
			
		}
		
	}

}