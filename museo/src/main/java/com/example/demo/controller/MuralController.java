package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Artista;
import com.example.demo.entity.Mural;
import com.example.demo.jpa.ArtistaRepository;
import com.example.demo.jpa.MuralRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/murales")
public class MuralController {

    @Autowired
    private MuralRepository muralRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    // Obtener todos los murales
    @GetMapping
    public ResponseEntity<List<Mural>> getAllMurales() {
        List<Mural> murales = muralRepository.findAll();
        return ResponseEntity.ok(murales);
    }

    // Obtener un mural por su ID
    @GetMapping("/{idM}")
    public ResponseEntity<Mural> getMuralById(@PathVariable Long idM) {
        return muralRepository.findById(idM)
                .map(mural -> ResponseEntity.ok(mural))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo mural
    @PostMapping
    public ResponseEntity<Mural> createMural(@RequestBody Mural mural) {
        if (mural.getIdA() != null) {
            Artista artista = artistaRepository.findById(mural.getIdA())
                    .orElseThrow(() -> new RuntimeException("Artista no encontrado con idA: " + mural.getIdA()));
            mural.setArtista(artista);
        }
        Mural nuevoMural = muralRepository.save(mural);
        return ResponseEntity.status(201).body(nuevoMural);
    }

    // Actualizar un mural
    @PutMapping("/{idM}")
    public ResponseEntity<Mural> updateMural(@PathVariable Long idM, @RequestBody Mural mural) {
        if (!muralRepository.existsById(idM)) {
            return ResponseEntity.notFound().build();
        }
        if (mural.getIdA() != null) {
            Artista artista = artistaRepository.findById(mural.getIdA())
                    .orElseThrow(() -> new RuntimeException("Artista no encontrado con idA: " + mural.getIdA()));
            mural.setArtista(artista);
        }
        mural.setIdM(idM);
        Mural updatedMural = muralRepository.save(mural);
        return ResponseEntity.ok(updatedMural);
    }

    // Eliminar un mural
    @DeleteMapping("/{idM}")
    public ResponseEntity<Void> deleteMural(@PathVariable Long idM) {
        if (!muralRepository.existsById(idM)) {
            return ResponseEntity.notFound().build();
        }
        muralRepository.deleteById(idM);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/por-artista/{idA}")
    public ResponseEntity<List<Mural>> getMuralesByArtista(@PathVariable Long idA) {
        List<Mural> murales = muralRepository.findByArtistaIdA(idA);

        if (murales.isEmpty()) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no hay murales
        }

        return ResponseEntity.ok(murales); // Retorna 200 con los murales
    }
    
    @GetMapping("/rating-mayor-a/{rating}")
    public ResponseEntity<List<Mural>> getMuralesByRatingMayorA(@PathVariable Double rating) {
        List<Mural> murales = muralRepository.findByRatingGreaterThan(rating);

        if (murales.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ArrayList<>()); // Retorna 404 si no hay murales
        }

        return ResponseEntity.ok(murales); // Retorna 200 con los murales
    }
}