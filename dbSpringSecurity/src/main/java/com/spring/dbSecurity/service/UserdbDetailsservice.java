package com.spring.dbSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.dbSecurity.entity.LoginUser;
import com.spring.dbSecurity.entity.UserDb;
import com.spring.dbSecurity.repository.DbRepository;

import java.util.Optional;

@Service
public class UserdbDetailsservice implements UserDetailsService{
	
	@Autowired
	private DbRepository dbrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserDb> userdb = dbrepo.findByUsername(username);
		
		return new LoginUser(userdb);
	}

	public void save(UserDb userdb) {
		// TODO Auto-generated method stub
		dbrepo.save(userdb);
	}

}
