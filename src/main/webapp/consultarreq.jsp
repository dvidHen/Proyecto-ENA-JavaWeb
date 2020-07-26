<%-- 
    Document   : consultarreq
    Created on : 16-07-2020, 20:14:18
    Author     : Henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
    <body>
        <div class="container"> 
                <h5>Consultar Requerimiento.</h5>
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
                </select>
                <%--agregar función de busqueda de los datos--%>
                <button class="waves-effect waves-light btn-small" onclick="" name="buscar">Buscar</button><br><br>
                
                <table class="highlight">
                <thead>
                  <tr>
                      <th>Gerencia</th>
                      <th>Departamento</th>
                      <th>Asignado a</th>
                      <th>Requerimiento</th>
                  </tr>
                </thead>
                <%--Falta ingresar datos de respuestas, debe ser automático--%>    
                <tbody>
                  <tr>
                    <td>Alvin</td>
                    <td>Eclair</td>
                    <td>$0.87</td>
                    <td>$7.00</td>
                  </tr>
                  <tr>
                    <td>Alan</td>
                    <td>Jellybean</td>
                    <td>$3.76</td>
                    <td>$7.00</td>
                  </tr>
                  <tr>
                    <td>Jonathan</td>
                    <td>Lollipop</td>
                    <td>$7.00</td>
                    <td>$7.00</td>
                  </tr>
                  <tr>
                      <td>Jonathan</td>
                      <td>Lollipop</td>
                       <td>$7.00</td>
                       <td>$7.00</td>
                  </tr>
                </tbody>
              </table><br><br>
                
                <a class="waves-effect waves-light btn-small" href="menuprincipal.jsp" name="menu">Volver al menú</a><br><br>
                
                </div>
              </p>
            </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="./js/materialize.js"></script>
    </body>
</html>
