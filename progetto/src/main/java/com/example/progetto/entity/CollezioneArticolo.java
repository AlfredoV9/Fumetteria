package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "collezionearticolo")
public class CollezioneArticolo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "collezione_id", nullable = false)
    private Collezione collezione;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private ArticoloCollezionabile articolo;
}

