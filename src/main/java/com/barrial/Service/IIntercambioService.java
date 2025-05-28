package com.barrial.Service;

import com.barrial.Entity.Intercambio;

public interface IIntercambioService {
    boolean validacionCamposObligatorio(Intercambio intercambio);

    boolean validacionActualizacion(Intercambio intercambio);

}
