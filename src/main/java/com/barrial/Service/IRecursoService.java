package com.barrial.Service;

import com.barrial.Entity.Recurso;

public interface IRecursoService {
    boolean registrarRecurso(Recurso recurso);

    boolean buscarRecurso(Recurso recurso);
}
