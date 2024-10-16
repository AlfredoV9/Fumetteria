package com.example.progetto.service;

import com.example.progetto.repository.CasaEditriceRepository;
import com.example.progetto.serviceInterface.CasaEditriceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasaEditriceService implements CasaEditriceInterface {

    @Autowired
    private CasaEditriceRepository casaEditriceRepository;
}
