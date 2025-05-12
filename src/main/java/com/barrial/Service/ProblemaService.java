package com.barrial.Service;

import com.barrial.DAO.IProblemaDAO;
import com.barrial.DTO.ProblemaDTO;
import com.barrial.Entity.Problema;
import com.barrial.DAO.ProblemaDAO;

import java.util.ArrayList;
import java.util.List;

public class ProblemaService {

    private IProblemaDAO problemaDAO;

    public ProblemaService(IProblemaDAO problemaDAO) {
        this.problemaDAO = problemaDAO;
    }

    public Problema buscarProblema(int id) {
        return problemaDAO.buscarProblema(id);
    }

    public List<Problema> obtenerProblemas() {
        return problemaDAO.obtenerProblemas();
    }

    public void registrarProblema(Problema problema) {
        problemaDAO.guardar(problema);
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

    public static void guardarEnBase(ProblemaDTO problemaDTO) {
        ProblemaDAO.guardarEnBase(DTOaEntity(problemaDTO));
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
