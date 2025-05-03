package com.barrial;

import jakarta.persistence.*;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @Column (name = "nombre")
    private String nombre;
    @Basic
    @Column (name = "descripcion")
    private String descripcion;
    @Basic
    @Column (name = "fecha")
    private String fecha;
    @Basic
    @Column (name = "hora")
    private String hora;

    public Evento() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
