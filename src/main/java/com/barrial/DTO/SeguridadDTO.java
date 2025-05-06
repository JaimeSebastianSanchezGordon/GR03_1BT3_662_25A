package com.barrial.DTO;

public class SeguridadDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private int numVotos;
    private String imagen;

    public SeguridadDTO(String nombre, String descripcion, int numVotos, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numVotos = numVotos;
        this.imagen = imagen;
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numVotos=" + numVotos + '\'' +
                '}';
    }
}
