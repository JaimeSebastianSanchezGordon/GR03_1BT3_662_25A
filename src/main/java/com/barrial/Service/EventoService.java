package com.barrial.Service;

import com.barrial.DAO.EventoDAO;
import com.barrial.DTO.EventoDTO;
import com.barrial.Entity.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoService {
    public static List<EventoDTO> obtenerDatos() {
        return EntityaDTO(EventoDAO.obtenerDatos());
    }

    private static List<EventoDTO> EntityaDTO(List<Evento> eventos) {
        List<EventoDTO> eventosDTO = new ArrayList<>();
        for (Evento evento : eventos) {
            EventoDTO eventoDTO =
                    new EventoDTO(
                            evento.getNombre(),
                            evento.getDescripcion(),
                            evento.getFecha(),
                            evento.getHora(),
                            evento.getImagen());
            eventoDTO.setId(evento.getId());
            eventosDTO.add(eventoDTO);
        }
        return eventosDTO;
    }

    public static void guardarEnBase(EventoDTO eventoDTO) {
        EventoDAO.guardarEnBase(DTOaEntity(eventoDTO));
    }

    public static Evento DTOaEntity(EventoDTO eventoDTO) {
        Evento evento = new Evento();
        evento.setNombre(eventoDTO.getNombre());
        evento.setDescripcion(eventoDTO.getDescripcion());
        evento.setFecha(eventoDTO.getFecha());
        evento.setHora(eventoDTO.getHora());
        evento.setImagen(eventoDTO.getImagen());
        return evento;
    }

    public static void eliminarEvento(int idEvento) {
        EventoDAO.eliminarEvento(obtenerEvento(idEvento));
    }

    // PARA ELIMINAR
    private static Evento obtenerEvento(int idEvento) {
        for (Evento evento : EventoDAO.obtenerDatos()) {
            if (evento.getId() == idEvento) {
                return evento;
            }
        }
        return null;
    }

    // PARA EDITAR
    private static Evento obtenerEvento(int idEvento, String nombre, String descripcion, String fecha, String hora, String imagen) {
        for (Evento evento : EventoDAO.obtenerDatos()) {
            if (evento.getId() == idEvento) {
                evento.setNombre(nombre);
                evento.setDescripcion(descripcion);
                evento.setImagen(fecha);
                evento.setHora(hora);
                evento.setImagen(imagen);
                return evento;
            }
        }
        return null;
    }

    public static void editarEvento(int idEvento, String nombre, String descripcion, String fecha, String hora, String imagen) {
        EventoDAO.editarEvento(obtenerEvento(idEvento, nombre, descripcion, fecha, hora, imagen));
    }
}
