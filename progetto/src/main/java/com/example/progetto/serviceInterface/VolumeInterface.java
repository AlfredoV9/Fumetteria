package com.example.progetto.serviceInterface;

import com.example.progetto.dto.FumettoDTO;
import com.example.progetto.dto.VolumeDTO;

import java.util.List;

public interface VolumeInterface {

    List<VolumeDTO> getUltimiVolumiPerTipoFumetto(String tipo);
    List<VolumeDTO> getVolumiFumetto(String titoloFumetto);
}
