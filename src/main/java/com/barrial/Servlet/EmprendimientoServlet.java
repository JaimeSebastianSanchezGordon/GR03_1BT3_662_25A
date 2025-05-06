package com.barrial.Servlet;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.Service.EmprendimientoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mostrarEmprendimientos")
public class EmprendimientoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("emprendimientos", EmprendimientoService.obtenerDatos());
        request.getRequestDispatcher("jsp/emprendimientos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion){
            case "crear":
                crearEmprendimiento(request, response);
                break;
            case "eliminar":
                eliminarEmprendimiento(request, response);
                break;
            case "editar":
                editarEmprendimiento(request, response);
                break;
        }

    }

    private void editarEmprendimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmprendimiento = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        System.out.println("EL ID DEL EMPRENDIMIETNO ES: " + idEmprendimiento);

        EmprendimientoService.editarEmprendimiento(idEmprendimiento, nombre, descripcion, imagen);

        response.sendRedirect("mostrarEmprendimientos");
    }

    private void eliminarEmprendimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmprendimiento = Integer.parseInt(request.getParameter("id"));

        EmprendimientoService.eliminarEmprendimiento(idEmprendimiento);

        response.sendRedirect("mostrarEmprendimientos");
    }

    private void crearEmprendimiento (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmprendimientoDTO emprendimientoDTO =
                new EmprendimientoDTO(
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        request.getParameter("imagen"));

        EmprendimientoService.guardarEnBase(emprendimientoDTO);

        response.sendRedirect("mostrarEmprendimientos");
    }

}
