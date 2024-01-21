package com.redis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redis.beans.StatusBean;
import com.redis.exceptions.MobileTimeException;
import com.redis.models.User;


@Repository
public class userDaoImpl implements userDao{

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public List<User> selectAllUsers() {
		String sql = "select id,fname,lname, userid from user";
		
		return jdbctemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User cust = new User();
				cust.setFname(rs.getString("fname"));
				cust.setLname(rs.getString("lname"));
				cust.setId(rs.getInt("id"));
				cust.setUserid(rs.getString("userid"));
				return cust;
			}
		});
	}
	
	 RowMapper<User> rowMapper = (rs, rowNum) -> {
		 User cust = new User();
			cust.setFname(rs.getString("fname"));
			cust.setLname(rs.getString("lname"));
			cust.setId(rs.getInt("id"));
			cust.setUserid(rs.getString("userid"));
			return cust;
	    };

	@SuppressWarnings("deprecation")
	@Override
	public Optional<User> selectUserById(Integer uid) {
		String sql = "select * from user where id = ?";
				
		//String sql = "SELECT course_id,title,description,link from course where course_id = ?";
        User course = null;
        try {
            course = jdbctemplate.queryForObject(sql, new Object[]{uid}, rowMapper);
        }catch (DataAccessException ex) {
           // log.info("Course not found: " + uid);
        }
        return Optional.ofNullable(course);
	}
	
//	 @Override
//	  public User findById(Long id) {
//	    try {
//	    	User tutorial = jdbctemplate.queryForObject("SELECT * FROM user WHERE id=?",
//	    		  rowMapper.mapRow(User.class, id);
//
//	      return tutorial;
//	    } catch (IncorrectResultSizeDataAccessException e) {
//	      return null;
//	    }
//	  }
	
	

	@Override
	@Cacheable(value = "user", key="#id")
	public Map<String, Object> fetchUserById(int id) {
		
		StatusBean status = null;
		User us;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String SQL = "SELECT * FROM user WHERE ids = ?";			
			us = jdbctemplate.queryForObject(SQL, rowMapper, id);
			map.put("data", us);
			map.put("Status", new StatusBean("no error","200","null"));
			
		}catch(Exception e) {
			map.put("Status", e);
			map.put("data", null);
		}
				
		return map;

	}

}
