package com.basic.project.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@Column(length = 16,nullable = false)
	private String transactionId;
	@Column(length = 5,nullable = false)
	private Integer transactionAmount;
	@Column(length = 2,nullable = false)
	private String transactionType;
	private LocalDate transactionDate;
	private LocalTime transactionTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="accountNumber",nullable = false)
	private Account account;

	
	public Transaction() {
        this.transactionId = generateUniqueTransactionId();
    }
	
	private String generateUniqueTransactionId() {
		long currentTime = System.currentTimeMillis();
	    int randomValue = new Random().nextInt(100000);
	    return String.format("%16d", currentTime, randomValue);
	    // Combine current time and random value without relying on format specifier
	    //return String.valueOf(currentTime) + String.format("%05d", randomValue);
    }
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
