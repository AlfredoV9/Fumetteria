package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "capitolo")
public class Capitolo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    private String titolo;
    @Column(name = "data_pubblicazione")
    private LocalDate dataPubblicazione;

    @ManyToOne
    @JoinColumn(name = "volume_id", nullable = false)
    private Volume volume;
}

