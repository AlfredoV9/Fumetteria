package com.example.progetto.entity;

import com.example.progetto.enumCostanti.StatoPreordine;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "preordine")
public class Preordine implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario inventario;

    private LocalDate dataPreordine;
    private LocalDate dataDisponibilita;

    @Enumerated(EnumType.STRING)
    private StatoPreordine stato;
}
