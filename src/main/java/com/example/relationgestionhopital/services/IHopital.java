package com.example.relationgestionhopital.services;

import com.example.relationgestionhopital.entities.Consultation;
import com.example.relationgestionhopital.entities.Medecin;
import com.example.relationgestionhopital.entities.Patient;
import com.example.relationgestionhopital.entities.RendezVous;

public interface IHopital {
    Medecin saveMedecin (Medecin medecin);
    Patient savePatient (Patient patient);
    RendezVous saveRendezVous (RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);
}
