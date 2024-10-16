package com.example.progetto.service;

import com.example.progetto.dto.UtenteForBackEndDTO;
import com.example.progetto.dto.UtenteForFrontEndDTO;
import com.example.progetto.entity.Ruolo;
import com.example.progetto.entity.Utente;
import com.example.progetto.mapper.MapperUtils;
import com.example.progetto.repository.UtenteRepository;
import com.example.progetto.serviceInterface.RuoloInterface;
import com.example.progetto.serviceInterface.UtenteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UtenteService implements UtenteInterface {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private RuoloInterface ruoloInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UtenteForFrontEndDTO creazioneUtente(UtenteForBackEndDTO utenteForBackEndDTO) {
        MapperUtils convertitore = new MapperUtils();
        Ruolo ruoloUtente = ruoloInterface.findByNome(utenteForBackEndDTO.getNomeRuolo());
        Utente utente = convertitore.backEndDtoToEntity(utenteForBackEndDTO, ruoloUtente);
        utente.setPassword(passwordEncoder.encode(utenteForBackEndDTO.getPassword()));
        Utente utenteSalvato = utenteRepository.save(utente);
        return convertitore.entityToFrontEndDto(utenteSalvato);
    }

    @Override
    public UtenteForFrontEndDTO findByEmailOUsernameEPassword(UtenteForBackEndDTO utenteForBackEndDTO) {
        MapperUtils convertitore = new MapperUtils();
        Utente utente = null;
        if (utenteForBackEndDTO.getEmail() != null && !utenteForBackEndDTO.getEmail().isEmpty()) {
            utente = utenteRepository.findByEmail(utenteForBackEndDTO.getEmail())
                    .orElse(null);
        }
        if (utente == null && utenteForBackEndDTO.getUsername() != null && !utenteForBackEndDTO.getUsername().isEmpty()) {
            utente = utenteRepository.findByUsername(utenteForBackEndDTO.getUsername())
                    .orElse(null);
        }
        if (utente == null) {
            throw new IllegalArgumentException("Utente non trovato");
        }
        if (!passwordEncoder.matches(utenteForBackEndDTO.getPassword(), utente.getPassword()) && !(utenteForBackEndDTO.getPassword().equals(utente.getPassword()))) {
            throw new IllegalArgumentException("Password non corretta");
        }
        return convertitore.entityToFrontEndDto(utente);
    }

}
