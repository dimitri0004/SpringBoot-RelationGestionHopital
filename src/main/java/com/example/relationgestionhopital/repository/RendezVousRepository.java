package com.example.relationgestionhopital.repository;

import com.example.relationgestionhopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

    //RendezVous findById(String id);
}
