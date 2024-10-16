package com.example.progetto.service;

import com.example.progetto.dto.VolumeDTO;
import com.example.progetto.entity.Fumetto;
import com.example.progetto.entity.Volume;
import com.example.progetto.enumCostanti.FumettoTipo;
import com.example.progetto.exception.BusinessLogicException;
import com.example.progetto.exception.NessunaNuovaUscitaException;
import com.example.progetto.mapper.MapperUtils;
import com.example.progetto.repository.FumettoRepository;
import com.example.progetto.repository.VolumeRepository;
import com.example.progetto.serviceInterface.VolumeInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class VolumeService implements VolumeInterface {

    @Autowired
    private VolumeRepository volumeRepository;

    @Autowired
    private FumettoRepository fumettoRepository;

    @Override
    public List<VolumeDTO> getUltimiVolumiPerTipoFumetto(String tipo) {
        List<VolumeDTO> volumiDTO = null;
        for (int i = 0; i < 4; i++) {
            LocalDate dataInizio = LocalDate.now().minusWeeks(i + 1);
            List<Volume> volumi = volumeRepository.findUltimiVolumiPerTipoFumettoEDataUscita(FumettoTipo.valueOf(tipo), dataInizio);

            if (!volumi.isEmpty()) {
                volumiDTO = volumi.stream()
                        .map(MapperUtils::entityToDtoVolume)
                        .collect(Collectors.toList());
                break;
            }
        }
        if (volumiDTO == null) {
            throw new NessunaNuovaUscitaException("Nessuna nuova uscita nell'ultimo mese.");
        }

        return volumiDTO;
    }

    @Override
    public List<VolumeDTO> getVolumiFumetto(String titoloFumetto) {
        Fumetto fumetto = fumettoRepository.findByTitolo(titoloFumetto);
        if (fumetto == null) {
            throw new BusinessLogicException("Fumetto con titolo " + titoloFumetto + " non trovato!");
        }
        List<Volume> volumi = volumeRepository.findVolumiPerFumetto(fumetto.getId());
        if (volumi.isEmpty()) {
            throw new BusinessLogicException("Nessun volume di " + titoloFumetto + " presente!");
        }
        return volumi.stream()
                .map(MapperUtils::entityToDtoVolume)
                .collect(Collectors.toList());
    }
}
