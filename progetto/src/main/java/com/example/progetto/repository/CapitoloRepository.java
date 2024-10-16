package com.example.progetto.repository;

import com.example.progetto.entity.Capitolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitoloRepository extends JpaRepository<Capitolo, Integer> {


}
