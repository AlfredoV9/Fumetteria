package com.example.progetto.controller;

import com.example.progetto.dto.UtenteForBackEndDTO;
import com.example.progetto.dto.UtenteForFrontEndDTO;
import com.example.progetto.serviceInterface.UtenteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteInterface utenteInterface;

    @PostMapping("/crea")
    public ResponseEntity<UtenteForFrontEndDTO> creaUtente(@RequestBody UtenteForBackEndDTO utenteForBackEndDTO) {
        UtenteForFrontEndDTO utenteCreato = utenteInterface.creazioneUtente(utenteForBackEndDTO);
        return new ResponseEntity<>(utenteCreato, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UtenteForFrontEndDTO> login(@RequestBody UtenteForBackEndDTO utenteForBackEndDTO) {
        UtenteForFrontEndDTO utenteLoggato = utenteInterface.findByEmailOUsernameEPassword(utenteForBackEndDTO);
        return new ResponseEntity<>(utenteLoggato, HttpStatus.OK);
    }
}
