package com.example.progetto.repository;

import com.example.progetto.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    Optional<Utente> findByEmail(String email);
    Optional<Utente> findByUsername(String username);
}
