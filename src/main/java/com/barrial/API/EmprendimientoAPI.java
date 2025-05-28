package com.barrial.API;

import com.barrial.DTO.EmprendimientoDTO;
import com.barrial.Service.EmprendimientoService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/api/emprendimientos")
public class EmprendimientoAPI extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener todos los emprendimientos
        List<EmprendimientoDTO> lista = EmprendimientoService.obtenerDatos();

        String json = gson.toJson(lista);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
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
        // Editar un emprendimiento (requiere que el JSON tenga el ID)
        EmprendimientoDTO editado = gson.fromJson(request.getReader(), EmprendimientoDTO.class);
        EmprendimientoService.editarEmprendimiento(
                editado.getId(),
                editado.getNombre(),
                editado.getDescripcion(),
                editado.getImagen()
        );

        response.getWriter().write("{\"mensaje\": \"Emprendimiento editado\"}");
    }


    private void eliminarEmprendimiento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Eliminar usando un parámetro ?id=3
        int idEmprendimiento = Integer.parseInt(request.getParameter("id"));
        EmprendimientoService.eliminarEmprendimiento(idEmprendimiento);

        response.sendRedirect("mostrarEmprendimientos");
    }

    private void crearEmprendimiento (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Crear nuevo emprendimiento desde JSON enviado
        EmprendimientoDTO emprendimientoDTO = gson.fromJson(request.getReader(), EmprendimientoDTO.class);
        EmprendimientoService.guardarEnBase(emprendimientoDTO);

        response.sendRedirect("mostrarEmprendimientos");
    }
}