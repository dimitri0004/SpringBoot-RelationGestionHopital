package com.example.relationgestionhopital.web;

import com.example.relationgestionhopital.entities.User;
import com.example.relationgestionhopital.services.UserImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserImpl userImp;
    @GetMapping("/index/{username}")

    public User index(@PathVariable String username){
        User user = userImp.findUserByUsername(username);
        return user;

    }
}
