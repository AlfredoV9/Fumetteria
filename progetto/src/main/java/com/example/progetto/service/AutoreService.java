package com.example.progetto.service;

import com.example.progetto.repository.AutoreRepository;
import com.example.progetto.serviceInterface.AutoreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreService implements AutoreInterface {

    @Autowired
    private AutoreRepository autoreRepository;
}
