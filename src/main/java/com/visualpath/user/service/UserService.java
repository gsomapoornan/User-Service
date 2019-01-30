package com.visualpath.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.visualpath.user.User;

public interface UserService {
	public String helloVisualPath();
	public User getUserByID(long id);
	public void deleteUserByID(long id);
	public ResponseEntity<Object> updateUserByID(User user,long id);
	public ResponseEntity<String> createUser(User user);
	
	
	
	public List<User> getUserByName(String name);
	public List<User> getUserByNameCity(String name,String address);
	public List<User> getUserByAddress(String address);
	public List<User> getUserByNameLowercase(String name);
	 

}
