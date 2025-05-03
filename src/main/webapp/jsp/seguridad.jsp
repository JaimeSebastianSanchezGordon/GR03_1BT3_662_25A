<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="seguridadContent">
    <div class="encabezadoEmprendimiento">
        <h2>SEGURIDAD</h2>
        <button type="submit" class="botonRegistroSeguridad">Agregar seguridad</button>
    </div>

    <div class="seguridades">
        <%
            for (int i = 0; i < 3; i++) {
        %>
        <div class="seguridad">
            <div class="imagenSeguridad">
                <h3>IMAGEN</h3>
            </div>
            <div class="contenidoSeguridad">
                <div class="tituloSeguridad">
                    <h3>TITULO</h3>
                </div>
                <div class="contenidoSeguridad">
                    <p>CONTEXTO</p>
                </div>
                <div>
                    <button class="botonVotarSeguridad">VOTAR</button>
                </div>
            </div>
            <div class="votosSeguridad">
                <div>
                    <h3>Numero de votaciones:</h3>
                </div>
                <div>
                    <h1>10</h1>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>

    <div class="registroSeguridad" id="registroSeguridad">
        <div class="tituloRegistro">
            <h3>Registrar seguridad</h3>
        </div>
        <div class="datosRegistro">
            <form action="" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit">Registrar seguridad</button>
            </form>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Seguridad"/>
    <jsp:param name="contentPage" value="${seguridadContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/seguridad.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/emprendimientos.css"/>
</jsp:include>
