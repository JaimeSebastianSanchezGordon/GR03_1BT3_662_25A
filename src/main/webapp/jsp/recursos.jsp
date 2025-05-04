<%@ page import="java.util.List" %>
<%@ page import="com.barrial.Entity.Recurso" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="recursoContent">
    <div class="encabezadoEmprendimiento">
        <h2>RECURSOS</h2>
        <button type="submit" class="botonRegistroRecurso">Agregar recurso</button>
    </div>

    <div class="recursos">
        <%
            List<Recurso> recursos = (List<Recurso>) request.getAttribute("recursos");
            if (recursos != null && !recursos.isEmpty()){
                for (Recurso recurso: recursos){
        %>
        <div class="recurso">
            <div class="tipoRecurso">
                <h3><%=recurso.getTipo()%></h3>
            </div>
            <div class="ejemploRecurso">
                <h3><%=recurso.getNombre()%></h3>
            </div>
            <div class="cantidadRecurso">
                <div>
                    <h3>Cantidad:</h3>
                </div>
                <div>
                    <h3><%=recurso.getCantidad()%></h3>
                </div>
            </div>
            <div class="imagenRecurso">
                <h2>IMAGEN</h2>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <div class="noHayRecursos">
            <h2>NO HAY RECURSOS</h2>
        </div>
        <%
            }
        %>
    </div>

    <div class="emprendimientos">
    </div>

    <div class="registroRecurso" id="registroRecurso">
        <div class="tituloRegistro">
            <h3>Registrar recurso</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarRecursos" method="POST">
                Tipo recurso: <br>
                <input type="text" name="tipoRecurso"><br>
                Nombre recurso: <br>
                <input type="text" name="nombreRecurso"><br>
                Cantidad recurso: <br>
                <input type="text" name="cantidadRecurso"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit">Registrar recurso</button>
            </form>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Recurso"/>
    <jsp:param name="contentPage" value="${recursoContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/recursoJs.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleRecurso.css"/>
</jsp:include>