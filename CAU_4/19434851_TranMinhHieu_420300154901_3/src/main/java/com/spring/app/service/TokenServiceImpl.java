package com.spring.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.Token;
import com.spring.app.repository.TokenRepository;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

}

