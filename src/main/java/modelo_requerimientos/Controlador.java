/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_requerimientos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrr
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion= request.getParameter("opcionEnvio");
        
        switch (opcion){
                case "ingreso":
                    ingresoReq(request, response);
                break;
                case "consulta":
                    consultaReq(request, response);
                    break;
                case "cierre":
                    cierreReq(request, response);
                    break;
        }
    }
    
    protected void ingresoReq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean respuesta;
        Requerimiento aux= new Requerimiento(
                request.getParameter("gerencia"),
                request.getParameter("departamento"),
                request.getParameter("asignadoa"),
                request.getParameter("encargado"),
                request.getParameter("descripcion"),
                "abierto"
        );
        
        respuesta= aux.ingresar(aux);
            
        if(respuesta==false){
            request.setAttribute("msg", "<div class='chip'>No se pudo guardar requerimiento.<i class='close material-icons'>close</i></div>");
        }else{
            request.setAttribute("msg", "<div class='chip'>Guardado correctamente.<i class='close material-icons'>close</i></div>");
        }
        request.getRequestDispatcher("ingresarreq.jsp").forward(request, response);
    }
    
  protected void consultaReq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ArrayList<Requerimiento> registros= new ArrayList();
        String  ger= request.getParameter("gerencia");
        String  dep= request.getParameter("departamento");
        String  asig= request.getParameter("asignadoa");
        
        System.out.println("datos de entrada: "+ ger + dep+ asig);
        Requerimiento aux= new Requerimiento();
        
        registros= aux.consultar(ger, dep, asig);
        
        if(registros==null){
            request.setAttribute("msg", "<div class='chip'>No se encontraron registros.<i class='close material-icons'>close</i></div>");
        }else{
            request.setAttribute("registros",registros);
        }
        request.getRequestDispatcher("consultarreq.jsp").forward(request, response);

    }

    
    protected void cierreReq(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String  id= request.getParameter("cierre");
        String  ger= request.getParameter("gerencia");
        String  dep= request.getParameter("departamento");
        String  asig= request.getParameter("asignadoa");
        Requerimiento aux= new Requerimiento();
        boolean respuesta= aux.cerrarcaso(Integer.parseInt(id));
        
        
        ArrayList<Requerimiento> registros= aux.consultar(ger, dep, asig);
        
        if(respuesta==false){
            request.setAttribute("msg", "<div class='chip'>No se pudo cerrar el requerimiento.<i class='close material-icons'>close</i></div>");
        }else{
            request.setAttribute("registros",registros);
        }
        request.getRequestDispatcher("cerrarreq.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
