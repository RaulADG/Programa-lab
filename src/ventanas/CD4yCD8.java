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
public class CD4yCD8 extends javax.swing.JFrame {

   
int IDpaciente_update = 0, IDestudio = 0, IEstudio =0;
String user = "", nom_paciente = "";
 String minutos, ampm;
 Calendar calendario;
    /**
     * Creates new form CargaViralA
     */
    public CD4yCD8() {
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
                  "select * from CD4yCD8 where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            jTextPane_indicaciones.setText(rs2.getString("Observaciones"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
            txt_Leucocitostotales.setText(rs2.getString("Leucocitos_totales"));
            txt_Linfocitostotales.setText(rs2.getString("Linfocitos_totales"));
            txt_CTCD3.setText(rs2.getString("CélulasTCD3totales"));
            txt_CTCD4.setText(rs2.getString("CélulasTCD4Cooperadores"));
            txt_CTCD8.setText(rs2.getString("CélulasTCD8Supresoras"));
            txt_CD4CD8.setText(rs2.getString("CocienteCD4CD8"));
            
          }
          
          
        } catch (SQLException e) {
         System.err.println("Error al consultar la información del estudio");
        }
  
        setSize(588, 1050);
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
        txt_Leucocitostotales = new javax.swing.JTextField();
        jLabel_CopiasmL = new javax.swing.JLabel();
        txt_Linfocitostotales = new javax.swing.JTextField();
        jCheckBox_firma = new javax.swing.JCheckBox();
        txt_CTCD3 = new javax.swing.JTextField();
        jLabel_CTCD3 = new javax.swing.JLabel();
        jLabel_CTCD4 = new javax.swing.JLabel();
        txt_CTCD4 = new javax.swing.JTextField();
        jLabel_CTCD8 = new javax.swing.JLabel();
        txt_CTCD8 = new javax.swing.JTextField();
        jLabel_CD4CD8 = new javax.swing.JLabel();
        txt_CD4CD8 = new javax.swing.JTextField();
        jLabel_Cooperadores = new javax.swing.JLabel();
        jLabel_totales = new javax.swing.JLabel();
        jLabel_CTCD9 = new javax.swing.JLabel();
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
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 250, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 540, 190));

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
        getContentPane().add(jButton_GuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, 130, -1));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 250, 26));

        txt_Reporte.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reporte.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reporte.setText("No");
        txt_Reporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 855, 210, -1));

        jLabel_Datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Datos.setText("Datos guardados:");
        getContentPane().add(jLabel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 860, -1, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 665, 130, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Reporte");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 700, 130, -1));

        jLabel_ValoresdeResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado.setText("Valores de resultado:");
        getContentPane().add(jLabel_ValoresdeResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jLabel_Logaritmo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Logaritmo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Logaritmo.setText("Leucocitos totales:");
        getContentPane().add(jLabel_Logaritmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 635, -1, -1));

        txt_Leucocitostotales.setBackground(new java.awt.Color(153, 153, 255));
        txt_Leucocitostotales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Leucocitostotales.setForeground(new java.awt.Color(255, 255, 255));
        txt_Leucocitostotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Leucocitostotales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Leucocitostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 630, 210, -1));

        jLabel_CopiasmL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CopiasmL.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CopiasmL.setText("Linfocitos totales:");
        getContentPane().add(jLabel_CopiasmL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, -1, -1));

        txt_Linfocitostotales.setBackground(new java.awt.Color(153, 153, 255));
        txt_Linfocitostotales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Linfocitostotales.setForeground(new java.awt.Color(255, 255, 255));
        txt_Linfocitostotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Linfocitostotales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Linfocitostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 665, 210, -1));

        jCheckBox_firma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox_firma.setText("Incluir firma");
        jCheckBox_firma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_firmaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_firma, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 910, -1, -1));

        txt_CTCD3.setBackground(new java.awt.Color(153, 153, 255));
        txt_CTCD3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_CTCD3.setForeground(new java.awt.Color(255, 255, 255));
        txt_CTCD3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CTCD3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_CTCD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 700, 210, -1));

        jLabel_CTCD3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD3.setText("Células T CD3");
        getContentPane().add(jLabel_CTCD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 697, -1, -1));

        jLabel_CTCD4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD4.setText("Células T CD4");
        getContentPane().add(jLabel_CTCD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 735, -1, -1));

        txt_CTCD4.setBackground(new java.awt.Color(153, 153, 255));
        txt_CTCD4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_CTCD4.setForeground(new java.awt.Color(255, 255, 255));
        txt_CTCD4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CTCD4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_CTCD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 735, 210, -1));

        jLabel_CTCD8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD8.setText("Células T CD8");
        getContentPane().add(jLabel_CTCD8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 767, -1, -1));

        txt_CTCD8.setBackground(new java.awt.Color(153, 153, 255));
        txt_CTCD8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_CTCD8.setForeground(new java.awt.Color(255, 255, 255));
        txt_CTCD8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CTCD8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_CTCD8, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 770, 210, -1));

        jLabel_CD4CD8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CD4CD8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CD4CD8.setText("Cociente CD4/CD8:");
        getContentPane().add(jLabel_CD4CD8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, -1, -1));

        txt_CD4CD8.setBackground(new java.awt.Color(153, 153, 255));
        txt_CD4CD8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_CD4CD8.setForeground(new java.awt.Color(255, 255, 255));
        txt_CD4CD8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CD4CD8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_CD4CD8, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 805, 210, -1));

        jLabel_Cooperadores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Cooperadores.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cooperadores.setText("(Cooperadores):");
        getContentPane().add(jLabel_Cooperadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 748, -1, -1));

        jLabel_totales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_totales.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_totales.setText("totales:");
        getContentPane().add(jLabel_totales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 711, -1, -1));

        jLabel_CTCD9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CTCD9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CTCD9.setText("(Supresoras):");
        getContentPane().add(jLabel_CTCD9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 1050));

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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, leucocitosT, linfocitosT, CélulasCD3T, CélulasCD4T, CélulasCD8T, CD4CD8,Reporte_generado1; 
      
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
      leucocitosT = txt_Leucocitostotales.getText().trim();
      linfocitosT = txt_Linfocitostotales.getText().trim();
      CélulasCD3T = txt_CTCD3.getText().trim();
      CélulasCD4T = txt_CTCD4.getText().trim();
      CélulasCD8T = txt_CTCD8.getText().trim();
      CD4CD8 = txt_CD4CD8.getText().trim();
      
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
       if(leucocitosT.equals("")) {
           txt_Leucocitostotales.setBackground(Color.red);
           validacion++;     
       }
       if(linfocitosT.equals("")) {
           txt_Linfocitostotales.setBackground(Color.red);
           validacion++;     
       }
        if(CélulasCD3T.equals("")) {
           txt_CTCD3.setBackground(Color.red);
           validacion++;     
       }
         if(CélulasCD4T.equals("")) {
           txt_CTCD4.setBackground(Color.red);
           validacion++;     
       }
        if(CélulasCD8T.equals("")) {
           txt_CTCD8.setBackground(Color.red);
           validacion++;     
       }
        if(CD4CD8.equals("")) {
           txt_CD4CD8.setBackground(Color.red);
           validacion++;     
       }
      
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "insert into CD4yCD8 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
             
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
             pst.setString(13, leucocitosT);
             pst.setString(14, linfocitosT);
             pst.setString(15, CélulasCD3T);
             pst.setString(16, CélulasCD4T);
             pst.setString(17, CélulasCD8T);
             pst.setString(18, CD4CD8);
             pst.setString(19, user);
             pst.setString(20, Reporte_generado1);

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
             txt_Leucocitostotales.setBackground(Color.green);
             txt_Linfocitostotales.setBackground(Color.green);
             txt_CTCD3.setBackground(Color.green);
             txt_CTCD4.setBackground(Color.green);
             txt_CTCD8.setBackground(Color.green);
             txt_CD4CD8.setBackground(Color.green);
             
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 
 
         try {
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from CD4yCD8 where ID_estudio = '" + IEstudio + "'");
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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, leucocitosT, linfocitosT, CélulasCD3T, CélulasCD4T, CélulasCD8T, CD4CD8,Reporte_generado1; 
      
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
      leucocitosT = txt_Leucocitostotales.getText().trim();
      linfocitosT = txt_Linfocitostotales.getText().trim();
      CélulasCD3T = txt_CTCD3.getText().trim();
      CélulasCD4T = txt_CTCD4.getText().trim();
      CélulasCD8T = txt_CTCD8.getText().trim();
      CD4CD8 = txt_CD4CD8.getText().trim();
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
 
       if(leucocitosT.equals("")) {
           txt_Leucocitostotales.setBackground(Color.red);
           validacion++;     
       }
       if(linfocitosT.equals("")) {
           txt_Linfocitostotales.setBackground(Color.red);
           validacion++;     
       }
        if(CélulasCD3T.equals("")) {
           txt_CTCD3.setBackground(Color.red);
           validacion++;     
       }
         if(CélulasCD4T.equals("")) {
           txt_CTCD4.setBackground(Color.red);
           validacion++;     
       }
        if(CélulasCD8T.equals("")) {
           txt_CTCD8.setBackground(Color.red);
           validacion++;     
       }
        if(CD4CD8.equals("")) {
           txt_CD4CD8.setBackground(Color.red);
           validacion++;     
       }
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "update CD4yCD8 set Fecha_entrega=?, Hora=?, Observaciones=?, Leucocitos_totales=?, Linfocitos_totales=?, CélulasTCD3totales=?,"
 + "CélulasTCD4Cooperadores=?, CélulasTCD8Supresoras=?, CocienteCD4CD8=?, ultima_modificacion=? " 
                   + "where ID_estudio = '" + IEstudio + "'");
             
         
             pst.setString(1, fechaEntrega);
             pst.setString(2, hora);
             pst.setString(3, observaciones);
             pst.setString(4, leucocitosT);
             pst.setString(5, linfocitosT);
             pst.setString(6, CélulasCD3T);
             pst.setString(7, CélulasCD4T);
             pst.setString(8, CélulasCD8T);
             pst.setString(9, CD4CD8);
             pst.setString(10, user);

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
             txt_Leucocitostotales.setBackground(Color.green);
             txt_Linfocitostotales.setBackground(Color.green);
             txt_CTCD3.setBackground(Color.green);
             txt_CTCD4.setBackground(Color.green);
             txt_CTCD8.setBackground(Color.green);
             txt_CD4CD8.setBackground(Color.green);
             
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
                     "update CD4yCD8 set Hora=?, ultima_modificacion=?"
                     
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
        resultado.setIndentationLeft(229);
        resultado.setSpacingAfter(-3);
        documento.add(resultado);
        
        Paragraph valores = new  Paragraph ("Valores de referencia" , FontFactory.getFont("arial", 11, Font.BOLD , BaseColor.BLACK));
        valores.setSpacingBefore(-14);
        valores.setIndentationLeft(400);
        valores.setSpacingAfter(-3);
        documento.add(valores);
        
        Chunk chunk2 = new Chunk("Células CD4 y CD8", FontFactory.getFont("arial", 11,Font.BOLD, BaseColor.BLACK));
        chunk2.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk = new  Paragraph ((chunk2));
        chunk.setSpacingBefore(10);
        chunk.setIndentationLeft(17);
        chunk.setSpacingAfter(-3);
        documento.add(chunk);
        
        Paragraph metodo = new  Paragraph ("Método: Citometría de flujo" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        metodo.setSpacingBefore(2);
        metodo.setIndentationLeft(17);
        metodo.setSpacingAfter(-3);
        documento.add(metodo);

        double LeucocitosTR, LinfocitosTR, CTCD3, CD4R, CD8R, CD4CD8; 
        
        LeucocitosTR = Double.parseDouble(txt_Leucocitostotales.getText());
        LinfocitosTR = Double.parseDouble(txt_Linfocitostotales.getText());
        CTCD3 = Double.parseDouble(txt_CTCD3.getText());
        CD4R = Double.parseDouble(txt_CTCD4.getText());
        CD8R = Double.parseDouble(txt_CTCD8.getText());
        CD4CD8 = Double.parseDouble(txt_CD4CD8.getText());
      
        Paragraph LeucocitosT = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitosT.setSpacingBefore(10);
        LeucocitosT.setIndentationLeft(17);
        LeucocitosT.setSpacingAfter((float) -3.5);

        if(LeucocitosTR<4500){
        documento.add(LeucocitosT);
        }

        Paragraph LeucocitosT1 = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LeucocitosT1.setSpacingBefore(10);
        LeucocitosT1.setIndentationLeft(17);
        LeucocitosT1.setSpacingAfter((float) -3.5);

        if(LeucocitosTR>=4500 && LeucocitosTR<=11000){
        documento.add(LeucocitosT1);
        }
 
        Paragraph LeucocitosT2 = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitosT2.setSpacingBefore(10);
        LeucocitosT2.setIndentationLeft(17);
        LeucocitosT2.setSpacingAfter((float) -3.5);

        if(LeucocitosTR>11000){
        documento.add(LeucocitosT2);
        }
             
        Paragraph Leucocitostotales = new  Paragraph (txt_Leucocitostotales.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Leucocitostotales.setSpacingBefore((float) -11.5);
        Leucocitostotales.setSpacingAfter(-3);

        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>=0 && LeucocitosTR<=9){
        Leucocitostotales.setIndentationLeft(251);
        documento.add(Leucocitostotales);
        } else {
        if(LeucocitosTR>=0 && LeucocitosTR<=9) {  
        Leucocitostotales.setIndentationLeft((float) 255);
        documento.add(Leucocitostotales);
          }
        }
        
        
        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>=10 && LeucocitosTR<=100){
        Leucocitostotales.setIndentationLeft(248);
        documento.add(Leucocitostotales);
        } else {
        if(LeucocitosTR>=10 && LeucocitosTR<=99) {  
        Leucocitostotales.setIndentationLeft((float) 252);
        documento.add(Leucocitostotales);
          }
        }
        

        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>=100 && LeucocitosTR<=1000){
        Leucocitostotales.setIndentationLeft(245);
        documento.add(Leucocitostotales);
        } else {
        if(LeucocitosTR>=100 && LeucocitosTR<=999) {  
        Leucocitostotales.setIndentationLeft((float) 249);
        documento.add(Leucocitostotales);
          }
        }
        

        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>=1000 && LeucocitosTR<4500){
        Leucocitostotales.setIndentationLeft(242);
        documento.add(Leucocitostotales);
        } else {
        if(LeucocitosTR>=1000 && LeucocitosTR<=4499) {  
        Leucocitostotales.setIndentationLeft((float) 246);
        documento.add(Leucocitostotales);
          }
        }
        

        Paragraph Leucocitostotales1 = new  Paragraph (txt_Leucocitostotales.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Leucocitostotales1.setSpacingBefore((float) -11.5);
        Leucocitostotales1.setSpacingAfter(-3);
 
        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>4500 && LeucocitosTR<10000){
        Leucocitostotales1.setIndentationLeft(242);
        documento.add(Leucocitostotales1);
        } else {
        if(LeucocitosTR>=4500 && LeucocitosTR<=9999) {  
        Leucocitostotales1.setIndentationLeft((float) 246);
        documento.add(Leucocitostotales1);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>10000 && LeucocitosTR<11000){
        Leucocitostotales1.setIndentationLeft(239);
        documento.add(Leucocitostotales1);
        } else {
        if(LeucocitosTR>=10000 && LeucocitosTR<=11000) {  
        Leucocitostotales1.setIndentationLeft((float) 243);
        documento.add(Leucocitostotales1);
          }
        }  
   
        if(txt_Leucocitostotales.getText().contains(".") && LeucocitosTR>11000 && LeucocitosTR<100000){
        Leucocitostotales.setIndentationLeft(239);
        documento.add(Leucocitostotales);
        } else {
        if(LeucocitosTR>=11001 && LeucocitosTR<=99999) {  
        Leucocitostotales.setIndentationLeft((float) 243);
        documento.add(Leucocitostotales);
          }
        }
        

        if(LeucocitosTR>=100000){
        Leucocitostotales.setIndentationLeft(240);
        documento.add(Leucocitostotales);
        } 
         

        //negativo
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-9 && LeucocitosTR<=0){
        Leucocitostotales.setIndentationLeft(248);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-9 && LeucocitosTR<=0) {  
        Leucocitostotales.setIndentationLeft((float) 252);
        documento.add(Leucocitostotales);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-100 && LeucocitosTR<=-10){
        Leucocitostotales.setIndentationLeft(245);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-99 && LeucocitosTR<=-10) {  
        Leucocitostotales.setIndentationLeft((float) 249);
        documento.add(Leucocitostotales);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-1000 && LeucocitosTR<=-100){
        Leucocitostotales.setIndentationLeft(242);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-999 && LeucocitosTR<=-100) {  
        Leucocitostotales.setIndentationLeft((float) 246);
        documento.add(Leucocitostotales);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-4500 && LeucocitosTR<=-1000){
        Leucocitostotales.setIndentationLeft(239);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-4500 && LeucocitosTR<=-1000) {  
        Leucocitostotales.setIndentationLeft((float) 243);
        documento.add(Leucocitostotales);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>-10000 && LeucocitosTR<-4500){
        Leucocitostotales.setIndentationLeft(236);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-9999 && LeucocitosTR<=-4500) {  
        Leucocitostotales.setIndentationLeft((float) 240);
        documento.add(Leucocitostotales);
          }
        }
        
        if(txt_Leucocitostotales.getText().contains(".") && txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>-100000 && LeucocitosTR<-10000){
        Leucocitostotales.setIndentationLeft(236);
        documento.add(Leucocitostotales);
        } else {
        if(txt_Leucocitostotales.getText().contains("-") && LeucocitosTR>=-99999 && LeucocitosTR<=-10000) {  
        Leucocitostotales.setIndentationLeft((float) 240);
        documento.add(Leucocitostotales);
          }
        }

        if(LeucocitosTR<=-100000){
        Leucocitostotales.setIndentationLeft(237);
        documento.add(Leucocitostotales);
        } 
        
        Paragraph logM = new  Paragraph ("4,500	            11,000", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        logM.setSpacingBefore(-12);
        logM.setIndentationLeft(413);
        logM.setSpacingAfter((float) -4.5);
        

        if(LeucocitosTR<4500){ 
        documento.add(logM);     
        }

        Paragraph logM1 = new  Paragraph ("4,500	            11,000", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        logM1.setSpacingBefore(-12);
        logM1.setIndentationLeft(413);
        logM1.setSpacingAfter((float) -4.5);
        

        if(LeucocitosTR>=4500 && LeucocitosTR<=11000){ 
        documento.add(logM1);     
        }

        Paragraph logM2 = new  Paragraph ("4,500	            11,000", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        logM2.setSpacingBefore(-12);
        logM2.setIndentationLeft(413);
        logM2.setSpacingAfter((float) -4.5);
        

        if(LeucocitosTR>11000){ 
        documento.add(logM2);     
        }
      
        Paragraph LinfocitosT = new  Paragraph ("Linfocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosT.setSpacingBefore(5);
        LinfocitosT.setIndentationLeft(17);
        LinfocitosT.setSpacingAfter(-3);

        if(LinfocitosTR<600){
        documento.add(LinfocitosT);
        }

        Paragraph LinfocitosT1 = new  Paragraph ("Linfocitos totales" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LinfocitosT1.setSpacingBefore(5);
        LinfocitosT1.setIndentationLeft(17);
        LinfocitosT1.setSpacingAfter(-3);

        if(LinfocitosTR>=600 && LinfocitosTR<=3400){
        documento.add(LinfocitosT1);
        }
 
        Paragraph LinfocitosT2 = new  Paragraph ("Linfocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosT2.setSpacingBefore(5);
        LinfocitosT2.setIndentationLeft(17);
        LinfocitosT2.setSpacingAfter(-3);

        if(LinfocitosTR>3400){
        documento.add(LinfocitosT2);
        }
         
        
        Paragraph Linfocitostotales = new  Paragraph (txt_Linfocitostotales.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitostotales.setSpacingBefore(-11);
        Linfocitostotales.setSpacingAfter((float) -3.5);
      
        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>=0 && LinfocitosTR<=9){
        Linfocitostotales.setIndentationLeft(251);
        documento.add(Linfocitostotales);
        } else {
        if(LinfocitosTR>=0 && LinfocitosTR<=9) {  
        Linfocitostotales.setIndentationLeft((float) 255);
        documento.add(Linfocitostotales);
          }
        }
        
        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>=10 && LinfocitosTR<=100){
        Linfocitostotales.setIndentationLeft(248);
        documento.add(Linfocitostotales);
        } else {
        if(LinfocitosTR>=10 && LinfocitosTR<=99) {  
        Linfocitostotales.setIndentationLeft((float) 252);
        documento.add(Linfocitostotales);
          }
        }

        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>=100 && LinfocitosTR<600){
        Linfocitostotales.setIndentationLeft(245);
        documento.add(Linfocitostotales);
        } else {
        if(LinfocitosTR>=100 && LinfocitosTR<=599) {  
        Linfocitostotales.setIndentationLeft((float) 249);
        documento.add(Linfocitostotales);
          }
        }
        
        Paragraph Linfocitostotales1 = new  Paragraph (txt_Linfocitostotales.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Linfocitostotales1.setSpacingBefore(-11);
        Linfocitostotales1.setSpacingAfter((float) -3.5);
        
        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>600 && LinfocitosTR<1000){
        Linfocitostotales1.setIndentationLeft(245);
        documento.add(Linfocitostotales1);
        } else {
        if(LinfocitosTR>=600 && LinfocitosTR<=999) {  
        Linfocitostotales1.setIndentationLeft((float) 249);
        documento.add(Linfocitostotales1);
          }
        }
        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>1000 && LinfocitosTR<3400){
        Linfocitostotales1.setIndentationLeft(242);
        documento.add(Linfocitostotales1);
        } else {
        if(LinfocitosTR>=1000 && LinfocitosTR<=3400) {  
        Linfocitostotales1.setIndentationLeft((float) 246);
        documento.add(Linfocitostotales1);
          }
        }

        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>3400 && LinfocitosTR<10000){
        Linfocitostotales.setIndentationLeft(242);
        documento.add(Linfocitostotales);
        } else {
        if(LinfocitosTR>=3400 && LinfocitosTR<=9999) {  
        Linfocitostotales.setIndentationLeft((float) 246);
        documento.add(Linfocitostotales);
          }
        }
           
        if(txt_Linfocitostotales.getText().contains(".") && LinfocitosTR>10000 && LinfocitosTR<100000){
        Linfocitostotales.setIndentationLeft(239);
        documento.add(Linfocitostotales);
        } else {
        if(LinfocitosTR>=10000 && LinfocitosTR<=99999) {  
        Linfocitostotales.setIndentationLeft((float) 243);
        documento.add(Linfocitostotales);
          }
        }  
   
        if(LinfocitosTR>=100000){
        Linfocitostotales.setIndentationLeft(240);
        documento.add(Linfocitostotales);
        } 
         

        //negativo
        if(txt_Linfocitostotales.getText().contains(".") && txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>-9 && LinfocitosTR<0){
        Linfocitostotales.setIndentationLeft(248);
        documento.add(Linfocitostotales);
        } else {
        if(txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>=-9 && LinfocitosTR<=0) {  
        Linfocitostotales.setIndentationLeft((float) 252);
        documento.add(Linfocitostotales);
          }
        }
        
        if(txt_Linfocitostotales.getText().contains(".") && txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>-100 && LinfocitosTR<-10){
        Linfocitostotales.setIndentationLeft(245);
        documento.add(Linfocitostotales);
        } else {
        if(txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>=-99 && LinfocitosTR<=-10) {  
        Linfocitostotales.setIndentationLeft((float) 249);
        documento.add(Linfocitostotales);
          }
        }
        
        if(txt_Linfocitostotales.getText().contains(".") && txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>-1000 && LinfocitosTR<-100){
        Linfocitostotales.setIndentationLeft(242);
        documento.add(Linfocitostotales);
        } else {
        if(txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>=-999 && LinfocitosTR<=-100) {  
        Linfocitostotales.setIndentationLeft((float) 246);
        documento.add(Linfocitostotales);
          }
        }
        
        if(txt_Linfocitostotales.getText().contains(".") && txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>-10000 && LinfocitosTR<-1000){
        Linfocitostotales.setIndentationLeft(239);
        documento.add(Linfocitostotales);
        } else {
        if(txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>=-9999 && LinfocitosTR<=-1000) {  
        Linfocitostotales.setIndentationLeft((float) 243);
        documento.add(Linfocitostotales);
          }
        }
        
        if(txt_Linfocitostotales.getText().contains(".") && txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>-100000 && LinfocitosTR<-10000){
        Linfocitostotales.setIndentationLeft(233);
        documento.add(Linfocitostotales);
        } else {
        if(txt_Linfocitostotales.getText().contains("-") && LinfocitosTR>=-99999 && LinfocitosTR<=-10000) {  
        Linfocitostotales.setIndentationLeft((float) 237);
        documento.add(Linfocitostotales);
          }
        }

        if(LinfocitosTR<=-100000){
        Linfocitostotales.setIndentationLeft(237);
        documento.add(Linfocitostotales);
        } 


        Paragraph copiasM = new  Paragraph ("600               3,400" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM.setSpacingBefore(-12);
        copiasM.setIndentationLeft(420);
        copiasM.setSpacingAfter((float) -3.5);

        if(LinfocitosTR<600){ 
        documento.add(copiasM);     
        }

        Paragraph copiasM1 = new  Paragraph ("600               3,400" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copiasM1.setSpacingBefore(-12);
        copiasM1.setIndentationLeft(420);
        copiasM1.setSpacingAfter((float) -3.5);
        

        if(LinfocitosTR>=600 && LinfocitosTR<=3400){ 
        documento.add(copiasM1);     
        }

        Paragraph copiasM2 = new  Paragraph ("600               3,400" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM2.setSpacingBefore(-12);
        copiasM2.setIndentationLeft(420);
        copiasM2.setSpacingAfter((float) -3.5);

        if(LinfocitosTR>3400){ 
        documento.add(copiasM2);     
        }
        
        Paragraph CD3 = new  Paragraph ("Células T CD3 totales " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD3.setSpacingBefore(5);
        CD3.setIndentationLeft(17);
        CD3.setSpacingAfter(-3);

        if(CTCD3<690){
        documento.add(CD3);
        }

        Paragraph CD3_1 = new  Paragraph ("Células T CD3 totales " , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD3_1.setSpacingBefore(5);
        CD3_1.setIndentationLeft(17);
        CD3_1.setSpacingAfter(-3);

        if(CTCD3>=690 && CTCD3<=2540){
        documento.add(CD3_1);
        }
 
        Paragraph CD3_2 = new  Paragraph ("Células T CD3 totales " , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD3_2.setSpacingBefore(5);
        CD3_2.setIndentationLeft(17);
        CD3_2.setSpacingAfter(-3);

        if(CTCD3>2540){
        documento.add(CD3_2);
        }
        
        Paragraph CD3T = new  Paragraph (txt_CTCD3.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD3T.setSpacingBefore(-11);
        CD3T.setSpacingAfter((float) -3.5);
       
        if(txt_CTCD3.getText().contains(".") && CTCD3>=0 && CTCD3<=9){
        CD3T.setIndentationLeft(251);
        documento.add(CD3T);
        } else {
        if(CTCD3>=0 && CTCD3<=9) {  
        CD3T.setIndentationLeft((float) 255);
        documento.add(CD3T);
          }
        }
        
        if(txt_CTCD3.getText().contains(".") && CTCD3>10 && CTCD3<100){
        CD3T.setIndentationLeft(248);
        documento.add(CD3T);
        } else {
        if(CTCD3>=10 && CTCD3<=99) {  
        CD3T.setIndentationLeft((float) 252);
        documento.add(CD3T);
          }
        }
        
        if(txt_CTCD3.getText().contains(".") && CTCD3>100 && CTCD3<690){
        CD3T.setIndentationLeft(245);
        documento.add(CD3T);
        } else {
        if(CTCD3>=100 && CTCD3<=689) {  
        CD3T.setIndentationLeft((float) 249);
        documento.add(CD3T);
          }
        }
        
        Paragraph CD3T1 = new  Paragraph (txt_CTCD3.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD3T1.setSpacingBefore(-11);
        CD3T1.setSpacingAfter((float) -3.5);

        if(txt_CTCD3.getText().contains(".") && CTCD3>690 && CTCD3<1000){
        CD3T1.setIndentationLeft(245);
        documento.add(CD3T1);
        } else {
        if(CTCD3>=690 && CTCD3<=999) {  
        CD3T1.setIndentationLeft((float) 249);
        documento.add(CD3T1);
          }
        }

        if(txt_CTCD3.getText().contains(".") && CTCD3>1000 && CTCD3<2540){
        CD3T1.setIndentationLeft(242);
        documento.add(CD3T1);
        } else {
        if(CTCD3>=1000 && CTCD3<=2540) {  
        CD3T1.setIndentationLeft((float) 246);
        documento.add(CD3T1);
          }
        }
        
        if(txt_CTCD3.getText().contains(".") && CTCD3>2540 && CTCD3<10000){
        CD3T.setIndentationLeft(242);
        documento.add(CD3T);
        } else {
        if(CTCD3>=2541 && CTCD3<=9999) {  
        CD3T.setIndentationLeft((float) 246);
        documento.add(CD3T);
          }
        }
       
        if(txt_CTCD3.getText().contains(".") && CTCD3>10000 && CTCD3<100000){
        CD3T.setIndentationLeft(239);
        documento.add(CD3T);
        } else {
        if(CTCD3>=10000 && CTCD3<=99999) {  
        CD3T.setIndentationLeft((float) 243);
        documento.add(CD3T);
          }
        }

        if(CTCD3>=100000){
        CD3T.setIndentationLeft(240);
        documento.add(CD3T);
        } 
         
        //negativo
        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-9 && CTCD3<0){
        CD3T.setIndentationLeft(248);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-9 && CTCD3<=0) {  
        CD3T.setIndentationLeft((float) 252);
        documento.add(CD3T);
          }
        }

        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-100 && CTCD3<-10){
        CD3T.setIndentationLeft(245);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-99 && CTCD3<=-10) {  
        CD3T.setIndentationLeft((float) 249);
        documento.add(CD3T);
          }
        }

        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-1000 && CTCD3<-100){
        CD3T.setIndentationLeft(242);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-999 && CTCD3<=-100) {  
        CD3T.setIndentationLeft((float) 246);
        documento.add(CD3T);
          }
        }

        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-10000 && CTCD3<-1000){
        CD3T.setIndentationLeft(239);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-9999 && CTCD3<=-1000) {  
        CD3T.setIndentationLeft((float) 243);
        documento.add(CD3T);
          }
        }

        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-100000 && CTCD3<-1000){
        CD3T.setIndentationLeft(239);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-9999 && CTCD3<=-1000) {  
        CD3T.setIndentationLeft((float) 243);
        documento.add(CD3T);
          }
        }
        
        if(txt_CTCD3.getText().contains(".") && txt_CTCD3.getText().contains("-") && CTCD3>-100000 && CTCD3<-10000){
        CD3T.setIndentationLeft(233);
        documento.add(CD3T);
        } else {
        if(txt_CTCD3.getText().contains("-") && CTCD3>=-99999 && CTCD3<=-10000) {  
        CD3T.setIndentationLeft((float) 237);
        documento.add(CD3T);
          }
        }
        
        if(CTCD3<=-100000){
        CD3T.setIndentationLeft(237);
        documento.add(CD3T);
        } 
        
        Paragraph CD3M = new  Paragraph ("690	               2,540", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD3M.setSpacingBefore((float) -12);
        CD3M.setIndentationLeft(420);
        CD3M.setSpacingAfter((float) -3.5);

        if(CTCD3<690){ 
        documento.add(CD3M);     
        }

        Paragraph CD3M1 = new  Paragraph ("690	               2,540", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD3M1.setSpacingBefore((float) -12);
        CD3M1.setIndentationLeft(420);
        CD3M1.setSpacingAfter((float) -3.5);

        if(CTCD3>=690 && CTCD3<=2540){ 
        documento.add(CD3M1);     
        }

        Paragraph CD3M2 = new  Paragraph ("690	               2,540", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD3M2.setSpacingBefore((float) -12);
        CD3M2.setIndentationLeft(420);
        CD3M1.setSpacingAfter((float) -3.5);

        if(CTCD3>=2540){ 
        documento.add(CD3M1);     
        }
        
        Paragraph CD4 = new  Paragraph ("Células T CD4 (Cooperadores)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4.setSpacingBefore(5);
        CD4.setIndentationLeft(17);
        CD4.setSpacingAfter(-3);

        if(CD4R<410){
        documento.add(CD4);
        }

        Paragraph CD4_1 = new  Paragraph ("Células T CD4 (Cooperadores)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4_1.setSpacingBefore(5);
        CD4_1.setIndentationLeft(17);
        CD4_1.setSpacingAfter(-3);

        if(CD4R>=410 && CD4R<=1590){
        documento.add(CD4_1);
        }

        Paragraph CD4_2 = new  Paragraph ("Células T CD4 (Cooperadores)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4_2.setSpacingBefore(5);
        CD4_2.setIndentationLeft(17);
        CD4_2.setSpacingAfter(-3);

        if(CD4R>=1590){
        documento.add(CD4_2);
        }
        
  
        float left = 255, left1 = 255, left2 = 255;

        Paragraph CD4R1 = new  Paragraph (txt_CTCD4.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4R1.setSpacingBefore(-11);
        CD4R1.setSpacingAfter(-3);
        
        if(txt_CTCD4.getText().contains(".") && CD4R>0 && CD4R<9){
        left = left - 4;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(CD4R>=0 && CD4R<=9){
        left = left;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        if(txt_CTCD4.getText().contains(".") && CD4R>10 && CD4R<100){
        left = left - 7;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(CD4R>=10 && CD4R<=99){
        left = left - 3;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        if(txt_CTCD4.getText().contains(".") && CD4R>100 && CD4R<410){
        left = left - 10;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(CD4R>=100 && CD4R<=409){
        left = left - 6;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        Paragraph CD4R2 = new  Paragraph (txt_CTCD4.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4R2.setSpacingBefore(-11);
        CD4R2.setSpacingAfter(-3);
         
        if(txt_CTCD4.getText().contains(".") && CD4R>410 && CD4R<1000){
        left = left - 10;
        CD4R2.setIndentationLeft(left);
        documento.add(CD4R2);
        } else {
        if(CD4R>=410 && CD4R<=999){
        left = left - 6;
        CD4R2.setIndentationLeft(left);
        documento.add(CD4R2);
        } }

        if(txt_CTCD4.getText().contains(".") && CD4R>1000 && CD4R<1590){
        left = left - 13;
        CD4R2.setIndentationLeft(left);
        documento.add(CD4R2);
        } else {
        if(CD4R>=1000 && CD4R<=1590){
        left = left - 9;
        CD4R2.setIndentationLeft(left);
        documento.add(CD4R2);
        } }

        if(txt_CTCD4.getText().contains(".") && CD4R>1590 && CD4R<10000){
        left = left - 13;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(CD4R>=1590 && CD4R<=9999){
        left = left - 9;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } } 

        if(txt_CTCD4.getText().contains(".") && CD4R>10000 && CD4R<100000){
        left = left - 16;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(CD4R>=10000 && CD4R<=99999){
        left = left - 12;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }        

        if(CD4R>=100000){
        left = left - 15;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        }

         //negativo

        if(txt_CTCD4.getText().contains(".") && txt_CTCD4.getText().contains("-") && CD4R>-9 && CD4R<0){
        left = left - 7;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(txt_CTCD4.getText().contains("-") && CD4R>=-9 && CD4R<=0){
        left = left -3;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        if(txt_CTCD4.getText().contains(".") && txt_CTCD4.getText().contains("-") && CD4R>-100 && CD4R<-10){
        left = left - 10;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(txt_CTCD4.getText().contains("-") && CD4R>=-99 && CD4R<=-10){
        left = left -6;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }
        
        if(txt_CTCD4.getText().contains(".") && txt_CTCD4.getText().contains("-") && CD4R>-1000 && CD4R<-100){
        left = left - 13;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(txt_CTCD4.getText().contains("-") && CD4R>=-999 && CD4R<=-100){
        left = left - 9;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        if(txt_CTCD4.getText().contains(".") && txt_CTCD4.getText().contains("-") && CD4R>-10000 && CD4R<-1000){
        left = left - 16;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(txt_CTCD4.getText().contains("-") && CD4R>=-9999 && CD4R<=-1000){
        left = left - 12;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }

        if(txt_CTCD4.getText().contains(".") && txt_CTCD4.getText().contains("-") && CD4R>-100000 && CD4R<-10000){
        left = left - 22;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } else {
        if(txt_CTCD4.getText().contains("-") && CD4R>=-99999 && CD4R<=-10000){
        left = left - 18;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } }
        
        if(CD4R<=-100000){
        left = left - 18;
        CD4R1.setIndentationLeft(left);
        documento.add(CD4R1);
        } 

        Paragraph CD4E = new  Paragraph ("410	               1,590" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4E.setSpacingBefore(-13);
        CD4E.setIndentationLeft(420);
        CD4E.setSpacingAfter(-3);

         if(CD4R<410){
        documento.add(CD4E);
        }

        Paragraph CD4E1 = new  Paragraph ("410	               1,590" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4E1.setSpacingBefore(-13);
        CD4E1.setIndentationLeft(420);
        CD4E1.setSpacingAfter(-3);

        if(CD4R>=410 && CD4R<=1590){
        documento.add(CD4E1);
        }

        Paragraph CD4E2 = new  Paragraph ("410	               1,590" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4E2.setSpacingBefore(-13);
        CD4E2.setIndentationLeft(420);
        CD4E2.setSpacingAfter(-3);

        if(CD4R>=1590){
        documento.add(CD4E2);
        }
        
        Paragraph CTCD8 = new  Paragraph ("Células T CD8 (Supresoras)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CTCD8.setSpacingBefore(5);
        CTCD8.setIndentationLeft(17);
        CTCD8.setSpacingAfter(-3);
        
        if(CD8R<190){
        documento.add(CTCD8);
        }

        Paragraph CTCD81 = new  Paragraph ("Células T CD8 (Supresoras)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CTCD81.setSpacingBefore(5);
        CTCD81.setIndentationLeft(17);
        CTCD81.setSpacingAfter(-3);

        if(CD8R>=190 && CD8R<=1140){
        documento.add(CTCD81);
        }

        Paragraph CTCD82 = new  Paragraph ("Células T CD8 (Supresoras)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CTCD82.setSpacingBefore(5);
        CTCD82.setIndentationLeft(17);
        CTCD82.setSpacingAfter(-3);

        if(CD8R>=1140){
        documento.add(CTCD82);
        }
          
        Paragraph CTCD8R = new  Paragraph (txt_CTCD8.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CTCD8R.setSpacingBefore((float) -11);
        CTCD8R.setSpacingAfter(-8);

        if(txt_CTCD8.getText().contains(".") && CD8R>0 && CD8R<9){
        left1 = left1 - 4;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(CD8R>=0 && CD8R<=9){
        left1 = left1;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        if(txt_CTCD8.getText().contains(".") && CD8R>10 && CD8R<100){
        left1 = left1 - 7;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(CD8R>=10 && CD8R<=99){
        left1 = left1 - 3;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        if(txt_CTCD8.getText().contains(".") && CD8R>100 && CD8R<190){
        left1 = left1 - 10;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(CD8R>=100 && CD8R<=189){
        left1 = left1 - 6;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        Paragraph CTCD8R1 = new  Paragraph (txt_CTCD8.getText() + " Cel/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CTCD8R1.setSpacingBefore((float) -11);
        CTCD8R1.setSpacingAfter(-8);
         
        if(txt_CTCD8.getText().contains(".") && CD8R>190 && CD8R<1000){
        left1 = left1 - 10;
        CTCD8R1.setIndentationLeft(left1);
        documento.add(CTCD8R1);
        } else {
        if(CD8R>=190 && CD8R<=999){
        left1 = left1 - 6;
        CTCD8R1.setIndentationLeft(left1);
        documento.add(CTCD8R1);
        } }

        if(txt_CTCD8.getText().contains(".") && CD8R>1000 && CD8R<1140){
        left1 = left1 - 13;
        CTCD8R1.setIndentationLeft(left1);
        documento.add(CTCD8R1);
        } else {
        if(CD8R>=1000 && CD8R<=1140){
        left1 = left1 - 9;
        CTCD8R1.setIndentationLeft(left1);
        documento.add(CTCD8R1);
        } }

        if(txt_CTCD8.getText().contains(".") && CD8R>1140 && CD8R<10000){
        left1 = left1 - 13;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(CD8R>=1140 && CD8R<=9999){
        left1 = left1 - 9;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } } 

        if(txt_CTCD8.getText().contains(".") && CD8R>10000 && CD8R<100000){
        left1 = left1 - 16;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(CD8R>=10000 && CD8R<=99999){
        left1 = left1 - 12;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }        

        if(CD8R>=100000){
        left1 = left1 - 15;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        }

        //negativo

        if(txt_CTCD8.getText().contains(".") && txt_CTCD8.getText().contains("-") && CD8R>-9 && CD8R<0){
        left1 = left1 - 7;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(txt_CTCD8.getText().contains("-") && CD8R>=-9 && CD8R<=0){
        left1 = left1 -3;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        if(txt_CTCD8.getText().contains(".") && txt_CTCD8.getText().contains("-") && CD8R>-100 && CD8R<-10){
        left1 = left1 - 10;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(txt_CTCD8.getText().contains("-") && CD8R>=-99 && CD8R<=-10){
        left1 = left1 -6;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }
        
        if(txt_CTCD8.getText().contains(".") && txt_CTCD8.getText().contains("-") && CD8R>-1000 && CD8R<-100){
        left1 = left1 - 13;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(txt_CTCD8.getText().contains("-") && CD8R>=-999 && CD8R<=-100){
        left1 = left1 - 9;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        if(txt_CTCD8.getText().contains(".") && txt_CTCD8.getText().contains("-") && CD8R>-10000 && CD8R<-1000){
        left1 = left1 - 16;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(txt_CTCD8.getText().contains("-") && CD8R>=-9999 && CD8R<=-1000){
        left1 = left1 - 12;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }

        if(txt_CTCD8.getText().contains(".") && txt_CTCD8.getText().contains("-") && CD8R>-100000 && CD8R<-10000){
        left1 = left1 - 22;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } else {
        if(txt_CTCD8.getText().contains("-") && CD8R>=-99999 && CD8R<=-10000){
        left1 = left1 - 18;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } }
        
        if(CD8R<=-100000){
        left1 = left1 - 18;
        CTCD8R.setIndentationLeft(left1);
        documento.add(CTCD8R);
        } 

        Paragraph CTCD8E = new  Paragraph ("190	               1,140" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CTCD8E.setSpacingBefore(-8);
        CTCD8E.setIndentationLeft(420);
        CTCD8E.setSpacingAfter(-9);
        
        if(CD8R<190){
        documento.add(CTCD8E);
        }

        Paragraph CTCD8E1 = new  Paragraph ("190	               1,140" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CTCD8E1.setSpacingBefore(-8);
        CTCD8E1.setIndentationLeft(420);
        CTCD8E1.setSpacingAfter(-9);

        if(CD8R>=190 && CD8R<=1140){
        documento.add(CTCD8E1);
        }

        Paragraph CTCD8E2 = new  Paragraph ("190	               1,140" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CTCD8E2.setSpacingBefore(-8);
        CTCD8E2.setIndentationLeft(420);
        CTCD8E2.setSpacingAfter(-9);

        if(CD8R>=1140){
        documento.add(CTCD8E2);
        }
        
        Paragraph CD4CD8T = new  Paragraph ("Cociente CD4/CD8" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4CD8T.setSpacingBefore(10);
        CD4CD8T.setIndentationLeft(17);
        CD4CD8T.setSpacingAfter((float) -4);
        
        if(CD4CD8<0.83){
        documento.add(CD4CD8T);
        }

        Paragraph CD4CD8T1 = new  Paragraph ("Cociente CD4/CD8" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4CD8T1.setSpacingBefore(10);
        CD4CD8T1.setIndentationLeft(17);
        CD4CD8T1.setSpacingAfter((float) -4);

        if(CD4CD8>=0.83 && CD4CD8<=6.1){
        documento.add(CD4CD8T1);
        }

        Paragraph CD4CD8T2 = new  Paragraph ("Cociente CD4/CD8" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4CD8T2.setSpacingBefore(10);
        CD4CD8T2.setIndentationLeft(17);
        CD4CD8T2.setSpacingAfter((float) -4);

        if(CD4CD8>=6.1){
        documento.add(CD4CD8T2);
        }
        
        Paragraph CD4CD8R = new  Paragraph (txt_CD4CD8.getText() + " %", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4CD8R.setSpacingBefore((float) -10.5);
        CD4CD8R.setSpacingAfter(-3);

        if(txt_CD4CD8.getText().contains(".") && CD4CD8>0 && CD4CD8<0.83){
        left2 = left2 - 4;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8==0){
        left2 = left2;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        Paragraph CD4CD8R1 = new  Paragraph (txt_CD4CD8.getText() + " %", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4CD8R1.setSpacingBefore((float) -10.5);
        CD4CD8R1.setSpacingAfter(-3);


        if(txt_CD4CD8.getText().contains(".") && CD4CD8>=0.83 && CD4CD8<=6.1){
        left2 = left2 - 4;
        CD4CD8R1.setIndentationLeft(left2);
        documento.add(CD4CD8R1);
        } else {
        if(CD4CD8>=1 && CD4CD8<=6){
        left2 = left2;
        CD4CD8R1.setIndentationLeft(left2);
        documento.add(CD4CD8R1);
        } }

        if(txt_CD4CD8.getText().contains(".") && CD4CD8>6.1 && CD4CD8<10){
        left2 = left2 - 4;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8>=7 && CD4CD8<=9){
        left2 = left2;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        if(txt_CD4CD8.getText().contains(".") && CD4CD8>10 && CD4CD8<100){
        left2 = left2 - 7;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8>=10 && CD4CD8<=99){
        left2 = left2 - 3;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        if(txt_CD4CD8.getText().contains(".") && CD4CD8>100 && CD4CD8<1000){
        left2 = left2 - 10;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8>=100 && CD4CD8<=999){
        left2 = left2 - 6;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }


        if(txt_CD4CD8.getText().contains(".") && CD4CD8>1000 && CD4CD8<10000){
        left2 = left2 - 13;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8>=1000 && CD4CD8<=9999){
        left2 = left2 - 9;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

  
        if(txt_CD4CD8.getText().contains(".") && CD4CD8>10000 && CD4CD8<100000){
        left2 = left2 - 16;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(CD4CD8>=10000 && CD4CD8<=99999){
        left2 = left2 - 12;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }        

        if(CD4CD8>=100000){
        left2 = left2 - 15;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        }

        //negativo
        if(txt_CD4CD8.getText().contains(".") && txt_CD4CD8.getText().contains("-") && CD4CD8>-9 && CD4CD8<0){
        left2 = left2 - 7;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(txt_CD4CD8.getText().contains("-") && CD4CD8>=-9 && CD4CD8<=0){
        left2 = left2 -3;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        if(txt_CD4CD8.getText().contains(".") && txt_CD4CD8.getText().contains("-") && CD4CD8>-100 && CD4CD8<-10){
        left2 = left2 - 10;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(txt_CD4CD8.getText().contains("-") && CD4CD8>=-99 && CD4CD8<=-10){
        left2 = left2 -6;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }
        
        if(txt_CD4CD8.getText().contains(".") && txt_CD4CD8.getText().contains("-") && CD4CD8>-1000 && CD4CD8<-100){
        left2 = left2 - 13;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(txt_CD4CD8.getText().contains("-") && CD4CD8>=-999 && CD4CD8<=-100){
        left2 = left2 - 9;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        if(txt_CD4CD8.getText().contains(".") && txt_CD4CD8.getText().contains("-") && CD4CD8>-10000 && CD4CD8<-1000){
        left2 = left2 - 16;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(txt_CD4CD8.getText().contains("-") && CD4CD8>=-9999 && CD4CD8<=-1000){
        left2 = left2 - 12;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }

        if(txt_CD4CD8.getText().contains(".") && txt_CD4CD8.getText().contains("-") && CD4CD8>-100000 && CD4CD8<-10000){
        left2 = left2 - 22;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } else {
        if(txt_CD4CD8.getText().contains("-") && CD4CD8>=-99999 && CD4CD8<=-10000){
        left2 = left2 - 18;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } }
        
        if(CD4CD8<=-100000){
        left2 = left2 - 18;
        CD4CD8R.setIndentationLeft(left2);
        documento.add(CD4CD8R);
        } 
        
        Paragraph CD4CD8E = new  Paragraph ("0.83                6.1" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4CD8E.setSpacingBefore((float) -11.5);
        CD4CD8E.setIndentationLeft(420);
        CD4CD8E.setSpacingAfter(-3);
        
        if(CD4CD8<0.83){
        documento.add(CD4CD8E);
        }

        Paragraph CD4CD8E1 = new  Paragraph ("0.83                6.1" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CD4CD8E1.setSpacingBefore((float) -11.5);
        CD4CD8E1.setIndentationLeft(420);
        CD4CD8E1.setSpacingAfter(-3);

        if(CD4CD8>=0.83 && CD4CD8<=6.1){
        documento.add(CD4CD8E1);
        }

        Paragraph CD4CD8E2 = new  Paragraph ("0.83                6.1" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CD4CD8E2.setSpacingBefore((float) -11.5);
        CD4CD8E2.setIndentationLeft(420);
        CD4CD8E2.setSpacingAfter(-3);

        if(CD4CD8>=6.1){
        documento.add(CD4CD8E2);
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
            java.util.logging.Logger.getLogger(CD4yCD8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CD4yCD8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CD4yCD8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CD4yCD8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CD4yCD8().setVisible(true);
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
    private javax.swing.JLabel jLabel_CD4CD8;
    private javax.swing.JLabel jLabel_CTCD3;
    private javax.swing.JLabel jLabel_CTCD4;
    private javax.swing.JLabel jLabel_CTCD8;
    private javax.swing.JLabel jLabel_CTCD9;
    private javax.swing.JLabel jLabel_Cooperadores;
    private javax.swing.JLabel jLabel_CopiasmL;
    private javax.swing.JLabel jLabel_Datos;
    private javax.swing.JLabel jLabel_Logaritmo;
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
    private javax.swing.JLabel jLabel_totales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_CD4CD8;
    private javax.swing.JTextField txt_CTCD3;
    private javax.swing.JTextField txt_CTCD4;
    private javax.swing.JTextField txt_CTCD8;
    private javax.swing.JTextField txt_Leucocitostotales;
    private javax.swing.JTextField txt_Linfocitostotales;
    private javax.swing.JTextField txt_NoFolio;
    private javax.swing.JTextField txt_Reporte;
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
