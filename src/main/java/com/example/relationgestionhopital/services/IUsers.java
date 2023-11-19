package com.example.relationgestionhopital.services;

import com.example.relationgestionhopital.entities.Role;
import com.example.relationgestionhopital.entities.User;

public interface IUsers {

     User addUser(User user);
     Role addRole(Role role);

     User findUserByUsername(String username);
     Role findUserByRolename(String roleName);

     void findAddUsernameByRoleName(String username, String roleName);

     User authenticate(String username, String password);

}
