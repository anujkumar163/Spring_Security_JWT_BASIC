package com.spring.dbSecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.dbSecurity.service.UserdbDetailsservice;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserdbDetailsservic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
}
