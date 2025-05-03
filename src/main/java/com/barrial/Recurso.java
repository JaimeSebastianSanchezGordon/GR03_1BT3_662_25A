package com.barrial;

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
    private int cantidad;

    public Recurso() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
