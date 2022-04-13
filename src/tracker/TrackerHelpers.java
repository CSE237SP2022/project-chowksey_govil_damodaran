package tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TrackerHelpers {
	
	public TrackerHelpers() {

	}
	
	public void read(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
	
	public void write(String fileName, int miles, int flight, int trash) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		File trackerFile = new File(fileName);
		trackerFile.createNewFile();
		writer.write("Miles: " + miles + "\n");
		writer.write("Flight: " + flight + "\n");
		writer.write("Trash: " + trash + "\n");
		writer.close();
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

}
