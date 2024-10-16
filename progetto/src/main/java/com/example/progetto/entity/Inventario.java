package com.example.progetto.entity;

import com.example.progetto.enumCostanti.StatoVolume;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "volume_id", nullable = false)
    private Volume volume;

    @Column(nullable = false)
    private int giacenza;

    @Column(nullable = false)
    private double prezzo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoVolume stato;

    @OneToMany(mappedBy = "inventario")
    private List<Preordine> preordini;

    @OneToMany(mappedBy = "inventario")
    private List<Offerta> offerte;

}

