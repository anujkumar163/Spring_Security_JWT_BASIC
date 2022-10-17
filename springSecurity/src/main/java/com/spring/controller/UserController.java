package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.User;
import com.spring.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userservice;
	
	
	//all user
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		
		return this.userservice.getAllUsers();
	}
	
	//return single user
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userservice.getUser(username);
	}
	
	//add user
	@PostMapping("/")
	public User add(@RequestBody User user) {
		
		return this.userservice.addUser(user);
	}
	
}
