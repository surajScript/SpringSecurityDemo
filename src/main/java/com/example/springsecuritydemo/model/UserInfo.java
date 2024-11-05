package com.example.springsecuritydemo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfo implements UserDetails {

    private final String name;
    private final String password;
    private final List<GrantedAuthority> grantedAuthorities;


    public UserInfo(User user) {
        this.name = user.getUserName();
        this.password=user.getPassword();
        String[] rolesArray = user.getRoles().split(",");
        this.grantedAuthorities = Arrays.stream(rolesArray).map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableList());


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }
}
