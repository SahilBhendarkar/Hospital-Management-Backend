package com.hospital.backend.repository;

import com.hospital.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    // CHECK EMAIL EXISTS
    boolean existsByEmail(String email);

    // FIND USER BY EMAIL
    Optional<User> findByEmail(String email);
}