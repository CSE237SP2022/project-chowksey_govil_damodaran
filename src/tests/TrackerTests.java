package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import classes.Tracker;
import classes.TrackerHelpers;
 
class TrackerTests {

	@Test
	void testWrite() throws Exception {
		
		TrackerHelpers th = new TrackerHelpers();
		th.write("src/tests/testfile", 10 , 20, 30, LocalDate.now());
		
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
	
	@Test
	void testDelete() throws Exception {
		
		TrackerHelpers th = new TrackerHelpers();
		
		th.write("src/tests/testfile", 0 , 0, 0, LocalDate.now());
		th.delete("src/tests/testfile");
		
		assertEquals(new File("src/tests/testfile").exists(), false);
		
	}
	
	@Test
	void testParse() throws Exception {
	
		TrackerHelpers th = new TrackerHelpers();
		th.write("src/tests/testfile", 10 , 0, 0, LocalDate.now());
		
		int miles = th.parseText("src/tests/testfile", "Miles:", 20);
		assertEquals(30, miles);
		
	}
	
	@Test
	void testParseDate() throws Exception {
	
		TrackerHelpers th = new TrackerHelpers();
		th.write("src/tests/testfile", 10 , 0, 0, LocalDate.now());
		
		LocalDate date = th.parseTextDate("src/tests/testfile", "Date:");
		assertEquals(LocalDate.now(), date);
		
	}
	
	@Test
	void testCheckDate() throws Exception {
	
		TrackerHelpers th = new TrackerHelpers();
		
		Boolean realDate = th.checkDate("Date: 2022-04-22");
		assertEquals(realDate, true);
		
		Boolean fakeDate = th.checkDate("Miles: 10");
		assertEquals(fakeDate, false);
		
	}
	
	@Test
	void testDiffDate() throws Exception {
	
		TrackerHelpers th = new TrackerHelpers();
		
		int result = th.getDifferenceDate(LocalDate.now());
		assertEquals(0, result);
		
	}

}
