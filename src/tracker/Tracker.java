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
			
			String fileName = "src/tracker/trackerResults";
//			
//			if (new File(fileName).exists()) {
//				System.out.println("exists");
//				File trackerFile = new File(fileName);
//				if (trackerFile.delete()) {
//					System.out.println("success");
//				}
//			}
			
			if (!new File(fileName).exists()) {
				System.out.println("here");
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
				File trackerFile = new File(fileName);
				trackerFile.createNewFile();
				writer.write("Miles: " + 0 + "\n");
				writer.write("Flight: " + 0 + "\n");
				writer.write("Trash: " + 0 + "\n");
				writer.close();
			}
			
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			
			Scanner scanner = new Scanner(System.in);  
			
			System.out.println("Please input how many miles you drove:");
			int miles = scanner.nextInt();
			
			System.out.println("Please input how many miles you flew:");
			int flight = scanner.nextInt();
			
			System.out.println("Please input how many pounds of trash you threw out.");
			int trash = scanner.nextInt();
			
			scanner.close();
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			
			String currentLine = reader.readLine();
			
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
				currentLine = reader.readLine();
			}
			
			reader.close();
			
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName));
			File trackerFile = new File(fileName);
			trackerFile.createNewFile();
			writer2.write("Miles: " + miles + "\n");
			writer2.write("Flight: " + flight + "\n");
			writer2.write("Trash: " + trash + "\n");
			
			
			writer2.close();
			
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			String line2;
			while ((line2 = br2.readLine()) != null) {
				System.out.println(line2);
			}
			br.close();
	    }
	}