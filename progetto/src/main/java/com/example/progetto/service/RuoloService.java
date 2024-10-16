package com.example.progetto.service;

import com.example.progetto.entity.Ruolo;
import com.example.progetto.repository.RuoloRepository;
import com.example.progetto.serviceInterface.RuoloInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuoloService implements RuoloInterface {

    @Autowired
    private RuoloRepository ruoloRepository;

    @Override
    public Ruolo findByNome(String nome) {
        return ruoloRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Ruolo non trovato: " + nome));
    }
}
