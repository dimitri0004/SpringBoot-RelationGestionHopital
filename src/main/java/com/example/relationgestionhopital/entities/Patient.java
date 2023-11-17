package com.example.relationgestionhopital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String email;
    private String name;
    @OneToMany(mappedBy = "patient" ,fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous ;

}
