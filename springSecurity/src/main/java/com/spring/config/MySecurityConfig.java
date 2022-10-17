package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.repository.UserRepository;
import com.spring.services.CustomUserDetailService;
//basic,role,folds config

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnable=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	private CustomUserDetailService customuserdetailservice;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http
				.csrf().disable()
				.authorizeRequests()
				//.antMatchers("/home","/login","/register").permitAll()
				//.antMatchers("/signin").permitAll()
				.antMatchers("/home/**").hasRole("NORMAL")
				.antMatchers("/user/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
				//.formLogin()
				//.loginPage("/signin")
				//.loginProcessingUrl("/dologin")
				//.defaultSuccessUrl("/users/")
				//
				
				
			
				
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(auth);
		//here you are passing password directly
		//auth.inMemoryAuthentication().withUser("anuj").password("anuj").roles("NORMAL");
		
		//auth.inMemoryAuthentication().withUser("anuj").password(this.passwordEncoder().encode("anuj")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("abhay").password(this.passwordEncoder().encode("abhay")).roles("ADMIN");
		
		auth.userDetailsService(customuserdetailservice).passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//this is for passing bassword as it is but 
		//return NoOpPasswordEncoder.getInstance();
		
		//this is for password to be passed as incoded
		return BCryptPasswordEncoder(10);
	}

	private PasswordEncoder BCryptPasswordEncoder(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
