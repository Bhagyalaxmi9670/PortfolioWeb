package com.portfolio.backend.controller;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.User;
import com.portfolio.backend.repository.UserRepository;
import com.portfolio.backend.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;


    }
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user){
        
        User dbUser = userRepository.findByUsername(user.getUsername())
        .orElseThrow();
        if(!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
            String token = jwtUtil.generateToken(dbUser.getUsername());

        return Map.of("token", token);
        
    }
}
