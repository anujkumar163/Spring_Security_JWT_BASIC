package com.spring.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.entity.TableOne;

public interface jwtRepository extends JpaRepository<TableOne, Long> {

}
