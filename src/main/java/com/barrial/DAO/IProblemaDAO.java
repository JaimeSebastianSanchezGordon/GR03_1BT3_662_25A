package com.barrial.DAO;

import com.barrial.Entity.Problema;

import java.util.List;

public interface IProblemaDAO {
    void guardar(Problema problema);

    Problema buscarProblema(int id);
    List<Problema> obtenerProblemas();
}
