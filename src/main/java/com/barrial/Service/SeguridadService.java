package com.barrial.Service;

import com.barrial.DTO.SeguridadDTO;
import com.barrial.Entity.Seguridad;
import com.barrial.DAO.SeguridadDAO;

import java.util.ArrayList;
import java.util.List;

public class SeguridadService {

    public static List<SeguridadDTO> obtenerDatos() {
        return EntityaDTO(SeguridadDAO.obtenerDatos());
    }

    private static List<SeguridadDTO> EntityaDTO(List<Seguridad> seguridades) {
        List<SeguridadDTO> seguridadDTOs = new ArrayList<>();
        for (Seguridad seguridad : seguridades) {
            SeguridadDTO seguridadDTO = new SeguridadDTO(
                    seguridad.getNombre(),
                    seguridad.getDescripcion(),
                    seguridad.getNumVotos(),
                    seguridad.getImagen()
            );
            seguridadDTOs.add(seguridadDTO);
        }
        return seguridadDTOs;
    }

    public static void guardarEnBase(SeguridadDTO seguridadDTO) {
        SeguridadDAO.guardarEnBase(DTOaEntity(seguridadDTO));
    }

    public static Seguridad DTOaEntity(SeguridadDTO seguridadDTO) {
        Seguridad seguridad = new Seguridad();
        seguridad.setNombre(seguridadDTO.getNombre());
        seguridad.setDescripcion(seguridadDTO.getDescripcion());
        seguridad.setNumVotos(seguridadDTO.getNumVotos());
        seguridad.setImagen(seguridadDTO.getImagen());
        return seguridad;
    }

    public static void eliminarSeguridad(int idSeguridad) {
        SeguridadDAO.eliminarSeguridad(obtenerSeguridad(idSeguridad));
    }

    private static Seguridad obtenerSeguridad(int idSeguridad) {
        for (Seguridad seguridad : SeguridadDAO.obtenerDatos()) {
            if (seguridad.getId() == idSeguridad) {
                return seguridad;
            }
        }
        return null;
    }
}
