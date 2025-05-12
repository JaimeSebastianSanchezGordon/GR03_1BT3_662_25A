package com.barrial.Service;

import com.barrial.DAO.ProblemaDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;

import java.util.Arrays;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;



@RunWith(Parameterized.class)
public class ProblemaServiceExistenceTest {

    @Mock
    private ProblemaDAO problemaDAO;

    @InjectMocks
    private ProblemaService problemaService;

    private String nombreProblema;
    private boolean existe;

    public ProblemaServiceExistenceTest(String nombreProblema, boolean existe) {
        this.nombreProblema = nombreProblema;
        this.existe = existe;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(problemaDAO.existsByNombre(nombreProblema)).thenReturn(existe);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {"Baches en calle principal", true},
                {"Falta de iluminación", true},
                {"Parque descuidado", true},
                {"Ruido excesivo", true}
        });
    }

    @Test
    public void given_problem_name_when_check_existence_then_return_expected() {
        boolean resultado = problemaService.existeProblema(nombreProblema);
        assertEquals(existe, resultado);
    }
}