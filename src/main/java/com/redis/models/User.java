package com.redis.models;

public class User {

	private Integer id;
	private String userid;
	private String fname;
	private String lname;
	public User(Integer id, String userid, String fname, String lname) {
		super();
		this.id = id;
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
}
