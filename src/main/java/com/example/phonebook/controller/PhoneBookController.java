package com.example.phonebook.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PhoneBookController {


    @GetMapping("createContact")
    public String view(){
        return "addContact";
    }

    @PostMapping("/saveData")
    public String saveContact(){
        return "addContact";
    }

    @GetMapping("view/contacts")
    public String viewContact(){
        return "viewContact";
    }



}
