package com.barrial.Service;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.Entity.Emprendimiento;
import com.barrial.DAO.EmprendimientoDAO;

import java.util.ArrayList;
import java.util.List;

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

    private static Emprendimiento obtenerEmprendimiento(int idEmprendimiento) {
        for (Emprendimiento emprendimiento : EmprendimientoDAO.obtenerDatos()) {
            if (emprendimiento.getId() == idEmprendimiento) {
                return emprendimiento;
            }
        }
        return null;
    }
}
