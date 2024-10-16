package com.example.progetto.service;

import com.example.progetto.repository.FunkoPopRepository;
import com.example.progetto.serviceInterface.FunkoPopInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FunkoPopService implements FunkoPopInterface {

    @Autowired
    private FunkoPopRepository funkoPopRepository;
}
