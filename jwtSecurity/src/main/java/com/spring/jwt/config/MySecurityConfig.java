package com.spring.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.jwt.services.CustomUserDetailsService;
//jwtconfiguration 
@Configuration

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		//using method chaning
		http
				.csrf().disable()
				.cors().disable()
				.authorizeRequests()
				.antMatchers("/token").permitAll()
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.userDetailsService(customUserDetailsService);
		
		
	}

	//bcryptpasswordincoder for incoding the password
	//but here no password encoder is used below
	//add jjwt dependency in pom for upto * version and above 8 add
	//one more dependency javax.xml.bind
	@Bean
	public PasswordEncoder passwordencoder() {
		  
		return NoOpPasswordEncoder.getInstance();  
		
	}  
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		
		return super.authenticationManagerBean();
	}
	
}
