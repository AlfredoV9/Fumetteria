package com.example.progetto.service;

import com.example.progetto.repository.CapitoloRepository;
import com.example.progetto.serviceInterface.CapitoloInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapitoloService implements CapitoloInteface {

    @Autowired
    private CapitoloRepository capitoloRepository;
}
