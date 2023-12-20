package com.basic.project.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@Column(length = 9,nullable = false)
	private Integer customerId;
	@Column(length = 15,nullable = false)
	private String customerName;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	@Column(length = 1,nullable = false)
	private Character gender;
	private String emailId;
	@Column(length = 10,nullable = false)
	private String customerContact;
	@Column(nullable = false)
	private String address;
	@Column(length = 12,nullable = false)
	private String adharNumber;
	@Column(length = 10,nullable = false)
	private String panNumber;
	
	@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
	private List<Account> account;
	
	@ManyToOne
	@JoinColumn(name="ifscCode")
	private Bank bank;
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGeneder() {
		return gender;
	}

	public void setGeneder(Character geneder) {
		this.gender = geneder;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}
