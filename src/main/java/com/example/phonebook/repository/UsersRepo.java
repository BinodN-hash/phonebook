package com.example.phonebook.repository;

import com.example.phonebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id=1")
    User findByEmail(String email);
}
