package com.spring.dbSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dbSecurity.entity.UserDb;
import com.spring.dbSecurity.service.UserdbDetailsservice;

@Controller
public class User {
	
	@Autowired
	private UserdbDetailsservice dbservice;
	
	@RequestMapping("/userPage")
	public String userdt() {
		
		return "databasePage";
	}
	
	@RequestMapping("/usersave")
	public String saveUser(@ModelAttribute("ioc") UserDb userdb, ModelMap model ) {
		
		dbservice.save(userdb);
		model.addAttribute("userdb", userdb);
		
		System.out.println(userdb.getUsername());
		System.out.println(userdb.getPassword());
		return "databasePage";
		
	}
}
