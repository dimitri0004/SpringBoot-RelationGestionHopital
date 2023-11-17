package com.example.relationgestionhopital.repository;

import com.example.relationgestionhopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient ,Long> {
    Patient findById(int id);
}
