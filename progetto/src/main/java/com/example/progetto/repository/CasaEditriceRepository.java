package com.example.progetto.repository;

import com.example.progetto.entity.CasaEditrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Integer> {
}
