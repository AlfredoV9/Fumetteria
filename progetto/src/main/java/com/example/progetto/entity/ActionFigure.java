package com.example.progetto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "actionfigure")
public class ActionFigure implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private ArticoloCollezionabile articolo;

    private BigDecimal altezza;
    private String materiale;
}

