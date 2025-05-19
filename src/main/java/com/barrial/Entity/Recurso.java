package com.barrial.Entity;

import jakarta.persistence.*;

@Entity
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "tipo")
    private String tipo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "cantidad")
    private String cantidad;
    @Basic
    @Column(name = "imagen")
    private String imagen;

    public Recurso() {
    }
    public Recurso(String tipoRecurso, String nombreRecurso, String cantidadRecurso, String imagen) {
        this.tipo = tipoRecurso;
        this.nombre = nombreRecurso;
        this.cantidad = cantidadRecurso;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Recursos{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
