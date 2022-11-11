/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the TwoDimRaggedArrayUtility class.
* 
* Due: 11/15/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] dataset1 = {{7,9,1},
								   {1,2},
								   {3,4,2}};
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	
	@Test
	public void testGetTotal() {
		assertEquals(29.0, TwoDimRaggedArrayUtility.getTotal(dataset1), 0);
	}

	@Test
	public void testGetAverage() {
		assertEquals(3.625, TwoDimRaggedArrayUtility.getAverage(dataset1), 0);
	}
	
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataset1, 2), 0);
	}

	@Test
	public void testGetColumnTotal() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getColumnTotal(dataset1, 2), 0);
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataset1, 0), 0);
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataset1, 0), 0);
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInRow(dataset1, 2), 0);
	}
	
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataset1, 1), 0);
	}

	@Test
	public void testGetHighestInColumn() {
		assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataset1, 2), 0);
	}

	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataset1, 1), 0);
	}

	@Test
	public void testGetLowestInColumn() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataset1, 0), 0);
	}

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataset1, 0), 0);
	}

	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataset1), 0);
	}

	@Test
	public void testGetLowestInArray() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataset1), 0);
	}

}