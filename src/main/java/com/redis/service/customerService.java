package com.redis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.redis.dao.customerDao;
import com.redis.models.CustomerDTO;

@Service
public class customerService {
	
	@Autowired
	customerDao customerDAO;
	
	dtoMapping dtom = new dtoMapping();
	
	public List<CustomerDTO> getAllCustomers() {
        return customerDAO.selectAllCustomers()
                .stream()
                .map(e->dtom.customerToDto(e))
                .collect(Collectors.toList());
    }
}
