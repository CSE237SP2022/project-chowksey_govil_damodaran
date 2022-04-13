package classes;

import java.io.File;
import java.util.Scanner;

public class Tracker {
	
	TrackerHelpers th;
	
	public Tracker(){
		
		th = new TrackerHelpers();

	}
		
	public void runTracker() throws Exception {
		
		String fileName = "src/tracker/trackerResults";
		 
//		th.delete(fileName);
	
		if (!new File(fileName).exists()) {
			th.write(fileName, 0, 0, 0);
		} 
		
		th.read(fileName);
		
		Scanner scanner = new Scanner(System.in);  
		
		System.out.println("Please input how many miles you drove:");
		int miles = scanner.nextInt();
		
		System.out.println("Please input how many miles you flew:");
		int flight = scanner.nextInt();
		
		System.out.println("Please input how many pounds of trash you threw out.");
		int trash = scanner.nextInt();
		
		scanner.close();
		
		miles = th.parseText(fileName, "Miles:", miles);
		flight = th.parseText(fileName, "Flight:", flight);
		trash = th.parseText(fileName, "Trash:", trash);
		
		th.write(fileName, miles, flight, trash);
		
		th.read(fileName);
		
	}

}