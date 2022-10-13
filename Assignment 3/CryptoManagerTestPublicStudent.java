/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is an encryption program that will encode the user's input according to the ceaser cipher
* or bellaso cipher if also given a proper key. It will also decrypt the word. 
* Due: 10/11/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/






import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestPublicStudent {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStringInBounds() {

		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("'' IN BOUNDS ''"));
		assertFalse(CryptoManager.isStringInBounds("} NOT IN BOUNDS"));
		assertFalse(CryptoManager.isStringInBounds("SHOULD NOT WORK BECSUE OF ~"));

	}

	@Test
	public void testCaesarEncryption() {
		
		assertEquals("J]F", CryptoManager.caesarEncryption("GZC", 3));
		assertEquals("AH7D:7D7", CryptoManager.caesarEncryption("OVERHERE", 50));
		assertEquals("W^MZ\\PMZM", CryptoManager.caesarEncryption("OVERTHERE", 200));

	}

	@Test
	public void testBellasoEncryption() {
		
		assertEquals("^,J$\\MWWT", CryptoManager.bellasoEncryption("OVERTHERE", "OVERHERE"));
		assertEquals("IPLYI", CryptoManager.bellasoEncryption("GOING", "BACK"));
		assertEquals("__X^", CryptoManager.bellasoEncryption("LOOP", "SPIN"));
		assertEquals("'&ZR", CryptoManager.bellasoEncryption("TREE", "STUMP"));

		
	}

	@Test
	public void testCaesarDecryption() {
		
		assertEquals("HELLO", CryptoManager.caesarDecryption("PMTTW", 8));
		assertEquals("GZC", CryptoManager.caesarDecryption("J]F", 3));
		assertEquals("OVERHERE", CryptoManager.caesarDecryption("3:)6,)6)", 100));
		assertEquals("OVERTHERE", CryptoManager.caesarDecryption("Y`O\\^RO\\O", 10));



		
	}

	@Test
	public void testBellasoDecryption() {
		
		assertEquals("ASD", CryptoManager.bellasoDecryption("E&E", "DSA"));
		assertEquals("RETRY", CryptoManager.bellasoDecryption("+Z-'2", "YU"));
		assertEquals("HELLO", CryptoManager.bellasoDecryption("PNTUW", "HI"));
		assertEquals("TRUE", CryptoManager.bellasoDecryption("ZS!X", "FALSE"));

	}
	



}
