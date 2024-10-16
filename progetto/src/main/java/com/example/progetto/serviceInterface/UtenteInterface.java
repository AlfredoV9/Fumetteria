package com.example.progetto.serviceInterface;

import com.example.progetto.dto.UtenteForBackEndDTO;
import com.example.progetto.dto.UtenteForFrontEndDTO;

public interface UtenteInterface {

    UtenteForFrontEndDTO creazioneUtente(UtenteForBackEndDTO utenteForBackEndDTO);
    UtenteForFrontEndDTO findByEmailOUsernameEPassword(UtenteForBackEndDTO utenteForBackEndDTO);

}
