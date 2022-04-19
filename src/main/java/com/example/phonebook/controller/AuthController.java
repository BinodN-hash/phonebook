package com.example.phonebook.controller;

import com.example.phonebook.model.Contact;
import com.example.phonebook.model.User;
import com.example.phonebook.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/auth/login")
    public String loginView() {

        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user){
        String userEmail = user.getEmail();
        User userdata = userRepo.findByEmail(userEmail);
        if (user.getEmail().equals(userdata.getEmail()) & user.getPassword().equals(userdata.getPassword())){

            return "redirect:/";
        }else{
            throw new RuntimeException("Invalid email adn password");
        }
    }

}
