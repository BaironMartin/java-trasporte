/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.cliente;
import clases.conexion;
import clases.empleados;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author baironMartin
 */
public class informacion_cliente extends javax.swing.JFrame {
    
    DefaultTableModel model=new DefaultTableModel();
    String clienteupdate="";
    String  id ,nombre ,apellido,telefono,direccion, ciudad;
    java.sql.Date fecha1;
     int Id;
     public static String Id_envio="",user="";
    /**
     * Creates new form informacion_cliente
     */
    public informacion_cliente() {
        initComponents();
        
        user=Login.user;
        clienteupdate=gestionar_cliente.clienteupdate;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        setSize(630,450);
        setResizable(false);
        setTitle("Información del Cliente - Sesión de Id usuario "+user);
        setLocationRelativeTo(null);
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(fecha.getWidth(), 
                fecha.getHeight(), Image.SCALE_DEFAULT));
         fecha.setIcon(icono);
        this.repaint();
        
        
         try {
            Connection cn = conexion.Conectar();
             PreparedStatement pst = cn.prepareStatement(
                "select * from  cliente where Id_Cliente ='" + clienteupdate +"'");
             ResultSet rs = pst.executeQuery();
             if (rs.next()){
                 Id=rs.getInt("Id_Cliente");
                 
                 jText_id.setText(rs.getString("Id_Cliente"));
                 jText_Nombre.setText(rs.getString("Nombres"));
                 jText_apellido.setText(rs.getString("Apellidos"));
                 jText_telefono.setText(rs.getString("Telefono"));
                 fechan.setDate(rs.getDate("F_Nacimiento"));
                 jText_ciudad.setText(rs.getString("Ciudad"));
                 jText_direccion.setText(rs.getString("Direccion"));
                 
                 
                 
             } 
             cn.close();
               
             
        } catch (Exception e) {
              System.err.println("Error al cargar usuario "+e);
              JOptionPane.showMessageDialog(null, "¡¡ERROR !!, contacte al administrador.");
        }
         try {
            Connection connection = conexion.Conectar();
            PreparedStatement preparedStatement =connection.prepareStatement(
                    "select Id_Envio,tipo,fragilidad,C_destino from envio  where Id_Cliente='"+ clienteupdate +"'" );
            
            ResultSet rs = preparedStatement.executeQuery();
            jTable_envios=new JTable(model);
            jScrollPane1.setViewportView(jTable_envios);
            model.addColumn("ID ENVIO");
            model.addColumn("TIPO");
            model.addColumn("FRAGILIDAD");
            model.addColumn("CIUDAD DESTINO");
            
             while (rs.next()) {
               
                 Object[]fila =new Object[4];
                 
                 for (int i = 0; i < 4; i++) {
                     fila[i] = rs.getObject(i+1);
                     
                     
                 }
                 model.addRow(fila);
                 
             }
           connection.close();
            
        } catch (SQLException e) {
            
             System.err.println("!!Error¡¡");
        }
         
          jTable_envios.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
              
               int fila_point =jTable_envios.rowAtPoint(e.getPoint());
               int columna_point = 0;
               
                if (fila_point > -1) {
                    Id_envio=(String)model.getValueAt(fila_point, columna_point);
                    informacion_envio envio= new informacion_envio();
                   envio.setVisible(true);
                    
                } else {
                }
                
            }
            
            
            
            
        });
         
         
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
        jLabel_Nombres = new javax.swing.JLabel();
        jText_Nombre = new javax.swing.JTextField();
        jLabel_Apellidos = new javax.swing.JLabel();
        jText_apellido = new javax.swing.JTextField();
        jLabel_FechaNac1 = new javax.swing.JLabel();
        jLabel_Telefono = new javax.swing.JLabel();
        jText_direccion = new javax.swing.JTextField();
        jLabel_Contraseña = new javax.swing.JLabel();
        jLabel_Rol = new javax.swing.JLabel();
        jText_ciudad = new javax.swing.JTextField();
        jText_telefono = new javax.swing.JTextField();
        jText_id = new javax.swing.JTextField();
        jLabel_Footer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_envios = new javax.swing.JTable();
        jButton_registrar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_empleados = new javax.swing.JButton();
        fechan = new com.toedter.calendar.JDateChooser();
        fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1_titulo.setFont(new java.awt.Font("Arial Narrow", 0, 24)); // NOI18N
        jLabel1_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_titulo.setText("Información del Cliente");
        getContentPane().add(jLabel1_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 240, 30));

        jLabel_id.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_id.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_id.setText("ID. Cliente");
        getContentPane().add(jLabel_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 200, 20));

        jLabel_Nombres.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombres.setText("Nombre");
        getContentPane().add(jLabel_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 200, 20));

        jText_Nombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(jText_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, 20));

        jLabel_Apellidos.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Apellidos.setText("Apellido");
        getContentPane().add(jLabel_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 200, 20));

        jText_apellido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(jText_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 20));

        jLabel_FechaNac1.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_FechaNac1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FechaNac1.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel_FechaNac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, 20));

        jLabel_Telefono.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Telefono");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 20));

        jText_direccion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jText_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(jText_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 200, 20));

        jLabel_Contraseña.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Contraseña.setText("Direccion:");
        getContentPane().add(jLabel_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 20));

        jLabel_Rol.setFont(new java.awt.Font("Arial Narrow", 0, 12)); // NOI18N
        jLabel_Rol.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Rol.setText("Ciudad:");
        getContentPane().add(jLabel_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 200, 20));

        jText_ciudad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jText_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_ciudadActionPerformed(evt);
            }
        });
        getContentPane().add(jText_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 200, 20));

        jText_telefono.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jText_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(jText_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 200, 20));

        jText_id.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jText_id.setEnabled(false);
        getContentPane().add(jText_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 200, 20));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("@ Licencias Creative Commons ");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 210, -1));

        jTable_envios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_envios.setPreferredSize(new java.awt.Dimension(380, 180));
        jScrollPane1.setViewportView(jTable_envios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 280, 190));

        jButton_registrar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(51, 51, 51));
        jButton_registrar.setText("Registrar Envio");
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 180, -1));

        jButton_actualizar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(51, 51, 51));
        jButton_actualizar.setText("Actualizar Cliente");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 180, -1));

        jButton_eliminar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(51, 51, 51));
        jButton_eliminar.setText("Eliminar Cliente");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 180, -1));

        jButton_empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_empleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_empleadosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_empleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 110, 90));
        getContentPane().add(fechan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, 30));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_direccionActionPerformed

    private void jText_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_ciudadActionPerformed

    private void jText_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_telefonoActionPerformed

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        // TODO add your handling code here:
        Registrar_envio registrar_envio =new Registrar_envio();
        registrar_envio.setVisible(true);
    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        // TODO add your handling code here:
         int  validacion=0;
         
                     
       Date date =fechan.getDate();
       long d =date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
         
       
        
        id= jText_id.getText() .trim();
        nombre= jText_Nombre.getText() .trim();
        apellido=jText_apellido.getText() .trim();
        telefono=jText_telefono.getText() .trim();
        direccion=jText_direccion.getText().trim();
        ciudad= jText_ciudad.getText().trim();
        fecha1=fecha;
      
      
             if (id.equals("")) {
                 jText_id.setBackground(Color.red);
                 validacion++;
               
             }
             if (nombre.equals("")) {
                 jText_Nombre.setBackground(Color.red);
                 validacion++;
             
             }
             if (apellido.equals("")) {
                 jText_apellido.setBackground(Color.red);
                 validacion++;                     
             }
             if (telefono.equals("")) {
                 jText_telefono.setBackground(Color.red);
                 validacion++;                     
             }
             if (direccion.equals("")) {
                 jText_direccion.setBackground(Color.red);
                 validacion++;                     
             }
             if (ciudad.equals("")) {
                 jText_ciudad.setBackground(Color.red);
                 validacion++;                     
             }
             if (validacion==0){
        
       
                 try { 
                     
             Connection cn = conexion.Conectar();
            PreparedStatement pst1 = cn.prepareStatement(
                "select Id_Cliente FROM Cliente where Id_Cliente= '"+ id +"' and not Id_Cliente= '"+ Id +"'");
            ResultSet rs1 = pst1.executeQuery();
            
            if (rs1.next()) {
                jText_id.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                cn.close();
            } else{
                
            
                     Modificar_Cliente();
                        JOptionPane.showMessageDialog(null, "¡¡Actualizacion Correcta!!");
                         this.dispose();
            }
                     
                 } catch (SQLException e) {
                      System.err.println("Error al Actualizar usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar!!, contacte al administrador.");
                 }
                 
         }
             else{
                  JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
             }
      
      
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        // TODO add your handling code here:
        
        
      id= jText_id.getText().trim();
       int respuesta = JOptionPane.showConfirmDialog(null, "desea eliminar id "+ id);
       
       if(respuesta==0){
            
            try { 
                     Borrar_Cliente();
           
                        JOptionPane.showMessageDialog(null, "¡¡Eliminacion Correcta!!");
                         this.dispose();
                       
                         
            }
                     
                  catch (SQLException e) {
                      System.err.println("Error al Eliminar usuario." + e);
                        JOptionPane.showMessageDialog(null, "¡¡ERROR al Eliminar!!, contacte al administrador.");
                 }
           
       }
       
       
        
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_empleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_empleadosActionPerformed
        // TODO add your handling code here:
         Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + jText_Nombre.getText().trim() + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Información del cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

             PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Id_Cliente");
            tabla.addCell("Nombres");
            tabla.addCell("Apellidos");
            tabla.addCell("F_Nacimiento");
            tabla.addCell("Telefono");
            tabla.addCell("Dirección");
            tabla.addCell("Ciudad");

            try {

                Connection cn = conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from cliente where id_cliente = '" + clienteupdate + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {

                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));

                    } while (rs.next());

                    documento.add(tabla);
                }

                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Envios registrados. \n \n");
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                PdfPTable tablaEnvios = new PdfPTable(8);
                tablaEnvios.addCell("ID Envio");
                tablaEnvios.addCell("Tipo");
                tablaEnvios.addCell("Fragilidad");
                tablaEnvios.addCell("F_Envio");
                tablaEnvios.addCell("Destino");
                tablaEnvios.addCell("Dirección");
                tablaEnvios.addCell("Peso lb ");
                tablaEnvios.addCell("Precio");

                try {

                    Connection cn2 = conexion.Conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select Id_Envio, Tipo,Fragilidad,F_envio,C_destino,Direccion,peso,precio from envio where Id_Cliente = '" + clienteupdate + "'");
                    
                    ResultSet rs2 = pst2.executeQuery();
                    
                    if(rs2.next()){
                        do {                            
                            tablaEnvios.addCell(rs2.getString(1));
                            tablaEnvios.addCell(rs2.getString(2));
                            tablaEnvios.addCell(rs2.getString(3));
                            tablaEnvios.addCell(rs2.getString(4));
                            tablaEnvios.addCell(rs2.getString(5));
                            tablaEnvios.addCell(rs2.getString(6));
                            tablaEnvios.addCell(rs2.getString(7));
                            tablaEnvios.addCell(rs2.getString(8));
                            
                        } while (rs2.next());
                        documento.add(tablaEnvios);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al cargar equipos " + e);
                }

            } catch (SQLException e) {
                System.err.print("Error al obtener datos del clientes. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

        } catch (DocumentException | IOException e) {
            System.err.println("Error en PDF o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador");
        }

    }//GEN-LAST:event_jButton_empleadosActionPerformed

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
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacion_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private com.toedter.calendar.JDateChooser fechan;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JButton jButton_empleados;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JLabel jLabel1_titulo;
    private javax.swing.JLabel jLabel_Apellidos;
    private javax.swing.JLabel jLabel_Contraseña;
    private javax.swing.JLabel jLabel_FechaNac1;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Nombres;
    private javax.swing.JLabel jLabel_Rol;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_envios;
    private javax.swing.JTextField jText_Nombre;
    private javax.swing.JTextField jText_apellido;
    private javax.swing.JTextField jText_ciudad;
    private javax.swing.JTextField jText_direccion;
    private javax.swing.JTextField jText_id;
    private javax.swing.JTextField jText_telefono;
    // End of variables declaration//GEN-END:variables

     void Borrar_Cliente() throws SQLException{
         
         cliente cliente1= new cliente (id,null,null,null,null,null,null);
     cliente1.Eliminar_Cliente();
        
    }
    
     void Modificar_Cliente() throws SQLException{
         cliente cliente1 = new cliente(id,nombre,apellido,fecha1,telefono,direccion,ciudad);
         cliente1.Modificar_Cliente();
       
   }
}
