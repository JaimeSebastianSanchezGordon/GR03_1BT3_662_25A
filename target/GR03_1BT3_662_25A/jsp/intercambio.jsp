<%@ page import="java.util.List" %>
<%@ page import="com.barrial.DTO.IntercambioDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.barrial.DTO.IntercambioDTO" %>
<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="intercambioContent">
    <div class="encabezadoIntercambio">
        <h2>INTERCAMBIO</h2>
        <button type="submit" class="botonRegistroIntercambio">Agregar intercambio</button>
    </div>

    <div class="contenidoIntercambios">
        <div class="trueque">
            <div class="tituloCategoria">
                <h2>INTERCAMBIO</h2>
            </div>
            <div class="objetoADar">
                <h3>OBJETO A DAR</h3>
                <p>DESCRIPCION:</p>
                <img src="" alt="ESTA ES LA IMAGEN">
            </div>
            <div class="objetoARecivir">
                <h3>OBJETO A RECIBIR: </h3>
                <h3>DESCRIPCION:</h3>
                <p></p>
            </div>
        </div>
    </div>

    <%-- MODAL PARA REGISTRO--%>

</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Intercambio"/>
    <jsp:param name="contentPage" value="${intercambioContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/1.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleIntercambio.css"/>
</jsp:include>

