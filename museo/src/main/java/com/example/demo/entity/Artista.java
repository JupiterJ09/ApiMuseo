package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idA;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    
	public Artista(Long idA, String nombre, String apellido, String nacionalidad) {
		super();
		this.idA = idA;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
	}

	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdA() {
		return idA;
	}

	public void setIdA(Long idA) {
		this.idA = idA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
    
    
    
}