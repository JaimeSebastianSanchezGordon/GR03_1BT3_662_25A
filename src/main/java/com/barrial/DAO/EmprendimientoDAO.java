package com.barrial.DAO;

import com.barrial.Entity.Emprendimiento;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmprendimientoDAO {
    public static List<Emprendimiento> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Emprendimiento", Emprendimiento.class).list();
    }

    public static void guardarEnBase(Emprendimiento emprendimiento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(emprendimiento);
        transaction.commit();
        session.close();
    }

    public static void eliminarEmprendimiento(Emprendimiento emprendimiento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(emprendimiento);
        transaction.commit();
        session.close();
    }

    public static void editarEmprendimiento(Emprendimiento emprendimiento) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(emprendimiento);
        transaction.commit();
        session.close();
    }
}
