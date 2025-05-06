<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.barrial.DTO.EmprendimientoDTO" %>

<c:set var="emprendimientoContent">
    <div class="encabezadoEmprendimiento">
        <h2>EMPRENDIMIENTOS</h2>
        <button type="submit" class="botonRegistroEmprendimiento">Agregar emprendimiento</button>
    </div>

    <div class="emprendimientos">
        <%
            List<EmprendimientoDTO> emprendimientosDTO = (List<EmprendimientoDTO>) request.getAttribute("emprendimientos");
            if (emprendimientosDTO!= null && !emprendimientosDTO.isEmpty()) {
                for (EmprendimientoDTO emprendimiento: emprendimientosDTO) {
        %>
        <div class="emprendimiento">
            <div class="tituloEmprendimiento">
                <h3><%=emprendimiento.getNombre()%></h3>
            </div>
            <div class="contenidoEmprendimiento">
                <p><%=emprendimiento.getDescripcion()%></p>
            </div>
            <div class="imagenEmprendimiento">
<%--                <img width="100%" src="https://www.produccion.gob.ec/wp-content/uploads/2020/04/IMG-20200402-WA0042.jpg" alt="ERROR AL CARGAR LA IMAGEN">--%>
                <img width="100%" src="<%=emprendimiento.getImagen()%>" alt="ERROR AL CARGAR LA IMAGEN">
            </div>
            <div>
                <form action="mostrarEmprendimientos" method="POST">
                    <input type="hidden" name="id" value="<%=emprendimiento.getId()%>">
                    <button name="accion" value="editar"> EDITAR</button>
                    <input type="hidden" name="id" value="<%=emprendimiento.getId()%>">
                    <button name="accion" value="eliminar"> ELIMINAR</button>
                </form>
            </div>
        </div>
        <%
            }
        } else{
        %>
        <div class="noEmprendimientos">
            <h2> NO HAY EMPRENDIMIENTOS </h2>
        </div>
        <%
            }
        %>
    </div>
<%--    MODAL PARA REGISTRO--%>
    <div class="registroEmprendimiento" id="registroEmprendimiento">
        <div class="tituloRegistro">
            <h3>Registrar emprendimiento</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarEmprendimientos" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit" name="accion" value="crear" >Registrar emprendimiento</button>
            </form>
        </div>
    </div>
<%--    MODAL PARA EDITAR--%>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Emprendimiento"/>
    <jsp:param name="contentPage" value="${emprendimientoContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/emprendimientoJs.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleEmprendimiento.css"/>
</jsp:include>


