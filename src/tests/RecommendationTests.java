package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import classes.CarbonFootPrintCalculator;
import classes.CarbonFootprintCalculatorRecommendations;
import classes.FileWriterAndReader;

class RecommendationTests {

	@Test
	void runFirstCheckIfReccsFailsWithoutFile() {
	     
		CarbonFootprintCalculatorRecommendations cfcr = new CarbonFootprintCalculatorRecommendations();
		int counter = cfcr.getRecommendation();

	    assertEquals(counter,0);	
	    
	    StringBuilder sb = new StringBuilder();
	    
	    FileWriterAndReader fwr = new FileWriterAndReader();
	    HashMap<String, Double> emissions = fwr.readFile("src/tests/beforecalcresults.txt");
	    fwr.appendToFile(emissions, "src/classes/calculatorResults.txt");
	}
	
	@Test
	void checkIfRecommendationsAccurate() {
		CarbonFootprintCalculatorRecommendations cfcr = new CarbonFootprintCalculatorRecommendations();
		int counter = cfcr.getRecommendation();
		assertEquals(counter,4);
	}

}
