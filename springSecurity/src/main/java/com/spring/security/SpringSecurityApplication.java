package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.models.User;
import com.spring.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrytpasswordencoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername("abc");
		user.setPassword(this.bcrytpasswordencoder.encode("abc"));
		user.setEmail("abc@gmail.com");
		user.setRole("ROLE_NORMAL");
		
		this.userrepository.save(user);
		
		User user1 = new User();
		user1.setUsername("xyz");
		user1.setPassword(this.bcrytpasswordencoder.encode("xyz"));
		user1.setEmail("xyz@gmail.com");
		user1.setRole("ROLE_ADMIN");
		this.userrepository.save(user1);
		
	}

}
