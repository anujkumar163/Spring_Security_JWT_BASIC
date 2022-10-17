package com.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.models.CustomUserDetails;
import com.spring.models.User;
import com.spring.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user =Optional.ofNullable(this.userrepository.findByUsername(username));
		if(user==null) {
			throw new UsernameNotFoundException("no user");
		}
		return CustomUserDetails(user);
	}

	private UserDetails CustomUserDetails(Optional<User> user) {
		// TODO Auto-generated method stub
		return null;
	}

}
