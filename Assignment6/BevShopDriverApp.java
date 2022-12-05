/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates utilizes the bevshop class to create orders
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import java.util.Scanner;


public class BevShopDriverApp {

	public static void main(String[] args)
	{
		int time;	//variable to hold time of order
		BevShop order;	//variable to hold bevshop order
		Customer cust;	//variable to hold customer
		Type type = null;	//variable to hold type of drink
		Order o;	//variable to hold one order
		Day day = null;	//variable to hold day of order
		
		//creates scanner for input
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.print("Start new order?(type in yes or no): ");
		String answer = keyboard.nextLine();
		
		if(answer.equalsIgnoreCase("yes") )
		{
			//gets time of day
			System.out.print("Enter time of day: ");
			time = keyboard.nextInt();
			keyboard.nextLine();
			
			//gets day
			day = dayOfWeek();
			
			//creates customer
			cust = createCustomer();
			
			//creates new list of orders
			order = new BevShop();
			
			//begins new oder
			order.startNewOrder(time, day, cust.getName(), cust.getAge());
			
			//checks if time input is during the open time
			if(order.isValidTime(time) == true)
			{
				//starts new single order for getting order number
				o = new Order(time, day, cust);
				System.out.println("Order number: " + generateOrderNum(o, time, day, cust));
				
				//gets the type of drink
				type = createDrink();
			
				//if type of drink is alcohol, checks if the proper age and begins the process
				//to add it to the order
				if(type.equals(Type.ALCOHOL))
				{
					if(order.isValidAge(cust.getAge()))
					{
						orderAlcohol(order, cust);
					}
					//if not proper age, does not allow alcohol order, and gets a new drink until it's not alcohol
					else
					{	
						while(type.equals(Type.ALCOHOL))
						{
							System.out.println("Not of age, not allowed to order alcohol");
							type = createDrink();
						}
					
					}
				}
				
				//if drink is coffee, adds a coffee to the order
				if(type.equals(Type.COFFEE))
				{	
					orderCoffee(order);
				}
				
				//if drink is smoothie, adds a smoothie to the order
				if(type.equals(Type.SMOOTHIE))
				{
					orderSmoothie(order);
				}
				
				//shows total on current order
				System.out.print("Total on the order: " + order.getCurrentOrder().calcOrderTotal() + "\n");
			
				//asks if the person wants to add more to the order, create a a new order, or to stop all orders for the day
				System.out.print("Enter 1 to add more to the current order, 2 to create a new order. or 3 to stop: ");
				int orderAnswer = keyboard.nextInt();
				keyboard.nextLine();
				
				//while answer is 1, adds more to current order, if 2 then creates a new order
				while(orderAnswer == 1 || orderAnswer == 2)
				{
					while(orderAnswer == 1)
					{
						type = createDrink();
					
						if(type.equals(Type.ALCOHOL))
						{
							if(order.isValidAge(cust.getAge()))
							{
								orderAlcohol(order, cust);
							}
							else
							{	
								while(type.equals(Type.ALCOHOL))
								{
									System.out.println("Not of age, not allowed to order alcohol");
									type = createDrink();
								}
							}
							
							//checks if the current order has reached maximum orders for alcohol
							if(order.isEligibleForMore() == false)
							{
								
								System.out.print("Total on the order: " + order.getCurrentOrder().calcOrderTotal() + "\n");
								
								//if max reached, does not allow order of alcohol
								while(type.equals(Type.ALCOHOL))
								{
									System.out.println("Maximum alcohol drink for this order");
									type = createDrink();
								}
							}
						
						}
						
						if(type.equals(Type.COFFEE))
						{	
							orderCoffee(order);
						}
				
						if(type.equals(Type.SMOOTHIE))
						{
							orderSmoothie(order);
						}
					
						System.out.print("Total on the order: " + order.getCurrentOrder().calcOrderTotal() + "\n");
						
						//can add even more to current order, create new order, or end all orders
						System.out.print("Enter 1 to add more to the current order, 2 to create a new order. or 3 end orders: ");
						orderAnswer = keyboard.nextInt();
						keyboard.nextLine();
				
					}
					
					//if answer was 2, creates a new order, with a new customer
					if(orderAnswer == 2)
					{
						System.out.print("Enter time of day: ");
						time = keyboard.nextInt();
						keyboard.nextLine();
						
						day = dayOfWeek();
						cust = createCustomer();
					
						o = new Order(time, day, cust);
						
						order.startNewOrder(time, day, cust.getName(), cust.getAge());
				
						if(order.isValidTime(time) == true)
						{
						
							System.out.println("Order number: " + generateOrderNum(o, time, day, cust));
				
							type = createDrink();
				
							if(type.equals(Type.ALCOHOL))
							{
								if(order.isValidAge(cust.getAge()))
								{
									orderAlcohol(order, cust);
								}
								else
								{	
									while(type.equals(Type.ALCOHOL))
									{
										System.out.println("Not of age, not allowed to order alcohol");
										type = createDrink();
									}
							
								}
							}
					
					
							if(type.equals(Type.COFFEE))
							{	
								orderCoffee(order);
							}
				
							if(type.equals(Type.SMOOTHIE))
							{
								orderSmoothie(order);
							}
					
							System.out.print("Total on the order: " + order.getCurrentOrder().calcOrderTotal() + "\n");
			
							System.out.print("Enter 1 to add more to the current order, 2 to create a new order, or 3 to end orders: ");
							orderAnswer = keyboard.nextInt();
							keyboard.nextLine();
						}
						
						//if the order time was not valid, does not allow creation of orders
						else
						{
							System.out.println("We are not open");
							orderAnswer = 3;
						}
			
					}
			
				}
				
				//shows total amount accumulated from every order of current list of orders
				System.out.println("Total amount for all orders: " + order.totalMonthlySale());
			}	
			
			//if the order time was not valid, does not allow creation of orders
			else
			{
				System.out.println("We are not open");
			}
		}
		
		//programmer name
		System.out.println("Programmer name: Anthony Amaya");
		
	}
	
	/**
	 * Generates a order number for current order
	 * @param o the current order
	 * @param time of order
	 * @param day of order
	 * @param cust current customer
	 * @return the randomly generated order number
	 */
	public static int generateOrderNum(Order o, int time, Day day, Customer cust)
	{
		int orderNumber = 0;
		
		o = new Order(time, day, cust);
		orderNumber = o.generateOrder();
		
		return orderNumber;
	}
	
	/**
 	 * Gets the type of drink the customer wants
	 * @return the type of drink the customer wants
	 */
	public static Type createDrink()
	{
		Scanner keyboard = new Scanner(System.in);
		int drink = 0;
		Type type = null;
		
		//lets user choose what drink to order
		System.out.print("Enter beverage(enter 1 for coffee, 2 for alcohol, or 3 for smoothie): ");
		drink = keyboard.nextInt();
		keyboard.nextLine();
		
		//the type variable is assigned the type of drink
		switch(drink)
		{
			case 1:
				type = Type.COFFEE;
				break;
			
			case 2:
				type = Type.ALCOHOL;
				break;
				
			case 3:
				type = Type.SMOOTHIE;
				break;
		}
		
		return type;
		
	}
	
	/**
	 * Gets the day of the order
	 * @return the day of the order
	 */
	public static Day dayOfWeek()
	{
		Scanner keyboard = new Scanner(System.in);
		
		Day day = null;
		
		//lets user choose what day it is
		System.out.print("Enter day(enter 1 for Sunday, 2 for Monday, 3 for Tuesday, 4 for Wednesday, 5 for Thursday, 6 for Friday, or 7 for Saturday): ");
		int num = keyboard.nextInt(); 
		keyboard.nextLine();
		
		//the day variable is assigned the type of day
		switch(num)
		{
			case 1:
				day = Day.SUNDAY;
				break;
		
			case 2:
				day = Day.MONDAY;
				break;
			
			case 3:
				day = Day.TUESDAY;
				break;
			
			case 4:
				day = Day.WEDNESDAY;
				break;
			
			case 5:
				day = Day.THURSDAY;
				break;
			
			case 6: 
				day = Day.FRIDAY;
				break;
			
			case 7:
				day = Day.SATURDAY;
				break;
		
		}
		
		return day;
		
	}
	
	/**
	 * Creates the current customer
	 * @return the current customer
	 */
	public static Customer createCustomer()
	{
		Scanner keyboard = new Scanner(System.in);
		
		int age = 0;	//variable to hold customer age
		Customer cust;	//variable to return
		
		//asks for customer name
		System.out.print("Enter customer name: ");
		String customerName = keyboard.nextLine();
		
		//asks for customer age
		System.out.print("Enter customer age: ");
		age = keyboard.nextInt();
		keyboard.nextLine();
		
		//creates new customer using given name and age
		cust = new Customer(customerName, age);
		
		return cust;
	}
	
	/**
	 * If the drink was coffee then adds a coffee to current order
	 * @param order the current order with coffee added
	 */
	public static void orderCoffee(BevShop order)
	{
		
		Size size = null;	//variable to hold size of drink
		Scanner keyboard = new Scanner(System.in);
		
		//gets the beverage name
		System.out.print("Enter the beverage name: ");
		String bevName = keyboard.nextLine();
		
		//gets the beverage size
		System.out.print("Enter beverage size(enter 1 for small, 2 for medium, or 3 for large): ");
		int sizeNum = keyboard.nextInt();
		keyboard.nextLine();
		
		size = null;
		
		//makes the size variable the appropriate size chosen
		switch(sizeNum)
		{
			case 1:
				size = Size.SMALL;
				break;
			
			case 2:
				size = Size.MEDIUM;
				break;
			
			case 3:
				size = Size.LARGE;
				break;
				
		}
		
		//asks if the customer wants an extra shot
		System.out.print("Would you like an extra shot?(yes or no): ");
		String extraShot1 = keyboard.nextLine();
		
		//asks if the user wants extra syrup
		System.out.print("Would you like extra syrup?(yes or no): ");
		String extraSyrup1 = keyboard.nextLine();
		
		//boolean variables to hold whether the customer wanted an extra shot or extra syrup
		boolean extraShot = false;
		boolean extraSyrup = false;
		
		//makes boolean variable equal to appropriate customer answer
		if(extraShot1.equalsIgnoreCase("yes"))
		{
			extraShot = true;
		}
		if(extraSyrup1.equalsIgnoreCase("yes"))
		{
			extraSyrup = true;
		}
		
		//adds the coffee to the current order
		order.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
	
	}
	
	/**
	 * Adds alcohol to the current order
	 * @param order to add alcohol to
	 * @param cust current customer to get age
	 */
	public static void orderAlcohol(BevShop order, Customer cust)
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		Size size = null;	//Size variable to hold wanted size
		
		//checks the customer age to see if it is valid
		if(order.isValidAge(cust.getAge()) == true)
		{
			//gets the beverage name
			System.out.print("Enter the beverage name: ");
			String bevName = keyboard.nextLine();
			
			//gets the beverage size
			System.out.print("Enter beverage size(enter 1 for small, 2 for medium, or 3 for large): ");
			int sizeNum = keyboard.nextInt();
			keyboard.nextLine();
			
			size = null;
			
			//makes the size variable appropriate to chosen size
			switch(sizeNum)
			{
				case 1:
					size = Size.SMALL;
					break;
				
				case 2:
					size = Size.MEDIUM;
					break;
				
				case 3:
					size = Size.LARGE;
					break;
					
			}
			
			//adds alcohol to current order
			order.processAlcoholOrder(bevName, size);
			
		}
		
	}
	
	/**
	 * Adds a smoothie to the current order
	 * @param order to add a smoothie to
	 */
	public static void orderSmoothie(BevShop order)
	{
		Scanner keyboard = new Scanner(System.in);
		
		Size size = null;	//Size variable to hold chosen size
		int numOfFruit = 0;	//variable used to hold desired number of fruit
		String proteinAnswer;	//variable to hold whether the customer wants added protein
		boolean addProtein = false;	//boolean to tell if protein was added or not
		
		//gets the beverage name
		System.out.print("Enter the beverage name: ");
		String bevName = keyboard.nextLine();
		
		//gets the beverage size
		System.out.print("Enter beverage size(enter 1 for small, 2 for medium, or 3 for large): ");
		int sizeNum = keyboard.nextInt();
		keyboard.nextLine();
		
		//makes size variable equal the chosen size
		switch(sizeNum)
		{
			case 1:
				size = Size.SMALL;
				break;
			
			case 2:
				size = Size.MEDIUM;
				break;
			
			case 3:
				size = Size.LARGE;
				break;
				
		}
		
		//gets how many fruits the customer wants to add
		System.out.print("How many fruits would you like to add?: ");
		numOfFruit = keyboard.nextInt();
		keyboard.nextLine();
		
		//checks if the chosen amount of fruit exceeds the max amount of fruit
		if(order.isMaxFruit(numOfFruit) == true)
		{
			//does not allow customer to order above max amount of fruit
			while(order.isMaxFruit(numOfFruit) == true)
			{
				
				System.out.println("Maximum number of fruits was reached, max number is 5");
				
				System.out.print("How many fruits would you like to add?: ");
				numOfFruit = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		
		//asks if the customer wants protein
		System.out.print("Would you like to add protein?(yes or no): ");
		proteinAnswer = keyboard.nextLine();
		
		//if the customer wanted protein, makes the protein boolean variable equal true
		if(proteinAnswer.equalsIgnoreCase("yes"))
		{
			addProtein = true;
		}
		
		//adds a smoothie to the order
		order.processSmoothieOrder(bevName, size, numOfFruit, addProtein);
	
	}
	
}