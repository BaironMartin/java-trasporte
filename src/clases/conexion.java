
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public  class  conexion{
    //conexion local
    public static  Connection Conectar(){
        
        try{
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/bs_po","root","");
            return  con;
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion local, Comuniquese con el desarrollador"+e);
        }
            
        
    return (null);
        
    }
        }
       



