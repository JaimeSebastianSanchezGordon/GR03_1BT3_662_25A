package com.barrial.Servlet;

import com.barrial.DTO.EventoDTO;
import com.barrial.Service.EventoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mostrarEventos")
public class EventosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("eventos", EventoService.obtenerDatos());
        request.getRequestDispatcher("jsp/eventos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion){
            case "crear":
                crearEvento(request, response);
                break;
            case "eliminar":
                eliminarEvento(request, response);
                break;
            case "editar":
                editarEvento(request, response);
                break;
        }

    }

    private void editarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEvento = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String imagen = request.getParameter("imagen");
        //System.out.println("EL ID DEL EVENTO ES: " + idEvento);

        EventoService.editarEvento(idEvento, nombre, descripcion, fecha, hora, imagen);

        response.sendRedirect("mostrarEventos");
    }

    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEvento = Integer.parseInt(request.getParameter("id"));

        EventoService.eliminarEvento(idEvento);

        response.sendRedirect("mostrarEventos");
    }

    private void crearEvento (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EventoDTO eventoDTO =
                new EventoDTO(
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        request.getParameter("fecha"),
                        request.getParameter("hora"),
                        request.getParameter("imagen"));

        EventoService.guardarEnBase(eventoDTO);

        response.sendRedirect("mostrarEventos");
    }

}
