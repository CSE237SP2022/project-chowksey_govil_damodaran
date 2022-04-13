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

}
