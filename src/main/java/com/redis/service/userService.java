package com.redis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.dao.userDao;
import com.redis.models.User;

@Service
public class userService {

	@Autowired
	userDao uDao;
	
	public Optional<User> getSingleUser(int id) {
		return uDao.selectUserById(id);
	}
}
