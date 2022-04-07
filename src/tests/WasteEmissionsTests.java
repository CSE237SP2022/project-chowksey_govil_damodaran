package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import carbonFootprintCalculator.WasteEmissionsCalculator;

class WasteEmissionsTests {

	@Test
	void testIfRecycledCans() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("1 2 2 2 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(602,we,1);	    
	}
	
	@Test
	void testIfRecycledPlastic() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("2 1 2 2 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(656,we,1);	    
	}
	
	@Test
	void testIfRecycledGlass() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("2 2 1 2 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(666,we,1);	    
	}
	
	@Test
	void testIfRecycledNewspapers() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("2 2 2 1 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(578,we,1);	    
	}
	
	@Test
	void testIfRecycledMagazines() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("2 2 2 2 1");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(664,we,1);	    
	}
	
	@Test
	void testWasteEmission1() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("1 2 1 2 1");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(549,we,1);	    
	}
	
	@Test
	void testWasteEmission2() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("1 1 1 1 1");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(401,we,1);	    
	}
	
	@Test
	void testWasteEmission3() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("2 2 2 2 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(692,we,1);	    
	}
	
	@Test
	void testWasteEmission4() {
	     
		StringBuilder sb = new StringBuilder();
	    sb.append("1 1 1 2 2");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    WasteEmissionsCalculator wec = new WasteEmissionsCalculator();
	    double we = wec.wasteEmissions();

	    assertEquals(541,we,1);	    
	}

}
