package com.barrial.Service;

import com.barrial.DAO.ProblemaDAO;
import com.barrial.Entity.Problema;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class ProblemaServiceTest {


    //Prueba Unitaria Mockito 2: Simular error en base de datos al actualizar votos.
    @Test
    public void given_update_on_BD_when_wrong_data_then_exception(){
        //Objetos con datos de entrada del usuario
        Problema problema = new Problema(
                1, "NuevoProblema", "Problema descripción", 3, "http//imagen"
        );
        //Se mockea al DAO
        ProblemaDAO mockDAO = mock(ProblemaDAO.class);
        //Simulación de excepción del método editarSeguridad
        doThrow(new RuntimeException("DB Error")).when(mockDAO).editarSeguridad(any(Problema.class));

        //Verificar que se lanza la excepción esperada
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mockDAO.editarSeguridad(problema);
        });
        //Comprobar que la excepción lanzada es la esperada
        assertEquals("DB Error", exception.getMessage());

        System.out.println("Test con Mock");
    }

}