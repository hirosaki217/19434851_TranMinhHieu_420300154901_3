package com.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.auth.UserPrincipal;
import com.spring.app.entity.Token;
import com.spring.app.entity.User;
import com.spring.app.service.TokenService;
import com.spring.app.service.UserService;
import com.spring.app.utils.JwtUtil;


@RestController
public class AuthController {
	@Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    
    @Autowired
    private TokenService tokenService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception{
		
		System.out.print("register");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.createUser(user);
	}
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
		
		System.out.println(user.toString());
		
        UserPrincipal userPrincipal =
                userService.findByUsername(user.getUsername());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }

}
