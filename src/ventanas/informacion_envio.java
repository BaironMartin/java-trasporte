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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author baironMartin
 */
public class informacion_envio extends javax.swing.JFrame {

    String envio_update;
    int Id;
    
    float peso,precio;
     String  id_cliente,id_envio,tipo,fragilidad,destino,direccion;
    java.sql.Date fecha1;
    
    /**
     * Creates new form informacion_envio
     */
    public informacion_envio() {        
        initComponents();
        envio_update=informacion_cliente.Id_envio;
        setSize(670,530);
        setResizable(false);
        setTitle("Informacion del Envio");
        setLocationRelativeTo(null);
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), 
        jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
         jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
         try {
            Connection cn = conexion.Conectar();
             PreparedStatement pst = cn.prepareStatement(
                "select * from  envio where Id_Envio ='" + envio_update +"'");
             ResultSet rs = pst.executeQuery();
             if (rs.next()){
                 Id=rs.getInt("Id_Envio");
                 
                 jText_ID.setText(rs.getString("Id_Envio"));
                 jText_Tipo.setText(rs.getString("Tipo"));
                 jText_ID1.setText(rs.getString("Id_Cliente"));
                 jText_direccion.setText(rs.getString("Direccion"));
                 jComboBox_Rol.setSelectedItem(rs.getString("fragilidad"));
                 jText_ciudad.setText(rs.getString("C_destino"));
                 jDateChooser1.setDate(rs.getDate("F_Envio"));
                 jText_peso.setText(rs.getString("peso"));
                 
                 
             } 
             cn.close();
               
             
        } catch (Exception e) {
              System.err.println("Error al cargar usuario "+e);
              JOptionPane.showMessageDialog(null, "¡¡ERROR !!, contacte al administrador.");
        }
       
             
        
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
        jLabel_Apellidos2 = new javax.swing.JLabel();
        jText_peso = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jText_ciudad = new javax.swing.JTextField();
        jLabel_Contraseña = new javax.swing.JLabel();
        jText_direccion = new javax.swing.JTextField();
        jLabel_Rol = new javax.swing.JLabel();
        jComboBox_Rol = new javax.swing.JComboBox<>();
        jButton_registrarcliente = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        eliminar = new javax.swing.JButton();
        jLabel_id1 = new javax.swing.JLabel();
        jText_ID1 = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1_titulo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_titulo.setText("Información del  envio");
        getContentPane().add(jLabel1_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 240, 30));

        jLabel_id.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_id.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id.setText("ID. Envio");
        getContentPane().add(jLabel_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, -1));

        jText_ID.setEnabled(false);
        jText_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_IDActionPerformed(evt);
            }
        });
        getContentPane().add(jText_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 200, 30));

        jLabel_Nombres.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombres.setText("Tipo");
        getContentPane().add(jLabel_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 200, -1));
        getContentPane().add(jText_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 200, 30));

        jLabel_Apellidos.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos.setText("Fecha de envio");
        getContentPane().add(jLabel_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 200, -1));

        jLabel_Apellidos2.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos2.setText("Peso");
        getContentPane().add(jLabel_Apellidos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 200, -1));
        getContentPane().add(jText_peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 200, 30));

        jLabel_Telefono.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Ciudad Destino:");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 200, -1));

        jText_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_ciudadActionPerformed(evt);
            }
        });
        getContentPane().add(jText_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 200, 30));

        jLabel_Contraseña.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Contraseña.setText("Direccion:");
        getContentPane().add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 200, -1));

        jText_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(jText_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 200, 30));

        jLabel_Rol.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Rol.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rol.setText("Fragilidad:");
        getContentPane().add(jLabel_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 200, -1));

        jComboBox_Rol.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jComboBox_Rol.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fragil", "No Fragil", "Fagilidad moderada" }));
        jComboBox_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_RolActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 200, 30));

        jButton_registrarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        getContentPane().add(jButton_registrarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 120, 100));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("@ Licencias Creative Commons ");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 210, -1));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 200, 30));

        eliminar.setBackground(new java.awt.Color(51, 51, 51));
        eliminar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.setBorder(null);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 140, 25));

        jLabel_id1.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_id1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id1.setText("ID. Envio");
        getContentPane().add(jLabel_id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 200, -1));

        jText_ID1.setEnabled(false);
        getContentPane().add(jText_ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 200, 30));

        modificar.setBackground(new java.awt.Color(51, 51, 51));
        modificar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("Modificar");
        modificar.setBorder(null);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 140, 25));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_ciudadActionPerformed

    private void jText_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_direccionActionPerformed

    private void jComboBox_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_RolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_RolActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        id_envio= jText_ID.getText().trim();
       int respuesta = JOptionPane.showConfirmDialog(null, "desea eliminar id "+ id_envio);
       
       if(respuesta==0){
            
            try { 
                     
           Eliminar_envio();
                        
            JOptionPane.showMessageDialog(null, "¡¡Eliminacion Correcta!!");
                         this.dispose();
                       
                         
            }
                     
                  catch (SQLException e) {
                      System.err.println("Error al Eliminar usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al Eliminar!!, contacte al administrador.");
                 }
       
           
       }
       
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        
        Date date =jDateChooser1.getDate();
       long d =date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
              int validacion =0;          
     
        
        id_cliente = jText_ID1.getText() .trim();
        id_envio= jText_ID.getText() .trim();
        tipo=jText_Tipo.getText() .trim();
        fragilidad=jComboBox_Rol.getSelectedItem().toString();
        direccion=jText_direccion.getText().trim();
        destino=jText_ciudad.getText().trim();
        peso=Float.parseFloat(jText_peso.getText().trim());
       
        fecha1=fecha;
      
      
             if (id_cliente.equals("")) {
                 jText_ID1.setBackground(Color.red);
                 validacion++;
               
             }
             if (id_envio.equals("")) {
                 jText_ID.setBackground(Color.red);
                 validacion++;
             
             }
             if (tipo.equals("")) {
                 jText_Tipo.setBackground(Color.red);
                 validacion++;                     
             }
             if (direccion.equals("")) {
                 jText_direccion.setBackground(Color.red);
                 validacion++;                     
             }
             if (destino.equals("")) {
                 jText_ciudad.setBackground(Color.red);
                 validacion++;                     
             }
             if (peso<-1) {
                 jText_peso.setBackground(Color.red);
                 validacion++;                     
             }
             
              if (peso>=0&&peso<5) {
            precio =7500;
            
        }else{
            if (peso>=5) {
               float resto=peso-4;
               precio=7500+(resto*1200);
            }
           
        }
             if (validacion==0){
        
       
                 try { 
                     
             
                
           
                        Modificar_envio();
                        JOptionPane.showMessageDialog(null, "¡¡Actualizacion Correcta!!");
                         this.dispose();
            
                     
                 } catch (SQLException e) {
                      System.err.println("Error al Actualizar usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador.");
                 }
                 
         }
             else{
                  JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
             }
        
        
    }//GEN-LAST:event_modificarActionPerformed

    private void jText_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_IDActionPerformed

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
            java.util.logging.Logger.getLogger(informacion_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacion_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacion_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacion_envio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacion_envio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton_registrarcliente;
    private javax.swing.JComboBox<String> jComboBox_Rol;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1_titulo;
    private javax.swing.JLabel jLabel_Apellidos;
    private javax.swing.JLabel jLabel_Apellidos2;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombres;
    private javax.swing.JLabel jLabel_Rol;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JLabel jLabel_id1;
    private javax.swing.JTextField jText_ID;
    private javax.swing.JTextField jText_ID1;
    private javax.swing.JTextField jText_Tipo;
    private javax.swing.JTextField jText_ciudad;
    private javax.swing.JTextField jText_direccion;
    private javax.swing.JTextField jText_peso;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables

    void Modificar_envio() throws SQLException{
         
         envios envio1 = new envios(null,id_envio,tipo,fragilidad,fecha1,destino,direccion,peso,precio);
         envio1.Modificar_Envio();
         
     }
     void Eliminar_envio()throws  SQLException{
         
         envios envio2 = new envios(null,id_envio,null,null,null,null,null,0,0);
         envio2.Eliminar_Envio();
         
     }
}

