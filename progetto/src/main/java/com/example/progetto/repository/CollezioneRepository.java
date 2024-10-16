package com.example.progetto.repository;

import com.example.progetto.entity.Collezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollezioneRepository extends JpaRepository<Collezione, Integer> {
}