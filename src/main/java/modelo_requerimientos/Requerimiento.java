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


    public Requerimiento(String gerencia, String departamento, String asignadoa, String encargado, String descripcion, String estado) {
        this.gerencia = gerencia;
        this.departamento = departamento;
        this.asignadoa = asignadoa;
        this.encargado = encargado;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Requerimiento() {
    }
    
    
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
    
    /*public ArrayList consultar(){
        MysqlConexion cone= new MysqlConexion();
        ArrayList<Requerimiento> registros= new ArrayList();
        ResultSet res= null;
        Requerimiento aux= new Requerimiento();
        try{
            cone.conectar();
            String sql="select id, gerencia, departamento, encargado, asignadoa, descripcion, estado from requerimiento";
            PreparedStatement st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            
            res = st.executeQuery();
            
            while (res.next()) {//Resultados de query
                int id=res.getInt("id");
                aux.setId(res.getInt("id"));
                System.out.println("Id de la base: "+ aux.getId());
                aux.setGerencia(res.getString("gerencia"));
                aux.setDepartamento(res.getString("departamento"));
                aux.setEncargado(res.getString("encargado"));
                aux.setAsignadoa(res.getString("asignadoa"));
                aux.setDescripcion(res.getString("descripcion"));
                aux.setEstado(res.getString("estado"));
                
                System.out.println("Id desde la clase" + aux.getId());
                //enlistado
                registros.add(aux);
                
            }
            for(Requerimiento i: registros){
                System.out.println("Id desde la lista: " +i.getId());
            }
            
            
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
            }
        return registros;
    }*/
    
     public ResultSet consultar(String ger, String dep, String asig){
        MysqlConexion cone= new MysqlConexion();

        ResultSet res= null;
        Requerimiento aux= new Requerimiento();
        try{
            cone.conectar();
            PreparedStatement st;
            if(ger.equals("") || dep.equals("") || asig.equals("")){
                String sql="select id, gerencia, departamento, encargado, asignadoa, descripcion, estado from requerimiento";
                st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
            }else{
                String sql="select id, gerencia, departamento, encargado, asignadoa, descripcion, estado from requerimiento where gerencia= ? and departamento= ? and asignadoa= ? ";
                st=(PreparedStatement) cone.getConexion().prepareStatement(sql);
                st.setString(1, ger);
                st.setString(2, dep);
                st.setString(1, asig);
            }
            
            
            res = st.executeQuery();
            
            
        } catch (SQLException ex) { }
        
            catch (ClassNotFoundException ex) {
            }
        return res;
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
