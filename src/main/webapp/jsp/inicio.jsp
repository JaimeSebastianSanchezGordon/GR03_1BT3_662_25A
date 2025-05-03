<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setContentType("text/html;charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="inicioContent">
    <div class="seccion-bienvenida">
        <h1 class="titulo-bienvenida">Bienvenido a MiBarrioApp</h1>
        <p class="subtitulo-bienvenida">Tu plataforma de comunicación y organización vecinal</p>

        <div class="mensaje-bienvenida">
            <p>Conéctate con tus vecinos, organiza eventos, reporta problemas y mejora juntos tu comunidad.</p>
            <p>Selecciona una de las opciones del menú para comenzar a explorar todas las funcionalidades que tenemos para ti.</p>
        </div>

        <div class="grid-caracteristicas">
            <div class="tarjeta-caracteristica">
                <div class="icono-caracteristica">🏪</div>
                <h3>Emprendimientos Locales</h3>
                <p>Promueve tu negocio y descubre los productos y servicios que ofrecen tus vecinos.</p>
            </div>
            <div class="tarjeta-caracteristica">
                <div class="icono-caracteristica">🎉</div>
                <h3>Eventos</h3>
                <p>Organiza y participa en actividades comunitarias.</p>
            </div>
            <div class="tarjeta-caracteristica">
                <div class="icono-caracteristica">🤝</div>
                <h3>Recursos</h3>
                <p>Coordina la recolección de recursos para proyectos barriales.</p>
            </div>
            <div class="tarjeta-caracteristica">
                <div class="icono-caracteristica">🛡️</div>
                <h3>Seguridad</h3>
                <p>Reporta y recibe alertas sobre situaciones de seguridad.</p>
            </div>
        </div>
    </div>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp - Inicio"/>
    <jsp:param name="contentPage" value="${inicioContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/inicioJs.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleInicio.css"/>
</jsp:include>