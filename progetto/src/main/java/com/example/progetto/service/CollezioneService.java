package com.example.progetto.service;

import com.example.progetto.repository.CollezioneRepository;
import com.example.progetto.serviceInterface.CollezioneInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollezioneService implements CollezioneInterface {

    @Autowired
    private CollezioneRepository collezioneRepository;
}
