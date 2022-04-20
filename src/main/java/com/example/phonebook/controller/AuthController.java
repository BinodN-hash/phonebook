package com.example.phonebook.controller;
import com.example.phonebook.model.User;
import com.example.phonebook.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UsersRepo usersRepo;

    @GetMapping("/auth/login")
    public String loginView() {

        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, RedirectAttributes attributes, Model model){

        String userEmail = user.getEmail();
        User userData = usersRepo.findByEmail(user.getEmail());
        model.addAttribute("user", user);
        if(user.getPassword().equals(userData.getPassword())){

            return "redirect:/create/contact";

        }
        else{
            attributes.addFlashAttribute("error", "Invalid email & password !!!");
            return "redirect:/auth/login";
        }



    }

}
