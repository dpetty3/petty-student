package com.FauxBank.service;

import com.FauxBank.business.Customer;

public abstract class CustomerService {

	public abstract boolean authenticateUser(String uname, String pwd);
	
	public abstract void registersUser(Customer customer);
	
	public abstract void doBanking(char txType);
}
