package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.entity.User;
import com.portfolio.backend.service.UserService;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:4200")
public class UserController {
    
    private final UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping
    public List <User> getUsers(){
        return service.getAll();
    }

}
