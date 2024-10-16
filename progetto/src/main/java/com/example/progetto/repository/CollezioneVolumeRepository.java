package com.example.progetto.repository;

import com.example.progetto.entity.CollezioneVolume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollezioneVolumeRepository extends JpaRepository<CollezioneVolume, Integer> {
}
