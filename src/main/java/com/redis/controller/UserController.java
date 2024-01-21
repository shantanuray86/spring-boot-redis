package com.redis.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.dao.userDao;
import com.redis.models.User;
import com.redis.service.userService;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

	@Autowired
	userService uService;
	
	@Autowired
	userDao ud;
	
	@GetMapping("/{empId}")
	@Cacheable(value = "user")
    public Optional<User> getUser(@PathVariable("empId") int empId) {
        return uService.getSingleUser(empId);
    }
	
	@GetMapping("/getuser/{empId}")
    public ResponseEntity<Map<String, Object>> getUser2(@PathVariable("empId") int empId) {
        return new ResponseEntity<Map<String, Object>>(ud.fetchUserById(empId), HttpStatus.OK);
    }
}
