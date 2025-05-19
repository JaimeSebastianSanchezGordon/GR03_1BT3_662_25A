package com.barrial.Service;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.DAO.ProblemaDAO;
import com.barrial.Entity.Problema;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class ProblemaServiceParameterizedTest {

    @Mock
    private ProblemaDAO problemaDAO;

    @InjectMocks
    private ProblemaService problemaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private String nombre;
    private String descripcion;
    private int numVotos;
    private String imagen;

    public ProblemaServiceParameterizedTest(String nombre, String descripcion, int numVotos, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numVotos = numVotos;
        this.imagen = imagen;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"Baches en calle principal", "Baches peligrosos en la avenida", 0, "bache.jpg"});
        objects.add(new Object[]{"Falta de iluminación", "Lobos", 0, "luz.jpg"});
        objects.add(new Object[]{"Parque descuidado", "Basura en áreas verdes", 0, "parque.jpg"});
        objects.add(new Object[]{"Alcantarilla tapada", "Inundaciones en temporada de lluvia", 0, "alcantarilla.jpg"});
        objects.add(new Object[]{"Ruido excesivo", "Bares con música alta", 0, "ruido.jpg"});
        return objects;
    }

    @Test
    public void given_different_problems_NullDescription_when_register_then_ok() {
        ProblemaDTO problemaDTO = new ProblemaDTO(nombre, descripcion, numVotos, imagen);
        problemaService.guardarEnBase(problemaDTO);
    }
}
