package com.basic.project.presentation;

import java.util.Scanner;
import com.basic.project.entity.Customer;
import com.basic.project.service.CustomerService;
import com.basic.project.service.CustomerServiceImpl;

public class Login {

	public static void main(String[] args) {
	
		boolean flagCardNo=true;
		boolean flagCardPin=true;
		
		Scanner scanner = new Scanner(System.in);
		CustomerService customerService =new CustomerServiceImpl();
	//	Account account = new Account();	
		Integer remainingAttempts = 3;
		
		while(flagCardNo && remainingAttempts > 0) 
		{
			System.out.println();         
			System.out.print("Enter your ATM card number :: ");
			//	AppImpl.displayInputPrompt("\t\t\t\t\t ");
			String cardNo = scanner.next();		
			Integer remainingAttempt = 3;
			String status = "Deactive";	
			Customer customer2 = customerService.findCardNumber(cardNo);

			if(customer2 != null && isValidCardNumber(cardNo) )
			{
				flagCardNo=false;
				
				if(!customer2.getAccount().get(0).getAtmCard().getCardStatus().equals(status))
				{
					while(flagCardPin && remainingAttempt > 0)
					{
						System.out.println();
						System.out.print("Enter your PIN :: ");
						String pinNo = scanner.next();
						
						if(isValidPin(pinNo) && pinNo.equals(customer2.getAccount().get(0).getAtmCard().getCardPin()))
						{
							flagCardPin = false;				
							MainApp.displayMenu(customer2);
							break;
						}
						else
						{
							remainingAttempt--;					
							if(remainingAttempt > 0)
							{
								System.out.println();
								if(!(pinNo.length()==4))
								{
									System.out.println("Please enter a 4-digit PIN number.");
									System.out.println();
									if(remainingAttempt == 1)
									{
										System.out.println("Warning: This is your last attempt.");
										System.out.println();
										System.out.println("Your card is being blocked");
										System.out.println();
									}
								}
								else if(!(pinNo.matches("\\d+")))
								{
									System.out.println("Please enter PIN number containing only digits.");
									System.out.println();
									if(remainingAttempt == 1)
									{
										System.out.println("Warning: This is your last attempt.");
										System.out.println();
										System.out.println("Your card is being blocked");
										System.out.println();
									}
								}
								else //if(!(pinNo.equals(customer2.getAccount().get(0).getAtmCard().getCardPin())))
								{
									System.out.println("Invalid PIN number. Please try again.");
									System.out.println();
									if(remainingAttempt == 1)
									{
										System.out.println("Warning: This is your last attempt.");
										System.out.println();
										System.out.println("Your card is being blocked");
										System.out.println();
									}
								}
							}
							else
							{
								System.out.println();
								//System.out.print("Too many unsuccessful attempts. Sorry, try again later.");
								String cardStatus = customerService.cardStatus(customer2);
								System.out.println(cardStatus);
								System.out.println();
								System.out.println("Please contact your bank for assistance.");
								break;
							}
						}
					}//pin while	
				}
				else
				{
					System.out.println("Your card is blocked!!!");
					System.out.println();
					System.out.println("Please contact your bank for assistance.");
					System.out.println();
					System.exit(0);
				}
			}
			else
			{
				remainingAttempts--;

				
				if(remainingAttempts > 0)
				{
					System.out.println();
					if(!(cardNo.length()==16))
					{
						System.out.println("Please enter a 16-digit ATM card number.");
						System.out.println();
					}
					else if(!(cardNo.matches("\\d+")))
					{
						System.out.println("Please enter ATM card number containing only digits.");
						System.out.println();
					}
					else
					{
						//System.out.println();
						System.out.print("Invalid ATM card number. Please try again.");
						System.out.println();
					}	
					//System.out.print("Invalid ATM card number. Please try again. Remaining attempts: " + remainingAttempts);
					//System.out.println("Remaining Attempts : " +remainingAttempts);
				}
				else
				{
					System.out.println();
					System.out.print("Too many unsuccessful attempts. Sorry, try again later.");
				}
			}
			
		}	//Card Number while
	
	}
	
	private static boolean isValidCardNumber(String cardNo)
	{
		 String cardNumber = "\\d{16}";
		 if(cardNo.matches(cardNumber))
		{
			return true;
		}
		else
		{
			return false;
		}			
	}

	private static boolean isValidPin(String pinNo)
	{
		String cardPin = "\\d{4}";
		if(pinNo.matches(cardPin))
			return true;
		else
			return false;
	}	
}




















/*package com.basic.project.presentation;

import java.util.Scanner;

import com.basic.project.entity.Customer;
import com.basic.project.service.CustomerService;
import com.basic.project.service.CustomerServiceImpl;

public class Login {

	public static void main(String[] args) {
	
		boolean flagCardNo=true;
		boolean flagCardPin=true;
		
		Scanner scanner = new Scanner(System.in);
		CustomerService customerService =new CustomerServiceImpl();
		
		Integer remainingAttempts = 3;
		
		while(flagCardNo && remainingAttempts > 0) 
		{
			System.out.println();
			System.out.print("Enter your ATM card number :: ");
			String cardNo = scanner.next();
			
			Integer remainingAttempt = 3;
			
			Customer customer2 = customerService.findCardNumber(cardNo);

			if(customer2 != null && isValidCardNumber(cardNo) )
			{
				flagCardNo=false;
				while(flagCardPin && remainingAttempt > 0)
				{
					System.out.println();
					System.out.print("Enter your PIN :: ");
					String pinNo = scanner.next();
					
					if(isValidPin(pinNo) && pinNo.equals(customer2.getAccount().get(0).getAtmCard().getCardPin()))
					{
						flagCardPin = false;
						
						MainApp.displayMenu(customer2);
						break;
					}
					else
					{
						remainingAttempt--;
						
						if(remainingAttempt > 0)
						{
							System.out.println();
							System.out.print("Invalid PIN Number. Please try again. ");
							System.out.println();
							//System.out.println("Remaining Attempts : " +remainingAttempts);
						}
						else
						{
							System.out.println();
							System.out.print("Too many unsuccessfull attempts. Sorry try next time.");
							break;
						}
					}
				}//pin while
			}
			else
			{
				remainingAttempts--;

				
				if(remainingAttempts > 0)
				{
					System.out.println();
					System.out.print("Invalid ATM cardNumber. Please try again. ");
					//System.out.println("Remaining Attempts : " +remainingAttempts);
				}
				else
				{
					System.out.println();
					System.out.print("Too many unsuccessfull attempts. Sorry try next time.");
					break;
				}
			}
			
		}	//Card Number while
	
	}
	
	private static boolean isValidCardNumber(String cardNo)
	{
		String cardNumber = "[0-9]+";
		if(cardNo.matches(cardNumber))
			return true;
		else
			return false;
	}

	private static boolean isValidPin(String pinNo)
	{
		String cardPin = "[0-9]+";
		if(pinNo.matches(cardPin))
			return true;
		else
			return false;
	}	
}*/

// System.out.println("Could not retrieve account information. Please contact customer support.");
