package com.basic.project.service;

import com.basic.project.dao.CustomerDao;
import com.basic.project.dao.CustomerDaoImpl;
import com.basic.project.entity.Account;
import com.basic.project.entity.Customer;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public Customer findCardNumber(String cardNo) {
		return customerDao.findCardNumber(cardNo);
	}

	@Override
	public String cardStatus(Customer customer) {	
		return customerDao.cardStatus(customer);
	}

}
