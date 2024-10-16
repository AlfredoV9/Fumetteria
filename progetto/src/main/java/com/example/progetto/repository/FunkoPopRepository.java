package com.example.progetto.repository;

import com.example.progetto.entity.FunkoPop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunkoPopRepository extends JpaRepository<FunkoPop, Integer> {
}
