/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author raula
 */
public class RegistrarEstudio1 extends javax.swing.JFrame {

int IDpaciente_update = 0;
String user = "", nom_paciente = "";
private TextAutoCompleter ac;
    
    /**
     * Creates new form RegistrarEstudio
     */
    public RegistrarEstudio1() {
        initComponents();
        user = Login.user;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        
        Estudio estudio = new Estudio();
        txt_nombredelestudio.setText(estudio.estudio);
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_paciente from pacientes where id_paciente = '" + IDpaciente_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                nom_paciente = rs.getString("nombre_paciente");
            }
            
        } catch (SQLException e) {
           System.err.println("Error al consultar el nombre del paciente");
        }     
        
        setTitle("Registrar nuevo estudio para " + nom_paciente); 
        setSize(830, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Carga viral HBV
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_clavedelestudio.setText("PHB2");   
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_costo.setText("$4175");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           jTextPane_indicaciones.setText("Con EDTA 3 mL.  Enviar congelado en tubo de plástico estéril. ");
        }
        
        //Carga viral HCV
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_clavedelestudio.setText("5200");   
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_tipodeestudio.setText("Tubo rosa");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_costo.setText("$2000");
        }
        
        //CD4 y CD8
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_clavedelestudio.setText("5200");   
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_tipodeestudio.setText("Tubo rosa");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_costo.setText("$2000");
        }
        
         //CD4 y CD8
        if(txt_nombredelestudio.getText().equals("CD4 y CD8" )){
           txt_clavedelestudio.setText("5200");   
          
        
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_tipodeestudio.setText("Tubo rosa");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_costo.setText("$2000");
        }
        
        //Carga viral VIH
         if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_clavedelestudio.setText("5200");   
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_tipodeestudio.setText("Tubo rosa");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_costo.setText("$2000");
        }
        
        
        TextAutoCompleter textAutoAcomplter = new TextAutoCompleter(txt_nombredelestudio);
        textAutoAcomplter.addItem("Carga viral HBV");
        textAutoAcomplter.addItem("Carga viral HCV");
        textAutoAcomplter.addItem("Carga viral VIH");
        textAutoAcomplter.addItem("CD4 y CD8");
        textAutoAcomplter.addItem("FTA-ABS");
        textAutoAcomplter.addItem("HLA A, B,C DQ, DR (Baja resolución)");
        textAutoAcomplter.setMode(0); // infijo
        
              ImageIcon wallpaper = new ImageIcon("src/images/Fondo.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(),Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }

      @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Logo1.jpg"));
      
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

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_clavedelestudio = new javax.swing.JLabel();
        txt_clavedelestudio = new javax.swing.JTextField();
        jLabel_nombredelestudio = new javax.swing.JLabel();
        txt_nombredelestudio = new javax.swing.JTextField();
        jLabel_diadeentrega = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_indicaciones = new javax.swing.JTextPane();
        jLabel_tipodeestudio = new javax.swing.JLabel();
        txt_tipodeestudio = new javax.swing.JTextField();
        jLabel_costo = new javax.swing.JLabel();
        txt_costo = new javax.swing.JTextField();
        jLabel_indicaciones = new javax.swing.JLabel();
        jButton_Registrar = new javax.swing.JButton();
        txt_diadeentrega = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Registro de estudio");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel_clavedelestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_clavedelestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_clavedelestudio.setText("Clave del estudio:");
        getContentPane().add(jLabel_clavedelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_clavedelestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_clavedelestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_clavedelestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_clavedelestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clavedelestudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_clavedelestudio.setEnabled(false);
        txt_clavedelestudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clavedelestudioActionPerformed(evt);
            }
        });
        txt_clavedelestudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_clavedelestudioKeyReleased(evt);
            }
        });
        getContentPane().add(txt_clavedelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel_nombredelestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombredelestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombredelestudio.setText("Nombre del estudio:");
        getContentPane().add(jLabel_nombredelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_nombredelestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombredelestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombredelestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombredelestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombredelestudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombredelestudio.setEnabled(false);
        txt_nombredelestudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombredelestudioActionPerformed(evt);
            }
        });
        txt_nombredelestudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombredelestudioKeyReleased(evt);
            }
        });
        getContentPane().add(txt_nombredelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel_diadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_diadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_diadeentrega.setText("Dia de entrega:");
        getContentPane().add(jLabel_diadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jTextPane_indicaciones.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane_indicaciones.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextPane_indicaciones.setEnabled(false);
        jScrollPane1.setViewportView(jTextPane_indicaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 490, 190));

        jLabel_tipodeestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_tipodeestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tipodeestudio.setText("Tipo de muestra:");
        getContentPane().add(jLabel_tipodeestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txt_tipodeestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_tipodeestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tipodeestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_tipodeestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipodeestudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_tipodeestudio.setEnabled(false);
        getContentPane().add(txt_tipodeestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, -1));

        jLabel_costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_costo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_costo.setText("Costo:");
        getContentPane().add(jLabel_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txt_costo.setBackground(new java.awt.Color(153, 153, 255));
        txt_costo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_costo.setForeground(new java.awt.Color(255, 255, 255));
        txt_costo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_costo.setEnabled(false);
        getContentPane().add(txt_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, -1));

        jLabel_indicaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_indicaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_indicaciones.setText("Indicaciones:");
        getContentPane().add(jLabel_indicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jButton_Registrar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar.setText("Registrar Estudio");
        jButton_Registrar.setBorder(null);
        jButton_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 210, 35));

        txt_diadeentrega.setBackground(new java.awt.Color(153, 153, 255));
        txt_diadeentrega.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_diadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        txt_diadeentrega.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_diadeentrega.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_diadeentrega.setEnabled(false);
        getContentPane().add(txt_diadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombredelestudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombredelestudioActionPerformed

    }//GEN-LAST:event_txt_nombredelestudioActionPerformed

    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarActionPerformed
        
   
        int validacion = 0;
        String  clave_estudio, nombre_estudio, dia_entrega, tipo_muestra, costo_estudio, indicaciones_estudio, estatus, dia_registrado, mes_registrado, annio_registrado; 
        
        clave_estudio = txt_clavedelestudio.getText().trim();
        nombre_estudio = txt_nombredelestudio.getText().trim();
        dia_entrega = txt_diadeentrega.getText().trim();
        tipo_muestra = txt_tipodeestudio.getText().trim();
        costo_estudio = txt_costo.getText().trim();
        indicaciones_estudio = jTextPane_indicaciones.getText();
        estatus = "En proceso";
        
        Calendar calendar = Calendar.getInstance();
        
        dia_registrado = Integer.toString(calendar.get(Calendar.DATE));
        mes_registrado = Integer.toString(calendar.get(Calendar.MONTH));
        annio_registrado = Integer.toString(calendar.get(Calendar.YEAR));
        
        if(clave_estudio.equals("")){
           txt_clavedelestudio.setBackground(Color.red);
           validacion++;
        }
        if(nombre_estudio.equals("")){
           txt_nombredelestudio.setBackground(Color.red);
           validacion++;
        }
        
        if(dia_entrega.equals("")){
           txt_diadeentrega.setBackground(Color.red);
           validacion++;
        }
        if(tipo_muestra.equals("")){
           txt_tipodeestudio.setBackground(Color.red);
           validacion++;
        }
        if(costo_estudio.equals("")){
           txt_costo.setBackground(Color.red);
           validacion++;
        }
        if(indicaciones_estudio.equals("")){
           jTextPane_indicaciones.setText("Sin indicaciones");
           indicaciones_estudio = "Sin indicaciones";
        }
   
        String clave;
        clave = txt_clavedelestudio.getText();
        
        if(clave.equals("1200")){
           txt_nombredelestudio.setText("Clave");
        }
        
             
        if (validacion == 0) {
            
            try {
            
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into estudios values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                
                pst.setInt(1, 0);
                pst.setString(2, clave_estudio);
                pst.setInt(3, IDpaciente_update);
                pst.setString(4, nombre_estudio);
                pst.setString(5, dia_entrega);
                pst.setString(6, indicaciones_estudio);
                pst.setString(7, tipo_muestra);
                pst.setString(8, costo_estudio);
                pst.setString(9, dia_registrado);
                pst.setString(10, mes_registrado);
                pst.setString(11, annio_registrado);
                pst.setString(12, estatus);
                pst.setString(13, user);
                
                pst.executeUpdate();
                cn.close();
                
                txt_clavedelestudio.setBackground(Color.green);
                txt_nombredelestudio.setBackground(Color.green);
                txt_diadeentrega.setBackground(Color.green);
                txt_tipodeestudio.setBackground(Color.green);
                txt_costo.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                
                this.dispose();
                
                Informacion_paciente informacion_paciente = new Informacion_paciente();
                  informacion_paciente.setVisible(true);
                
            } catch (SQLException e){
               System.err.println("Error en registrar estudio. " + e);
               JOptionPane.showMessageDialog(null, "¡¡ERROR al registrar estudio!!, contacte al programador.");
            }
                         
        } else {
           JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
        }
             
    }//GEN-LAST:event_jButton_RegistrarActionPerformed

    private void txt_clavedelestudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clavedelestudioActionPerformed

    }//GEN-LAST:event_txt_clavedelestudioActionPerformed

    private void txt_nombredelestudioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombredelestudioKeyReleased

    }//GEN-LAST:event_txt_nombredelestudioKeyReleased

    private void txt_clavedelestudioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clavedelestudioKeyReleased

    }//GEN-LAST:event_txt_clavedelestudioKeyReleased

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
            java.util.logging.Logger.getLogger(RegistrarEstudio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEstudio1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_clavedelestudio;
    private javax.swing.JLabel jLabel_costo;
    private javax.swing.JLabel jLabel_diadeentrega;
    private javax.swing.JLabel jLabel_indicaciones;
    private javax.swing.JLabel jLabel_nombredelestudio;
    private javax.swing.JLabel jLabel_tipodeestudio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_clavedelestudio;
    private javax.swing.JTextField txt_costo;
    private javax.swing.JTextField txt_diadeentrega;
    private javax.swing.JTextField txt_nombredelestudio;
    private javax.swing.JTextField txt_tipodeestudio;
    // End of variables declaration//GEN-END:variables
}
