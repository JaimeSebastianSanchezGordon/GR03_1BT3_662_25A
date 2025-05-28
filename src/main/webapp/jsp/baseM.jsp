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
  <style>
    .titulo{
      display: grid;
      grid-template-columns: 10% auto 10%;
    }

    .titulo h2 {
      margin: 0;
    }

    .titulo button{
      background: darkred;
      color: white;
      padding: 10px 20px;
      margin: 0;
      border: none;
      border-radius: 5px;
    }

  </style>
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
      <a href="<%= request.getContextPath() %>/mostrarProblema">PROBLEMAS</a>
      <a href="">INTERCAMBIO</a>
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