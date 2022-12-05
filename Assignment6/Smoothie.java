/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates a smoothie beverage to add to an order
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

public class Smoothie extends Beverage {

	private int numOfFruit; //variable to hold number of fruit
	
	private boolean addProtein; //boolean variable that holds whether the user wants to add protein or not
	private double proteinPrice = 1.50; //if adding protein, this amount is added to the price
	
	private double fruitPrice = 0.5; //this it the price that is added per fruit
	
	/**
	 * Constructor that calls on the super constructor to create beverage object based on given arguments
	 * @param bevName name of the beverage
	 * @param size of the beverage
	 * @param numOfFruit number of fruits to be added to the smoothie
	 * @param addProtein whether to add protein to the smoothie or not
	 */
	public Smoothie(String bevName, Size size, int numOfFruit, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		
		this.numOfFruit = numOfFruit;
		
		this.addProtein = addProtein;
		
	}
	
	/**
	 * Calculates the price based on the number of fruit that were added, whether protein was added, and the size that was picked
	 */
	public double calcPrice()
	{
		//uses the super method to get the base price for a drink
		double price = super.addSizePrice();
		
		if(numOfFruit >= 1)
		{
			price = price + (numOfFruit*fruitPrice);
		}
		
		if(addProtein == true)
		{
			price = price + proteinPrice;
		}
		
		return price;
		
	}
	
	/**
	 * toString method that returns information about the smoothie
	 */
	public String toString()
	{
		//calls on super toString method for beverage name and size
		String str = super.toString();
		
		if(addProtein == true)
		{
			str = str + "Protein was added, ";
		}
		
		if(numOfFruit >= 1)
		{
			str = str + numOfFruit + " fruits were added, ";
		}
		
		str = str + "Price was: " + calcPrice();
		
		return str;
		
	}
	
	/**
	 * Compares the smoothie beverage with another smoothie beverage
	 * @param anotherBev other beverage to be compared
	 * @return whether the two beverages are the same or not
	 */
	public boolean equals(Smoothie anotherBev)
	{
		
		boolean status = true;
		//calls on super class to get the name, type, and size
		if(!(super.beverageName.equals(anotherBev.beverageName)))
		{
			status = false;
		}
		
		if(!(super.type.equals(anotherBev.type)))
		{
			status = false;
		}
		
		if(!(super.size.equals(anotherBev.size)))
		{
			status = false;
		}	
	
		if(this.addProtein != anotherBev.addProtein)
		{
			status = false;
		}
		
		if(this.numOfFruit != anotherBev.numOfFruit)
		{
			status = false;
		}
		
		//add base price method possibly or other beverages note
		
		return status;
		
	}
	
	/**
	 * Gets the variable of whether to add protein or not
	 * @return the addProtein variable
	 */
	public boolean getAddProtein()
	{
		return addProtein;
	}
	
	/**
	 * Gets the number of fruits that were added
	 * @return the number of fruits that were added
	 */
	public int getNumOfFruits()
	{
		return numOfFruit;
	}
	
	
}
