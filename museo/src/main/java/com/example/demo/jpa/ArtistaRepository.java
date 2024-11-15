package com.example.demo.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Artista;


public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}