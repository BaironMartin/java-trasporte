/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author baironMartin
 */
public class empleados extends  personas{
    protected String contraseña;
    protected  String rol;

    public empleados( String Id, String Nombres, String Apellidos, Date F_Nacimiento, String Telefono,String contraseña, String rol) {
        super(Id, Nombres, Apellidos, F_Nacimiento, Telefono);
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
     
    public  void Insertar_Empleado() throws SQLException{
        
          
                        Connection cn2 = conexion.Conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into empleado values (?,?,?,?,?,?,?)");
                        
                             pst2.setString(1, Id);
                             pst2.setString(2, Nombres);
                             pst2.setString(3, Apellidos);
                             pst2.setDate(4, F_Nacimiento);
                             pst2.setString(5, Telefono);
                             pst2.setString(6, contraseña);
                             pst2.setString(7, rol);
                             
                        
                        pst2.executeUpdate();
                        cn2.close();
        
    }
    
    public  void Borrar_Empleado() throws SQLException{
        
         Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                "DELETE FROM empleado where Id_Empleado= ?");
          
            
          
                       pst.setString(1, Id);
                        pst.execute();
                        cn.close();
                        
    
    }
    
    public void Modificar_Empleado() throws  SQLException{
           
                Connection connection =conexion.Conectar();
                     PreparedStatement pst =connection.prepareStatement(
                              "update empleado set nombres = ?,apellido=?,F_Nacimiento=?,Telefono=?,rol=? " +
                                      "where Id_Empleado= '"+ Id +"'");
                      
                      
                     
                  
                                                      
                             pst.setString(1, Nombres);
                             pst.setString(2, Apellidos);                        
                             pst.setDate(3,F_Nacimiento);
                             pst.setString(4, Telefono);                             
                             pst.setString(5, rol);
                             
                        
                        pst.executeUpdate();
                        connection.close();
    }
    
    
    
}

