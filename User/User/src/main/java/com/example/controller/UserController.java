package com.example.controller;

import com.example.config.TokenProvider;
import com.example.dtos.UserDto;
import com.example.jpa.RoleRepo;
import com.example.jpa.UserRepo;
import com.example.models.AuthToken;
import com.example.models.LoginUser;
import com.example.models.User;
import com.example.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        final String generateToken = jwtTokenUtil.generateToken(authenticate);
        return ResponseEntity.ok(new AuthToken(generateToken));
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDto user) {

        return userRoleService.saveUser(user);
    }

    @GetMapping("/test")
    public String test() {
        return "testing";
    }
}

