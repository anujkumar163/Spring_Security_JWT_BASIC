package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.services.UserServices;

@RestController

@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserServices userservice;
	
	@GetMapping("/home")
	public String home() {
		
		return "this is home page";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "this is login page";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "this is register page";
	}
	
}
