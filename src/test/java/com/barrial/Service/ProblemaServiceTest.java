package com.barrial.Service;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.DAO.ProblemaDAO;
import com.barrial.Entity.Problema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Validation.ValidateProblema;
@RunWith(MockitoJUnitRunner.class)
public class ProblemaServiceTest {
    @Mock
    private ProblemaDAO problemaDAO;

    @InjectMocks
    private ProblemaService problemaService;
    @Test (expected = IllegalArgumentException.class)
    public void given_null_name_when_insert_BD_then_exception() {
        ProblemaDTO problemaDTO = new ProblemaDTO(
                null,
                "Descripción de prueba",
                0,
                "imagen.jpg"
        );
        problemaService.guardarEnBase(problemaDTO);
    }

    @Test
    public void given_negative_votes_when_create_problem_then_DefaultToZero() {
        ProblemaDTO problemaDTO = new ProblemaDTO(
                "Nombre de prueba",
                "Descripción de prueba",
                -1,
                "imagen.jpg"
        );

        problemaService.guardarEnBase(problemaDTO);

        assertEquals(0, problemaDTO.getNumVotos());
        verify(problemaDAO, times(1)).guardarEnBase(any(Problema.class));
    }

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


    //Prueba unitaria 7: Eliminar problemabarial en BD.
    @Test
    public void given__when__then7(){
    }

    //Prueba unitaria 8: Editar campos de problemabarial en BD.
    @Test
    public void given_when_then8(){
    }

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
        assertEquals("DB error", exception.getMessage());

        System.out.println("Test con Mock");
    }

}