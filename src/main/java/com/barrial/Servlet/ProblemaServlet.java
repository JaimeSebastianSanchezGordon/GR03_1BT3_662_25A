package com.barrial.Servlet;

import com.barrial.DTO.ProblemaDTO;
import com.barrial.Service.ProblemaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mostrarProblema")
public class ProblemaServlet extends HttpServlet {

    private ProblemaService problemaService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("problemas", ProblemaService.obtenerDatos());
        request.getRequestDispatcher("jsp/problema.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "crear":
                crearSeguridad(request, response);
                break;
            case "eliminar":
                eliminarSeguridad(request, response);
                break;
        }
    }

    private void eliminarSeguridad(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("SE VA A ELIMINAR LA SUGERENCIA DE SEGURIDAD CON ID: " +
                Integer.parseInt(request.getParameter("id")));
        ProblemaService.eliminarSeguridad(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("mostrarSeguridad");
    }

    private void crearSeguridad(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("SE VA A REGISTRAR UNA NUEVA SUGERENCIA DE SEGURIDAD");
        ProblemaDTO problemaDTO = new ProblemaDTO(
                request.getParameter("nombre"),
                request.getParameter("descripcion"),
                0,
                request.getParameter("imagen")
        );
        problemaService.guardarEnBase(problemaDTO);
        response.sendRedirect("mostrarProblema");
    }
}

