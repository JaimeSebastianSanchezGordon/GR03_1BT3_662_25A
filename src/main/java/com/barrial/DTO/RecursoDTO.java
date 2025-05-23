package com.barrial.DTO;

public class RecursoDTO {
    private int id;
    private String tipoRecurso;
    private String nombreRecurso;
    private String cantidadRecurso;
    private String imagen;

    public RecursoDTO(String tipoRecurso, String nombreRecurso, String cantidadRecurso, String imagen) {
        this.tipoRecurso = tipoRecurso;
        this.nombreRecurso = nombreRecurso;
        this.cantidadRecurso = cantidadRecurso;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipoRecurso() {
        return tipoRecurso;
    }
    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }
    public String getNombreRecurso() {
        return nombreRecurso;
    }
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }
    public String getCantidadRecurso() {
        return cantidadRecurso;
    }
    public void setCantidadRecurso(String cantidadRecurso) {
        this.cantidadRecurso = cantidadRecurso;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
