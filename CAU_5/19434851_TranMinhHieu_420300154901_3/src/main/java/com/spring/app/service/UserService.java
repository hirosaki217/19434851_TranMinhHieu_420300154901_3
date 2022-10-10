package com.spring.app.service;

import com.spring.app.auth.UserPrincipal;
import com.spring.app.entity.User;

public interface UserService {
	User createUser(User user);
	UserPrincipal findByUsername(String username);
}
