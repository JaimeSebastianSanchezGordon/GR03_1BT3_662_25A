<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="inicioContent">
    <h1>Pruebas</h1>
    <main class="pantallaEmprendimientos">
        <h1>Hola</h1>
    </main>
</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Inicio"/>
    <jsp:param name="contentPage" value="${inicioContent}"/>
</jsp:include>