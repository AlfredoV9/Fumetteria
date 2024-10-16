package com.example.progetto.repository;

import com.example.progetto.entity.ActionFigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionFigureRepository extends JpaRepository<ActionFigure, Integer> {
}
