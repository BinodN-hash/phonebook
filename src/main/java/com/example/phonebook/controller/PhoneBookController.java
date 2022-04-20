package com.example.phonebook.controller;

import com.example.phonebook.model.Contact;
import com.example.phonebook.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhoneBookController {

    @Autowired
    ContactRepo contactRepo;

    /*add contact view page*/
    @GetMapping("/create/contact")
    public String view(){
        return "addContact";
    }

    /*create contacts*/
    @PostMapping("/save/contact")
    public String saveContact(@ModelAttribute Contact contact, Model model, RedirectAttributes redirectAttributes){

        if(contactRepo.existsByNumber(contact.getNumber())){
//           throw new RuntimeException("Phone number already Exist.");
            redirectAttributes.addFlashAttribute("perror", "Phone already added to phonebook");
            return "redirect:/create/contact";



        }if (contactRepo.existsByEmail(contact.getEmail())){
            redirectAttributes.addFlashAttribute("eerror", "E-mail already added to phonebook");
            return "redirect:/create/contact";


        }
        else{
            contactRepo.save(contact);

        }
        redirectAttributes.addFlashAttribute("success","Contact successfully created");
        return "redirect:/create/contact";

    }

    /*View Contacts list*/
    @GetMapping("/view/contacts")
    public String viewContact(Model model){

        model.addAttribute("contacts",contactRepo.findAll());

        return "viewContact";

    }

   @GetMapping("/delete/contact/{id}")
    public String deleteContact(@PathVariable Long id){

       contactRepo.deleteById(id);
        return "redirect:/view/contacts";
   }

    @GetMapping("/edit/contact/{id}")
    public String editContact(@PathVariable Long id, Model model){
        Contact contact = contactRepo.findById(id).get();
        System.out.println(contact.getId());
        model.addAttribute("contact", contact);
        return "editContact";
    }

    @PostMapping("/update/contact")
    public String updateContact(@ModelAttribute Contact contact, RedirectAttributes attributes){

        System.out.println("id =" + contact.getId() );
        Contact existContact = contactRepo.findById(contact.getId()).get();
        existContact.setName(contact.getName());
        existContact.setNumber(contact.getNumber());
        existContact.setEmail(contact.getEmail());

        contactRepo.save(existContact);
        attributes.addFlashAttribute("success", "Contact successfully updated");
        return "redirect:/view/contacts";
    }

}
