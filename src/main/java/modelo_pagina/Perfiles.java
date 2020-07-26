/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_pagina;

import Conexion.MysqlConexion;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrr
 */
public class Perfiles  {
  
    
    public boolean validarusuario(String usuario, String contrasena){ 
        MysqlConexion cone= new MysqlConexion();
        try{
            cone.conectar();
            String sql="select * from perfil where usuario = ? and contrasena= ?";
            PreparedStatement st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            st.setString(1, usuario);
            st.setString(2, contrasena);
            ResultSet rs=st.executeQuery();

            if(rs.absolute(1)){
                return true;
            }
            st.close();
            rs.close();
            cone.desconectar();
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }
}
