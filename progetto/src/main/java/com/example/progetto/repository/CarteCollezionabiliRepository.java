package com.example.progetto.repository;

import com.example.progetto.entity.CarteCollezionabili;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteCollezionabiliRepository extends JpaRepository<CarteCollezionabili, Integer> {
}
