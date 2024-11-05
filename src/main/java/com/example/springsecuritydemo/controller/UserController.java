package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

   @PutMapping("/save")
    public String saveUser(@RequestBody User user){
       return userService.saveUser(user);

   }
}
