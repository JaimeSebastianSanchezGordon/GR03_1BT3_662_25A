<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="recursoContent">
    <div class="encabezadoEmprendimiento">
        <h2>RECURSOS</h2>
        <button type="submit" class="botonRegistroRecurso">Agregar seguridad</button>
    </div>

    <div class="recursos">
        <%
            for (int i = 0; i < 4; i++) {
        %>
        <div class="recurso">
            <div class="tipoRecurso">
                <h3>ROPA</h3>
            </div>
            <div class="ejemploRecurso">
                <h3>PANTALON</h3>
            </div>
            <div class="cantidadRecurso">
                <div>
                    <h3>Cantidad</h3>
                </div>
                <div>
                    <h3>2</h3>
                </div>
            </div>
            <div class="imagenRecurso">
                <h2>IMAGEN</h2>
            </div>
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
            <form action="" method="POST">
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
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/recursos.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/emprendimientos.css"/>
</jsp:include>