<%-- 
    Document   : cerrarreq
    Created on : 16-07-2020, 20:15:38
    Author     : Henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo_pagina.Perfiles"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
    <jsp:useBean id="cn" class="modelo_pagina.Perfiles" scope="page"></jsp:useBean>
        <%
            //Estructura del ResulSet gerencia, departamento, encargado, trabajador
            ResultSet rs= cn.infocombos();
            String elemento="";
            
        %>
    <body>
        <div class="container"> 
            <h5>Cerrar Requerimiento.</h5>
            <form action="Controlador" method="post">    
              <p>
                <div class="card-panel">
                Gerencia:    
                <select class="browser-default" name="gerencia">
                  <option value="" disabled selected>Seleccionar</option>
                  <%
                      while(rs.next()){
                          if(!elemento.equals(rs.getString("gerencia"))){
                  %>
                          <option value="<%=rs.getString("gerencia")%>">
                          <%=rs.getString("gerencia")%>
                          </option>
                  <%    
                      elemento=rs.getString("gerencia");
                      }}
                  %>
                </select><br>
                Departamento:    
                <select class="browser-default" name="departamento">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="1">Option 1</option>
                  <option value="2">Option 2</option>
                  <option value="3">Option 3</option>
                </select><br>
                Asignar a:    
                <select class="browser-default" name="asignadoa">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="abastecimiento">Abastecimiento</option>
                  <option value="tic">TIC</option>
                </select>
                <%--agregar función de busqueda de los datos--%>
                <button class="waves-effect waves-light btn-small" type="submit" name="opcionEnvio" value="cierre">Buscar</button><br><br>
            </form>    
                <table class="highlight">
                <thead>
                  <tr>
                      <th>Gerencia</th>
                      <th>Departamento</th>
                      <th>Asignado a</th>
                      <th>Estado</th>
                      <th>Requerimiento</th>
                      <th></th>
                  </tr>
                </thead>
                <%--Falta ingresar datos de respuestas, debe ser automático--%>    
                <tbody>
                  <tr>
                    <td>Alvin</td>
                    <td>Eclair</td>
                    <td>$0.87</td>
                    <td>$7.00</td>
                    <td><button class="waves-effect waves-light btn-small" onclick="" name="cerrar" value="cerrar">Cerrar</button></td>
                  </tr>
                  <tr>
                    <td>Alan</td>
                    <td>Jellybean</td>
                    <td>$3.76</td>
                    <td>$7.00</td>
                    <td><button class="waves-effect waves-light btn-small" onclick="" name="cerrar" value="cerrar">Cerrar</button></td>
                  </tr>
                  <tr>
                    <td>Jonathan</td>
                    <td>Lollipop</td>
                    <td>$7.00</td>
                    <td>$7.00</td>
                    <td><button class="waves-effect waves-light btn-small" onclick="" name="cerrar" value="cerrar">Cerrar</button></td>
                  </tr>
                  <tr>
                      <td>Jonathan</td>
                      <td>Lollipop</td>
                       <td>$7.00</td>
                       <td>$7.00</td>
                       <td><button class="waves-effect waves-light btn-small" onclick="" name="cerrar" value="cerrar">Cerrar</button></td>
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
