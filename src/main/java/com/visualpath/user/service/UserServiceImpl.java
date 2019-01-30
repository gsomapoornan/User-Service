package com.visualpath.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visualpath.user.User;
import com.visualpath.user.repository.UserCRUDRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserCRUDRepository userRepository;
	
	
	public String helloVisualPath() {
		return "Hello VisualPath";
		
	}
	
	
	public User getUserByID(long id) {
		return userRepository.findById(id).get();		
		
	}
	
	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);		
		
	}
	
	public List<User> getUserByNameLowercase(String name) {
		return userRepository.findByLowerName(name);		
		
	}
	
	public List<User> getUserByAddress(String address) {
		return userRepository.findByLocation(address);		
		
	}
	
	public List<User> getUserByNameCity(String name,String address) {
		return userRepository.findUserbyAddressAndName(name, address);		
	
	}
	
	
	
	public void deleteUserByID(long id) {
		userRepository.deleteById(id);		
		
	}
	
	public ResponseEntity<Object> updateUserByID(User user,long id) {
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		userRepository.save(user);

		return ResponseEntity.noContent().build();		
		
	}
	
	
	
	
	
	    public ResponseEntity < String > createUser(User user) {	       
	           User savedUser=userRepository.save(user);
	           if(savedUser!=null)
	           {
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        }
	        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	    }
	
	
}
