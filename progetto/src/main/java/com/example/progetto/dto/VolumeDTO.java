package com.example.progetto.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VolumeDTO implements Serializable {

    private Integer numero;
    private LocalDate dataUscita;
    private FumettoDTO fumetto;
}
