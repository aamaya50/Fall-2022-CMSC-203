/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a JUnit test class for GradeBook.java 
* Due: 10/02/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	private GradeBook score1;
	private GradeBook score2;

	@BeforeEach
	void setUp() throws Exception {
		
		score1 = new GradeBook(5); 
		score2 = new GradeBook(5);
		
		
		score1.addScore(50);
		score1.addScore(75);

		
		score2.addScore(50);
		score2.addScore(75);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		score1 = null;
		score2 = null;
		
	}

	@Test
	void testAddScore() {
		//fail("Not yet implemented");
	
		assertTrue(score1.toString().equals(score2.toString()));
		assertEquals(2, score1.getScoreSize(), .001);
		
		
		
	}

	@Test
	void testSum() {
		//fail("Not yet implemented");
		
		assertEquals(125, score1.sum(), .0001);
		
	}

	@Test
	void testMinimum() {
		//fail("Not yet implemented");
		
		assertEquals(50, score1.minimum(), .001);
		
	}

	@Test
	void testFinalScore() {
		//fail("Not yet implemented");
		
		assertEquals(75, score1.finalScore());
		
	}

	@Test
	void testGetScoreSize() {
		//fail("Not yet implemented");
	}

	@Test
	void testToString() {
		//fail("Not yet implemented");
		
	}

}
