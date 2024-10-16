package com.example.progetto.repository;

import com.example.progetto.entity.Volume;
import com.example.progetto.enumCostanti.FumettoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Integer> {

    @Query("SELECT v FROM Volume v WHERE v.fumetto.tipo = :tipo AND v.dataUscita >= :dataInizio")
    List<Volume> findUltimiVolumiPerTipoFumettoEDataUscita(@Param("tipo") FumettoTipo tipo, @Param("dataInizio") LocalDate dataInizio);

    @Query("SELECT v FROM Volume v WHERE v.fumetto.id = :fumettoId ORDER BY v.numero")
    List<Volume> findVolumiPerFumetto(@Param("fumettoId") Integer fumettoId);
}
