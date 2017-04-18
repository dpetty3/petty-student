package com.bursar.business;

import java.sql.Blob;
import java.sql.Date;

public class Receipt {
	
	public Receipt(){}

	private long empID;
	private String expType;
	private double expAmt;
	private Date rDate;
	private String empStat;
	private Blob expR;

	public Receipt(long empID, String expType, double expAmt, Date rDate, String empStat, Blob expR) {
		super();
		this.empID = empID;
		this.expType = expType;
		this.expAmt = expAmt;
		this.rDate = rDate;
		this.empStat = empStat;
		this.expR = expR;
	}
	public long getEmpID() 
	{
		return empID;
	}
	public void setEmpID(long empID) 
	{
		this.empID = empID;
	}
	public String getExpType()
	{
		return expType;
	}
	public void setExpType(String expType)
	{
		this.expType = expType;
	}
	public double getExpAmt() 
	{
		return expAmt;
	}
	public void setExpAmt(double expAmt)
	{
		this.expAmt = expAmt;
	}
	public Date getrDate() 
	{
		return rDate;
	}
	public void setrDate(Date rDate)
	{
		this.rDate = rDate;
	}
	public String getEmpStat() {
		return empStat;
	}
	public void setEmpStat(String empStat) {
		this.empStat = empStat;
	}
	public Blob getExpR() {
		return expR;
	}
	public void setExpR(Blob expR) {
		this.expR = expR;
	}
	@Override
	public String toString() {
		return "Receipt [empID=" + empID + ", expType=" + expType + ", expAmt=" + expAmt + ", rDate=" + rDate
				+ ", empStat=" + empStat + ", expR=" + expR + "]";
	}
	
}
