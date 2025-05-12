package com.barrial.Service;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Entity.Problema;
import com.barrial.DAO.ProblemaDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProblemaService {
    private final ProblemaDAO problemaDAO;
    public ProblemaService(ProblemaDAO problemaDAO) {
        this.problemaDAO = problemaDAO;
    }
    public static List<ProblemaDTO> obtenerDatos() {
        return EntityaDTO(ProblemaDAO.obtenerDatos());
    }

    private static List<ProblemaDTO> EntityaDTO(List<Problema> seguridades) {
        List<ProblemaDTO> problemaDTOS = new ArrayList<>();
        for (Problema problema : seguridades) {
            ProblemaDTO problemaDTO = new ProblemaDTO(
                    problema.getNombre(),
                    problema.getDescripcion(),
                    problema.getNumVotos(),
                    problema.getImagen()
            );
            problemaDTOS.add(problemaDTO);
        }
        return problemaDTOS;
    }

    public void guardarEnBase(ProblemaDTO problemaDTO) {
        validarProblemaDTO(problemaDTO);
        normalizarDatos(problemaDTO);
        problemaDAO.guardarEnBase(DTOaEntity(problemaDTO));
    }

    private void validarProblemaDTO(ProblemaDTO problemaDTO) {
        Objects.requireNonNull(problemaDTO, "El DTO no puede ser nulo");

        if (problemaDTO.getNombre() == null || problemaDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (problemaDTO.getDescripcion() == null || problemaDTO.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
    }

    private void normalizarDatos(ProblemaDTO problemaDTO) {
        if (problemaDTO.getNumVotos() < 0) {
            problemaDTO.setNumVotos(0);
        }
    }

    public static Problema DTOaEntity(ProblemaDTO problemaDTO) {
        Problema problema = new Problema();
        problema.setNombre(problemaDTO.getNombre());
        problema.setDescripcion(problemaDTO.getDescripcion());
        problema.setNumVotos(problemaDTO.getNumVotos());
        problema.setImagen(problemaDTO.getImagen());
        return problema;
    }

    public static void eliminarSeguridad(int idSeguridad) {
        ProblemaDAO.eliminarSeguridad(obtenerSeguridad(idSeguridad));
    }

    private static Problema obtenerSeguridad(int idSeguridad) {
        for (Problema problema : ProblemaDAO.obtenerDatos()) {
            if (problema.getId() == idSeguridad) {
                return problema;
            }
        }
        return null;
    }
}
