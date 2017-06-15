package com.FauxBank.service;

import com.FauxBank.business.Transaction;

public interface Service {
	
	// Interface is what gives the ability for other classes to us the same methods
	public abstract void makeDeposit(double amt);
	public abstract void getWithdraw(double amt);
	public abstract void getBalance ();
	public abstract void submitTx(Transaction tx);
	public abstract void fetchTx(long accountNum);
	
}
