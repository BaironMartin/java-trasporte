/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;



/**
 *
 * @author baironMartin
 */
public class empleado extends  personas{
    protected String contraseña;
    protected  String rol;

    public empleado(String Id, String Nombres, String Apellidos, Date F_Nacimiento, String Telefono) {
        super(Id, Nombres, Apellidos, F_Nacimiento, Telefono);
    }
  
     public void Guardarcontraseña(String pasString){
        this.contraseña = pasString;
    }
     
      public void GuardarRol(String rol){
        this.rol = rol;
    }
    
}
