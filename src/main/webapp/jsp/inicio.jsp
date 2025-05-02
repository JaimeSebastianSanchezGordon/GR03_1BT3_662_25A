<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.barrial.Emprendimiento" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>INICIO</title>
    <link href="<%= request.getContextPath() %>/css/emprendimientos.css" rel="stylesheet">
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
            <a href="<%= request.getContextPath() %>/jsp/eventos.jsp">EVENTOS</a>
            <a href="<%= request.getContextPath() %>/jsp/recursos.jsp">RECOLECCION RECURSOS</a>
            <a href="">SEGURIDAD</a>
        </nav>
    </aside>

    <main class="pantallaInicio">
    </main>

</div>

</body>
</html>

