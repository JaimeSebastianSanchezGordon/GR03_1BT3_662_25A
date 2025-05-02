package com.barrial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Hibernate {
    public static <T> void guardarEnBaseDeDatos(T clase) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(clase.getClass())
                .configure()
                .buildSessionFactory();

        Session sesion = sessionFactory.openSession();

        Transaction transaction = sesion.beginTransaction();

        sesion.persist(clase);

        transaction.commit();
        sesion.close();
        sessionFactory.close();
    }

    public static <T> List<T> obtenerDatos(T clase) {

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(clase.getClass())
                .configure()
                .buildSessionFactory();

        Session sesion = sessionFactory.openSession();

        List<T> lista = (List<T>) sesion.createQuery("from "+clase.getClass().getName(), clase.getClass()).list();

        sesion.close();
        sessionFactory.close();

        return lista;
    }


}

