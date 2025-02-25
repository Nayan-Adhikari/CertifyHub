package com.certifyhub.auth.service;

import com.certifyhub.auth.model.User;
import com.certifyhub.auth.model.Role; // ✅ Correct Enum Import
import com.certifyhub.auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER); // ✅ Correct Enum Usage
        userRepository.save(user);
        return "User registered successfully!";
    }
}
