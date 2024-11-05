package com.example.springsecuritydemo.configs;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.model.UserInfo;
import com.example.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserInfoService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid User Name");
        }
        return new UserInfo(user);
    }
}
