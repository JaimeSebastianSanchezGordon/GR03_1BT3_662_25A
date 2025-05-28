package com.barrial.Service;

import com.barrial.DAO.IntercambioDAO;
import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;

import java.util.ArrayList;
import java.util.List;

public class IntercambioService {
    public static void guardarEnBase(IntercambioDTO intercambioDTO) {
        IntercambioDAO.guardarEnBase(DTOaEntity(intercambioDTO));
    }

    private static Intercambio DTOaEntity(IntercambioDTO intercambioDTO) {
        Intercambio intercambio = new Intercambio();
        intercambio.setNombre(intercambioDTO.getNombre());
        intercambio.setDescripcion(intercambioDTO.getDescripcion());
        intercambio.setImagen(intercambioDTO.getImagen());
        intercambio.setObjetoTrueque(intercambioDTO.getObjetoTrueque());
        intercambio.setDescripcionObjetoTrueque(intercambioDTO.getDescripcionObjetoTrueque());

        System.out.println("ESTA ES LA ENTITY DE BD: " + intercambio);

        return intercambio;
    }

    public static List<IntercambioDTO> obtenerDatos() {
        return EntityaDTO(IntercambioDAO.obtenerDatos());
    }

    public static List<IntercambioDTO> EntityaDTO(List<Intercambio> intercambios) {
        List<IntercambioDTO> intercambiosDTO = new ArrayList<>();
        for (Intercambio intercambio : intercambios) {
            IntercambioDTO intercambioDTO = new IntercambioDTO();
            intercambioDTO.setId(intercambio.getId());
            intercambioDTO.setDescripcion(intercambio.getDescripcion());
            intercambioDTO.setNombre(intercambio.getNombre());
            intercambioDTO.setImagen(intercambio.getImagen());
            intercambioDTO.setObjetoTrueque(intercambio.getObjetoTrueque());
            intercambioDTO.setDescripcionObjetoTrueque(intercambio.getDescripcionObjetoTrueque());

            intercambiosDTO.add(intercambioDTO);
        }
        return intercambiosDTO;
    }
}
