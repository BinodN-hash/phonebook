package com.example.phonebook.repository;


import com.example.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

    Boolean existsByNumber(String number);
    Boolean existsByEmail(String email);

}
