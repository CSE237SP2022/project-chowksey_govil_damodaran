package tracker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
	
	public Tracker(){
		}
		
		public static void main(String[] args) throws Exception {
			
			String fileName = "src/tracker/trackerResults";
			Path filePath = Path.of(fileName);
			
//			if (new File(fileName).exists()) {
//				System.out.println("exists");
//				File trackerFile = new File(fileName);
//				if (trackerFile.delete()) {
//					System.out.println("success");
//				}
//			} 
			
			if (!new File(fileName).exists()) {
				File trackerFile = new File(fileName);
				trackerFile.createNewFile();
				Files.writeString(filePath, "Miles: " + 0);
				Files.writeString(filePath, "Flight: " + 0);
				Files.writeString(filePath, "Trash: " + 0);
			}
			
			Scanner reader = new Scanner(System.in);  
			
			System.out.println("Please input how many miles you drove:");
			int miles = reader.nextInt();
			
			System.out.println("Please input how many miles you flew:");
			int flight = reader.nextInt();
			
			System.out.println("Please input how many pounds of trash you threw out.");
			int trash = reader.nextInt();
			
			reader.close();
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String currentLine = br.readLine();
			
			while (currentLine != null){
				String[] splitStr = currentLine.trim().split("\\s+");
				if (splitStr[0] == "Miles: ") {
					miles += Integer.valueOf(splitStr[1]);
				}
				else if (splitStr[0] == "Flight: ") {
					flight += Integer.valueOf(splitStr[1]);
				}
				else {
					trash += Integer.valueOf(splitStr[1]);
				}
				currentLine = br.readLine();
			}
			

			File trackerFile = new File(fileName);
			trackerFile.delete();	
			trackerFile.createNewFile();
			Files.writeString(filePath, "Miles: " + 0);
			Files.writeString(filePath, "Flight: " + 0);
			Files.writeString(filePath, "Trash: " + 0);
			
			System.out.println();
			
	    }
	}