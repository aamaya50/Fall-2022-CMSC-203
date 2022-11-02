/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class extends the BankAccount class to create a checking account for a person 
* Due: 11/08/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/



public class CheckingAccount extends BankAccount 
{
	//checking fee applied each time a withdraw occurs
	private static final double FEE = 0.15;
	
	/**
	 * Constructor to create a person's bank account and checking acccount simultaneously
	 * @param name of the person
	 * @param amount initial amount to be deposited
	 */
	public CheckingAccount(String name, double amount)
	{
		//calls on super constructor
		super(name, amount);
		
		//calls super setter method
		super.setAccountNumber(super.getAccountNumber() + "-10");
		
	}
	
	@Override
	public boolean withdraw(double amount)
	{
		return super.withdraw(amount + FEE);
		
	}
	
}
