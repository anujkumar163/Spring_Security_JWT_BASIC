package com.spring.defaultSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration

public class SecurityConfig<> {
	
	@Bean
	public UserDetailsService userDetailService() {
	//this method have loaduserbyusername, userdetails interface
	//inmemory or dataabase userdetails 
		var ud = new InMemoryUserDetailsManager();
		//inmemory username and pasword
		var user =User.withUsername("anuj")
		.password("123")
		.authorities("read")
		.build();
		//create user
		ud.createUser(user);
		
		return ud;
		
	}
	//pasword in coder
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
}
