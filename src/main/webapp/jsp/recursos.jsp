<%@ page import="java.util.List" %>
<%@ page import="com.barrial.DTO.RecursoDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="recursoContent">
    <div class="encabezadoEmprendimiento">
        <h2>RECURSOS</h2>
        <button type="submit" class="botonRegistroRecurso">Agregar recurso</button>
    </div>

    <div class="recursos">
        <%
            List<RecursoDTO> recursosDTO = (List<RecursoDTO>) request.getAttribute("recursos");
            if (recursosDTO != null && !recursosDTO.isEmpty()){
                for (RecursoDTO recursoDTO: recursosDTO){
        %>
        <div class="recurso">
            <div class="tipoRecurso">
                <h3><%=recursoDTO.getTipoRecurso()%></h3>
            </div>
            <div class="ejemploRecurso">
                <h3><%=recursoDTO.getNombreRecurso()%></h3>
            </div>
            <div class="cantidadRecurso">
                <div>
                    <h3>Cantidad:</h3>
                </div>
                <div>
                    <h3><%=recursoDTO.getCantidadRecurso()%></h3>
                </div>
            </div>
            <div class="imagenRecurso">
                <img width="100%" src="<%=recursoDTO.getImagen()%>" alt="ERROR AL CARGAR LA IMAGEN">
            </div>
            <div class="botonesRecurso">
                <div>
                    <button class="btnEditarRecurso"
                            data-id="<%=recursoDTO.getId()%>"
                            data-tipoRecurso="<%=recursoDTO.getTipoRecurso()%>"
                            data-nombreRecurso="<%=recursoDTO.getNombreRecurso()%>"
                            data-cantidadRecurso="<%=recursoDTO.getCantidadRecurso()%>"
                            data-imagen="<%=recursoDTO.getImagen()%>"> EDITAR</button>
                </div>
                <div>
                    <form action="mostrarRecursos" method="POST">
                        <input type="hidden" name="id" value="<%=recursoDTO.getId()%>">
                        <button name="accion" value="eliminar"> ELIMINAR</button>
                    </form>
                </div>
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

    <%--    MODAL PARA REGISTRO--%>
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
                <input type="number" name="cantidadRecurso" step="1" min="1" required><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit" name="accion" value="crear">Registrar recurso</button>
            </form>
        </div>
    </div>

    <%--    MODAL PARA EDITAR--%>
    <div class="editarRecurso" id="modalEditarRecurso">
        <div class="tituloRegistro">
            <h3>Editar recurso</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarRecursos" method="POST">
                <input type="hidden" name="id" id="id">
                Tipo recurso: <br>
                <input type="text" name="tipoRecurso" id="tipoRecurso"><br>
                Nombre recurso: <br>
                <input type="text" name="nombreRecurso" id="nombreRecurso"><br>
                Cantidad recurso: <br>
                <input type="number" name="cantidadRecurso" id="cantidadRecurso" step="1" min="1" required><br>
                Imagen:<br>
                <input type="text" name="imagen" id="imagen"><br>
                <button type="submit" name="accion" value="editar" >Actualizar recurso</button>
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