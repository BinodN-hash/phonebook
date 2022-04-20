package com.example.phonebook.controller;
import com.example.phonebook.model.User;
import com.example.phonebook.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/auth/login")
    public String loginView(Model model) {

        User user = new User();
        model.addAttribute("user",user);
        return "auth/login";
    }

}
