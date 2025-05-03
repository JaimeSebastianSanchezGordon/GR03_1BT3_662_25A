package com.barrial;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Evento evento = new Evento();

//        evento.setNombre("Mario");
//        evento.setDescripcion("Mario");
//        evento.setFecha("new Date()");
//        evento.setHora("23:59:59");

//        Hibernate.guardarEnBaseDeDatos(evento);

        List<Evento> listas = Hibernate.obtenerDatos(evento);
        for (Evento evento1 : listas) {
            System.out.println(evento1);
        }
    }
}
