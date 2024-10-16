package com.example.progetto.repository;

import com.example.progetto.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {

    Optional<Ruolo> findByNome(String nome);
}
