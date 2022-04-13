package tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Tracker {
	
	public Tracker(){

	}
		
		public static void main(String[] args) throws Exception { 
			
			TrackerHelpers th = new TrackerHelpers();
			String fileName = "src/tracker/trackerResults";
			
//			if (new File(fileName).exists()) {
//				System.out.println("exists");
//				File trackerFile = new File(fileName);
//				if (trackerFile.delete()) {
//					System.out.println("success");
//				}
//			}
			
			int miles = 0;
			int flight = 0;
			int trash = 0;
			
			if (!new File(fileName).exists()) {
				th.write(fileName, miles, flight, trash);
			}
			
			th.read(fileName);
			
			Scanner scanner = new Scanner(System.in);  
			
			System.out.println("Please input how many miles you drove:");
			miles = scanner.nextInt();
			
			System.out.println("Please input how many miles you flew:");
			flight = scanner.nextInt();
			
			System.out.println("Please input how many pounds of trash you threw out.");
			trash = scanner.nextInt();
			
			scanner.close();
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				String[] splitStr = currentLine.trim().split("\\s+");
				if (splitStr[0].equals("Miles:")) {
					miles += Integer.valueOf(splitStr[1]);
				}
				else if (splitStr[0].equals("Flight:")) {
					flight += Integer.valueOf(splitStr[1]);
				}
				else if (splitStr[0].equals("Trash:")) {
					trash += Integer.valueOf(splitStr[1]);
				}
			}
			
			reader.close();
			
			th.write(fileName, miles, flight, trash);
			
			th.read(fileName);
	    }
	}