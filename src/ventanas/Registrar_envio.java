/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.conexion;
import clases.envios;
import java.awt.Color;
import java.awt.Image;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author baironMartin
 */
public class Registrar_envio extends javax.swing.JFrame {
 String userString;
  String id_cliente,id_envio,tipo,fragilidad="",destino,direccion;
        float peso,precio = 0;
        java.sql.Date fecha1;
    /**
     * Creates new form registrar_envio
     */
    public Registrar_envio() {
        initComponents();
        userString= gestionar_cliente.clienteupdate;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setSize(630,450);
        setResizable(false);
        setTitle("Registrar Envio");
        setLocationRelativeTo(null);
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), 
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
         jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }
       
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1_titulo = new javax.swing.JLabel();
        jLabel_id = new javax.swing.JLabel();
        jText_ID = new javax.swing.JTextField();
        jLabel_Nombres = new javax.swing.JLabel();
        jText_Tipo = new javax.swing.JTextField();
        jLabel_Apellidos = new javax.swing.JLabel();
        jText_direccion = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jLabel_Contraseña = new javax.swing.JLabel();
        jLabel_Rol = new javax.swing.JLabel();
        jComboBox_Rol = new javax.swing.JComboBox<>();
        jButton_agregar = new javax.swing.JButton();
        jLabel_Apellidos1 = new javax.swing.JLabel();
        jText_id1 = new javax.swing.JTextField();
        jLabel_Footer = new javax.swing.JLabel();
        jText_peso = new javax.swing.JTextField();
        jLabel_Apellidos2 = new javax.swing.JLabel();
        jText_destino = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1_titulo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_titulo.setText("Registro de Envios");
        getContentPane().add(jLabel1_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 240, 30));

        jLabel_id.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_id.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id.setText("ID. Envio");
        getContentPane().add(jLabel_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 200, -1));
        getContentPane().add(jText_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 200, 30));

        jLabel_Nombres.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombres.setText("Tipo");
        getContentPane().add(jLabel_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 200, -1));
        getContentPane().add(jText_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 200, 30));

        jLabel_Apellidos.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos.setText("Fecha de envio");
        getContentPane().add(jLabel_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 200, -1));

        jText_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(jText_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 200, 30));

        jLabel_Telefono.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Ciudad Destino:");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 200, -1));

        jLabel_Contraseña.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Contraseña.setText("Direccion:");
        getContentPane().add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 200, -1));

        jLabel_Rol.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Rol.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rol.setText("Fragilidad:");
        getContentPane().add(jLabel_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 200, -1));

        jComboBox_Rol.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jComboBox_Rol.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fragil", "No Fragil", "Fagilidad moderada" }));
        jComboBox_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RolActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 200, 30));

        jButton_agregar.setBackground(new java.awt.Color(51, 51, 51));
        jButton_agregar.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton_agregar.setForeground(new java.awt.Color(240, 240, 240));
        jButton_agregar.setText("Registrar Envio");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 210, 30));

        jLabel_Apellidos1.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos1.setText("Nombre cliente:");
        getContentPane().add(jLabel_Apellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 200, -1));

        jText_id1.setEnabled(false);
        jText_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_id1ActionPerformed(evt);
            }
        });
        getContentPane().add(jText_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 200, 30));

        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("@ Licencias Creative Commons ");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 210, -1));

        jText_peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_pesoActionPerformed(evt);
            }
        });
        getContentPane().add(jText_peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 200, 30));

        jLabel_Apellidos2.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos2.setText("Peso Lb");
        getContentPane().add(jLabel_Apellidos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 200, -1));

        jText_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_destinoActionPerformed(evt);
            }
        });
        getContentPane().add(jText_destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 200, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, 30));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_direccionActionPerformed

    private void jComboBox_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_RolActionPerformed

    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
        // TODO add your handling code here:
        int validacion =0;
       
        
        Date date =jDateChooser1.getDate();
       long d =date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
       fecha1=fecha;
     
        fragilidad= jComboBox_Rol.getSelectedItem().toString();
        id_cliente=userString;
        id_envio=jText_ID.getText().trim();
        destino=jText_destino.getText().trim();
        tipo=jText_Tipo.getText().trim();
        direccion=jText_direccion.getText().trim();
        peso=Float.parseFloat(jText_peso.getText().trim());
        if (peso>=0&&peso<5) {
            precio =7500;
            
        }else{
            if (peso>=5) {
               float resto=peso-4;
               precio=7500+(resto*1200);
            }
        }
        
        
          if (jDateChooser1 ==null) {
                
                 validacion++;
                 JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
          }
          
             if (id_envio.equals("")) {
                 jText_ID.setBackground(Color.red);
                 validacion++;
                   JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
               
             }
             if (destino.equals("")) {
                 jText_destino.setBackground(Color.red);
                 validacion++;
                   JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
             
             }
             if (tipo.equals("")) {
                 jText_Tipo.setBackground(Color.red);
                 validacion++;
                   JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
                           
             }
             if (direccion.equals("")) {
                 jText_direccion.setBackground(Color.red);
                 validacion++;
                   JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
                           
             }
             if (peso<-1) {
                 jText_peso.setBackground(Color.red);
                 validacion++;
                   JOptionPane.showMessageDialog(null, "debe llenar todos los campos.");
             }
             
            
               try {    
                    Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select Id_Envio FROM envio where Id_envio= '"+ id_envio +"'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                jText_ID.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "ID no disponible.");
                cn.close();
            } else {
                
                cn.close();
                
            
             if (validacion == 0) {
                 
                 
                 
                 try {
                     
                   Insertar_envio();
                        
                       
                        
                        jText_ID.setBackground(Color.green);                
                        jText_destino.setBackground(Color.green);               
                        jText_Tipo.setBackground(Color.green);            
                        jText_direccion.setBackground(Color.green);               
                        jText_peso.setBackground(Color.green);
                        
                        
                        
                        JOptionPane.showMessageDialog(null, "Registro exitoso.");
                        this.dispose();
                 } catch (SQLException e) {
                      System.err.println("Error al registrar el envio "+e);
              JOptionPane.showMessageDialog(null, "¡¡ERROR !!, contacte al administrador.");
                 }
             
             }else{
                 JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
                 
             }
               }
               }
               catch (SQLException e) {
            System.err.println("Error en validar nombre de usario." + e);
            JOptionPane.showMessageDialog(null, "¡¡ERROR al comparar usuario!!, contacte al administrador.");
                        }
             
            
        
        
        
    }//GEN-LAST:event_jButton_agregarActionPerformed

    private void jText_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_destinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_destinoActionPerformed

    private void jText_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_id1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jText_id1ActionPerformed

    private void jText_pesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_pesoActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jText_pesoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrar_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_envio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JComboBox<String> jComboBox_Rol;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1_titulo;
    private javax.swing.JLabel jLabel_Apellidos;
    private javax.swing.JLabel jLabel_Apellidos1;
    private javax.swing.JLabel jLabel_Apellidos2;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombres;
    private javax.swing.JLabel jLabel_Rol;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JTextField jText_ID;
    private javax.swing.JTextField jText_Tipo;
    private javax.swing.JTextField jText_destino;
    private javax.swing.JTextField jText_direccion;
    private javax.swing.JTextField jText_id1;
    private javax.swing.JTextField jText_peso;
    // End of variables declaration//GEN-END:variables

     void Insertar_envio() throws SQLException{
         
         envios envio1 = new envios(id_cliente,id_envio,tipo,fragilidad,fecha1,destino,direccion,peso,precio);
         envio1.Insertar_Envio();
         
     }
    
}
