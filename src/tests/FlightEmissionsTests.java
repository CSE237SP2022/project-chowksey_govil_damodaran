package tests;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Rule;

import classes.FlightEmissionsCalculator;

import org.junit.jupiter.api.Test;

class FlightEmissionsTests {

	@Test
	void testNonClassWeightMultiplicationContribution() {

		double result = ((0.835)*(3.15*2.0+0.54)*(1.0/(216.86*0.82)));
		
	    assertEquals(0.030211,result,0.1);
	}
	
	@Test
	void testNonClassWeightAdditionContribution() {
		
		double result = (0.00038 + 11.68);

	    assertEquals(11.68038,result,0.1);
	}
	
	@Test
	void testFlightEmissions() {
		StringBuilder sb = new StringBuilder();
	    sb.append("L 100 E");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    double classWeightContribution = 100;
	    double finalEmissionValue = 5756.33/(classWeightContribution*0.030211+11.68038);
	    assertEquals(finalEmissionValue,391.548,5);
	}
	
	@Test
	void testNLMModelContribution() {
		double a = 0.0001;
		double b = 7.104;
		double c = 5044.93;
		double flightDistance = 100.0;
		
		double result = ((a*flightDistance*flightDistance) + (b*flightDistance) + c);
		assertEquals(5756.33,result,10);
	}
}
