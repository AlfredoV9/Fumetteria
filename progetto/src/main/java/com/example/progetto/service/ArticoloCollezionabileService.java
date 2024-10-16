package com.example.progetto.service;

import com.example.progetto.repository.ArticoloCollezionabileRepository;
import com.example.progetto.serviceInterface.ArticoloCollezionabileInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticoloCollezionabileService implements ArticoloCollezionabileInterface {

    @Autowired
    private ArticoloCollezionabileRepository articoloCollezionabileRepository;
}
