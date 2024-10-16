package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "collezionevolume")
public class CollezioneVolume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "collezione_id", nullable = false)
    private Collezione collezione;

    @ManyToOne
    @JoinColumn(name = "volume_id", nullable = false)
    private Volume volume;
}

