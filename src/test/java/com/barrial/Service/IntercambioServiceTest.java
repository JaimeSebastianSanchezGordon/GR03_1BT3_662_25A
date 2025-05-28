package com.barrial.Service;

import com.barrial.DAO.IntercambioDAO;
import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class IntercambioServiceTest {
    // Test 1
    @Test
    void dado_un_DTO_cuando_se_transforma_a_Entity_entonces_retorna_true() {
        IntercambioDTO dto = new IntercambioDTO("Libro", "Buen estado", "img.jpg",
                "Calculadora", "Objeto en trueque");
        Intercambio entity = IntercambioService.DTOaEntity(dto);

        assertAll("Transformación completa",
                () -> assertEquals("Libro", entity.getNombre()),
                () -> assertEquals("Buen estado", entity.getDescripcion()),
                () -> assertEquals("img.jpg", entity.getImagen()),
                () -> assertEquals("Calculadora", entity.getObjetoTrueque()),
                () -> assertEquals("Objeto en trueque", entity.getDescripcionObjetoTrueque())
        );
    }
    // Test 2: verificar formatos válidos de imagen
    @Test
    public void dado_una_imagen_con_formato_valido_cuando_se_verifica_entonces_retorna_true() {
        assertTrue(IntercambioService.esFormatoImagenValido("foto.jpg"));
        assertTrue(IntercambioService.esFormatoImagenValido("imagen.jpeg"));
        assertTrue(IntercambioService.esFormatoImagenValido("perfil.png"));
    }


    // Test 4: DAO mock devuelve lista vacía
    @Test
    void dado_lista_vacia_mockeada_cuando_se_obtienen_intercambios_entonces_lista_vacia() {
        try (MockedStatic<IntercambioDAO> mockedDao = mockStatic(IntercambioDAO.class)) {
            mockedDao.when(IntercambioDAO::obtenerDatos).thenReturn(new ArrayList<>());

            List<IntercambioDTO> lista = IntercambioService.obtenerDatos();

            assertNotNull(lista);
            assertTrue(lista.isEmpty());

            mockedDao.verify(IntercambioDAO::obtenerDatos);
        }
    }

    // Test 5: verificar descripción no muy larga (máx 220 caracteres)
    @Test
    void dada_una_descripcion_muy_larga_cuando_se_verifica_entonces_retorna_false() {
        String descripcionLarga = "a".repeat(221);
        IntercambioDTO dto = new IntercambioDTO("Lámpara", descripcionLarga, "img.jpg",
                "Bombillo", "Disponible");

        assertFalse(IntercambioService.esDescripcionLarga(dto.getDescripcion()),
                "La descripción excede el límite de caracteres permitidos");
    }

    // Test 6: nombre sin caracteres especiales
    @Test
    void dado_nombre_con_caracteres_especiales_cuando_se_verifica_entonces_retorna_false() {
        assertFalse(IntercambioService.contieneSoloCaracteresValidos("Lib@ro"),
                "El nombre no debe contener caracteres especiales");
        assertFalse(IntercambioService.contieneSoloCaracteresValidos("Mesa#1"),
                "El nombre no debe contener caracteres especiales");
        assertTrue(IntercambioService.contieneSoloCaracteresValidos("Libro Mesa 1"),
                "El nombre con letras, números y espacios debe ser válido");
    }

    // Test 7: campos completos (ningún campo vacío)
    @Test
    public void dado_campos_completos_cuando_se_validan_entonces_retorna_true() {
        IntercambioDTO dto = new IntercambioDTO("Libro", "Buen estado", "img.jpg",
                "Calculadora", "Disponible");
        assertTrue(IntercambioService.camposCompletos(dto), "TIENES QUE COMPLETAR TODOS LOS CAMPOS");
    }

    // Test 8: si algún campo está vacío retorna false
    @Test
    public void dado_campo_vacio_cuando_se_valida_entonces_retorna_false() {
        IntercambioDTO dto = new IntercambioDTO("", "Buen estado", "img.jpg",
                "Calculadora", "Disponible");
        assertFalse(IntercambioService.camposCompletos(dto), "No debe aceptar campos vacíos");
    }
}