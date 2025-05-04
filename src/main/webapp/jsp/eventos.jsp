<%@ page import="java.util.List" %>
<%@ page import="com.barrial.Entity.Evento" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="eventoContent">
    <div class="encabezadoEmprendimiento">
        <h2>EVENTOS</h2>
        <button type="submit" class="botonRegistroEvento">Agregar evento</button>
    </div>
    <div class="eventos">
        <%
            List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
            if (eventos != null && !eventos.isEmpty()){
                for (Evento evento: eventos) {
        %>
        <div class="evento">
            <div class="nombreEvento">
                <h3><%=evento.getNombre()%></h3>
            </div>
            <div class="contenidoEvento">
                <div class="informacionEvento">
                    <div class="descipcionEvento">
                        <p><%=evento.getDescripcion()%></p>
                    </div>
                    <div class="fechaEvento">
                        <p><%=evento.getFecha()%></p>
                    </div>
                    <div class="horaEvento">
                        <p><%=evento.getHora()%></p>
                    </div>
                </div>
                <div class="imagen">
                    <h3>AQUI VA LA IMAGEN</h3>
                </div>
            </div>
        </div>
        <%
                }
        } else{
        %>
        <div class="noHayEventos">
            <h2> NO HAY EVENTOS </h2>
        </div>
        <%
            }
        %>
    </div>

    <div class="registroEvento" id="registroEvento">
        <div class="tituloRegistro">
            <h3>Registrar evento</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarEventos" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion"><br>
                Fecha: <br>
                <input type="text" name="fecha"><br>
                Hora: <br>
                <input type="text" name="hora"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit">Registrar evento</button>
            </form>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Evento"/>
    <jsp:param name="contentPage" value="${eventoContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/eventoJs.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleEvento.css"/>
</jsp:include>