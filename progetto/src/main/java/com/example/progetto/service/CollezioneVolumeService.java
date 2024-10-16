package com.example.progetto.service;

import com.example.progetto.repository.CollezioneVolumeRepository;
import com.example.progetto.serviceInterface.CollezioneVolumeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollezioneVolumeService implements CollezioneVolumeInterface {

    @Autowired
    private CollezioneVolumeRepository collezioneVolumeRepository;
}
