package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "murales")
public class Mural {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idM;  
    private String titulo;  
    private String ap;  
    private String dimensiones;  
    private String materiales;  
    private Double rating;  

    @ManyToOne
    @JoinColumn(name = "idA", referencedColumnName = "idA")
    private Artista artista;

    @Transient // Este campo no se mapea en la base de datos
    private Long idA;

    // Constructor
    public Mural(Long idM, String titulo, String ap, String dimensiones, String materiales, Double rating,
                 Artista artista) {
        this.idM = idM;
        this.titulo = titulo;
        this.ap = ap;
        this.dimensiones = dimensiones;
        this.materiales = materiales;
        this.rating = rating;
        this.artista = artista;
    }

    public Mural() {
    }

    // Getters y setters
    public Long getIdM() {
        return idM;
    }

    public void setIdM(Long idM) {
        this.idM = idM;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Long getIdA() {
        return idA;
    }

    public void setIdA(Long idA) {
        this.idA = idA;
    }
}
