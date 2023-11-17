package com.example.relationgestionhopital.entities;
import  com.example.relationgestionhopital.entities.Enumarate.statusRDV;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {

    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date  dateRDV;
    @Enumerated(EnumType.STRING)
    private statusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezvous", fetch = FetchType.LAZY)
    private Consultation consultation;

}
