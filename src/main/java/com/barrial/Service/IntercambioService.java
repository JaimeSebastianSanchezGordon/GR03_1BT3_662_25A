package com.barrial.Service;

import com.barrial.DAO.IntercambioDAO;
import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntercambioService {
    public static void guardarEnBase(IntercambioDTO intercambioDTO) {
        IntercambioDAO.guardarEnBase(DTOaEntity(intercambioDTO));
    }

    public static Intercambio DTOaEntity(IntercambioDTO intercambioDTO) {
        if(!camposCompletos(intercambioDTO)){
            throw new IllegalArgumentException("Faltan campos obligatorios en el DTO: " + intercambioDTO);
        } else if (!esFormatoImagenValido(intercambioDTO.getImagen())
                || !esDescripcionLarga(intercambioDTO.getDescripcion()) || !contieneSoloCaracteresValidos(intercambioDTO.getNombre())){
            throw new IllegalArgumentException("Datos inválidos en el DTO: " + intercambioDTO);
        }

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

    private static List<IntercambioDTO> EntityaDTO(List<Intercambio> intercambios) {
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

    public static boolean esFormatoImagenValido(String nombreArchivo) {
        if (nombreArchivo == null) return false;
        return nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".png");
    }

    public static boolean esEstadoValido(String estado) {
        List<String> estadosValidos = Arrays.asList("Disponible", "Intercambiado");
        return estadosValidos.contains(estado);
    }

    public static boolean esDescripcionLarga(String descripcion) {
        return descripcion != null && descripcion.length() <= 220;
    }

    public static boolean contieneSoloCaracteresValidos(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-Z0-9\\s]+$");
    }

    public static boolean camposCompletos(IntercambioDTO dto) {
        return dto != null
                && dto.getNombre() != null && !dto.getNombre().isEmpty()
                && dto.getDescripcion() != null && !dto.getDescripcion().isEmpty()
                && dto.getImagen() != null && !dto.getImagen().isEmpty()
                && dto.getObjetoTrueque() != null && !dto.getObjetoTrueque().isEmpty()
                && dto.getDescripcionObjetoTrueque() != null && !dto.getDescripcionObjetoTrueque().isEmpty();
    }
}
