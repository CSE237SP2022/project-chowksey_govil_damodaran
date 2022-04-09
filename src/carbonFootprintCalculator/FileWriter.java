package carbonFootprintCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class FileWriter {
	
	
	public FileWriter() {
		
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

	public void appendToFile(HashMap<String, Double> emissions, String fileName) {
		File fileToAdd = new File(fileName);
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

}
