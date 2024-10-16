package com.example.progetto.service;

import com.example.progetto.dto.FumettoDTO;
import com.example.progetto.entity.Fumetto;
import com.example.progetto.enumCostanti.FumettoTipo;
import com.example.progetto.exception.BusinessLogicException;
import com.example.progetto.mapper.MapperUtils;
import com.example.progetto.repository.FumettoRepository;
import com.example.progetto.serviceInterface.FumettoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FumettoService implements FumettoInterface {

    @Autowired
    private FumettoRepository fumettoRepository;

    @Override
    public List<FumettoDTO> findByGeneriNomeAndTipo(String genere, String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByGeneriNomeAndTipo(genere, FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato per genere: " + genere + " e tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto) // Usa il MapperUtils per la conversione
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findByCasaEditriceNomeAndTipo(String casaEditrice, String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByCasaEditriceNomeAndTipo(casaEditrice, FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato per casa editrice: " + casaEditrice + " e tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findByTipo(String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByTipo(FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato per il tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findByAutoreNomeCognomeAndTipo(String nome, String cognome, String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByAutoreNomeCognomeAndTipo(nome, cognome, FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato per autore: " + nome + " " + cognome + " e tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findByRaccomandatoAndTipo(boolean raccomandato, String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByRaccomandatoAndTipo(raccomandato, FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato con raccomandato: " + raccomandato + " e tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findByFranchiseAndTipo(String franchise, String tipo) {
        List<Fumetto> fumetti = fumettoRepository.findByFranchiseAndTipo(franchise, FumettoTipo.valueOf(tipo));
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto trovato per franchise: " + franchise + " e tipo: " + tipo);
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FumettoDTO> findRecommendedFumetti(String tipo, Integer utenteId) {
        List<Fumetto> fumetti = fumettoRepository.findRecommendedFumetti(tipo, utenteId);
        if (fumetti.isEmpty()) {
            throw new BusinessLogicException("Nessun fumetto consigliato trovato per utente: " + utenteId + " e tipo: " + FumettoTipo.valueOf(tipo));
        }
        return fumetti.stream()
                .map(MapperUtils::entityToDtoFumetto)
                .collect(Collectors.toList());
    }

    @Override
    public FumettoDTO findByTitolo(String titolo) {
        Fumetto fumetto = fumettoRepository.findByTitolo(titolo);
        if (fumetto == null) {
            throw new BusinessLogicException("Nessun fumetto trovato per titolo: " + titolo);
        }
        return MapperUtils.entityToDtoFumetto(fumetto);
    }

}
