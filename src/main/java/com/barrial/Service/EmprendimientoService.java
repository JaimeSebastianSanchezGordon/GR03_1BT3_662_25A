package com.barrial.Service;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.Entity.Emprendimiento;
import com.barrial.DAO.EmprendimientoDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmprendimientoService {

    public static List<EmprendimientoDTO> obtenerDatos() {
        return EntityaDTO(EmprendimientoDAO.obtenerDatos());
    }

    private static List<EmprendimientoDTO> EntityaDTO(List<Emprendimiento> emprendimientos) {
        List<EmprendimientoDTO> emprendimientosDTO = new ArrayList<>();
        for (Emprendimiento emprendimiento : emprendimientos) {
            EmprendimientoDTO emprendimientoDTO =
                    new EmprendimientoDTO(
                            emprendimiento.getNombre(),
                            emprendimiento.getDescripcion(),
                            emprendimiento.getImagen());
            emprendimientoDTO.setId(emprendimiento.getId());
            emprendimientosDTO.add(emprendimientoDTO);
        }
        return emprendimientosDTO;
    }

    public static void guardarEnBase(EmprendimientoDTO emprendimientoDTO) {
        EmprendimientoDAO.guardarEnBase(DTOaEntity(emprendimientoDTO));
    }

    public static Emprendimiento DTOaEntity(EmprendimientoDTO emprendimientoDTO) {
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(emprendimientoDTO.getNombre());
        emprendimiento.setDescripcion(emprendimientoDTO.getDescripcion());
        emprendimiento.setImagen(emprendimientoDTO.getImagen());
        return emprendimiento;
    }

    public static void eliminarEmprendimiento(int idEmprendimiento) {
        EmprendimientoDAO.eliminarEmprendimiento(obtenerEmprendimiento(idEmprendimiento));
    }

    // PARA ELIMINAR
    private static Emprendimiento obtenerEmprendimiento(int idEmprendimiento) {
        for (Emprendimiento emprendimiento : EmprendimientoDAO.obtenerDatos()) {
            if (emprendimiento.getId() == idEmprendimiento) {
                return emprendimiento;
            }
        }
        return null;
    }

    // PARA EDITAR
    private static Emprendimiento obtenerEmprendimiento(int idEmprendimiento, String nombre, String descripcion, String imagen) {
        for (Emprendimiento emprendimiento : EmprendimientoDAO.obtenerDatos()) {
            if (emprendimiento.getId() == idEmprendimiento) {
                emprendimiento.setNombre(nombre);
                emprendimiento.setDescripcion(descripcion);
                emprendimiento.setImagen(imagen);
                return emprendimiento;
            }
        }
        return null;
    }

    public static void editarEmprendimiento(int idEmprendimiento, String nombre, String descripcion, String imagen) {
        EmprendimientoDAO.editarEmprendimiento(obtenerEmprendimiento(idEmprendimiento, nombre, descripcion, imagen));
    }
}
