package com.example.progetto.entity;

import com.example.progetto.enumCostanti.FumettoTipo;
import com.example.progetto.enumCostanti.StatoFumetto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "fumetto")
public class Fumetto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String titolo;

    private String descrizione;
    @Column(name = "data_rilascio")
    private LocalDate dataRilascio;
    @Column(nullable = false)
    private boolean raccomandato;
    private String franchise;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;

    @ManyToOne
    @JoinColumn(name = "casa_editrice_id")
    private CasaEditrice casaEditrice;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "fumetto_genere",
            joinColumns = @JoinColumn(name = "fumetto_id"),
            inverseJoinColumns = @JoinColumn(name = "genere_id")
    )
    private List<Genere> generi;

    @Enumerated(EnumType.STRING) // Questo indica che vogliamo memorizzare il valore della stringa nell DB
    private FumettoTipo tipo;

    @Enumerated(EnumType.STRING) // Utilizza EnumType.STRING per mappare l'enum come stringa
    private StatoFumetto stato;

}

