package com.redis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redis.models.Customer;

@Repository
public class customerDaoImpl implements customerDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<Customer> selectAllCustomers() {
	
		String sql = "select name, id, age, email, userid from customer";
				
				return jdbctemplate.query(sql, new RowMapper<Customer>() {
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
						Customer cust = new Customer();
						cust.setName(rs.getString("name"));
						cust.setId(rs.getInt("id"));
						cust.setAge(rs.getInt("age"));
						cust.setEmail(rs.getString("email"));
						cust.setUserid(rs.getString("userid"));
						return cust;
					}
				});
	}

	@Override
	public Optional<Customer> selectCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsCustomerWithEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Customer> selectUserByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void updateCustomerProfileImageId(String profileImageId, Integer customerId) {
		// TODO Auto-generated method stub
		
	}

}
