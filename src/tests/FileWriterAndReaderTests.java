package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import classes.FileWriterAndReader;

class FileWriterAndReaderTests {

	@Test
	void testWritingToFile() {
		FileWriterAndReader fwr = new FileWriterAndReader();
		
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		emissions.put("test1", 10.0);
		emissions.put("test2", 20.0);
		String fileName = "src/tests/testWritingToFile.txt";
		
		fwr.writeToFile(emissions, fileName);
		
		File file = new File(fileName);
		
		try {
			Scanner fileIn = new Scanner(file);
			String[] emissionTypes = new String[2];
			double[] values = new double[2];
			int counter = 0;
			while(fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				int spaceIndex = line.indexOf(" ");
				String typeOfEmission = line.substring(0, spaceIndex);
				emissionTypes[counter] = typeOfEmission;
				String amount = line.substring(spaceIndex+1, line.length());
				double amountD = Double.parseDouble(amount);
				values[counter] = amountD;
				counter++;
			}
			assertEquals(emissionTypes[0],"test2");
			assertEquals(emissionTypes[1],"test1");
			assertEquals(values[0],20.0);
			assertEquals(values[1],10.0);
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testReadingFile() {
		FileWriterAndReader fwr = new FileWriterAndReader();
		
		String fileName = "src/tests/testReadingToFile.txt";
		
		HashMap<String, Double> emissions = fwr.readFile(fileName);
		
		for (HashMap.Entry<String, Double> entry : emissions.entrySet()) {
		    String key = entry.getKey();
		    Object val = entry.getValue();
		    if(key.equals("test1")) {
		    	assertEquals(val,10.0);
		    }
		    else {
		    	assertEquals(val,20.0);
		    }
		}
	}
	
	@Test
	void testreadCSVForEFactor1() {
		FileWriterAndReader fwr = new FileWriterAndReader();
		double eFactor = fwr.readCSVForEFactor(95129);
		
		assertEquals(eFactor,0.6132845);
	}
	
	@Test
	void testreadCSVForEFactor2() {
		FileWriterAndReader fwr = new FileWriterAndReader();
		double eFactor = fwr.readCSVForEFactor(63112);
		
		assertEquals(eFactor,1.820425);
	}
	
	@Test
	void testAppendingFile() {
		FileWriterAndReader fwr = new FileWriterAndReader();
		
		HashMap<String, Double> emissions = new HashMap<String, Double>();
		emissions.put("test1", 10.0);
		String fileName = "src/tests/testAppendingToFile.txt";
		
		fwr.writeToFile(emissions, fileName);
		
		emissions = new HashMap<String, Double>();
		emissions.put("test2", 20.0);
				
		fwr.appendToFile(emissions, fileName);
		
		File file = new File(fileName);
		
		try {
			Scanner fileIn = new Scanner(file);
			String[] emissionTypes = new String[2];
			double[] values = new double[2];
			int counter = 0;
			while(fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				int spaceIndex = line.indexOf(" ");
				String typeOfEmission = line.substring(0, spaceIndex);
				emissionTypes[counter] = typeOfEmission;
				String amount = line.substring(spaceIndex+1, line.length());
				double amountD = Double.parseDouble(amount);
				values[counter] = amountD;
				counter++;
			}
			assertEquals(emissionTypes[0],"test1");
			assertEquals(emissionTypes[1],"test2");
			assertEquals(values[0],10.0);
			assertEquals(values[1],20.0);
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
