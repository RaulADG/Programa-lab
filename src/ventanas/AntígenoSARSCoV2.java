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
public class AntígenoSARSCoV2 extends javax.swing.JFrame {

   
int IDpaciente_update = 0, IDestudio = 0, IEstudio =0;
String user = "", nom_paciente = "";
 String minutos, ampm;
 Calendar calendario;


    /**
     * Creates new form CargaViralA
     */
    public AntígenoSARSCoV2() {
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
                  "select * from AntígenoSARSCoV2 where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            jTextPane_indicaciones.setText(rs2.getString("Observaciones"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
            txt_AntígenoSARSCoV2.setText(rs2.getString("AntígenoSARSCoV2"));
            txt_SPO2.setText(rs2.getString("SPO2"));
            txt_FC.setText(rs2.getString("FC"));
            txt_TemperaturaC.setText(rs2.getString("Temperaturacorporal"));
            
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
        jLabel_GpS = new javax.swing.JLabel();
        txt_AntígenoSARSCoV2 = new javax.swing.JTextField();
        jCheckBox_firma = new javax.swing.JCheckBox();
        jLabel_GpS1 = new javax.swing.JLabel();
        jLabel_ValoresdeResultado1 = new javax.swing.JLabel();
        jLabel_ValoresdeResultado2 = new javax.swing.JLabel();
        txt_SPO2 = new javax.swing.JTextField();
        jLabel_SPO2 = new javax.swing.JLabel();
        jLabel_ValoresNSP02 = new javax.swing.JLabel();
        jLabel_fc = new javax.swing.JLabel();
        txt_FC = new javax.swing.JTextField();
        jLabel_ValoresNFC = new javax.swing.JLabel();
        jLabel_Temperaturac = new javax.swing.JLabel();
        jLabel_Temperaturac1 = new javax.swing.JLabel();
        txt_TemperaturaC = new javax.swing.JTextField();
        jLabel_ValoresNFC1 = new javax.swing.JLabel();
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
        getContentPane().add(jButton_GuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 820, 130, -1));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 250, 26));

        txt_Reporte.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reporte.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reporte.setText("No");
        txt_Reporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 870, 210, -1));

        jLabel_Datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Datos.setText("Datos guardados:");
        getContentPane().add(jLabel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 870, -1, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 820, 130, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Reporte");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 820, 130, -1));

        jLabel_ValoresdeResultado.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado.setText("Valores de resultado:");
        getContentPane().add(jLabel_ValoresdeResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        jLabel_GpS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_GpS.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_GpS.setText("Antígeno de SARS CoV-2 (COVID-19)");
        getContentPane().add(jLabel_GpS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        txt_AntígenoSARSCoV2.setBackground(new java.awt.Color(153, 153, 255));
        txt_AntígenoSARSCoV2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_AntígenoSARSCoV2.setForeground(new java.awt.Color(255, 255, 255));
        txt_AntígenoSARSCoV2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_AntígenoSARSCoV2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_AntígenoSARSCoV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 210, -1));

        jCheckBox_firma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox_firma.setText("Incluir firma");
        jCheckBox_firma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_firmaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_firma, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 920, -1, -1));

        jLabel_GpS1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_GpS1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_GpS1.setText("Método: Inmunocromatografía");
        getContentPane().add(jLabel_GpS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, 10));

        jLabel_ValoresdeResultado1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado1.setText("Valores de referencia:");
        getContentPane().add(jLabel_ValoresdeResultado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, -1, -1));

        jLabel_ValoresdeResultado2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresdeResultado2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado2.setText("Negativo");
        getContentPane().add(jLabel_ValoresdeResultado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, -1, -1));

        txt_SPO2.setBackground(new java.awt.Color(153, 153, 255));
        txt_SPO2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_SPO2.setForeground(new java.awt.Color(255, 255, 255));
        txt_SPO2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SPO2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_SPO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 210, -1));

        jLabel_SPO2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_SPO2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_SPO2.setText("SPO2:");
        getContentPane().add(jLabel_SPO2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 696, -1, -1));

        jLabel_ValoresNSP02.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresNSP02.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresNSP02.setText("Valor nominal: 95-100%.");
        getContentPane().add(jLabel_ValoresNSP02, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 690, -1, -1));

        jLabel_fc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fc.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fc.setText("FC:");
        getContentPane().add(jLabel_fc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 735, -1, -1));

        txt_FC.setBackground(new java.awt.Color(153, 153, 255));
        txt_FC.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_FC.setForeground(new java.awt.Color(255, 255, 255));
        txt_FC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_FC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_FC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 210, -1));

        jLabel_ValoresNFC.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresNFC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresNFC.setText("Valor nominal: 60-100 ppm.");
        getContentPane().add(jLabel_ValoresNFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 730, -1, -1));

        jLabel_Temperaturac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Temperaturac.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Temperaturac.setText("Temperatura");
        getContentPane().add(jLabel_Temperaturac, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 768, -1, -1));

        jLabel_Temperaturac1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Temperaturac1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Temperaturac1.setText("corporal");
        getContentPane().add(jLabel_Temperaturac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 782, -1, -1));

        txt_TemperaturaC.setBackground(new java.awt.Color(153, 153, 255));
        txt_TemperaturaC.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TemperaturaC.setForeground(new java.awt.Color(255, 255, 255));
        txt_TemperaturaC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TemperaturaC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_TemperaturaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 770, 210, -1));

        jLabel_ValoresNFC1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel_ValoresNFC1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresNFC1.setText("Valor nominal: 35.5-37.2 °C.");
        getContentPane().add(jLabel_ValoresNFC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 770, -1, -1));

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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, AntígenoSARSCoV2R, SPO2R, FCR, TemperaturaCR, Reporte_generado1; 
      
      Calendar calendario = new GregorianCalendar();
      ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"a.m.":"p.m.";
      java.util.Date d0 = new java.util.Date();
      SimpleDateFormat hourtwenty0 = new SimpleDateFormat("hh:mm");
      
      NoFolio = txt_NoFolio.getText().trim();
      ClaveE = txt_claveEstudio.getText().trim();
      empresa = txt_empresa.getText().trim();
      nombre = txt_nombre.getText().trim();
      apellido = txt_apellido.getText().trim();
      edad = txt_edad.getText().trim();
      nombremedico = txt_nombremedico.getText().trim();
      sexo = txt_sexo.getText().trim();
      fechaEntrega = dFormat.format(jDateChooser_fnacimiento.getDate());
      hora = hourtwenty0.format(d0)+ " "+ ampm;
      observaciones = jTextPane_indicaciones.getText().trim();
      AntígenoSARSCoV2R = txt_AntígenoSARSCoV2.getText().trim();
      SPO2R = txt_SPO2.getText().trim();
      FCR = txt_FC.getText().trim();
      TemperaturaCR = txt_TemperaturaC.getText().trim();
      
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
       if(AntígenoSARSCoV2R.equals("")) {
           txt_AntígenoSARSCoV2.setBackground(Color.red);
           validacion++;     
       }
       if(SPO2R.equals("")) {
           txt_SPO2.setBackground(Color.red);
           validacion++;     
       }
       if(FCR.equals("")) {
           txt_FC.setBackground(Color.red);
           validacion++;     
       }
       if(TemperaturaCR.equals("")) {
           txt_TemperaturaC.setBackground(Color.red);
           validacion++;     
       }
               
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "insert into AntígenoSARSCoV2 values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
             
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
             pst.setString(13, AntígenoSARSCoV2R);
             pst.setString(14, SPO2R);
             pst.setString(15, FCR);
             pst.setString(16, TemperaturaCR);
             pst.setString(17, user);
             pst.setString(18, Reporte_generado1);
          
             
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
             txt_AntígenoSARSCoV2.setBackground(Color.green);
             txt_SPO2.setBackground(Color.green);
             txt_FC.setBackground(Color.green);
             txt_TemperaturaC.setBackground(Color.green);
             
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 
           
       
    
         try {
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from GruposanguíneoyRh where ID_estudio = '" + IEstudio + "'");
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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, AntígenoSARSCoV2R,SPO2R, FCR, TemperaturaCR,Reporte_generado1; 
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
      AntígenoSARSCoV2R = txt_AntígenoSARSCoV2.getText().trim();
      SPO2R = txt_SPO2.getText().trim();
      FCR = txt_FC.getText().trim();
      TemperaturaCR = txt_TemperaturaC.getText().trim();
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
 
       if(AntígenoSARSCoV2R.equals("")) {
           txt_AntígenoSARSCoV2.setBackground(Color.red);
           validacion++;     
       }
       if(SPO2R.equals("")) {
           txt_SPO2.setBackground(Color.red);
           validacion++;     
       }
       if(FCR.equals("")) {
           txt_FC.setBackground(Color.red);
           validacion++;     
       }
       if(TemperaturaCR.equals("")) {
           txt_TemperaturaC.setBackground(Color.red);
           validacion++;     
       }
     
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "update AntígenoSARSCoV2 set Fecha_entrega=?, Hora=?, Observaciones=?, AntígenoSARSCoV2=?, SPO2=?, FC=?, Temperaturacorporal=?, ultima_modificacion=? " 
                   + "where ID_estudio = '" + IEstudio + "'");
             
         
             pst.setString(1, fechaEntrega);
             pst.setString(2, hora);
             pst.setString(3, observaciones);
             pst.setString(4, AntígenoSARSCoV2R);
             pst.setString(5, SPO2R);
             pst.setString(6, FCR);
             pst.setString(7, TemperaturaCR);
             pst.setString(8, user);
    
             
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
             txt_AntígenoSARSCoV2.setBackground(Color.green);
             txt_SPO2.setBackground(Color.green);
             txt_FC.setBackground(Color.green);
             txt_TemperaturaC.setBackground(Color.green);
             
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
                     "update AntígenoSARSCoV2 set Hora=?, ultima_modificacion=?"
                     
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
        estudio.setSpacingBefore(-1);
        estudio.setIndentationLeft(17);
        estudio.setSpacingAfter(-3);
        documento.add(estudio);
        
        Paragraph resultado = new  Paragraph ("Resultado"  , FontFactory.getFont("arial", 11, Font.BOLD, BaseColor.BLACK));
        resultado.setSpacingBefore(-13);
        resultado.setIndentationLeft(295);
        resultado.setSpacingAfter(-3);
        documento.add(resultado);

        PdfContentByte cb0 = writer.getDirectContent();
        BaseFont bf0 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb0.saveState();
        cb0.beginText();
        cb0.setFontAndSize(bf0, 11);
        cb0.setColorFill(BaseColor.BLACK);
        cb0.moveText((float) 445, (float) 599.5);
        cb0.showText("Valores de referencia");
        cb0.endText();
        cb0.restoreState();

        
        if(txt_AntígenoSARSCoV2.getText().contains("Positivo")){
         PdfContentByte cb01 = writer.getDirectContent();
        BaseFont bf01 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb01.saveState();
        cb01.beginText();
        cb01.setFontAndSize(bf01, 12);
        cb01.setColorFill(BaseColor.BLACK);
        cb01.moveText((float) 479, 573);
        cb01.showText("Negativo");
        cb01.endText();
        cb01.restoreState();
        } else {
        if(txt_AntígenoSARSCoV2.getText().contains("Negativo")){
         PdfContentByte cb01 = writer.getDirectContent();
        BaseFont bf01 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb01.saveState();
        cb01.beginText();
        cb01.setFontAndSize(bf01, 12);
        cb01.setColorFill(BaseColor.BLACK);
        cb01.moveText((float) 479, 573);
        cb01.showText("Negativo");
        cb01.endText();
        cb01.restoreState();
        } else {
         PdfContentByte cb01 = writer.getDirectContent();
        BaseFont bf01 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb01.saveState();
        cb01.beginText();
        cb01.setFontAndSize(bf01, 12);
        cb01.setColorFill(BaseColor.BLACK);
        cb01.moveText((float) 479, 573);
        cb01.showText("Negativo");
        cb01.endText();
        cb01.restoreState();
        }
          } 

           
        Chunk chunk2 = new Chunk("Antígeno de SARS CoV-2 (COVID-19)", FontFactory.getFont("arial", 12,Font.BOLD, BaseColor.BLACK));
        chunk2.setUnderline(1.5f, -3.5f);
        
        Paragraph chunk = new  Paragraph ((chunk2));
        chunk.setSpacingBefore(10);
        chunk.setIndentationLeft(17);
        chunk.setSpacingAfter(-3);
        documento.add(chunk);
        
        Paragraph metodo = new  Paragraph ("Método: Inmunocromatografía" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        metodo.setSpacingBefore(2);
        metodo.setIndentationLeft(17);
        metodo.setSpacingAfter(-3);
        documento.add(metodo);



        float left = 300;

Paragraph AntígenoSARSCoV2R0 = new  Paragraph (txt_AntígenoSARSCoV2.getText(), FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLACK));
        AntígenoSARSCoV2R0.setSpacingBefore((float) -28.5);
        AntígenoSARSCoV2R0.setSpacingAfter(-3);
        AntígenoSARSCoV2R0.setIndentationLeft(left);
        
        Paragraph AntígenoSARSCoV2R = new  Paragraph (txt_AntígenoSARSCoV2.getText(), FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLACK));
        AntígenoSARSCoV2R.setSpacingBefore((float) -28.5);
        AntígenoSARSCoV2R.setSpacingAfter(-3);
        AntígenoSARSCoV2R.setIndentationLeft(left);
        
        Paragraph AntígenoSARSCoV2R1 = new  Paragraph (txt_AntígenoSARSCoV2.getText(), FontFactory.getFont("arial", 12, Font.NORMAL, BaseColor.BLACK));
        AntígenoSARSCoV2R1.setSpacingBefore((float) -28.5);
        AntígenoSARSCoV2R1.setSpacingAfter(-3);
        AntígenoSARSCoV2R1.setIndentationLeft(left);

        if(txt_AntígenoSARSCoV2.getText().contains("Positivo")){
         documento.add(AntígenoSARSCoV2R);
        } else {
        if(txt_AntígenoSARSCoV2.getText().contains("Negativo")){
          documento.add(AntígenoSARSCoV2R1);
        } else {
          documento.add(AntígenoSARSCoV2R0);
        }
          } 
        double SPO2, FC, TemperaturaCD;
       String SPO2f = txt_SPO2.getText(), FCf = txt_FC.getText(), TemperaturaC = txt_TemperaturaC.getText();
 
        if(txt_SPO2.getText().contains("NA")){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.BLACK);
        cb1.moveText((float) 76, 537); 
        cb1.showText(txt_SPO2.getText());
        cb1.endText();
        cb1.restoreState(); 
        } else {
        SPO2 = Double.parseDouble(txt_SPO2.getText()); 
        if(txt_SPO2.getText().contains(".") && SPO2>0 && SPO2<10){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.RED);
        cb1.moveText((float) 73, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();  
        } else {
        if(SPO2>=0 && SPO2<=9){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.RED);
        cb1.moveText((float) 76, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();
        } }
        
        if(txt_SPO2.getText().contains(".") && SPO2>10 && SPO2<95 ){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.RED);
        cb1.moveText((float) 71, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();  
        } else {
        if(SPO2>=10 && SPO2<=95){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.RED);
        cb1.moveText((float) 74, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();
        } }
        
        if(txt_SPO2.getText().contains(".") && SPO2>95 && SPO2<100){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont SPO2bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(SPO2bf1, 8);
        cb1.setColorFill(BaseColor.BLACK);
        cb1.moveText((float) 71, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();  
        } else {
        if(SPO2>=96 && SPO2<=99){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.BLACK);
        cb1.moveText((float) 74, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();
        } 
           } 
        
        if(SPO2>=100){
        PdfContentByte cb1 = writer.getDirectContent();
        BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb1.saveState();
        cb1.beginText();
        cb1.setFontAndSize(bf1, 8);
        cb1.setColorFill(BaseColor.BLACK);
        cb1.moveText((float) 72, 537); 
        cb1.showText(SPO2f +"%.");
        cb1.endText();
        cb1.restoreState();
        } 
}
 
        if(txt_FC.getText().contains("NA")){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.BLACK);
        cb5.moveText((float) 215, 537); 
        cb5.showText(txt_FC.getText());
        cb5.endText();
        cb5.restoreState();
        } else {
        FC = Double.parseDouble(txt_FC.getText()); 
          if(txt_FC.getText().contains(".") && FC>0 && FC<10){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.RED);
        cb5.moveText((float) 206, 537);
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();
        } else {
        if(FC>=0 && FC<=9){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.RED);
        cb5.moveText((float) 209, 537);
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();
        } }

        if(txt_FC.getText().contains(".") && FC>10 && FC<60){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.RED);
        cb5.moveText((float) 204, 537);
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();  
        } else {
        if(FC>=10 && FC<=60){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.RED);
        cb5.moveText((float) 207, 537);
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();
        } }
            
        if(txt_FC.getText().contains(".") && FC>60 && FC<100){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.BLACK);
        cb5.moveText((float) 204, 537); 
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();  
        } else {
        if(FC>=61 && FC<=99){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.BLACK);
        cb5.moveText((float) 207, 537); 
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();
        } }
           
        if(FC>=100){
        PdfContentByte cb5 = writer.getDirectContent();
        BaseFont bf5 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb5.saveState();
        cb5.beginText();
        cb5.setFontAndSize(bf5, 8);
        cb5.setColorFill(BaseColor.RED);
        cb5.moveText((float) 205, 537); 
        cb5.showText(FCf + " pmm.");
        cb5.endText();
        cb5.restoreState();
        } 
}

        if(txt_TemperaturaC.getText().contains("NA")) {
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.BLACK);
        cb9.moveText((float) 441, 537);
        cb9.showText(txt_TemperaturaC.getText());
        cb9.endText();
        cb9.restoreState();} else {
        TemperaturaCD = Double.parseDouble(txt_TemperaturaC.getText()); 
        if(txt_TemperaturaC.getText().contains(".") && TemperaturaCD>0 && TemperaturaCD<10){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 436, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } else {
        if(TemperaturaCD>=0 && TemperaturaCD<=9){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 439, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } }

        if(TemperaturaCD>10 && TemperaturaCD<=35.5 && txt_TemperaturaC.getText().contains(".")){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 434, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } else {
        if(TemperaturaCD>=10 && TemperaturaCD<=35){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 437, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();  
        } }

        if(txt_TemperaturaC.getText().contains(".") && TemperaturaCD>35.5 && TemperaturaCD<37.2){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.BLACK);
        cb9.moveText((float) 434, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();  
        } else { 
        if(TemperaturaCD>=36 && TemperaturaCD<=37){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.BLACK);
        cb9.moveText((float) 437, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } }

        if(txt_TemperaturaC.getText().contains(".") && TemperaturaCD>37.2 && TemperaturaCD<100){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 434, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();  
        } else { 
        if(TemperaturaCD>=38 && TemperaturaCD<=99){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 437, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } }
        
        if(TemperaturaCD>=100){
        PdfContentByte cb9 = writer.getDirectContent();
        BaseFont bf9 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb9.saveState();
        cb9.beginText();
        cb9.setFontAndSize(bf9, 8);
        cb9.setColorFill(BaseColor.RED);
        cb9.moveText((float) 435, 537);
        cb9.showText(TemperaturaC + " °C.");
        cb9.endText();
        cb9.restoreState();
        } 

}

        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.saveState();
        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.setColorFill(new BaseColor(105, 0, 105));
        cb.moveText((float) 45.5, 537);
        cb.showText("SPO2:");
        cb.endText();
        cb.restoreState();
        
        
 
        PdfContentByte cb2 = writer.getDirectContent();
        BaseFont bf2 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb2.saveState();
        cb2.beginText();
        cb2.setFontAndSize(bf2, 8);
        cb2.setColorFill(new BaseColor(0, 32, 96));
        cb2.moveText((float) 98, 537);
        cb2.showText("Valor normal:");
        cb2.endText();
        cb2.restoreState();

        PdfContentByte cb3 = writer.getDirectContent();
        BaseFont bf3 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb3.saveState();
        cb3.beginText();
        cb3.setFontAndSize(bf3, 8);
        cb3.setColorFill(BaseColor.BLACK);
        cb3.moveText((float) 152, 537);
        cb3.showText("95-100%.");
        cb3.endText();
        cb3.restoreState();

        PdfContentByte cb4 = writer.getDirectContent();
        BaseFont bf4 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb4.saveState();
        cb4.beginText();
        cb4.setFontAndSize(bf4, 8);
        cb4.setColorFill(new BaseColor(105, 0, 105));
        cb4.moveText((float) 189, 537);
        cb4.showText("FC:");
        cb4.endText();
        cb4.restoreState();

      

        PdfContentByte cb6 = writer.getDirectContent();
        BaseFont bf6 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb6.saveState();
        cb6.beginText();
        cb6.setFontAndSize(bf6, 8);
        cb6.setColorFill(new BaseColor(0, 32, 96));
        cb6.moveText((float) 245, 537);
        cb6.showText("Valor normal:");
        cb6.endText();
        cb6.restoreState();

        PdfContentByte cb7 = writer.getDirectContent();
        BaseFont bf7 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb7.saveState();
        cb7.beginText();
        cb7.setFontAndSize(bf7, 8);
        cb7.setColorFill(BaseColor.BLACK);
        cb7.moveText((float) 299, 537);
        cb7.showText("60-100 ppm.");
        cb7.endText();
        cb7.restoreState();
              
        PdfContentByte cb8 = writer.getDirectContent();
        BaseFont bf8 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb8.saveState();
        cb8.beginText();
        cb8.setFontAndSize(bf8, 8);
        cb8.setColorFill(new BaseColor(105, 0, 105));
        cb8.moveText((float) 347, 537);
        cb8.showText("Temperatura corporal:");
        cb8.endText();
        cb8.restoreState();

        

        PdfContentByte cb10 = writer.getDirectContent();
        BaseFont bf10 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb10.saveState();
        cb10.beginText();
        cb10.setFontAndSize(bf10, 8);
        cb10.setColorFill(new BaseColor(0, 32, 96));
        cb10.moveText((float) 465, 537);
        cb10.showText("Valor normal:");
        cb10.endText();
        cb10.restoreState();

        PdfContentByte cb11 = writer.getDirectContent();
        BaseFont bf11 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb11.saveState();
        cb11.beginText();
        cb11.setFontAndSize(bf11, 8);
        cb11.setColorFill(BaseColor.BLACK);
        cb11.moveText((float) 519, 537);
        cb11.showText("35.5-37.2 °C.");
        cb11.endText();
        cb11.restoreState();

        Paragraph Observaciones = new  Paragraph ("Observaciones:" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Observaciones.setSpacingBefore((float) 50);
        Observaciones.setIndentationLeft(17);
        Observaciones.setSpacingAfter(-3);
        documento.add(Observaciones);
 
        PdfContentByte cb12 = writer.getDirectContent();
        BaseFont bf12 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb12.saveState();
        cb12.beginText();
        cb12.setFontAndSize(bf12, 10);
        cb12.setColorFill(BaseColor.BLACK);
        cb12.moveText((float) 45.5, 489);
        cb12.showText("• Durante los primeros días (aproximadamente 7 días a partir de los síntomas) la prueba recomendada para");
        cb12.endText();
        cb12.restoreState();

        PdfContentByte cb13 = writer.getDirectContent();
        BaseFont bf13 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb13.saveState();
        cb13.beginText();
        cb13.setFontAndSize(bf13, 10);
        cb13.setColorFill(BaseColor.BLACK);
        cb13.moveText((float) 52, 477);
        cb13.showText("detectar SARS CoV-2 es la RT-PCR (Reacción en Cadena de la Polimerasa) o el Antígeno de SARS CoV-2.");
        cb13.endText();
        cb13.restoreState();

        PdfContentByte cb14 = writer.getDirectContent();
        BaseFont bf14 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb14.saveState();
        cb14.beginText();
        cb14.setFontAndSize(bf14, 10);
        cb14.setColorFill(BaseColor.BLACK);
        cb14.moveText((float) 45.5, 465);
        cb14.showText("• Un resultado Negativo no descarta la infección presente o futura por SARS CoV-2.");
        cb14.endText();
        cb14.restoreState();

        PdfContentByte cb15 = writer.getDirectContent();
        BaseFont bf15 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb15.saveState();
        cb15.beginText();
        cb15.setFontAndSize(bf15, 10);
        cb15.setColorFill(BaseColor.BLACK);
        cb15.moveText((float) 45.5, 453);
        cb15.showText("• Los resultados negativos deben combinarse con observaciones clínicas, historial del paciente e información");
        cb15.endText();
        cb15.restoreState();

        PdfContentByte cb16 = writer.getDirectContent();
        BaseFont bf16 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb16.saveState();
        cb16.beginText();
        cb16.setFontAndSize(bf16, 10);
        cb16.setColorFill(BaseColor.BLACK);
        cb16.moveText((float) 52, 441);
        cb16.showText("epidemiológica.");
        cb16.endText();
        cb16.restoreState();

        PdfContentByte cb17 = writer.getDirectContent();
        BaseFont bf17 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb17.saveState();
        cb17.beginText();
        cb17.setFontAndSize(bf17, 10);
        cb17.setColorFill(BaseColor.BLACK);
        cb17.moveText((float) 45.5, 429);
        cb17.showText("• La prueba no está diseñada para usarse como prueba de detección de donantes para el SARS-CoV-2.");
        cb17.endText();
        cb17.restoreState();

        com.itextpdf.text.Image Grafica = com.itextpdf.text.Image.getInstance("images/Grafica.jpg");
        Grafica.scaleAbsolute(400, 230);
        Grafica.setAbsolutePosition(105,197);
        documento.add(Grafica);
        
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
            java.util.logging.Logger.getLogger(AntígenoSARSCoV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntígenoSARSCoV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntígenoSARSCoV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntígenoSARSCoV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntígenoSARSCoV2().setVisible(true);
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
    private javax.swing.JLabel jLabel_Datos;
    private javax.swing.JLabel jLabel_GpS;
    private javax.swing.JLabel jLabel_GpS1;
    private javax.swing.JLabel jLabel_NoFolio;
    private javax.swing.JLabel jLabel_SPO2;
    private javax.swing.JLabel jLabel_Temperaturac;
    private javax.swing.JLabel jLabel_Temperaturac1;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_ValoresNFC;
    private javax.swing.JLabel jLabel_ValoresNFC1;
    private javax.swing.JLabel jLabel_ValoresNSP02;
    private javax.swing.JLabel jLabel_ValoresdeResultado;
    private javax.swing.JLabel jLabel_ValoresdeResultado1;
    private javax.swing.JLabel jLabel_ValoresdeResultado2;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_edad;
    private javax.swing.JLabel jLabel_empresa;
    private javax.swing.JLabel jLabel_fc;
    private javax.swing.JLabel jLabel_fechadeentrega;
    private javax.swing.JLabel jLabel_hora;
    private javax.swing.JLabel jLabel_indicaciones;
    private javax.swing.JLabel jLabel_medico;
    private javax.swing.JLabel jLabel_nombres;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_AntígenoSARSCoV2;
    private javax.swing.JTextField txt_FC;
    private javax.swing.JTextField txt_NoFolio;
    private javax.swing.JTextField txt_Reporte;
    private javax.swing.JTextField txt_SPO2;
    private javax.swing.JTextField txt_TemperaturaC;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_claveEstudio;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_sexo;
    // End of variables declaration//GEN-END:variables

    private static class BLACK {

        public BLACK() {
        }
    }
 

}
