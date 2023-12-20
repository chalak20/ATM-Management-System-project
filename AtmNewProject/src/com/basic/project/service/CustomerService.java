package com.basic.project.service;

import com.basic.project.entity.Customer;

public interface CustomerService {

	Customer findCardNumber(String cardNo);
	String cardStatus(Customer customer);
}
