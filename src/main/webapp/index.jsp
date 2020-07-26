<%-- 
    Document   : index
    Created on : 16-07-2020, 18:45:25
    Author     : Henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String err=request.getParameter("err");
   String mensaje="";
   if(err!=null){
        mensaje= "<label class='col s6 offset-s3 card-panel teal lighten-1 white-text'>Usuario o contraseña erróneo</label>";
   } 
%>
<!DOCTYPE html>
<html>
    <jsp:include page="./shared/head.jsp" />
    
    <body>
        <div class="row">
            <%
           out.print(mensaje);
        %>
            <div class="col s6 offset-s3">
                <div class="card-panel z-depth-5" >
                    
                    <h5>Autentificación</h5>
                        <form action="autenticacion" method="post"> 
                        
                        <p>
                            Usuario:<input type="text" name="usuario"><br>
                            Contraseña:<input type="password" name="contrasena"><br>
                        </p>
                        
                        <br><br>
                        <input type="submit" value="ingresar" class="waves-effect waves-light btn-small white-text"/>
                    </form>
                        
                </div>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="./js/materialize.js"></script>
    </body>
</html>
