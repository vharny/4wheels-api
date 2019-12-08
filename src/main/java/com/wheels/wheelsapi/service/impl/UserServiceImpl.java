package com.wheels.wheelsapi.service.impl;

import com.wheels.wheelsapi.entity.User;
import com.wheels.wheelsapi.repository.UserRepository;
import com.wheels.wheelsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
