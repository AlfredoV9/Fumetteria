package com.example.progetto.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutoreDTO implements Serializable {

    private String nome;
    private String cognome;
    private String nazionalita;

}
