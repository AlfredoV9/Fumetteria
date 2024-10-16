package com.example.progetto.serviceInterface;

import com.example.progetto.dto.FumettoDTO;
import com.example.progetto.entity.Fumetto;

import java.util.List;

public interface FumettoInterface {

    List<FumettoDTO> findByGeneriNomeAndTipo(String genere, String tipo);
    List<FumettoDTO> findByCasaEditriceNomeAndTipo(String casaEditrice, String tipo);
    List<FumettoDTO> findByTipo(String tipo);
    List<FumettoDTO> findByAutoreNomeCognomeAndTipo(String nome, String cognome, String tipo);
    List<FumettoDTO> findByRaccomandatoAndTipo(boolean raccomandato, String tipo);
    List<FumettoDTO> findByFranchiseAndTipo(String franchise, String tipo);
    List<FumettoDTO> findRecommendedFumetti(String tipo, Integer utenteId);
    FumettoDTO findByTitolo(String titolo);

}
