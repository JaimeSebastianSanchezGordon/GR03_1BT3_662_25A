package com.barrial.Servlet;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.Entity.Emprendimiento;
import com.barrial.Service.EmprendimientoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/mostrarEmprendimientos")
public class EmprendimientoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<EmprendimientoDTO> emprendimientosDTO = EmprendimientoService.obtenerDatos();

        for (EmprendimientoDTO emprendimiento : emprendimientosDTO){
            System.out.println(emprendimiento);
        }
        request.setAttribute("emprendimientos", emprendimientosDTO);
        request.getRequestDispatcher("jsp/emprendimientos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO(nombre, descripcion);

        EmprendimientoService.guardarEnBase(emprendimientoDTO);

        response.sendRedirect("mostrarEmprendimientos");

    }

}
