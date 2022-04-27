package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.time.LocalDate;

public class TrackerHelpers {
	
	public TrackerHelpers() {

	} 
	
	public void read(String fileName) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		int difference = 0;
		
		while ((line = br.readLine()) != null) {
			String[] splitStr = line.trim().split("\\s+");
			if (checkDate(line)) {
				difference = getDifferenceDate(LocalDate.parse(splitStr[1])) + 1;
				System.out.println("Here is your cumulative usage starting from: " + splitStr[1]);
			} 
			else {
				if (difference == 0) {
					difference++;
				}
				System.out.println(line + ", Average Per Day: " + (Integer.valueOf(splitStr[1])/difference));	
			}
		}
		System.out.println(" ");
		br.close();
		
	}
	
	public void write(String fileName, int miles, int flight, int trash, LocalDate date) throws Exception {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		File trackerFile = new File(fileName);
		trackerFile.createNewFile();
		
		writer.write("Date: " + date + "\n");
		writer.write("Miles: " + miles + "\n");
		writer.write("Flight: " + flight + "\n");
		writer.write("Trash: " + trash + "\n");
		writer.close();
		 
	}
	
	public void delete(String fileName) throws Exception {
		
		if (new File(fileName).exists()) {
			File trackerFile = new File(fileName);
			trackerFile.delete();	
		}
		
	}
	
	public int parseText(String fileName, String compString, int variable) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String currentLine;
		
		while ((currentLine = reader.readLine()) != null) {
			String[] splitStr = currentLine.trim().split("\\s+");
			
			if (splitStr[0].equals(compString)) {
				variable += Integer.valueOf(splitStr[1]);
			}
		}
		
		reader.close();
		
		return variable;
		
	}
	
	public LocalDate parseTextDate(String fileName, String compString) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String currentLine;
		
		while ((currentLine = reader.readLine()) != null) {
			String[] splitStr = currentLine.trim().split("\\s+");
			
			if (splitStr[0].equals(compString)) {
				reader.close();
				return LocalDate.parse(splitStr[1]);
			}
		}
	
		reader.close();
		return null;
		
	}
	
	public Boolean checkDate(String line) {
		String[] splitStr = line.trim().split("\\s+");
		
		if (splitStr[0].equals("Date:")) {
			return true;
		}
		return false;
	}
	
	public int getDifferenceDate(LocalDate oldDate) {
		return (int) Duration.between(oldDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
	}

}
