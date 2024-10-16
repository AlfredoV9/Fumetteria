package com.example.progetto.repository;

import com.example.progetto.entity.CollezioneArticolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollezioneArticoloRepository extends JpaRepository<CollezioneArticolo, Integer> {
}
