/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Henrr
 */
public class MysqlConexion {
    private String URL="jdbc:mysql://localhost:3306/requerimientos";
    private String Driver="com.mysql.jdbc.Driver";
    private String user="root";
    private String pass="root";
    private Connection conex;
    
    
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(Driver);
        conex=DriverManager.getConnection(URL, user,pass);
    }
    public void desconectar() throws SQLException{
        conex.close();
    }

    public Connection getConexion() {
        return conex;
    }
}
