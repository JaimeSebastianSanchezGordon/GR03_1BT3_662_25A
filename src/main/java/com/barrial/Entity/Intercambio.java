package com.barrial.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Intercambio")
public class Intercambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    String descripcion;
    String imagen;
    //    CUANDO ES TRUEQUE
    String objetoTrueque;
    String descripcionObjetoTrueque;


    public Intercambio(String nombre, String descripcion, String imagen,
                       String objetoTrueque, String descripcionObjetoTrueque) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.objetoTrueque = objetoTrueque;
        this.descripcionObjetoTrueque = descripcionObjetoTrueque;
    }

    public Intercambio() {

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getObjetoTrueque() {
        return objetoTrueque;
    }

    public void setObjetoTrueque(String objetoTrueque) {
        this.objetoTrueque = objetoTrueque;
    }

    public String getDescripcionObjetoTrueque() {
        return descripcionObjetoTrueque;
    }

    public void setDescripcionObjetoTrueque(String estado) {
        this.descripcionObjetoTrueque = estado;
    }

    @Override
    public String toString() {
        return "Intercambio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", objetoTrueque='" + objetoTrueque + '\'' +
                ", estado='" + descripcionObjetoTrueque + '\'' +
                '}';
    }
}

