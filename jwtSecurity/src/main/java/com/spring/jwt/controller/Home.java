package com.spring.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@RequestMapping("/welcome")
	public String welcome() {
		String txt = "this is rest api";
		txt = "this api is not allowed to unauthenticated users";
		return txt;
	}
}
