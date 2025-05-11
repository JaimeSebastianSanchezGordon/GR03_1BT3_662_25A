package com.barrial.Service;

import org.junit.Test;

import static org.junit.Assert.*;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Validation.ValidateProblema;
import org.junit.*;

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

}