package com.barrial.Service;

import com.barrial.DAO.ProblemaDAO;
import com.barrial.Entity.Problema;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Validation.ValidateProblema;

public class ProblemaServiceTest {

    //Prueba Unitaria 1: Crear problemabarial con datos válidos.
    @Test
    public void given_problemaBarrial_when_wrong_data_then_exception(){
        ProblemaDTO problemaDTO = new ProblemaDTO(
                "Pedro",
                "Descripción ejemplo",
                0,
                "http://hola.com"
        );
        assertTrue(ValidateProblema.isValidProblemaBarrial(problemaDTO));
        System.out.println("Done");
    }

    //Prueba Unitaria 2: Crear cuadro con URL de imagen inválida.
    @Test
    public void given_URL_when_valid_data_then_ok(){
        ProblemaDTO problemaDTO = new ProblemaDTO(
                "Pedro",
                "Descripción ejemplo",
                0,
                "https://prueba.com"
        );

        assertTrue(ValidateProblema.isValidProblemaBarrial(problemaDTO));
        System.out.println("Hecho");
    }

    @Test
    public void given_when_then(){


    }

    @Test
    public void given_when_then2(){


    }

    //Prueba Unitaria Mockito 2: Simular error en base de datos al actualizar votos.
    @Test
    public void given_update_on_BD_when_wrong_data_then_exception(){
        Problema problema = new Problema(
                1, "NuevoProblema", "Problema descripción", 3, "http//imagen"
        );
        ProblemaDAO mockDAO = mock(ProblemaDAO.class);
        doThrow(new RuntimeException("DB error")).when(mockDAO).editarSeguridad(any(Problema.class));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            mockDAO.editarSeguridad(problema);
        });

        assertEquals("DB error", exception.getMessage());
    }

}