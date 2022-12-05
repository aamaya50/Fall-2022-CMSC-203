/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates a customer for an order
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


public class Customer {
	
	private String name;	//variable to hold customer name
	private int age;	//variable to hold customer age
	
	/**
	 * Constructor to create customer
	 * @param name of the customer
	 * @param age of the customer
	 */
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor that copies the name and age
	 * @param c
	 */
	public Customer(Customer c)
	{
		this.name = c.name;
		this.age = c.age;
	}
	
	/**
	 * Sets the customer age
	 * @param age
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Sets the customer name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Gets the customer age
	 * @return the customer age variable
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * Gets the customer name
	 * @return the customer name variable
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * toString method used to represent the customer name and age
	 */
	public String toString()
	{
		String str = "Name: " + name + ", Age: " + age;
		
		return str;
	}

}
