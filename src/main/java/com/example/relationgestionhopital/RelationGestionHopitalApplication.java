package com.example.relationgestionhopital;

import com.example.relationgestionhopital.entities.Consultation;
import com.example.relationgestionhopital.entities.Enumarate.statusRDV;
import com.example.relationgestionhopital.entities.Medecin;
import com.example.relationgestionhopital.entities.Patient;
import com.example.relationgestionhopital.entities.RendezVous;
import com.example.relationgestionhopital.repository.ConsultationRepository;
import com.example.relationgestionhopital.repository.MedecinRepository;
import com.example.relationgestionhopital.repository.PatientRepository;
import com.example.relationgestionhopital.repository.RendezVousRepository;
import com.example.relationgestionhopital.services.HopitalImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class RelationGestionHopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelationGestionHopitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            MedecinRepository medecinRepository,
            PatientRepository patientRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository,
            HopitalImpl hopitalImp
    ){
        return args->{
            Stream.of("Bienvenu", "Esso", "Mounirou")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Chirurgie":"dentiste");
                        medecinRepository.save(medecin);
                    });

            Stream.of("samto", "rafiou", "phillipe")
                    .forEach(name->{
                        Patient patient =new Patient();
                        patient.setName(name);
                        patient.setEmail(name+"@gmail.com");
                        patientRepository.save(patient);

                    });

            Medecin medecin1 = medecinRepository.findById(1);
            Patient patient1 = patientRepository.findById(1);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setStatus(statusRDV.ANNULE);
            rendezVous.setDateRDV(new Date());
            rendezVous.setMedecin(medecin1);
            rendezVous.setPatient(patient1);
            hopitalImp.saveRendezVous(rendezVous);


            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateRDV(new Date());
            consultation.setRendezvous(rendezVous1);
            consultation.setRapportConsulatation("votre rapport de consulatation est : ");
            hopitalImp.saveConsultation(consultation);
            };




    }
}
