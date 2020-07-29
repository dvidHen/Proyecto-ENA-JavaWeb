<%-- 
    Document   : consultarreq
    Created on : 16-07-2020, 20:14:18
    Author     : Henrr
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo_requerimientos.Requerimiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
   

    <body>
            <jsp:useBean id="cn" class="modelo_pagina.Perfiles" scope="page"></jsp:useBean>

        <%
            //Estructura del ResulSet gerencia, departamento, encargado, trabajador
            ResultSet rs= cn.infocombos();
            String elemento="";
            
        %>
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
                    <%--busqueda de datos--%>
                    <button class="waves-effect waves-light btn-small" type="submit" name="opcionEnvio" value="consulta">Buscar</button><br><br>
            </form> 
                   
                    <table class="highlight">
                    <thead>
                      <tr>
                          <th>Gerencia</th>
                          <th>Departamento</th>
                          <th>Asignado a</th>
                          <th>Requerimiento</th>
                          <th>Acción</th>
                              
                      </tr>
                    </thead>
                         
                    <tbody>  
  
                         <%
                            ArrayList<Requerimiento> requerimientosRegistrados= (ArrayList<Requerimiento>) request.getAttribute("registros");
                            if(requerimientosRegistrados==null){
                         %>
                                <p>No trajo registros</p>
                         <% }else{
                            for(Requerimiento aux: requerimientosRegistrados){


                         %>

                               <tr>
                                   
                                   <td><%=aux.getGerencia()%></td>
                                   <td><%=aux.getDepartamento()%></td>
                                   <td><%=aux.getAsignadoa()%></td>
                                   <td><%=aux.getDescripcion()%></td>
                                   <td  name="id" value="<%=aux.getId()%>"><%=aux.getId()%></td>
                               </tr>
                          <%
                              }
                            }
                          %>

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
