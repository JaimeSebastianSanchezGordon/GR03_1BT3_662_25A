package com.barrial.DTO;


public class IntercambioDTO {
    int id;
    String nombre;
    String descripcion;
    String imagen;
    //    CUANDO ES TRUEQUE
    String objetoTrueque;
    String descripcionObjetoTrueque;

    //    CONTRUCTOR PARA TRUEQUE
    public IntercambioDTO(String nombre, String descripcion, String imagen,
                          String objetoTrueque, String descripcionObjetoTrueque) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.objetoTrueque = objetoTrueque;
        this.descripcionObjetoTrueque = descripcionObjetoTrueque;
    }

    public IntercambioDTO() {

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

    public void setDescripcionObjetoTrueque(String descripcionObjetoTrueque) {
        this.descripcionObjetoTrueque = descripcionObjetoTrueque;
    }

    @Override
    public String toString() {
        return "IntercambioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", objetoTrueque='" + objetoTrueque + '\'' +
                ", estado='" + descripcionObjetoTrueque + '\'' +
                '}';
    }
}
