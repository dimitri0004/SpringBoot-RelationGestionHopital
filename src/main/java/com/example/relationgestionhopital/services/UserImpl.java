package com.example.relationgestionhopital.services;

import com.example.relationgestionhopital.entities.Role;
import com.example.relationgestionhopital.entities.User;
import com.example.relationgestionhopital.repository.RoleRepository;
import com.example.relationgestionhopital.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserImpl implements  IUsers{
    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        role.setId(UUID.randomUUID().toString());
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Role findUserByRolename(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }

    @Override
    public void findAddUsernameByRoleName(String username, String roleName) {
        Role role = findUserByRolename(roleName);
        User user = findUserByUsername(username);
        if (user.getRole()!=null){
            user.getRole().add(role);
            role.getUser().add(user);
        }

    }

    @Override
    public User authenticate(String username, String password) {
        User user = findUserByUsername(username);
        if(user==null) throw  new RuntimeException("informations incorrectes");
        if(user.getPassword().equals(password)){
            return user;
        } throw  new RuntimeException("informations incorrectes");


    }
}
