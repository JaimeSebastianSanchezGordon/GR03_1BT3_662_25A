<%@ page import="java.util.List" %>
<%@ page import="com.barrial.Entity.Evento" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.barrial.DTO.EventoDTO" %>

<c:set var="eventoContent">
    <div class="encabezadoEvento">
        <h2>EVENTOS</h2>
        <button type="submit" class="botonRegistroEvento">Agregar evento</button>
    </div>

    <div class="eventos">
        <%
            List<EventoDTO> eventosDTO = (List<EventoDTO>) request.getAttribute("eventos");
            if (eventosDTO != null && !eventosDTO.isEmpty()){
                for (EventoDTO evento: eventosDTO) {
        %>
        <div class="evento">
            <div class="nombreEvento">
                <h3><%=evento.getNombre()%></h3>
            </div>
            <div class="contenidoEvento">
                <p><%=evento.getDescripcion()%></p>
            </div>
            <div class="fechaEvento">
                <p><%=evento.getFecha()%></p>
            </div>
            <div class="horaEvento">
                <p><%=evento.getHora()%></p>
            </div>
            <div class="imagen">
                <img width="100%" src="<%=evento.getImagen()%>" alt="ERROR AL CARGAR LA IMAGEN">
            </div>
            <div class="botonesEvento">
                <div>
                    <button class="btnEditarEvento"
                                data-id="<%=evento.getId()%>"
                                data-nombre="<%=evento.getNombre()%>"
                                data-descripcion="<%=evento.getDescripcion()%>"
                                data-fecha="<%=evento.getFecha()%>"
                                data-hora="<%=evento.getHora()%>"
                                data-imagen="<%=evento.getImagen()%>"> EDITAR</button>
                </div>
                <div>
                    <form action="mostrarEventos" method="POST">
                        <input type="hidden" name="id" value="<%=evento.getId()%>">
                        <button name="accion" value="eliminar"> ELIMINAR</button>
                    </form>
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
                <button type="submit" name="accion" value="crear" >Registrar evento</button>
            </form>
        </div>
    </div>

    <div class="editarEvento" id="modalEditarEvento">
        <div class="tituloRegistro">
            <h3>Editar evento</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarEventos" method="POST">
                <input type="hidden" name="id" id="id">
                Nombre: <br>
                <input type="text" name="nombre" id="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion" id="descripcion"><br>
                Fecha: <br>
                <input type="text" name="fecha" id="fecha"><br>
                Hora: <br>
                <input type="text" name="hora" id="hora"><br>
                Imagen:<br>
                <input type="text" name="imagen" id="imagen"><br>
                <button type="submit" name="accion" value="editar" >Editar evento</button>
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