package com.hospital.backend.controller;

import com.hospital.backend.dto.LoginRequest;
import com.hospital.backend.entity.User;
import com.hospital.backend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService service;

    // SIGNUP API
    @PostMapping("/register")
    public String register(
            @RequestBody User user
    ) {

        return service.register(user);
    }

    // LOGIN API
    @PostMapping("/login")
    public Object login(
            @RequestBody LoginRequest request
    ) {

        return service.login(request);
    }
}