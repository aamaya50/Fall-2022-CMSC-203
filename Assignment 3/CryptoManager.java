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





/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		//creating a boolean variable that will be returned
		boolean type = true;
		
		//for loop that decides whether the plainText is within bounds and returns false if it is not else it returns true
		for(int i = 0; i < plainText.length(); i++)
		{
			if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)
			{
				type = false;
			}
		}
		return type;
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		//String variable to be returned at the end of the method
		String word = "";
		
		//char variable used to hold each individual char
		char c;
		
		//for loop that checks whether the plainText is within range
		for(int i = 0; i < plainText.length(); i++)
		{	
			if(plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)
			{
				word = "The selected string is not in bounds, Try again.";
				break;
			}
			
			//else statement that shifts the plainText by the user's key
			else
			{
				
				c = (char)(plainText.charAt(i) + key);
				
				//if statement that gets the char within range if it is not in range
				if (c > UPPER_RANGE)
				{
					while (c > UPPER_RANGE)
					{
					c -= RANGE;
					}
				}
				else if (c < LOWER_RANGE)
				{
					while (c > LOWER_RANGE)
					{
					c += RANGE;
					}
				}
				
				//adds the char to the string making the encrypted word
				word += c;
				word = word.toUpperCase();

			}
		}
		return word;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {

		//String variable to hold the word to be returned
		String encryption = "";
		
		//char variable to hold each individual letter
		char c;
		
		//if statement that uses a for loop to get the key to the right length if the key is shorter then the plainText
		if (plainText.length() > bellasoStr.length())
		{
			for (int i = 0; i < plainText.length(); i++)
			{
				bellasoStr += bellasoStr;
			}
		}
		
		//for loop that shifts the plainText by the required amount
		for (int k = 0; k < plainText.length(); k++)
		{
			c = (char)(plainText.charAt(k) + bellasoStr.charAt(k));
			
			//if statement that gets the char in range if it goes out of it
			if (c > UPPER_RANGE)
			{
				while (c > UPPER_RANGE)
				{
					c -= RANGE;
				}
			}
			
			//adds each char to the string variable to make the encrypted word
			encryption += c;
			
		}
		return encryption;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		
		//String variable to hold the word that is to be returned
		String originalText = "";
		
		//char variable to hold each individual char
		char c;
		
		//if statement that only executes if the string that was to be encrypted was in bounds
		if (!encryptedText.equalsIgnoreCase("The selected string is not in bounds, Try again."))
		{
			//for loop that creates the original text from the encrypted text using the key
			for (int i = 0; i < encryptedText.length(); i++)
			{
				
				//c = (char)(encryptedText.charAt(i) - (key - RANGE));
				c = (char)(encryptedText.charAt(i) + RANGE - key);

				
				//sequence of if-else-if statements to ensure that if the char was orignally out of bounds
				//that it would return it to it's oringal position
				if (c < LOWER_RANGE)
				{
					while (c < LOWER_RANGE)
					{
						c += RANGE;
					}
				}
				else if (c > UPPER_RANGE)
				{
					while (c > UPPER_RANGE)
					{
						c -= RANGE;
					}
				}
					//adds the char to the string variable making the original word
					originalText += c;
			}
		}
		return originalText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {

		//String variable to hold the decrypted word
		String decryption = "";
		
		//char variable to hold each individual character to return to the orignal character
		char c;
		
		//if statement that gets the key to the proper length if the key is shorter than the encrypted text
		if (encryptedText.length() > bellasoStr.length())
		{
			//for loop that adds to the key for the length of the encrypted text
			for (int i = 0; i < encryptedText.length(); i++)
			{
				bellasoStr += bellasoStr;
			}
		}
		
		//for loop that creates the original word accounting for the range displacement
		for (int k = 0; k < encryptedText.length(); k++)
		{
			c = (char)((encryptedText.charAt(k) + RANGE  - bellasoStr.charAt(k)));
	
			//sequence of if-else-if statements to ensure that if the char was orignally out of bounds
			//that it would return it to it's oringal position
			if (c < LOWER_RANGE)
			{
				while (c < LOWER_RANGE)
				{
					c += RANGE;
				}
			}
			else if (c > UPPER_RANGE)
			{
				while (c > UPPER_RANGE)
				{
					c -= RANGE;
				}
			}
			
			//adds the char to the string variable making the original word
			decryption += c;
		}
		return decryption;
	}
}
