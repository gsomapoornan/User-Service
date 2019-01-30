package com.visualpath.user.repository;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.visualpath.user.User;

@Repository
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public User findById(long id) {
		return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
		
	}


	public int saveUser(User user) {
		return jdbcTemplate.update("INSERT INTO user(id, name,user_address) VALUES(?,?,?)",user.getId(),user.getName(),user.getAddress());	
		
	}
	
	public int saveUserPS(User user) {
		
	
	 String INSERT_USER_SQL = "insert into user(id,name,user_address) VALUES(?,?,?)";	    
	 
	    return jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(INSERT_USER_SQL);
	          ps.setLong(1, user.getId());
	          ps.setString(2, user.getName());
	          ps.setString(3, user.getAddress());
	          return ps;
	        });
	 
	       
	    }
	
}
