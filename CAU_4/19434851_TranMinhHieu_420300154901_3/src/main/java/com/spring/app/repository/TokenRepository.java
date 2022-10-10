package com.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.app.entity.Token;


public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
