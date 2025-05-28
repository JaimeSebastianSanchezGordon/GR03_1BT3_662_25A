package com.barrial.Service;

import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;

import java.util.ArrayList;
import java.util.List;

public class IntercambioService {
    public static void guardarEnBase(IntercambioDTO intercambioDTO) {
    }

    private static Intercambio DTOaEntity(IntercambioDTO intercambioDTO) {
        Intercambio intercambio = new Intercambio();


        return intercambio;
    }

    public static List<IntercambioDTO> obtenerDatos() {

        return null;
    }

    private static List<IntercambioDTO> EntityaDTO(List<Intercambio> intercambios) {
        List<IntercambioDTO> intercambiosDTO = new ArrayList<>();

        return intercambiosDTO;
    }
}

