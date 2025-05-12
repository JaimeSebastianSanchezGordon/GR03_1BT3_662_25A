package com.barrial.Service;

import com.barrial.DAO.IProblemaDAO;
import com.barrial.DAO.ProblemaDAO;
import com.barrial.Entity.Problema;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Validation.ValidateProblema;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProblemaServiceTest {


    class TestProblemaDAO implements IProblemaDAO {
        @Override
        public List<Problema> obtenerProblemas() {
            List<Problema> lista = new ArrayList<>();
            lista.add(new Problema("Inseguridad", "Robo en calles", 0, "imagen"));
            lista.add(new Problema("Basura", "Acumulación en calles", 0, "imagen"));
            lista.add(new Problema("Ruido", "Molestias por volumen", 0, "imagen"));
            return lista;
        }

        @Override
        public void guardar(Problema problema) {

        }

        @Override
        public Problema buscarProblema(int id) {
            return new Problema("Inseguridad",
                    "Robo en calles",
                    0,
                    "imagen");
        }
    }

    ProblemaService problemaService = null;

//    @Before
//    public void setUp() {
//        // Configuración común antes de cada prueba
//        problemaService = new ProblemaService(new TestProblemaDAO());
//    }

    @Test (timeout = 100)
    public void given_problema_id_when_busca_then_existe_problema() {
        Problema problemaActual = problemaService.buscarProblema(1);
        assertEquals("Inseguridad", problemaActual.getNombre());
    }

    @Test (timeout = 100)
    public void given_datos_when_obtener_problemas_then_size_correcto() {
        List<Problema> totalProblemasActuales = problemaService.obtenerProblemas();
        assertEquals(3, totalProblemasActuales.size());
    }

    @Test
    public void given_problema_when_registra_then_dao_guarda_invocado() {
        // Arrange
        IProblemaDAO iProblemaDAO = Mockito.mock(IProblemaDAO.class);
        ProblemaService problemaService = new ProblemaService(iProblemaDAO);
        Problema problema = new Problema("Inseguridad",
                "Robo en calles",
                0,
                "imagen");

        problemaService.registrarProblema(problema);

        verify(iProblemaDAO, times(1)).guardar(problema);
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
        doThrow(new RuntimeException("DB error")).when(mockDAO).editarSeguridad(any(Problema.class));

        //Verificar que se lanza la excepción esperada
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mockDAO.editarSeguridad(problema);
        });
        //Comprobar que la excepción lanzada es la esperada
        assertEquals("DB error", exception.getMessage());

        System.out.println("Test con Mock");
    }

}