package com.example.progetto.service;

import com.example.progetto.entity.CapitoloLetto;
import com.example.progetto.repository.CapitoloLettoRepository;
import com.example.progetto.serviceInterface.CapitoloLettoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitoloLettoService implements CapitoloLettoInterface {

    @Autowired
    private CapitoloLettoRepository capitoloLettoRepository;

    public List<CapitoloLetto> getCapitoliLetti(Integer utenteId) {
        try {
            return capitoloLettoRepository.findCapitoliLettiByUtente(utenteId);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
