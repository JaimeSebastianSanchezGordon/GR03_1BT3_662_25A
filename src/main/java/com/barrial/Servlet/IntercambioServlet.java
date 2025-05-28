package com.barrial.Servlet;

import com.barrial.DTO.IntercambioDTO;
import com.barrial.Service.IntercambioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registroIntercambio")
public class IntercambioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String busqueda = request.getParameter("buscar");
        List<IntercambioDTO> intercambioDTOS = new ArrayList<IntercambioDTO>();
        if (busqueda != null && !busqueda.trim().isEmpty()) {
            for (IntercambioDTO intercambioDTO : IntercambioService.obtenerDatos()) {
                if(intercambioDTO.getObjetoTrueque().equals(busqueda)) {
                    intercambioDTOS.add(intercambioDTO);
                }
            }
        } else {
            intercambioDTOS = IntercambioService.obtenerDatos();
        }

        System.out.println("ESTOS SON TODOS LOS INTERCAMBIOS");
        for (IntercambioDTO intercambioDTO : intercambioDTOS) {
            System.out.println("IntercambioDTO: " + intercambioDTO);
        }

        request.setAttribute("intercambios", intercambioDTOS);
        request.getRequestDispatcher("jsp/intercambio.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        String objetoTrueque =request.getParameter("articulo");
        String descripcionArticulo = request.getParameter("descripcionArticulo");

        IntercambioDTO intercambioDTO =
                new IntercambioDTO(nombre, descripcion,
                        imagen, objetoTrueque, descripcionArticulo);

        System.out.println("REGISTRO DE INTERCAMBIO: " + intercambioDTO);

        IntercambioService.guardarEnBase(intercambioDTO);
        response.sendRedirect("registroIntercambio");
    }
}
