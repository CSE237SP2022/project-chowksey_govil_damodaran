package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class FileWriterAndReader {
	
	
	public FileWriterAndReader() {
		
	}
	
	// source: https://www.javatpoint.com/how-to-read-csv-file-in-java
	// default if zip code doesn't work will be 63112 zip code
	public double readCSVForEFactor(int zip) {
		double eFactor = 1820.425/1000;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/classes/eFactors.csv"));
			String line = "";  
			String splitBy = ",";  
			while ((line = br.readLine()) != null)  
			{  
				String[] efactorLine = line.split(splitBy); 	
				if(efactorLine.length == 0) {
					continue;
				}
				if(efactorLine[0].equals(String.valueOf(zip))) {
					eFactor = Double.parseDouble(efactorLine[3])/1000;
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return eFactor;
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
