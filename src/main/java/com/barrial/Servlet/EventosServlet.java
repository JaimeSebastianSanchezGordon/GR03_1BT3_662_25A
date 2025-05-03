package com.barrial.Servlet;

import com.barrial.Evento;
import com.barrial.Hibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarEventos")
public class EventosServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Evento e = new Evento();

            List<Evento> eventos = Hibernate.obtenerDatos(e);

            for (Evento evento : eventos) {
                System.out.println(evento);
            }

            request.setAttribute("eventos", eventos);
            request.getRequestDispatcher("jsp/eventos.jsp").forward(request, response);

        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");

            Evento evento = new Evento();
            evento.setNombre(nombre);
            evento.setDescripcion(descripcion);
            evento.setFecha(fecha);
            evento.setHora(hora);

            Hibernate.guardarEnBaseDeDatos(evento);

            response.sendRedirect("mostrarEventos");



        }
}
