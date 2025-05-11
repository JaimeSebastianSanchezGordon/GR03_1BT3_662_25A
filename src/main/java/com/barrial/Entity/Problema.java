package com.barrial.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Problema")
public class Problema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "numVotos")
    private int numVotos;
    @Basic
    @Column(name = "imagen")
    private String imagen;

    public Problema(String nombre, String descripcion, int numVotos, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numVotos = numVotos;
        this.imagen = imagen;
    }

    public Problema() {
        this.numVotos = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "SeguridadDTO{" +
                "id=" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numVotos=" + numVotos + '\'' +
                '}';
    }
}
