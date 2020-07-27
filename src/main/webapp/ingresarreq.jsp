<%-- 
    Document   : ingresarreq
    Created on : 16-07-2020, 20:00:00
    Author     : Henrr
--%>

<%@page import="modelo_pagina.Perfiles"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form action="Controlador" method="post"> 
                <h5>Ingresar requerimiento.</h5>
                ${msg}
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
                </select><br>
                Encargado:    
                <select class="browser-default" name="encargado">
                  <option value="" disabled selected>Seleccionar</option>
                  <option value="1">Option 1</option>
                  <option value="2">Option 2</option>
                  <option value="3">Option 3</option>
                </select><br>
                Requerimiento:    
                <input type="text" name="descripcion"><br>
                <button type="submit" value="ingreso" name="opcionEnvio" class="waves-effect waves-light btn-small">Guardar</button>
                <a class="waves-effect waves-light btn-small" href="menuprincipal.jsp" name="menu">Volver al menú</a><br><br>
                
                </div>
              </p>
            </form>
                
        </div>
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="./js/materialize.js"></script>
    </body>
</html>
