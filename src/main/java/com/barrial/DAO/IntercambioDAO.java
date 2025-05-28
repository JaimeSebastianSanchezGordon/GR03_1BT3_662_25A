package com.barrial.DAO;

import com.barrial.Entity.Intercambio;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class IntercambioDAO {
    public static void guardarEnBase(Intercambio intercambio) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(intercambio);
        transaction.commit();
        session.close();
    }

    public static List<Intercambio> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Intercambio", Intercambio.class).list();
    }
}
