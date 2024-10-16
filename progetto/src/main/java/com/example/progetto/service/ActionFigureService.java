package com.example.progetto.service;

import com.example.progetto.repository.ActionFigureRepository;
import com.example.progetto.serviceInterface.ActionFigureInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionFigureService implements ActionFigureInterface {

    @Autowired
    private ActionFigureRepository actionFigureRepository;
}
