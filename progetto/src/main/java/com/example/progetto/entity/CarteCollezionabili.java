package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cartecollezionabili")
public class CarteCollezionabili implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private ArticoloCollezionabile articolo;

    private String rarita;
    @Column(name = "set_collezione")
    private String setCollezione;
}

