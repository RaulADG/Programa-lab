/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import javax.swing.WindowConstants;

import clases.Conexion;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
/**
 *
 * @author raula
 */
public class TPyTTP extends javax.swing.JFrame {

   
int IDpaciente_update = 0, IDestudio = 0, IEstudio =0;
String user = "", nom_paciente = "";
 String minutos, ampm;
 Calendar calendario;
    /**
     * Creates new form CargaViralA
     */
    public TPyTTP() {
        initComponents();
        user = Login.user;
        IDestudio = Estudio_paciente.IDestudio;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        IEstudio = InformacionEstudio.IEstudio;
   
         try {
          Connection cn = Conexion.conectar();
          PreparedStatement pst = cn.prepareStatement(
                  "select nombre_paciente from pacientes where id_paciente = '" + IDpaciente_update + "'");
          ResultSet rs = pst.executeQuery();
          
          if(rs.next()){
            nom_paciente = rs.getString("nombre_paciente");
          }
          
        } catch (Exception e) {
            System.err.println("Error al consultar el nombre del paciente");
        }
        
         try {
          Connection cn = Conexion.conectar();
          PreparedStatement pst = cn.prepareStatement(
                  "select * from estudios where id_estudio = '" + IDestudio + "'");
          ResultSet rs = pst.executeQuery();
          
          if (rs.next()) {
            
              setTitle("Formulario para estudio " + rs.getString("nombre_estudio")  + " - Sesión de " + user);
                jLabel_Titulo.setText("Formulario para estudio " + rs.getString("nombre_estudio"));
              
              
            txt_NoFolio.setText(rs.getString("NdeFolio"));
            txt_claveEstudio.setText(rs.getString("clave_estudio"));
           
          }
              
        } catch (Exception e) {
           System.err.println("Error al consultar el No. de folio");
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
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from TPyTTP where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            jTextPane_indicaciones.setText(rs2.getString("Observaciones"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
            txt_TP.setText(rs2.getString("TP"));
            txt_INR.setText(rs2.getString("INR"));
            txt_TTP.setText(rs2.getString("TTP"));
   
          }
           
        } catch (SQLException e) {
         System.err.println("Error al consultar la información del estudio");
        }
  
        setSize(673, 941);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       
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
        jLabel_NoFolio = new javax.swing.JLabel();
        txt_NoFolio = new javax.swing.JTextField();
        jLabel_empresa = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabe_claveEstudio = new javax.swing.JLabel();
        txt_claveEstudio = new javax.swing.JTextField();
        jLabel_nombres = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel_apellidos = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel_edad = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        jLabel_medico = new javax.swing.JLabel();
        txt_nombremedico = new javax.swing.JTextField();
        jLabel_sexo = new javax.swing.JLabel();
        txt_sexo = new javax.swing.JTextField();
        jLabel_fechadeentrega = new javax.swing.JLabel();
        jLabel_hora = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_indicaciones = new javax.swing.JTextPane();
        jLabel_indicaciones = new javax.swing.JLabel();
        jButton_GuardarDatos = new javax.swing.JButton();
        jDateChooser_fnacimiento = new com.toedter.calendar.JDateChooser();
        txt_Reporte = new javax.swing.JTextField();
        jLabel_Datos = new javax.swing.JLabel();
        jButton_ActualizarDatos = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jLabel_ValoresdeResultado = new javax.swing.JLabel();
        jLabel_Logaritmo = new javax.swing.JLabel();
        txt_INR = new javax.swing.JTextField();
        jLabel_CopiasmL = new javax.swing.JLabel();
        jCheckBox_firma = new javax.swing.JCheckBox();
        jLabel_CTCD3 = new javax.swing.JLabel();
        jLabel_Logaritmo2 = new javax.swing.JLabel();
        jLabel_CTCD5 = new javax.swing.JLabel();
        txt_TTP = new javax.swing.JTextField();
        jLabel_Logaritmo3 = new javax.swing.JLabel();
        txt_TP = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Creación de Reporte");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_NoFolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_NoFolio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NoFolio.setText("No. de folio:");
        getContentPane().add(jLabel_NoFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_NoFolio.setBackground(new java.awt.Color(153, 153, 255));
        txt_NoFolio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NoFolio.setForeground(new java.awt.Color(255, 255, 255));
        txt_NoFolio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NoFolio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NoFolio.setEnabled(false);
        txt_NoFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NoFolioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_NoFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 250, -1));

        jLabel_empresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_empresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_empresa.setText("Empresa:");
        getContentPane().add(jLabel_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_empresa.setBackground(new java.awt.Color(153, 153, 255));
        txt_empresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_empresa.setForeground(new java.awt.Color(255, 255, 255));
        txt_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_empresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, -1));

        jLabe_claveEstudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabe_claveEstudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabe_claveEstudio.setText("Clave de estudio:");
        getContentPane().add(jLabe_claveEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_claveEstudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_claveEstudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_claveEstudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_claveEstudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_claveEstudio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_claveEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveEstudioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_claveEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, -1));

        jLabel_nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombres.setText("Nombre(s):");
        getContentPane().add(jLabel_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

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
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 250, -1));

        jLabel_apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_apellidos.setText("Apellidos:");
        getContentPane().add(jLabel_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(153, 153, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 250, -1));

        jLabel_edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_edad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_edad.setText("Edad:");
        getContentPane().add(jLabel_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        txt_edad.setBackground(new java.awt.Color(153, 153, 255));
        txt_edad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(255, 255, 255));
        txt_edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_edad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 250, -1));

        jLabel_medico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_medico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_medico.setText("Médico solicitante:");
        getContentPane().add(jLabel_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        txt_nombremedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombremedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombremedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombremedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombremedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 330, -1));

        jLabel_sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sexo.setText("Sexo:");
        getContentPane().add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        txt_sexo.setBackground(new java.awt.Color(153, 153, 255));
        txt_sexo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sexo.setForeground(new java.awt.Color(255, 255, 255));
        txt_sexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sexo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 250, -1));

        jLabel_fechadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fechadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechadeentrega.setText("Fecha de entrega:");
        getContentPane().add(jLabel_fechadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hora.setText("Hora:");
        getContentPane().add(jLabel_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        txt_hora.setBackground(new java.awt.Color(153, 153, 255));
        txt_hora.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 250, -1));

        jScrollPane1.setViewportView(jTextPane_indicaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 630, 190));

        jLabel_indicaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_indicaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_indicaciones.setText("Observaciones:");
        getContentPane().add(jLabel_indicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jButton_GuardarDatos.setText("Guardar Datos");
        jButton_GuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 770, 130, -1));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 250, 26));

        txt_Reporte.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reporte.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reporte.setText("No");
        txt_Reporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 825, 210, -1));

        jLabel_Datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Datos.setText("Datos guardados:");
        getContentPane().add(jLabel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 830, -1, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 770, 130, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Reporte");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 770, 130, -1));

        jLabel_ValoresdeResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado.setText("Valores de resultado:");
        getContentPane().add(jLabel_ValoresdeResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jLabel_Logaritmo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Logaritmo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Logaritmo.setText("Tiempo de protrombina (TP)");
        getContentPane().add(jLabel_Logaritmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 635, -1, -1));

        txt_INR.setBackground(new java.awt.Color(153, 153, 255));
        txt_INR.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_INR.setForeground(new java.awt.Color(255, 255, 255));
        txt_INR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_INR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_INR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 210, -1));

        jLabel_CopiasmL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CopiasmL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CopiasmL.setText("I.N.R.");
        getContentPane().add(jLabel_CopiasmL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jCheckBox_firma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox_firma.setText("Incluir firma");
        jCheckBox_firma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_firmaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_firma, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 870, -1, -1));

        jLabel_CTCD3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD3.setText("Método: Coagulometría");
        getContentPane().add(jLabel_CTCD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 665, -1, -1));

        jLabel_Logaritmo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Logaritmo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Logaritmo2.setText("parcial activada (TTP)");
        getContentPane().add(jLabel_Logaritmo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 715, -1, -1));

        jLabel_CTCD5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD5.setText("Método: Coagulometría");
        getContentPane().add(jLabel_CTCD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, -1, -1));

        txt_TTP.setBackground(new java.awt.Color(153, 153, 255));
        txt_TTP.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TTP.setForeground(new java.awt.Color(255, 255, 255));
        txt_TTP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TTP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_TTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 210, -1));

        jLabel_Logaritmo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Logaritmo3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Logaritmo3.setText("Tiempo de tromboplastina");
        getContentPane().add(jLabel_Logaritmo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, -1, -1));

        txt_TP.setBackground(new java.awt.Color(153, 153, 255));
        txt_TP.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TP.setForeground(new java.awt.Color(255, 255, 255));
        txt_TP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_TP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 210, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_claveEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_claveEstudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_claveEstudioActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void jButton_GuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarDatosActionPerformed
      
        String Reporte_generado;
        
        Reporte_generado = txt_Reporte.getText().trim();
        
        if(Reporte_generado.equals("No")) {
      
        
        int validacion = 0;
       
      SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, TiempoP,INR, TTP,Reporte_generado1; 
      
      Calendar calendario = new GregorianCalendar();
      ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
      java.util.Date d1 = new java.util.Date();
      SimpleDateFormat hourtwenty1 = new SimpleDateFormat("hh:mm");
      
      NoFolio = txt_NoFolio.getText().trim();
      ClaveE = txt_claveEstudio.getText().trim();
      empresa = txt_empresa.getText().trim();
      nombre = txt_nombre.getText().trim();
      apellido = txt_apellido.getText().trim();
      edad = txt_edad.getText().trim();
      nombremedico = txt_nombremedico.getText().trim();
      sexo = txt_sexo.getText().trim();
      fechaEntrega = dFormat.format(jDateChooser_fnacimiento.getDate());
      hora = hourtwenty1.format(d1)+ " "+ ampm;
      observaciones = jTextPane_indicaciones.getText().trim();
      TiempoP = txt_TP.getText().trim();
      INR = txt_INR.getText().trim();
      TTP = txt_TTP.getText().trim();
      
      Reporte_generado1 = "Si";
              
        if(NoFolio.equals("")) {
           txt_NoFolio.setBackground(Color.red);
           validacion++;     
       }
        if(ClaveE.equals("")) {
           txt_claveEstudio.setBackground(Color.red);
           validacion++;     
       }
       if(empresa.equals("")) {
           txt_empresa.setBackground(Color.red);
           validacion++;     
       }
       if(nombre.equals("")) {
           txt_nombre.setBackground(Color.red);
           validacion++;     
       }
       if(apellido.equals("")) {
           txt_apellido.setBackground(Color.red);
           validacion++;     
       }
        if(edad.equals("")) {
           txt_edad.setBackground(Color.red);
           validacion++;     
       }
       if(nombremedico.equals("")) {
           txt_nombremedico.setBackground(Color.red);
           validacion++;     
       }  
       if(sexo.equals("")) {
           txt_sexo.setBackground(Color.red);
           validacion++;     
       }
      
       if(hora.equals("")) {
           txt_hora.setBackground(Color.red);
           validacion++;     
       }
       if(observaciones.equals("")) { 
           jTextPane_indicaciones.setText("");
           observaciones = "";
       }
       if(TiempoP.equals("")) {
           txt_TP.setBackground(Color.red);
           validacion++;     
       }
       if(INR.equals("")) {
           txt_INR.setBackground(Color.red);
           validacion++;     
       }
        if(TTP.equals("")) {
           txt_TTP.setBackground(Color.red);
           validacion++;     
       }
      
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "insert into TPyTTP values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
             
             pst.setInt(1, IEstudio);
             pst.setString(2, NoFolio);
             pst.setString(3, ClaveE);
             pst.setString(4, empresa);
             pst.setString(5, nombre);
             pst.setString(6, apellido);
             pst.setString(7, edad);
             pst.setString(8, nombremedico);
             pst.setString(9, sexo);
             pst.setString(10, fechaEntrega);
             pst.setString(11, hora);
             pst.setString(12, observaciones);
             pst.setString(13, TiempoP);
             pst.setString(14, INR);
             pst.setString(15, TTP);
             pst.setString(16, user);
             pst.setString(17, Reporte_generado1);
          
             pst.executeUpdate();
             cn.close();
            
             txt_NoFolio.setBackground(Color.green);
             txt_claveEstudio.setBackground(Color.green);
             txt_empresa.setBackground(Color.green);
             txt_nombre.setBackground(Color.green);
             txt_apellido.setBackground(Color.green);
             txt_edad.setBackground(Color.green);
             txt_nombremedico.setBackground(Color.green);
             txt_sexo.setBackground(Color.green);
       
             txt_hora.setBackground(Color.green);
             jTextPane_indicaciones.setBackground(Color.green);
             txt_TP.setBackground(Color.green);
             txt_INR.setBackground(Color.green);
             txt_TTP.setBackground(Color.green);
             
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 
        
         try {
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from TPyTTP where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
           
          }
         
        } catch (SQLException e) {
         System.err.println("Error al consultar la información del estudio");
        }
         
       this.dispose();
        }
        
        
        if(Reporte_generado.equals("Si")) {
           JOptionPane.showMessageDialog(null, "Ya hay datos guardados anteriormente.");
        }
     
    }//GEN-LAST:event_jButton_GuardarDatosActionPerformed

    private void jButton_ActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarDatosActionPerformed
          
        String Reporte_generado;
        
        Reporte_generado = txt_Reporte.getText().trim();
        
        if(Reporte_generado.equals("Si")) {
      
        
        int validacion = 0;
       
      SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, TiempoP, INR, TTP,Reporte_generado1; 
      
       Calendar calendario = new GregorianCalendar();
      ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
      java.util.Date d1 = new java.util.Date();
      SimpleDateFormat hourtwenty1 = new SimpleDateFormat("hh:mm");
      
      NoFolio = txt_NoFolio.getText().trim();
      ClaveE = txt_claveEstudio.getText().trim();
      empresa = txt_empresa.getText().trim();
      nombre = txt_nombre.getText().trim();
      apellido = txt_apellido.getText().trim();
      edad = txt_edad.getText().trim();
      nombremedico = txt_nombremedico.getText().trim();
      sexo = txt_sexo.getText().trim();
      fechaEntrega = dFormat.format(jDateChooser_fnacimiento.getDate());
      hora = hourtwenty1.format(d1)+ " "+ ampm;
      observaciones = jTextPane_indicaciones.getText().trim();
      TiempoP = txt_TP.getText().trim();
      INR = txt_INR.getText().trim();
      TTP = txt_TTP.getText().trim();
      Reporte_generado1 = "Si";
              
       if(NoFolio.equals("")) {
           txt_NoFolio.setBackground(Color.red);
           validacion++;     
       }
        if(ClaveE.equals("")) {
           txt_claveEstudio.setBackground(Color.red);
           validacion++;     
       }
       if(empresa.equals("")) {
           txt_empresa.setBackground(Color.red);
           validacion++;     
       }
       if(nombre.equals("")) {
           txt_nombre.setBackground(Color.red);
           validacion++;     
       }
       if(apellido.equals("")) {
           txt_apellido.setBackground(Color.red);
           validacion++;     
       }
        if(edad.equals("")) {
           txt_edad.setBackground(Color.red);
           validacion++;     
       }
       if(nombremedico.equals("")) {
           txt_nombremedico.setBackground(Color.red);
           validacion++;     
       }  
       if(sexo.equals("")) {
           txt_sexo.setBackground(Color.red);
           validacion++;     
       }
      
       if(hora.equals("")) {
           txt_hora.setBackground(Color.red);
           validacion++;     
       }
 
       if(TiempoP.equals("")) {
           txt_TP.setBackground(Color.red);
           validacion++;     
       }
       if(INR.equals("")) {
           txt_INR.setBackground(Color.red);
           validacion++;     
       }
        if(TTP.equals("")) {
           txt_TTP.setBackground(Color.red);
           validacion++;     
       }
       
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "update TPyTTP set Fecha_entrega=?, Hora=?, Observaciones=?, TP=?, INR=?, TTP=?, ultima_modificacion=? " 
                   + "where ID_estudio = '" + IEstudio + "'");
           
             pst.setString(1, fechaEntrega);
             pst.setString(2, hora);
             pst.setString(3, observaciones);
             pst.setString(4, TiempoP);
             pst.setString(5, INR);
             pst.setString(6, TTP);
             pst.setString(7, user);
    
             pst.executeUpdate();
             cn.close();
            
             txt_NoFolio.setBackground(Color.green);
             txt_claveEstudio.setBackground(Color.green);
             txt_empresa.setBackground(Color.green);
             txt_nombre.setBackground(Color.green);
             txt_apellido.setBackground(Color.green);
             txt_edad.setBackground(Color.green);
             txt_nombremedico.setBackground(Color.green);
             txt_sexo.setBackground(Color.green);
       
             txt_hora.setBackground(Color.green);
             jTextPane_indicaciones.setBackground(Color.green);
             txt_TP.setBackground(Color.green);
             txt_INR.setBackground(Color.green);
             txt_TTP.setBackground(Color.green);
    
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 
         
       this.dispose();
        }
        
        
        if(Reporte_generado.equals("No")) {
           JOptionPane.showMessageDialog(null, "No hay datos guardados para actualizar.");
        }
        
    }//GEN-LAST:event_jButton_ActualizarDatosActionPerformed

    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed
      
       String horaA;

      Calendar calendarioA = new GregorianCalendar();
      ampm = calendarioA.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
      java.util.Date d2 = new java.util.Date();
      SimpleDateFormat hourtwenty2 = new SimpleDateFormat("hh:mm");
      

      horaA = hourtwenty2.format(d2) + " "+ ampm;

       try {
            
             Connection cnA = Conexion.conectar();
             PreparedStatement pstA = cnA.prepareStatement(
                     "update TPyTTP set Hora=?, ultima_modificacion=?"
                     
                   + "where ID_estudio = '" + IEstudio + "'");
         
             pstA.setString(1, horaA);
             pstA.setString(2, user);
      
             pstA.executeUpdate();
             cnA.close();
             
       
         } catch (SQLException e) {
          
         }

        Rectangle pageSize = new Rectangle(PageSize.LETTER); 
        Document documento = new Document(pageSize);
         documento.setMargins(28.34f, 28.34f, 28.34f, 0f);

     try {
     
         String ruta = System.getProperty("user.home");
         PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Estudios/" + txt_nombre.getText().trim() + " " + txt_apellido.getText() + ".pdf"));
       
        
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
        
        Scanner digitos = new Scanner(txt_NoFolio.getText());
        int numE=digitos.nextInt();
        String numeroE = Integer.toString(numE);        

        Paragraph parrafo = new Paragraph("No. de folio:", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        parrafo.setSpacingBefore(34);  
        parrafo.setSpacingAfter(25);
        
        Paragraph Ndefolio = new  Paragraph (txt_NoFolio.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
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
        
        SimpleDateFormat dFormat = new SimpleDateFormat("dd");
        SimpleDateFormat dFormat1 = new SimpleDateFormat("MMMM");
        SimpleDateFormat dFormat2 = new SimpleDateFormat("yyyy");
        
        Paragraph fecha1 = new  Paragraph (dFormat.format(jDateChooser_fnacimiento.getDate())+ " de " + dFormat1.format(jDateChooser_fnacimiento.getDate()) + " de " + dFormat2.format(jDateChooser_fnacimiento.getDate())+ "\n"  , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
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
        
        Calendar calendario = new GregorianCalendar();
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
        java.util.Date d3 = new java.util.Date();
        SimpleDateFormat hourtwenty3 = new SimpleDateFormat("hh:mm");
 
        Paragraph hora1 = new  Paragraph (hourtwenty3.format(d3) + " "+ ampm+"\n" + "\n" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        hora1.setSpacingBefore(-12);
        hora1.setIndentationLeft(361);
        hora1.setSpacingAfter(-3);
        documento.add(hora1);

        Paragraph estudio = new  Paragraph ("Estudio" , FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK));
        estudio.setSpacingBefore(10);
        estudio.setIndentationLeft(17);
        estudio.setSpacingAfter(-3);
        documento.add(estudio);
        
        Paragraph resultado = new  Paragraph ("Resultado"  , FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK));
        resultado.setSpacingBefore(-13);
        resultado.setIndentationLeft(300);
        resultado.setSpacingAfter(-3);
        documento.add(resultado);
        
        Paragraph valores = new  Paragraph ("Valores de referencia" , FontFactory.getFont("arial", 11, Font.BOLD , BaseColor.BLACK));
        valores.setSpacingBefore(-14);
        valores.setIndentationLeft(400);
        valores.setSpacingAfter(-3);
        documento.add(valores);
        
        double TiempoP, INR, TTP; 
        
        TiempoP = Double.parseDouble(txt_TP.getText());
        INR = Double.parseDouble(txt_INR.getText());
        TTP = Double.parseDouble(txt_TTP.getText());

        Chunk chunk2 = new Chunk("Tiempo de Protrombina (TP)", FontFactory.getFont("arial", 11,Font.NORMAL, BaseColor.BLACK));
        chunk2.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk = new  Paragraph ((chunk2));
        chunk.setSpacingBefore(10);
        chunk.setIndentationLeft(17);
        chunk.setSpacingAfter(-3);
        
        if(TiempoP<9){
        documento.add(chunk);
        }

        Chunk chunk_1 = new Chunk("Tiempo de Protrombina (TP)", FontFactory.getFont("arial", 11,Font.BOLD, BaseColor.BLACK));
        chunk_1.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk1 = new  Paragraph ((chunk_1));
        chunk1.setSpacingBefore(10);
        chunk1.setIndentationLeft(17);
        chunk1.setSpacingAfter(-3);
        
        if(TiempoP>=9 && TiempoP<=15){
        documento.add(chunk1);
        }

        Chunk chunk_2 = new Chunk("Tiempo de Protrombina (TP)", FontFactory.getFont("arial", 11,Font.NORMAL, BaseColor.BLACK));
        chunk_2.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk3 = new  Paragraph ((chunk_2));
        chunk3.setSpacingBefore(10);
        chunk3.setIndentationLeft(17);
        chunk3.setSpacingAfter(-3);
        
        if(TiempoP>=15){
        documento.add(chunk3);
        }

        float left = 290, left1 = 290, left2 = 290;

         Paragraph Tiempopro = new  Paragraph (txt_TP.getText() + " Segundos" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Tiempopro.setSpacingBefore(-11);
        Tiempopro.setSpacingAfter(-3);
        
        if(txt_TP.getText().contains(".") && TiempoP>0 && TiempoP<9){
        left = left - 4;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(TiempoP>=0 && TiempoP<=8){
        left = left;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        Paragraph Tiempopro1 = new  Paragraph (txt_TP.getText()+ " Segundos" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Tiempopro1.setSpacingBefore(-11);
        Tiempopro1.setSpacingAfter(-3);
         
        if(txt_TP.getText().contains(".") && TiempoP>9 && TiempoP<10){
        left = left - 4;
        Tiempopro1.setIndentationLeft(left);
        documento.add(Tiempopro1);
        } else {
        if(TiempoP==9){
        left = left;
        Tiempopro1.setIndentationLeft(left);
        documento.add(Tiempopro1);
        } }

        if(txt_TP.getText().contains(".") && TiempoP>10 && TiempoP<15){
        left = left - 7;
        Tiempopro1.setIndentationLeft(left);
        documento.add(Tiempopro1);
        } else {
        if(TiempoP>=10 && TiempoP<=15){
        left = left - 3;
        Tiempopro1.setIndentationLeft(left);
        documento.add(Tiempopro1);
        } }

        if(txt_TP.getText().contains(".") && TiempoP>15 && TiempoP<100){
        left = left - 7;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(TiempoP>=16 && TiempoP<=99){
        left = left - 3;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        if(txt_TP.getText().contains(".") && TiempoP>100 && TiempoP<1000){
        left = left - 10;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(TiempoP>=100 && TiempoP<=999){
        left = left - 6;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        if(txt_TP.getText().contains(".") && TiempoP>1000 && TiempoP<10000){
        left = left - 13;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(TiempoP>=1000 && TiempoP<=9999){
        left = left - 9;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        if(txt_TP.getText().contains(".") && TiempoP>10000 && TiempoP<100000){
        left = left - 16;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(TiempoP>=10000 && TiempoP<=99999){
        left = left - 12;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

         
        if(TiempoP>=100000){
        left = left - 15;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        }

         //negativo
        if(txt_TP.getText().contains(".") && txt_TP.getText().contains("-") && TiempoP>-9 && TiempoP<0){
        left = left - 7;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(txt_TP.getText().contains("-") && TiempoP>=-9 && TiempoP<=0){
        left = left - 3;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        if(txt_TP.getText().contains(".") && txt_TP.getText().contains("-") && TiempoP>-9 && TiempoP<0){
        left = left - 7;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(txt_TP.getText().contains("-") && TiempoP>=-9 && TiempoP<=0){
        left = left - 3;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }

        if(txt_TP.getText().contains(".") && txt_TP.getText().contains("-") && TiempoP>-1000 && TiempoP<-100){
        left = left - 13;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(txt_TP.getText().contains("-") && TiempoP>=-999 && TiempoP<=-100){
        left = left - 9;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }
        
        if(txt_TP.getText().contains(".") && txt_TP.getText().contains("-") && TiempoP>-10000 && TiempoP<-1000){
        left = left - 16;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(txt_TP.getText().contains("-") && TiempoP>=-9999 && TiempoP<=-1000){
        left = left - 12;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }
        
        if(txt_TP.getText().contains(".") && txt_TP.getText().contains("-") && TiempoP>-100000 && TiempoP<-10000){
        left = left - 22;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } else {
        if(txt_TP.getText().contains("-") && TiempoP>=-99999 && TiempoP<=-10000){
        left = left - 18;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } }
       
        if(TiempoP<=-100000){
        left = left - 18;
        Tiempopro.setIndentationLeft(left);
        documento.add(Tiempopro);
        } 

        Paragraph logM = new  Paragraph ("9	            15", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        logM.setSpacingBefore(-12);
        logM.setIndentationLeft(413);
        logM.setSpacingAfter((float) -4.5);
        

        if(TiempoP<9){ 
        documento.add(logM);     
        }

        Paragraph logM1 = new  Paragraph ("9	            15", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        logM1.setSpacingBefore(-12);
        logM1.setIndentationLeft(413);
        logM1.setSpacingAfter((float) -4.5);
        

        if(TiempoP>=9 && TiempoP<=11000){ 
        documento.add(logM1);     
        }

        Paragraph logM2 = new  Paragraph ("9	            15", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        logM2.setSpacingBefore(-12);
        logM2.setIndentationLeft(413);
        logM2.setSpacingAfter((float) -4.5);
        

        if(TiempoP>11000){ 
        documento.add(logM2);     
        }
      
        Chunk chunk5 = new Chunk("I.N.R.", FontFactory.getFont("arial", 11,Font.BOLD, BaseColor.BLACK));
        chunk5.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk6 = new  Paragraph ((chunk5));
        chunk6.setSpacingBefore(3);
        chunk6.setIndentationLeft(17);
        chunk6.setSpacingAfter(-3);

        Chunk chunk7 = new Chunk("I.N.R.", FontFactory.getFont("arial", 11,Font.BOLD, BaseColor.BLACK));
        chunk7.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk8 = new  Paragraph ((chunk7));
        chunk8.setSpacingBefore(3);
        chunk8.setIndentationLeft(17);
        chunk8.setSpacingAfter(-3);
        
        if(INR==1){
        documento.add(chunk6);
        } else {
        documento.add(chunk8);
        }

        Paragraph metodo = new  Paragraph ("Método: Coagulometría" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        metodo.setSpacingBefore(2);
        metodo.setIndentationLeft(17);
        metodo.setSpacingAfter(-3);
        documento.add(metodo);
   
        Paragraph INRR = new  Paragraph (txt_INR.getText() + " De acuerdo al lote" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        INRR.setSpacingBefore(-25);
        INRR.setSpacingAfter(-3);
        
        if(txt_INR.getText().contains(".") && INR>0 && INR<1){
        left1 = left1 - 4;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR==0){
        left1 = left1;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        Paragraph INRR1 = new  Paragraph (txt_INR.getText() + " De acuerdo al lote", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        INRR1.setSpacingBefore(-25);
        INRR1.setSpacingAfter(-3);
         
        if(INR==1){
        left1 = left1;
        INRR1.setIndentationLeft(left1);
        documento.add(INRR1);
        } 

        if(txt_INR.getText().contains(".") && INR>1 && INR<10){
        left1 = left1 - 4;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR>=2 && INR<=9 ){
        left1 = left1;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && INR>10 && INR<100){
        left1 = left1 - 7;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR>=10 && INR<=99 ){
        left1 = left1 - 3;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && INR>100 && INR<1000){
        left1 = left1 - 10;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR>=100 && INR<=999 ){
        left1 = left1 - 6;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && INR>1000 && INR<10000){
        left1 = left1 - 13;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR>=1000 && INR<=9999 ){
        left1 = left1 - 9;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && INR>10000 && INR<100000){
        left1 = left1 - 16;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(INR>=10000 && INR<=99999 ){
        left1 = left1 - 12;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(INR>=100000){
        left1 = left1 - 15;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } 
    
   
         //negativo
        if(txt_INR.getText().contains(".") && txt_INR.getText().contains("-") && INR>-9 && INR<0){
        left1 = left1 - 7;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(txt_INR.getText().contains("-") && INR>=-9 && INR<=0 ){
        left1 = left1 - 3;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && txt_INR.getText().contains("-") && INR>-100 && INR<-10){
        left1 = left1 - 10;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(txt_INR.getText().contains("-") && INR>=-99 && INR<=-10 ){
        left1 = left1 - 6;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }

        if(txt_INR.getText().contains(".") && txt_INR.getText().contains("-") && INR>-1000 && INR<-100){
        left1 = left1 - 13;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(txt_INR.getText().contains("-") && INR>=-999 && INR<=-100){
        left1 = left1 - 9;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }
  
        if(txt_INR.getText().contains(".") && txt_INR.getText().contains("-") && INR>-10000 && INR<-1000){
        left1 = left1 - 16;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(txt_INR.getText().contains("-") && INR>=-9999 && INR<=-1000){
        left1 = left1 - 12;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }
        
        if(txt_INR.getText().contains(".") && txt_INR.getText().contains("-") && INR>-100000 && INR<-10000){
        left1 = left1 - 22;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } else {
        if(txt_INR.getText().contains("-") && INR>=-99999 && INR<=-10000){
        left1 = left1 - 18;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } }
        
        if(INR<=-100000){
        left1 = left1 - 18;
        INRR.setIndentationLeft(left1);
        documento.add(INRR);
        } 
       
       
        Paragraph INRM1 = new  Paragraph ("1", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        INRM1.setSpacingBefore(-12);
        INRM1.setIndentationLeft(413);
        INRM1.setSpacingAfter((float) -4.5);
        
        Paragraph INRM12 = new  Paragraph ("1", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        INRM12.setSpacingBefore(-12);
        INRM12.setIndentationLeft(413);
        INRM12.setSpacingAfter((float) -4.5);

        if(TiempoP==1){ 
        documento.add(INRM1);     
        } else {
        documento.add(INRM12);
        }


        Chunk chunk4 = new Chunk("Tiempo de tromboplastina parcial activada (TTP)", FontFactory.getFont("arial", 11,Font.NORMAL, BaseColor.BLACK));
        chunk4.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk9 = new  Paragraph ((chunk4));
        chunk9.setSpacingBefore(30);
        chunk9.setIndentationLeft(17);
        chunk9.setSpacingAfter(-3);
     

        Chunk chunk0 = new Chunk("Tiempo de tromboplastina parcial activada (TTP)", FontFactory.getFont("arial", 11,Font.BOLD, BaseColor.BLACK));
        chunk0.setUnderline(1.5f, -3.5f);
        
        Paragraph chunkl = new  Paragraph ((chunk0));
        chunkl.setSpacingBefore(30);
        chunkl.setIndentationLeft(17);
        chunkl.setSpacingAfter(-3);
   

        if(TTP>=0 && TTP<=9){
        documento.add(chunk9);
        } else {
        documento.add(chunkl);
        }

               
        Paragraph metodo1 = new  Paragraph ("Método: Coagulometría" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        metodo1.setSpacingBefore(2);
        metodo1.setIndentationLeft(17);
        metodo1.setSpacingAfter(-3);
        documento.add(metodo1);

        Paragraph TTPR = new  Paragraph (txt_TTP.getText() + " Segundos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        TTPR.setSpacingBefore(-25);
        TTPR.setSpacingAfter(-3);
         
        if(txt_TTP.getText().contains(".") && TTP>0 && TTP<10){
        left2 = left2 - 4;
        TTPR.setIndentationLeft(left2);
        documento.add(TTPR);
        } else {
        if(TTP>=0 && TTP<=9 ){
        left2 = left2;
        TTPR.setIndentationLeft(left2);
        documento.add(TTPR);
        } }

        if(txt_TTP.getText().contains(".") && TTP>10 && TTP<40){
        left2 = left2 - 7;
        TTPR.setIndentationLeft(left2);
        documento.add(TTPR);
        } else {
        if(TTP>=10 && TTP<=40 ){
        left2 = left2 - 3;
        TTPR.setIndentationLeft(left2);
        documento.add(TTPR);
        } }

        Paragraph TTPR1 = new  Paragraph (txt_TTP.getText() + " Segundos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        TTPR1.setSpacingBefore(-25);
        TTPR1.setSpacingAfter(-3);

        if(txt_TTP.getText().contains(".") && TTP>40 && TTP<100){
        left2 = left2 - 7;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(TTP>=41 && TTP<=99 ){
        left2 = left2 - 3;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }        

        if(txt_TTP.getText().contains(".") && TTP>100 && TTP<1000){
        left2 = left2 - 10;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(TTP>=100 && TTP<=999 ){
        left2 = left2 - 6;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }

        if(txt_TTP.getText().contains(".") && TTP>1000 && TTP<10000){
        left2 = left2 - 13;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(TTP>=1000 && TTP<=9999 ){
        left2 = left2 - 9;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }

        if(txt_TTP.getText().contains(".") && TTP>10000 && TTP<100000){
        left2 = left2 - 16;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(TTP>=10000 && TTP<=99999){
        left2 = left2 - 12;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }        

        if(TTP>=100000){
        left2 = left2 - 15;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } 

   
         //negativo

        if(txt_TTP.getText().contains(".") && txt_TTP.getText().contains("-") && TTP>-9 && TTP<0){
        left2 = left2 - 7;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(txt_TTP.getText().contains("-") && TTP>=-9 && TTP<=0){
        left2 = left2 - 3;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }        

        if(txt_TTP.getText().contains(".") && txt_TTP.getText().contains("-") && TTP>-100 && TTP<-10){
        left2 = left2 - 10;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(txt_TTP.getText().contains("-") && TTP>=-99 && TTP<=-10){
        left2 = left2 - 6;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } } 

        if(txt_TTP.getText().contains(".") && txt_TTP.getText().contains("-") && TTP>-1000 && TTP<-100){
        left2 = left2 - 13;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(txt_TTP.getText().contains("-") && TTP>=-999 && TTP<=-100){
        left2 = left2 - 9;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }

        if(txt_TTP.getText().contains(".") && txt_TTP.getText().contains("-") && TTP>-10000 && TTP<-1000){
        left2 = left2 - 16;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(txt_TTP.getText().contains("-") && TTP>=-9999 && TTP<=-1000){
        left2 = left2 - 12;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }
  
        if(txt_TTP.getText().contains(".") && txt_TTP.getText().contains("-") && TTP>-100000 && TTP<-10000){
        left2 = left2 - 22;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } else {
        if(txt_TTP.getText().contains("-") && TTP>=-99999 && TTP<=-10000){
        left2 = left2 - 18;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } }
        
        if(TTP<=-100000){
        left2 = left2 - 18;
        TTPR1.setIndentationLeft(left2);
        documento.add(TTPR1);
        } 
        
        Paragraph TTPM = new  Paragraph ("0	            40", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        TTPM.setSpacingBefore(-12);
        TTPM.setIndentationLeft(413);
        TTPM.setSpacingAfter((float) -4.5);
        

        if(TTP<0){ 
        documento.add(TTPM);     
        }

        Paragraph TTPM1 = new  Paragraph ("0	            40", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        TTPM1.setSpacingBefore(-12);
        TTPM1.setIndentationLeft(413);
        TTPM1.setSpacingAfter((float) -4.5);
        

        if(TTP>=0 && TTP<=40){ 
        documento.add(TTPM1);     
        }

        Paragraph TTPM2 = new  Paragraph ("0	            40", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        TTPM2.setSpacingBefore(-12);
        TTPM2.setIndentationLeft(413);
        TTPM2.setSpacingAfter((float) -4.5);
        

        if(TTP>40){ 
        documento.add(TTPM2);     
        }
         
        Paragraph Observaciones = new  Paragraph ("Observaciones:" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Observaciones.setSpacingBefore(30);
        Observaciones.setIndentationLeft(17);
        Observaciones.setSpacingAfter(-3);
        documento.add(Observaciones);
 
        Paragraph ObservacionesP = new  Paragraph (jTextPane_indicaciones.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        ObservacionesP.setSpacingBefore(0);
        ObservacionesP.setIndentationLeft(17);
        ObservacionesP.setSpacingAfter(-3);
        documento.add(ObservacionesP);
        
        PdfContentByte canvas2 = writer.getDirectContent();
        CMYKColor magentaColor2 = new CMYKColor(0.f, 0.f, 0.f, 100.f);
        canvas2.setColorStroke(magentaColor2);
        canvas2.moveTo(197, 135);
        canvas2.lineTo(409, 135);
        canvas2.setLineWidth(0);
        canvas2.closePathStroke();
        
        PdfContentByte atteM = writer.getDirectContent();
        BaseFont atteMb = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        atteM.saveState();
        atteM.beginText();
        atteM.setFontAndSize(atteMb, 11);
        atteM.setColorFill(BaseColor.BLACK);
        atteM.moveText((float) 270, 114); 
        atteM.showText("Atentamente");
        atteM.endText();
        atteM.restoreState(); 
        
        PdfContentByte QFBT = writer.getDirectContent();
        BaseFont QFBTb = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        QFBT.saveState();
        QFBT.beginText();
        QFBT.setFontAndSize(QFBTb, 11);
        QFBT.setColorFill(BaseColor.BLACK);
        QFBT.moveText((float) 200, 102); 
        QFBT.showText("Q.F.B. Brenda Juliana Domínguez Gómez");
        QFBT.endText();
        QFBT.restoreState(); 
        
        PdfContentByte cedulaT = writer.getDirectContent();
        BaseFont cedulaB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cedulaT.saveState();
        cedulaT.beginText();
        cedulaT.setFontAndSize(cedulaB, 11);
        cedulaT.setColorFill(BaseColor.BLACK);
        cedulaT.moveText((float) 253, (float) 90.5); 
        cedulaT.showText("Céd. Prof. 9216129");
        cedulaT.endText();
        cedulaT.restoreState(); 
  
        PdfContentByte dirT = writer.getDirectContent();
        BaseFont dirB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        dirT.saveState();
        dirT.beginText();
        dirT.setFontAndSize(dirB, 8);
        dirT.setColorFill(BaseColor.BLACK);
        dirT.moveText((float) 135.4, (float) 67.2); 
        dirT.showText("Avenida Coronel Gregorio Méndez Magaña #507, Col. Centro. C.P. 86000. Villahermosa, Tabasco.");
        dirT.endText();
        dirT.restoreState(); 
        com.itextpdf.text.Image ubicacion = com.itextpdf.text.Image.getInstance("images/ubicacion.jpg");
        ubicacion.scaleAbsolute(15, 15);
        ubicacion.setAbsolutePosition(120,65);
        documento.add(ubicacion);
        
        PdfContentByte telT = writer.getDirectContent();
        BaseFont telB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        telT.saveState();
        telT.beginText();
        telT.setFontAndSize(telB, 9);
        telT.setColorFill(BaseColor.BLACK);
        telT.moveText((float) 233, (float) 50.3); 
        telT.showText("(993) 3656540");
        telT.endText();
        telT.restoreState();
        com.itextpdf.text.Image telefono = com.itextpdf.text.Image.getInstance("images/telefono.jpg");
        telefono.scaleAbsolute(15, 15);
        telefono.setAbsolutePosition(215,47);
        documento.add(telefono);
        
        PdfContentByte numT = writer.getDirectContent();
        BaseFont numB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        numT.saveState();
        numT.beginText();
        numT.setFontAndSize(numB, 9);
        numT.setColorFill(BaseColor.BLACK);
        numT.moveText((float) 333, (float) 50.3); 
        numT.showText("9934447673");
        numT.endText();
        numT.restoreState();
        com.itextpdf.text.Image numero = com.itextpdf.text.Image.getInstance("images/numero.jpg");
        numero.scaleAbsolute(15, 12);
        numero.setAbsolutePosition(315,47);
        documento.add(numero);
        
        PdfContentByte correoT = writer.getDirectContent();
        BaseFont correoTB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        correoT.saveState();
        correoT.beginText();
        correoT.setFontAndSize(correoTB, 8);
        correoT.setColorFill(BaseColor.BLACK);
        correoT.moveText((float) 164, (float) 36); 
        correoT.showText("laboratoriosbiosalud@hotmail.com");
        correoT.endText();
        correoT.restoreState();
        com.itextpdf.text.Image correoI = com.itextpdf.text.Image.getInstance("images/correo.jpg");
        correoI.scaleAbsolute(13, 14);
        correoI.setAbsolutePosition(145,34);
        documento.add(correoI);
        
        PdfContentByte pagT = writer.getDirectContent();
        BaseFont pagB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        pagT.saveState();
        pagT.beginText();
        pagT.setFontAndSize(pagB, 8);
        pagT.setColorFill(BaseColor.BLACK);
        pagT.moveText((float) 348, (float) 36); 
        pagT.showText("www.laboratoriosbiosalud.com.mx");
        pagT.endText();
        pagT.restoreState();
        com.itextpdf.text.Image pagina = com.itextpdf.text.Image.getInstance("images/pagina.jpg");
        pagina.scaleAbsolute(15, 15);
        pagina.setAbsolutePosition(330,32);
        documento.add(pagina);
        
        PdfContentByte faceT = writer.getDirectContent();
        BaseFont faceB = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        faceT.saveState();
        faceT.beginText();
        faceT.setFontAndSize(faceB, 8);
        faceT.setColorFill(BaseColor.BLACK);
        faceT.moveText((float) 235, (float) 21); 
        faceT.showText("www.facebook.com/LaboratoriosBioSalud");
        faceT.endText();
        faceT.restoreState();           

         if (jCheckBox_firma.isSelected()) {
            com.itextpdf.text.Image footer2 = com.itextpdf.text.Image.getInstance("images/firma.jpg");
        footer2.scaleAbsolute(110, 70);
        footer2.setAbsolutePosition(236,126);
            documento.add(footer2);
        }
 
        documento.close();
         JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");
        
        
        } catch (DocumentException | IOException e){
           System.err.println("Error en generar documento. " + e);
           JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al programador.");
     }
        
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

    private void jCheckBox_firmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_firmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_firmaActionPerformed

    private void txt_NoFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NoFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NoFolioActionPerformed

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
            java.util.logging.Logger.getLogger(TPyTTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPyTTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPyTTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPyTTP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPyTTP().setVisible(true);
            }
        });
    }


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarDatos;
    private javax.swing.JButton jButton_GuardarDatos;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JCheckBox jCheckBox_firma;
    private com.toedter.calendar.JDateChooser jDateChooser_fnacimiento;
    private javax.swing.JLabel jLabe_claveEstudio;
    private javax.swing.JLabel jLabel_CTCD3;
    private javax.swing.JLabel jLabel_CTCD5;
    private javax.swing.JLabel jLabel_CopiasmL;
    private javax.swing.JLabel jLabel_Datos;
    private javax.swing.JLabel jLabel_Logaritmo;
    private javax.swing.JLabel jLabel_Logaritmo2;
    private javax.swing.JLabel jLabel_Logaritmo3;
    private javax.swing.JLabel jLabel_NoFolio;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_ValoresdeResultado;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_edad;
    private javax.swing.JLabel jLabel_empresa;
    private javax.swing.JLabel jLabel_fechadeentrega;
    private javax.swing.JLabel jLabel_hora;
    private javax.swing.JLabel jLabel_indicaciones;
    private javax.swing.JLabel jLabel_medico;
    private javax.swing.JLabel jLabel_nombres;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_INR;
    private javax.swing.JTextField txt_NoFolio;
    private javax.swing.JTextField txt_Reporte;
    private javax.swing.JTextField txt_TP;
    private javax.swing.JTextField txt_TTP;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_claveEstudio;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_sexo;
    // End of variables declaration//GEN-END:variables
 

}
