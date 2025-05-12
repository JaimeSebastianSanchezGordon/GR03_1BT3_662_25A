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
    public static void editarRecurso(int idRecurso, String tipoRecurso, String nombreRecurso, int cantidadRecurso, String imagen) {
        RecursoDAO.editarRecurso(obtenerRecurso(idRecurso, tipoRecurso, nombreRecurso, cantidadRecurso, imagen));
    }

    // OBTENER RECURSO PARA EDITAR
    private static Recurso obtenerRecurso(int idRecurso, String tipoRecurso, String nombreRecurso, int cantidadRecurso, String imagen) {
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
}
