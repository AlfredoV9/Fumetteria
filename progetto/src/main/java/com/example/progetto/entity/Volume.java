package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "volume")
public class Volume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private LocalDate dataUscita;

    @ManyToOne
    @JoinColumn(name = "fumetto_id", nullable = false)
    private Fumetto fumetto;
}

