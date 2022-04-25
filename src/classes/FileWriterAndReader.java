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
	
	public double readCSVForEFactor(int zip) {
		// default if zip code doesn't work will be 63112 zip code
		double eFactor = 1820.425/1000;
		// source: https://www.javatpoint.com/how-to-read-csv-file-in-java
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/classes/eFactors.csv"));
			String line = "";  
			String splitBy = ",";  
			while ((line = br.readLine()) != null)  
			{  
				String[] employee = line.split(splitBy); 
				if(employee[0].equals("Zip") ) {
					continue;
				}
				if(Integer.parseInt(employee[0]) == zip) {
					eFactor = Double.parseDouble(employee[3]);
				}
					System.out.println(employee[0]);  
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
