package com.barrial.DAO;

import com.barrial.Entity.Recurso;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RecursoDAO {
    public static List<Recurso> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Recurso", Recurso.class).list();
    }

    public static void guardarEnBase(Recurso recurso) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(recurso);
        transaction.commit();
        session.close();

    }


    public static void eliminarRecurso(Recurso recurso) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(recurso);
        transaction.commit();
        session.close();

    }

    public static void editarRecurso(Recurso recurso) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(recurso);
        transaction.commit();
        session.close();
    }
}
