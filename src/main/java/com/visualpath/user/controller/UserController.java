package com.visualpath.user.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visualpath.user.User;
import com.visualpath.user.repository.UserCRUDRepository;
import com.visualpath.user.service.UserService;
import com.visualpath.user.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Value("${welcome.message}")
	private String welcomeMessage;

	
	@RequestMapping(value="/")
	public String helloVisualPath() {
		return welcomeMessage;
		
	}
	
	@RequestMapping(value = "/user/{id}", method =RequestMethod.GET)	
	public User getUserByID(@PathVariable("id") long id) {
		return userService.getUserByID(id);		
		
	}
	@RequestMapping(value = "/userbyname/{name}", method =RequestMethod.GET)
	public List<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);		
		
	}
	@RequestMapping(value = "/userbylowername/{name}", method =RequestMethod.GET)
	public List<User> getUserByNameLowercase(@PathVariable("name") String name) {
		return userService.getUserByNameLowercase(name);		
		
	}
	@RequestMapping(value = "/userbyaddress/{address}", method =RequestMethod.GET)
	public List<User> getUserByAddress(@PathVariable("address") String address) {
		return userService.getUserByAddress(address);		
		
	}
	@RequestMapping(value = "/userbynamecity", method =RequestMethod.GET)
	public List<User> getUserByNameCity(@RequestParam(value="name",required=false) String name,@RequestParam(value="address",required=false) String address) {
		return userService.getUserByNameCity(name, address);		
	
	}
	
	
	@RequestMapping(value = "/user/{id}", method =RequestMethod.DELETE)
	public void deleteUserByID(@PathVariable("id") long id) {
		userService.deleteUserByID(id);		
		
	}
	@RequestMapping(value = "/user/{id}", method =RequestMethod.PUT)
	public ResponseEntity<Object> updateUserByID(@RequestBody User user,@PathVariable("id") long id) {
				return userService.updateUserByID(user,id);		
		
	}
	
	
	
	
	 @RequestMapping(value = "/newUser", method = RequestMethod.POST)
	    public ResponseEntity < String > createUser(@RequestBody User user) {	       
	          
	        return userService.createUser(user);
	    }
	
	
}

