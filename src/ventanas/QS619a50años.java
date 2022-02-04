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
import com.itextpdf.text.Element;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class QS619a50años extends javax.swing.JFrame {

   
int IDpaciente_update = 0, IDestudio = 0, IEstudio =0;
String user = "", nom_paciente = "";
 String minutos, ampm;
 Calendar calendario;


    /**
     * Creates new form CargaViralA
     */
    public QS619a50años() {
        initComponents();
        user = Login.user;
        IDestudio = Estudio_paciente.IDestudio;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        IEstudio = InformacionEstudio.IEstudio;
        txt_Ureasérica.requestFocus();
        txt_Creatininasérica.requestFocus();
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
                  "select * from QS619a50años where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            jTextPane_indicaciones.setText(rs2.getString("Observaciones"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
            txt_Glucosasérica.setText(rs2.getString("Glucosaserica"));
            txt_Ureasérica.setText(rs2.getString("Ureaserica"));
            txt_Creatininasérica.setText(rs2.getString("Creatininaserica"));
            txt_NitrogenoureicoBUN.setText(rs2.getString("NitrogenoureicoBUN"));
            txt_RelaciónBUNCreatinina.setText(rs2.getString("RelacionBUNCreatinina"));
            txt_Ácidoúrico.setText(rs2.getString("Acidourico"));
            txt_Colesteroltotal.setText(rs2.getString("Colesteroltotal"));
            txt_Triglicéridos.setText(rs2.getString("Trigliceridos"));
          }
          
          
        } catch (SQLException e) {
         System.err.println("Error al consultar la información del estudio");
        }
  
        setSize(603, 990);
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
        txt_Glucosasérica = new javax.swing.JTextField();
        jCheckBox_firma = new javax.swing.JCheckBox();
        jLabel_Glucosasérica = new javax.swing.JLabel();
        jLabel_Ureasérica = new javax.swing.JLabel();
        txt_Ureasérica = new javax.swing.JTextField();
        txt_Creatininasérica = new javax.swing.JTextField();
        jLabel_Creatininasérica = new javax.swing.JLabel();
        jLabel_NitrogenoureicoBUN = new javax.swing.JLabel();
        txt_NitrogenoureicoBUN = new javax.swing.JTextField();
        jLabel_RelaciónBUNCreatinina = new javax.swing.JLabel();
        txt_RelaciónBUNCreatinina = new javax.swing.JTextField();
        jLabel_Ácidoúrico = new javax.swing.JLabel();
        txt_Ácidoúrico = new javax.swing.JTextField();
        jLabel_Colesteroltotal = new javax.swing.JLabel();
        txt_Colesteroltotal = new javax.swing.JTextField();
        jLabel_Triglicéridos = new javax.swing.JLabel();
        txt_Triglicéridos = new javax.swing.JTextField();
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
        getContentPane().add(jLabel_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        txt_edad.setBackground(new java.awt.Color(153, 153, 255));
        txt_edad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(255, 255, 255));
        txt_edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_edad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 250, -1));

        jLabel_medico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_medico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_medico.setText("Médico solicitante:");
        getContentPane().add(jLabel_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        txt_nombremedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombremedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombremedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombremedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombremedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 250, -1));

        jLabel_sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sexo.setText("Sexo:");
        getContentPane().add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        txt_sexo.setBackground(new java.awt.Color(153, 153, 255));
        txt_sexo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sexo.setForeground(new java.awt.Color(255, 255, 255));
        txt_sexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sexo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 250, -1));

        jLabel_fechadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fechadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechadeentrega.setText("Fecha de entrega:");
        getContentPane().add(jLabel_fechadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        jLabel_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hora.setText("Hora:");
        getContentPane().add(jLabel_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        txt_hora.setBackground(new java.awt.Color(153, 153, 255));
        txt_hora.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 250, -1));

        jScrollPane1.setViewportView(jTextPane_indicaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 550, 170));

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
        getContentPane().add(jButton_GuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 830, 130, -1));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 250, 26));

        txt_Reporte.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reporte.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reporte.setText("No");
        txt_Reporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 880, 210, -1));

        jLabel_Datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Datos.setText("Datos guardados:");
        getContentPane().add(jLabel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 885, -1, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 830, 130, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Reporte");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 830, 130, -1));

        jLabel_ValoresdeResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado.setText("Valores de resultado:");
        getContentPane().add(jLabel_ValoresdeResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        txt_Glucosasérica.setBackground(new java.awt.Color(153, 153, 255));
        txt_Glucosasérica.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Glucosasérica.setForeground(new java.awt.Color(255, 255, 255));
        txt_Glucosasérica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Glucosasérica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Glucosasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 210, -1));

        jCheckBox_firma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox_firma.setText("Incluir firma");
        jCheckBox_firma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_firmaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_firma, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 920, -1, -1));

        jLabel_Glucosasérica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Glucosasérica.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Glucosasérica.setText("Glucosa sérica:");
        getContentPane().add(jLabel_Glucosasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        jLabel_Ureasérica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Ureasérica.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ureasérica.setText("Urea sérica:");
        getContentPane().add(jLabel_Ureasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, -1, -1));

        txt_Ureasérica.setBackground(new java.awt.Color(153, 153, 255));
        txt_Ureasérica.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Ureasérica.setForeground(new java.awt.Color(255, 255, 255));
        txt_Ureasérica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Ureasérica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Ureasérica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_UreaséricaKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Ureasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 210, -1));

        txt_Creatininasérica.setBackground(new java.awt.Color(153, 153, 255));
        txt_Creatininasérica.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Creatininasérica.setForeground(new java.awt.Color(255, 255, 255));
        txt_Creatininasérica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Creatininasérica.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Creatininasérica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CreatininaséricaActionPerformed(evt);
            }
        });
        txt_Creatininasérica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CreatininaséricaKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Creatininasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 210, -1));

        jLabel_Creatininasérica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Creatininasérica.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Creatininasérica.setText("Nitrógeno ureico (BUN):");
        getContentPane().add(jLabel_Creatininasérica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 760, -1, -1));

        jLabel_NitrogenoureicoBUN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_NitrogenoureicoBUN.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NitrogenoureicoBUN.setText("Creatinina sérica:");
        getContentPane().add(jLabel_NitrogenoureicoBUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, -1, -1));

        txt_NitrogenoureicoBUN.setBackground(new java.awt.Color(153, 153, 255));
        txt_NitrogenoureicoBUN.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NitrogenoureicoBUN.setForeground(new java.awt.Color(255, 255, 255));
        txt_NitrogenoureicoBUN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NitrogenoureicoBUN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NitrogenoureicoBUN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NitrogenoureicoBUNActionPerformed(evt);
            }
        });
        txt_NitrogenoureicoBUN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_NitrogenoureicoBUNKeyReleased(evt);
            }
        });
        getContentPane().add(txt_NitrogenoureicoBUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, 210, -1));

        jLabel_RelaciónBUNCreatinina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_RelaciónBUNCreatinina.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RelaciónBUNCreatinina.setText("Relación BUN/Creatinina:");
        getContentPane().add(jLabel_RelaciónBUNCreatinina, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, -1, -1));

        txt_RelaciónBUNCreatinina.setBackground(new java.awt.Color(153, 153, 255));
        txt_RelaciónBUNCreatinina.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_RelaciónBUNCreatinina.setForeground(new java.awt.Color(255, 255, 255));
        txt_RelaciónBUNCreatinina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RelaciónBUNCreatinina.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_RelaciónBUNCreatinina, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 630, 210, -1));

        jLabel_Ácidoúrico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Ácidoúrico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Ácidoúrico.setText("Ácido úrico:");
        getContentPane().add(jLabel_Ácidoúrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 660, -1, -1));

        txt_Ácidoúrico.setBackground(new java.awt.Color(153, 153, 255));
        txt_Ácidoúrico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Ácidoúrico.setForeground(new java.awt.Color(255, 255, 255));
        txt_Ácidoúrico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Ácidoúrico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Ácidoúrico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 680, 210, -1));

        jLabel_Colesteroltotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Colesteroltotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Colesteroltotal.setText("Colesterol total:");
        getContentPane().add(jLabel_Colesteroltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 710, -1, -1));

        txt_Colesteroltotal.setBackground(new java.awt.Color(153, 153, 255));
        txt_Colesteroltotal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Colesteroltotal.setForeground(new java.awt.Color(255, 255, 255));
        txt_Colesteroltotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Colesteroltotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Colesteroltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 730, 210, -1));

        jLabel_Triglicéridos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Triglicéridos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Triglicéridos.setText("Triglicéridos:");
        getContentPane().add(jLabel_Triglicéridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 760, -1, -1));

        txt_Triglicéridos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Triglicéridos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Triglicéridos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Triglicéridos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Triglicéridos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Triglicéridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 780, 210, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 1060));

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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, Glucosaserica, Ureaserica, Creatininaserica, NitrogenoureicoBUN, RelacionBUNCreatinina, Acidourico, Colesteroltotal, Triglicéridos,Reporte_generado1; 
      
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
      Glucosaserica = txt_Glucosasérica.getText().trim();
      Ureaserica = txt_Ureasérica.getText().trim();
      Creatininaserica = txt_Creatininasérica.getText().trim();
      NitrogenoureicoBUN = txt_NitrogenoureicoBUN.getText().trim();
      RelacionBUNCreatinina = txt_RelaciónBUNCreatinina.getText().trim();
      Acidourico = txt_Ácidoúrico.getText().trim();
      Colesteroltotal = txt_Colesteroltotal.getText().trim();
      Triglicéridos = txt_Triglicéridos.getText().trim();

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
       if(Glucosaserica.equals("")) {
           txt_Glucosasérica.setBackground(Color.red);
           validacion++;     
       }
       if(Ureaserica.equals("")) {
           txt_Ureasérica.setBackground(Color.red);
           validacion++;     
       }
       if(Creatininaserica.equals("")) {
           txt_Creatininasérica.setBackground(Color.red);
           validacion++;     
       }
       if(NitrogenoureicoBUN.equals("")) {
           txt_NitrogenoureicoBUN.setBackground(Color.red);
           validacion++;     
       }
       if(RelacionBUNCreatinina.equals("")) {
           txt_RelaciónBUNCreatinina.setBackground(Color.red);
           validacion++;     
       }
       if(Acidourico.equals("")) {
           txt_Ácidoúrico.setBackground(Color.red);
           validacion++;     
       }
       if(Colesteroltotal.equals("")) {
           txt_Colesteroltotal.setBackground(Color.red);
           validacion++;     
       }
       if(Triglicéridos.equals("")) {
           txt_Triglicéridos.setBackground(Color.red);
           validacion++;     
       }

               
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "insert into QS619a50años values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
             
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
             pst.setString(13, Glucosaserica);
             pst.setString(14, Ureaserica);
             pst.setString(15, Creatininaserica);
             pst.setString(16, NitrogenoureicoBUN);
             pst.setString(17, RelacionBUNCreatinina);
             pst.setString(18, Acidourico);
             pst.setString(19, Colesteroltotal);
             pst.setString(20, Triglicéridos);
             pst.setString(21, user);
             pst.setString(22, Reporte_generado1);
          
             
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
             txt_Glucosasérica.setBackground(Color.green);
             txt_Ureasérica.setBackground(Color.green);
             txt_Creatininasérica.setBackground(Color.green);
             txt_NitrogenoureicoBUN.setBackground(Color.green);
             txt_RelaciónBUNCreatinina.setBackground(Color.green);
             txt_Ácidoúrico.setBackground(Color.green);
             txt_Colesteroltotal.setBackground(Color.green);
             txt_Triglicéridos.setBackground(Color.green);
             
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 

         try {
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from QS619a50años where ID_estudio = '" + IEstudio + "'");
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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, Glucosaserica, Ureaserica, Creatininaserica, NitrogenoureicoBUN, RelacionBUNCreatinina, Acidourico, Colesteroltotal, Triglicéridos,Reporte_generado1; 
      
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
      Glucosaserica = txt_Glucosasérica.getText().trim();
      Ureaserica = txt_Ureasérica.getText().trim();
      Creatininaserica = txt_Creatininasérica.getText().trim();
      NitrogenoureicoBUN = txt_NitrogenoureicoBUN.getText().trim();
      RelacionBUNCreatinina = txt_RelaciónBUNCreatinina.getText().trim();
      Acidourico = txt_Ácidoúrico.getText().trim();
      Colesteroltotal = txt_Colesteroltotal.getText().trim();
      Triglicéridos = txt_Triglicéridos.getText().trim();

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
       if(Glucosaserica.equals("")) {
           txt_Glucosasérica.setBackground(Color.red);
           validacion++;     
       }
       if(Ureaserica.equals("")) {
           txt_Ureasérica.setBackground(Color.red);
           validacion++;     
       }
       if(Creatininaserica.equals("")) {
           txt_Creatininasérica.setBackground(Color.red);
           validacion++;     
       }
       if(NitrogenoureicoBUN.equals("")) {
           txt_NitrogenoureicoBUN.setBackground(Color.red);
           validacion++;     
       }
       if(RelacionBUNCreatinina.equals("")) {
           txt_RelaciónBUNCreatinina.setBackground(Color.red);
           validacion++;     
       }
       if(Acidourico.equals("")) {
           txt_Ácidoúrico.setBackground(Color.red);
           validacion++;     
       }
       if(Colesteroltotal.equals("")) {
           txt_Colesteroltotal.setBackground(Color.red);
           validacion++;     
       }
       if(Triglicéridos.equals("")) {
           txt_Triglicéridos.setBackground(Color.red);
           validacion++;     
       }
     
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "update QS619a50años set Fecha_entrega=?, Hora=?, Observaciones=?, Glucosaserica=?, Ureaserica=?, Creatininaserica=?, NitrogenoureicoBUN=?, RelacionBUNCreatinina=?, Acidourico=?, Colesteroltotal=?, Trigliceridos=?, ultima_modificacion=? " 
                   + "where ID_estudio = '" + IEstudio + "'");
             
         
             pst.setString(1, fechaEntrega);
             pst.setString(2, hora);
             pst.setString(3, observaciones);
             pst.setString(4, Glucosaserica);
             pst.setString(5, Ureaserica);
             pst.setString(6, Creatininaserica);
             pst.setString(7, NitrogenoureicoBUN);
             pst.setString(8, RelacionBUNCreatinina);
             pst.setString(9, Acidourico);
             pst.setString(10, Colesteroltotal);
             pst.setString(11, Triglicéridos);
             pst.setString(12, user);
    
             
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
             txt_Glucosasérica.setBackground(Color.green);
             txt_Ureasérica.setBackground(Color.green);
             txt_Creatininasérica.setBackground(Color.green);
             txt_NitrogenoureicoBUN.setBackground(Color.green);
             txt_RelaciónBUNCreatinina.setBackground(Color.green);
             txt_Ácidoúrico.setBackground(Color.green);
             txt_Colesteroltotal.setBackground(Color.green);
             txt_Triglicéridos.setBackground(Color.green);
             
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
                     "update QS619a50años set Hora=?, ultima_modificacion=?"
                     
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

        Paragraph estudio = new  Paragraph ("Estudio" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        estudio.setSpacingBefore(-3);
        estudio.setIndentationLeft(17);
        estudio.setSpacingAfter(-3);
        documento.add(estudio);
        
        Paragraph resultado = new  Paragraph ("Resultado"  , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        resultado.setSpacingBefore(-13);
        resultado.setIndentationLeft(240);
        resultado.setSpacingAfter(-3);
        documento.add(resultado);
        
        Paragraph valores = new  Paragraph ("Valores de referencia" , FontFactory.getFont("arial", 10, Font.BOLD , BaseColor.BLACK));
        valores.setSpacingBefore(-12);
        valores.setIndentationLeft(425);
        valores.setSpacingAfter(-3);
        documento.add(valores);

        Chunk chunk2 = new Chunk("Química sanguínea de 6 parámetros", FontFactory.getFont("arial", 12,Font.BOLD, BaseColor.BLACK));
        chunk2.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk = new  Paragraph ((chunk2));
        chunk.setSpacingBefore(10);
        chunk.setIndentationLeft(17);
        chunk.setSpacingAfter(-3);
        documento.add(chunk);
        
        Paragraph metodo = new  Paragraph ("Método: Espectrofotometría automatizada" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        metodo.setSpacingBefore(2);
        metodo.setIndentationLeft(17);
        metodo.setSpacingAfter(20);
        documento.add(metodo);

        double GlucosaséricaRe, UreaséricaRe, Creatininasérica, NitrógenoureicoBUN, RelaciónBUNC, Ácidoúrico, Colesterolt, 
        Triglicéridos; 
        
        GlucosaséricaRe = Double.parseDouble(txt_Glucosasérica.getText());
        UreaséricaRe = Double.parseDouble(txt_Ureasérica.getText());
        Creatininasérica = Double.parseDouble(txt_Creatininasérica.getText());
        NitrógenoureicoBUN = Double.parseDouble(txt_NitrogenoureicoBUN.getText());
        RelaciónBUNC = Double.parseDouble(txt_RelaciónBUNCreatinina.getText());
        Ácidoúrico = Double.parseDouble(txt_Ácidoúrico.getText());
        Colesterolt = Double.parseDouble(txt_Colesteroltotal.getText());
        Triglicéridos = Double.parseDouble(txt_Triglicéridos.getText());
     
        Paragraph GlucosaséricaR = new  Paragraph ("Glucosa sérica" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        GlucosaséricaR.setSpacingBefore(-11);
        GlucosaséricaR.setIndentationLeft(17);
        GlucosaséricaR.setSpacingAfter(-3);
        
        if(GlucosaséricaRe<70 || GlucosaséricaRe>100){
        documento.add(GlucosaséricaR);
        }
             
        Paragraph GlucosaséricaR1 = new  Paragraph ("Glucosa sérica" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        GlucosaséricaR1.setSpacingBefore(-11);
        GlucosaséricaR1.setIndentationLeft(17);
        GlucosaséricaR1.setSpacingAfter(-3);
        
        if(GlucosaséricaRe>=70 && GlucosaséricaRe<=100){
        documento.add(GlucosaséricaR1);
        }

        Paragraph GlucosaséricaRR = new  Paragraph (txt_Glucosasérica.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        GlucosaséricaRR.setAlignment(Element.ALIGN_CENTER);
        GlucosaséricaRR.setIndentationLeft(-95);
        GlucosaséricaRR.setSpacingBefore((float) -12.5);
        GlucosaséricaRR.setSpacingAfter(-3);

        
        if(GlucosaséricaRe<70 || GlucosaséricaRe>100){
        documento.add(GlucosaséricaRR);
        }
             
        Paragraph GlucosaséricaRR1 = new  Paragraph (txt_Glucosasérica.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        GlucosaséricaRR1.setAlignment(Element.ALIGN_CENTER);
        GlucosaséricaRR1.setIndentationLeft(-95);
        GlucosaséricaRR1.setSpacingBefore((float) -12.5);
        GlucosaséricaRR1.setSpacingAfter(-3);
        
        if(GlucosaséricaRe>=70 && GlucosaséricaRe<=100){
        documento.add(GlucosaséricaRR1);
        }

        Paragraph mgdL1 = new  Paragraph ("mg/dL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL1.setAlignment(Element.ALIGN_CENTER);
        mgdL1.setIndentationLeft(35);
        mgdL1.setSpacingBefore((float) -12.5);
        mgdL1.setSpacingAfter(-3);

        
        if(GlucosaséricaRe<70 || GlucosaséricaRe>100){
        documento.add(mgdL1);
        }
             
        Paragraph mgdL2 = new  Paragraph ("mg/dL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL2.setAlignment(Element.ALIGN_CENTER);
        mgdL2.setIndentationLeft(35);
        mgdL2.setSpacingBefore((float) -12.5);
        mgdL2.setSpacingAfter(-3);
        
        if(GlucosaséricaRe>=70 && GlucosaséricaRe<=100){
        documento.add(mgdL2);
        }

        Paragraph Num511 = new  Paragraph ("70" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num511.setAlignment(Element.ALIGN_CENTER);
        Num511.setSpacingBefore((float) -12);
        Num511.setIndentationLeft((float) 330);
        Num511.setSpacingAfter(-3);
     
        if(GlucosaséricaRe<70 || GlucosaséricaRe>100){
        documento.add(Num511);
        }

        Paragraph Num5111 = new  Paragraph ("70" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num5111.setAlignment(Element.ALIGN_CENTER);
        Num5111.setSpacingBefore((float) -12);
        Num5111.setIndentationLeft((float) 330);
        Num5111.setSpacingAfter(-3);

        if(GlucosaséricaRe>=70 && GlucosaséricaRe<=100){
        documento.add(Num5111);
        }
         
        Paragraph Num411 = new  Paragraph ("100" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num411.setAlignment(Element.ALIGN_CENTER);
        Num411.setSpacingBefore((float) -12);
        Num411.setIndentationLeft((float) 450);
        Num411.setSpacingAfter(-3);
        
        if(GlucosaséricaRe<70 || GlucosaséricaRe>100){
        documento.add(Num411);
        }

        Paragraph Num4111 = new  Paragraph ("100" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num4111.setAlignment(Element.ALIGN_CENTER);
        Num4111.setSpacingBefore((float) -12);
        Num4111.setIndentationLeft((float) 450);
        Num4111.setSpacingAfter(-3);
        
        if(GlucosaséricaRe>=70 && GlucosaséricaRe<=100){
        documento.add(Num4111);
        }

        Paragraph UreaséricaR = new  Paragraph ("Urea sérica" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        UreaséricaR.setSpacingBefore(2);
        UreaséricaR.setIndentationLeft(17);
        UreaséricaR.setSpacingAfter(-3);
        
        if( UreaséricaRe<15 ||  UreaséricaRe>40){
        documento.add(UreaséricaR);
        }
             
        Paragraph UreaséricaRR1 = new  Paragraph ("Urea sérica" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        UreaséricaRR1.setSpacingBefore(2);
        UreaséricaRR1.setIndentationLeft(17);
        UreaséricaRR1.setSpacingAfter(-3);
        
        if(UreaséricaRe>=15 && UreaséricaRe<=40){
        documento.add(UreaséricaRR1);
        }

        Paragraph UreaséricaP = new  Paragraph (txt_Ureasérica.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        UreaséricaP.setAlignment(Element.ALIGN_CENTER);
        UreaséricaP.setIndentationLeft(-95);
        UreaséricaP.setSpacingBefore((float) -12.5);
        UreaséricaP.setSpacingAfter(-3);

        
        if(UreaséricaRe<15 || UreaséricaRe>40){
        documento.add(UreaséricaP);
        }

        Paragraph UreaséricaP1 = new  Paragraph (txt_Ureasérica.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        UreaséricaP1.setAlignment(Element.ALIGN_CENTER);
        UreaséricaP1.setIndentationLeft(-95);
        UreaséricaP1.setSpacingBefore((float) -12.5);
        UreaséricaP1.setSpacingAfter(-3);

        
        if(UreaséricaRe>=15 && UreaséricaRe<=40){
        documento.add(UreaséricaP1);
        }

        Paragraph mgdL3 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL3.setAlignment(Element.ALIGN_CENTER);
        mgdL3.setIndentationLeft(35);
        mgdL3.setSpacingBefore((float) -12.5);
        mgdL3.setSpacingAfter(-3);

        
        if(UreaséricaRe<15 || UreaséricaRe>40){
        documento.add(mgdL3);
        }

        Paragraph mgdL4 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL4.setAlignment(Element.ALIGN_CENTER);
        mgdL4.setIndentationLeft(35);
        mgdL4.setSpacingBefore((float) -12.5);
        mgdL4.setSpacingAfter(-3);

        
        if(UreaséricaRe>=15 && UreaséricaRe<=40){
        documento.add(mgdL4);
        }
             
  
        Paragraph Num15 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num15.setAlignment(Element.ALIGN_CENTER);
        Num15.setSpacingBefore((float) -12);
        Num15.setIndentationLeft((float) 330);
        Num15.setSpacingAfter(-3);
     
        if(UreaséricaRe<15 || UreaséricaRe>40){
        documento.add(Num15);
        }

        Paragraph Num15T = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num15T.setAlignment(Element.ALIGN_CENTER);
        Num15T.setSpacingBefore((float) -12);
        Num15T.setIndentationLeft((float) 330);
        Num15T.setSpacingAfter(-3);

        if(UreaséricaRe>=15 && UreaséricaRe<=40){
        documento.add(Num15T);
        }
         
        Paragraph Num40 = new  Paragraph ("40" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num40.setAlignment(Element.ALIGN_CENTER);
        Num40.setSpacingBefore((float) -12);
        Num40.setIndentationLeft((float) 450);
        Num40.setSpacingAfter(-3);
        
        if(UreaséricaRe<15 || UreaséricaRe>40){
        documento.add(Num40);
        }

        Paragraph Num40T = new  Paragraph ("40" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num40T.setAlignment(Element.ALIGN_CENTER);
        Num40T.setSpacingBefore((float) -12);
        Num40T.setIndentationLeft((float) 450);
        Num40T.setSpacingAfter(-3);
        
        if(UreaséricaRe>=15 && UreaséricaRe<=40){
        documento.add(Num40T);
        }

        Paragraph CreatininaséricaR = new  Paragraph ("Creatinina sérica" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CreatininaséricaR.setSpacingBefore(2);
        CreatininaséricaR.setIndentationLeft(17);
        CreatininaséricaR.setSpacingAfter(-3);
        
        if(Creatininasérica<0.57 ||  Creatininasérica>1.11){
        documento.add(CreatininaséricaR);
        }
             
        Paragraph CreatininaséricaR1 = new  Paragraph ("Creatinina sérica" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CreatininaséricaR1.setSpacingBefore(2);
        CreatininaséricaR1.setIndentationLeft(17);
        CreatininaséricaR1.setSpacingAfter(-3);
        
        if(Creatininasérica>=0.57 && Creatininasérica<=1.11){
        documento.add(CreatininaséricaR1);
        }

        Paragraph CreatininaséricaP = new  Paragraph (txt_Creatininasérica.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CreatininaséricaP.setAlignment(Element.ALIGN_CENTER);
        CreatininaséricaP.setIndentationLeft(-95);
        CreatininaséricaP.setSpacingBefore((float) -12.5);
        CreatininaséricaP.setSpacingAfter(-3);

        
        if(Creatininasérica<0.57 || Creatininasérica>1.11){
        documento.add(CreatininaséricaP);
        }

        Paragraph CreatininaséricaP1 = new  Paragraph (txt_Creatininasérica.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CreatininaséricaP1.setAlignment(Element.ALIGN_CENTER);
        CreatininaséricaP1.setIndentationLeft(-95);
        CreatininaséricaP1.setSpacingBefore((float) -12.5);
        CreatininaséricaP1.setSpacingAfter(-3);

        if(Creatininasérica>=0.57 && Creatininasérica<=1.11){
        documento.add(CreatininaséricaP1);
        }

        Paragraph mgdL5 = new  Paragraph ("mg/dL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL5.setAlignment(Element.ALIGN_CENTER);
        mgdL5.setIndentationLeft(35);
        mgdL5.setSpacingBefore((float) -12.5);
        mgdL5.setSpacingAfter(-3);

        
        if(Creatininasérica<0.57 || Creatininasérica>1.11){
        documento.add(mgdL5);
        }

        Paragraph mgdL6 = new  Paragraph ("mg/dL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL6.setAlignment(Element.ALIGN_CENTER);
        mgdL6.setIndentationLeft(35);
        mgdL6.setSpacingBefore((float) -12.5);
        mgdL6.setSpacingAfter(-3);

        if(Creatininasérica>=0.57 && Creatininasérica<=1.11){
        documento.add(mgdL6);
        }

        Paragraph Num057 = new  Paragraph ("0.57" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num057.setAlignment(Element.ALIGN_CENTER);
        Num057.setSpacingBefore((float) -12);
        Num057.setIndentationLeft((float) 330);
        Num057.setSpacingAfter(-3);
     
        if(Creatininasérica<0.57 || Creatininasérica>1.11){
        documento.add(Num057);
        }

        Paragraph Num057T = new  Paragraph ("0.57" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num057T.setAlignment(Element.ALIGN_CENTER);
        Num057T.setSpacingBefore((float) -12);
        Num057T.setIndentationLeft((float) 330);
        Num057T.setSpacingAfter(-3);

        if(Creatininasérica>=0.57 && Creatininasérica<=1.11){
        documento.add(Num057T);
        }
         
        Paragraph Num111 = new  Paragraph ("1.11" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num111.setAlignment(Element.ALIGN_CENTER);
        Num111.setSpacingBefore((float) -12);
        Num111.setIndentationLeft((float) 450);
        Num111.setSpacingAfter(-3);
        
        if(Creatininasérica<0.57 || Creatininasérica>1.11){
        documento.add(Num111);
        }

        Paragraph Num111T = new  Paragraph ("1.11" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num111T.setAlignment(Element.ALIGN_CENTER);
        Num111T.setSpacingBefore((float) -12);
        Num111T.setIndentationLeft((float) 450);
        Num111T.setSpacingAfter(-3);
        
        if(Creatininasérica>=0.57 && Creatininasérica<=1.11){
        documento.add(Num111T);
        }

        Paragraph NitrógenoureicoBUNR = new  Paragraph ("Nitrógeno ureico (BUN)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NitrógenoureicoBUNR.setSpacingBefore(2);
        NitrógenoureicoBUNR.setIndentationLeft(17);
        NitrógenoureicoBUNR.setSpacingAfter(-3);
        
        if(NitrógenoureicoBUN<7 ||   NitrógenoureicoBUN>19){
        documento.add(NitrógenoureicoBUNR);
        }
             
        Paragraph NitrógenoureicoBUNR1 = new  Paragraph ("Nitrógeno ureico (BUN)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NitrógenoureicoBUNR1.setSpacingBefore(2);
        NitrógenoureicoBUNR1.setIndentationLeft(17);
        NitrógenoureicoBUNR1.setSpacingAfter(-3);
        
        if(NitrógenoureicoBUN>=7 && NitrógenoureicoBUN<=19){
        documento.add(NitrógenoureicoBUNR1);
        }

        Paragraph NitrógenoureicoBUNP = new  Paragraph (txt_NitrogenoureicoBUN.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NitrógenoureicoBUNP.setAlignment(Element.ALIGN_CENTER);
        NitrógenoureicoBUNP.setIndentationLeft(-95);
        NitrógenoureicoBUNP.setSpacingBefore((float) -12.5);
        NitrógenoureicoBUNP.setSpacingAfter(-3);

        if(NitrógenoureicoBUN<7 || NitrógenoureicoBUN>19){
        documento.add(NitrógenoureicoBUNP);
        }

        Paragraph NitrógenoureicoBUNP1 = new  Paragraph (txt_NitrogenoureicoBUN.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NitrógenoureicoBUNP1.setAlignment(Element.ALIGN_CENTER);
        NitrógenoureicoBUNP1.setIndentationLeft(-95);
        NitrógenoureicoBUNP1.setSpacingBefore((float) -12.5);
        NitrógenoureicoBUNP1.setSpacingAfter(-3);

        if(NitrógenoureicoBUN>=7 && NitrógenoureicoBUN<=19){
        documento.add(NitrógenoureicoBUNP1);
        }

        Paragraph mgdL7 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL7.setAlignment(Element.ALIGN_CENTER);
        mgdL7.setIndentationLeft(35);
        mgdL7.setSpacingBefore((float) -12.5);
        mgdL7.setSpacingAfter(-3);

        if(NitrógenoureicoBUN<7 || NitrógenoureicoBUN>19){
        documento.add(mgdL7);
        }

        Paragraph mgdL8 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL8.setAlignment(Element.ALIGN_CENTER);
        mgdL8.setIndentationLeft(35);
        mgdL8.setSpacingBefore((float) -12.5);
        mgdL8.setSpacingAfter(-3);

        if(NitrógenoureicoBUN>=7 && NitrógenoureicoBUN<=19){
        documento.add(mgdL8);
        }

        Paragraph Num7 = new  Paragraph ("7" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num7.setAlignment(Element.ALIGN_CENTER);
        Num7.setSpacingBefore((float) -12);
        Num7.setIndentationLeft((float) 330);
        Num7.setSpacingAfter(-3);
     
        if(NitrógenoureicoBUN<7 || NitrógenoureicoBUN>19){
        documento.add(Num7);
        }

        Paragraph Num7T = new  Paragraph ("7" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num7T.setAlignment(Element.ALIGN_CENTER);
        Num7T.setSpacingBefore((float) -12);
        Num7T.setIndentationLeft((float) 330);
        Num7T.setSpacingAfter(-3);

        if(NitrógenoureicoBUN>=7 && NitrógenoureicoBUN<=19){
        documento.add(Num7T);
        }
         
        Paragraph Num19 = new  Paragraph ("19" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num19.setAlignment(Element.ALIGN_CENTER);
        Num19.setSpacingBefore((float) -12);
        Num19.setIndentationLeft((float) 450);
        Num19.setSpacingAfter(-3);
        
        if(NitrógenoureicoBUN<7 || NitrógenoureicoBUN>19){
        documento.add(Num19);
        }

        Paragraph Num19T = new  Paragraph ("19" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num19T.setAlignment(Element.ALIGN_CENTER);
        Num19T.setSpacingBefore((float) -12);
        Num19T.setIndentationLeft((float) 450);
        Num19T.setSpacingAfter(-3);
        
        if(NitrógenoureicoBUN>=7 && NitrógenoureicoBUN<=19){
        documento.add(Num19T);
        }

        Paragraph RelaciónBUNCR = new  Paragraph ("Relación BUN/Creatinina" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RelaciónBUNCR.setSpacingBefore(2);
        RelaciónBUNCR.setIndentationLeft(17);
        RelaciónBUNCR.setSpacingAfter(-3);
        
        if(RelaciónBUNC<10 || RelaciónBUNC>20){
        documento.add(RelaciónBUNCR);
        }
             
        Paragraph RelaciónBUNCR1 = new  Paragraph ("Relación BUN/Creatinina" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RelaciónBUNCR1.setSpacingBefore(2);
        RelaciónBUNCR1.setIndentationLeft(17);
        RelaciónBUNCR1.setSpacingAfter(-3);
        
        if(RelaciónBUNC>=10 && RelaciónBUNC<=20){
        documento.add(RelaciónBUNCR1);
        }

        Paragraph RelaciónBUNCRP = new  Paragraph (txt_RelaciónBUNCreatinina.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RelaciónBUNCRP.setAlignment(Element.ALIGN_CENTER);
        RelaciónBUNCRP.setIndentationLeft(-95);
        RelaciónBUNCRP.setSpacingBefore((float) -12.5);
        RelaciónBUNCRP.setSpacingAfter(-3);

        if(RelaciónBUNC<10 || RelaciónBUNC>20){
        documento.add(RelaciónBUNCRP);
        }

        Paragraph RelaciónBUNCRP1 = new  Paragraph (txt_RelaciónBUNCreatinina.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RelaciónBUNCRP1.setAlignment(Element.ALIGN_CENTER);
        RelaciónBUNCRP1.setIndentationLeft(-95);
        RelaciónBUNCRP1.setSpacingBefore((float) -12.5);
        RelaciónBUNCRP1.setSpacingAfter(-3);

        if(RelaciónBUNC>=10 && RelaciónBUNC<=20){
        documento.add(RelaciónBUNCRP1);
        }

        Paragraph mgdL9 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL9.setAlignment(Element.ALIGN_CENTER);
        mgdL9.setIndentationLeft(35);
        mgdL9.setSpacingBefore((float) -12.5);
        mgdL9.setSpacingAfter(-3);

        if(RelaciónBUNC<10 || RelaciónBUNC>20){
        documento.add(mgdL9);
        }

        Paragraph mgdL10 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL10.setAlignment(Element.ALIGN_CENTER);
        mgdL10.setIndentationLeft(35);
        mgdL10.setSpacingBefore((float) -12.5);
        mgdL10.setSpacingAfter(-3);

        if(RelaciónBUNC>=10 && RelaciónBUNC<=20){
        documento.add(mgdL10);
        }

        Paragraph Num10 = new  Paragraph ("10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num10.setAlignment(Element.ALIGN_CENTER);
        Num10.setSpacingBefore((float) -12);
        Num10.setIndentationLeft((float) 330);
        Num10.setSpacingAfter(-3);
     
        if(RelaciónBUNC<10 || RelaciónBUNC>20){
        documento.add(Num10);
        }

        Paragraph Num10T = new  Paragraph ("10" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num10T.setAlignment(Element.ALIGN_CENTER);
        Num10T.setSpacingBefore((float) -12);
        Num10T.setIndentationLeft((float) 330);
        Num10T.setSpacingAfter(-3);

        if(RelaciónBUNC>=10 && RelaciónBUNC<=20){
        documento.add(Num10T);
        }
         
        Paragraph Num20 = new  Paragraph ("20" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num20.setAlignment(Element.ALIGN_CENTER);
        Num20.setSpacingBefore((float) -12);
        Num20.setIndentationLeft((float) 450);
        Num20.setSpacingAfter(-3);
        
        if(RelaciónBUNC<10 || RelaciónBUNC>20){
        documento.add(Num20);
        }

        Paragraph Num20T = new  Paragraph ("20" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num20T.setAlignment(Element.ALIGN_CENTER);
        Num20T.setSpacingBefore((float) -12);
        Num20T.setIndentationLeft((float) 450);
        Num20T.setSpacingAfter(-3);
        
        if(RelaciónBUNC>=10 && RelaciónBUNC<=20){
        documento.add(Num20T);
        }

        Paragraph ÁcidoúricoR = new  Paragraph ("Ácido úrico" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        ÁcidoúricoR.setSpacingBefore(2);
        ÁcidoúricoR.setIndentationLeft(17);
        ÁcidoúricoR.setSpacingAfter(-3);
        
        if(Ácidoúrico<2.4 || Ácidoúrico>5.7){
        documento.add(ÁcidoúricoR);
        }
             
        Paragraph ÁcidoúricoR1 = new  Paragraph ("Ácido úrico" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        ÁcidoúricoR1.setSpacingBefore(2);
        ÁcidoúricoR1.setIndentationLeft(17);
        ÁcidoúricoR1.setSpacingAfter(-3);
        
        if(Ácidoúrico>=2.4 && Ácidoúrico<=5.7){
        documento.add(ÁcidoúricoR1);
        }

        Paragraph ÁcidoúricoRP = new  Paragraph (txt_Ácidoúrico.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        ÁcidoúricoRP.setAlignment(Element.ALIGN_CENTER);
        ÁcidoúricoRP.setIndentationLeft(-95);
        ÁcidoúricoRP.setSpacingBefore((float) -12.5);
        ÁcidoúricoRP.setSpacingAfter(-3);

        if(Ácidoúrico<2.4 || Ácidoúrico>5.7){
        documento.add(ÁcidoúricoRP);
        }

        Paragraph ÁcidoúricoRP1 = new  Paragraph (txt_Ácidoúrico.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        ÁcidoúricoRP1.setAlignment(Element.ALIGN_CENTER);
        ÁcidoúricoRP1.setIndentationLeft(-95);
        ÁcidoúricoRP1.setSpacingBefore((float) -12.5);
        ÁcidoúricoRP1.setSpacingAfter(-3);

        if(Ácidoúrico>=2.4 && Ácidoúrico<=5.7){
        documento.add(ÁcidoúricoRP1);
        }

        Paragraph mgdL11 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL11.setAlignment(Element.ALIGN_CENTER);
        mgdL11.setIndentationLeft(35);
        mgdL11.setSpacingBefore((float) -12.5);
        mgdL11.setSpacingAfter(-3);

        if(Ácidoúrico<2.4 || Ácidoúrico>5.7){
        documento.add(mgdL11);
        }

        Paragraph mgdL12 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL12.setAlignment(Element.ALIGN_CENTER);
        mgdL12.setIndentationLeft(35);
        mgdL12.setSpacingBefore((float) -12.5);
        mgdL12.setSpacingAfter(-3);

        if(Ácidoúrico>=2.4 && Ácidoúrico<=5.7){
        documento.add(mgdL12);
        }

        Paragraph Num24 = new  Paragraph ("2.4" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num24.setAlignment(Element.ALIGN_CENTER);
        Num24.setSpacingBefore((float) -12);
        Num24.setIndentationLeft((float) 330);
        Num24.setSpacingAfter(-3);
     
        if(Ácidoúrico<2.4 || Ácidoúrico>5.7){
        documento.add(Num24);
        }

        Paragraph Num24T = new  Paragraph ("2.4" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num24T.setAlignment(Element.ALIGN_CENTER);
        Num24T.setSpacingBefore((float) -12);
        Num24T.setIndentationLeft((float) 330);
        Num24T.setSpacingAfter(-3);

        if(Ácidoúrico>=2.4 && Ácidoúrico<=5.7){
        documento.add(Num24T);
        }
         
        Paragraph Num57 = new  Paragraph ("5.7" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num57.setAlignment(Element.ALIGN_CENTER);
        Num57.setSpacingBefore((float) -12);
        Num57.setIndentationLeft((float) 450);
        Num57.setSpacingAfter(-3);
        
        if(Ácidoúrico<2.4 || Ácidoúrico>5.7){
        documento.add(Num57);
        }

        Paragraph Num57T = new  Paragraph ("5.7" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num57T.setAlignment(Element.ALIGN_CENTER);
        Num57T.setSpacingBefore((float) -12);
        Num57T.setIndentationLeft((float) 450);
        Num57T.setSpacingAfter(-3);
        
        if(Ácidoúrico>=2.4 && Ácidoúrico<=5.7){
        documento.add(Num57T);
        }

        Paragraph ColesterolTR = new  Paragraph ("Colesterol total" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        ColesterolTR.setSpacingBefore(2);
        ColesterolTR.setIndentationLeft(17);
        ColesterolTR.setSpacingAfter(-3);
        
        if(Colesterolt<0 || Colesterolt>199){
        documento.add(ColesterolTR);
        }
             
        Paragraph ColesterolTR1 = new  Paragraph ("Colesterol total" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        ColesterolTR1.setSpacingBefore(2);
        ColesterolTR1.setIndentationLeft(17);
        ColesterolTR1.setSpacingAfter(-3);
        
        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(ColesterolTR1);
        }

        Paragraph ColesterolTP = new  Paragraph (txt_Colesteroltotal.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        ColesterolTP.setAlignment(Element.ALIGN_CENTER);
        ColesterolTP.setIndentationLeft(-95);
        ColesterolTP.setSpacingBefore((float) -12.5);
        ColesterolTP.setSpacingAfter(-3);

        if(Colesterolt<0 || Colesterolt>199){
        documento.add(ColesterolTP);
        }

        Paragraph ColesterolTP1 = new  Paragraph (txt_Colesteroltotal.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        ColesterolTP1.setAlignment(Element.ALIGN_CENTER);
        ColesterolTP1.setIndentationLeft(-95);
        ColesterolTP1.setSpacingBefore((float) -12.5);
        ColesterolTP1.setSpacingAfter(-3);

        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(ColesterolTP1);
        }

        Paragraph mgdL13 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL13.setAlignment(Element.ALIGN_CENTER);
        mgdL13.setIndentationLeft(35);
        mgdL13.setSpacingBefore((float) -12.5);
        mgdL13.setSpacingAfter(-3);

        if(Colesterolt<0 || Colesterolt>199){
        documento.add(mgdL13);
        }

        Paragraph mgdL14 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL14.setAlignment(Element.ALIGN_CENTER);
        mgdL14.setIndentationLeft(35);
        mgdL14.setSpacingBefore((float) -12.5);
        mgdL14.setSpacingAfter(-3);

        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(mgdL14);
        }

        Paragraph Aconsejable = new  Paragraph ("Aconsejable" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Aconsejable.setAlignment(Element.ALIGN_CENTER);
        Aconsejable.setSpacingBefore((float) -12);
        Aconsejable.setIndentationLeft((float) 180);
        Aconsejable.setSpacingAfter(-3);

        if(Colesterolt<0 || Colesterolt>199){
        documento.add(Aconsejable);
        }

        Paragraph AconsejableT = new  Paragraph ("Aconsejable" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        AconsejableT.setAlignment(Element.ALIGN_CENTER);
        AconsejableT.setSpacingBefore((float) -12);
        AconsejableT.setIndentationLeft((float) 180);
        AconsejableT.setSpacingAfter(-3);

        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(AconsejableT);
        }

        Paragraph Num0 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num0.setAlignment(Element.ALIGN_CENTER);
        Num0.setSpacingBefore((float) -12);
        Num0.setIndentationLeft((float) 330);
        Num0.setSpacingAfter(-3);
     
        if(Colesterolt<0 || Colesterolt>199){
        documento.add(Num0);
        }

        Paragraph Num0T = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num0T.setAlignment(Element.ALIGN_CENTER);
        Num0T.setSpacingBefore((float) -12);
        Num0T.setIndentationLeft((float) 330);
        Num0T.setSpacingAfter(-3);

        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(Num0T);
        }
         
        Paragraph Num199 = new  Paragraph ("199" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num199.setAlignment(Element.ALIGN_CENTER);
        Num199.setSpacingBefore((float) -12);
        Num199.setIndentationLeft((float) 450);
        Num199.setSpacingAfter(-3);
        
        if(Colesterolt<0 || Colesterolt>199){
        documento.add(Num199);
        }

        Paragraph Num199T = new  Paragraph ("199" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num199T.setAlignment(Element.ALIGN_CENTER);
        Num199T.setSpacingBefore((float) -12);
        Num199T.setIndentationLeft((float) 450);
        Num199T.setSpacingAfter(-3);
        
        if(Colesterolt>=0 && Colesterolt<=199){
        documento.add(Num199T);
        }
        
        Paragraph Riesgomoderado = new  Paragraph ("Riesgo moderado" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Riesgomoderado.setAlignment(Element.ALIGN_CENTER);
        Riesgomoderado.setSpacingBefore(2);
        Riesgomoderado.setIndentationLeft(180);
        Riesgomoderado.setSpacingAfter(-3);
        
        if(Colesterolt>=200 && Colesterolt<=239){
        documento.add(Riesgomoderado);
        }

        Paragraph Riesgomoderado1 = new  Paragraph ("Riesgo moderado" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Riesgomoderado1.setAlignment(Element.ALIGN_CENTER);
        Riesgomoderado1.setSpacingBefore(2);
        Riesgomoderado1.setIndentationLeft(180);
        Riesgomoderado1.setSpacingAfter(-3);
        
        if(Colesterolt<200 || Colesterolt>239){
        documento.add(Riesgomoderado1);
        }

        Paragraph Num200 = new  Paragraph ("200" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num200.setAlignment(Element.ALIGN_CENTER);
        Num200.setSpacingBefore((float) -12);
        Num200.setIndentationLeft((float) 330);
        Num200.setSpacingAfter(-3);
     
        if(Colesterolt>=200 && Colesterolt<=239){
        documento.add(Num200);
        }

        Paragraph Num200T = new  Paragraph ("200" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num200T.setAlignment(Element.ALIGN_CENTER);
        Num200T.setSpacingBefore((float) -12);
        Num200T.setIndentationLeft((float) 330);
        Num200T.setSpacingAfter(-3);

        if(Colesterolt<200 || Colesterolt>239){
        documento.add(Num200T);
        }
         
        Paragraph Num239 = new  Paragraph ("239" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num239.setAlignment(Element.ALIGN_CENTER);
        Num239.setSpacingBefore((float) -12);
        Num239.setIndentationLeft((float) 450);
        Num239.setSpacingAfter(-3);
        
        if(Colesterolt>=200 && Colesterolt<=239){
        documento.add(Num239);
        }

        Paragraph Num239T = new  Paragraph ("239" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num239T.setAlignment(Element.ALIGN_CENTER);
        Num239T.setSpacingBefore((float) -12);
        Num239T.setIndentationLeft((float) 450);
        Num239T.setSpacingAfter(-3);
        
        if(Colesterolt<200 || Colesterolt>239){
        documento.add(Num239T);
        }
       
        Paragraph Riesgoalto = new  Paragraph ("Riesgo alto" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Riesgoalto.setAlignment(Element.ALIGN_CENTER);
        Riesgoalto.setSpacingBefore(2);
        Riesgoalto.setIndentationLeft(180);
        Riesgoalto.setSpacingAfter(-3);
        
        if(Colesterolt>=240){
        documento.add(Riesgoalto);
        }

        Paragraph Riesgoalto1 = new  Paragraph ("Riesgo alto" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Riesgoalto1.setAlignment(Element.ALIGN_CENTER);
        Riesgoalto1.setSpacingBefore(2);
        Riesgoalto1.setIndentationLeft(180);
        Riesgoalto1.setSpacingAfter(-3);
        
        if(Colesterolt<240){
        documento.add(Riesgoalto1);
        }

        Paragraph Másde = new  Paragraph ("Más de" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Másde.setAlignment(Element.ALIGN_CENTER);
        Másde.setSpacingBefore((float) -12);
        Másde.setIndentationLeft((float) 330);
        Másde.setSpacingAfter(-3);
     
        if(Colesterolt>=240){
        documento.add(Másde);
        }

        Paragraph Másde1 = new  Paragraph ("Más de" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Másde1.setAlignment(Element.ALIGN_CENTER);
        Másde1.setSpacingBefore((float) -12);
        Másde1.setIndentationLeft((float) 330);
        Másde1.setSpacingAfter(-3);

        if(Colesterolt<240){
        documento.add(Másde1);
        }
         
        Paragraph Num240 = new  Paragraph ("240" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num240.setAlignment(Element.ALIGN_CENTER);
        Num240.setSpacingBefore((float) -12);
        Num240.setIndentationLeft((float) 450);
        Num240.setSpacingAfter(-3);
        
        if(Colesterolt>=240){
        documento.add(Num240);
        }

        Paragraph Num2401 = new  Paragraph ("240" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num2401.setAlignment(Element.ALIGN_CENTER);
        Num2401.setSpacingBefore((float) -12);
        Num2401.setIndentationLeft((float) 450);
        Num2401.setSpacingAfter(-3);
        
        if(Colesterolt<240){
        documento.add(Num2401);
        }

        Paragraph TriglicéridosR = new  Paragraph ("Triglicéridos" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        TriglicéridosR.setSpacingBefore(2);
        TriglicéridosR.setIndentationLeft(17);
        TriglicéridosR.setSpacingAfter(-3);
        
        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(TriglicéridosR);
        }
       
        Paragraph TriglicéridosR1 = new  Paragraph ("Triglicéridos" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        TriglicéridosR1.setSpacingBefore(2);
        TriglicéridosR1.setIndentationLeft(17);
        TriglicéridosR1.setSpacingAfter(-3);
        
        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(TriglicéridosR1);
        }

        Paragraph TriglicéridosRP = new  Paragraph (txt_Triglicéridos.getText(), FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        TriglicéridosRP.setAlignment(Element.ALIGN_CENTER);
        TriglicéridosRP.setIndentationLeft(-95);
        TriglicéridosRP.setSpacingBefore((float) -12.5);
        TriglicéridosRP.setSpacingAfter(-3);

        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(TriglicéridosRP);
        }

        Paragraph TriglicéridosRP1 = new  Paragraph (txt_Triglicéridos.getText(), FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        TriglicéridosRP1.setAlignment(Element.ALIGN_CENTER);
        TriglicéridosRP1.setIndentationLeft(-95);
        TriglicéridosRP1.setSpacingBefore((float) -12.5);
        TriglicéridosRP1.setSpacingAfter(-3);

        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(TriglicéridosRP1);
        }

        Paragraph mgdL15 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        mgdL15.setAlignment(Element.ALIGN_CENTER);
        mgdL15.setIndentationLeft(35);
        mgdL15.setSpacingBefore((float) -12.5);
        mgdL15.setSpacingAfter(-3);

        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(mgdL15);
        }

        Paragraph mgdL16 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        mgdL16.setAlignment(Element.ALIGN_CENTER);
        mgdL16.setIndentationLeft(35);
        mgdL16.setSpacingBefore((float) -12.5);
        mgdL16.setSpacingAfter(-3);

        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(mgdL16);
        }

        Paragraph Normal = new  Paragraph ("Normal" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Normal.setAlignment(Element.ALIGN_CENTER);
        Normal.setSpacingBefore((float) -12);
        Normal.setIndentationLeft((float) 180);
        Normal.setSpacingAfter(-3);

        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(Normal);
        }

        Paragraph Normal1 = new  Paragraph ("Normal" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Normal1.setAlignment(Element.ALIGN_CENTER);
        Normal1.setSpacingBefore((float) -12);
        Normal1.setIndentationLeft((float) 180);
        Normal1.setSpacingAfter(-3);

        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(Normal1);
        }

        Paragraph Num0A = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num0A.setAlignment(Element.ALIGN_CENTER);
        Num0A.setSpacingBefore((float) -12);
        Num0A.setIndentationLeft((float) 330);
        Num0A.setSpacingAfter(-3);
     
        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(Num0A);
        }

        Paragraph Num0TAA = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num0TAA.setAlignment(Element.ALIGN_CENTER);
        Num0TAA.setSpacingBefore((float) -12);
        Num0TAA.setIndentationLeft((float) 330);
        Num0TAA.setSpacingAfter(-3);

        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(Num0TAA);
        }
         
        Paragraph Num149 = new  Paragraph ("149" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num149.setAlignment(Element.ALIGN_CENTER);
        Num149.setSpacingBefore((float) -12);
        Num149.setIndentationLeft((float) 450);
        Num149.setSpacingAfter(-3);
        
        if(Triglicéridos<0 || Triglicéridos>149){
        documento.add(Num149);
        }

        Paragraph Num149T = new  Paragraph ("149" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num149T.setAlignment(Element.ALIGN_CENTER);
        Num149T.setSpacingBefore((float) -12);
        Num149T.setIndentationLeft((float) 450);
        Num149T.setSpacingAfter(-3);
        
        if(Triglicéridos>=0 && Triglicéridos<=149){
        documento.add(Num149T);
        }

        Paragraph Límitealto = new  Paragraph ("Límite alto" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Límitealto.setAlignment(Element.ALIGN_CENTER);
        Límitealto.setSpacingBefore(2);
        Límitealto.setIndentationLeft(180);
        Límitealto.setSpacingAfter(-3);
        
        if(Triglicéridos>=150 && Triglicéridos<=199){
        documento.add(Límitealto);
        }

        Paragraph Límitealto1 = new  Paragraph ("Límite alto" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Límitealto1.setAlignment(Element.ALIGN_CENTER);
        Límitealto1.setSpacingBefore(2);
        Límitealto1.setIndentationLeft(180);
        Límitealto1.setSpacingAfter(-3);
        
        if(Triglicéridos<150 || Triglicéridos>199){
        documento.add(Límitealto1);
        }

        Paragraph Num150 = new  Paragraph ("150" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num150.setAlignment(Element.ALIGN_CENTER);
        Num150.setSpacingBefore((float) -12);
        Num150.setIndentationLeft((float) 330);
        Num150.setSpacingAfter(-3);
     
        if(Triglicéridos>=150 && Triglicéridos<=199){
        documento.add(Num150);
        }

        Paragraph Num150T = new  Paragraph ("150" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num150T.setAlignment(Element.ALIGN_CENTER);
        Num150T.setSpacingBefore((float) -12);
        Num150T.setIndentationLeft((float) 330);
        Num150T.setSpacingAfter(-3);

        if(Triglicéridos<150 || Triglicéridos>199){
        documento.add(Num150T);
        }
         
        Paragraph Num199A = new  Paragraph ("199" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num199A.setAlignment(Element.ALIGN_CENTER);
        Num199A.setSpacingBefore((float) -12);
        Num199A.setIndentationLeft((float) 450);
        Num199A.setSpacingAfter(-3);
        
        if(Triglicéridos>=150 && Triglicéridos<=199){
        documento.add(Num199A);
        }

        Paragraph Num199A1 = new  Paragraph ("199" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num199A1.setAlignment(Element.ALIGN_CENTER);
        Num199A1.setSpacingBefore((float) -12);
        Num199A1.setIndentationLeft((float) 450);
        Num199A1.setSpacingAfter(-3);
        
        if(Triglicéridos<150 || Triglicéridos>199){
        documento.add(Num199A1);
        }

        Paragraph Alto = new  Paragraph ("Alto" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Alto.setAlignment(Element.ALIGN_CENTER);
        Alto.setSpacingBefore(2);
        Alto.setIndentationLeft(180);
        Alto.setSpacingAfter(-3);
        
        if(Triglicéridos>=200 && Triglicéridos<=499){
        documento.add(Alto);
        }

        Paragraph Alto1 = new  Paragraph ("Alto" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Alto1.setAlignment(Element.ALIGN_CENTER);
        Alto1.setSpacingBefore(2);
        Alto1.setIndentationLeft(180);
        Alto1.setSpacingAfter(-3);
        
        if(Triglicéridos<200 || Triglicéridos>499){
        documento.add(Alto1);
        }

        Paragraph Num200E = new  Paragraph ("200" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num200E.setAlignment(Element.ALIGN_CENTER);
        Num200E.setSpacingBefore((float) -12);
        Num200E.setIndentationLeft((float) 330);
        Num200E.setSpacingAfter(-3);
     
        if(Triglicéridos>=200 && Triglicéridos<=499){
        documento.add(Num200E);
        }

        Paragraph Num200E1 = new  Paragraph ("200" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num200E1.setAlignment(Element.ALIGN_CENTER);
        Num200E1.setSpacingBefore((float) -12);
        Num200E1.setIndentationLeft((float) 330);
        Num200E1.setSpacingAfter(-3);

        if(Triglicéridos<200 || Triglicéridos>499){
        documento.add(Num200E1);
        }
         
        Paragraph Num499A = new  Paragraph ("499" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num499A.setAlignment(Element.ALIGN_CENTER);
        Num499A.setSpacingBefore((float) -12);
        Num499A.setIndentationLeft((float) 450);
        Num499A.setSpacingAfter(-3);
        
        if(Triglicéridos>=200 && Triglicéridos<=499){
        documento.add(Num499A);
        }

        Paragraph Num499A1 = new  Paragraph ("499" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num499A1.setAlignment(Element.ALIGN_CENTER);
        Num499A1.setSpacingBefore((float) -12);
        Num499A1.setIndentationLeft((float) 450);
        Num499A1.setSpacingAfter(-3);
        
        if(Triglicéridos<200 || Triglicéridos>499){
        documento.add(Num499A1);
        }

        Paragraph Muyalto = new  Paragraph ("Muy alto" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Muyalto.setAlignment(Element.ALIGN_CENTER);
        Muyalto.setSpacingBefore(2);
        Muyalto.setIndentationLeft(180);
        Muyalto.setSpacingAfter(-3);
        
        if(Triglicéridos>=500){
        documento.add(Muyalto);
        }

        Paragraph Muyalto1 = new  Paragraph ("Muy alto" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Muyalto1.setAlignment(Element.ALIGN_CENTER);
        Muyalto1.setSpacingBefore(2);
        Muyalto1.setIndentationLeft(180);
        Muyalto1.setSpacingAfter(-3);
        
        if(Triglicéridos<500){
        documento.add(Muyalto1);
        }

        Paragraph Másde5 = new  Paragraph ("Más de" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Másde5.setAlignment(Element.ALIGN_CENTER);
        Másde5.setSpacingBefore((float) -12);
        Másde5.setIndentationLeft((float) 330);
        Másde5.setSpacingAfter(-3);
     
        if(Triglicéridos>=500){
        documento.add(Másde5);
        }

        Paragraph Másde51 = new  Paragraph ("Más de" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Másde51.setAlignment(Element.ALIGN_CENTER);
        Másde51.setSpacingBefore((float) -12);
        Másde51.setIndentationLeft((float) 330);
        Másde51.setSpacingAfter(-3);

        if(Triglicéridos<500){
        documento.add(Másde51);
        }
         
        Paragraph Num500 = new  Paragraph ("500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num500.setAlignment(Element.ALIGN_CENTER);
        Num500.setSpacingBefore((float) -12);
        Num500.setIndentationLeft((float) 450);
        Num500.setSpacingAfter(-3);
        
        if(Triglicéridos>=500){
        documento.add(Num500);
        }

        Paragraph Num5001 = new  Paragraph ("500" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num5001.setAlignment(Element.ALIGN_CENTER);
        Num5001.setSpacingBefore((float) -12);
        Num5001.setIndentationLeft((float) 450);
        Num5001.setSpacingAfter(-3);
        
        if(Triglicéridos<500){
        documento.add(Num5001);
        }

        Paragraph Observaciones = new  Paragraph ("Observaciones:" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Observaciones.setSpacingBefore(10);
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
        canvas2.moveTo(197, 125);
        canvas2.lineTo(409, 125);
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

    private void txt_NitrogenoureicoBUNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NitrogenoureicoBUNKeyReleased
           
    }//GEN-LAST:event_txt_NitrogenoureicoBUNKeyReleased

    private void txt_NitrogenoureicoBUNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NitrogenoureicoBUNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NitrogenoureicoBUNActionPerformed

    private void txt_UreaséricaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UreaséricaKeyReleased
      String numero=txt_Ureasérica.getText();

      if(numero.equals("")==false&&numero.matches("[0-9]*([.,][0-9]{1,3})?$")){
         Double num=Double.parseDouble(numero);
         Double NU = num/2.14;
         BigDecimal bd = new BigDecimal(NU);
         bd = bd.setScale(2, RoundingMode.HALF_UP);
         txt_NitrogenoureicoBUN.setText(""+bd.doubleValue());
      } else {
         txt_NitrogenoureicoBUN.setText("...");
      }
    }//GEN-LAST:event_txt_UreaséricaKeyReleased

    private void txt_CreatininaséricaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CreatininaséricaKeyReleased
       String numero=txt_Creatininasérica.getText(), numero1=txt_NitrogenoureicoBUN.getText() ;

      if(numero.equals("")==false&&numero.matches("[0-9]*([.,][0-9]{1,3})?$")){
         Double num=Double.parseDouble(numero);
         Double num1=Double.parseDouble(numero1);
         Double NU = num1/num;
         BigDecimal bd = new BigDecimal(NU);
         bd = bd.setScale(2, RoundingMode.HALF_UP);
         txt_RelaciónBUNCreatinina.setText(""+bd.doubleValue());
      } else {
         txt_RelaciónBUNCreatinina.setText("...");
      }
    }//GEN-LAST:event_txt_CreatininaséricaKeyReleased

    private void txt_CreatininaséricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CreatininaséricaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CreatininaséricaActionPerformed

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
            java.util.logging.Logger.getLogger(QS619a50años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QS619a50años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QS619a50años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QS619a50años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new QS619a50años().setVisible(true);
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
    private javax.swing.JLabel jLabel_Colesteroltotal;
    private javax.swing.JLabel jLabel_Creatininasérica;
    private javax.swing.JLabel jLabel_Datos;
    private javax.swing.JLabel jLabel_Glucosasérica;
    private javax.swing.JLabel jLabel_NitrogenoureicoBUN;
    private javax.swing.JLabel jLabel_NoFolio;
    private javax.swing.JLabel jLabel_RelaciónBUNCreatinina;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Triglicéridos;
    private javax.swing.JLabel jLabel_Ureasérica;
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
    private javax.swing.JLabel jLabel_Ácidoúrico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_Colesteroltotal;
    private javax.swing.JTextField txt_Creatininasérica;
    private javax.swing.JTextField txt_Glucosasérica;
    private javax.swing.JTextField txt_NitrogenoureicoBUN;
    private javax.swing.JTextField txt_NoFolio;
    private javax.swing.JTextField txt_RelaciónBUNCreatinina;
    private javax.swing.JTextField txt_Reporte;
    private javax.swing.JTextField txt_Triglicéridos;
    private javax.swing.JTextField txt_Ureasérica;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_claveEstudio;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_sexo;
    private javax.swing.JTextField txt_Ácidoúrico;
    // End of variables declaration//GEN-END:variables

    private static class BLACK {

        public BLACK() {
        }
    }
 

}
