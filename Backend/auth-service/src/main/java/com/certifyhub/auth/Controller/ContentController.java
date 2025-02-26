package com.certifyhub.auth.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/register")
    public String registerPage() {
        return "register_page"; // Returns register_page.html from templates
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login_page"; // Returns login_page.html from templates
    }
}
