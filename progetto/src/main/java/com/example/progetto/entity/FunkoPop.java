package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "funkopop")
public class FunkoPop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private ArticoloCollezionabile articolo;

    private String serie;
    @Column(name = "numero_edizione")
    private Integer numeroEdizione;
}
