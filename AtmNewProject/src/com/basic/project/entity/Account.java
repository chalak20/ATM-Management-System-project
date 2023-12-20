package com.basic.project.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@Column(length = 14,nullable = false)
	private String accountNumber;
	@Column(length = 7,nullable = false)
	private String accountType;
	@Column(nullable = false)
	private Date accountOpeningDate;
	@Column(length = 6,nullable = false)
	private String accountStatus;
	@Column(nullable = false)
	private Integer balance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL)
	private List<Transaction> transaction;

	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
	private AtmCard atmCard;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public AtmCard getAtmCard() {
		return atmCard;
	}

	public void setAtmCard(AtmCard atmCard) {
		this.atmCard = atmCard;
	}

	
}
