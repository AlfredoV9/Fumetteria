package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "capitololetto")
public class CapitoloLetto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "capitolo_id", nullable = false)
    private Capitolo capitolo;

    @Column(nullable = false)
    private String stato;  // Es.: "completato", "in corso"
}

