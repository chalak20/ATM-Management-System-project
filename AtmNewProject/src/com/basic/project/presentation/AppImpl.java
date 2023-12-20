package com.basic.project.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.basic.project.entity.Account;
import com.basic.project.entity.AtmCard;
import com.basic.project.entity.Customer;
import com.basic.project.entity.Transaction;
import com.basic.project.service.AtmCardService;
import com.basic.project.service.AtmCardServiceImpl;

public class AppImpl implements App{
	
	Scanner scanner = new Scanner(System.in);
	AtmCardService atmService = new AtmCardServiceImpl();
	private final Integer maxTransactionPerDay = 3;
	
	@Override
	public void deposit(Customer customer) {
		Account account = customer.getAccount().get(0);
		AtmCard atmCard = account.getAtmCard();
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		Integer dailyDepositCount = atmService.getDailyDepositCount(customer, localDate);
		System.out.print("\t\t\t\t\t Enter the amount you want to deposit :: ");
		System.out.println();
		Integer depositAmount;
		while(true)
		{
			//	System.out.println();
			displayInputPrompt("\t\t\t\t\t ");
			depositAmount = scanner.nextInt();
			
			if(depositAmount % 100 != 0)
			{
				 System.out.println();
				 System.out.println( "\t\t\t\t\t Please enter an amount in multiples of 100.");
			}
			else if(depositAmount >= 50000  )
			{
				System.out.println();
				System.out.println("\t\t\t\t\t Deposit limit exceeded. Enter amount up to 50,000 at a time.");
			}
			else if(depositAmount <= 0 )
			{
				System.out.println();
				System.out.println( "\t\t\t\t\t Please enter a non-negative deposit amount.");
			}
			else if(dailyDepositCount >= maxTransactionPerDay)
			{
				System.out.println();
				System.out.println("\t\t\t\t\t Maximum deposit limit for the day reached. Try again tomorrow.");
				break;
			}
			else
			{
				System.out.println("\t\t\t\t\t"+ atmService.deposit(customer, depositAmount));
				System.out.println();
				System.out.println("\t\t\t\t\t"+" Please take your receipt");
				System.out.println();
				System.out.println("\t\t\t\t\t|-------------------------------------------------|");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|\t             "+customer.getBank().getBankName() +"\t\t          |");
				System.out.println("\t\t\t\t\t|"+"\t        _____________________     \t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");		
				System.out.println("\t\t\t\t\t|  DATE"+"\t\t\t\t TIME"+"\t\t  |");
				System.out.println("\t\t\t\t\t|  "+localDate+"\t\t\t"+localTime+"|");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Card No. "+"\t\t\t Account Type"+"\t  |");
				System.out.println("\t\t\t\t\t|  "+atmCard.getCardNo() +"\t\t "+account.getAccountStatus()+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Transaction type "+ "\"Cr\""+ " from checking"+"\t          |");
				System.out.println("\t\t\t\t\t|  transaction # "+ atmService.reciept(customer,localDate)+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Transaction Amount "+"\t\t "+depositAmount+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  From: Account # "+ "\t\t "+account.getAccountNumber()+"\t  |");
				System.out.println("\t\t\t\t\t|  Available Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
				System.out.println("\t\t\t\t\t|  Total Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|-------------------------------------------------|");
				System.out.println();
				System.out.println("\t\t\t\t\t Thank you for using our ATM");
				break;
			}
		}	
	}

	@Override
	public void withdraw(Customer customer) 
	{
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		Integer dailyWithdrawalCount = atmService.getDailyWithdrawalCount(customer, localDate);
		Account account = customer.getAccount().get(0);
		AtmCard atmCard = account.getAtmCard();
		Integer currentBalance = atmService.checkBalance(customer);
		System.out.print("\t\t\t\t\t Enter the amount you want to withdraw ");
		System.out.println();
		Integer withdrawalAmount ;
		while(true)
		{
			displayInputPrompt("\t\t\t\t\t ");
			withdrawalAmount = scanner.nextInt();
			 
			if (withdrawalAmount % 100 != 0) 
		    {
				System.out.println();
				System.out.println("\t\t\t\t\t Please enter an amount in multiples of 100.");
				
		    }
			else if (withdrawalAmount > currentBalance)
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t Insufficient balance. Please check your account balance."); 
	            break;
	        } 
		    else if (withdrawalAmount > 25000) 
		    {
		    	System.out.println();
		    	System.out.println("\t\t\t\t\t Withdrawal limit exceeded. Enter amount up to 25,000 at a time.");
		    }
		    else if (withdrawalAmount <= 0) 
		    {
		    	System.out.println();
		        System.out.println("\t\t\t\t\t Please enter a non-negative withdraw amount.");
		    }
		    else if (dailyWithdrawalCount >= maxTransactionPerDay) 
	        {
		    	 System.out.println();
	             System.out.println("\t\t\t\t\t Maximum withdrawal limit for the day reached. Try again tomorrow.");
	             break;
	        }
		    else
		    {
		        System.out.println("\t\t\t\t\t"+ atmService.withdraw(customer, withdrawalAmount));
		        System.out.println();
		    	System.out.println("\t\t\t\t\t|-------------------------------------------------|");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|\t             "+ customer.getBank().getBankName()+"\t\t          |");
				System.out.println("\t\t\t\t\t|"+"\t        _____________________     \t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");	
				System.out.println("\t\t\t\t\t|  DATE"+"\t\t\t\t TIME"+"\t\t  |");
				System.out.println("\t\t\t\t\t|  "+localDate+"\t\t\t"+localTime+"|");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Card No. "+"\t\t\t Account Type"+"\t  |");
				System.out.println("\t\t\t\t\t|  "+atmCard.getCardNo() +"\t\t "+account.getAccountStatus()+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Transaction type "+ "\"De\""+ " from checking"+"\t\t  |");
				System.out.println("\t\t\t\t\t|  transaction # "+ atmService.reciept(customer,localDate)+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  Transaction Amount "+"\t\t "+withdrawalAmount+"\t\t  |");
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|  From: Account # "+ "\t\t "+account.getAccountNumber()+"\t  |");
				System.out.println("\t\t\t\t\t|  Available Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
				System.out.println("\t\t\t\t\t|  Total Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
				System.out.println("\t\t\t\t\t|-------------------------------------------------|");
				System.out.println();
				System.out.println("\t\t\t\t\t Thank you for using our ATM");
		        break;
		    }
		}		
	}

	@Override
	public void checkBalance(Customer customer) {
		Integer balance = atmService.checkBalance(customer);
		System.out.println();
		System.out.println("\t\t\t\t\t Your current balance is :: "+balance);
	}

	@Override
	public void changePin(Customer customer) 
	{
	    System.out.print("\t\t\t\t\t Enter your new PIN :: ");
	    System.out.println();
	    String newPin;
	    String confirmPin;
	    String oldPin = customer.getAccount().get(0).getAtmCard().getCardPin();

	    while (true) 
	    {
	    	displayInputPrompt("\t\t\t\t\t ");
	        newPin = scanner.next();

	        if (newPin.length() != 4) 
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t PIN length must be of 4 digits. Enter pin again");
	            //System.out.print("\t\t\t\t\t Enter your new PIN again :: ");
	        } 
	        else if (!newPin.matches("[0-9]+")) 
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t Please enter a four-digit numeric PIN. Enter pin again");
	           // System.out.print("\t\t\t\t\t Enter your new PIN again :: ");
	        } 
	        else if (!uniquePinDigit(newPin)) 
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t All digits must be unique. Please choose a different PIN");
	           // System.out.print("\t\t\t\t\t Enter your new PIN again :: ");
	        } 
	        else if (newPin.equals(oldPin)) 
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t New PIN cannot be the same as the old PIN. Please choose a different PIN");
	        } 
	        else if (newPin.equals("0000")) 
	        {
	        	System.out.println();
	            System.out.println("\t\t\t\t\t Please choose a different PIN other than 0000. Enter pin again");
	          //  System.out.print("\t\t\t\t\t Enter your new PIN again :: ");
	        } 
	        else 
	        {
	        	System.out.println();
	            System.out.print("\t\t\t\t\t Re-enter Pin to confirm :: ");
	            System.out.println();
	            displayInputPrompt("\t\t\t\t\t ");
	            confirmPin = scanner.next();

	            if (!confirmPin.equals(newPin)) {
	                System.out.println();
	                System.out.println("\t\t\t\t\t New PIN and confirm PIN do not match.");
	                System.out.println();
	                System.out.println("\t\t\t\t\t Please enter your new PIN again");
	                
	            } else {
	                System.out.println();
	                System.out.println("\t\t\t\t\t" + atmService.changePin(customer, newPin, confirmPin));
	                break;
	            }
	        }
	    }
	}

	@Override
	public void miniStatement(Customer customer) 
	{
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		Account account = customer.getAccount().get(0);
		List<Transaction> transactions = atmService.miniStatement(customer);
		AtmCard atmCard = account.getAtmCard();
		while(true)
		{
			if (transactions.isEmpty()) 
			{
				System.out.println();
			    System.out.println("\t\t\t\t\t No transactions available for this account ");
			    break;
			} 
			else 
			{
				System.out.println();
				System.out.println("\t\t\t\t\t|-----------------------------------------------|");
				System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t|");
				//System.out.println("\t\t\t\t\t|  " + "\t\t" + "   ATM Customer Advice\t\t\t|");
				//System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t|  "+"\t\t  "+customer.getBank().getBankName()+"  \t\t\t|");
				System.out.println("\t\t\t\t\t| " + "\t      ___________________\t    v   |");
				System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t|   DATE"+"\t\t TIME"+"\t\t\t"+ "|");
				System.out.println("\t\t\t\t\t|   "+localDate.now()+"\t\t "+localTime.now()+"\t|");
				System.out.println("\t\t\t\t\t| "+"\t\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t|   CARD NUMBER: "+ "\t "+atmCard.getCardNo()+"\t|");
				System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t|   STATEMENT FOR:"+ "\t "+account.getAccountNumber()+"\t\t|");
				System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t|");
				//	System.out.println("\t\t\t\t\t|   Transaction Date "+"\t\t Transaction Amount"+"\t|");
				for(Transaction transaction : transactions)
				{
		     		System.out.println("\t\t\t\t\t|   "+transaction.getTransactionDate()+"   "+transaction.getTransactionType()+"\t "+transaction.getTransactionAmount()+"\t\t\t|");
				}
				System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t|   Available Balance "+"\t "+account.getBalance()+"\t\t\t|");
				//System.out.println("\t\t\t\t\t|"+" Thank You..."+"\t\t\t\t\t|");
				System.out.println("\t\t\t\t\t| "+"\t\t\t\t\t\t|");
				System.out.println(" \t\t\t\t\t|-----------------------------------------------|");
				break;
			}
		}
		
	}
	
	private boolean uniquePinDigit(String pinNo)
	{
		for(Integer i=0;i<pinNo.length();i++)
		{
			Character currentDigit = pinNo.charAt(i);
			for(Integer j=i+1;j<pinNo.length();j++)
			{
				if(currentDigit == pinNo.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void displayInputPrompt(String msg) {
	  System.out.print(msg);
	}
 

}




















//@Override
//public void reciept(Customer customer) {
//	System.out.println("\t\t\t\t\t"+ "Dou you want reciept ? yes/no ");
//	String receiptChoice = scanner.next();
//	
//	if(receiptChoice.equalsIgnoreCase("yes"))
//	{
//		System.out.println("\t\t\t\t\t"+ atmService.reciept(customer));
//	}
//	
//}