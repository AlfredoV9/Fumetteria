package com.example.progetto.service;

import com.example.progetto.dto.GenereDTO;
import com.example.progetto.entity.Genere;
import com.example.progetto.exception.BusinessLogicException;
import com.example.progetto.mapper.MapperUtils;
import com.example.progetto.repository.GenereRepository;
import com.example.progetto.serviceInterface.GenereInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenereService implements GenereInterface {

    @Autowired
    private GenereRepository genereRepository;

    @Override
    public List<GenereDTO> listaGeneri() {
        List<Genere> generi = genereRepository.findAll();
        if (generi.isEmpty()) {
            throw new BusinessLogicException("Nessun genere trovato.");
        }
        return generi.stream()
                .map(MapperUtils::entityToDTOGenere) // Usa il MapperUtils per la conversione
                .collect(Collectors.toList());
    }

    @Override
    public GenereDTO creaGenere(GenereDTO genereDTO) {
        Genere genere = MapperUtils.dtoToEntityGenere(genereDTO); // Mappa il DTO all'entità
        genere = genereRepository.save(genere);
        return MapperUtils.entityToDTOGenere(genere);
    }

    @Override
    public void eliminaGenere(Integer id) {
        if (!genereRepository.existsById(id)) {
            throw new BusinessLogicException("Genere con ID: " + id + " non trovato.");
        }
        genereRepository.deleteById(id);
    }
}
