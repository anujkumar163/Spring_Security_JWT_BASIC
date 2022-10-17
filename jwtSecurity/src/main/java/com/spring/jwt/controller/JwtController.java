package com.spring.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.entity.JwtRequest;
import com.spring.jwt.entity.JwtResponce;
import com.spring.jwt.helper.JwtUtil;
import com.spring.jwt.services.CustomUserDetailsService;

@RestController

public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("bad credential");
		}
		
		
		//fina area
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		
		//for token generation call util class
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("jwt" + token);
		
		//for sending token
		//{"token":"value"}
		
		
		
		
		
		
		return ResponseEntity.ok(new JwtResponce(token));
		
	}
}
