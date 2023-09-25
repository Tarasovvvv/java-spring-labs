package com.example.app.entities.lab4;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Pet2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;
    @ManyToMany(mappedBy = "pets")
    private List<Owner> owners;
    @OneToOne
    private MedicalHistory medicalHistory;
}
