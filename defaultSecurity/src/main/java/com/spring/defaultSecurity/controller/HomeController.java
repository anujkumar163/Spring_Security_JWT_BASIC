package com.spring.defaultSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/default")
	public String defaultPage() {
		return "default";
	}
}
