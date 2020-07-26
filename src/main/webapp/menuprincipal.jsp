<%-- 
    Document   : menuprincipal
    Created on : 16-07-2020, 19:51:25
    Author     : Henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
    <body>
      <div class="container">
        <div class="card-panel z-depth-5">
            <h5>Menú Principal.</h5><br>
            <a class="waves-effect waves-light btn-small" href="ingresarreq.jsp" name="ingreso">Ingresar Requerimiento</a><br><br>   
            <a class="waves-effect waves-light btn-small" href="consultarreq.jsp" name="consulta">Consultar Requerimiento</a><br><br>  
            <a class="waves-effect waves-light btn-small" href="cerrarreq.jsp" name="cerrar">Cerrar Requerimiento</a> 
            <p class="right-align"><a class="waves-effect waves-light btn-small" href="index.jsp" name="salir" >Cerrar sesión</a></p>
            
        </div>    

      </div> 
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="./js/materialize.js"></script>
    </body>
</html>
