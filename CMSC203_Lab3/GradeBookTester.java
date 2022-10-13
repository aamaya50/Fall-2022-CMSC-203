/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a JUnit test class for GradeBook.java 
* Due: 10/13/2022
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
	
	//creates two objects of GradeBook class
	private GradeBook score1;
	private GradeBook score2;

	@BeforeEach
	void setUp() throws Exception {
		
		//makes objects accept 5 scores
		score1 = new GradeBook(5); 
		score2 = new GradeBook(5);
		
		//scores to add to score 1
		score1.addScore(50);
		score1.addScore(75);

		//scores to add to score 2
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
		//tests true or false to check if the output was correct
		assertTrue(score1.toString().equals(score2.toString()));
		assertEquals(2, score1.getScoreSize(), .001);
			
	}

	@Test
	void testSum() {
		//tests if the sum method returns the intended number
		assertEquals(125, score1.sum(), .0001);
		
	}

	@Test
	void testMinimum() {
		//checks if the minimum method returns the intended number
		assertEquals(50, score1.minimum(), .001);
		
	}

	@Test
	void testFinalScore() {
		//checks if the final score is the correct number
		assertEquals(75, score1.finalScore());
		
	}
}
