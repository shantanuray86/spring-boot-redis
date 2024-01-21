package com.redis.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.redis.models.User;



public interface userDao {

	List<User> selectAllUsers();
	Optional<User> selectUserById(Integer uid);
	Map<String, Object> fetchUserById(int id);
}
