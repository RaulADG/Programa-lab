/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarPacientes.IDpaciente_update;
import static ventanas.Informacion_paciente.empresa;



/**
 *
 * @author raula
 */
public class RegistrodeRecibos extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(); 
    public static String empresa = "",IDEst="";
    int IDpaciente_update = 0;
    public static int IDestudio = 0, IDEst1 = 0;
    String user = "";
  

       Statement ejecutor = null;
    Connection cn = Conexion.conectar();
     protected void cargarTabla(){
           
            model.setRowCount(0);
            String datos[]= new String[6];
            String query= "select * from Recibos where id_paciente = '"
                                  + IDpaciente_update + "'";


            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("ID_NRecibo");
               datos[1]=rs.getString("ID_Ndefolio");
               datos[2]=rs.getString("Total");
               datos[3]=rs.getString("Anticipo");
               datos[4]=rs.getString("Saldo");
               datos[5]=rs.getString("ultima_modificacion");
               model.addRow(datos);
              }
               jTable_recibos.setModel(model);
            } catch (Exception e){       
              }             
}
protected void buscarTablaE(String NdeFolio){
            model.setRowCount(0);
            String datos[]= new String[6];
            String where=" where 1=1";
            //Si el NdeFolios no esta vacio
            if(NdeFolio.isEmpty()==false){
               where=where+" and ID_Ndefolio='"+NdeFolio+"' ";
            }
            
            String query= "select * from Recibos "+where+" ;";
            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("ID_NRecibo");
               datos[1]=rs.getString("ID_Ndefolio");
               datos[2]=rs.getString("Total");
               datos[3]=rs.getString("Anticipo");
               datos[4]=rs.getString("Saldo");
               datos[5]=rs.getString("ultima_modificacion");
               model.addRow(datos);
              }
               jTable_recibos.setModel(model);
            } catch (Exception e){
                 
        }             
}

    /**
     * Creates new form Informacion_paciente
     */
    public RegistrodeRecibos() {
        initComponents();
 
        user = Login.user;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
       
            model.addColumn("ID Recibo");
            model.addColumn("N. de folio");
            model.addColumn("Total");
            model.addColumn("Anticipo");
            model.addColumn("Saldo");
            model.addColumn("ultima_modificacion");

        cargarTabla();
        setSize(1000, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
        try {
          
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
             "select * from pacientes where id_paciente = '" + IDpaciente_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                setTitle("Estudios del paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente") + " - Sesión de " + user);
                jLabel_Titulo.setText("Estudios del Paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente"));
                
                
           
            }
            cn.close();
             
        } catch (SQLException e) {
            System.err.println("Error al cargar usuario." + e);
            JOptionPane.showMessageDialog(
                null, "¡¡ERROR al cargar!!, contacte al administrador");
        }
        
            jTable_recibos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

              if(e.getClickCount()==2){
                 int fila = jTable_recibos.getSelectedRow();
            
           
                  String IDestudio_up = jTable_recibos.getValueAt(fila, 1).toString();
                  IDEst1 = Integer.parseInt(IDestudio_up);;
                  GenerarRecibo1 generarRecibo1 = new GenerarRecibo1();
                  generarRecibo1.setVisible(true);
                  dispose(); 
 
            }}
        });
         
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
        jButton_Registrar = new javax.swing.JButton();
        jScrollPane_estudios = new javax.swing.JScrollPane();
        jTable_recibos = new javax.swing.JTable();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel_BNEstudio = new javax.swing.JLabel();
        jText_BEstudio = new javax.swing.JTextField();
        jButton_Buscar = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Estudios del Paciente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

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
        getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 210, 35));

        jTable_recibos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        jTable_recibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID estudio", "N. de folio", "Total", "Anticipo", "Saldo", "ultima_modificacion"
            }
        ));
        jScrollPane_estudios.setViewportView(jTable_recibos);

        getContentPane().add(jScrollPane_estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 870, 440));

        jButton_Eliminar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Eliminar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.setBorder(null);
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 210, 35));

        jLabel_BNEstudio.setText("N. de folio");
        getContentPane().add(jLabel_BNEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jText_BEstudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jText_BEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 130, 30));

        jButton_Buscar.setText("Buscar");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 120, 30));

        jButton_Actualizar.setText("Actualizar tabla");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 120, 30));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarActionPerformed
        // TODO add your handling code here:
 
        NfolioRecibo nfolioRecibo = new NfolioRecibo();
        nfolioRecibo.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton_RegistrarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        int fila = jTable_recibos.getSelectedRow();
        String identidad = jTable_recibos.getValueAt(fila, 0).toString();
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                "delete from Recibos where ID_NRecibo = '"+identidad+"'" );
            pst2.executeUpdate();
            cargarTabla();
        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla estudios");
        }

       
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
     buscarTablaE(jText_BEstudio.getText());
    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        
            cargarTabla();
       
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrodeRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrodeRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrodeRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrodeRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrodeRecibos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JLabel jLabel_BNEstudio;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane_estudios;
    private javax.swing.JTable jTable_recibos;
    private javax.swing.JTextField jText_BEstudio;
    // End of variables declaration//GEN-END:variables

 
   

}
