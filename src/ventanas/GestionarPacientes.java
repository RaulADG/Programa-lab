/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import static clases.Conexion.conectar;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raula
 */
public class GestionarPacientes extends javax.swing.JFrame {
    
    String user;
    public static int IDpaciente_update = 0;
    DefaultTableModel model = new DefaultTableModel();
    Statement ejecutor = null;
    Connection cn = Conexion.conectar();
     protected void cargarTabla(){
            model.setRowCount(0);
            String datos[]= new String[10];
            String query= "select * from pacientes;";
            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("id_paciente");
               datos[1]=rs.getString("empresa_paciente");
               datos[2]=rs.getString("nombre_paciente");
               datos[3]=rs.getString("apellido_paciente");
               datos[4]=rs.getString("fnacimiento_paciente");
               datos[5]=rs.getString("sexo_paciente");
               datos[6]=rs.getString("mail_paciente");
               datos[7]=rs.getString("tel_paciente");
               datos[8]=rs.getString("dir_paciente");
               datos[9]=rs.getString("ultima_modificacion");
               model.addRow(datos);
              }
               jTable_pacientes.setModel(model);
            } catch (Exception e){
                 
        }       
}      
protected void buscarTablaP(String id_paciente, String empresa_paciente, String nombre_paciente,String apellido_paciente){
            model.setRowCount(0);
            String datos[]= new String[10];
            String where=" where 1=1";
            //Si el id paciente no esta vacio
            if(id_paciente.isEmpty()==false){
               where=where+" and id_paciente='"+id_paciente+"' ";
            }
            //Si la empresa paciente no esta vacio
            if(empresa_paciente.isEmpty()==false){
               where=where+" and empresa_paciente='"+empresa_paciente+"' ";
            }
            //Si el nombre no esta vacio
            if(nombre_paciente.isEmpty()==false){
               where=where+" and nombre_paciente='"+nombre_paciente+"' ";
            }
            //Si el apellido no esta vacio
            if(apellido_paciente.isEmpty()==false){
               where=where+" and apellido_paciente='"+apellido_paciente+"' ";
            }
            String query= "select * from pacientes "+where+" ;";
            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("id_paciente");
               datos[1]=rs.getString("empresa_paciente");
               datos[2]=rs.getString("nombre_paciente");
               datos[3]=rs.getString("apellido_paciente");
               datos[4]=rs.getString("fnacimiento_paciente");
               datos[5]=rs.getString("sexo_paciente");
               datos[6]=rs.getString("mail_paciente");
               datos[7]=rs.getString("tel_paciente");
               datos[8]=rs.getString("dir_paciente");
               datos[9]=rs.getString("ultima_modificacion");
               model.addRow(datos);
              }
               jTable_pacientes.setModel(model);
            } catch (Exception e){
                 
        }             
} 
    /**
     * Creates new form GestionarPacientes
     */
    public GestionarPacientes() {
        initComponents();
        user = Login.user;
        model.addColumn("id_paciente");
        model.addColumn("Empresa");
        model.addColumn("Nombre(s)");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Sexo");
        model.addColumn("Email");
        model.addColumn("Teléfono");
        model.addColumn("Dirección");
        model.addColumn("Modificado por");
        cargarTabla();
        
        setSize(1627, 507);
        setResizable(false);
        setTitle("Pasante - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
     
        
         jTable_pacientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

              if(e.getClickCount()==2){
                 int fila = jTable_pacientes.getSelectedRow();
            
           
                  String IDpaciente_up = jTable_pacientes.getValueAt(fila, 0).toString();
                  IDpaciente_update =Integer.parseInt(IDpaciente_up);
                  Informacion_paciente informacion_paciente = new Informacion_paciente();
                  informacion_paciente.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_pacientes = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Bidpaciente = new javax.swing.JLabel();
        jText_BIdPaciente = new javax.swing.JTextField();
        jLabel_BEmpresa = new javax.swing.JLabel();
        jText_BEmpresa = new javax.swing.JTextField();
        jLabel_BNombres = new javax.swing.JLabel();
        jText_BNombres = new javax.swing.JTextField();
        jLabel_BApellidos = new javax.swing.JLabel();
        jText_BApellidos = new javax.swing.JTextField();
        jButton_Buscar = new javax.swing.JButton();
        jButton_RegistrarP = new javax.swing.JButton();
        jButton_EliminarP = new javax.swing.JButton();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pacientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jTable_pacientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        jTable_pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_paciente", "Empresa", "Nombre(s)", "Apellido", "Fecha de Nacimiento", "Sexo", "Email", "Teléfono", "Dirección", "Modificado por"
            }
        ));
        jTable_pacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable_pacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_pacientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1570, 190));

        jLabel_footer.setText("Creado por DGSystem ®");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        jLabel_Bidpaciente.setText("id paciente");
        getContentPane().add(jLabel_Bidpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jText_BIdPaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jText_BIdPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        jLabel_BEmpresa.setText("Empresa");
        getContentPane().add(jLabel_BEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jText_BEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jText_BEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, 30));

        jLabel_BNombres.setText("Nombre(s)");
        getContentPane().add(jLabel_BNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jText_BNombres.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jText_BNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 130, 30));

        jLabel_BApellidos.setText("Apellido(s)");
        getContentPane().add(jLabel_BApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jText_BApellidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jText_BApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 130, 30));

        jButton_Buscar.setText("Buscar");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 120, 30));

        jButton_RegistrarP.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RegistrarP.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistrarP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarP.setText("Registrar Paciente");
        jButton_RegistrarP.setBorder(null);
        jButton_RegistrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarPActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 210, 35));

        jButton_EliminarP.setBackground(new java.awt.Color(153, 153, 255));
        jButton_EliminarP.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_EliminarP.setForeground(new java.awt.Color(255, 255, 255));
        jButton_EliminarP.setText("Eliminar Paciente");
        jButton_EliminarP.setBorder(null);
        jButton_EliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarPActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_EliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 210, 35));

        jButton_Actualizar.setText("Actualizar tabla");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 120, 30));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
     buscarTablaP(jText_BIdPaciente.getText(), jText_BEmpresa.getText(),jText_BNombres.getText(),jText_BApellidos.getText());        
    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jButton_RegistrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarPActionPerformed
        // TODO add your handling code here:
     
        RegistrarPacientes registrarPacientes = new RegistrarPacientes();
        registrarPacientes.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton_RegistrarPActionPerformed

    private void jButton_EliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarPActionPerformed
        int fila = jTable_pacientes.getSelectedRow();
        String identidad = jTable_pacientes.getValueAt(fila, 0).toString();
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                "delete from pacientes where id_paciente = '"+identidad+"'" );
            pst2.executeUpdate();
            cargarTabla();
        } catch (SQLException e) {
      
        }
           try {
            Connection cn3 = Conexion.conectar();
            PreparedStatement pst3 = cn3.prepareStatement(
                "delete from facturacion where id_paciente = '"+identidad+"'" );
            pst3.executeUpdate();

        } catch (SQLException e) {
          
        }
        try {
            Connection cn4 = Conexion.conectar();
            PreparedStatement pst4 = cn4.prepareStatement(
                "delete from estudios where id_paciente = '"+identidad+"'" );
            pst4.executeUpdate();

        } catch (SQLException e) {
          
        }

    }//GEN-LAST:event_jButton_EliminarPActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_EliminarP;
    private javax.swing.JButton jButton_RegistrarP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_BApellidos;
    private javax.swing.JLabel jLabel_BEmpresa;
    private javax.swing.JLabel jLabel_BNombres;
    private javax.swing.JLabel jLabel_Bidpaciente;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_pacientes;
    private javax.swing.JTextField jText_BApellidos;
    private javax.swing.JTextField jText_BEmpresa;
    private javax.swing.JTextField jText_BIdPaciente;
    private javax.swing.JTextField jText_BNombres;
    // End of variables declaration//GEN-END:variables
}
