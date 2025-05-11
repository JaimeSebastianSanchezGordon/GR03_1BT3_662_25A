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
        return emprendimientos.stream()
                .map(e -> new EmprendimientoDTO(e.getNombre(), e.getDescripcion()))
                .collect(Collectors.toList());
    }


    public static void guardarEnBase(EmprendimientoDTO emprendimientoDTO) {
        Emprendimiento emprendimiento = DTOaEntity(emprendimientoDTO);
        EmprendimientoDAO.guardarEnBase(emprendimiento);
    }

    public static Emprendimiento DTOaEntity(EmprendimientoDTO emprendimientoDTO) {
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(emprendimientoDTO.getNombre());
        emprendimiento.setDescripcion(emprendimientoDTO.getDescripcion());
        return emprendimiento;
    }


}
