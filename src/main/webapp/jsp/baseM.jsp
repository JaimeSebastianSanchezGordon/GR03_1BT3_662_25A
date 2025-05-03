<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv='X-UA-Compatible' content="IE=edge">

  <title><c:out value="${not empty param.title ? param.title : 'MiBarrioApp'}" /></title>


  <link href="${pageContext.request.contextPath}/css/styleBase.css" rel="stylesheet">
  <!-- Bloques para CSS adicionales -->
  <c:if test="${not empty param.extra_css}">
    <link rel="stylesheet" href="${param.extra_css}">
  </c:if>
</head>

<body>
<div class="pantallaCompletaEmprendimiento">
  <div class="titulo">
    <h1>COMUNICACION BARRIAL</h1>
  </div>
  <aside class="menu">
    <nav>
      <a href="<%= request.getContextPath() %>/jsp/inicio.jsp">INICIO</a>
      <a href="<%= request.getContextPath() %>/mostrarEmprendimientos">EMPRENDIMIENTOS</a>
      <a href="<%= request.getContextPath() %>/mostrarEventos">EVENTOS</a>
      <a href="<%= request.getContextPath() %>/mostrarRecursos">RECOLECCION RECURSOS</a>
      <a href="<%= request.getContextPath() %>/jsp/seguridad.jsp">SEGURIDAD</a>
    </nav>
  </aside>

  <!-- Contenido principal - Área derecha -->
  <main class="pantallaEmprendimientos">
    <c:choose>
      <%-- Si contentPage comienza con '<', es contenido directo --%>
      <c:when test="${fn:startsWith(param.contentPage, '<')}">
        ${param.contentPage}
      </c:when>
      <%-- Si no, es una ruta a incluir --%>
      <c:otherwise>
        <c:if test="${not empty param.contentPage}">
          <jsp:include page="${param.contentPage}" />
        </c:if>
      </c:otherwise>
    </c:choose>
  </main>

</div>
</body>
<script src="${pageContext.request.contextPath}/js/sidebar.js"></script>
<c:if test="${not empty param.extra_js}">
  <script src="${param.extra_js}"></script>
</c:if>
</html>