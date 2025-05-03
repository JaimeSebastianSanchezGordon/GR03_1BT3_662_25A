<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.barrial.Emprendimiento" %>
<%@ page import="java.util.List" %>

<c:set var="emprendimientoContent">
    <div class="encabezadoEmprendimiento">
        <h2>EMPRENDIMIENTOS</h2>
        <button type="submit" class="botonRegistroEmprendimiento">Agregar emprendimiento</button>
    </div>

    <div class="emprendimientos">
        <%
            List<Emprendimiento> emprendimientos = (List<Emprendimiento>) request.getAttribute("emprendimientos");
            if (emprendimientos!= null && !emprendimientos.isEmpty()) {
                for (Emprendimiento emprendimiento: emprendimientos) {
        %>
        <div class="emprendimiento">
            <div class="tituloEmprendimiento">
                <h3><%=emprendimiento.getNombre()%></h3>
            </div>
            <div class="contenidoEmprendimiento">
                <p><%=emprendimiento.getDescripcion()%></p>
            </div>
            <div>
                <h3>AQUI VA IMAGEN</h3>
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
                <button type="submit">Registrar emprendimiento</button>
            </form>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Emprendimiento"/>
    <jsp:param name="contentPage" value="${emprendimientoContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/emprendimiento.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/emprendimientos.css"/>
</jsp:include>


