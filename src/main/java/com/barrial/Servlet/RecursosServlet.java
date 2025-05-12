//package com.barrial.Servlet;
//
//import com.barrial.DTO.RecursoDTO;
//import com.barrial.Service.EmprendimientoService;
//import com.barrial.Service.RecursoService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/mostrarRecursos")
//public class RecursosServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setAttribute("recursos", RecursoService.obtenerDatos());
//        request.getRequestDispatcher("jsp/recursos.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String accion = request.getParameter("accion");
//
//        switch (accion){
//            case "crear":
//                crearRecurso(request, response);
//                break;
//            case "eliminar":
//                eliminarRecurso(request, response);
//                break;
//            case "editar":
//                editarRecurso(request, response);
//                break;
//        }
//
//    }
//
//    private void crearRecurso(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RecursoDTO recursoDTO = new RecursoDTO(
//                request.getParameter("tipoRecurso"),
//                request.getParameter("nombreRecurso"),
//                Integer.parseInt(request.getParameter("cantidadRecurso")),
//                request.getParameter("imagen"));
//
//        RecursoService.guardarEnBase(recursoDTO);
//        response.sendRedirect("mostrarRecursos");
//    }
//
//    private void eliminarRecurso(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int idRecurso = Integer.parseInt(request.getParameter("id"));
//        System.out.println("EL ID DEL RECURSO A ELIMINAR ES: " + idRecurso);
//        RecursoService.eliminarRecurso(idRecurso);
//        response.sendRedirect("mostrarRecursos");
//    }
//
//    private void editarRecurso(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int idRecurso = Integer.parseInt(request.getParameter("id"));
//        String tipoRecurso = request.getParameter("tipoRecurso");
//        String nombreRecurso = request.getParameter("nombreRecurso");
//        int cantidadRecurso = Integer.parseInt(request.getParameter("cantidadRecurso"));
//        String imagen = request.getParameter("imagen");
//
//        System.out.println("EL ID DEL RECURSO ES: " + idRecurso);
//
//        RecursoService.editarRecurso(idRecurso, tipoRecurso, nombreRecurso, cantidadRecurso, imagen);
//        response.sendRedirect("mostrarRecursos");
//    }
//}