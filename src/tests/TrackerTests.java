package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

import tracker.Tracker;
import tracker.TrackerHelpers;

class TrackerTests {

	@Test
	void testWrite() throws Exception {
		TrackerHelpers th = new TrackerHelpers();
		th.write("src/tests/testfile", 10 , 20, 30);
		
		int miles = 0;
		BufferedReader reader = new BufferedReader(new FileReader("src/tests/testfile"));
		String currentLine;
		while ((currentLine = reader.readLine()) != null) {
			String[] splitStr = currentLine.trim().split("\\s+");
			if (splitStr[0].equals("Miles:")) {
				miles += Integer.valueOf(splitStr[1]);
			}
		}
		reader.close();
		
		assertEquals(10, miles);
		
	}

}
