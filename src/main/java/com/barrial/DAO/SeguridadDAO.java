package com.barrial.DAO;

import com.barrial.Entity.Seguridad;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SeguridadDAO {
    public static List<Seguridad> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Seguridad ", Seguridad.class).list();
    }

    public static void guardarEnBase(Seguridad seguridad) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(seguridad);
        transaction.commit();
        session.close();
    }

    public static void eliminarSeguridad(Seguridad seguridad) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(seguridad);
        transaction.commit();
        session.close();
    }
}