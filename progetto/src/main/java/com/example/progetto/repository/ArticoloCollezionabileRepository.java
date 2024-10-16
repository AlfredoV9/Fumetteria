package com.example.progetto.repository;

import com.example.progetto.entity.ArticoloCollezionabile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloCollezionabileRepository extends JpaRepository<ArticoloCollezionabile, Integer> {
}
