package com.example.progetto.controller;

import com.example.progetto.dto.FumettoDTO;
import com.example.progetto.serviceInterface.FumettoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fumetti")
public class FumettoController {

    @Autowired
    private FumettoInterface fumettoService;

    @GetMapping("/genere/{genere}/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByGenereAndTipo(@PathVariable String genere, @PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByGeneriNomeAndTipo(genere, tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/casaEditrice/{casaEditrice}/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByCasaEditriceAndTipo(@PathVariable String casaEditrice, @PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByCasaEditriceNomeAndTipo(casaEditrice, tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByTipo(@PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByTipo(tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/autore/nome/{nome}/cognome/{cognome}/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByAutoreAndTipo(@PathVariable String nome, @PathVariable String cognome, @PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByAutoreNomeCognomeAndTipo(nome, cognome, tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/raccomandati/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByRaccomandatoAndTipo( @PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByRaccomandatoAndTipo(true, tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/franchise/{franchise}/tipo/{tipo}")
    public ResponseEntity<List<FumettoDTO>> getFumettiByFranchiseAndTipo(@PathVariable String franchise, @PathVariable String tipo) {
        List<FumettoDTO> fumetti = fumettoService.findByFranchiseAndTipo(franchise, tipo);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/consigliati/tipo/{tipo}/utente/{utenteId}")
    public ResponseEntity<List<FumettoDTO>> getRecommendedFumetti(@PathVariable String tipo, @PathVariable Integer utenteId) {
        List<FumettoDTO> fumetti = fumettoService.findRecommendedFumetti(tipo, utenteId);
        return ResponseEntity.ok(fumetti);
    }

    @GetMapping("/titolo/{titolo}")
    public ResponseEntity<FumettoDTO> getFumettoByTitolo(@PathVariable String titolo) {
        FumettoDTO fumetto = fumettoService.findByTitolo(titolo);
        return ResponseEntity.ok(fumetto);
    }
}
