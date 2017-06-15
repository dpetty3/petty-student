package com.FauxBank.business;

import java.util.Date;

public class Transaction {

	private long txid;
	private long accountNum;
	private String txType;
	private double amount;
	private Date date;
	
	public Transaction(long accountNum, String txType,long txid, double amount, Date date)
	{
		super();
		this.accountNum = accountNum;
		this.txType = txType;
		this.amount = amount;
		this.date = date;
		this.txid = txid;
	}

	public Transaction()
	{
		txType = "";
		date = new Date();
	}

	public long getAccountNum()
	{
		return accountNum;
	}

	public void setAccountNum(long accountNum)
	{
		this.accountNum = accountNum;
	}

	public String getTxType()
	{
		return txType;
	}

	public void setTxType(String txType)
	{
		this.txType = txType;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public long getTxid() {
		return txid;
	}

	public void setTxid(long l) {
		this.txid = l;
	}

	@Override
	public String toString() {
		return "Transaction [txid=" + txid + ", accountNum=" + accountNum + ", txType=" + txType + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	



}
