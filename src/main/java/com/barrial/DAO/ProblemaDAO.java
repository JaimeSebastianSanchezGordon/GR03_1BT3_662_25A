package com.barrial.DAO;

import com.barrial.Entity.Evento;
import com.barrial.Entity.Problema;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProblemaDAO {
    public static List<Problema> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Problema ", Problema.class).list();
    }

    public static void guardarEnBase(Problema problema) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(problema);
        transaction.commit();
        session.close();
    }

    public static void eliminarSeguridad(Problema problema) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(problema);
        transaction.commit();
        session.close();
    }

    public void editarSeguridad(Problema problema) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(problema);
        transaction.commit();
        session.close();
    }
}