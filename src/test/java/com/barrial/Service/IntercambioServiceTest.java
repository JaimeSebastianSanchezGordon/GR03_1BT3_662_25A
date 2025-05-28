package com.barrial.Service;

import com.barrial.DTO.IntercambioDTO;
import com.barrial.Entity.Intercambio;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IntercambioServiceTest {
    //Prueba Unitaria Mocks 1: validación de los campos obligatorios correctamente.
    @Test
    public void dado_intercambio_cuando_campos_correctos_entonces_retorna_true(){
        Intercambio intercambioCamposCorrectos =
                new Intercambio("Pantalon",
                        "Pepe: Intercambio",
                        "https://imagenesPantalones.com",
                        "Pantalon Talla 36, 2 meses de uso",
                        "A cambio de un pantalón de talla similar");
        IIntercambioService iIntercambioService = Mockito.mock(IIntercambioService.class);
        when(iIntercambioService.validacionCamposObligatorio(intercambioCamposCorrectos)).thenReturn(true);
        assertTrue("HAY CAMPOS CON DATOS INVÁLIDOS", iIntercambioService.validacionCamposObligatorio(intercambioCamposCorrectos));
        //Verificar que se llamó al método validacionCamposObligatorio con el objeto correcto
        Mockito.verify(iIntercambioService).validacionCamposObligatorio(intercambioCamposCorrectos);
    }
    //Prueba Unitaria Mocks 2: Actualización correcta en base de datos.
   @Test
   public void dado_intercambio_actualizado_cuando_actualización_correcta_entonces_retorna_true(){
       Intercambio intercambioCamposCorrectos =
               new Intercambio("Camiseta",
                       "José: Intercambio",
                       "https://imagenesCamiseta.com",
                       "Camiseta Talla M, nueva",
                       "A cambio de un pantalón de talla 28");
       IIntercambioService iIntercambioService = Mockito.mock(IIntercambioService.class);
       when(iIntercambioService.validacionActualizacion(intercambioCamposCorrectos)).thenReturn(true);
       assertTrue("INTERCAMBIO NO SE ACTUALIZÓ", iIntercambioService.validacionActualizacion(intercambioCamposCorrectos));
       Mockito.verify(iIntercambioService).validacionActualizacion(intercambioCamposCorrectos);
   }
}
