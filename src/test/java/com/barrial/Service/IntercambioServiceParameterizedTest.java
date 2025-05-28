package com.barrial.Service;
import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntercambioServiceParameterizedTest {

    // Prueba parametrizada 1 - conversión de DTO a Entity
    public static Iterable<IntercambioDTO> parametersDTO() {
        return List.of(
                new IntercambioDTO("Libro", "Buen estado", "img1.jpg", "Regla", "Buen estado"),
                new IntercambioDTO("Reloj", "Poco uso", "img2.jpg", "USB", "Excelente estado"),
                new IntercambioDTO("Pelota", "Nueva", "img3.jpg", "Guantes", "Nueva con etiqueta"),
                new IntercambioDTO("Silla", "Usada", "img4.jpg", "Mesa", "Algo desgastada"),
                new IntercambioDTO("Auriculares", "Buen sonido", "img5.jpg", "Cable", "Como nuevo")
        );
    }

    @ParameterizedTest
    @MethodSource("parametersDTO")
    public void dado_un_IntercambioDTO_cuando_se_convierte_a_Entidad_entonces_el_nombre_es_igual(IntercambioDTO dto) {
        Intercambio entidad = IntercambioService.DTOaEntity(dto);
        assertEquals(dto.getNombre(), entidad.getNombre());
    }

    // Prueba parametrizada 2 - conversión de Entity a DTO
    static Stream<Arguments> parametersEntity() {
        List<Intercambio> listaCompleta = List.of(
                new Intercambio("Libro", "Buen estado", "img1.jpg", "Regla", "Buen estado"),
                new Intercambio("Reloj", "Poco uso", "img2.jpg", "USB", "Excelente estado"),
                new Intercambio("Pelota", "Nueva", "img3.jpg", "Guantes", "Nueva con etiqueta"),
                new Intercambio("Silla", "Usada", "img4.jpg", "Mesa", "Algo desgastada")
        );
        return Stream.of(Arguments.of(listaCompleta));
    }

    @ParameterizedTest
    @MethodSource("parametersEntity")
    public void dado_lista_de_intercambios_cuando_se_convierte_a_DTO_entonces_se_preserva_el_tamaño(List<Intercambio> listaEntity) {
        List<IntercambioDTO> listaDTO = IntercambioService.EntityaDTO(listaEntity);
        assertEquals(listaEntity.size(), listaDTO.size());
    }
}

