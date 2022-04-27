package tests;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import classes.Quiz;
 
class QuizTests {

	@Test
	void testEasy() throws Exception {
		
		StringBuilder sb = new StringBuilder();
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	  
	    String data = sb.toString();
	    InputStream anyInputStream = new ByteArrayInputStream(data.getBytes());
	    System.setIn(anyInputStream);
	    
	    Quiz quiz = new Quiz();
	    assertEquals(quiz.easyQuiz(), 2);
	    
	}
	
	@Test
	void testHard() throws Exception {
		
		StringBuilder sb = new StringBuilder();
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    sb.append(System.getProperty("line.separator"));
	    sb.append("b");
	    
	    String data = sb.toString();
	    InputStream anyInputStream = new ByteArrayInputStream(data.getBytes());
	    System.setIn(anyInputStream);
	    
	    Quiz quiz = new Quiz();
	    assertEquals(quiz.hardQuiz(), 1);
	    
	}
	
	@Test
	void testCorrect() throws Exception {
		
		Quiz quiz = new Quiz();
		
		int rightAns = quiz.checkCorrect("b", "b", 0);
		assertEquals(rightAns, 1);
		
		int wrongAns = quiz.checkCorrect("c", "b", 0);
		assertEquals(wrongAns, 0);
	    
	}

}
