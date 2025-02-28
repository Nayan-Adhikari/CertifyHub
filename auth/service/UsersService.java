package com.certifyhub.auth.service;

import com.certifyhub.auth.repository.UserRepo;
import com.certifyhub.auth.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String registerUser (User user){
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            return "Email already exits";
        }
        else{
            User userDetails = new User();
            userDetails.setUsername(user.getUsername());
            userDetails.setEmail(user.getEmail());
            userDetails.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(userDetails);
        }
        return "User registered successfully!";
    }

    public boolean validateUser(String username, String password) {
        Optional<User> user = userRepo.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}