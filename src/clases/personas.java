
package clases;

import java.sql.Date;


public class personas {
    
    protected  String Id;
    protected  String Nombres;
    protected  String Apellidos;
    protected  Date F_Nacimiento;
    protected  String Telefono;

    
    //constructor
    public personas(String Id, String Nombres, String Apellidos, Date F_Nacimiento, String Telefono) {
        this.Id = Id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.F_Nacimiento = F_Nacimiento;
        this.Telefono = Telefono;
    }
    
    //getter and setter

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Date getF_Nacimiento() {
        return F_Nacimiento;
    }

    public void setF_Nacimiento(Date F_Nacimiento) {
        this.F_Nacimiento = F_Nacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
