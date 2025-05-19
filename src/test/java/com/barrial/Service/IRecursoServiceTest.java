package com.barrial.Service;

import com.barrial.Entity.Recurso;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IRecursoServiceTest {

    @Test
    public void dado_recurso_cuando_se_busca_entonces_retorna_true() {
        Recurso recursoRegistrado =
                new Recurso("Ropa",
                        "Pantalon",
                        "2",
                        "imagen");
        Recurso recursoNoRegistrado =
                new Recurso("Ropa",
                        "Media",
                        "5",
                        "imagen");
        IRecursoService iRecursoService = Mockito.mock(IRecursoService.class);
        Mockito.when(iRecursoService.buscarRecurso(recursoRegistrado)).thenReturn(true);
        assertTrue("NO EXISTE EL RECURSO BUSCADO",iRecursoService.buscarRecurso(recursoRegistrado));
    }


    @Test
    public void dado_recurso_valido_cuando_se_registra_entonces_se_llama_al_metodo() {
        Recurso recurso = new Recurso("Ropa",
                "Pantalon",
                "3",
                "imagen.jpg");
        IRecursoService iRecursoService = Mockito.mock(IRecursoService.class);
        Mockito.when(iRecursoService.registrarRecurso(recurso)).thenReturn(true);
        assertTrue("EL RECURSO NO SE REGISTRÓ CORRECTAMENTE", iRecursoService.registrarRecurso(recurso));
        Mockito.verify(iRecursoService).registrarRecurso(recurso);
    }


}