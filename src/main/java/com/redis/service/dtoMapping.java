package com.redis.service;

import com.redis.models.Customer;
import com.redis.models.CustomerDTO;

public class dtoMapping {

	public CustomerDTO customerToDto(Customer cus) {
		CustomerDTO cdto =  new CustomerDTO();
		
		cdto.setUserid(cus.getUserid());
		cdto.setAge(cus.getAge());
		cdto.setName(cus.getName());
		cdto.setEmail(cus.getEmail());
		
		return cdto;
	}
	
	public Customer dtoToCustomer(CustomerDTO cus) {
		Customer cdto =  new Customer();
		
		cdto.setUserid(cus.getUserid());
		cdto.setAge(cus.getAge());
		cdto.setName(cus.getName());
		cdto.setEmail(cus.getEmail());
		
		return cdto;
	}
}
