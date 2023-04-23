/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author baironMartin
 */
public class envios {
    
    protected String id_cliente;
    protected String id_envio;
    protected String tipo;
    protected String fragilidad;
    protected Date f_envio;
    protected String c_destino;
    protected String Direccion;
    protected float peso;
    protected float precio;

    public envios(String id_cliente, String id_envio, String tipo, String fragilidad, Date f_envio, String c_destino, String Direccion, float peso, float precio) {
        this.id_cliente = id_cliente;
        this.id_envio = id_envio;
        this.tipo = tipo;
        this.fragilidad = fragilidad;
        this.f_envio = f_envio;
        this.c_destino = c_destino;
        this.Direccion = Direccion;
        this.peso = peso;
        this.precio = precio;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_envio() {
        return id_envio;
    }

    public void setId_envio(String id_envio) {
        this.id_envio = id_envio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFragilidad() {
        return fragilidad;
    }

    public void setFragilidad(String fragilidad) {
        this.fragilidad = fragilidad;
    }

    public Date getF_envio() {
        return f_envio;
    }

    public void setF_envio(Date f_envio) {
        this.f_envio = f_envio;
    }

    public String getC_destino() {
        return c_destino;
    }

    public void setC_destino(String c_destino) {
        this.c_destino = c_destino;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    
    
    
    public  void Insertar_Envio() throws SQLException{
        
          Connection  cn = conexion.Conectar();
                     PreparedStatement pst =cn.prepareStatement(
                            "insert into envio values (?,?,?,?,?,?,?,?,?)");
                        
                             pst.setString(1,id_cliente);
                             pst.setString(2, id_envio);
                             pst.setString(3, tipo);
                             pst.setString(4, fragilidad);
                             pst.setDate(5, f_envio);
                             pst.setString(6, c_destino);
                             pst.setString(7, Direccion);
                             pst.setFloat(8, peso);
                             pst.setFloat(9, precio);
                             
                        
                        pst.executeUpdate();
                        cn.close();
    }
     public  void Eliminar_Envio() throws SQLException{
         
         Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                "DELETE FROM envio where Id_Envio= ?");
          
            
          
                       pst.setString(1, id_envio);
                        pst.execute();
                        cn.close();
         
     }
     
     public  void Modificar_Envio() throws SQLException{
         
         Connection connection =conexion.Conectar();
          PreparedStatement pst =connection.prepareStatement(
          "update envio set Tipo= ?,Fragilidad=?,F_Envio=?,C_destino=?,Direccion=?,peso=?,precio=? " +
            "where Id_Envio= '"+ id_envio +"'");
          
                 pst.setString(1, tipo);
                 pst.setString(2, fragilidad);                        
                 pst.setDate(3,f_envio);
                 pst.setString(4, c_destino);                             
                 pst.setString(5, Direccion);
                 pst.setFloat(6, peso);
                 pst.setFloat(7, precio);
                 
                 pst.executeUpdate();
                  connection.close();
         
     }
    
    
    
    
    
}
        
