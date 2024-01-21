package com.redis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redis.models.CustomerDTO;
import com.redis.models.User;
import com.redis.service.customerService;
import com.redis.service.userService;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

	
	private static customerService cs;
	

	
	public CustomerController(customerService customerService)
	{
		this.cs = customerService;
	}
	
	@GetMapping
	@Cacheable(value = "customer")
    public List<CustomerDTO> allCustomers() {
        return cs.getAllCustomers();
    }
	

	
	
}