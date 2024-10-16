package com.example.progetto.dto;

import com.example.progetto.enumCostanti.FumettoTipo;
import com.example.progetto.enumCostanti.StatoFumetto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class FumettoDTO implements Serializable {

    private String titolo;
    private String descrizione;
    private LocalDate dataRilascio;
    private String franchise;
    private boolean raccomandato;
    private List<GenereDTO> generi;
    private FumettoTipo tipo;
    private StatoFumetto stato;
    private CasaEditriceDTO casaEditrice;
    private AutoreDTO autore;

}
