/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class extends the BankAccount class to create a savings account, allowing for multiple saving's account to be created 
* Due: 11/08/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/




public class SavingsAccount extends BankAccount 
{
	//interest rate
	private double rate = 0.025;
	
	//savings number instance
	private int savingsNumber = 0;
	
	//variable to hold account number
	private String accountNumber;
	
	/**
	 * Constructor to create a savings acccount and bank account simultaneously
	 * @param name of the person 
	 * @param amount initial amount to deposit
	 */
	public SavingsAccount(String name, double amount)
	{
		//calls on BankAccount constructor
		super(name, amount);
		
		//sets the account number using the super account number getter, and concatenates the savings number to show which account it is
		this.accountNumber = "" + super.getAccountNumber() + "-" + savingsNumber;
		
		
	}
	
	/**
	 * Savings account number copy constructor
	 * @param oldAccount to be copied
	 * @param amount inital amount to be deposited
	 */
	public SavingsAccount(SavingsAccount oldAccount, double amount)
	{
		//calls on bank account constructor
		super(oldAccount, amount);
		
		this.rate = oldAccount.rate;
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = "" + super.getAccountNumber() + "-" + this.savingsNumber;
			
	}
	
	/*
	 * Creates the post interest to be added
	 */
	public void postInterest()
	{
		deposit((rate/12)*super.getBalance());
	}
	
	@Override
	public String getAccountNumber()
	{
		return accountNumber;
	}
		
	
	
}
