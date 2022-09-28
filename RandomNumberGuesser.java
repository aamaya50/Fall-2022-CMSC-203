/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a driver class designed to work with the RNG.java utility class. Used to generate a random number between 0-100 and let's user make 7 guesses between 0 and 100. 
* It then displays these variables and asks if the user wants to do the same for another movie 
* Due: 09/27/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/




import java.util.Scanner;	//imports Scanner class


//driver class designed to go with the RNG.java utility class
public class RandomNumberGuesser {
  public static void main(String[] args) {
	 
	 
	  Scanner keyboard = new Scanner(System.in);  //Scanner class used to create keyboard object for user input
      String keepGoing = "";	//empty string variable used for holding a string that would tell whent the program should repeat or stop
  
    //do while statement to repeat program until the user decides to stop  
	do {
		  int ranInt = RNG.rand();	//integer variable that references the random method from the RNG.java class. Gives a random number
	      int answer = 0;	//integer variable used to hold user answer
	      int lowNum = 0;	//integer variable used to set the lowest bound out of 1-100
	      int highNum = 100;	//integer variable used to set highest bound out of 1-100
	      int count = 0;	// integer variable to hold count later in program
  
      
    System.out.println("This application generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly.");

    System.out.println("Enter your first guess: ");
    answer = keyboard.nextInt();	//keyboard object used to gain user input and set it to variable "answer"
    
    RNG.inputValidation(answer, lowNum, highNum); //uses method from RNG class to validate the user input

    keepGoing = correct(answer, ranInt);	//keepGoing variable set to value of correct() method, uses the user input and random integer as arguments
    
    //while statement in case user guesses the correct number on the first try and wants to play again
    while(keepGoing.equalsIgnoreCase("yes"))
    {

        System.out.println("Enter your first guess: ");
        answer = keyboard.nextInt();	//keyboard object used to gain user input and set it to variable "answer"
        
        RNG.inputValidation(answer, lowNum, highNum); 	//uses method from RNG class to validate the user input

        keepGoing = correct(answer, ranInt);	//keepGoing variable set to value of correct() method, uses the user input and random integer as arguments
    }
    
    
   //if statement that executes as long as the answer wasn't the random integer and as long as the answer wasn't 100
    if(answer != ranInt && answer != 100)
    {
      while(count < 7)	//while statement that can run a maximum of 7 times, since the user will have 7 guesses before the program ends.
      {
    	  if (answer >= lowNum && answer <= highNum)	//if statement that executes if the number would be considered lower than the highest number and greater then the lowerst integers at that time
          {
    		  if (answer >= lowNum && answer <= ranInt)	//if statement that executes if the number is lower than the random integer
    		  {
    			  lowNum = lowerNumber(answer, lowNum, ranInt);	//sets the new lowest number to the number that was guessed, thus making new bounds using the lowestNumber method
    			  ++count;	//increases count
    			  System.out.println("Number of guesses is: " + count);
    		  }
    	  	 else if (answer <= highNum && answer >= ranInt)	//else if statement that executes if the number is greater than the random integer	
    	  	 {
    	  		highNum = higherNumber(answer, highNum, ranInt);	//sets the new highest number to the user's guess using the higherNumber method
    	  		++count;	//increases count
    	  		System.out.println("Number of guesses is: " + count);
    	  	 }
    		  
    	      
    		 
    	       	System.out.println("Enter your next guess between " + lowNum + " and " + highNum);	//after executing the other body statements, let's user guess new number between new bounds
    	        answer = keyboard.nextInt();	//keyboard object used to gain user input and set it to variable "answer"
    	        RNG.inputValidation(answer, lowNum, highNum); //uses method from RNG class to validate the user input
    		  
    	    
    	  //if the answer turns out to be the random integer, executes this statement that would end the while loop and ask if the user wants to play again
          if (answer == ranInt)
          {
        	keyboard.nextLine();
            System.out.println("Congratulations, you guessed correctly");
            System.out.println("Try again? (yes or no)");
      		keepGoing = keyboard.nextLine();
          
      		count = 8;
          }
     
        //if the user reaches the maximum number of attempts, let's user know and the while loop does not continue
        if (count == 7)
        {
        	System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
        
        }
        
      }
    }
  
    }
	  }while(keepGoing.equalsIgnoreCase("yes"));	//end of do-while loop where if the user's answer is still "yes" then the game would replay
	//if the user's answer is no, then the game ends
	if (keepGoing.equalsIgnoreCase("no"))
	{
		System.out.println("Thanks for playing...");
		System.out.println("Programmer: Anthony Amaya");
	}
}

  /**
   * Checks the two number arguments, (user's answer and the random integer) to see if they are the same, if so it would end the program or ask the user if they want to play again
   * @param num1 
   * @param num2
   * @return the "keepGoing" variable that would let the program know whether to continue or end the program
   */
  public static String correct(int num1, int num2)
  { 
	Scanner keyboard = new Scanner(System.in);
  	String keepGoing;
  	if(num1 == num2)
  	{
  		System.out.println("Congratulations, you guessed correctly");
          
  		System.out.println("Try again? (yes or no)");
  		keepGoing = keyboard.nextLine();
  	}
  	else
  	{
  		keepGoing = "";
  	}
  	
  	return keepGoing;
  }
  
  
  /**
   * Method used to set the answer as the highest bounds possible if it were higher than the random integer
   * @param answer
   * @param highNum1
   * @param ranInt
   * @return the new highest bound in the program
   */
  public static int higherNumber(int answer, int highNum1, int ranInt)
  {
	  int highNum = 0;
	  if (answer <= highNum1)
	  {
		  if (answer <= highNum1 && answer >= ranInt)
		  {
			  System.out.println("Your guess is too high");
			  highNum = answer;
		  }
	  }
	  return highNum;
  }
  
  /**
   * Method used to set the answer as the lowest bounds possible if it were lower than the random integer
   * @param answer
   * @param lowNum1
   * @param ranInt
   * @return the new lowest bound in the program
   */
  public static int lowerNumber(int answer, int lowNum1, int ranInt)
  {
	  int lowNum = 0;
	  if (answer >= lowNum1)
	  {
		  if (answer >= lowNum1 && answer <= ranInt)
		  {
			  System.out.println("Your guess is too low");
			  lowNum = answer;
		  }
	  }
	  return lowNum;
  }
 
}
  
  

  