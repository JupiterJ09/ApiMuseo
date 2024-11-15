package com.example.demo.controller;

import com.example.demo.entity.Artista;
import com.example.demo.jpa.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @GetMapping
    public List<Artista> getAllArtistas() {
        return artistaRepository.findAll();
    }

    @GetMapping("/{idA}")
    public Artista getArtistaById(@PathVariable Long idA) {
        return artistaRepository.findById(idA).orElse(null);
    }

  
    @PostMapping
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaRepository.save(artista);
    }

    @PutMapping("/{idA}")
    public Artista updateArtista(@PathVariable Long idA, @RequestBody Artista artista) {
        artista.setIdA(idA);
        return artistaRepository.save(artista);
    }

    @DeleteMapping("/{idA}")
    public void deleteArtista(@PathVariable Long idA) {
        artistaRepository.deleteById(idA);
    }
}