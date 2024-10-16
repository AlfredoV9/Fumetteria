package com.example.progetto.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UtenteForBackEndDTO implements Serializable {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String nomeRuolo;

}
