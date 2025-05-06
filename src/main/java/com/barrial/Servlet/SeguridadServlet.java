package com.barrial.Servlet;

import com.barrial.DTO.SeguridadDTO;
import com.barrial.Service.SeguridadService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mostrarSeguridad")
public class SeguridadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("seguridades", SeguridadService.obtenerDatos());
        request.getRequestDispatcher("jsp/seguridad.jsp").forward(request, response);
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

        int idSeguridad = Integer.parseInt(request.getParameter("id"));
        System.out.println("SE VA A ELIMINAR LA SUGERENCIA DE SEGURIDAD CON ID: " + idSeguridad);

        SeguridadService.eliminarSeguridad(idSeguridad);

        response.sendRedirect("mostrarSeguridad");
    }

    private void crearSeguridad(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("SE VA A REGISTRAR UNA NUEVA SUGERENCIA DE SEGURIDAD");

        SeguridadDTO seguridadDTO = new SeguridadDTO(
                request.getParameter("nombre"),
                request.getParameter("descripcion"),
                0,  // numVotos por defecto
                request.getParameter("imagen")
        );

        SeguridadService.guardarEnBase(seguridadDTO);

        response.sendRedirect("mostrarSeguridad");
    }
}
