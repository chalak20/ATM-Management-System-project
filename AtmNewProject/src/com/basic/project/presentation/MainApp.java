package com.basic.project.presentation;

import java.util.Scanner;

import com.basic.project.entity.Customer;

public class MainApp {

	public static void displayMenu(Customer customer2)
		{
			Scanner scanner = new Scanner(System.in);
			App app = new AppImpl();
			
			int choice = 0;
			while(choice != 7)
			{
				System.out.println();
				System.out.println("************************************************************************************************************************************************");
				System.out.println("                                          		Well-Come To " +customer2.getBank().getBankName()+" ATM System 			                                                  ");
				System.out.println("                                             "+"              ");
				System.out.println("************************************************************************************************************************************************");
				System.out.println();

				System.out.println("\t\t\t\t\t Welcome "+ customer2.getCustomerName()+"\t\t Account Number :: "+customer2.getAccount().get(0).getAccountNumber());
				//System.out.println("**************************** Welcome to the ATM System *****************************");
				System.out.println();
				System.out.println("\t\t\t\t\t 1. Balance Enquiry"+"\t\t\t 2. Withdrawl " );
				System.out.println();
				System.out.println("\t\t\t\t\t 3. Deposit "+"\t\t\t\t 4. Mini Statement ");
				System.out.println();
				System.out.println("\t\t\t\t\t 5. PIN Change "+"\t\t\t\t 6. Exit  ");
				System.out.println();
				//System.out.println("\t\t\t\t\t 7. Exit");
				//System.out.println();
	            
	            System.out.print("\t\t\t\t\t Please Select Your Transaction ");
	            System.out.println();
	            AppImpl.displayInputPrompt("\t\t\t\t\t ");
	            choice = scanner.nextInt();
	            
	            switch(choice)
	            {
	            	case 1:
	            		app.checkBalance(customer2);
	            	break;
	            	
	            	case 2:
	            		app.withdraw(customer2);
	            		//app.reciept(customer2);
	            	break;
	            	
	            	case 3:
	            		app.deposit(customer2);
	            	//	app.reciept(customer2);
	            	break;
	            	
	            	case 4:
	            		app.miniStatement(customer2);
	            	break;
	            	
	            	case 5:
	            		app.changePin(customer2);
	            		break;
	            		
//	            	case 7:
//	            		app.reciept(customer2);
//	            		break;
	            	
	            	case 6:
	            		System.out.println();
	                    System.out.println("*********************************************************** Thank you! Visit Again ************************************************************");
	                    System.exit(0);

	                default:
	                    System.out.println("\t\t\t\t\t Invalid option. Please try again.");
	            }
			}
		}
}







/*public class MainApp
{

	public static void displayMenu(Customer customer2)
	{
		Scanner sc = new Scanner(System.in);
		
		
		
		Integer choice=0;
		
		while(choice!=6)
		{
		
			System.out.println("                  ***************************************************************************************");
			System.out.println("                                           Well-Come To ATM System                          ");
			System.out.println("                  ***************************************************************************************");
			
			System.out.println();
			System.out.println("Welcome "+ customer2.getCustomerName() +  "                                 AccountNumber : "  + customer2.getAccount().get(0).getAccountNumber());
			System.out.println("1. Check Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Mini Statement");
			System.out.println("5. Change Pin");
			System.out.println("6. Exit");
			
			System.out.println(" What would like to do ? ");
			
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("");
				
				break;
				
			case 2:
				System.out.println("");
				
				break;
				
			case 3:
				System.out.println("");
				
				break;
				
			case 4:
				System.out.println("");
				
				break;
				
			case 5:
				System.out.println("");
				
				break;
				
			case 6:
				System.out.println("------------------Exit--------------------");
				System.exit(0);
			   

			default:
				System.out.println("Invalid choice...");
				break;
			}
		}
	}
}

*/













/*

System.out.println("**************************** Welcome to the ATM System *****************************");
System.out.println();
System.out.println("1. Check Balance"+"\t\t\t\t 2. Withdraw " );
System.out.println();
System.out.println("3. Deposit "+"\t\t\t\t\t 4. Mini Statement ");
System.out.println();
System.out.println("5. Change PIN "+"\t\t\t\t\t 6. Exit ");
System.out.println();

*/