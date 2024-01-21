package com.redis.models;

public class CustomerDTO {

	private String userid;
	private String name;
	private String email;
	private Integer age;
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
	
	public CustomerDTO(String userid, String name, String email, Integer age) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
