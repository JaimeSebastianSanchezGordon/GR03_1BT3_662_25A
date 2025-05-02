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
    </main>

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

</div>

<script src="<%= request.getContextPath() %>/js/seguridad.js"></script>

</body>
</html>

