/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import clases.conexion;
import clases.empleados;
import  java.sql.*;
import java.sql.Connection;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;



/**
 *
 * @author baironMartin
 */
public class Login extends javax.swing.JFrame {
    
   
    public static String user="" ;
    
   
   
    static String user() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String pass="";
    

    
    
    
        public Login() {
        initComponents();
        setSize(400,500);
        setResizable(false);
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), 
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
     
        ImageIcon logo=new ImageIcon("src/images/DS.png");
        Icon icono1 =new ImageIcon(logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
       
        jLabel_Logo.setIcon(icono1);
        this.repaint();
               
        
    }
    
    @Override
    public Image getIconImage(){
    Image retValue =Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
    return retValue;
    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Footer = new javax.swing.JLabel();
        jButton_conexion = new javax.swing.JButton();
        jButton_Acceder = new javax.swing.JButton();
        jText_user = new javax.swing.JTextField();
        jTxt_Password = new javax.swing.JPasswordField();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(400, 550));
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("@ Licencias Creative Commons ");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 460, 210, -1));

        jButton_conexion.setBackground(new java.awt.Color(51, 51, 51));
        jButton_conexion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_conexion.setText("Verificar Conexión");
        jButton_conexion.setBorder(null);
        jButton_conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_conexionActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_conexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 110, 30));

        jButton_Acceder.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Acceder.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(null);
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, 35));

        jText_user.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jText_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_user.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jText_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 310, 210, -1));

        jTxt_Password.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTxt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxt_Password.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jTxt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 340, 210, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 250));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
       
        user=jText_user.getText().trim();
        pass=jTxt_Password.getText().trim();
     
        if(!user.equals("")||!pass.equals("")){
            
            try{
                Connection con = conexion.Conectar();
                PreparedStatement pst = con.prepareStatement(
                    "select rol from empleado where Id_Empleado = '"+user
                    + "' and contrasenia = '"+ pass +"' ");
                
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    String rol= res.getString("rol");
                    if (rol.equalsIgnoreCase("Administrador")) {
                        
                        dispose();
                        new Administrador().setVisible(true);
                        
                        
                    } else {
                    
                    
                       dispose();
                     new Empleado().setVisible(true);
                    }
                    
                    
                    
                  
                } else {
                    JOptionPane.showInternalMessageDialog(null, "Datos de acceso incorrectos");
                    jText_user.setText("");
                    jTxt_Password.setText("");
                }
                
                
                
                
            }
            catch(Exception e){
                System.err.println("Error en el boton acceder"+e);
                JOptionPane.showInternalMessageDialog(null, "Error al iniciar secion, Contactese con el administradoe");
                 jText_user.setText("");
                    jTxt_Password.setText("");
            }
        }
        else{
          JOptionPane.showInternalMessageDialog(null, "Debes llenar todos los campos");
           
        }
        
        
    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void jButton_conexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_conexionActionPerformed
    try{
                Connection con = conexion.Conectar();
                 JOptionPane.showInternalMessageDialog(null, "Conexion exitosa ");
                
    }
    catch(Exception e){
            
        JOptionPane.showInternalMessageDialog(null, "Error al conectarce, Contactese con el administrador" + e);
                     
    }
    }//GEN-LAST:event_jButton_conexionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JButton jButton_conexion;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField jText_user;
    private javax.swing.JPasswordField jTxt_Password;
    // End of variables declaration//GEN-END:variables

   
}
