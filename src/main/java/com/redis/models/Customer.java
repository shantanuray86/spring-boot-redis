package com.redis.models;

public class Customer {

	private Integer id;
	private String userid;
	private String name;
	private String email;
	private Integer age;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(Integer id, String userid, String name, String email, Integer age) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.age = age;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
