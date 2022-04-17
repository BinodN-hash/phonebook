package com.example.phonebook.controller;

import com.example.phonebook.model.Contact;
import com.example.phonebook.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PhoneBookController {

    @Autowired
    ContactRepo contactRepo;

    @GetMapping("/createContact")
    public String view(){
        return "addContact";
    }

    @PostMapping("/saveData")
    public String saveContact(@ModelAttribute Contact contact, Model model){

        if(contactRepo.existsByNumber(contact.getNumber())){
           throw new RuntimeException("Phone number already Exist.");
//           model.addAttribute("error_phone", "Phone number already exist");


        }if (contactRepo.existsByEmail(contact.getEmail())){
            throw new RuntimeException("Email already exist");
//            model.addAttribute("error_email","Email address already exist");

        }
        else{
            contactRepo.save(contact);

        }
        return "redirect:/viewContact";

    }

    @GetMapping("/viewContacts")
    public String viewContact(Model model){

        model.addAttribute("contacts",contactRepo.findAll());

        return "viewContact";

    }


}
