package com.example.relationgestionhopital.repository;

import com.example.relationgestionhopital.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository <Role,String>{
         Role findRoleByRoleName(String roleName);


}
