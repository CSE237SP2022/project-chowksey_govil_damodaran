package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import classes.HouseEmissionsCalculator;

class HouseEmissionsTests {


	@Test
	void testNatGasEmissions() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("23 2 0 0 0");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();

	    assertEquals(3090,he,1);	    
	}
	
	
	@Test
	void testElecEmissionsWithoutGreenPower() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("0 2 44 0 0");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(8091,he,1);
	}
	
	@Test
	void testElecEmissionsWithGreenPower() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("0 1 44 10 0 0");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(7282,he,1);
	}

	
	@Test
	void testFuelOilEmissions() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("0 2 0 72 0");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(4860,he,1);
	}
	
	@Test
	void testPropaneEmissions() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("0 2 0 0 37");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(2234,he,1);
	}
	
	@Test
	void testFullMethod1() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("40 2 36 80 32");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(19326,he,1);
	}
	
	@Test
	void testFullMethod2() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("40 1 36 40 80 32");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    HouseEmissionsCalculator hec = new HouseEmissionsCalculator();
	    double he = hec.houseEmissions();
    
	    assertEquals(16678,he,1);
	}


}
