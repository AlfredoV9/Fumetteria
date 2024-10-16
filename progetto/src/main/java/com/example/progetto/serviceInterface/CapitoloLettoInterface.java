package com.example.progetto.serviceInterface;

import com.example.progetto.entity.CapitoloLetto;

import java.util.List;

public interface CapitoloLettoInterface {

    List<CapitoloLetto> getCapitoliLetti(Integer utenteId);
}
