package com.example.progetto.serviceInterface;
import com.example.progetto.dto.GenereDTO;

import java.util.List;

public interface GenereInterface {

    List<GenereDTO> listaGeneri();
    GenereDTO creaGenere(GenereDTO genereDTO);
    void eliminaGenere(Integer id);

}

