package com.certifyhub.auth.Controller;


import com.certifyhub.auth.service.UsersService;
import com.certifyhub.auth.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ContentController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        usersService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        boolean isvalidUser = usersService.validateUser(user.getUsername(),user.getPassword());

        if(isvalidUser) {
            return ResponseEntity.ok("Login succesfull!");
        } else{
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

}
