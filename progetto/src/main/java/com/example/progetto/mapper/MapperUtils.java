package com.example.progetto.mapper;

import com.example.progetto.dto.*;
import com.example.progetto.entity.*;

import java.util.ArrayList;
import java.util.List;

public class MapperUtils {

    public static Volume dtoToEntityVolume(VolumeDTO volumeDTO) {
        if (volumeDTO == null) {
            return null;
        }
        Volume volume = new Volume();
        volume.setNumero(volumeDTO.getNumero());
        volume.setDataUscita(volumeDTO.getDataUscita());
        volume.setFumetto(dtoToEntityFumetto(volumeDTO.getFumetto()));
        return volume;
    }

    public static Fumetto dtoToEntityFumetto(FumettoDTO fumettoDTO) {
        if (fumettoDTO == null) {
            return null;
        }
        Fumetto fumetto = new Fumetto();
        fumetto.setDataRilascio(fumettoDTO.getDataRilascio());
        fumetto.setDescrizione(fumettoDTO.getDescrizione());
        fumetto.setStato(fumettoDTO.getStato());
        fumetto.setRaccomandato(fumettoDTO.isRaccomandato());
        fumetto.setTipo(fumettoDTO.getTipo());
        fumetto.setFranchise(fumettoDTO.getFranchise());
        fumetto.setTitolo(fumettoDTO.getTitolo());
        fumetto.setAutore(dtoToEntityAutore(fumettoDTO.getAutore()));
        fumetto.setCasaEditrice(dtoToEntityCasaEditrice(fumettoDTO.getCasaEditrice()));
        if(!fumettoDTO.getGeneri().isEmpty()){
            List<Genere> generi = new ArrayList<>();
            for(GenereDTO genereDTO : fumettoDTO.getGeneri()){
                generi.add(dtoToEntityGenere(genereDTO));
            }
            fumetto.setGeneri(generi);
        }
        return fumetto;
    }

    public static VolumeDTO entityToDtoVolume(Volume volume) {
        if (volume == null) {
            return null;
        }
        VolumeDTO volumeDTO = new VolumeDTO();
        volumeDTO.setNumero(volume.getNumero());
        volumeDTO.setDataUscita(volume.getDataUscita());
        volumeDTO.setFumetto(entityToDtoFumetto(volume.getFumetto()));
        return volumeDTO;
    }

    public static FumettoDTO entityToDtoFumetto(Fumetto fumetto) {
        if (fumetto == null) {
            return null;
        }
        FumettoDTO fumettoDTO = new FumettoDTO();
        fumettoDTO.setDataRilascio(fumetto.getDataRilascio());
        fumettoDTO.setDescrizione(fumetto.getDescrizione());
        fumettoDTO.setStato(fumetto.getStato());
        fumettoDTO.setTipo(fumetto.getTipo());
        fumettoDTO.setRaccomandato(fumetto.isRaccomandato());
        fumettoDTO.setFranchise(fumetto.getFranchise());
        fumettoDTO.setTitolo(fumetto.getTitolo());
        fumettoDTO.setAutore(entityToDTOAutore(fumetto.getAutore()));
        fumettoDTO.setCasaEditrice(entityToDTOCasaEditrice(fumetto.getCasaEditrice()));
        if(!fumetto.getGeneri().isEmpty()){
            List<GenereDTO> generiDTO = new ArrayList<>();
            for(Genere genere : fumetto.getGeneri()){
                generiDTO.add(entityToDTOGenere(genere));
            }
            fumettoDTO.setGeneri(generiDTO);
        }
        return fumettoDTO;
    }

    public static Autore dtoToEntityAutore(AutoreDTO autoreDTO){
        if(null == autoreDTO){
            return null;
        }
        Autore autore = new Autore();
        autore.setCognome(autoreDTO.getCognome());
        autore.setNome(autoreDTO.getNome());
        autore.setNazionalita(autoreDTO.getNazionalita());
        return autore;
    }

    public static AutoreDTO entityToDTOAutore(Autore autore){
        if(null == autore){
            return null;
        }
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setNazionalita(autore.getNazionalita());
        return autoreDTO;
    }

    public static CasaEditrice dtoToEntityCasaEditrice(CasaEditriceDTO casaEditriceDTO){
        if(null == casaEditriceDTO){
            return null;
        }
        CasaEditrice casaEditrice = new CasaEditrice();
        casaEditrice.setNome(casaEditriceDTO.getNome());
        casaEditrice.setPaese(casaEditriceDTO.getPaese());
        return casaEditrice;
    }

    public static CasaEditriceDTO entityToDTOCasaEditrice(CasaEditrice casaEditrice){
        if(null == casaEditrice){
            return null;
        }
        CasaEditriceDTO casaEditriceDTO = new CasaEditriceDTO();
        casaEditriceDTO.setNome(casaEditrice.getNome());
        casaEditriceDTO.setPaese(casaEditrice.getPaese());
        return casaEditriceDTO;
    }

    public static Genere dtoToEntityGenere(GenereDTO genereDTO){
        if(null == genereDTO){
            return null;
        }
        Genere genere = new Genere();
        genere.setNome(genereDTO.getNome());
        return genere;
    }

    public static GenereDTO entityToDTOGenere(Genere genere){
        if(null == genere){
            return null;
        }
        GenereDTO genereDTO = new GenereDTO();
        genereDTO.setNome(genere.getNome());
        return genereDTO;
    }

    public static UtenteForFrontEndDTO entityToFrontEndDto(Utente utente) {
        if (utente == null) {
            return null;
        }
        UtenteForFrontEndDTO dto = new UtenteForFrontEndDTO();
        dto.setUsername(utente.getUsername());
        dto.setNome(utente.getNome());
        dto.setCognome(utente.getCognome());
        dto.setEmail(utente.getEmail());
        dto.setNomeRuolo(utente.getRuolo() != null ? utente.getRuolo().getNome() : null);
        return dto;
    }

    public static UtenteForBackEndDTO entityToBackEndDto(Utente utente) {
        if (utente == null) {
            return null;
        }
        UtenteForBackEndDTO dto = new UtenteForBackEndDTO();
        dto.setUsername(utente.getUsername());
        dto.setNome(utente.getNome());
        dto.setCognome(utente.getCognome());
        dto.setEmail(utente.getEmail());
        dto.setPassword(utente.getPassword());
        dto.setNomeRuolo(utente.getRuolo() != null ? utente.getRuolo().getNome() : null);
        return dto;
    }

    public static Utente backEndDtoToEntity(UtenteForBackEndDTO dto, Ruolo ruolo) {
        if (dto == null) {
            return null;
        }
        Utente utente = new Utente();
        utente.setUsername(dto.getUsername());
        utente.setNome(dto.getNome());
        utente.setCognome(dto.getCognome());
        utente.setEmail(dto.getEmail());
        utente.setPassword(dto.getPassword());
        utente.setRuolo(ruolo);
        return utente;
    }

}

