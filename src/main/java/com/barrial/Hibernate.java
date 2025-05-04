package com.barrial;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

//public static <T> void guardarEnBaseDeDatos(T clase) {
//
//    SessionFactory sessionFactory = new Configuration()
//            .configure()
//            .buildSessionFactory();
//
//    Session sesion = sessionFactory.openSession();
//
//    Transaction transaction = sesion.beginTransaction();
//
//    sesion.persist(clase);
//
//    transaction.commit();
//    sesion.close();
//    sessionFactory.close();
//}
//
//public static <T> List<T> obtenerDatos(T clase) {
//
//    SessionFactory sessionFactory = new Configuration()
//            .configure()
//            .buildSessionFactory();
//
//    Session sesion = sessionFactory.openSession();
//
//    List<T> lista = (List<T>) sesion.createQuery("from "+clase.getClass().getName(), clase.getClass()).list();
//
//    sesion.close();
//    sessionFactory.close();
//
//    return lista;
//}
