 package com.basic.project.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.basic.project.entity.Account;
import com.basic.project.entity.AtmCard;
import com.basic.project.entity.Customer;
import com.basic.project.entity.Transaction;

public class AtmCardDaoImpl implements AtmCardDao
{

	EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	@Override
	public String deposit(Customer customer, Integer depositAmount) 
	{
		Account account = customer.getAccount().get(0);
		entityTransaction.begin();
		customer.getAccount().get(0).setBalance(customer.getAccount().get(0).getBalance()+depositAmount);
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setTransactionAmount(depositAmount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionType("Cr");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Amount Deposited successfully";
	}

	@Override
	public String withdraw(Customer customer, Integer withdrawAmount) 
	{
		Account account = customer.getAccount().get(0);
		entityTransaction.begin();	
		customer.getAccount().get(0).setBalance(customer.getAccount().get(0).getBalance()-withdrawAmount);
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setTransactionAmount(withdrawAmount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionType("De");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Amount Withdrawal successfully";
	}

	@Override
	public Integer checkBalance(Customer customer) 
	{
		Account account = customer.getAccount().get(0);
		return account.getBalance();
	}

	@Override
	public String changePin(Customer customer,String newPin,String confirmPin) 
	{
		Account account = customer.getAccount().get(0);
		AtmCard atmCard = account.getAtmCard();
		entityTransaction.begin();
		atmCard.setCardPin(newPin);
		entityManager.persist(atmCard);
		entityTransaction.commit();
		return " PIN changed successfully";
	}

	@Override
	public List<Transaction> miniStatement(Customer customer) 
	{
		String accountNo = customer.getAccount().get(0).getAccountNumber();
		String jpql = "select a from Transaction a where a.account.accountNumber =: accountNo ORDER BY a.transactionTime DESC";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("accountNo", accountNo);
		query.setMaxResults(10);
		List<Transaction> transactions = query.getResultList();
		return transactions;

	}
	@Override
	public String reciept(Customer customer,LocalDate date) 
	{
		Account account=customer.getAccount().get(0);
		String jpql = "select transactionId from Transaction a where a.account.accountNumber = :accountNo AND a.transactionDate=:date ORDER BY a.transactionDate DESC, a.transactionTime DESC";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("accountNo",account.getAccountNumber());
		query.setParameter("date", date);
		query.setMaxResults(1);
		return (String) query.getSingleResult();
	}

	 @Override
	 public Integer getDailyWithdrawalCount(Customer customer, LocalDate date) 
	 {
		 String jpql = "SELECT COUNT(a) FROM Transaction a WHERE a.account.accountNumber = :account AND a.transactionDate = :date AND a.transactionType='De'";
		 Query query = entityManager.createQuery(jpql);
		 query.setParameter("account", customer.getAccount().get(0).getAccountNumber());
	     query.setParameter("date", date);
	     return ((Number) query.getSingleResult()).intValue();
	 }

	@Override
	public Integer getDailyDepositCount(Customer customer, LocalDate date) 
	{
		String jpql = "SELECT COUNT(a) FROM Transaction a WHERE a.account.accountNumber = :account AND a.transactionDate = :date AND a.transactionType = 'Cr'";
		Query query =entityManager.createQuery(jpql);
		query.setParameter("account", customer.getAccount().get(0).getAccountNumber());
		query.setParameter("date", date);
		return ((Number) query.getSingleResult()).intValue();
	}

}




















/*

	@Override
	public String reciept(Customer customer) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		Account account=customer.getAccount().get(0);
		AtmCard atmCard = account.getAtmCard();
		String jpql="select a from Transaction a where a.account=:account AND a.transactionDate =:date AND a.transactionTime =:time ORDER BY a.transactionDate DESC, a.transactionTime DESC";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("account",account);
		query.setParameter("date", date);
		query.setParameter("time", time);
		query.setMaxResults(1);
		
		Transaction currentTransaction = null;
		
		try
		{
			currentTransaction =  (Transaction) query.getSingleResult();
			
			//System.out.println("+-------------------------------------------+------------------------------------------------------+----------------------------------+----------------------------------+---------------------------------+---------------------------------+");
			System.out.println();
			System.out.println("\t\t\t\t\t|-------------------------------------------------|");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|\t        TRANSACTION RECIEPT   \t\t  |");
			System.out.println("\t\t\t\t\t|"+"\t     ___________________________  \t  |");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
		//	System.out.println("+-------------------------------------------+------------------------------------------------------+----------------------------------+----------------------------------+---------------------------------+---------------------------------+");
			System.out.println("\t\t\t\t\t|  DATE"+"\t\t\t\t TIME"+"\t\t  |");
			System.out.println("\t\t\t\t\t|  "+currentTransaction.getTransactionDate()+"\t\t\t"+currentTransaction.getTransactionTime()+"|");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|  Card No. "+"\t\t\t Account Type"+"\t  |");
			System.out.println("\t\t\t\t\t|  "+atmCard.getCardNo() +"\t\t "+account.getAccountStatus()+"\t\t  |");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|  Transaction type "+ currentTransaction.getTransactionType() + " from checking"+"\t\t  |");
			System.out.println("\t\t\t\t\t|  transaction # "+ currentTransaction.getTransactionId()+"\t\t  |");
			//System.out.println("+-------------------------------------------+------------------------------------------------------+----------------------------------+----------------------------------+---------------------------------+---------------------------------+");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|  Transaction Amount "+"\t\t "+ currentTransaction.getTransactionAmount()+"\t\t  |");
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|  From: Account # "+ "\t\t "+account.getAccountNumber()+"\t  |");
			System.out.println("\t\t\t\t\t|  Available Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
			System.out.println("\t\t\t\t\t|  Total Balance "+"\t\t "+account.getBalance()+"\t\t  |"); 
			System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t  |");
			System.out.println("\t\t\t\t\t|-------------------------------------------------|");
			
		}
		catch(NoResultException e) 
		{
			System.out.println("");
			//System.out.println("\t\t\t\t\t Transaction not found for reciept");
		}
		return "";
	}

*/

/*@Override
public String miniStatement(Customer customer) {
LocalDate localDate = LocalDate.now();
LocalTime localTime = LocalTime.now();
Account account = customer.getAccount().get(0);
AtmCard atmCard = account.getAtmCard();
String jpql = "select a from Transaction a where a.account =: account";
Query query = entityManager.createQuery(jpql);
query.setParameter("account", account);
query.setMaxResults(10);
List<Transaction> transactions = query.getResultList();

//System.out.println("\t\t\t\t\t|-----------------------------------------------|");
//System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t|");
//System.out.println("\t\t\t\t\t| "+"\t\t"+" MINI STATEMENT \t\t|");
//System.out.println("\t\t\t\t\t|"+"\t      ____________________\t\t|");

//System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t|");

if (transactions.isEmpty()) 
{
    System.out.println("\t\t\t\t\t No transactions available for this account ");
} 
else 
{
	System.out.println();
	System.out.println("\t\t\t\t\t|-------------------------------------------------------|");
	System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
	//System.out.println("\t\t\t\t\t|  " + "\t\t" + "   ATM Customer Advice\t\t\t|");
	//System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t|  "+"\t\t\t"+customer.getBank().getBankName()+"\t\t\t|");
	System.out.println("\t\t\t\t\t| " + "\t\t   ____________________ \t\t|");
	System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t|   DATE"+"\t\t\t TIME"+"\t\t\t"+ "|");
	System.out.println("\t\t\t\t\t|   "+localDate.now()+"\t\t\t "+localTime.now()+"\t|");
	System.out.println("\t\t\t\t\t| "+"\t\t\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t|   CARD NUMBER: "+ "\t\t "+atmCard.getCardNo()+"\t|");
	System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t|   STATEMENT FOR:"+ "\t\t "+account.getAccountNumber()+"\t\t|");
	System.out.println("\t\t\t\t\t| " + "\t\t\t\t\t\t\t|");
//	System.out.println("\t\t\t\t\t|   Transaction Date "+"\t\t Transaction Amount"+"\t|");
	//System.out.println("\t\t\t\t\t| "+"\t\t\t\t\t\t\t|");
	for(Transaction transaction : transactions)
	{
 		System.out.println("\t\t\t\t\t|   "+transaction.getTransactionDate()+"   "+transaction.getTransactionType()+"\t\t "+transaction.getTransactionAmount()+"\t\t\t|");
	}
	System.out.println("\t\t\t\t\t|"+"\t\t\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t|   Available Balance "+"\t\t "+account.getBalance()+"\t\t\t|");
	//System.out.println("\t\t\t\t\t|"+" Thank You..."+"\t\t\t\t\t|");
	System.out.println("\t\t\t\t\t| "+"\t\t\t\t\t\t\t|");
	System.out.println(" \t\t\t\t\t|-------------------------------------------------------|");
}
return "";

}*/