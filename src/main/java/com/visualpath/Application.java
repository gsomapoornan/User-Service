package com.visualpath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.util.JSONPObject;



@SpringBootApplication
public class Application {	

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
	
	@Endpoint(id="custominfo")
	@Component
    public class CustomPoint {
        @ReadOperation
        public String  getSampleUser(){        	
        	return "{\r\n" + 
        			"    \"id\": \"Long\",\r\n" + 
        			"    \"name\": \"String\",\r\n" + 
        			"    \"address\": \"String\"\r\n" + 
        			"}";
         
       	}
        
	}
}
