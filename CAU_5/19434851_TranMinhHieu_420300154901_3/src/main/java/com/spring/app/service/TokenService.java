package com.spring.app.service;

import com.spring.app.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
    
}
