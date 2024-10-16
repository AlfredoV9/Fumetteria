package com.example.progetto.controller;

import com.example.progetto.dto.GenereDTO;
import com.example.progetto.serviceInterface.GenereInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generi")
public class GenereController {

    @Autowired
    private GenereInterface genereService;

    @GetMapping("/totali")
    public ResponseEntity<List<GenereDTO>> listaGeneri() {
        List<GenereDTO> generi = genereService.listaGeneri();
        return new ResponseEntity<>(generi, HttpStatus.OK);
    }

    @PostMapping("creazione")
    public ResponseEntity<GenereDTO> creaGenere(@RequestBody GenereDTO genereDTO) {
        GenereDTO nuovoGenere = genereService.creaGenere(genereDTO);
        return new ResponseEntity<>(nuovoGenere, HttpStatus.CREATED);
    }

    @DeleteMapping("/cancellazione/{id}")
    public ResponseEntity<Void> eliminaGenere(@PathVariable Integer id) {
        genereService.eliminaGenere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
