<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>EVENTOS</title>
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
    <main class="pantallaEmprendimientos">
        <div class="encabezadoEmprendimiento">
            <h2>EVENTOS</h2>
            <button type="submit" class="botonRegistroEvento">Agregar evento</button>
        </div>
        <div class="eventos">
            <%
                for (int i = 0; i < 6; i++) {
            %>
            <div class="evento">
                <div class="nombreEvento">
                    <h3>NOMBRE</h3>
                </div>
                <div class="contenidoEvento">
                    <div class="informacionEvento">
                        <div class="descipcionEvento">
                            <p>DESCRIPCION</p>
                        </div>
                        <div class="fechaEvento">
                            <p>FECHA</p>
                        </div>
                        <div class="horaEvento">
                            <p>HORA</p>
                        </div>
                    </div>
                    <div class="imagen">
                        <h3>AQUI VA LA IMAGEN</h3>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>

        <div class="emprendimientos">
        </div>
    </main>

    <div class="registroEvento" id="registroEvento">
        <div class="tituloRegistro">
            <h3>Registrar evento</h3>
        </div>
        <div class="datosRegistro">
            <form action="" method="POST">
                Nombre: <br>
                <input type="text" name="nombre"><br>
                Descripcion: <br>
                <input type="text" name="descripcion"><br>
                Fecha: <br>
                <input type="text" name="fecha"><br>
                Hora: <br>
                <input type="text" name="hora"><br>
                Imagen:<br>
                <input type="text" name="imagen"><br>
                <button type="submit">Registrar evento</button>
            </form>
        </div>
    </div>
</div>

<script src="<%= request.getContextPath() %>/js/eventos.js"></script>

</body>
</html>

