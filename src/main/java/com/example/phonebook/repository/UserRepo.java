package com.example.phonebook.repository;

import com.example.phonebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
}
