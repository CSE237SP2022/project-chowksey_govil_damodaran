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
			}
			
			Scanner reader = new Scanner(System.in);  
			System.out.println("How many miles did you drive?");
			
			
			int miles = reader.nextInt();
			reader.close();
			
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			ArrayList<String> lines = new ArrayList<String>();
			
			String currentLine = br.readLine();
			
			while (currentLine != null){
				lines.add(currentLine);
				currentLine = br.readLine();
			}
			
			for(int i = 0; i < lines.size(); i++) {
				String[] splitStr = lines.get(i).trim().split("\\s+");
				Integer number = Integer.valueOf(splitStr[1]) + miles;
				Files.writeString(filePath, "Miles: " + number);
			}
			
	    }
	}