package com.spring.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Page {
	
	@RequestMapping("/firstpage")
	public String firstPage() {
		
		return "security";
	}
	
	@RequestMapping("/secondpage")
	public String secondPage() {
		
		return "secondpage";
	}
}
