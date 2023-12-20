package com.basic.project.service;

import java.time.LocalDate;
import java.util.List;

import com.basic.project.entity.Account;
import com.basic.project.entity.Customer;
import com.basic.project.entity.Transaction;

public interface AtmCardService {

	String deposit(Customer customer,Integer depositAmount);
	String withdraw(Customer customer, Integer withdrawAmount);
	Integer checkBalance(Customer customer);
	String changePin(Customer customer, String newPin,String confirmPin);
	List<Transaction> miniStatement(Customer customer);
//	String miniStatement(Customer customer);
	Integer getDailyWithdrawalCount(Customer customer, LocalDate date);
	Integer getDailyDepositCount(Customer customer,LocalDate date);
	String reciept(Customer customer,LocalDate date);
//	String depositTransactionLimit(Customer customer);
	
	
}