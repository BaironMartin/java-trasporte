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
public class cliente extends personas{
    
    protected String Direcion;
    protected  String Ciudad;

    public cliente(String Id, String Nombres, String Apellidos, Date F_Nacimiento, String Telefono,String Direcion, String Ciudad) {
        super(Id, Nombres, Apellidos, F_Nacimiento, Telefono);
        this.Direcion = Direcion;
        this.Ciudad = Ciudad;
    }

    public String getDirecion() {
        return Direcion;
    }

    public void setDirecion(String Direcion) {
        this.Direcion = Direcion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
    
    public  void Borrar_Cliente() throws SQLException{
        Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                "DELETE FROM cliente where Id_Cliente= ?");
          
            
          
                       pst.setString(1, Id);
                        pst.execute();
                        cn.close();
    }
   public  void Insertar_Cliente() throws SQLException{
       Connection cn2 = conexion.Conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into cliente values (?,?,?,?,?,?,?)");
                        
                             pst2.setString(1, Id);
                             pst2.setString(2, Nombres);
                             pst2.setString(3, Apellidos);
                             pst2.setDate(4, F_Nacimiento);
                             pst2.setString(5, Telefono);
                             pst2.setString(6, Direcion);
                             pst2.setString(7, Ciudad);
                             
                        
                        pst2.executeUpdate();
                        cn2.close();
       
   }
   public  void Eliminar_Cliente() throws SQLException{
               
             Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                "DELETE FROM cliente where Id_Cliente= ?");
          
            
          
                       pst.setString(1, Id);
                        pst.execute();
                        cn.close();
       
   }
   public  void Modificar_Cliente() throws SQLException{
       Connection connection =conexion.Conectar();
                     PreparedStatement pst =connection.prepareStatement(
                              "update Cliente set nombres = ?,apellidoS=?,F_Nacimiento=?,Telefono=?,Ciudad=? ,Direccion=? " +
                                      "where Id_Cliente= '"+    Id +"'");
                      
                                       
                             pst.setString(1, Nombres);
                             pst.setString(2,Apellidos );                        
                             pst.setDate(3,F_Nacimiento);
                             pst.setString(4, Telefono);                             
                             pst.setString(5, Ciudad);
                             pst.setString(6, Direcion);
                              
                             
                        
                        pst.executeUpdate();
                        connection.close();
   }
   
}
