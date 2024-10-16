package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "utente")
public class Utente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nome;
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ruolo_id")
    private Ruolo ruolo;

    @OneToMany(mappedBy = "utente")
    private List<Preferito> preferiti;

    @OneToMany(mappedBy = "utente")
    private List<Voto> voti;

    @OneToMany(mappedBy = "utente")
    private List<Commento> commenti;
}
