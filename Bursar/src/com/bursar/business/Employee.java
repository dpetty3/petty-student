package com.bursar.business;

public class Employee {

	
	public Employee(long eid, String fname, String lname, String uname, String pwd) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pwd = pwd;
	}

	private long eid;
	private String fname;
	private String lname;
	private String uname;
	private String pwd;
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pwd=" + pwd
				+ "]";
	}
	
	
	
	
}
