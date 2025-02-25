package com.certifyhub.auth.Controller;
import com.certifyhub.auth.model.User;
import com.certifyhub.auth.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ContentController {

    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
}