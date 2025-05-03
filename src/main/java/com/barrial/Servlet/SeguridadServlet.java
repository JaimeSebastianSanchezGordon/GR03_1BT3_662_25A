package com.barrial.Servlet;

import com.barrial.Hibernate;
import com.barrial.Seguridad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarSeguridad")
public class SeguridadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Seguridad seguridad = new Seguridad();

        List<Seguridad> seguridades = Hibernate.obtenerDatos(seguridad);

        request.setAttribute("seguridades", seguridades);
        request.getRequestDispatcher("jsp/seguridad.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Seguridad seguridad = new Seguridad();

        seguridad.setNombre(nombre);
        seguridad.setDescripcion(descripcion);

        Hibernate.guardarEnBaseDeDatos(seguridad);

        response.sendRedirect("mostrarSeguridad");
    }
}
