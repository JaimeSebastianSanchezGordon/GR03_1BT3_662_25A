package com.barrial.Service;

import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;

import java.util.List;

public interface IIntercambioService {
    boolean validacionCamposObligatorio(Intercambio intercambio);

    boolean validacionActualizacion(Intercambio intercambio);

}
