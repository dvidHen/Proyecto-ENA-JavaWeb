<%-- 
    Document   : ingresarreq
    Created on : 16-07-2020, 20:00:00
    Author     : Henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
    <body>
        <div class="container">
            <form action="action"> <%--agregar gestión de ingreso--%>
                <h5>Ingresar requerimiento.</h5>
              <p>
                <div class="card-panel">
                Gerencia:    
                <select class="browser-default">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="1">Option 1</option>
                  <option value="2">Option 2</option>
                  <option value="3">Option 3</option>
                </select><br>
                Departamento:    
                <select class="browser-default">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="1">Option 1</option>
                  <option value="2">Option 2</option>
                  <option value="3">Option 3</option>
                </select><br>
                Asignar a:    
                <select class="browser-default">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="abastecimiento">Abastecimiento</option>
                  <option value="tic">TIC</option>
                </select><br>
                Encargado:    
                <select class="browser-default">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="1">Option 1</option>
                  <option value="2">Option 2</option>
                  <option value="3">Option 3</option>
                </select><br>
                Requerimiento:    
                <input type="text" name="nombre"><br>
                <a type="submit" value="guardar" class="waves-effect waves-light btn-small">Guardar</a>
                <a class="waves-effect waves-light btn-small" href="menuprincipal.jsp" name="menu">Volver al menú</a><br><br>
                
                </div>
              </p>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="./js/materialize.js"></script>
    </body>
</html>
