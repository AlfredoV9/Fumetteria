package com.example.progetto.controller;

import com.example.progetto.entity.CapitoloLetto;
import com.example.progetto.serviceInterface.CapitoloLettoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/capitoli")
public class CapitoloLettoController {

    @Autowired
    private CapitoloLettoInterface capitoloLettoService;

    @GetMapping("/letto/{utenteId}")
    public List<CapitoloLetto> getCapitoliLetti(@PathVariable Integer utenteId) {
        return capitoloLettoService.getCapitoliLetti(utenteId);
    }
}
