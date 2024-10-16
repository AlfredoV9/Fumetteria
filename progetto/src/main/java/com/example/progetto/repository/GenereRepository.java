package com.example.progetto.repository;

import com.example.progetto.entity.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Integer> {
}
