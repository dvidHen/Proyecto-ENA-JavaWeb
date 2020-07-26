/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_requerimientos;

import Conexion.MysqlConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo_pagina.Perfiles;

/**
 *
 * @author Henrr
 */
public class Requerimiento {
    private int id;
    private String gerencia;
    private String departamento;
    private String asignadoa;
    private String encargado;
    private String descripcion;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAsignadoa() {
        return asignadoa;
    }

    public void setAsignadoa(String asignadoa) {
        this.asignadoa = asignadoa;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public boolean ingresar(Requerimiento aux){
        boolean resultado= false;
        MysqlConexion cone= new MysqlConexion();
        try{
            cone.conectar();
            String sql="INSERT INTO requerimiento (gerencia, departamento, encargado, asignadoa, descripcion, estado) VALUES ( ?, ?, ?, ?, ?, ?);";
            PreparedStatement st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            st.setString(1, aux.getGerencia());
            st.setString(2, aux.getDepartamento());
            st.setString(3, aux.getEncargado());
            st.setString(4, aux.getAsignadoa());
            st.setString(5, aux.getDescripcion());
            st.setString(6, aux.getEstado());
            
            resultado = st.executeUpdate() > 0;

            cone.desconectar();
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultado;
    }
    
    public ArrayList<Requerimiento> consultar(){
        MysqlConexion cone= new MysqlConexion();
        ArrayList<Requerimiento> registros= new ArrayList();
        Requerimiento aux= new Requerimiento();
        try{
            cone.conectar();
            String sql="select * from requerimiento;";
            PreparedStatement st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            
            ResultSet res = st.executeQuery();
            
            if (res.next()) {//Resultados de query
                aux.setId(res.getInt("id"));
                aux.setGerencia(res.getString("gerencia"));
                aux.setDepartamento(res.getString("departamento"));
                aux.setEncargado(res.getString("encargado"));
                aux.setAsignadoa(res.getString("asignadoa"));
                aux.setDescripcion(res.getString("descripcion"));
                aux.setEstado(res.getString("estado"));
                //enlistado
                registros.add(aux);
            }
            cone.desconectar();
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        return registros;
    }
    
    public boolean cerrarcaso(int id){
        boolean resultado=false;
        MysqlConexion cone= new MysqlConexion();
        try{
            cone.conectar();
            String sql="UPDATE requerimiento SET estado ='cerrado' WHERE requerimiento.id = ?";
            PreparedStatement st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            st.setString(1, String.valueOf(id));

            resultado = st.executeUpdate() > 0;
            
            cone.desconectar();
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
                Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultado;
    }
    
}
