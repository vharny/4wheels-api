package com.wheels.wheelsapi.service.impl;
import java.util.HashSet;
import java.util.Set;

import com.wheels.wheelsapi.entity.User;
import com.wheels.wheelsapi.repository.UserRepository;
import com.wheels.wheelsapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements UserDetailsService, AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {
        com.wheels.wheelsapi.entity.User user = repository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    @Override
    public Set getAuthority(User user) {
        Set<Object> authorities = new HashSet<>();
        if (user.isAdmin()) authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    @Override
    public void save(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}