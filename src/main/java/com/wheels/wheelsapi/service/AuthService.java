package com.wheels.wheelsapi.service;

import com.wheels.wheelsapi.entity.User;

import java.util.Set;

public interface AuthService {
    void save(User user);
    Set getAuthority(User user);
}
