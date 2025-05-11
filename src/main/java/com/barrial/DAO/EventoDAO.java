package com.barrial.DAO;

import com.barrial.Entity.Emprendimiento;
import com.barrial.Entity.Evento;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EventoDAO {
    public static List<Evento> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Evento", Evento.class).list();
    }

    public static void guardarEnBase(Evento evento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(evento);
        transaction.commit();
        session.close();
    }

    public static void eliminarEvento(Evento evento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(evento);
        transaction.commit();
        session.close();
    }

    public static void editarEvento(Evento evento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(evento);
        transaction.commit();
        session.close();
    }
}
