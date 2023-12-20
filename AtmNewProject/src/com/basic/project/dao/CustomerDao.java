package com.basic.project.dao;

import com.basic.project.entity.Customer;

public interface CustomerDao {

	Customer findCardNumber(String cardNo);
	String cardStatus(Customer customer);
}
