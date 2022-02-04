/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import com.itextpdf.layout.property.HorizontalAlignment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarPacientes.IDpaciente_update;
import static ventanas.Informacion_paciente.empresa;



/**
 *
 * @author raula
 */
public class GenerarRecibo extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel(); 
    public static String empresa = "";
    int IDpaciente_update = 0;
    public static int IDestudio = 0;
    String user = "", IDEst="";
    String hour, minutos, ampm;
    Calendar calendario;

    Statement ejecutor = null;
    Connection cn = Conexion.conectar();
     protected void cargarTabla(){
           
            model.setRowCount(0);
            String datos[]= new String[3];
            String query= "select * from estudios where NdeFolio = '"
                                  + IDEst + "'";


            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("id_estudio");
               datos[1]=rs.getString("nombre_estudio");
               datos[2]=rs.getString("costo_estudio");
               model.addRow(datos);
              }
               jTable_Recibos.setModel(model);
            } catch (Exception e){       
              }             
}
protected void buscarTablaE(String NdeFolio){
            model.setRowCount(0);
            String datos[]= new String[3];
            String where=" where 1=1";
            //Si el NdeFolios no esta vacio
            if(NdeFolio.isEmpty()==false){
               where=where+" and NdeFolio='"+NdeFolio+"' ";
            }
            String query= "select * from estudios "+where+" ;";
            ResultSet rs;
            try {
              ejecutor = cn.createStatement();
              ejecutor.setQueryTimeout(20);
              rs = ejecutor.executeQuery(query);

              while(rs.next()==true) {
               datos[0]=rs.getString("id_estudio");
               datos[1]=rs.getString("nombre_estudio");
               datos[2]=rs.getString("costo_estudio");
               model.addRow(datos);
              }
               jTable_Recibos.setModel(model);
            } catch (Exception e){
                 
        }             
}

private void calTol(){
int S=0;
for(int i=0;i<jTable_Recibos.getRowCount();i++){
  S=S+Integer.parseInt(model.getValueAt(i, 2).toString());
}

jText_Total.setText(String.valueOf(S));

}
    /**
     * Creates new form Informacion_paciente
     */
    public GenerarRecibo() {
        initComponents();
 
        user = Login.user;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        IDEst = NfolioRecibo.IDEst;
 
   
            model.addColumn("ID estudio");
            model.addColumn("Estudio");
            model.addColumn("Costo");
        
        cargarTabla(); 
        
        calTol();  
        
        jText_BEstudio.setText(IDEst);
        jText_Anticipo.setText("");
        jText_Anticipo.requestFocus();
        buscarTablaE(jText_BEstudio.getText());
        setSize(918, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
             "select * from pacientes where id_paciente = '" + IDpaciente_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                setTitle("Recibo para el paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente") + " - Sesión de " + user);
                jLabel_Titulo.setText("Recibo para el paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente"));

            }
            cn.close();
             
        } catch (SQLException e) {
            System.err.println("Error al cargar usuario." + e);
            JOptionPane.showMessageDialog(
                null, "¡¡ERROR al cargar!!, contacte al administrador");
        }
        
           try {
          Connection cn = Conexion.conectar();
          PreparedStatement pst = cn.prepareStatement(
                  "select * from pacientes where id_paciente = '" + IDpaciente_update + "'");
          ResultSet rs = pst.executeQuery();
          
          if (rs.next()) {
            txt_empresa.setText(rs.getString("empresa_paciente"));
            txt_nombre.setText(rs.getString("nombre_paciente"));
            txt_apellido.setText(rs.getString("apellido_paciente"));
            txt_edad.setText(rs.getString("edad_paciente"));
            txt_nombremedico.setText(rs.getString("nombredelmedico_paciente"));
            txt_sexo.setText(rs.getString("sexo_paciente"));  
          }
          
          
        } catch (Exception e) {
           System.err.println("Error al consultar el No. de folio");
        }

 try {
          Connection cn0 = Conexion.conectar();
          PreparedStatement pst0 = cn0.prepareStatement(
                  "select * from Recibos where ID_Ndefolio = '" + IDEst + "'");
          ResultSet rs0 = pst0.executeQuery();
          
          if (rs0.next()) {
      
            txt_hora.setText(rs0.getString("Hora"));
            jDateChooser_fecha.setDate(rs0.getDate("Fecha"));
            jDateChooser_fEntrega.setDate(rs0.getDate("Fecha_entrega"));
            jText_Total.setText(rs0.getString("Total"));
            jText_Anticipo.setText(rs0.getString("Anticipo"));
            jText_Saldo.setText(rs0.getString("Saldo"));
          }
          
          
        } catch (Exception e) {
           System.err.println("Error al consultar el No. de folio");
        }
        
       
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
        jScrollPane_estudios = new javax.swing.JScrollPane();
        jTable_Recibos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jText_Total = new javax.swing.JTextField();
        jLabel_Anticipo = new javax.swing.JLabel();
        jText_Anticipo = new javax.swing.JTextField();
        jLabel_Saldo = new javax.swing.JLabel();
        jText_Saldo = new javax.swing.JTextField();
        jDateChooser_fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jText_BEstudio = new javax.swing.JTextField();
        jLabel_empresa = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabel_nombres = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel_apellidos = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel_fechadeentrega = new javax.swing.JLabel();
        jDateChooser_fEntrega = new com.toedter.calendar.JDateChooser();
        jLabel_hora = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jLabel_Ndefolio = new javax.swing.JLabel();
        jLabel_medico = new javax.swing.JLabel();
        txt_nombremedico = new javax.swing.JTextField();
        jLabel_edad = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        jLabel_sexo = new javax.swing.JLabel();
        txt_sexo = new javax.swing.JTextField();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jButton_ActualizarDatos = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Recibo para el paciente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTable_Recibos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){

                return false;

            }
        };
        jTable_Recibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID estudio", "Estudio", "Costo"
            }
        ));
        jScrollPane_estudios.setViewportView(jTable_Recibos);

        getContentPane().add(jScrollPane_estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 870, 220));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Total:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        jText_Total.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jText_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_TotalActionPerformed(evt);
            }
        });
        getContentPane().add(jText_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 170, -1));

        jLabel_Anticipo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_Anticipo.setText("Anticipo:");
        getContentPane().add(jLabel_Anticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, -1, -1));

        jText_Anticipo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jText_Anticipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_Anticipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_AnticipoActionPerformed(evt);
            }
        });
        jText_Anticipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jText_AnticipoKeyReleased(evt);
            }
        });
        getContentPane().add(jText_Anticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 170, -1));

        jLabel_Saldo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_Saldo.setText("Saldo:");
        getContentPane().add(jLabel_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, -1, -1));

        jText_Saldo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jText_Saldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_Saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_SaldoActionPerformed(evt);
            }
        });
        getContentPane().add(jText_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 170, -1));
        getContentPane().add(jDateChooser_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 250, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Fecha de entrega:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jText_BEstudio.setEditable(false);
        jText_BEstudio.setBackground(new java.awt.Color(153, 153, 255));
        jText_BEstudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jText_BEstudio.setForeground(new java.awt.Color(255, 255, 255));
        jText_BEstudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jText_BEstudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jText_BEstudio.setEnabled(false);
        jText_BEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_BEstudioActionPerformed(evt);
            }
        });
        getContentPane().add(jText_BEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, -1));

        jLabel_empresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_empresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_empresa.setText("Empresa:");
        getContentPane().add(jLabel_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        txt_empresa.setBackground(new java.awt.Color(153, 153, 255));
        txt_empresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_empresa.setForeground(new java.awt.Color(255, 255, 255));
        txt_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_empresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 250, -1));

        jLabel_nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombres.setText("Nombre(s):");
        getContentPane().add(jLabel_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 250, -1));

        jLabel_apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_apellidos.setText("Apellidos:");
        getContentPane().add(jLabel_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(153, 153, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, -1));

        jLabel_fechadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fechadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechadeentrega.setText("Fecha");
        getContentPane().add(jLabel_fechadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));
        getContentPane().add(jDateChooser_fEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 250, 26));

        jLabel_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hora.setText("Hora:");
        getContentPane().add(jLabel_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        txt_hora.setBackground(new java.awt.Color(204, 204, 204));
        txt_hora.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 250, -1));

        jLabel_Ndefolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Ndefolio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ndefolio.setText("N. de folio:");
        getContentPane().add(jLabel_Ndefolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel_medico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_medico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_medico.setText("Médico solicitante:");
        getContentPane().add(jLabel_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_nombremedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombremedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombremedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombremedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombremedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, -1));

        jLabel_edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_edad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_edad.setText("Edad:");
        getContentPane().add(jLabel_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        txt_edad.setBackground(new java.awt.Color(153, 153, 255));
        txt_edad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(255, 255, 255));
        txt_edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_edad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 250, -1));

        jLabel_sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sexo.setText("Sexo:");
        getContentPane().add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        txt_sexo.setBackground(new java.awt.Color(153, 153, 255));
        txt_sexo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sexo.setForeground(new java.awt.Color(255, 255, 255));
        txt_sexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sexo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 250, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Recibo");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 130, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 130, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jText_SaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_SaldoActionPerformed
      
    }//GEN-LAST:event_jText_SaldoActionPerformed

    private void jText_AnticipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText_AnticipoKeyReleased
      
      String numero=jText_Anticipo.getText() , Total=jText_Total.getText();

      if(numero.equals("")==false&&numero.matches("[0-9]*")){
         int num=Integer.parseInt(numero);
         int num1=Integer.parseInt(Total);
         int resta = num1-num;
         jText_Saldo.setText(""+resta);
      } else {
         jText_Saldo.setText("...");
      }
    }//GEN-LAST:event_jText_AnticipoKeyReleased

    private void jText_BEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_BEstudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_BEstudioActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed

   int validacion = 0;

            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");

            String NoFolioI, empresaI, nombreI, apellidoI, edadI, sexoI, nombremedicoI,horaI,horaF1I,fechaI,fechaEntregaI, TotalI, AnticipoI, SaldoI;

            Calendar calendar = Calendar.getInstance();
            Calendar calendario = new GregorianCalendar();
            horaF1I = Integer.toString(calendar.get(Calendar.HOUR));
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
            java.util.Date d = new java.util.Date();
            SimpleDateFormat hourtwenty = new SimpleDateFormat("hh:mm");
      

            NoFolioI = jText_BEstudio.getText().trim();
            empresaI = txt_empresa.getText().trim();
            nombreI = txt_nombre.getText().trim();
            apellidoI = txt_apellido.getText().trim();
            edadI = txt_edad.getText().trim();
            sexoI = txt_sexo.getText().trim();
            nombremedicoI = txt_nombremedico.getText().trim();
            horaI = hourtwenty.format(d) + " " + ampm;
            fechaI = dFormat.format(jDateChooser_fecha.getDate());
            fechaEntregaI = dFormat.format(jDateChooser_fEntrega.getDate());
            TotalI = jText_Total.getText().trim();
            AnticipoI = jText_Anticipo.getText().trim();
            SaldoI = jText_Saldo.getText().trim();

            if(NoFolioI.equals("")) {
                jText_BEstudio.setBackground(Color.red);
                validacion++;
            }
            
            if(empresaI.equals("")) {
                txt_empresa.setBackground(Color.red);
                validacion++;
            }
            if(nombreI.equals("")) {
                txt_nombre.setBackground(Color.red);
                validacion++;
            }
            if(apellidoI.equals("")) {
                txt_apellido.setBackground(Color.red);
                validacion++;
            }
            if(edadI.equals("")) {
                txt_edad.setBackground(Color.red);
                validacion++;
            }
            if(nombremedicoI.equals("")) {
                txt_nombremedico.setBackground(Color.red);
                validacion++;
            }
            if(sexoI.equals("")) {
                txt_sexo.setBackground(Color.red);
                validacion++;
            }
            if(horaI.equals("")) {
                txt_hora.setBackground(Color.red);
                validacion++;
            }
            if(TotalI.equals("")) {
                jText_Total.setBackground(Color.red);
                validacion++;
            }
            if(AnticipoI.equals("")) {
                jText_Anticipo.setBackground(Color.red);
                validacion++;
            }
            if(SaldoI.equals("")) {
                jText_Saldo.setBackground(Color.red);
                validacion++;
            }
           

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "insert into Recibos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

                pst.setInt(1, 0);
                pst.setInt(2, IDpaciente_update);
                pst.setString(3, NoFolioI);
                pst.setString(4, empresaI);
                pst.setString(5, nombreI);
                pst.setString(6, apellidoI);
                pst.setString(7, edadI);
                pst.setString(8, sexoI);
                pst.setString(9, nombremedicoI);
                pst.setString(10, horaI);
                pst.setString(11, fechaI);
                pst.setString(12, fechaEntregaI);
                pst.setString(13, TotalI);
                pst.setString(14, AnticipoI);
                pst.setString(15, SaldoI);
                pst.setString(16, user);

                pst.executeUpdate();
                cn.close();

            } catch (SQLException e) {
                System.out.println("Error en registrar datos del recibo." + e);
                JOptionPane.showMessageDialog(null, "ERROR al registrar datos del recibo!!, contacte al programador.");
            } 


        Rectangle pageSize = new Rectangle(PageSize.LETTER);
        Document documento = new Document(pageSize);
        documento.setMargins(28.34f, 28.34f, 28.34f, 0f);

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Recibos/" + "Recibo" + txt_nombre.getText().trim() + " " + txt_apellido.getText() + ".pdf"));

            documento.open();

            com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance("images/LogoT.jpg");
            logo.scaleAbsolute(75, 90);
            logo.setAbsolutePosition(46,681);
            documento.add(logo);

            BaseFont baseFont = BaseFont.createFont("fonts/03812_BaskervilleOldFace.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font fuente =  new Font(baseFont);

            fuente.setColor(105, 0, 105);

            fuente.setStyle(Font.BOLD);
            fuente.setSize(14);
            Paragraph Titulo = new Paragraph("Laboratorios BioSalud", fuente);
            Titulo.setSpacingBefore(3);
            Titulo.setIndentationLeft(230);
            Titulo.setSpacingAfter(-25);
            documento.add(Titulo);

            BaseFont baseFontL = BaseFont.createFont("fonts/monotype-corsiva.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font fuenteL =  new Font(baseFontL);

            fuenteL.setColor(BaseColor.BLACK);

            fuenteL.setStyle(Font.NORMAL);
            fuenteL.setSize(12);
            Paragraph Lema = new Paragraph("“Un diagnóstico oportuno…salva tu vida”", fuenteL);
            Lema.setSpacingBefore(20);
            Lema.setIndentationLeft(204);
            Lema.setSpacingAfter(-25);
            documento.add(Lema);

            BaseFont baseFontL2 = BaseFont.createFont("fonts/comic.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);

            Font fuenteL2 =  new Font(baseFontL2);

            fuenteL2.setColor(BaseColor.BLACK);

            fuenteL2.setStyle(Font.NORMAL);
            fuenteL2.setSize(8);
            Paragraph Lema2 = new Paragraph("Abierto los 365 días del año", fuenteL2);
            Lema2.setSpacingBefore(28);
            Lema2.setIndentationLeft(241);
            Lema2.setSpacingAfter(-25);
            documento.add(Lema2);

            PdfContentByte canvas = writer.getDirectContent();
            CMYKColor magentaColor = new CMYKColor(0.f, 0.f, 0.f, 100.f);
            canvas.setColorStroke(magentaColor);
            canvas.moveTo(129, 701.5);
            canvas.lineTo(557, 701.5);
            canvas.setLineWidth(2.5);
            canvas.closePathStroke();

            float Nfolio = 447, Nfolio1 = 442, Nfolio2 = 436, Nfolio3 = 430, Nfolio4 = 424, Nfolio5 = 419, Nfolio6 = 413;

            Scanner digitos = new Scanner(jText_BEstudio.getText());
            int numE=digitos.nextInt();
            String numeroE = Integer.toString(numE);

            Paragraph parrafo = new Paragraph("No. de folio:", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            parrafo.setSpacingBefore(34);
            parrafo.setSpacingAfter(25);

            Paragraph Ndefolio = new  Paragraph (jText_BEstudio.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            Ndefolio.setSpacingBefore(-40);
            Ndefolio.setSpacingAfter(25);

            if(numeroE.length()==4){
                parrafo.setIndentationLeft(Nfolio);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==5){
                parrafo.setIndentationLeft(Nfolio1);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio1 + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==6){
                parrafo.setIndentationLeft(Nfolio2);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio2 + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==7){
                parrafo.setIndentationLeft(Nfolio3);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio3 + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==8){
                parrafo.setIndentationLeft(Nfolio4);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio4 + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==9){
                parrafo.setIndentationLeft(Nfolio5);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio5 + 60);
                documento.add(Ndefolio);
            }
            if(numeroE.length()==10){
                parrafo.setIndentationLeft(Nfolio6);
                documento.add(parrafo);
                Ndefolio.setIndentationLeft(Nfolio6 + 60);
                documento.add(Ndefolio);
            }

            Paragraph empresa = new  Paragraph (txt_empresa.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            empresa.setSpacingBefore(-15);
            empresa.setIndentationLeft(17);
            empresa.setSpacingAfter(-3);
            documento.add(empresa);

            Paragraph paciente1 = new  Paragraph ("Paciente: ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            paciente1.setSpacingBefore(0);
            paciente1.setIndentationLeft(17);
            paciente1.setSpacingAfter(-3);
            documento.add(paciente1);

            Paragraph paciente = new  Paragraph (txt_nombre.getText() + " " + txt_apellido.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            paciente.setSpacingBefore(-12);
            paciente.setIndentationLeft(67);
            paciente.setSpacingAfter(-3);
            documento.add(paciente);

            Paragraph edad1 = new  Paragraph ("Edad: " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            edad1.setSpacingBefore(0);
            edad1.setIndentationLeft(17);
            edad1.setSpacingAfter(-3);
            documento.add(edad1);

            Paragraph edad = new  Paragraph (txt_edad.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            edad.setSpacingBefore(-12);
            edad.setIndentationLeft(47);
            edad.setSpacingAfter(-3);
            documento.add(edad);

            Paragraph sexo = new  Paragraph ("Sexo: " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            sexo.setSpacingBefore(-12);
            sexo.setIndentationLeft(127);
            sexo.setSpacingAfter(-3);
            documento.add(sexo);

            Paragraph sexo1 = new  Paragraph (txt_sexo.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            sexo1.setSpacingBefore(-12);
            sexo1.setIndentationLeft(157);
            sexo1.setSpacingAfter(-3);
            documento.add(sexo1);

            Paragraph fecha = new  Paragraph ("Fecha: " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            fecha.setSpacingBefore(-12);
            fecha.setIndentationLeft(330);
            fecha.setSpacingAfter(-3);
            documento.add(fecha);

            SimpleDateFormat dFormat0 = new SimpleDateFormat("dd");
            SimpleDateFormat dFormat1 = new SimpleDateFormat("MMMM");
            SimpleDateFormat dFormat2 = new SimpleDateFormat("yyyy");

            Paragraph fecha1 = new  Paragraph (dFormat0.format(jDateChooser_fecha.getDate())+ " de " + dFormat1.format(jDateChooser_fecha.getDate()) + " de " + dFormat2.format(jDateChooser_fecha.getDate())+ "\n"  , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            fecha1.setSpacingBefore(-12);
            fecha1.setIndentationLeft(367);
            fecha1.setSpacingAfter(-3);
            documento.add(fecha1);

            Paragraph medico = new  Paragraph ("Médico solicitante: " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            medico.setSpacingBefore(0);
            medico.setIndentationLeft(17);
            medico.setSpacingAfter(-3);
            documento.add(medico);

            Paragraph nombreMedico = new  Paragraph (txt_nombremedico.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            nombreMedico.setSpacingBefore(-12);
            nombreMedico.setIndentationLeft(111);
            nombreMedico.setSpacingAfter(-3);
            documento.add(nombreMedico);

            Paragraph hora = new  Paragraph ("Hora: ", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            hora.setSpacingBefore(-12);
            hora.setIndentationLeft(330);
            hora.setSpacingAfter(-3);
            documento.add(hora);

            String  hora_estudio;
            Calendar calendar0 = Calendar.getInstance();
            Calendar calendario0 = new GregorianCalendar();

            hora_estudio = Integer.toString(calendar0.get(Calendar.HOUR));
            java.util.Date d1 = new java.util.Date();
            SimpleDateFormat hourtwenty1 = new SimpleDateFormat("hh:mm");
           
             ampm = calendario0.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
           

            Paragraph hora1 = new  Paragraph (hourtwenty1.format(d1) + " "+ ampm+"\n" + "\n" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            hora1.setSpacingBefore(-12);
            hora1.setIndentationLeft(361);
            hora1.setSpacingAfter(-3);
            documento.add(hora1);

            Paragraph estudio = new  Paragraph ("Estudio" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            estudio.setSpacingBefore(10);
            estudio.setIndentationLeft(17);
            estudio.setSpacingAfter(-3);
            documento.add(estudio);

            Paragraph resultado = new  Paragraph ("Precio"  , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            resultado.setSpacingBefore(-13);
            resultado.setIndentationLeft(397);
            resultado.setSpacingAfter(-3);
            documento.add(resultado);

            PdfPTable tabla = new PdfPTable(2);
            tabla.setSpacingBefore(10);            
            tabla.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            tabla.setWidthPercentage((float) 94.5);


            BaseFont bfChinese = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);  
            Font fNormal = new Font(bfChinese, 10, Font.NORMAL);
    
            try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from estudios where NdeFolio = '"
                                  + IDEst + "'");
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
              do {
                  
                 if(rs.getString(6).contains("BH")){
                   PdfPCell Estu = new PdfPCell (new Paragraph ("Biometría Hemática", fNormal));
                   Estu.setBorder(PdfPCell.NO_BORDER);
                   tabla.addCell(Estu);
                 } else {
                    if(rs.getString(6).contains("QS")){
                   PdfPCell Estu = new PdfPCell (new Paragraph ("Química sanguínea", fNormal));
                   Estu.setBorder(PdfPCell.NO_BORDER);
                   tabla.addCell(Estu);
                   } else {
                   PdfPCell Estu = new PdfPCell (new Paragraph (rs.getString(6), fNormal));
                   Estu.setBorder(PdfPCell.NO_BORDER);
                   tabla.addCell(Estu);
                       }
                    } 

                  
                 PdfPCell Costo = new PdfPCell (new Paragraph ("$" + rs.getString(10), fNormal)) ;
                 Costo.setBorder(PdfPCell.NO_BORDER);
                 Costo.setHorizontalAlignment(Element.ALIGN_CENTER);
                 tabla.addCell(Costo);
                  
             
             } while(rs.next());  
                 documento.add(tabla);
            }
            } catch(Exception e) {
            }

            Paragraph FechaE = new  Paragraph ("Fecha de entrega:"  , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
            FechaE.setSpacingBefore(9);
            FechaE.setIndentationLeft(17);
            FechaE.setSpacingAfter(-3);
            documento.add(FechaE);

            SimpleDateFormat dFormat3 = new SimpleDateFormat("dd");
            SimpleDateFormat dFormat4 = new SimpleDateFormat("MMMM");
            SimpleDateFormat dFormat5 = new SimpleDateFormat("yyyy");

            Paragraph fechaE1 = new  Paragraph (dFormat3.format(jDateChooser_fEntrega.getDate())+ " de " + dFormat4.format(jDateChooser_fEntrega.getDate()) + " de " + dFormat5.format(jDateChooser_fEntrega.getDate())+ "\n"  , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
            fechaE1.setSpacingBefore(-12);
            fechaE1.setIndentationLeft(110);
            fechaE1.setSpacingAfter(7);
            documento.add(fechaE1);     

            PdfPTable tablaC = new PdfPTable(2);
            tablaC .setSpacingBefore(10);            
            tablaC .getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            tablaC .setWidthPercentage((float) 94.5);

            BaseFont bfC = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);  
            Font fNormalC = new Font(bfC, 10, Font.NORMAL);

            BaseFont bfCR = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);  
            Font fNormalCR = new Font(bfCR, 10, Font.NORMAL);

            PdfPCell Total = new PdfPCell (new Paragraph ("Total:", fNormalC));
            Total.setBorder(PdfPCell.NO_BORDER);
            tablaC.addCell(Total);

            PdfPCell TotalR = new PdfPCell (new Paragraph ("$"+jText_Total.getText(), fNormalCR)) ;
            TotalR.setBorder(PdfPCell.NO_BORDER);
            TotalR.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaC.addCell(TotalR);

            PdfPCell Anticipo = new PdfPCell (new Paragraph ("Anticipo:", fNormalC));
            Anticipo.setBorder(PdfPCell.NO_BORDER);
            tablaC.addCell(Anticipo);

            PdfPCell AnticipoR = new PdfPCell (new Paragraph ("$"+jText_Anticipo.getText(), fNormalCR)) ;
            AnticipoR.setBorder(PdfPCell.NO_BORDER);
            AnticipoR.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaC.addCell(AnticipoR);

            PdfPCell Saldo = new PdfPCell (new Paragraph ("Saldo:", fNormalC));
            Saldo.setBorder(PdfPCell.NO_BORDER);
            tablaC.addCell(Saldo);

            PdfPCell SaldoR = new PdfPCell (new Paragraph ("$"+jText_Saldo.getText(), fNormalCR)) ;
            SaldoR.setBorder(PdfPCell.NO_BORDER);
            SaldoR.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaC.addCell(SaldoR);

            documento.add(tablaC);
 
        Font dir =  new Font();
    
        dir.setColor(BaseColor.BLACK);
        dir.setFamily("arial");
        dir.setStyle(Font.NORMAL);
        dir.setSize(8);
        Paragraph dirP = new Paragraph("Avenida Coronel Gregorio Méndez Magaña #507, Col. Centro. C.P. 86000. Villahermosa, Tabasco.", dir);
        dirP.setSpacingBefore((float) 7);
        dirP.setIndentationLeft(107);
        dirP.setSpacingAfter(-1);
        documento.add(dirP);    
        

        Font telT =  new Font();
    
        telT.setColor(new BaseColor(105, 0, 105));
        telT.setFamily("arial");
        telT.setStyle(Font.NORMAL);
        telT.setSize(9);
        Paragraph telPT = new Paragraph("Télefono:", telT);
        telPT.setSpacingBefore(0);
        telPT.setIndentationLeft(60);
        telPT.setSpacingAfter(-13);
        documento.add(telPT);
        
        
        Font tel =  new Font();
    
        tel.setColor(BaseColor.BLACK);
        tel.setFamily("arial");
        tel.setStyle(Font.NORMAL);
        tel.setSize(9);
        Paragraph telP = new Paragraph("(933) 3656540", tel);
        telP.setSpacingBefore(0);
        telP.setIndentationLeft(101);
        telP.setSpacingAfter(-3);
        documento.add(telP);
           
        Font numT =  new Font();
    
        numT.setColor(new BaseColor(105, 0, 105));
        numT.setFamily("arial");
        numT.setStyle(Font.NORMAL);
        numT.setSize(9);
        Paragraph numTT = new Paragraph("WhatsApp:", numT);
        numTT.setSpacingBefore((float) -10.5);
        numTT.setIndentationLeft(210);
        numTT.setSpacingAfter(-13);
        documento.add(numTT);

        Font num =  new Font();
    
        num.setColor(BaseColor.BLACK);
        num.setFamily("arial");
        num.setStyle(Font.NORMAL);
        num.setSize(9);
        Paragraph numP = new Paragraph("9934447673", num);
        numP.setSpacingBefore((float) 0);
        numP.setIndentationLeft(259);
        numP.setSpacingAfter(0);
        documento.add(numP);
        
        Font correoT =  new Font();
    
        correoT.setColor(new BaseColor(105, 0, 105));
        correoT.setFamily("arial");
        correoT.setStyle(Font.NORMAL);
        correoT.setSize(9);
        Paragraph correoTT = new Paragraph("Correo:", correoT);
        correoTT.setSpacingBefore((float) -14);
        correoTT.setIndentationLeft(350);
        correoTT.setSpacingAfter(-12);
        documento.add(correoTT);
        
        Font correo =  new Font();
    
        correo.setColor(BaseColor.BLACK);
        correo.setFamily("arial");
        correo.setStyle(Font.NORMAL);
        correo.setSize(8);
        Paragraph correoP = new Paragraph("laboratoriosbiosalud@hotmail.com", correo);
        correoP.setSpacingBefore(0);
        correoP.setIndentationLeft(385);
        correoP.setSpacingAfter(0);
        documento.add(correoP);
        
        
        Font pag =  new Font();
    
        pag.setColor(BaseColor.BLACK);
        pag.setFamily("arial");
        pag.setStyle(Font.NORMAL);
        pag.setSize(8);
        Paragraph pagP = new Paragraph("www.laboratoriosbiosalud.com.mx", pag);
        pagP.setSpacingBefore(0);
        pagP.setIndentationLeft(120);
        pagP.setSpacingAfter((float) -12);
        documento.add(pagP);
        
        
        Font face =  new Font();
    
        face.setColor(BaseColor.BLACK);
        face.setFamily("arial");
        face.setStyle(Font.NORMAL);
        face.setSize(8);
        Paragraph faceP = new Paragraph("www.facebook.com/LaboratoriosBioSalud", face);
        faceP.setSpacingBefore(0);
        faceP.setIndentationLeft(270);
        faceP.setSpacingAfter(0);
        documento.add(faceP); 
        

            documento.close();
            JOptionPane.showMessageDialog(null, "Recibo guardado y creado correctamente.");

        } catch (DocumentException | IOException e){
            System.err.println("Error en generar documento. " + e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al programador.");
        }

 
       String horaA;
      Calendar calendarioA = new GregorianCalendar();
      ampm = calendarioA.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
      java.util.Date d0 = new java.util.Date();
      SimpleDateFormat hourtwenty0 = new SimpleDateFormat("hh:mm");

      
      horaA =  hourtwenty0.format(d0)+ " "+ ampm;

       try {
            
             Connection cnA = Conexion.conectar();
             PreparedStatement pstA = cnA.prepareStatement(
                     "update Recibos set Hora=?, ultima_modificacion=?"
                    + "where ID_Ndefolio = '" + IDEst + "'");

             pstA.setString(1, horaA);
             pstA.setString(2, user);
             pstA.executeUpdate();
             cnA.close();
             
       
         } catch (SQLException e) {
          
         }

  try {
          Connection cn0 = Conexion.conectar();
          PreparedStatement pst0 = cn0.prepareStatement(
                  "select * from Recibos where ID_Ndefolio = '" + IDEst + "'");
          ResultSet rs0 = pst0.executeQuery();
          
          if (rs0.next()) {
            txt_hora.setText(rs0.getString("Hora"));
            jDateChooser_fecha.setDate(rs0.getDate("Fecha"));
            jDateChooser_fEntrega.setDate(rs0.getDate("Fecha_entrega"));
            jText_Total.setText(rs0.getString("Total"));
            jText_Anticipo.setText(rs0.getString("Anticipo"));
            jText_Saldo.setText(rs0.getString("Saldo"));
          }
          
          
        } catch (Exception e) {
           System.err.println("Error al consultar el No. de folio");
        }
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

    private void jButton_ActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarDatosActionPerformed
 int validacion = 0;

            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");

            String horaI,horaF1I,fechaI,fechaEntregaI, TotalI, AnticipoI, SaldoI;

            Calendar calendar = Calendar.getInstance();
            Calendar calendario = new GregorianCalendar();
            horaF1I = Integer.toString(calendar.get(Calendar.HOUR));
            ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
            java.util.Date d = new java.util.Date();
            SimpleDateFormat hourtwenty = new SimpleDateFormat("hh:mm");
        
            horaI = hourtwenty.format(d) + " "+ ampm;
        
            fechaI = dFormat.format(jDateChooser_fecha.getDate());
            fechaEntregaI = dFormat.format(jDateChooser_fEntrega.getDate());
            TotalI = jText_Total.getText().trim();
            AnticipoI = jText_Anticipo.getText().trim();
            SaldoI = jText_Saldo.getText().trim();


            if(horaI.equals("")) {
                txt_hora.setBackground(Color.red);
                validacion++;
            }
            if(TotalI.equals("")) {
                jText_Total.setBackground(Color.red);
                validacion++;
            }
            if(AnticipoI.equals("")) {
                jText_Anticipo.setBackground(Color.red);
                validacion++;
            }
            if(SaldoI.equals("")) {
                jText_Saldo.setBackground(Color.red);
                validacion++;
            }
           
            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "update Recibos set Hora=?, Fecha=?, Fecha_entrega=?, Total=?, Anticipo=?, Saldo=?, ultima_modificacion=?"
                    + "where ID_Ndefolio = '" + IDEst + "'");

                pst.setString(1, horaI);
                pst.setString(2, fechaI);
                pst.setString(3, fechaEntregaI);
                pst.setString(4, TotalI);
                pst.setString(5, AnticipoI);
                pst.setString(6, SaldoI);
                pst.setString(7, user);

                pst.executeUpdate();
                cn.close();



                JOptionPane.showMessageDialog(null, "Registro exitoso.");

            } catch (SQLException e) {
                System.out.println("Error en registrar datos del estudio." + e);
                JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
            }

 try {
          Connection cn0 = Conexion.conectar();
          PreparedStatement pst0 = cn0.prepareStatement(
                  "select * from Recibos where ID_Ndefolio = '" + IDEst + "'");
          ResultSet rs0 = pst0.executeQuery();
          
          if (rs0.next()) {
            txt_hora.setText(rs0.getString("Hora"));
            jDateChooser_fecha.setDate(rs0.getDate("Fecha"));
            jDateChooser_fEntrega.setDate(rs0.getDate("Fecha_entrega"));
            jText_Total.setText(rs0.getString("Total"));
            jText_Anticipo.setText(rs0.getString("Anticipo"));
            jText_Saldo.setText(rs0.getString("Saldo"));
          }
          
          
        } catch (Exception e) {
           System.err.println("Error al consultar el No. de folio");
        }
        

      

    }//GEN-LAST:event_jButton_ActualizarDatosActionPerformed

    private void jText_AnticipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_AnticipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_AnticipoActionPerformed

    private void jText_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText_TotalActionPerformed

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
            java.util.logging.Logger.getLogger(GenerarRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarRecibo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarDatos;
    private javax.swing.JButton jButton_ImprimirReporte;
    private com.toedter.calendar.JDateChooser jDateChooser_fEntrega;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Anticipo;
    private javax.swing.JLabel jLabel_Ndefolio;
    private javax.swing.JLabel jLabel_Saldo;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_edad;
    private javax.swing.JLabel jLabel_empresa;
    private javax.swing.JLabel jLabel_fechadeentrega;
    private javax.swing.JLabel jLabel_hora;
    private javax.swing.JLabel jLabel_medico;
    private javax.swing.JLabel jLabel_nombres;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JScrollPane jScrollPane_estudios;
    private javax.swing.JTable jTable_Recibos;
    private javax.swing.JTextField jText_Anticipo;
    private javax.swing.JTextField jText_BEstudio;
    private javax.swing.JTextField jText_Saldo;
    private javax.swing.JTextField jText_Total;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_sexo;
    // End of variables declaration//GEN-END:variables

 
   

}
