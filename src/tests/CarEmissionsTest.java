package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import classes.CarEmissionsCalculator;

class CarEmissionsTest {

	@Test
	void testNumberOfCars() {
		StringBuilder sb = new StringBuilder();
	    sb.append("10 1 1 1");
	    
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarEmissionsCalculator cec = new CarEmissionsCalculator();
	    double ce = cec.carEmissions();

	    assertEquals(520,ce,1);
	}
	@Test
	void testAverageMilesDrivenPerWeek() {
		StringBuilder sb = new StringBuilder();
	    sb.append("1 10 1 1");
	    
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarEmissionsCalculator cec = new CarEmissionsCalculator();
	    double ce = cec.carEmissions();

	    assertEquals(520,ce,1);
	}
	@Test
	void testAverageHouseholdFuelEconomy() {
		StringBuilder sb = new StringBuilder();
	    sb.append("1 1 10 1");
	    
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarEmissionsCalculator cec = new CarEmissionsCalculator();
	    double ce = cec.carEmissions();

	    assertEquals(5.2,ce,1);
	}
	@Test
	void testAveragePoundsOfCarbonPerGallon() {
		StringBuilder sb = new StringBuilder();
	    sb.append("1 1 1 10");
	    
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarEmissionsCalculator cec = new CarEmissionsCalculator();
	    double ce = cec.carEmissions();

	    assertEquals(5.2,ce,1);
	}
	@Test
	void testCarEmissions() {
		StringBuilder sb = new StringBuilder();
	    sb.append("5 50 19 15");
	    
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarEmissionsCalculator cec = new CarEmissionsCalculator();
	    double ce = cec.carEmissions();

	    assertEquals(45.6,ce,1);
	}

}
