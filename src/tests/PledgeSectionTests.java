package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import classes.CarbonFootprintPledgeSection;

class PledgeSectionTests {
	
	//test only public class method per instructor suggestion
	@Test
	void testMainPledgeMethod() {
		StringBuilder sb = new StringBuilder();
	    sb.append("10.0 1 1 1 1 1");
	    String data = sb.toString();
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
	    CarbonFootprintPledgeSection cps = new CarbonFootprintPledgeSection();
	    String result = cps.mainPledgeMethod();
	    assertEquals("Great!",result);
	}

}
