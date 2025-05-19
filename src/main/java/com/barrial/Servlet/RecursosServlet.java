package com.barrial.Servlet;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.DTO.RecursoDTO;
import com.barrial.Service.EmprendimientoService;
import com.barrial.Service.RecursoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mostrarRecursos")
public class RecursosServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String busqueda = request.getParameter("buscar");
        System.out.println("TIPO A BUSCAR"+busqueda);
        List<RecursoDTO> recursosDTO = new ArrayList<RecursoDTO>();
        if (busqueda != null && !busqueda.trim().isEmpty()) {
            for (RecursoDTO recursoDTO : RecursoService.obtenerDatos()) {
                if(recursoDTO.getTipoRecurso().equals(busqueda)) {
                    recursosDTO.add(recursoDTO);
                }
            }
        } else {
            recursosDTO = RecursoService.obtenerDatos();
        }

        for (RecursoDTO recursoDTO : recursosDTO) {
            System.out.println(recursoDTO);
        }

        request.setAttribute("recursos", recursosDTO);
        request.getRequestDispatcher("jsp/recursos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion){
            case "crear":
                crearRecurso(request, response);
                break;
            case "eliminar":
                eliminarRecurso(request, response);
                break;
            case "editar":
                editarRecurso(request, response);
                break;
        }

    }

    private void crearRecurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RecursoDTO recursoDTO = new RecursoDTO(
                request.getParameter("tipoRecurso"),
                request.getParameter("nombreRecurso"),
                request.getParameter("cantidadRecurso"),
                request.getParameter("imagen"));

        RecursoService.guardarEnBase(recursoDTO);
        response.sendRedirect("mostrarRecursos");
    }

    private void eliminarRecurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRecurso = Integer.parseInt(request.getParameter("id"));
        System.out.println("EL ID DEL RECURSO A ELIMINAR ES: " + idRecurso);
        RecursoService.eliminarRecurso(idRecurso);
        response.sendRedirect("mostrarRecursos");
    }

    private void editarRecurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRecurso = Integer.parseInt(request.getParameter("id"));
        String tipoRecurso = request.getParameter("tipoRecurso");
        String nombreRecurso = request.getParameter("nombreRecurso");
        String cantidadRecurso = request.getParameter("cantidadRecurso");
        String imagen = request.getParameter("imagen");

        System.out.println("EL ID DEL RECURSO ES: " + idRecurso);

        RecursoService.editarRecurso(idRecurso, tipoRecurso, nombreRecurso, cantidadRecurso, imagen);
        response.sendRedirect("mostrarRecursos");
    }
}