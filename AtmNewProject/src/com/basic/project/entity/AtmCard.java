package com.basic.project.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AtmCard {

	@Id
	@Column(length = 16,nullable = false)
	private String cardNo;
	@Column(length = 10,nullable = false)
	private LocalDate issueDate;
	@Column(length = 3,nullable = false)
	private String cvvNo;
	@Column(length=4,nullable = false)
	private String cardPin;
	@Column(length = 10,nullable = false)
	private String cardType;
	@Column(length = 8,nullable = false)
	private String cardStatus;
	@Column(length = 10,nullable = false)
	private LocalDate expiryDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="accountNumber",nullable = false)
	private Account account;
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
