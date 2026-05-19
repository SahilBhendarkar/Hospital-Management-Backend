package com.hospital.backend.service;

import com.hospital.backend.dto.LoginRequest;
import com.hospital.backend.entity.User;
import com.hospital.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    // SIGNUP
    public String register(User user) {

        // EMAIL VALIDATION
        if (
                user.getEmail() == null ||
                        user.getEmail().trim().isEmpty()
        ) {

            return "Email Required";
        }

        // PASSWORD VALIDATION
        if (
                user.getPassword() == null ||
                        user.getPassword().length() < 6
        ) {

            return "Password must be at least 6 characters";
        }

        // DUPLICATE EMAIL
        if (
                repository.existsByEmail(
                        user.getEmail()
                )
        ) {

            return "Email Already Registered";
        }

        // DEFAULT ROLE
        if (
                user.getRole() == null ||
                        user.getRole().isEmpty()
        ) {

            user.setRole("patient");
        }

        repository.save(user);

        return "Signup Successful";
    }

    // LOGIN
    public Object login(
            LoginRequest request
    ) {

        Optional<User> optionalUser =
                repository.findByEmail(
                        request.getEmail()
                );

        // USER NOT FOUND
        if (optionalUser.isEmpty()) {

            return "User Not Found";
        }

        User user = optionalUser.get();

        // PASSWORD CHECK
        if (
                !user.getPassword()
                        .equals(request.getPassword())
        ) {

            return "Invalid Password";
        }

        return user;
    }
}