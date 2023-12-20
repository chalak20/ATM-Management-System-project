package com.basic.project.dao;

import java.time.LocalDate;
import java.util.List;

import com.basic.project.entity.Customer;
import com.basic.project.entity.Transaction;

public interface AtmCardDao
{
	String deposit(Customer customer, Integer depositAmount);
	String withdraw(Customer customer, Integer withdrawAmount);
	Integer checkBalance(Customer customer);
	String changePin(Customer customer,String newPin, String confirmPin);
	List<Transaction> miniStatement(Customer customer);
	//String miniStatement(Customer customer);
	String reciept(Customer customer,LocalDate date); 
	Integer getDailyWithdrawalCount(Customer customer, LocalDate date);
	Integer getDailyDepositCount(Customer customer,LocalDate date);
}