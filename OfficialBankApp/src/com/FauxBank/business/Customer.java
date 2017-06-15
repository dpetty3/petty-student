package com.FauxBank.business;

public class Customer {

	private long cid;
	private long acctNum;
	private String uname;
	private String pwd;
	private String fname;
	private String lname;
	private String email;
	private double balance;

	public long getCid()
	{
		return cid;
	}

	public void setCid(long cid)
	{
		this.cid = cid;
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname(String fname)
	{
		this.fname = fname;
	}

	public String getLName()
	{
		return lname;
	}

	public void setLName(String name)
	{
		this.lname = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getUname()
	{
		return uname;
	}

	public void setUname(String uname)
	{
		this.uname = uname;
	}

	public long getAcctNum()
	{
		return acctNum;
	}

	public void setAcctNum(long acctNum)
	{
		this.acctNum = acctNum;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	@Override
	public String toString()
	{
		return "Customer [cid=" + cid + ", acctNum=" + acctNum + ", uname=" + uname + ", pwd=" + pwd + ", fname="
				+ fname + ", lname=" + lname + ", email=" + email + ", balance=" + balance + "]";
	}

}
