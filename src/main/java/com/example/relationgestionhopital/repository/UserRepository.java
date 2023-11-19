package com.example.relationgestionhopital.repository;

import com.example.relationgestionhopital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User,Long> {

    User findUserByUsername(String username);


}
