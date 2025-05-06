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
        }

    }

    private void eliminarEmprendimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmprendimiento = Integer.parseInt(request.getParameter("id"));
        System.out.println("SE VA A ELIMINAR EL EMPRENDIMIENTO CON ID: " + idEmprendimiento);

        EmprendimientoService.eliminarEmprendimiento(idEmprendimiento);

        response.sendRedirect("mostrarEmprendimientos");
    }

    private void crearEmprendimiento (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SE VA REGSITRAR UN NUEVO EMPRENDIMIENTO");
        System.out.println(request.getParameter("imagen"));

        EmprendimientoDTO emprendimientoDTO =
                new EmprendimientoDTO(
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        request.getParameter("imagen"));


        EmprendimientoService.guardarEnBase(emprendimientoDTO);

        response.sendRedirect("mostrarEmprendimientos");
    }

}
