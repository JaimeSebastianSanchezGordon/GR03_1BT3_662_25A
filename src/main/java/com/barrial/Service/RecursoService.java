package com.barrial.Service;

import com.barrial.DTO.RecursoDTO;
import com.barrial.Entity.Recurso;

import java.util.ArrayList;
import java.util.List;

public class RecursoService {

    public static boolean camposCompletos(RecursoDTO recurso) {
        if(!recurso.getNombreRecurso().isEmpty()
                && !recurso.getTipoRecurso().isEmpty()
                && !recurso.getCantidadRecurso().isEmpty()
                && !recurso.getImagen().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean campoVacio(RecursoDTO recurso) {
        if(!recurso.getNombreRecurso().isEmpty()
                && !recurso.getTipoRecurso().isEmpty()
                && !recurso.getCantidadRecurso().isEmpty()
                && !recurso.getImagen().isEmpty()){
            return false;
        }
        return true;
    }

    public static List<Recurso> obtenerRecursos() {
        List<Recurso> recursos = new ArrayList<Recurso>();
        if (recursos != null && !recursos.isEmpty()) {
            return recursos;
        }
        throw new IllegalArgumentException("NO HAY RECURSOS REGISTRADOS");
    }

    public static boolean buscarRecursos(Recurso recurso) {
        List<Recurso> recursos = new ArrayList<Recurso>();
        recursos.add(new Recurso("Ropa", "Pantalon", "2", "imagen" ));
        recursos.add(new Recurso("Ropa", "Gorra", "1", "imagen" ));
        for (Recurso r : recursos) {
            if (r.getNombre() == recurso.getNombre()) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarTipo(String tipoRecurso) {
        List<String> tipoRecursos = new ArrayList();
        tipoRecursos.add("Ropa");
        tipoRecursos.add("Comida");
        tipoRecursos.add("Limpieza");
        tipoRecursos.add("Papelería");
        tipoRecursos.add("Muebles");
        for (String tipo: tipoRecursos){
            if (tipo.equals(tipoRecurso)) {
                return true;
            }
        }
        return false;
    }



    public static void validarNombreSinNumeros(String nombre) {
        if (nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("NO PUEDES PONER NUMEROS EN EL NOMBRE DEL RECURSO");
        }
    }

    public static void validarNombreSinCaracterEspecial(String nombre) {
        if (nombre.matches(".*[^a-zA-Z0-9 ].*")) {
            throw new IllegalArgumentException("NO PUEDES PONER CARACTERES ESPECIALES EN EL NOMBRE DEL RECURSO");
        }
    }
}
