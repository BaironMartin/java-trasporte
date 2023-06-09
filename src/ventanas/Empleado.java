/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.conexion;
import java.sql.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author baironMartin
 */
public class Empleado extends javax.swing.JFrame {

    String user, nombre;
    int secionusuario;
    
    /**
     * Creates new form Empleado
     */
    public Empleado() {
        user =Login.user;
        secionusuario=Administrador.secion_usuario=1;
        
        initComponents();
         setTitle("Empleado secion de id "+user);
        setLocationRelativeTo(null);
        initComponents();
        setSize(550,300);
        setResizable(false);
       
       
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), 
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        
        if(secionusuario==1){
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    else{
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
        
        try {
            Connection cn=conexion.Conectar();
            PreparedStatement pst=cn.prepareStatement(
                "select nombres from empleado where Id_Empleado ='"+ user +"'");
            ResultSet rs =pst.executeQuery();
            if(rs.next()){
                nombre= rs.getString("Nombres");
                jLabel_nombreusuario.setText("bienvenido "+nombre);
            }
            
        } catch (SQLException e) {
            System.err.println("!!Error¡¡");
        }
    
    }
     @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
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

        jLabel_nombreusuario = new javax.swing.JLabel();
        jButton_registrarcliente = new javax.swing.JButton();
        jButton_imprimir = new javax.swing.JButton();
        jButton_gestionarcliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nombreusuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_nombreusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_registrarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_registrarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jButton_gestionarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_gestionarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Imprimir Clientes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 120, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 120, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 120, -1));

        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("@ Licencias Creative Commons ");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 210, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarclienteActionPerformed
        // TODO add your handling code here:
        Registrar_clientes regiaciente = new Registrar_clientes();
        regiaciente .setVisible(true);
    }//GEN-LAST:event_jButton_registrarclienteActionPerformed

    private void jButton_gestionarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarclienteActionPerformed
        // TODO add your handling code here:
        gestionar_cliente gestciente = new gestionar_cliente();
        gestciente .setVisible(true);
    }//GEN-LAST:event_jButton_gestionarclienteActionPerformed

    private void jButton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimirActionPerformed
        // TODO add your handling code here:
        
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListaClientes.pdf"));
            
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de clientes. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            
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
                PreparedStatement pst = cn.prepareStatement("select * from cliente");
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
                
            } catch (SQLException e) {
                System.err.print("Error al generar lista de clientes. " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de clientes creada correctamente.");
            
        } catch (Exception e) {
            System.err.println("Error al generar PDF " + e);
        }
    }//GEN-LAST:event_jButton_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionarcliente;
    private javax.swing.JButton jButton_imprimir;
    private javax.swing.JButton jButton_registrarcliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_nombreusuario;
    // End of variables declaration//GEN-END:variables
}
