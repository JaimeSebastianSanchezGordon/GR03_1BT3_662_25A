package com.barrial;

import jakarta.persistence.*;

@Entity
@Table(name = "Seguridad")
public class Seguridad {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "numVotos")
    private int numVotos;

    public Seguridad() {
        this.numVotos = 0;
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

    @Override
    public String toString() {
        return "Seguridad{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numVotos=" + numVotos +
                '}';
    }
}
