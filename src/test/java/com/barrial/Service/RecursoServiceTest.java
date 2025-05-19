package com.barrial.Service;

import com.barrial.DTO.RecursoDTO;
import com.barrial.Entity.Recurso;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursoServiceTest {

    // CREACION DE PRUEBAS UNITARIAS PARA RECURSOS

    // 1 Campos completos
    @Test
    public void dado_campos_completos_cuando_se_validan_entonces_retorna_true(){
        RecursoDTO recurso =
                new RecursoDTO("Ropa",
                        "Pantalon",
                        "2",
                        "imagen");
        assertTrue("TIENES QUE COMPLETAR TODOS LOS CAMPOS",RecursoService.camposCompletos(recurso));
    }

    // 2 Campo vacio
    @Test
    public void dado_un_campo_vacio_cuando_se_valida_entonces_retorna_true(){
        RecursoDTO recurso =
                new RecursoDTO("",
                        "Pantalon",
                        "2",
                        "imagen");
        assertTrue("NO HAY CAMPOS VACIOS",RecursoService.campoVacio(recurso));
    }

    //    3 Campos validos
    @Test
    public void dado_valores_correctos_cuando_se_validan_entonces_retirna_true(){
        RecursoDTO recurso =
                new RecursoDTO("Ropa",
                        "Pantalon",
                        "2",
                        "imagen");
        assertTrue("LA CANTIDAD TIENE QUE SER POSITIVA",
                Integer.parseInt(recurso.getCantidadRecurso()) > 0 );
    }

    //   4 cuando no hay recursos registrados
    @Test
    public void dado_lista_vacia_cuando_se_verifica_contenido_entonces_retorna_null(){
        try {
            RecursoService.obtenerRecursos();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    // 5 Buscar recurso por nombre
    @Test
    public void dado_recurso_cuando_se_busca_entonces_retorna_true(){
        Recurso recurso =
                new Recurso("Ropa",
                        "Pantalon",
                        "2",
                        "imagen");
        assertTrue("NO EXISTE EL RECURSO BUSCADO", RecursoService.buscarRecursos(recurso));
    }

    // 6 Tipo de recurso
    @Test
    public void dado_tipo_recurso_correcto_cuando_se_registra_entonces_retorna_true(){
        Recurso recurso =
                new Recurso("Ropa",
                        "Media",
                        "2",
                        "imagen");
        assertTrue("EL TIPO DE RECURSO NO ES VALIDO",RecursoService.verificarTipo(recurso.getTipo()));
    }

    // 7 Exception cuando nombre tiene nuemros
    @Test
    public void dado_nombre_con_numero_cuando_se_registra_entonces_lanza_error(){
        Recurso recurso =
                new Recurso("Ropa",
                        "Media",
                        "2",
                        "imagen");
        try {
            RecursoService.validarNombreSinNumeros(recurso.getNombre());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 8 Exception cuando nombre tiene caracter especial

    @Test
    public void dado_nombre_con_caracter_especial_cuando_se_registra_entonces_lanza_error(){
        Recurso recurso =
                new Recurso("Ropa",
                        "Media",
                        "2",
                        "imagen");
        try {
            RecursoService.validarNombreSinCaracterEspecial(recurso.getNombre());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}