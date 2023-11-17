package com.example.relationgestionhopital.repository;

import com.example.relationgestionhopital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedecinRepository extends JpaRepository< Medecin, Long> {


    //List<Medecin> findByName(String name);

    Medecin findById(int id);
}
