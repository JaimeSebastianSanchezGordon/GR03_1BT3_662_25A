package com.barrial.DAO;

import com.barrial.Entity.Evento;
import com.barrial.Entity.Problema;
import com.barrial.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;

public class ProblemaDAO {
    public boolean existsByNombre(String nombre) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(p) FROM Problema p WHERE p.nombre = :nombre", Long.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            return count > 0;
        }
    }
    public static List<Problema> obtenerDatos() {
        Session session = Hibernate.getSessionFactory().openSession();
        return session.createQuery("from Problema ", Problema.class).list();
    }

    private void ejecutarTransaccion(Consumer<Session> operacion) {
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            operacion.accept(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void guardarEnBase(Problema problema) {
        ejecutarTransaccion(session -> session.persist(problema));
    }

    public static void eliminarSeguridad(Problema problema) {
        new ProblemaDAO().ejecutarTransaccion(session -> session.remove(problema)); // si eliminar es static, se necesita crear instancia
    }

    public void editarSeguridad(Problema problema) {
        ejecutarTransaccion(session -> session.merge(problema));
    }



}