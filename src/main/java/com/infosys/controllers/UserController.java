package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.User;
import com.infosys.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//spring restful service
//@Controller+@ResponsBody //spring mvc 
@RequestMapping("/api")
public class UserController {

	@Autowired// used for dependency injection
	UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	 @PutMapping("/user/{id}")
	    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
	        return userService.updateUser(id, user);
	    }
	    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
    	userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
