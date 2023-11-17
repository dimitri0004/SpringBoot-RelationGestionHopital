package com.example.relationgestionhopital.services;

import com.example.relationgestionhopital.entities.Consultation;
import com.example.relationgestionhopital.entities.Medecin;
import com.example.relationgestionhopital.entities.Patient;
import com.example.relationgestionhopital.entities.RendezVous;
import com.example.relationgestionhopital.repository.ConsultationRepository;
import com.example.relationgestionhopital.repository.MedecinRepository;
import com.example.relationgestionhopital.repository.PatientRepository;
import com.example.relationgestionhopital.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HopitalImpl implements  IHopital{

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HopitalImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
