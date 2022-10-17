package com.spring.dbSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dbSecurity.entity.UserDb;

public interface DbRepository extends JpaRepository<UserDb, Long> {
	
	Optional<UserDb> findByUsername(String username);
	
}
