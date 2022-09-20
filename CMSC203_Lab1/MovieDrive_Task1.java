/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a driver class designed to make the user input the name of a movie, the rating, and how many tickets it sold, by using the
* Movie.java utility class
* It then displays these variables and asks if the user wants to do the same for another movie 
* Due: 09/20/2022
*
* Platform/Compiler: Java/Eclipse
*
* Programmer: Anthony Amaya
*
*/




import java.util.Scanner; // imports scanner class for reading user input


public class MovieDriver {
	
	

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);	//scanner variable to create user input
		
		Movie box = new Movie();	//creates a movie object
		
		String answer;	//string variable to hold user answer if they want to display another movie or not
		
		
		
		System.out.println("Enter the name of a movie");	//displays message for user
		box.getTitle();	//gets title using utility class
		box.setTitle(keyboard.nextLine());	//sets title using utility class
				
		
		System.out.println("Enter the rating of the movie");	//displays message for user
		box.getRating();	//gets rating using utility class
		box.setRating(keyboard.nextLine());	//sets rating using utility class
		
		System.out.println("Enter number of tickets sold for this movie");	//displays message for user
		box.getSoldTickets();	///gets number of sold tickets using utility class
		box.setSoldTickets(keyboard.nextInt());	//sets number of sold tickets using utility class
		
		System.out.println(box.toString());	//displays the title, rating, and tickets sold using the utility class
		
		keyboard.nextLine();	//consumes space caused by using nextInt()
		
		System.out.println("Do you want to enter another? (y or n)");	//asks the user if they want to display another movie
		answer = keyboard.nextLine();	//holds user input
		
		
		System.out.println("Goodbye");	//message displayed at the termination of the program
		System.out.println("Programmer: Anthony Amaya");
		
		
	}
	
	
	

}