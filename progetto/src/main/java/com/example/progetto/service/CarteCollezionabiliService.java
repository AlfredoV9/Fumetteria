package com.example.progetto.service;

import com.example.progetto.repository.CarteCollezionabiliRepository;
import com.example.progetto.serviceInterface.CarteCollezionabiliInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteCollezionabiliService implements CarteCollezionabiliInterface {

    @Autowired
    private CarteCollezionabiliRepository carteCollezionabiliRepository;
}
