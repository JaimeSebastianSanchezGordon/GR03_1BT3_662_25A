<%@ page import="java.util.List" %>
<%@ page import="com.barrial.Entity.Problema" %>
<%@ page import="com.barrial.DTO.ProblemaDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setContentType("text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>

<c:set var="seguridadContent">
    <div class="encabezadoEmprendimiento">
        <h2>PROBLEMAS</h2>
        <button type="submit" class="botonRegistroProblema">Agregar problema</button>
    </div>

    <div class="seguridades">
        <%
            List<ProblemaDTO> problemasDTO = (List<ProblemaDTO>) request.getAttribute("problemas");
            if (problemasDTO != null && !problemasDTO.isEmpty()){
                for (ProblemaDTO problema: problemasDTO) {
        %>
        <div class="problema">
            <div class="imagenProblema">
                <img width="100%" src="<%=problema.getImagen()%>" alt="Imagen de problema">
            </div>
            <div class="contenidoProblema">
                <div class="tituloProblema">
                    <h3><%=problema.getNombre()%></h3>
                </div>
                <div class="contenidoProblema">
                    <p><%=problema.getDescripcion()%></p>
                </div>
                <div>
                    <form action="mostrarProblema" method="POST">
                        <input type="hidden" name="id" value="<%=problema.getId()%>">
                        <button name="accion" value="votar" class="botonVotarProblema">VOTAR</button>
                    </form>
                </div>
                <div>
                    <form action="mostrarProblema" method="POST">
                        <input type="hidden" name="id" value="<%=problema.getId()%>">
                        <button name="accion" value="editar" class="botonVotarProblema"> EDITAR</button>
                        <input type="hidden" name="id" value="<%=problema.getId()%>">
                        <button name="accion" value="eliminar" class="botonVotarProblema">ELIMINAR</button>
                    </form>
                </div>
            </div>
            <div class="votosProblema">
                <div>
                    <h3>Número de votaciones:</h3>
                </div>
                <div>
                    <h1><%=problema.getNumVotos()%></h1>
                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <div class="noHayProblema">
            <h2>NO HAY SEGURIDADES</h2>
        </div>
        <%
            }
        %>
    </div>

    <div class="registroProblema" id="registroProblema">
        <div class="tipoProblema">
            <div class="tituloRegistro">
                <h3>Registrar problema</h3>
            </div>
        </div>
        <div class="datosRegistro">
            <form action="mostrarProblema" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripción: <br>
                <input type="text" name="descripcion"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit" name="accion" value="crear">Registrar problema</button>
            </form>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Problema"/>
    <jsp:param name="contentPage" value="${seguridadContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/problemaJs.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleProblema.css"/>
</jsp:include>
