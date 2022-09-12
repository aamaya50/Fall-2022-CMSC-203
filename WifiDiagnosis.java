/*
* Class: CSMC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: The WiFi diagnosis class is a program designed to help a user troubleshoot any  
* internet problems that they might be having by avdising the user with a series of tips and ending
* the program if they fixed the problem, or telling the user to contact their ISP if these tips
* don't work
*
* Due: 09/13/2022
*
* Platform/Compiler: Java/javac
*
* I pledge that I have completed the programming assignment independently.
* I have not copied the code from any student or any source.
* I have no given my code to any student
*
* Name: Anthony Amaya
*
*/



import java.util.Scanner; //import statement to use scanner class

class WifiDiagnosis {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);  // scanner variable to use for input later
    String answer;                // string variable to hold answer of user
    String keepGoing = "go";                // string variable that tells the program to keep going, stop, or to let the user know if an invalid reponse was put in
    final String QUESTION = "Did that fix the problem? (Yes or No)";  // constant string variable to hold a yes or no question
    final String INVALID = "\nInvalid answer; try again";               // constant string variable to hold an invalid message if there was a wrong input

    System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");  // displays purpopse of program to user

    System.out.println("\nReboot the computer and try to connect");  // first tip displayed to user with newline at the beginning to seperate from the first message
    System.out.println(QUESTION);  // displays yes or no question to user
    answer = keyboard.nextLine();  // gets input of user and stores it in the answer variable

    if (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"))  // if statement used for input validation. Ignores upper or lower case.
    {
      System.out.println(INVALID);  // message letting user know that there was a wrong input using the constant INVALID
      keepGoing = "wrong";  // sets keepGoing variable to wrong, which doesn't allow the program to display more tips
    }

    if (answer.equalsIgnoreCase("Yes"))  // if the user input yes then the variable keepGoing will not allow the program to display more tips and end the program
      {
        keepGoing = "stop";
      }

    if (answer.equalsIgnoreCase("No")) // if the user input no, then it moves on to the next tip
    {
      System.out.println("Reboot the router and try to connect");
      System.out.println(QUESTION);  // outputs same yes or no question using the constant QUESTION
      answer = keyboard.nextLine();   // gets user input

      	if (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"))  // innput validation using an if conditional statement 
     	{
      	  System.out.println(INVALID);   // message letting user know that there was a wrong input using the constant INVALID
     	  keepGoing = "wrong";  // sets keepGoing variable to wrong, which doesn't allow the program to display more tips
      	}

      	if (answer.equalsIgnoreCase("Yes")) // if the user input yes then the variable keepGoing will not allow the program to display more tips and end the program
      	{
      	  keepGoing = "stop";
      	}
        
    }

    if (answer.equalsIgnoreCase("No"))  // if statement checking if the answer is no, so the next tip can display
    {
      System.out.println("Make sure the cables connecting the router are firmly plugged in and power is getting to the router");
      System.out.println(QUESTION);   // outputs same yes or no question using the constant QUESTION
      answer = keyboard.nextLine();   // gets user input

      	if (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"))  // innput validation using an if conditional statement
      	{
      	  System.out.println(INVALID);   // message letting user know that there was a wrong input using the constant INVALID
      	  keepGoing = "wrong";  // sets keepGoing variable to wrong, which doesn't allow the program to display more tips
     	}

      	if (answer.equalsIgnoreCase("Yes"))  // if the user input yes then the variable keepGoing will not allow the program to display more tips and end the program
      	{
      	  keepGoing = "stop";
      	}
      
    } 

    if (answer.equalsIgnoreCase("No"))   // if statement checking if the answer is no, so the next tip can display
    {
      System.out.println("Move the computer closer to the router and try to connect");
      System.out.println(QUESTION);  // outputs same yes or no question using the constant QUESTION
      answer = keyboard.nextLine();  // gets user input

      	if (!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"))  // innput validation using an if conditional statement
      	{
      	  System.out.println(INVALID);   // message letting user know that there was a wrong input using the constant INVALID
     	  keepGoing = "wrong";   // sets keepGoing variable to wrong, which doesn't allow the program to display more tips
      	}

      	if (answer.equalsIgnoreCase("Yes"))  // if the user input yes then the variable keepGoing will not allow the program to display more tips and end the program
      	{
      	  keepGoing = "stop";
      	}
      
    } 

    if (answer.equalsIgnoreCase("No"))   // if statement checking if the answer is no, so the next tip can display
    {
      System.out.println("Contact you ISP");
      keepGoing = "stop";  // final tip that could have helped, so to end the program must change the keepGoing
    } 

    if (keepGoing.equals("stop") || keepGoing.equals("wrong"))  // both the "stop" and the "wrong" strings end the program but one allows the program to display the word "done"
    {
    	if (keepGoing.equals("stop"))  // if stop equals the "stop" string then it print out done and the programmer's name
      	{
        	  System.out.println("\nDone");
        	  System.out.println("Programmer: Anthony Amaya");
      	}

      	else if (keepGoing.equals("wrong"))  // if keepGoing equals the "wrong" string then the program will just end and display only the programmer's name
      	{
        	  System.out.println("Programmer: Anthony Amaya");
      	}
    }
    

    
  }
}