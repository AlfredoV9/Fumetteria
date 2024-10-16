package com.example.progetto.service;

import com.example.progetto.repository.CollezioneArticoloRepository;
import com.example.progetto.serviceInterface.CollezioneArticoloInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollezioneArticoloService implements CollezioneArticoloInterface {

    @Autowired
    private CollezioneArticoloRepository collezioneArticoloRepository;
}
