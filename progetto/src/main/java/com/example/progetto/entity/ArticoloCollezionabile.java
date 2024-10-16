package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "articolocollezionabile")
public class ArticoloCollezionabile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal prezzo;

    private String tipo;
    private String descrizione;
    @Column(name = "data_rilascio")
    private LocalDate dataRilascio;
}

