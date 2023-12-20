package com.basic.project.presentation;

import com.basic.project.entity.Customer;

public interface App {
	void deposit(Customer customer);
	void withdraw(Customer customer);
	void checkBalance(Customer customer);
	void changePin(Customer customer);
	void miniStatement(Customer customer);
//	void reciept(Customer customer);
}
