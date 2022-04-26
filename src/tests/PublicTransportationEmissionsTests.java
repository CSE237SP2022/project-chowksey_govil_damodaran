package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Rule;

import classes.PublicTransportationEmissions;

class PublicTransportationEmissionsTests {

	//only testing public class method as per instructor suggestion
	@Test
	void testPublicTransportEmissions() {
		StringBuilder sb = new StringBuilder();
	    sb.append("100 100 100 100 100 100");
	   
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    
	    PublicTransportationEmissions pte = new PublicTransportationEmissions();
	    double ce = pte.publicTransportEmissions();
	    
	    assertEquals(126.28,ce,1);
	}

}
