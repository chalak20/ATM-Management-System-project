package com.basic.project.service;

import java.time.LocalDate;
import java.util.List;

import com.basic.project.dao.AtmCardDao;
import com.basic.project.dao.AtmCardDaoImpl;
import com.basic.project.entity.Account;
import com.basic.project.entity.Customer;
import com.basic.project.entity.Transaction;

public class AtmCardServiceImpl implements AtmCardService{
	
	AtmCardDao atmDao = new AtmCardDaoImpl();

	@Override
	public String deposit(Customer customer, Integer depositAmount) 
	{

		atmDao.deposit(customer, depositAmount);
		System.out.println();
		return " Your amount has been successfully credited to your account";	
	}

	@Override
	public String withdraw(Customer customer, Integer withdrawAmount) 
	{
		atmDao.withdraw(customer, withdrawAmount);
	    System.out.println();
	    return " Please collect your cash and reciept.";
	}

	@Override
	public Integer checkBalance(Customer customer) {
		return atmDao.checkBalance(customer);
	}

	@Override
	public String changePin(Customer customer, String newPin,String confirmPin) 
	{
		 atmDao.changePin(customer, newPin,confirmPin);
		 return " Your PIN has been changed";	
	}

	@Override
	public List<Transaction> miniStatement(Customer customer) {
		return atmDao.miniStatement(customer);
	}

	@Override
	public String reciept(Customer customer,LocalDate date) {
		return atmDao.reciept(customer,date);
	}

	@Override
	public Integer getDailyWithdrawalCount(Customer customer, LocalDate date) {
		return atmDao.getDailyWithdrawalCount(customer, date);
	}

	@Override
	public Integer getDailyDepositCount(Customer customer, LocalDate date) {
		return atmDao.getDailyDepositCount(customer, date);
	}
}







/*


@Override
public String deposit(Customer customer, Integer depositAmount) {
	
	Integer transactionLimit = atmDao.depositTransactionLimit(customer);
	
	if(transactionLimit <= 3)
	{
		return "Deposit Transaction limit exceeded for the day. You cannot perform more transactions.";
	}
	else
	{
		if(depositAmount % 100 != 0)
		{
			 return " Invalid deposit amount. Please enter an amount in multiples of 100.";
		}
		else if(depositAmount >= 50000  )
		{
			return " Deposit limit exceeded. You can deposit up to 50,000 at a time.";
		}
		else if(depositAmount < 0 )
		{
			return "Invalid deposit amount. Please enter a non-negative deposit amount.";
		}
		else
		{
			atmDao.deposit(customer, depositAmount);
			return " Amount deposited successfully ";	
		}
	}
}
*
*/



/*
@Override
public String changePin(Customer customer, String newPin, String confirmPin) 
{
	Account account = customer.getAccount().get(0);
	String oldPin = account.getAtmCard().getCardPin();
	
	//if(newPin.isEmpty() || newPin.length() != 4 || !newPin.matches("[0-9]+") || oldPin.equals(newPin) || newPin.equals("0000"))
	// if (newPin.isEmpty()) 
	//{
    //        return " PIN cannot be empty.";
    //} 
	while(true)
	{		
		 if (newPin.length() != 4) 
		 {
	            return " Invalid PIN length. Please enter a four-digit numeric PIN";
	     } 
		 else if (!newPin.matches("[0-9]+")) 
		 {
	            return " Invalid PIN format. Please enter a four-digit numeric PIN";
	     } 
		 else if (newPin.equals(oldPin)) 
		 {
	            return " New PIN must be different from the old PIN. Please choose a different PIN";
	     } 
		 else if (!uniquePinDigit(newPin)) 
	     {
	            return " Invalid PIN. All digits must be unique Please choose a different PIN";
	     }
		 else if(!newPin.equals(confirmPin))
		 {
			    return " New PIN and confirm PIN do not match. Please try again";
		 }
	     else
	     {
	    	 atmDao.changePin(customer, newPin,confirmPin);
	 	 	 return " Your PIN has been changed"; 
	     }
	}
}
*/