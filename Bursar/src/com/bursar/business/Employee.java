package com.bursar.business;

public class Employee {

	public Employee()
	{
		
	}

	private long eid;
	private String stat;
	private String fname;
	private String lname;
	private String uname;
	
	public Employee(long eid, String stat, String fname, String lname, String uname, String pwd) {
		super();
		this.eid = eid;
		this.stat = stat;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
	}
	
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", stat=" + stat + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname
				+ "]";
	}
	
}
