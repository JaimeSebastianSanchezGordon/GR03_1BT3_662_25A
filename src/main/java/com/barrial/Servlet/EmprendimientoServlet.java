package com.barrial.Servlet;

import com.barrial.Emprendimiento;
import com.barrial.Hibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarEmprendimientos")
public class EmprendimientoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Emprendimiento e = new Emprendimiento();

        List<Emprendimiento> emprendimientos = Hibernate.obtenerDatos(e);

        for (Emprendimiento emprendimiento : emprendimientos) {
            System.out.println(emprendimiento);
        }

        request.setAttribute("emprendimientos", emprendimientos);
        request.getRequestDispatcher("jsp/emprendimientos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        Emprendimiento e = new Emprendimiento();
        e.setNombre(nombre);
        e.setDescripcion(descripcion);

        Hibernate.guardarEnBaseDeDatos(e);

        System.out.println("GUARDADO EN BASE DE DATOS");

        response.sendRedirect("mostrarEmprendimientos");

    }

}
