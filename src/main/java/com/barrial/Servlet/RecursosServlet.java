package com.barrial.Servlet;

import com.barrial.Hibernate;
import com.barrial.Recurso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarRecursos")
public class RecursosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Recurso r = new Recurso();

        List<Recurso> recursos = Hibernate.obtenerDatos(r);

        for (Recurso recurso : recursos) {
            System.out.println(recurso);
        }

        request.setAttribute("recursos", recursos);
        request.getRequestDispatcher("jsp/recursos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombreRecurso");
        String tipoRecurso = request.getParameter("tipoRecurso");
        int cantidadRecursos = Integer.parseInt(request.getParameter("cantidadRecurso"));

        Recurso recurso = new Recurso();

        recurso.setNombre(nombre);
        recurso.setTipo(tipoRecurso);
        recurso.setCantidad(cantidadRecursos);

        Hibernate.guardarEnBaseDeDatos(recurso);

        response.sendRedirect("mostrarRecursos");
    }
}
