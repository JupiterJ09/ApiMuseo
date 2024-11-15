package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Artista;
import com.example.demo.entity.Mural;

import java.util.List;

public interface MuralRepository extends JpaRepository<Mural, Long> {
    List<Mural> findByArtista(Artista artista); 
    List<Mural> findByArtistaIdA(Long idA); // Consulta personalizada
    List<Mural> findByRatingGreaterThan(Double rating);
   
}