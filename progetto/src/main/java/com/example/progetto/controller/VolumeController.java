package com.example.progetto.controller;

import com.example.progetto.dto.FumettoDTO;
import com.example.progetto.dto.VolumeDTO;
import com.example.progetto.serviceInterface.VolumeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volumi")
public class VolumeController {

    @Autowired
    private VolumeInterface volumeInterface;

    @GetMapping("/ultimi-per-tipo/{tipo}")
    public ResponseEntity<List<VolumeDTO>> getUltimiVolumiPerTipoFumetto(@PathVariable String tipo) {
            List<VolumeDTO> volumiDTO = volumeInterface.getUltimiVolumiPerTipoFumetto(tipo);
            return new ResponseEntity<>(volumiDTO, HttpStatus.OK);
    }

    @GetMapping("/per-fumetto")
    public ResponseEntity<List<VolumeDTO>> getVolumiPerFumetto(@RequestParam String titoloFumetto) {
        System.out.println("Titolo ricevuto: " + titoloFumetto);
        List<VolumeDTO> volumiDTO = volumeInterface.getVolumiFumetto(titoloFumetto);
        return new ResponseEntity<>(volumiDTO, HttpStatus.OK);
    }
}
