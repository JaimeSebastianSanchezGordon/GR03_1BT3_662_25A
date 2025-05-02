<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.barrial.Emprendimiento" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>EMPRENDIMIENTOS</title>
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
            <a href="<%= request.getContextPath() %>/jsp/seguridad.jsp">SEGURIDAD</a>
        </nav>
    </aside>

    <main class="pantallaEmprendimientos">
        <div class="encabezadoEmprendimiento">
            <h2>EMPRENDIMIENTOS</h2>
            <button type="submit" class="botonRegistroEmprendimiento">Agregar emprendimiento</button>
        </div>

        <div class="emprendimientos">
            <%
                List<Emprendimiento> emprendimientos = (List<Emprendimiento>) request.getAttribute("emprendimientos");
                if (emprendimientos!= null && !emprendimientos.isEmpty()) {
                    for (Emprendimiento emprendimiento: emprendimientos) {
            %>
            <div class="emprendimiento">
                <div class="tituloEmprendimiento">
                    <h3><%=emprendimiento.getNombre()%></h3>
                </div>
                <div class="contenidoEmprendimiento">
                    <p><%=emprendimiento.getDescripcion()%></p>
                </div>
                <div>
                    <h3>AQUI VA IMAGEN</h3>
                </div>
            </div>
            <%
                }
            } else{
            %>
            <div class="noEmprendimientos">
                <h2> NO HAY EMPRENDIMIENTOS </h2>
            </div>
            <%
                }
            %>
        </div>
    </main>

    <div class="registroEmprendimiento" id="registroEmprendimiento">
        <div class="tituloRegistro">
            <h3>Registrar emprendimiento</h3>
        </div>
        <div class="datosRegistro">
            <form action="mostrarEmprendimientos" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit">Registrar emprendimiento</button>
            </form>
        </div>
    </div>

</div>

<script src="<%= request.getContextPath() %>/js/emprendimiento.js"></script>

</body>
</html>

