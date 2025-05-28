package com.barrial.Service;
import com.barrial.DAO.RecursoDAO;
import com.barrial.DTO.RecursoDTO;
import com.barrial.Entity.Recurso;

import java.util.ArrayList;
import java.util.List;

public class RecursoService {
    public static List<RecursoDTO> obtenerDatos() {
        return EntityaDTO(RecursoDAO.obtenerDatos());
    }

    private static List<RecursoDTO> EntityaDTO(List<Recurso> recursos) {
        List<RecursoDTO> recursosDTO = new ArrayList<>();
        for (Recurso recurso : recursos) {
            RecursoDTO recursoDTO =
                    new RecursoDTO(
                            recurso.getTipo(),
                            recurso.getNombre(),
                            recurso.getCantidad(),
                            recurso.getImagen());
            recursoDTO.setId(recurso.getId());
            recursosDTO.add(recursoDTO);
        }
        return recursosDTO;
    }

    // GUARDAR EN BASE
    public static void guardarEnBase(RecursoDTO recursoDTO) {
        RecursoDAO.guardarEnBase(DTOaEntity(recursoDTO));
    }

    public static Recurso DTOaEntity(RecursoDTO recursoDTO) {
        Recurso recurso = new Recurso(
                recursoDTO.getTipoRecurso(),
                recursoDTO.getNombreRecurso(),
                recursoDTO.getCantidadRecurso(),
                recursoDTO.getImagen()
        );
        return recurso;
    }

    // ELIMINAR RECURSO
    public static void eliminarRecurso(int idRecurso) {
        RecursoDAO.eliminarRecurso(obtenerRecurso(idRecurso));
    }

    // OBTENER RECURSO
    private static Recurso obtenerRecurso(int idRecurso) {
        for (Recurso recurso : RecursoDAO.obtenerDatos()) {
            if (recurso.getId() == idRecurso) {
                return recurso;
            }
        }
        return null;
    }

    // EDITAR RECURSO
    public static void editarRecurso(int idRecurso, String tipoRecurso, String nombreRecurso, String cantidadRecurso, String imagen) {
        RecursoDAO.editarRecurso(obtenerRecurso(idRecurso, tipoRecurso, nombreRecurso, cantidadRecurso, imagen));
    }

    // OBTENER RECURSO PARA EDITAR
    private static Recurso obtenerRecurso(int idRecurso, String tipoRecurso, String nombreRecurso, String cantidadRecurso, String imagen) {
        for (Recurso recurso : RecursoDAO.obtenerDatos()) {
            if (recurso.getId() == idRecurso) {
                recurso.setTipo(tipoRecurso);
                recurso.setNombre(nombreRecurso);
                recurso.setCantidad(cantidadRecurso);
                recurso.setImagen(imagen);
                return recurso;
            }
        }
        return null;
    }

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
