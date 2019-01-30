package com.visualpath.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.visualpath.user.User;

public interface UserCRUDRepository extends CrudRepository<User, Long>,UserCRUDRepositoryCustom  {
	
	public List<User> findByName(String name);
	
	
	 public List<User> findByLowerName(String name);
	  
	   @Query("SELECT u FROM User u WHERE LOWER(u.address) = LOWER(:address)")
	    public List<User> findByLocation(@Param("address") String address);
	   
	   
}
