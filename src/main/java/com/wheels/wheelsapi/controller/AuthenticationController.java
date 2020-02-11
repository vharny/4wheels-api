package com.wheels.wheelsapi.controller;

import com.wheels.wheelsapi.configuration.JwtTokenUtil;
import com.wheels.wheelsapi.dto.UserDto;
import com.wheels.wheelsapi.entity.Token;
import com.wheels.wheelsapi.entity.Login;
import com.wheels.wheelsapi.entity.User;
import com.wheels.wheelsapi.service.impl.AuthServiceImpl;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Api(value = "Auth", tags = {"Auth"})
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private AuthServiceImpl userDetailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, AuthServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("register")
    public void register(@RequestBody UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        userDetailsService.save(user);
    }

    @PostMapping("auth")
    public ResponseEntity<?> login(@RequestBody Login login) throws Exception {
        authenticate(login.getEmail(), login.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(login.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new Token(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}