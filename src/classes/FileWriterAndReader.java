package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class FileWriterAndReader {
	
	
	public FileWriterAndReader() {
		
	}
	
	public void writeToFile(HashMap<String, Double> emissions, String fileName) {
		File fileToAdd = new File(fileName);
		try {
			PrintWriter writer = new PrintWriter(fileToAdd);
			writer.print("");
			for (String i : emissions.keySet()) {
				writer.println(i + " " + emissions.get(i));
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public void appendToFile(HashMap<String, Double> emissions, String filePath) {
		File fileToAdd = new File(filePath);
		try {
			
			PrintWriter writer = new PrintWriter(new FileOutputStream(fileToAdd,true));
			
			for (String i : emissions.keySet()) {
				writer.println(i + " " + emissions.get(i));
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public HashMap<String,Double> readFile(String filePath) {
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		
		File file = new File(filePath);
		
		try {
			Scanner fileIn = new Scanner(file);
			while(fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				int spaceIndex = line.indexOf(" ");
				String typeOfEmission = line.substring(0, spaceIndex);
				String amount = line.substring(spaceIndex+1, line.length());
				double amountD = Double.parseDouble(amount);
				
				emissions.put(typeOfEmission, amountD);
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return emissions;
	}

}
