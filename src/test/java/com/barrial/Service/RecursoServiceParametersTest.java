package com.barrial.Service;

import com.barrial.DTO.RecursoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class RecursoServiceParametersTest {

    private RecursoDTO recursoDTO;

    @Parameterized.Parameters
    public static Iterable<RecursoDTO> parameters() {
        List<RecursoDTO> recursos = new ArrayList<RecursoDTO>();
        recursos.add(new RecursoDTO("Ropa", "Camisa", "5", "camisa.jpg"));
        recursos.add(new RecursoDTO("Limpieza", "Escoba", "2", "escoba.jpg"));
        recursos.add(new RecursoDTO("Papelería", "Bolígrafo", "30", "boligrafo.jpg"));
        recursos.add(new RecursoDTO("Comida", "Silla", "6", "silla.jpg"));
        recursos.add(new RecursoDTO("Muebles", "Escritorio", "2", "escritorio.jpg"));

        return recursos;
    }

    public RecursoServiceParametersTest(RecursoDTO recursoDTO){
        this.recursoDTO = recursoDTO;

    }

    @Test
    public void dado_tipo_recurso_correcto_cuando_se_registra_entonces_retorna_true(){
        assertTrue("EL TIPO DE RECURSO NO ES VALIDO",RecursoService.verificarTipo(recursoDTO.getTipoRecurso()));
    }


    @Test
    public void dado_campos_completos_cuando_se_validan_entonces_retorna_true(){
        assertTrue("TIENES QUE COMPLETAR TODOS LOS CAMPOS",RecursoService.camposCompletos(recursoDTO));
    }

}