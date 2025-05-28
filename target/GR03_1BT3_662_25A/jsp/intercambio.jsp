<%@ page import="java.util.List" %>
<%@ page import="com.barrial.DTO.IntercambioDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.barrial.DTO.IntercambioDTO" %>
<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    /*PARA EL FORMULARIO DE REGISTRO*/
    .formularioRegistroTrueque {
        width: 20%;
        height: auto;
        border: solid black;
        text-align: center;
    }

    .formularioRegistroTrueque input{
        margin: 10px 0px;
    }

    .formularioRegistroTrueque button{
        margin: 10px 0px;
    }

    .formularioRegistroTrueque h4{
        margin: 0;
    }

    /*PARA EL CONTENIDO PRINCIPAL DE TRUEQUES Y PRETAMOS*/
    .trueque{
        border: solid black;
        display: grid;
        grid-template-columns: 40% auto;
        text-align: center;
        padding: 10px;
        box-sizing: border-box;
    }

    .tituloCategoria{
        grid-column: 1/3;
    }

    .tituloCategoria h2{
        margin: 0;
    }

    .contenidoIntercambios{
        padding: 10px;
        display: grid;
        grid-template-columns: auto auto auto auto;
        gap: 20px;
    }

    .trueque {
        background: white;
        border-radius: 10px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        transition: all 0.3s ease;
        display: grid;
        grid-template-columns: 200px 200px;
        grid-auto-rows: auto auto auto;
        width: 400px;
        border: 3px solid #2c3e50;
    }

    .tituloCategoria {
        grid-column: 1/4;
        grid-row: 1;
        padding: 1rem;
        background-color: #2c3e50;
        color: white;
        display: flex;
        align-items: center;
    }

    .objetoADar {
        grid-column: 1;
        grid-row: 2;
        padding: 1rem;
        background-color: #f8f9fa;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .objetoARecivir {
        grid-column: 2/3;
        grid-row: 2;
        padding: 1rem;
        background-color: white;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .botonRegistroIntercambio {
        background-color: #516591;
        color: white;
        border: none;
        padding: 0.8rem 1.5rem;
        border-radius: 50px;
        font-weight: 600;
        cursor: pointer;
        transition: all 0.3s ease;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    .botonRegistroIntercambio:hover {
        background-color: rgba(68, 139, 147, 0.8);
        transform: translateY(-2px);
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
    }

 


</style>

<c:set var="intercambioContent">
    <div class="encabezadoEmprendimiento">
        <h2>INTERCAMBIO</h2>
        <button type="submit" class="botonRegistroIntercambio">Agregar intercambio</button>
    </div>

    <%--    PARA LA BUSQUEDA PERSONALIZADA DE INTERCAMBIOS--%>
    <div class="buscarIntercambio">
        <form action="registroIntercambio" method="GET" style="position: relative; left: 80%;">
            <input type="text" name="buscar" placeholder="Nombre del objeto">
            <button  type="submit" name="btnBuscarIntercambio">Buscar</button>
        </form>
    </div>

    <div class="contenidoIntercambios">
        <%
            List<IntercambioDTO> intercambiosDTO = (List<IntercambioDTO>) request.getAttribute("intercambios");
            if (intercambiosDTO != null && !intercambiosDTO.isEmpty()){
                for (IntercambioDTO intercambioDTO : intercambiosDTO){
        %>
        <div class="trueque">
            <div class="tituloCategoria">
                <h2>INTERCAMBIO</h2>
            </div>
            <div class="objetoADar">
                <h3><%= intercambioDTO.getNombre()%></h3>
                <p><%= intercambioDTO.getDescripcion()%></p>
                <img src="<%= intercambioDTO.getImagen()%>" alt="ESTA ES LA IMAGEN">
            </div>
            <div class="objetoARecivir">
                <h3>Quiere: <%= intercambioDTO.getObjetoTrueque()%></h3>
                <h3>Descripcion:</h3>
                <p><%= intercambioDTO.getDescripcionObjetoTrueque()%></p>
            </div>
        </div>

        <%
            }
        } else{
        %>
        <div class="noEmprendimientos">
            <h2> NO HAY INTERCAMBIOS </h2>
        </div>
        <%
            }
        %>

    </div>


    <%--    MODAL PARA REGISTRO--%>
    <form onsubmit="validarFormulario(event)" action="<%= request.getContextPath() %>/registroIntercambio" method="POST">
        <div class="formularioRegistroTrueque" id="registroIntercambio">
            <h2>REGISTRO DE INTERCAMBIO</h2>
            <h2>OBJETO A DAR</h2>
            <input type="text" name="nombre" id="nombre" placeholder="Nombre"> <br>
            <input type="text" name="descripcion" id="descripcion" placeholder="Descripcion"> <br>
            <input type="text" name="imagen" id="imagen" placeholder="Imagen"> <br>
            <h2>OBJETO A RECIBIR</h2>
            <input type="text" name="articulo" id="trueque" placeholder="Articulo deseado" ><br>
            <input type="text" name="descripcionArticulo" id="descripcionTrueque" placeholder="Descripcion del articulo deseado"> <br>
            <button type="submit">Registar intercambio</button>
        </div>
    </form>

    <script>
        function validarFormulario(event) {
            event.preventDefault();

            const nombre = document.getElementById('nombre').value.trim();
            const descripcion = document.getElementById('descripcion').value.trim();
            const imagen = document.getElementById('imagen').value.trim();
            const trueque = document.getElementById('trueque').value.trim();
            const descripcionTrueque = document.getElementById('descripcionTrueque').value.trim();

            const campos = [nombre, descripcion, imagen, trueque, descripcionTrueque];

            const regexSoloLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s.,]+$/;

            // Validar campos vacíos
            if (campos.some(campo => campo === '')) {
                alert("Por favor, llena todos los campos antes de enviar.");
                return;
            }

            // Validar campos específicos que no deben tener números ni símbolos especiales
            if (!regexSoloLetras.test(nombre)) {
                alert("El campo 'Nombre' contiene caracteres no permitidos.");
                return;
            }

            if (!regexSoloLetras.test(trueque)) {
                alert("El campo 'Artículo deseado' contiene caracteres no permitidos.");
                return;
            }

            alert("¡Formulario enviado correctamente!");
            event.target.submit(); // Enviar el formulario si todo es correcto
        }
    </script>

</c:set>

<jsp:include page="/jsp/baseM.jsp">
    <jsp:param name="title" value="MiBarrioApp-Emprendimiento"/>
    <jsp:param name="contentPage" value="${intercambioContent}"/>
    <jsp:param name="extra_js" value="${pageContext.request.contextPath}/js/intercambio.js"/>
    <jsp:param name="extra_css" value="${pageContext.request.contextPath}/css/styleIntercambio.css"/>
</jsp:include>