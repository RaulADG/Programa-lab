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
import java.awt.font.TextAttribute;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.text.AttributedString;
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
public class BH6a10años extends javax.swing.JFrame {

   
int IDpaciente_update = 0, IDestudio = 0, IEstudio =0;
String user = "", nom_paciente = "";
 String minutos, ampm;
 Calendar calendario;
    /**
     * Creates new form CargaViralA
     */
    public BH6a10años() {
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
                  "select * from BH6a10años where ID_estudio = '" + IEstudio + "'");
          ResultSet rs2 = pst2.executeQuery();
          
          if (rs2.next()) {
            
            txt_hora.setText(rs2.getString("Hora"));
            jDateChooser_fnacimiento.setDate(rs2.getDate("Fecha_entrega"));
            jTextPane_indicaciones.setText(rs2.getString("Observaciones"));
            txt_Reporte.setText(rs2.getString("Reporte_generado"));
            txt_Eritrocitos.setText(rs2.getString("Eritrocitos"));
            txt_Hemoglobina.setText(rs2.getString("Hemoglobina"));
            txt_Hematocrito.setText(rs2.getString("Hematocrito"));
            txt_VolumenGlobularMedioVCM.setText(rs2.getString("VolumenGlobularMedioVCM"));
            txt_ConcentracióMediadeHemoglobinaHCM.setText(rs2.getString("ConcentraciónMediadeHemoglobinaHCM"));
            txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setText(rs2.getString("ConcentraciónMediadeHemoglobinaCorpuscularCHCM"));
            txt_ÍndicededistribucióndeeritrocitosRDW.setText(rs2.getString("ÍndicededistribucióndeeritrocitosRDW"));
            txt_Plaquetas.setText(rs2.getString("Plaquetas"));
            txt_VolumenPlaquetarioMedioVPM.setText(rs2.getString("VolumenPlaquetarioMedioVPM"));
            txt_Leucocitostotales.setText(rs2.getString("Leucocitostotales"));
            txt_Leucocitostotales1.setText(rs2.getString("Leucocitostotales1"));
            txt_Neutrófilostotales.setText(rs2.getString("Neutrófilostotales"));
            txt_Neutrófilostotales1.setText(rs2.getString("Neutrófilostotales1"));
            txt_Neutrófilossegmentados.setText(rs2.getString("Neutrófilossegmentados"));
            txt_Neutrófilossegmentados1.setText(rs2.getString("Neutrófilossegmentados1"));
            txt_Neutrófilosenbanda.setText(rs2.getString("Neutrófilosenbanda"));
            txt_Neutrófilosenbanda1.setText(rs2.getString("Neutrófilosenbanda1"));
            txt_Metamielocitos.setText(rs2.getString("Metamielocitos"));
            txt_Metamielocitos1.setText(rs2.getString("Metamielocitos1"));
            txt_Mielocitos.setText(rs2.getString("Mielocitos"));
            txt_Mielocitos1.setText(rs2.getString("Mielocitos1"));
            txt_Promielocitos.setText(rs2.getString("Promielocitos"));
            txt_Promielocitos1.setText(rs2.getString("Promielocitos1"));
            txt_Blastos.setText(rs2.getString("Blastos"));
            txt_Blastos1.setText(rs2.getString("Blastos1"));
            txt_Eosinófilos.setText(rs2.getString("Eosinófilos"));
            txt_Eosinófilos1.setText(rs2.getString("Eosinófilos1"));
            txt_Basófilos.setText(rs2.getString("Basófilos"));
            txt_Basófilos1.setText(rs2.getString("Basófilos1"));
            txt_Monocitos.setText(rs2.getString("Monocitos"));
            txt_Monocitos1.setText(rs2.getString("Monocitos1"));
            txt_Linfocitos.setText(rs2.getString("Linfocitos"));
            txt_Linfocitos1.setText(rs2.getString("Linfocitos1"));
          }
          
          
        } catch (SQLException e) {
         System.err.println("Error al consultar la información del estudio");
        }
  
        setSize(1450, 930);
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
        jLabel_Eritrocitos = new javax.swing.JLabel();
        txt_Eritrocitos = new javax.swing.JTextField();
        jLabel_Hemoglobina = new javax.swing.JLabel();
        txt_Hemoglobina = new javax.swing.JTextField();
        jCheckBox_firma = new javax.swing.JCheckBox();
        jLabel_Fórmularoja = new javax.swing.JLabel();
        jLabel_Hematocrito = new javax.swing.JLabel();
        txt_Hematocrito = new javax.swing.JTextField();
        txt_VolumenGlobularMedioVCM = new javax.swing.JTextField();
        txt_ConcentracióMediadeHemoglobinaHCM = new javax.swing.JTextField();
        jLabel_CHCM = new javax.swing.JLabel();
        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM = new javax.swing.JTextField();
        jLabel_VolumenGlobular1 = new javax.swing.JLabel();
        jLabel_ConcentraciónMedia = new javax.swing.JLabel();
        jLabel_deHemoglobinaHCM = new javax.swing.JLabel();
        jLabel_CHCM1 = new javax.swing.JLabel();
        jLabel_CHCM4 = new javax.swing.JLabel();
        jLabel_CHCM5 = new javax.swing.JLabel();
        txt_ÍndicededistribucióndeeritrocitosRDW = new javax.swing.JTextField();
        jLabel_CHCM6 = new javax.swing.JLabel();
        txt_Plaquetas = new javax.swing.JTextField();
        jLabel_CHCM7 = new javax.swing.JLabel();
        jLabel_CHCM8 = new javax.swing.JLabel();
        txt_VolumenPlaquetarioMedioVPM = new javax.swing.JTextField();
        jLabel_FórmulaBlanca = new javax.swing.JLabel();
        jLabel_Leucocitostotales = new javax.swing.JLabel();
        txt_Leucocitostotales = new javax.swing.JTextField();
        jLabel_Neutrófilostotales = new javax.swing.JLabel();
        txt_Neutrófilostotales = new javax.swing.JTextField();
        jLabel_Neutrófilossegmentados = new javax.swing.JLabel();
        txt_Neutrófilossegmentados = new javax.swing.JTextField();
        jLabel_Neutrófilosenbanda = new javax.swing.JLabel();
        txt_Neutrófilosenbanda = new javax.swing.JTextField();
        jLabel_Metamielocitos = new javax.swing.JLabel();
        txt_Metamielocitos = new javax.swing.JTextField();
        jLabel_Mielocitos = new javax.swing.JLabel();
        txt_Mielocitos = new javax.swing.JTextField();
        jLabel_Promielocitos = new javax.swing.JLabel();
        txt_Promielocitos = new javax.swing.JTextField();
        jLabel_Blastos = new javax.swing.JLabel();
        txt_Blastos = new javax.swing.JTextField();
        jLabel_Eosinófilos = new javax.swing.JLabel();
        txt_Eosinófilos = new javax.swing.JTextField();
        jLabel_Basófilos = new javax.swing.JLabel();
        txt_Basófilos = new javax.swing.JTextField();
        jLabel_Monocitos = new javax.swing.JLabel();
        txt_Monocitos = new javax.swing.JTextField();
        jLabel_Linfocitos = new javax.swing.JLabel();
        txt_Linfocitos = new javax.swing.JTextField();
        txt_Neutrófilostotales1 = new javax.swing.JTextField();
        txt_Neutrófilossegmentados1 = new javax.swing.JTextField();
        txt_Neutrófilosenbanda1 = new javax.swing.JTextField();
        txt_Metamielocitos1 = new javax.swing.JTextField();
        txt_Mielocitos1 = new javax.swing.JTextField();
        txt_Promielocitos1 = new javax.swing.JTextField();
        txt_Blastos1 = new javax.swing.JTextField();
        txt_Eosinófilos1 = new javax.swing.JTextField();
        txt_Basófilos1 = new javax.swing.JTextField();
        txt_Monocitos1 = new javax.swing.JTextField();
        txt_Linfocitos1 = new javax.swing.JTextField();
        jLabel_guion = new javax.swing.JLabel();
        jLabel_guion1 = new javax.swing.JLabel();
        jLabel_guion2 = new javax.swing.JLabel();
        jLabel_guion3 = new javax.swing.JLabel();
        jLabel_guion4 = new javax.swing.JLabel();
        jLabel_guion5 = new javax.swing.JLabel();
        jLabel_guion6 = new javax.swing.JLabel();
        jLabel_guion7 = new javax.swing.JLabel();
        jLabel_guion8 = new javax.swing.JLabel();
        jLabel_guion9 = new javax.swing.JLabel();
        jLabel_guion10 = new javax.swing.JLabel();
        txt_Leucocitostotales1 = new javax.swing.JTextField();
        jLabel_guion11 = new javax.swing.JLabel();
        jLabel_UL = new javax.swing.JLabel();
        jLabel_UL1 = new javax.swing.JLabel();
        jLabel_porcentaje = new javax.swing.JLabel();
        jLabel_porcentaje1 = new javax.swing.JLabel();
        jLabel_porcentaje2 = new javax.swing.JLabel();
        jLabel_porcentaje3 = new javax.swing.JLabel();
        jLabel_porcentaje4 = new javax.swing.JLabel();
        jLabel_porcentaje5 = new javax.swing.JLabel();
        jLabel_porcentaje6 = new javax.swing.JLabel();
        jLabel_porcentaje7 = new javax.swing.JLabel();
        jLabel_porcentaje8 = new javax.swing.JLabel();
        jLabel_porcentaje9 = new javax.swing.JLabel();
        jLabel_porcentaje10 = new javax.swing.JLabel();
        jLabel_uL2 = new javax.swing.JLabel();
        jLabel_uL3 = new javax.swing.JLabel();
        jLabel_uL4 = new javax.swing.JLabel();
        jLabel_uL5 = new javax.swing.JLabel();
        jLabel_uL6 = new javax.swing.JLabel();
        jLabel_uL7 = new javax.swing.JLabel();
        jLabel_uL8 = new javax.swing.JLabel();
        jLabel_uL9 = new javax.swing.JLabel();
        jLabel_uL10 = new javax.swing.JLabel();
        jLabel_uL11 = new javax.swing.JLabel();
        jLabel_uL12 = new javax.swing.JLabel();
        jButton_CalcularValores = new javax.swing.JButton();
        jLabel_Wallpaper2 = new javax.swing.JLabel();
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
        txt_NoFolio.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_NoFolio.setEnabled(false);
        txt_NoFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NoFolioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_NoFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel_empresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_empresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_empresa.setText("Empresa:");
        getContentPane().add(jLabel_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txt_empresa.setBackground(new java.awt.Color(153, 153, 255));
        txt_empresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_empresa.setForeground(new java.awt.Color(255, 255, 255));
        txt_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_empresa.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, -1));

        jLabe_claveEstudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabe_claveEstudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabe_claveEstudio.setText("Clave de estudio:");
        getContentPane().add(jLabe_claveEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_claveEstudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_claveEstudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_claveEstudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_claveEstudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_claveEstudio.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_claveEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_claveEstudioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_claveEstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel_nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombres.setText("Nombre(s):");
        getContentPane().add(jLabel_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 210, -1));

        jLabel_apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_apellidos.setText("Apellidos:");
        getContentPane().add(jLabel_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(153, 153, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, -1));

        jLabel_edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_edad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_edad.setText("Edad:");
        getContentPane().add(jLabel_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        txt_edad.setBackground(new java.awt.Color(153, 153, 255));
        txt_edad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(255, 255, 255));
        txt_edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_edad.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 210, -1));

        jLabel_medico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_medico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_medico.setText("Médico solicitante:");
        getContentPane().add(jLabel_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        txt_nombremedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombremedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombremedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombremedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombremedico.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 310, -1));

        jLabel_sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sexo.setText("Sexo:");
        getContentPane().add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        txt_sexo.setBackground(new java.awt.Color(153, 153, 255));
        txt_sexo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_sexo.setForeground(new java.awt.Color(255, 255, 255));
        txt_sexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_sexo.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 210, -1));

        jLabel_fechadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fechadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechadeentrega.setText("Fecha de entrega:");
        getContentPane().add(jLabel_fechadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel_hora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_hora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hora.setText("Hora:");
        getContentPane().add(jLabel_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        txt_hora.setEditable(false);
        txt_hora.setBackground(new java.awt.Color(153, 153, 255));
        txt_hora.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 210, -1));

        jScrollPane1.setViewportView(jTextPane_indicaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 560, 290));

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
        getContentPane().add(jButton_GuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 150, -1));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 210, 26));

        txt_Reporte.setBackground(new java.awt.Color(153, 153, 255));
        txt_Reporte.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Reporte.setForeground(new java.awt.Color(255, 255, 255));
        txt_Reporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Reporte.setText("No");
        txt_Reporte.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 760, 210, -1));

        jLabel_Datos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Datos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Datos.setText("Datos guardados:");
        getContentPane().add(jLabel_Datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 765, -1, -1));

        jButton_ActualizarDatos.setText("Actualizar Datos");
        jButton_ActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ActualizarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 700, 150, -1));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(204, 51, 255));
        jButton_ImprimirReporte.setText("Generar Reporte");
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 695, 150, 30));

        jLabel_ValoresdeResultado.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel_ValoresdeResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ValoresdeResultado.setText("Valores de resultado");
        getContentPane().add(jLabel_ValoresdeResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 40, -1, -1));

        jLabel_Eritrocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Eritrocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Eritrocitos.setText("Eritrocitos:");
        getContentPane().add(jLabel_Eritrocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 115, -1, -1));

        txt_Eritrocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Eritrocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Eritrocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Eritrocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Eritrocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Eritrocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 133, 210, -1));

        jLabel_Hemoglobina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Hemoglobina.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Hemoglobina.setText("Hemoglobina:");
        getContentPane().add(jLabel_Hemoglobina, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 175, -1, -1));

        txt_Hemoglobina.setBackground(new java.awt.Color(153, 153, 255));
        txt_Hemoglobina.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Hemoglobina.setForeground(new java.awt.Color(255, 255, 255));
        txt_Hemoglobina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Hemoglobina.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Hemoglobina, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 193, 210, -1));

        jCheckBox_firma.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jCheckBox_firma.setText("Incluir firma");
        jCheckBox_firma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_firmaActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_firma, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 810, -1, -1));

        jLabel_Fórmularoja.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_Fórmularoja.setForeground(new java.awt.Color(255, 0, 51));
        jLabel_Fórmularoja.setText("Fórmula roja:");
        getContentPane().add(jLabel_Fórmularoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 85, -1, -1));

        jLabel_Hematocrito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Hematocrito.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Hematocrito.setText("Hematocrito:");
        getContentPane().add(jLabel_Hematocrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 235, -1, -1));

        txt_Hematocrito.setBackground(new java.awt.Color(153, 153, 255));
        txt_Hematocrito.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Hematocrito.setForeground(new java.awt.Color(255, 255, 255));
        txt_Hematocrito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Hematocrito.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Hematocrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 253, 210, -1));

        txt_VolumenGlobularMedioVCM.setBackground(new java.awt.Color(153, 153, 255));
        txt_VolumenGlobularMedioVCM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_VolumenGlobularMedioVCM.setForeground(new java.awt.Color(255, 255, 255));
        txt_VolumenGlobularMedioVCM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_VolumenGlobularMedioVCM.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_VolumenGlobularMedioVCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 313, 210, -1));

        txt_ConcentracióMediadeHemoglobinaHCM.setBackground(new java.awt.Color(153, 153, 255));
        txt_ConcentracióMediadeHemoglobinaHCM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ConcentracióMediadeHemoglobinaHCM.setForeground(new java.awt.Color(255, 255, 255));
        txt_ConcentracióMediadeHemoglobinaHCM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ConcentracióMediadeHemoglobinaHCM.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_ConcentracióMediadeHemoglobinaHCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 387, 210, -1));

        jLabel_CHCM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM.setText("Hemoglobina Corpuscular (CHCM):");
        getContentPane().add(jLabel_CHCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 443, -1, -1));

        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBackground(new java.awt.Color(153, 153, 255));
        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setForeground(new java.awt.Color(255, 255, 255));
        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 461, 210, -1));

        jLabel_VolumenGlobular1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_VolumenGlobular1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_VolumenGlobular1.setText("Volumen Globular Medio (VCM):");
        getContentPane().add(jLabel_VolumenGlobular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 295, -1, -1));

        jLabel_ConcentraciónMedia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_ConcentraciónMedia.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ConcentraciónMedia.setText("Concentración Media");
        getContentPane().add(jLabel_ConcentraciónMedia, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 355, -1, -1));

        jLabel_deHemoglobinaHCM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_deHemoglobinaHCM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_deHemoglobinaHCM.setText("de Hemoglobina (HCM):");
        getContentPane().add(jLabel_deHemoglobinaHCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 369, -1, -1));

        jLabel_CHCM1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM1.setText("Concentración Media de");
        getContentPane().add(jLabel_CHCM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 429, -1, -1));

        jLabel_CHCM4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM4.setText("Índice de distribución ");
        getContentPane().add(jLabel_CHCM4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 503, -1, -1));

        jLabel_CHCM5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM5.setText("de eritrocitos (RDW):");
        getContentPane().add(jLabel_CHCM5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 517, -1, -1));

        txt_ÍndicededistribucióndeeritrocitosRDW.setBackground(new java.awt.Color(153, 153, 255));
        txt_ÍndicededistribucióndeeritrocitosRDW.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ÍndicededistribucióndeeritrocitosRDW.setForeground(new java.awt.Color(255, 255, 255));
        txt_ÍndicededistribucióndeeritrocitosRDW.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ÍndicededistribucióndeeritrocitosRDW.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_ÍndicededistribucióndeeritrocitosRDW, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 535, 210, -1));

        jLabel_CHCM6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM6.setText("Plaquetas:");
        getContentPane().add(jLabel_CHCM6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 577, -1, -1));

        txt_Plaquetas.setBackground(new java.awt.Color(153, 153, 255));
        txt_Plaquetas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Plaquetas.setForeground(new java.awt.Color(255, 255, 255));
        txt_Plaquetas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Plaquetas.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Plaquetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 595, 210, -1));

        jLabel_CHCM7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM7.setText("Volumen Plaquetario ");
        getContentPane().add(jLabel_CHCM7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 637, -1, -1));

        jLabel_CHCM8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_CHCM8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CHCM8.setText("Medio (VPM):");
        getContentPane().add(jLabel_CHCM8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 651, -1, -1));

        txt_VolumenPlaquetarioMedioVPM.setBackground(new java.awt.Color(153, 153, 255));
        txt_VolumenPlaquetarioMedioVPM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_VolumenPlaquetarioMedioVPM.setForeground(new java.awt.Color(255, 255, 255));
        txt_VolumenPlaquetarioMedioVPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_VolumenPlaquetarioMedioVPM.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_VolumenPlaquetarioMedioVPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 669, 210, -1));

        jLabel_FórmulaBlanca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel_FórmulaBlanca.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_FórmulaBlanca.setText("Fórmula blanca:");
        getContentPane().add(jLabel_FórmulaBlanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 85, -1, -1));

        jLabel_Leucocitostotales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Leucocitostotales.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Leucocitostotales.setText("Leucocitos totales:");
        getContentPane().add(jLabel_Leucocitostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 115, -1, -1));

        txt_Leucocitostotales.setBackground(new java.awt.Color(153, 153, 255));
        txt_Leucocitostotales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Leucocitostotales.setForeground(new java.awt.Color(255, 255, 255));
        txt_Leucocitostotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Leucocitostotales.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Leucocitostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 133, 210, -1));

        jLabel_Neutrófilostotales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Neutrófilostotales.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Neutrófilostotales.setText("Neutrófilos totales:");
        getContentPane().add(jLabel_Neutrófilostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 175, -1, -1));

        txt_Neutrófilostotales.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilostotales.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilostotales.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilostotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilostotales.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilostotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 193, 210, -1));

        jLabel_Neutrófilossegmentados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Neutrófilossegmentados.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Neutrófilossegmentados.setText("Neutrófilos segmentados:");
        getContentPane().add(jLabel_Neutrófilossegmentados, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 235, -1, -1));

        txt_Neutrófilossegmentados.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilossegmentados.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilossegmentados.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilossegmentados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilossegmentados.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilossegmentados, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 253, 210, -1));

        jLabel_Neutrófilosenbanda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Neutrófilosenbanda.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Neutrófilosenbanda.setText("Neutrófilos en banda:");
        getContentPane().add(jLabel_Neutrófilosenbanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 295, -1, -1));

        txt_Neutrófilosenbanda.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilosenbanda.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilosenbanda.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilosenbanda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilosenbanda.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilosenbanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 313, 210, -1));

        jLabel_Metamielocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Metamielocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Metamielocitos.setText("Metamielocitos:");
        getContentPane().add(jLabel_Metamielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 355, -1, -1));

        txt_Metamielocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Metamielocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Metamielocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Metamielocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Metamielocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Metamielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 373, 210, -1));

        jLabel_Mielocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Mielocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mielocitos.setText("Mielocitos:");
        getContentPane().add(jLabel_Mielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 415, -1, -1));

        txt_Mielocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Mielocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Mielocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Mielocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Mielocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Mielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 433, 210, -1));

        jLabel_Promielocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Promielocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Promielocitos.setText("Promielocitos:");
        getContentPane().add(jLabel_Promielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 475, -1, -1));

        txt_Promielocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Promielocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Promielocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Promielocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Promielocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Promielocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 493, 210, -1));

        jLabel_Blastos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Blastos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Blastos.setText("Blastos:");
        getContentPane().add(jLabel_Blastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 535, -1, -1));

        txt_Blastos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Blastos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Blastos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Blastos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Blastos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Blastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 553, 210, -1));

        jLabel_Eosinófilos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Eosinófilos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Eosinófilos.setText("Eosinófilos:");
        getContentPane().add(jLabel_Eosinófilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 595, -1, -1));

        txt_Eosinófilos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Eosinófilos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Eosinófilos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Eosinófilos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Eosinófilos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Eosinófilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 613, 210, -1));

        jLabel_Basófilos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Basófilos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Basófilos.setText("Basófilos:");
        getContentPane().add(jLabel_Basófilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 655, -1, -1));

        txt_Basófilos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Basófilos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Basófilos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Basófilos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Basófilos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Basófilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 673, 210, -1));

        jLabel_Monocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Monocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Monocitos.setText("Monocitos:");
        getContentPane().add(jLabel_Monocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 715, -1, -1));

        txt_Monocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Monocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Monocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Monocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Monocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Monocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 733, 210, -1));

        jLabel_Linfocitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Linfocitos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Linfocitos.setText("Linfocitos:");
        getContentPane().add(jLabel_Linfocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 775, -1, -1));

        txt_Linfocitos.setBackground(new java.awt.Color(153, 153, 255));
        txt_Linfocitos.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Linfocitos.setForeground(new java.awt.Color(255, 255, 255));
        txt_Linfocitos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Linfocitos.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Linfocitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 793, 210, -1));

        txt_Neutrófilostotales1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilostotales1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilostotales1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilostotales1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilostotales1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilostotales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 193, 210, -1));

        txt_Neutrófilossegmentados1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilossegmentados1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilossegmentados1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilossegmentados1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilossegmentados1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilossegmentados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 253, 210, -1));

        txt_Neutrófilosenbanda1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Neutrófilosenbanda1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Neutrófilosenbanda1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Neutrófilosenbanda1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Neutrófilosenbanda1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Neutrófilosenbanda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 313, 210, -1));

        txt_Metamielocitos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Metamielocitos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Metamielocitos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Metamielocitos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Metamielocitos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Metamielocitos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 373, 210, -1));

        txt_Mielocitos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Mielocitos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Mielocitos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Mielocitos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Mielocitos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Mielocitos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 433, 210, -1));

        txt_Promielocitos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Promielocitos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Promielocitos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Promielocitos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Promielocitos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Promielocitos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 493, 210, -1));

        txt_Blastos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Blastos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Blastos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Blastos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Blastos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Blastos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 553, 210, -1));

        txt_Eosinófilos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Eosinófilos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Eosinófilos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Eosinófilos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Eosinófilos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Eosinófilos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 613, 210, -1));

        txt_Basófilos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Basófilos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Basófilos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Basófilos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Basófilos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Basófilos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 673, 210, -1));

        txt_Monocitos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Monocitos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Monocitos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Monocitos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Monocitos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Monocitos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 733, 210, -1));

        txt_Linfocitos1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Linfocitos1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Linfocitos1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Linfocitos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Linfocitos1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Linfocitos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 793, 210, -1));

        jLabel_guion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion.setText("-");
        getContentPane().add(jLabel_guion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 193, -1, -1));

        jLabel_guion1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion1.setText("-");
        getContentPane().add(jLabel_guion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 253, -1, -1));

        jLabel_guion2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion2.setText("-");
        getContentPane().add(jLabel_guion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 312, -1, -1));

        jLabel_guion3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion3.setText("-");
        getContentPane().add(jLabel_guion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 373, -1, -1));

        jLabel_guion4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion4.setText("-");
        getContentPane().add(jLabel_guion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 433, -1, -1));

        jLabel_guion5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion5.setText("-");
        getContentPane().add(jLabel_guion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 493, -1, -1));

        jLabel_guion6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion6.setText("-");
        getContentPane().add(jLabel_guion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 553, -1, -1));

        jLabel_guion7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion7.setText("-");
        getContentPane().add(jLabel_guion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 613, -1, -1));

        jLabel_guion8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion8.setText("-");
        getContentPane().add(jLabel_guion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 673, -1, -1));

        jLabel_guion9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion9.setText("-");
        getContentPane().add(jLabel_guion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 733, -1, -1));

        jLabel_guion10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion10.setText("-");
        getContentPane().add(jLabel_guion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 793, -1, -1));

        txt_Leucocitostotales1.setBackground(new java.awt.Color(153, 153, 255));
        txt_Leucocitostotales1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Leucocitostotales1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Leucocitostotales1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Leucocitostotales1.setBorder(new javax.swing.border.SoftBevelBorder(0));
        getContentPane().add(txt_Leucocitostotales1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 133, 210, -1));

        jLabel_guion11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_guion11.setText("-");
        getContentPane().add(jLabel_guion11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 130, -1, -1));

        jLabel_UL.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_UL.setText("/uL");
        getContentPane().add(jLabel_UL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 135, -1, -1));

        jLabel_UL1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_UL1.setText("/uL");
        getContentPane().add(jLabel_UL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 135, -1, -1));

        jLabel_porcentaje.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje.setText("%");
        getContentPane().add(jLabel_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 195, -1, -1));

        jLabel_porcentaje1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje1.setText("%");
        getContentPane().add(jLabel_porcentaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 255, -1, -1));

        jLabel_porcentaje2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje2.setText("%");
        getContentPane().add(jLabel_porcentaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 315, -1, -1));

        jLabel_porcentaje3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje3.setText("%");
        getContentPane().add(jLabel_porcentaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 375, -1, -1));

        jLabel_porcentaje4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje4.setText("%");
        getContentPane().add(jLabel_porcentaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 435, -1, -1));

        jLabel_porcentaje5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje5.setText("%");
        getContentPane().add(jLabel_porcentaje5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 495, -1, -1));

        jLabel_porcentaje6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje6.setText("%");
        getContentPane().add(jLabel_porcentaje6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 555, -1, -1));

        jLabel_porcentaje7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje7.setText("%");
        getContentPane().add(jLabel_porcentaje7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 615, -1, -1));

        jLabel_porcentaje8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje8.setText("%");
        getContentPane().add(jLabel_porcentaje8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 675, -1, -1));

        jLabel_porcentaje9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje9.setText("%");
        getContentPane().add(jLabel_porcentaje9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 735, -1, -1));

        jLabel_porcentaje10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_porcentaje10.setText("%");
        getContentPane().add(jLabel_porcentaje10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 795, -1, -1));

        jLabel_uL2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL2.setText("/uL");
        getContentPane().add(jLabel_uL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 195, -1, -1));

        jLabel_uL3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL3.setText("/uL");
        getContentPane().add(jLabel_uL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 255, -1, -1));

        jLabel_uL4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL4.setText("/uL");
        getContentPane().add(jLabel_uL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 315, -1, -1));

        jLabel_uL5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL5.setText("/uL");
        getContentPane().add(jLabel_uL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 375, -1, -1));

        jLabel_uL6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL6.setText("/uL");
        getContentPane().add(jLabel_uL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 435, -1, -1));

        jLabel_uL7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL7.setText("/uL");
        getContentPane().add(jLabel_uL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 495, -1, -1));

        jLabel_uL8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL8.setText("/uL");
        getContentPane().add(jLabel_uL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 555, -1, -1));

        jLabel_uL9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL9.setText("/uL");
        getContentPane().add(jLabel_uL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 615, -1, -1));

        jLabel_uL10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL10.setText("/uL");
        getContentPane().add(jLabel_uL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 675, -1, -1));

        jLabel_uL11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL11.setText("/uL");
        getContentPane().add(jLabel_uL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 735, -1, -1));

        jLabel_uL12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel_uL12.setText("/uL");
        getContentPane().add(jLabel_uL12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1375, 795, -1, -1));

        jButton_CalcularValores.setBackground(new java.awt.Color(255, 255, 51));
        jButton_CalcularValores.setText("Calcular Valores");
        jButton_CalcularValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CalcularValoresActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_CalcularValores, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 720, 210, -1));

        jLabel_Wallpaper2.setBackground(new java.awt.Color(204, 204, 0));
        jLabel_Wallpaper2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel_Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Paper.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 830, 840));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 930));

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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, Eritrocitos, Hemoglobina, Hematocrito,
             VolumenGlobularMedioVCM, ConcentracióMediadeHemoglobinaHCM, ConcentraciónMediadeHemoglobinaCorpuscularCHCM, ÍndicededistribucióndeeritrocitosRDW, 
              Plaquetas, VolumenPlaquetarioMedioVPM, Leucocitostotales, Leucocitostotales1 , Neutrófilostotales, Neutrófilostotales1,Neutrófilossegmentados, Neutrófilossegmentados1, 
              Neutrófilosenbanda, Neutrófilosenbanda1, Metamielocitos, Metamielocitos1, Mielocitos, Mielocitos1, Promielocitos, Promielocitos1, Blastos, Blastos1, Eosinófilos, Eosinófilos1,
              Basófilos, Basófilos1, Monocitos, Monocitos1, Linfocitos, Linfocitos1, Reporte_generado1; 
      
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
      Eritrocitos = txt_Eritrocitos.getText().trim();
      Hemoglobina = txt_Hemoglobina.getText().trim();
      Hematocrito = txt_Hematocrito.getText().trim();
      VolumenGlobularMedioVCM = txt_VolumenGlobularMedioVCM.getText().trim();
      ConcentracióMediadeHemoglobinaHCM = txt_ConcentracióMediadeHemoglobinaHCM.getText().trim();
      ConcentraciónMediadeHemoglobinaCorpuscularCHCM = txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().trim();
      ÍndicededistribucióndeeritrocitosRDW = txt_ÍndicededistribucióndeeritrocitosRDW.getText().trim();
      Plaquetas = txt_Plaquetas.getText().trim();
      VolumenPlaquetarioMedioVPM = txt_VolumenPlaquetarioMedioVPM.getText().trim();
      Leucocitostotales = txt_Leucocitostotales.getText().trim();
      Leucocitostotales1 = txt_Leucocitostotales1.getText().trim();
      Neutrófilostotales = txt_Neutrófilostotales.getText().trim();
      Neutrófilostotales1 = txt_Neutrófilostotales1.getText().trim();
      Neutrófilossegmentados = txt_Neutrófilossegmentados.getText().trim();
      Neutrófilossegmentados1 = txt_Neutrófilossegmentados1.getText().trim();
      Neutrófilosenbanda = txt_Neutrófilosenbanda.getText().trim();
      Neutrófilosenbanda1 = txt_Neutrófilosenbanda1.getText().trim();
      Metamielocitos = txt_Metamielocitos.getText().trim();
      Metamielocitos1 = txt_Metamielocitos1.getText().trim();
      Mielocitos = txt_Mielocitos.getText().trim();
      Mielocitos1 = txt_Mielocitos1.getText().trim();
      Promielocitos = txt_Promielocitos.getText().trim();
      Promielocitos1 = txt_Promielocitos1.getText().trim();
      Blastos = txt_Blastos.getText().trim();
      Blastos1 = txt_Blastos1.getText().trim();
      Eosinófilos = txt_Eosinófilos.getText().trim();
      Eosinófilos1 = txt_Eosinófilos1.getText().trim();
      Basófilos = txt_Basófilos.getText().trim();
      Basófilos1 = txt_Basófilos1.getText().trim();
      Monocitos = txt_Monocitos.getText().trim();
      Monocitos1 = txt_Monocitos1.getText().trim();
      Linfocitos = txt_Linfocitos.getText().trim();
      Linfocitos1 = txt_Linfocitos1.getText().trim();
      
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
       if(Eritrocitos.equals("")) {
           txt_Eritrocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Hemoglobina.equals("")) {
           txt_Hemoglobina.setBackground(Color.red);
           validacion++;     
       }
       if(Hematocrito.equals("")) {
           txt_Hematocrito.setBackground(Color.red);
           validacion++;     
       }
       if(VolumenGlobularMedioVCM.equals("")) {
           txt_VolumenGlobularMedioVCM.setBackground(Color.red);
           validacion++;     
       }
       if(ConcentracióMediadeHemoglobinaHCM.equals("")) {
           txt_ConcentracióMediadeHemoglobinaHCM.setBackground(Color.red);
           validacion++;     
       }
       if(ConcentraciónMediadeHemoglobinaCorpuscularCHCM.equals("")) {
           txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBackground(Color.red);
           validacion++;     
       }
       if(ÍndicededistribucióndeeritrocitosRDW.equals("")) {
           txt_ÍndicededistribucióndeeritrocitosRDW.setBackground(Color.red);
           validacion++;     
       }
       if(Plaquetas.equals("")) {
           txt_Plaquetas.setBackground(Color.red);
           validacion++;     
       }
       if(VolumenPlaquetarioMedioVPM.equals("")) {
           txt_VolumenPlaquetarioMedioVPM.setBackground(Color.red);
           validacion++;     
       } 
       if(Leucocitostotales.equals("")) {
           txt_Leucocitostotales.setBackground(Color.red);
           validacion++;     
       }
       if(Leucocitostotales1.equals("")) {
           txt_Leucocitostotales1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilostotales.equals("")) {
           txt_Neutrófilostotales.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilostotales1.equals("")) {
           txt_Neutrófilostotales1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilossegmentados.equals("")) {
           txt_Neutrófilossegmentados.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilossegmentados1.equals("")) {
           txt_Neutrófilossegmentados1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilosenbanda.equals("")) {
           txt_Neutrófilosenbanda.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilosenbanda1.equals("")) {
           txt_Neutrófilosenbanda1.setBackground(Color.red);
           validacion++;     
       }
       if(Metamielocitos.equals("")) {
           txt_Metamielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Metamielocitos1.equals("")) {
           txt_Metamielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Mielocitos.equals("")) {
           txt_Mielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Mielocitos1.equals("")) {
           txt_Mielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Promielocitos.equals("")) {
           txt_Promielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Promielocitos1.equals("")) {
           txt_Promielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Blastos.equals("")) {
           txt_Blastos.setBackground(Color.red);
           validacion++;     
       }
       if(Blastos1.equals("")) {
           txt_Blastos1.setBackground(Color.red);
           validacion++;     
       }
       if(Eosinófilos.equals("")) {
           txt_Eosinófilos.setBackground(Color.red);
           validacion++;     
       }
       if(Eosinófilos1.equals("")) {
           txt_Eosinófilos1.setBackground(Color.red);
           validacion++;     
       }
       if(Basófilos.equals("")) {
           txt_Basófilos.setBackground(Color.red);
           validacion++;     
       }
       if(Basófilos1.equals("")) {
           txt_Basófilos1.setBackground(Color.red);
           validacion++;     
       }
       if(Monocitos.equals("")) {
           txt_Monocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Monocitos1.equals("")) {
           txt_Monocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Linfocitos.equals("")) {
           txt_Linfocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Linfocitos1.equals("")) {
           txt_Linfocitos1.setBackground(Color.red);
           validacion++;     
       }
       
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "insert into BH6a10años values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
             
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
             pst.setString(13, Eritrocitos);
             pst.setString(14, Hemoglobina);
             pst.setString(15, Hematocrito);
             pst.setString(16, VolumenGlobularMedioVCM);
             pst.setString(17, ConcentracióMediadeHemoglobinaHCM);
             pst.setString(18, ConcentraciónMediadeHemoglobinaCorpuscularCHCM);
             pst.setString(19, ÍndicededistribucióndeeritrocitosRDW);
             pst.setString(20, Plaquetas);
             pst.setString(21, VolumenPlaquetarioMedioVPM);
             pst.setString(22, Leucocitostotales);
             pst.setString(23, Leucocitostotales1);
             pst.setString(24, Neutrófilostotales);
             pst.setString(25, Neutrófilostotales1);
             pst.setString(26, Neutrófilossegmentados);
             pst.setString(27, Neutrófilossegmentados1);
             pst.setString(28, Neutrófilosenbanda);
             pst.setString(29, Neutrófilosenbanda1);
             pst.setString(30, Metamielocitos);
             pst.setString(31, Metamielocitos1);
             pst.setString(32, Mielocitos);
             pst.setString(33, Mielocitos1);
             pst.setString(34, Promielocitos);
             pst.setString(35, Promielocitos1);
             pst.setString(36, Blastos);
             pst.setString(37, Blastos1);
             pst.setString(38, Eosinófilos);
             pst.setString(39, Eosinófilos1);
             pst.setString(40, Basófilos);
             pst.setString(41, Basófilos1);
             pst.setString(42, Monocitos);
             pst.setString(43, Monocitos1);
             pst.setString(44, Linfocitos);
             pst.setString(45, Linfocitos1);
             pst.setString(46, user);
             pst.setString(47, Reporte_generado1);
          
             
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
             txt_Eritrocitos.setBackground(Color.green);
             txt_Hemoglobina.setBackground(Color.green);
             txt_Hematocrito.setBackground(Color.green);
             txt_VolumenGlobularMedioVCM.setBackground(Color.green);
             txt_ConcentracióMediadeHemoglobinaHCM.setBackground(Color.green);
             txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBackground(Color.green);
             txt_ÍndicededistribucióndeeritrocitosRDW.setBackground(Color.green);
             txt_Plaquetas.setBackground(Color.green);
             txt_VolumenPlaquetarioMedioVPM.setBackground(Color.green);
             txt_Leucocitostotales.setBackground(Color.green);
             txt_Leucocitostotales1.setBackground(Color.green);
             txt_Neutrófilostotales.setBackground(Color.green);
             txt_Neutrófilostotales1.setBackground(Color.green);
             txt_Neutrófilossegmentados.setBackground(Color.green);
             txt_Neutrófilossegmentados1.setBackground(Color.green);
             txt_Neutrófilosenbanda.setBackground(Color.green);
             txt_Neutrófilosenbanda1.setBackground(Color.green);
             txt_Metamielocitos.setBackground(Color.green);
             txt_Metamielocitos1.setBackground(Color.green);
             txt_Mielocitos.setBackground(Color.green);
             txt_Mielocitos1.setBackground(Color.green);     
             txt_Promielocitos.setBackground(Color.green);
             txt_Promielocitos1.setBackground(Color.green);
             txt_Blastos.setBackground(Color.green);
             txt_Blastos1.setBackground(Color.green);
             txt_Eosinófilos.setBackground(Color.green);
             txt_Eosinófilos1.setBackground(Color.green);
             txt_Basófilos.setBackground(Color.green);
             txt_Basófilos1.setBackground(Color.green);
             txt_Monocitos.setBackground(Color.green);
             txt_Monocitos1.setBackground(Color.green);
             txt_Linfocitos.setBackground(Color.green);
             txt_Linfocitos1.setBackground(Color.green);
             
             JOptionPane.showMessageDialog(null, "Registro exitoso.");
          
             
         } catch (SQLException e) {
             System.out.println("Error en registrar datos del estudio." + e);
             JOptionPane.showMessageDialog(null, "ERROR al registrar datos del estudio!!, contacte al programador.");
         } 
           
         try {
          Connection cn2 = Conexion.conectar();
          PreparedStatement pst2 = cn2.prepareStatement(
                  "select * from BH6a10años where ID_estudio = '" + IEstudio + "'");
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
       
      String NoFolio, ClaveE, empresa, nombre, apellido, edad, sexo, nombremedico, fechaEntrega, hora, horaF1, observaciones, Eritrocitos, Hemoglobina, Hematocrito,
             VolumenGlobularMedioVCM, ConcentracióMediadeHemoglobinaHCM, ConcentraciónMediadeHemoglobinaCorpuscularCHCM, ÍndicededistribucióndeeritrocitosRDW, 
              Plaquetas, VolumenPlaquetarioMedioVPM, Leucocitostotales, Leucocitostotales1 , Neutrófilostotales, Neutrófilostotales1,Neutrófilossegmentados, Neutrófilossegmentados1, 
              Neutrófilosenbanda, Neutrófilosenbanda1, Metamielocitos, Metamielocitos1, Mielocitos, Mielocitos1, Promielocitos, Promielocitos1, Blastos, Blastos1, Eosinófilos, Eosinófilos1,
              Basófilos, Basófilos1, Monocitos, Monocitos1, Linfocitos, Linfocitos1 ,Reporte_generado1; 
      
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
      Eritrocitos = txt_Eritrocitos.getText().trim();
      Hemoglobina = txt_Hemoglobina.getText().trim();
      Hematocrito = txt_Hematocrito.getText().trim();
      VolumenGlobularMedioVCM = txt_VolumenGlobularMedioVCM.getText().trim();
      ConcentracióMediadeHemoglobinaHCM = txt_ConcentracióMediadeHemoglobinaHCM.getText().trim();
      ConcentraciónMediadeHemoglobinaCorpuscularCHCM = txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().trim();
      ÍndicededistribucióndeeritrocitosRDW = txt_ÍndicededistribucióndeeritrocitosRDW.getText().trim();
      Plaquetas = txt_Plaquetas.getText().trim();
      VolumenPlaquetarioMedioVPM = txt_VolumenPlaquetarioMedioVPM.getText().trim();
      Leucocitostotales = txt_Leucocitostotales.getText().trim();
      Leucocitostotales1 = txt_Leucocitostotales1.getText().trim();
      Neutrófilostotales = txt_Neutrófilostotales.getText().trim();
      Neutrófilostotales1 = txt_Neutrófilostotales1.getText().trim();
      Neutrófilossegmentados = txt_Neutrófilossegmentados.getText().trim();
      Neutrófilossegmentados1 = txt_Neutrófilossegmentados1.getText().trim();
      Neutrófilosenbanda = txt_Neutrófilosenbanda.getText().trim();
      Neutrófilosenbanda1 = txt_Neutrófilosenbanda1.getText().trim();
      Metamielocitos = txt_Metamielocitos.getText().trim();
      Metamielocitos1 = txt_Metamielocitos1.getText().trim();
      Mielocitos = txt_Mielocitos.getText().trim();
      Mielocitos1 = txt_Mielocitos1.getText().trim();
      Promielocitos = txt_Promielocitos.getText().trim();
      Promielocitos1 = txt_Promielocitos1.getText().trim();
      Blastos = txt_Blastos.getText().trim();
      Blastos1 = txt_Blastos1.getText().trim();
      Eosinófilos = txt_Eosinófilos.getText().trim();
      Eosinófilos1 = txt_Eosinófilos1.getText().trim();
      Basófilos = txt_Basófilos.getText().trim();
      Basófilos1 = txt_Basófilos1.getText().trim();
      Monocitos = txt_Monocitos.getText().trim();
      Monocitos1 = txt_Monocitos1.getText().trim();
      Linfocitos = txt_Linfocitos.getText().trim();
      Linfocitos1 = txt_Linfocitos1.getText().trim();
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
           jTextPane_indicaciones.setBackground(Color.red);
           validacion++;     
       }
       if(Eritrocitos.equals("")) {
           txt_Eritrocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Hemoglobina.equals("")) {
           txt_Hemoglobina.setBackground(Color.red);
           validacion++;     
       }
       if(Hematocrito.equals("")) {
           txt_Hematocrito.setBackground(Color.red);
           validacion++;     
       }
       if(VolumenGlobularMedioVCM.equals("")) {
           txt_VolumenGlobularMedioVCM.setBackground(Color.red);
           validacion++;     
       }
       if(ConcentracióMediadeHemoglobinaHCM.equals("")) {
           txt_ConcentracióMediadeHemoglobinaHCM.setBackground(Color.red);
           validacion++;     
       }
       if(ConcentraciónMediadeHemoglobinaCorpuscularCHCM.equals("")) {
           txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBackground(Color.red);
           validacion++;     
       }
       if(ÍndicededistribucióndeeritrocitosRDW.equals("")) {
           txt_ÍndicededistribucióndeeritrocitosRDW.setBackground(Color.red);
           validacion++;     
       }
       if(Plaquetas.equals("")) {
           txt_Plaquetas.setBackground(Color.red);
           validacion++;     
       }
       if(VolumenPlaquetarioMedioVPM.equals("")) {
           txt_VolumenPlaquetarioMedioVPM.setBackground(Color.red);
           validacion++;     
       } 
       if(Leucocitostotales.equals("")) {
           txt_Leucocitostotales.setBackground(Color.red);
           validacion++;     
       }
       if(Leucocitostotales1.equals("")) {
           txt_Leucocitostotales1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilostotales.equals("")) {
           txt_Neutrófilostotales.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilostotales1.equals("")) {
           txt_Neutrófilostotales1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilossegmentados.equals("")) {
           txt_Neutrófilossegmentados.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilossegmentados1.equals("")) {
           txt_Neutrófilossegmentados1.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilosenbanda.equals("")) {
           txt_Neutrófilosenbanda.setBackground(Color.red);
           validacion++;     
       }
       if(Neutrófilosenbanda1.equals("")) {
           txt_Neutrófilosenbanda1.setBackground(Color.red);
           validacion++;     
       }
       if(Metamielocitos.equals("")) {
           txt_Metamielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Metamielocitos1.equals("")) {
           txt_Metamielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Mielocitos.equals("")) {
           txt_Mielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Mielocitos1.equals("")) {
           txt_Mielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Promielocitos.equals("")) {
           txt_Promielocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Promielocitos1.equals("")) {
           txt_Promielocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Blastos.equals("")) {
           txt_Blastos.setBackground(Color.red);
           validacion++;     
       }
       if(Blastos1.equals("")) {
           txt_Blastos1.setBackground(Color.red);
           validacion++;     
       }
       if(Eosinófilos.equals("")) {
           txt_Eosinófilos.setBackground(Color.red);
           validacion++;     
       }
       if(Eosinófilos1.equals("")) {
           txt_Eosinófilos1.setBackground(Color.red);
           validacion++;     
       }
       if(Basófilos.equals("")) {
           txt_Basófilos.setBackground(Color.red);
           validacion++;     
       }
       if(Basófilos1.equals("")) {
           txt_Basófilos1.setBackground(Color.red);
           validacion++;     
       }
       if(Monocitos.equals("")) {
           txt_Monocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Monocitos1.equals("")) {
           txt_Monocitos1.setBackground(Color.red);
           validacion++;     
       }
       if(Linfocitos.equals("")) {
           txt_Linfocitos.setBackground(Color.red);
           validacion++;     
       }
       if(Linfocitos1.equals("")) {
           txt_Linfocitos1.setBackground(Color.red);
           validacion++;     
       }
           
       try {
            
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(
                     "update BH6a10años set Fecha_entrega=?, Hora=?, Observaciones=?, Eritrocitos=?, Hemoglobina=?, Hematocrito=?, VolumenGlobularMedioVCM=?, ConcentraciónMediadeHemoglobinaHCM=?, ConcentraciónMediadeHemoglobinaCorpuscularCHCM=?, ÍndicededistribucióndeeritrocitosRDW=?, Plaquetas=?, VolumenPlaquetarioMedioVPM=?, Leucocitostotales=?, Leucocitostotales1=?, Neutrófilostotales=?,Neutrófilostotales1=?, Neutrófilossegmentados=?, Neutrófilossegmentados1=?, Neutrófilosenbanda=?, Neutrófilosenbanda1=?,Metamielocitos=?, Metamielocitos1=?, Mielocitos=?, Mielocitos1=?, Promielocitos=?, Promielocitos1=?, Blastos=?, Blastos1=?, Eosinófilos=?, Eosinófilos1=?, Basófilos=?, Basófilos1=?, Monocitos=?, Monocitos1=?, Linfocitos=?, Linfocitos1=?, ultima_modificacion=?"
                     
                   + "where ID_estudio = '" + IEstudio + "'");
             
         
             pst.setString(1, fechaEntrega);
             pst.setString(2, hora);
             pst.setString(3, observaciones);
             pst.setString(4, Eritrocitos);
             pst.setString(5, Hemoglobina);
             pst.setString(6, Hematocrito);
             pst.setString(7, VolumenGlobularMedioVCM);
             pst.setString(8, ConcentracióMediadeHemoglobinaHCM);
             pst.setString(9, ConcentraciónMediadeHemoglobinaCorpuscularCHCM);
             pst.setString(10, ÍndicededistribucióndeeritrocitosRDW);
             pst.setString(11, Plaquetas);
             pst.setString(12, VolumenPlaquetarioMedioVPM);
             pst.setString(13, Leucocitostotales);
             pst.setString(14, Leucocitostotales1);
             pst.setString(15, Neutrófilostotales);
             pst.setString(16, Neutrófilostotales1);
             pst.setString(17, Neutrófilossegmentados);
             pst.setString(18, Neutrófilossegmentados1);
             pst.setString(19, Neutrófilosenbanda);
             pst.setString(20, Neutrófilosenbanda1);
             pst.setString(21, Metamielocitos);
             pst.setString(22, Metamielocitos1);
             pst.setString(23, Mielocitos);
             pst.setString(24, Mielocitos1);
             pst.setString(25, Promielocitos);
             pst.setString(26, Promielocitos1);
             pst.setString(27, Blastos);
             pst.setString(28, Blastos1);
             pst.setString(29, Eosinófilos);
             pst.setString(30, Eosinófilos1);
             pst.setString(31, Basófilos);
             pst.setString(32, Basófilos1);
             pst.setString(33, Monocitos);
             pst.setString(34, Monocitos1);
             pst.setString(35, Linfocitos);
             pst.setString(36, Linfocitos1);
             pst.setString(37, user);
    
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
             txt_Eritrocitos.setBackground(Color.green);
             txt_Hemoglobina.setBackground(Color.green);
             txt_Hematocrito.setBackground(Color.green);
             txt_VolumenGlobularMedioVCM.setBackground(Color.green);
             txt_ConcentracióMediadeHemoglobinaHCM.setBackground(Color.green);
             txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.setBackground(Color.green);
             txt_ÍndicededistribucióndeeritrocitosRDW.setBackground(Color.green);
             txt_Plaquetas.setBackground(Color.green);
             txt_VolumenPlaquetarioMedioVPM.setBackground(Color.green);
             txt_Leucocitostotales.setBackground(Color.green);
             txt_Leucocitostotales1.setBackground(Color.green);
             txt_Neutrófilostotales.setBackground(Color.green);
             txt_Neutrófilostotales1.setBackground(Color.green);
             txt_Neutrófilossegmentados.setBackground(Color.green);
             txt_Neutrófilossegmentados1.setBackground(Color.green);
             txt_Neutrófilosenbanda.setBackground(Color.green);
             txt_Neutrófilosenbanda1.setBackground(Color.green);
             txt_Metamielocitos.setBackground(Color.green);
             txt_Metamielocitos1.setBackground(Color.green);
             txt_Mielocitos.setBackground(Color.green);
             txt_Mielocitos1.setBackground(Color.green);     
             txt_Promielocitos.setBackground(Color.green);
             txt_Promielocitos1.setBackground(Color.green);
             txt_Blastos.setBackground(Color.green);
             txt_Blastos1.setBackground(Color.green);
             txt_Eosinófilos.setBackground(Color.green);
             txt_Eosinófilos1.setBackground(Color.green);
             txt_Basófilos.setBackground(Color.green);
             txt_Basófilos1.setBackground(Color.green);
             txt_Monocitos.setBackground(Color.green);
             txt_Monocitos1.setBackground(Color.green);
             txt_Linfocitos.setBackground(Color.green);
             txt_Linfocitos1.setBackground(Color.green);
             
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
                     "update BH6a10años set Hora=?, ultima_modificacion=?"
                     
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
        resultado.setIndentationLeft(340);
        resultado.setSpacingAfter(-3);
        documento.add(resultado);
        
        Paragraph valores = new  Paragraph ("Valores de referencia" , FontFactory.getFont("arial", 10, Font.BOLD , BaseColor.BLACK));
        valores.setSpacingBefore(-12);
        valores.setIndentationLeft(425);
        valores.setSpacingAfter(-3);
        documento.add(valores);
        
        Chunk chunk2 = new Chunk("Biometría Hemática", FontFactory.getFont("arial", 10,Font.BOLD, BaseColor.BLACK));
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
      
        Paragraph Fórmularoja = new  Paragraph ("Fórmula roja:" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Fórmularoja.setSpacingBefore(10);
        Fórmularoja.setIndentationLeft(17);
        Fórmularoja.setSpacingAfter(-3);
        documento.add(Fórmularoja);

        double EritrocitosRe, HemoglobinaRe, HematocritoRe, VolumenGlobularMedioVCMRe, ConcentracióMediadeHemoglobinaHCMRe,
            ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe, ÍndicededistribucióndeeritrocitosRDWRe, PlaquetasRe,
            VolumenPlaquetarioMedioVPMRe; 
        
        EritrocitosRe = Double.parseDouble(txt_Eritrocitos.getText());
        HemoglobinaRe = Double.parseDouble(txt_Hemoglobina.getText());
        HematocritoRe = Double.parseDouble(txt_Hematocrito.getText());
        VolumenGlobularMedioVCMRe = Double.parseDouble(txt_VolumenGlobularMedioVCM.getText());
        ConcentracióMediadeHemoglobinaHCMRe = Double.parseDouble(txt_ConcentracióMediadeHemoglobinaHCM.getText());
        ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe = Double.parseDouble(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText());
        ÍndicededistribucióndeeritrocitosRDWRe = Double.parseDouble(txt_ÍndicededistribucióndeeritrocitosRDW.getText());
        PlaquetasRe = Double.parseDouble(txt_Plaquetas.getText());
        VolumenPlaquetarioMedioVPMRe = Double.parseDouble(txt_VolumenPlaquetarioMedioVPM.getText());
        
         Paragraph elevado6 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK));
        elevado6.setSpacingBefore((float) 4);
        elevado6.setIndentationLeft((float) 393.5);
        elevado6.setSpacingAfter(0);
        
        if(EritrocitosRe<4.3){
        documento.add(elevado6);
        }
             
        Paragraph elevado6_1 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.NORMAL, BaseColor.BLACK));
        elevado6_1.setSpacingBefore((float) 4);
        elevado6_1.setIndentationLeft((float) 393.5);
        elevado6_1.setSpacingAfter(0);
   
        if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(elevado6_1);
        } 
          
        Paragraph elevado6_2 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK));
        elevado6_2.setSpacingBefore((float) 4);
        elevado6_2.setIndentationLeft((float) 393.5);
        elevado6_2.setSpacingAfter(0);
   
        if(EritrocitosRe>5.2){
        documento.add(elevado6_2);
        } 
          
        Paragraph copias11 = new  Paragraph ("Eritrocitos" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias11.setSpacingBefore(-11);
        copias11.setIndentationLeft(17);
        copias11.setSpacingAfter(-3);
        
        if(EritrocitosRe<4.3){
        documento.add(copias11);
        }
             
        Paragraph copias12 = new  Paragraph ("Eritrocitos" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copias12.setSpacingBefore(-11);
        copias12.setIndentationLeft(17);
        copias12.setSpacingAfter(-3);
   
          if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(copias12);
        } 
          
        Paragraph copias13 = new  Paragraph ("Eritrocitos" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias13.setSpacingBefore(-11);
        copias13.setIndentationLeft(17);
        copias13.setSpacingAfter(-3);
   
          if(EritrocitosRe>5.2){
        documento.add(copias13);
        } 
        
        //Resultado de Eritrocitos
        Paragraph copiasR0DD = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasR0DD.setSpacingBefore((float) -12.5);
        copiasR0DD.setSpacingAfter(-3);
        if(txt_Eritrocitos.getText().contains(".") && EritrocitosRe>=0 && EritrocitosRe<4.3){
        copiasR0DD.setIndentationLeft((float) 326);
        documento.add(copiasR0DD);
        } else {
        if(EritrocitosRe>=0 && EritrocitosRe<=4) {  
        copiasR0DD.setIndentationLeft((float) 330);
        documento.add(copiasR0DD);
          }
        }
        
        Paragraph copiasR1D = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copiasR1D.setSpacingBefore((float) -12.5);
        copiasR1D.setSpacingAfter(-3);
        if(txt_Eritrocitos.getText().contains(".") && EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        copiasR1D.setIndentationLeft((float) 326);
        documento.add(copiasR1D);
        } else {
        if(EritrocitosRe==5) {  
        copiasR1D.setIndentationLeft((float) 330);
        documento.add(copiasR1D);
          }
        }
        
        Paragraph copiasR2D = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasR2D.setSpacingBefore((float) -12.5);
        copiasR2D.setSpacingAfter(-3);
        if(txt_Eritrocitos.getText().contains(".") && EritrocitosRe>5.2 && EritrocitosRe<10){
        copiasR2D.setIndentationLeft((float) 326);
        documento.add(copiasR2D);
        } else {
        if(EritrocitosRe>=6 && EritrocitosRe<=9) {  
        copiasR2D.setIndentationLeft((float) 330);
        documento.add(copiasR2D);
          }
        }
        
        Paragraph copiasR3D = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasR3D.setSpacingBefore((float) -12.5);
        copiasR3D.setSpacingAfter(-3);
        if(txt_Eritrocitos.getText().contains(".") && EritrocitosRe>10 && EritrocitosRe<100){
        copiasR3D.setIndentationLeft((float) 324);
        documento.add(copiasR3D);
        } else {
        if(EritrocitosRe>=10 && EritrocitosRe<=99) {  
        copiasR3D.setIndentationLeft((float) 327);
        documento.add(copiasR3D);
          }
        }
        
        Paragraph copiasR4D = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasR4D.setSpacingBefore((float) -12.5);
        copiasR4D.setSpacingAfter(-3);
        
        if(txt_Eritrocitos.getText().contains(".") && EritrocitosRe>100 && EritrocitosRe<1000){
        copiasR4D.setIndentationLeft((float) 323);
        documento.add(copiasR4D);
        } else {
        if(EritrocitosRe>=100 && EritrocitosRe<=999) {  
        copiasR4D.setIndentationLeft((float) 325);
        documento.add(copiasR4D);
          }
        }
        
        Paragraph copiasR5D = new  Paragraph (txt_Eritrocitos.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasR5D.setSpacingBefore((float) -12.5);
        copiasR5D.setSpacingAfter(-3);
        if(EritrocitosRe>=1000){
        copiasR5D.setIndentationLeft((float) 322);
        documento.add(copiasR5D);
        } 
        
        //------------------------------------------------------------------------>
        
        Paragraph copiasM11 = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM11.setSpacingBefore((float) -12);
        copiasM11.setIndentationLeft(373);
        copiasM11.setSpacingAfter(-3);
        
                if(EritrocitosRe<4.3){
        documento.add(copiasM11);
        }
             
        Paragraph copiasM12 = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copiasM12.setSpacingBefore((float) -12);
        copiasM12.setIndentationLeft(373);
        copiasM12.setSpacingAfter(-3);
   
          if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(copiasM12);
        } 
          
        Paragraph copiasM13 = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM13.setSpacingBefore((float) -12);
        copiasM13.setIndentationLeft(373);
        copiasM13.setSpacingAfter(-3);
   
          if(EritrocitosRe>5.2){
        documento.add(copiasM13);
        } 
         
        Paragraph uL = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        uL.setSpacingBefore((float) -12);
        uL.setIndentationLeft((float) 396.5);
        uL.setSpacingAfter(-3);
        
        if(EritrocitosRe<4.3){
        documento.add(uL);
        }
             
        Paragraph uL1 = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        uL1.setSpacingBefore((float) -12);
        uL1.setIndentationLeft((float) 396.5);
        uL1.setSpacingAfter(-3);
   
        if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(uL1);
        } 
          
        Paragraph uL2 = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        uL2.setSpacingBefore((float) -12);
        uL2.setIndentationLeft((float) 396.5);
        uL2.setSpacingAfter(-3);
   
        if(EritrocitosRe>5.2){
        documento.add(uL2);
        } 
        
        Paragraph Num511 = new  Paragraph ("4.3" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num511.setSpacingBefore((float) -12);
        Num511.setIndentationLeft((float) 447);
        Num511.setSpacingAfter(-3);
        
        if(EritrocitosRe<4.3){
        documento.add(Num511);
        }
             
        Paragraph Num512 = new  Paragraph ("4.3" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num512.setSpacingBefore((float) -12);
        Num512.setIndentationLeft((float) 447);
        Num512.setSpacingAfter(-3);
   
        if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(Num512);
        } 
          
        Paragraph Num513 = new  Paragraph ("4.3" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num513.setSpacingBefore((float) -12);
        Num513.setIndentationLeft((float) 447);
        Num513.setSpacingAfter(-3);
   
        if(EritrocitosRe>5.2){
        documento.add(Num513);
        } 
        
        Paragraph Num411 = new  Paragraph ("5.2" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num411.setSpacingBefore((float) -12);
        Num411.setIndentationLeft((float) 511);
        Num411.setSpacingAfter(-3);
        
        if(EritrocitosRe<4.3){
        documento.add(Num411);
        }
             
        Paragraph Num412 = new  Paragraph ("5.2" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num412.setSpacingBefore((float) -12);
        Num412.setIndentationLeft((float) 511);
        Num412.setSpacingAfter(-3);
   
        if(EritrocitosRe>=4.3 && EritrocitosRe<=5.2){
        documento.add(Num412);
        } 
          
        Paragraph Num413 = new  Paragraph ("5.2" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num413.setSpacingBefore((float) -12);
        Num413.setIndentationLeft((float) 511);
        Num413.setSpacingAfter(-3);
   
        if(EritrocitosRe>5.2){
        documento.add(Num413);
        }   
        
        Paragraph copias111 = new  Paragraph ("Hemoglobina" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias111.setSpacingBefore(2);
        copias111.setIndentationLeft(17);
        copias111.setSpacingAfter(-3);
        
        if(HemoglobinaRe<12){
        documento.add(copias111);
        }
             
        Paragraph copias112 = new  Paragraph ("Hemoglobina" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copias112.setSpacingBefore(2);
        copias112.setIndentationLeft(17);
        copias112.setSpacingAfter(-3);
   
        if(HemoglobinaRe>=12 && HemoglobinaRe<=14){
        documento.add(copias112);
        } 
          
        Paragraph copias113 = new  Paragraph ("Hemoglobina" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias113.setSpacingBefore(2);
        copias113.setIndentationLeft(17);
        copias113.setSpacingAfter(-3);
   
        if(HemoglobinaRe>14){
        documento.add(copias113);
        } 
        
        //Resultados de Hemoglobina
        Paragraph HemoglobinaR0 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HemoglobinaR0.setSpacingBefore((float) -12.5);
        HemoglobinaR0.setSpacingAfter(-3);
       
        if(txt_Hemoglobina.getText().contains(".") && HemoglobinaRe>0 && HemoglobinaRe<10){
        HemoglobinaR0.setIndentationLeft((float) 326);
        documento.add(HemoglobinaR0);
        } else {
        if(HemoglobinaRe>=0 && HemoglobinaRe<=9) {  
        HemoglobinaR0.setIndentationLeft((float) 330);
        documento.add(HemoglobinaR0);
          }
        }
        
        Paragraph HemoglobinaR1 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HemoglobinaR1.setSpacingBefore((float) -12.5);
        HemoglobinaR1.setSpacingAfter(-3);
       
        if(txt_Hemoglobina.getText().contains(".") && HemoglobinaRe>10 && HemoglobinaRe<12){
        HemoglobinaR1.setIndentationLeft((float) 324);
        documento.add(HemoglobinaR1);
        } else {
        if(HemoglobinaRe>=10 && HemoglobinaRe<=11) {  
        HemoglobinaR1.setIndentationLeft((float) 327);
        documento.add(HemoglobinaR1);
          }
        }
        
        Paragraph HemoglobinaR2 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HemoglobinaR2.setSpacingBefore((float) -12.5);
        HemoglobinaR2.setSpacingAfter(-3);
       
        if(txt_Hemoglobina.getText().contains(".") && HemoglobinaRe>12 && HemoglobinaRe<14){
        HemoglobinaR2.setIndentationLeft((float) 324);
        documento.add(HemoglobinaR2);
        } else {
        if(HemoglobinaRe>=12 && HemoglobinaRe<=14) {  
        HemoglobinaR2.setIndentationLeft((float) 327);
        documento.add(HemoglobinaR2);
          }
        }
        
        Paragraph HemoglobinaR3 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HemoglobinaR3.setSpacingBefore((float) -12.5);
        HemoglobinaR3.setSpacingAfter(-3);
       
        if(txt_Hemoglobina.getText().contains(".") && HemoglobinaRe>14 && HemoglobinaRe<100){
        HemoglobinaR3.setIndentationLeft((float) 324);
        documento.add(HemoglobinaR3);
        } else {
        if(HemoglobinaRe>=15 && HemoglobinaRe<=99) {  
        HemoglobinaR3.setIndentationLeft((float) 327);
        documento.add(HemoglobinaR3);
          }
        }
        
        Paragraph HemoglobinaR4 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HemoglobinaR4.setSpacingBefore((float) -12.5);
        HemoglobinaR4.setSpacingAfter(-3);
       
        if(txt_Hemoglobina.getText().contains(".") && HemoglobinaRe>100 && HemoglobinaRe<1000){
        HemoglobinaR4.setIndentationLeft((float) 323);
        documento.add(HemoglobinaR4);
        } else {
        if(HemoglobinaRe>=100 && HemoglobinaRe<=999) {  
        HemoglobinaR4.setIndentationLeft((float) 325);
        documento.add(HemoglobinaR4);
          }
        }
        
        Paragraph HemoglobinaR5 = new  Paragraph (txt_Hemoglobina.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HemoglobinaR5.setSpacingBefore((float) -12.5);
        HemoglobinaR5.setSpacingAfter(-3);
       
        if(HemoglobinaRe>=1000){
        HemoglobinaR5.setIndentationLeft((float) 322);
        documento.add(HemoglobinaR5);
        } 
        
        //----------------------------------------------------->
        
        Paragraph copiasM111 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM111.setSpacingBefore((float) -12);
        copiasM111.setIndentationLeft(375);
        copiasM111.setSpacingAfter(-3);
        
        if(HemoglobinaRe<12){
        documento.add(copiasM111);
        }
             
        Paragraph copiasM112 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copiasM112.setSpacingBefore((float) -12);
        copiasM112.setIndentationLeft(375);
        copiasM112.setSpacingAfter(-3);
   
        if(HemoglobinaRe>=12 && HemoglobinaRe<=14){
        documento.add(copiasM112);
        } 
          
        Paragraph copiasM113 = new  Paragraph ("mg/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM113.setSpacingBefore((float) -12);
        copiasM113.setIndentationLeft(375);
        copiasM113.setSpacingAfter(-3);
   
        if(HemoglobinaRe>14){
        documento.add(copiasM113);
        } 
        
        Paragraph Num5111 = new  Paragraph ("12" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num5111.setSpacingBefore((float) -12);
        Num5111.setIndentationLeft((float) 447);
        Num5111.setSpacingAfter(-3);
        
          if(HemoglobinaRe<12){
        documento.add(Num5111);
        }
             
        Paragraph Num5112 = new  Paragraph ("12" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num5112.setSpacingBefore((float) -12);
        Num5112.setIndentationLeft((float) 447);
        Num5112.setSpacingAfter(-3);
   
        if(HemoglobinaRe>=12 && HemoglobinaRe<=14){
        documento.add(Num5112);
        } 
          
        Paragraph Num5113 = new  Paragraph ("12" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num5113.setSpacingBefore((float) -12);
        Num5113.setIndentationLeft((float) 447);
        Num5113.setSpacingAfter(-3);
   
        if(HemoglobinaRe>14){
        documento.add(Num5113);
        } 
        
        Paragraph Num4111 = new  Paragraph ("14" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num4111.setSpacingBefore((float) -12);
        Num4111.setIndentationLeft((float) 512);
        Num4111.setSpacingAfter(-3);
        
           if(HemoglobinaRe<12){
        documento.add(Num4111);
        }
             
        Paragraph Num4112 = new  Paragraph ("14" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num4112.setSpacingBefore((float) -12);
        Num4112.setIndentationLeft((float) 512);
        Num4112.setSpacingAfter(-3);
   
        if(HemoglobinaRe>=12 && HemoglobinaRe<=14){
        documento.add(Num4112);
        } 
          
        Paragraph Num4113 = new  Paragraph ("14" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num4113.setSpacingBefore((float) -12);
        Num4113.setIndentationLeft((float) 512);
        Num4113.setSpacingAfter(-3);
   
        if(HemoglobinaRe>14){
        documento.add(Num4113);
        } 
        
        Paragraph copias1111 = new  Paragraph ("Hematocrito" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias1111.setSpacingBefore(2);
        copias1111.setIndentationLeft(17);
        copias1111.setSpacingAfter(-3);
        
        if(HematocritoRe<34){
        documento.add(copias1111);
        }
             
        Paragraph copias1112 = new  Paragraph ("Hematocrito" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copias1112.setSpacingBefore(2);
        copias1112.setIndentationLeft(17);
        copias1112.setSpacingAfter(-3);
   
        if(HematocritoRe>=34 && HematocritoRe<=43){
        documento.add(copias1112);
        } 
          
        Paragraph copias1113 = new  Paragraph ("Hematocrito" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copias1113.setSpacingBefore(2);
        copias1113.setIndentationLeft(17);
        copias1113.setSpacingAfter(-3);
   
        if(HematocritoRe>43){
        documento.add(copias1113);
        } 
        
        //Resultado de Hematocrito
        Paragraph HematocritoR = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HematocritoR.setSpacingBefore((float) -12.5);
        HematocritoR.setSpacingAfter(-3);
        
        if(txt_Hematocrito.getText().contains(".") && HematocritoRe>0 && HematocritoRe<10){
        HematocritoR.setIndentationLeft((float) 326);
        documento.add(HematocritoR);
        } else {
        if(HematocritoRe>=0 && HematocritoRe<=9) {  
        HematocritoR.setIndentationLeft((float) 330);
        documento.add(HematocritoR);
          }
        }
        
        Paragraph HematocritoR1 = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HematocritoR1.setSpacingBefore((float) -12.5);
        HematocritoR1.setSpacingAfter(-3);
        
        if(txt_Hematocrito.getText().contains(".") && HematocritoRe>10 && HematocritoRe<34){
        HematocritoR1.setIndentationLeft((float) 324);
        documento.add(HematocritoR1);
        } else {
        if(HematocritoRe>=10 && HematocritoRe<=33) {  
        HematocritoR1.setIndentationLeft((float) 327);
        documento.add(HematocritoR1);
          }
        }
        
        Paragraph HematocritoR2 = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HematocritoR2.setSpacingBefore((float) -12.5);
        HematocritoR2.setSpacingAfter(-3);
        
        if(txt_Hematocrito.getText().contains(".") && HematocritoRe>34 && HematocritoRe<43){
        HematocritoR2.setIndentationLeft((float) 324);
        documento.add(HematocritoR2);
        } else {
        if(HematocritoRe>=34 && HematocritoRe<=43) {  
        HematocritoR2.setIndentationLeft((float) 327);
        documento.add(HematocritoR2);
          }
        }
        
        Paragraph HematocritoR3 = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HematocritoR3.setSpacingBefore((float) -12.5);
        HematocritoR3.setSpacingAfter(-3);
        
        if(txt_Hematocrito.getText().contains(".") && HematocritoRe>43 && HematocritoRe<100){
        HematocritoR3.setIndentationLeft((float) 324);
        documento.add(HematocritoR3);
        } else {
        if(HematocritoRe>=44 && HematocritoRe<=99) {  
        HematocritoR3.setIndentationLeft((float) 327);
        documento.add(HematocritoR3);
          }
        }
        
        Paragraph HematocritoR4 = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HematocritoR4.setSpacingBefore((float) -12.5);
        HematocritoR4.setSpacingAfter(-3);
        
        if(txt_Hematocrito.getText().contains(".") && HematocritoRe>100 && HematocritoRe<1000){
        HematocritoR4.setIndentationLeft((float) 323);
        documento.add(HematocritoR4);
        } else {
        if(HematocritoRe>=100 && HematocritoRe<=999) {  
        HematocritoR4.setIndentationLeft((float) 325);
        documento.add(HematocritoR4);
          }
        }
        
        Paragraph HematocritoR5 = new  Paragraph (txt_Hematocrito.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HematocritoR5.setSpacingBefore((float) -12.5);
        HematocritoR5.setSpacingAfter(-3);
        
        if(HematocritoRe>=1000){
        HematocritoR5.setIndentationLeft((float) 322);
        documento.add(HematocritoR5);
        } 
       
        //--------------------------------------------------------------------------------------------------------------->
        
        Paragraph copiasM1111 = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM1111.setSpacingBefore((float) -12);
        copiasM1111.setIndentationLeft((float) 386);
        copiasM1111.setSpacingAfter(-3);
        
        if(HematocritoRe<34){
        documento.add(copiasM1111);
        }
             
        Paragraph copiasM1112 = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        copiasM1112.setSpacingBefore((float) -12);
        copiasM1112.setIndentationLeft((float) 386);
        copiasM1112.setSpacingAfter(-3);
   
        if(HematocritoRe>=34 && HematocritoRe<=43){
        documento.add(copiasM1112);
        } 
          
        Paragraph copiasM1113 = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        copiasM1113.setSpacingBefore((float) -12);
        copiasM1113.setIndentationLeft((float) 386);
        copiasM1113.setSpacingAfter(-3);
   
        if(HematocritoRe>43){
        documento.add(copiasM1113);
        } 
        
        Paragraph Num51111 = new  Paragraph ("34" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num51111.setSpacingBefore((float) -12);
        Num51111.setIndentationLeft((float) 447);
        Num51111.setSpacingAfter(-3);
        
        if(HematocritoRe<34){
        documento.add(Num51111);
        }
             
        Paragraph Num51112 = new  Paragraph ("34" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num51112.setSpacingBefore((float) -12);
        Num51112.setIndentationLeft((float) 447);
        Num51112.setSpacingAfter(-3);
   
        if(HematocritoRe>=34 && HematocritoRe<=43){
        documento.add(Num51112);
        } 
          
        Paragraph Num51113 = new  Paragraph ("34" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num51113.setSpacingBefore((float) -12);
        Num51113.setIndentationLeft((float) 447);
        Num51113.setSpacingAfter(-3);
   
        if(HematocritoRe>43){
        documento.add(Num51113);
        } 
        
        Paragraph Num41111 = new  Paragraph ("43" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num41111.setSpacingBefore((float) -12);
        Num41111.setIndentationLeft((float) 512);
        Num41111.setSpacingAfter(-3);
        
        if(HematocritoRe<34){
        documento.add(Num41111);
        }
             
        Paragraph Num41112 = new  Paragraph ("43" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Num41112.setSpacingBefore((float) -12);
        Num41112.setIndentationLeft((float) 512);
        Num41112.setSpacingAfter(-3);
   
        if(HematocritoRe>=34 && HematocritoRe<=43){
        documento.add(Num41112);
        } 
          
        Paragraph Num41113 = new  Paragraph ("43" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Num41113.setSpacingBefore((float) -12);
        Num41113.setIndentationLeft((float) 512);
        Num41113.setSpacingAfter(-3);
   
        if(HematocritoRe>43){
        documento.add(Num41113);
        } 
        
        Paragraph VCM = new  Paragraph ("Volumen Globular Medio (VCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCM.setSpacingBefore(2);
        VCM.setIndentationLeft(17);
        VCM.setSpacingAfter(-3);
        
        if(VolumenGlobularMedioVCMRe<84){
        documento.add(VCM);
        }
             
        Paragraph VCM1 = new  Paragraph ("Volumen Globular Medio (VCM)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCM1.setSpacingBefore(2);
        VCM1.setIndentationLeft(17);
        VCM1.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>=84 && VolumenGlobularMedioVCMRe<=104){
        documento.add(VCM1);
        } 
          
        Paragraph VCM2 = new  Paragraph ("Volumen Globular Medio (VCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCM2.setSpacingBefore(2);
        VCM2.setIndentationLeft(17);
        VCM2.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>104){
        documento.add(VCM2);
        } 
        
        //Resultados de Volumen Globular Medio
        Paragraph VCMR = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMR.setSpacingBefore((float) -12.5);
        VCMR.setSpacingAfter(-3);
       
        if(txt_VolumenGlobularMedioVCM.getText().contains(".") && VolumenGlobularMedioVCMRe>0 && VolumenGlobularMedioVCMRe<10){
        VCMR.setIndentationLeft((float) 326);
        documento.add(VCMR);
        } else {
        if(VolumenGlobularMedioVCMRe>=0 && VolumenGlobularMedioVCMRe<=9) {  
        VCMR.setIndentationLeft((float) 330);
        documento.add(VCMR);
          }
        }
          
        Paragraph VCMR2 = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMR2.setSpacingBefore((float) -12.5);
        VCMR2.setSpacingAfter(-3);
       
        if(txt_VolumenGlobularMedioVCM.getText().contains(".") && VolumenGlobularMedioVCMRe>10 && VolumenGlobularMedioVCMRe<84){
        VCMR2.setIndentationLeft((float) 324);
        documento.add(VCMR2);
        } else {
        if(VolumenGlobularMedioVCMRe>=10 && VolumenGlobularMedioVCMRe<=83) {  
        VCMR2.setIndentationLeft((float) 327);
        documento.add(VCMR2);
          }
        }
        
        Paragraph VCMR3 = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCMR3.setSpacingBefore((float) -12.5);
        VCMR3.setSpacingAfter(-3);
       
        if(txt_VolumenGlobularMedioVCM.getText().contains(".") && VolumenGlobularMedioVCMRe>84 && VolumenGlobularMedioVCMRe<100){
        VCMR3.setIndentationLeft((float) 324);
        documento.add(VCMR3);
        } else {
        if(VolumenGlobularMedioVCMRe>=84 && VolumenGlobularMedioVCMRe<=99) {  
        VCMR3.setIndentationLeft((float) 327);
        documento.add(VCMR3);
          }
        }
        
        Paragraph VCMR4 = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCMR4.setSpacingBefore((float) -12.5);
        VCMR4.setSpacingAfter(-3);
       
        if(txt_VolumenGlobularMedioVCM.getText().contains(".") && VolumenGlobularMedioVCMRe>100 && VolumenGlobularMedioVCMRe<104){
        VCMR4.setIndentationLeft((float) 323);
        documento.add(VCMR4);
        } else {
        if(VolumenGlobularMedioVCMRe>=100 && VolumenGlobularMedioVCMRe<=104) {  
        VCMR4.setIndentationLeft((float) 325);
        documento.add(VCMR4);
          }
        }
        
        Paragraph VCMR5 = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMR5.setSpacingBefore((float) -12.5);
        VCMR5.setSpacingAfter(-3);
       
        if(txt_VolumenGlobularMedioVCM.getText().contains(".") && VolumenGlobularMedioVCMRe>104 && VolumenGlobularMedioVCMRe<1000){
        VCMR5.setIndentationLeft((float) 323);
        documento.add(VCMR5);
        } else {
        if(VolumenGlobularMedioVCMRe>=105 && VolumenGlobularMedioVCMRe<=999) {  
        VCMR5.setIndentationLeft((float) 325);
        documento.add(VCMR5);
          }
        }
       
        Paragraph VCMR6 = new  Paragraph (txt_VolumenGlobularMedioVCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMR6.setSpacingBefore((float) -12.5);
        VCMR6.setSpacingAfter(-3);
       
        if(VolumenGlobularMedioVCMRe>=1000){
        VCMR6.setIndentationLeft((float) 322);
        documento.add(VCMR6);
        } 
    
        //------------------------------------------------------------------------------------------------------------------------------------>
        
        Paragraph VCMV = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMV.setSpacingBefore((float) -12);
        VCMV.setIndentationLeft(386);
        VCMV.setSpacingAfter(-3);
        
        if(VolumenGlobularMedioVCMRe<84){
        documento.add(VCMV);
        }
             
        Paragraph VCMV1 = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCMV1.setSpacingBefore((float) -12);
        VCMV1.setIndentationLeft(386);
        VCMV1.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>=84 && VolumenGlobularMedioVCMRe<=104){
        documento.add(VCMV1);
        } 
          
        Paragraph VCMV2 = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMV2.setSpacingBefore((float) -12);
        VCMV2.setIndentationLeft(386);
        VCMV2.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>104){
        documento.add(VCMV2);
        } 
        
        Paragraph VCMref = new  Paragraph ("84" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMref.setSpacingBefore((float) -12);
        VCMref.setIndentationLeft((float) 447);
        VCMref.setSpacingAfter(-3);
        
        if(VolumenGlobularMedioVCMRe<84){
        documento.add(VCMref);
        }
             
        Paragraph VCMref1 = new  Paragraph ("84" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCMref1.setSpacingBefore((float) -12);
        VCMref1.setIndentationLeft((float) 447);
        VCMref1.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>=84 && VolumenGlobularMedioVCMRe<=104){
        documento.add(VCMref1);
        } 
          
        Paragraph VCMref2 = new  Paragraph ("84" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMref2.setSpacingBefore((float) -12);
        VCMref2.setIndentationLeft((float) 447);
        VCMref2.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>104){
        documento.add(VCMref2);
        } 
        
        Paragraph VCMref3 = new  Paragraph ("104" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMref3.setSpacingBefore((float) -12);
        VCMref3.setIndentationLeft((float) 510);
        VCMref3.setSpacingAfter(-3);
        
        if(VolumenGlobularMedioVCMRe<84){
        documento.add(VCMref3);
        }
             
        Paragraph VCMref4 = new  Paragraph ("104" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VCMref4.setSpacingBefore((float) -12);
        VCMref4.setIndentationLeft((float) 510);
        VCMref4.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>=84 && VolumenGlobularMedioVCMRe<=104){
        documento.add(VCMref4);
        } 
          
        Paragraph VCMref5 = new  Paragraph ("104" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VCMref5.setSpacingBefore((float) -12);
        VCMref5.setIndentationLeft((float) 510);
        VCMref5.setSpacingAfter(-3);
   
        if(VolumenGlobularMedioVCMRe>104){
        documento.add(VCMref5);
        } 
        
        Paragraph HCM = new  Paragraph ("Concentración Media de Hemoglobina (HCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCM.setSpacingBefore(2);
        HCM.setIndentationLeft(17);
        HCM.setSpacingAfter(-3);
  
        if(ConcentracióMediadeHemoglobinaHCMRe<27){
        documento.add(HCM);
        }
             
        Paragraph HCM1 = new  Paragraph ("Concentración Media de Hemoglobina (HCM)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HCM1.setSpacingBefore(2);
        HCM1.setIndentationLeft(17);
        HCM1.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>=27 && ConcentracióMediadeHemoglobinaHCMRe<=35){
        documento.add(HCM1);
        } 
          
        Paragraph HCM2 = new  Paragraph ("Concentración Media de Hemoglobina (HCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCM2.setSpacingBefore(2);
        HCM2.setIndentationLeft(17);
        HCM2.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>35){
        documento.add(HCM2);
        } 
        
        //Resultado de Concentracion Media de Hemoglobina
        Paragraph HCMR = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMR.setSpacingBefore((float) -12.5);
        HCMR.setSpacingAfter(-3);
          
        if(txt_ConcentracióMediadeHemoglobinaHCM.getText().contains(".") && ConcentracióMediadeHemoglobinaHCMRe>0 && ConcentracióMediadeHemoglobinaHCMRe<10){
        HCMR.setIndentationLeft((float) 326);
        documento.add(HCMR);
        } else {
        if(ConcentracióMediadeHemoglobinaHCMRe>=0 && ConcentracióMediadeHemoglobinaHCMRe<=9) {  
        HCMR.setIndentationLeft((float) 330);
        documento.add(HCMR);
          }
        }
        
        Paragraph HCMR1 = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMR1.setSpacingBefore((float) -12.5);
        HCMR1.setSpacingAfter(-3);
          
        if(txt_ConcentracióMediadeHemoglobinaHCM.getText().contains(".") && ConcentracióMediadeHemoglobinaHCMRe>10 && ConcentracióMediadeHemoglobinaHCMRe<27){
        HCMR1.setIndentationLeft((float) 324);
        documento.add(HCMR1);
        } else {
        if(ConcentracióMediadeHemoglobinaHCMRe>=10 && ConcentracióMediadeHemoglobinaHCMRe<=26) {  
        HCMR1.setIndentationLeft((float) 327);
        documento.add(HCMR1);
          }
        }
        
        Paragraph HCMR2 = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HCMR2.setSpacingBefore((float) -12.5);
        HCMR2.setSpacingAfter(-3);
          
        if(txt_ConcentracióMediadeHemoglobinaHCM.getText().contains(".") && ConcentracióMediadeHemoglobinaHCMRe>27 && ConcentracióMediadeHemoglobinaHCMRe<35){
        HCMR2.setIndentationLeft((float) 324);
        documento.add(HCMR2);
        } else {
        if(ConcentracióMediadeHemoglobinaHCMRe>=27 && ConcentracióMediadeHemoglobinaHCMRe<=35) {  
        HCMR2.setIndentationLeft((float) 327);
        documento.add(HCMR2);
          }
        }
        
   
        Paragraph HCMR4 = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMR4.setSpacingBefore((float) -12.5);
        HCMR4.setSpacingAfter(-3);
          
        if(txt_ConcentracióMediadeHemoglobinaHCM.getText().contains(".") && ConcentracióMediadeHemoglobinaHCMRe>35 && ConcentracióMediadeHemoglobinaHCMRe<100){
        HCMR4.setIndentationLeft((float) 324);
        documento.add(HCMR4);
        } else {
        if(ConcentracióMediadeHemoglobinaHCMRe>=36 && ConcentracióMediadeHemoglobinaHCMRe<=99) {  
        HCMR4.setIndentationLeft((float) 327);
        documento.add(HCMR4);
          }
        }
        
        Paragraph HCMR5 = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMR5.setSpacingBefore((float) -12.5);
        HCMR5.setSpacingAfter(-3);
          
        if(txt_ConcentracióMediadeHemoglobinaHCM.getText().contains(".") && ConcentracióMediadeHemoglobinaHCMRe>100 && ConcentracióMediadeHemoglobinaHCMRe<1000){
        HCMR5.setIndentationLeft((float) 323);
        documento.add(HCMR5);
        } else {
        if(ConcentracióMediadeHemoglobinaHCMRe>=100 && ConcentracióMediadeHemoglobinaHCMRe<=999) {  
        HCMR5.setIndentationLeft((float) 325);
        documento.add(HCMR5);
          }
        }
                
        Paragraph HCMR7 = new  Paragraph (txt_ConcentracióMediadeHemoglobinaHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMR7.setSpacingBefore((float) -12.5);
        HCMR7.setSpacingAfter(-3);
          
        if(ConcentracióMediadeHemoglobinaHCMRe>=1000){
        HCMR7.setIndentationLeft((float) 322);
        documento.add(HCMR7);
        } 
        
        //---------------------------------------------------------------------------------------------->
        
        Paragraph HCMV = new  Paragraph ("pg" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMV.setSpacingBefore((float) -12);
        HCMV.setIndentationLeft(385);
        HCMV.setSpacingAfter(-3);
        
        if(ConcentracióMediadeHemoglobinaHCMRe<27){
        documento.add(HCMV);
        }
             
        Paragraph HCMV1 = new  Paragraph ("pg" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HCMV1.setSpacingBefore((float) -12);
        HCMV1.setIndentationLeft(385);
        HCMV1.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>=27 && ConcentracióMediadeHemoglobinaHCMRe<=35){
        documento.add(HCMV1);
        } 
          
        Paragraph HCMV2 = new  Paragraph ("pg" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMV2.setSpacingBefore((float) -12);
        HCMV2.setIndentationLeft(385);
        HCMV2.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>35){
        documento.add(HCMV2);
        }
        
        Paragraph HCMref = new  Paragraph ("27" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMref.setSpacingBefore((float) -12);
        HCMref.setIndentationLeft((float) 447);
        HCMref.setSpacingAfter(-3);
        
        if(ConcentracióMediadeHemoglobinaHCMRe<27){
        documento.add(HCMref);
        }
             
        Paragraph HCMref1 = new  Paragraph ("27" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HCMref1.setSpacingBefore((float) -12);
        HCMref1.setIndentationLeft((float) 447);
        HCMref1.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>=27 && ConcentracióMediadeHemoglobinaHCMRe<=35){
        documento.add(HCMref1);
        } 
          
        Paragraph HCMref2 = new  Paragraph ("27" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMref2.setSpacingBefore((float) -12);
        HCMref2.setIndentationLeft((float) 447);
        HCMref2.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>35){
        documento.add(HCMref2);
        }
        
        Paragraph HCMref12 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMref12.setSpacingBefore((float) -12);
        HCMref12.setIndentationLeft((float) 512);
        HCMref12.setSpacingAfter(-3);
        
        if(ConcentracióMediadeHemoglobinaHCMRe<27){
        documento.add(HCMref12);
        }
             
        Paragraph HCMref122 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        HCMref122.setSpacingBefore((float) -12);
        HCMref122.setIndentationLeft((float) 512);
        HCMref122.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>=27 && ConcentracióMediadeHemoglobinaHCMRe<=35){
        documento.add(HCMref122);
        } 
          
        Paragraph HCMref123 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        HCMref123.setSpacingBefore((float) -12);
        HCMref123.setIndentationLeft((float) 512);
        HCMref123.setSpacingAfter(-3);
   
        if(ConcentracióMediadeHemoglobinaHCMRe>35){
        documento.add(HCMref123);
        }
        
        Paragraph CHCM = new  Paragraph ("Concentración Media de Hemoglobina Corpuscular (CHCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCM.setSpacingBefore(2);
        CHCM.setIndentationLeft(17);
        CHCM.setSpacingAfter(-3);
        
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<29){
        documento.add(CHCM);
        }
             
        Paragraph CHCM1 = new  Paragraph ("Concentración Media de Hemoglobina Corpuscular (CHCM)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CHCM1.setSpacingBefore(2);
        CHCM1.setIndentationLeft(17);
        CHCM1.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=35){
        documento.add(CHCM1);
        } 
          
        Paragraph CHCM2 = new  Paragraph ("Concentración Media de Hemoglobina Corpuscular (CHCM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCM2.setSpacingBefore(2);
        CHCM2.setIndentationLeft(17);
        CHCM2.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>35){
        documento.add(CHCM2);
        } 
        
        //Concentracion Media de Hemoglobina Corpuscular
        Paragraph CHCMR = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMR.setSpacingBefore((float) -12.5);
        CHCMR.setSpacingAfter(-3);
            
        if(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().contains(".") && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>0 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<10){
        CHCMR.setIndentationLeft((float) 326);
        documento.add(CHCMR);
        } else {
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=0 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=9) {  
        CHCMR.setIndentationLeft((float) 330);
        documento.add(CHCMR);
          }
        }
        
        Paragraph CHCMR1 = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMR1.setSpacingBefore((float) -12.5);
        CHCMR1.setSpacingAfter(-3);
            
        if(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().contains(".") && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>10 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<29){
        CHCMR1.setIndentationLeft((float) 324);
        documento.add(CHCMR1);
        } else {
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=10 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=28) {  
        CHCMR1.setIndentationLeft((float) 327);
        documento.add(CHCMR1);
          }
        }
        
        Paragraph CHCMR2 = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CHCMR2.setSpacingBefore((float) -12.5);
        CHCMR2.setSpacingAfter(-3);
            
        if(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().contains(".") && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<35){
        CHCMR2.setIndentationLeft((float) 324);
        documento.add(CHCMR2);
        } else {
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=35) {  
        CHCMR2.setIndentationLeft((float) 327);
        documento.add(CHCMR2);
          }
        }
        
        Paragraph CHCMR3 = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMR3.setSpacingBefore((float) -12.5);
        CHCMR3.setSpacingAfter(-3);
            
        if(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().contains(".") && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>35 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<100){
        CHCMR3.setIndentationLeft((float) 324);
        documento.add(CHCMR3);
        } else {
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=36 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=99) {  
        CHCMR3.setIndentationLeft((float) 327);
        documento.add(CHCMR3);
          }
        }
        
        Paragraph CHCMR4 = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMR4.setSpacingBefore((float) -12.5);
        CHCMR4.setSpacingAfter(-3);
            
        if(txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText().contains(".") && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>100 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<1000){
        CHCMR4.setIndentationLeft((float) 323);
        documento.add(CHCMR4);
        } else {
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=100 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=999) {  
        CHCMR4.setIndentationLeft((float) 325);
        documento.add(CHCMR4);
          }
        }
        
        Paragraph CHCMR5 = new  Paragraph (txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMR5.setSpacingBefore((float) -12.5);
        CHCMR5.setSpacingAfter(-3);
            
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=1000){
        CHCMR5.setIndentationLeft((float) 322);
        documento.add(CHCMR5);
        } 
   
        //---------------------------------------------------------------------------------------------------->
        
        Paragraph CHCMV = new  Paragraph ("gr/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMV.setSpacingBefore((float) -12);
        CHCMV.setIndentationLeft(380);
        CHCMV.setSpacingAfter(-3);
        
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<29){
        documento.add(CHCMV);
        }
             
        Paragraph CHCMV1 = new  Paragraph ("gr/dL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CHCMV1.setSpacingBefore((float) -12);
        CHCMV1.setIndentationLeft(380);
        CHCMV1.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=35){
        documento.add(CHCMV1);
        } 
          
        Paragraph CHCMV2 = new  Paragraph ("gr/dL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMV2.setSpacingBefore((float) -12);
        CHCMV2.setIndentationLeft(380);
        CHCMV2.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>35){
        documento.add(CHCMV2);
        } 
        
        Paragraph CHCMref = new  Paragraph ("29" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMref.setSpacingBefore((float) -12);
        CHCMref.setIndentationLeft((float) 447);
        CHCMref.setSpacingAfter(-3);
        
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<29){
        documento.add(CHCMref);
        }
             
        Paragraph CHCMref1 = new  Paragraph ("29" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CHCMref1.setSpacingBefore((float) -12);
        CHCMref1.setIndentationLeft((float) 447);
        CHCMref1.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=35){
        documento.add(CHCMref1);
        } 
          
        Paragraph CHCMref2 = new  Paragraph ("29" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMref2.setSpacingBefore((float) -12);
        CHCMref2.setIndentationLeft((float) 447);
        CHCMref2.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>35){
        documento.add(CHCMref2);
        } 
        
        Paragraph CHCMref12 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMref12.setSpacingBefore((float) -12);
        CHCMref12.setIndentationLeft((float) 512);
        CHCMref12.setSpacingAfter(-3);
        
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<29){
        documento.add(CHCMref12);
        }
             
        Paragraph CHCMref13 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        CHCMref13.setSpacingBefore((float) -12);
        CHCMref13.setIndentationLeft((float) 512);
        CHCMref13.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>=29 && ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe<=35){
        documento.add(CHCMref13);
        } 
          
        Paragraph CHCMref14 = new  Paragraph ("35" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        CHCMref14.setSpacingBefore((float) -12);
        CHCMref14.setIndentationLeft((float) 512);
        CHCMref14.setSpacingAfter(-3);
   
        if(ConcentraciónMediadeHemoglobinaCorpuscularCHCMRe>35){
        documento.add(CHCMref14);
        } 
        
        Paragraph RDW = new  Paragraph ("Índice de distribución de eritrocitos (RDW)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDW.setSpacingBefore(2);
        RDW.setIndentationLeft(17);
        RDW.setSpacingAfter(-3);
        
        if(ÍndicededistribucióndeeritrocitosRDWRe<10){
        documento.add(RDW);
        }
             
        Paragraph RDW1 = new  Paragraph ("Índice de distribución de eritrocitos (RDW)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RDW1.setSpacingBefore(2);
        RDW1.setIndentationLeft(17);
        RDW1.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>=10 && ÍndicededistribucióndeeritrocitosRDWRe<=15){
        documento.add(RDW1);
        } 
          
        Paragraph RDW2 = new  Paragraph ("Índice de distribución de eritrocitos (RDW)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDW2.setSpacingBefore(2);
        RDW2.setIndentationLeft(17);
        RDW2.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>15){
        documento.add(RDW2);
        } 
        
        //Indice de distribución eritrocitos
        Paragraph RDWR = new  Paragraph (txt_ÍndicededistribucióndeeritrocitosRDW.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWR.setSpacingBefore((float) -12.5);
        RDWR.setSpacingAfter(-3);
               
        if(txt_ÍndicededistribucióndeeritrocitosRDW.getText().contains(".") && ÍndicededistribucióndeeritrocitosRDWRe>0 && ÍndicededistribucióndeeritrocitosRDWRe<10){
        RDWR.setIndentationLeft((float) 326);
        documento.add(RDWR);
        } else {
        if(ÍndicededistribucióndeeritrocitosRDWRe>=0 && ÍndicededistribucióndeeritrocitosRDWRe<=9) {  
        RDWR.setIndentationLeft((float) 330);
        documento.add(RDWR);
          }
        }
        
        Paragraph RDWR1 = new  Paragraph (txt_ÍndicededistribucióndeeritrocitosRDW.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RDWR1.setSpacingBefore((float) -12.5);
        RDWR1.setSpacingAfter(-3);
               
        if(txt_ÍndicededistribucióndeeritrocitosRDW.getText().contains(".") && ÍndicededistribucióndeeritrocitosRDWRe>10 && ÍndicededistribucióndeeritrocitosRDWRe<15){
        RDWR1.setIndentationLeft((float) 324);
        documento.add(RDWR1);
        } else {
        if(ÍndicededistribucióndeeritrocitosRDWRe>=10 && ÍndicededistribucióndeeritrocitosRDWRe<=15) {  
        RDWR1.setIndentationLeft((float) 327);
        documento.add(RDWR1);
          }
        }
        
        Paragraph RDWR2 = new  Paragraph (txt_ÍndicededistribucióndeeritrocitosRDW.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWR2.setSpacingBefore((float) -12.5);
        RDWR2.setSpacingAfter(-3);
               
        if(txt_ÍndicededistribucióndeeritrocitosRDW.getText().contains(".") && ÍndicededistribucióndeeritrocitosRDWRe>15 && ÍndicededistribucióndeeritrocitosRDWRe<100){
        RDWR2.setIndentationLeft((float) 324);
        documento.add(RDWR2);
        } else {
        if(ÍndicededistribucióndeeritrocitosRDWRe>=16 && ÍndicededistribucióndeeritrocitosRDWRe<=99) {  
        RDWR2.setIndentationLeft((float) 327);
        documento.add(RDWR2);
          }
        }
        
       
        Paragraph RDWR4 = new  Paragraph (txt_ÍndicededistribucióndeeritrocitosRDW.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWR4.setSpacingBefore((float) -12.5);
        RDWR4.setSpacingAfter(-3);
               
        if(txt_ÍndicededistribucióndeeritrocitosRDW.getText().contains(".") && ÍndicededistribucióndeeritrocitosRDWRe>100 && ÍndicededistribucióndeeritrocitosRDWRe<1000){
        RDWR4.setIndentationLeft((float) 323);
        documento.add(RDWR4);
        } else {
        if(ÍndicededistribucióndeeritrocitosRDWRe>=100 && ÍndicededistribucióndeeritrocitosRDWRe<=999) {  
        RDWR4.setIndentationLeft((float) 325);
        documento.add(RDWR4);
          }
        }
 
        Paragraph RDWR5 = new  Paragraph (txt_ÍndicededistribucióndeeritrocitosRDW.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWR5.setSpacingBefore((float) -12.5);
        RDWR5.setSpacingAfter(-3);
               
        if(ÍndicededistribucióndeeritrocitosRDWRe>=1000){
        RDWR5.setIndentationLeft((float) 322);
        documento.add(RDWR5);
        } 
              
        //----------------------------------------------------------------------------------->
        
        Paragraph RDWV = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWV.setSpacingBefore((float) -12);
        RDWV.setIndentationLeft(386);
        RDWV.setSpacingAfter(-3);
        
        if(ÍndicededistribucióndeeritrocitosRDWRe<10){
        documento.add(RDWV);
        }
             
        Paragraph RDWV1 = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RDWV1.setSpacingBefore((float) -12);
        RDWV1.setIndentationLeft(386);
        RDWV1.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>=10 && ÍndicededistribucióndeeritrocitosRDWRe<=15){
        documento.add(RDWV1);
        } 
          
        Paragraph RDWV2 = new  Paragraph ("%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWV2.setSpacingBefore((float) -12);
        RDWV2.setIndentationLeft(386);
        RDWV2.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>15){
        documento.add(RDWV2);
        } 
        
        Paragraph RDWref = new  Paragraph ("10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWref.setSpacingBefore((float) -12);
        RDWref.setIndentationLeft((float) 447);
        RDWref.setSpacingAfter(-3);
        
        if(ÍndicededistribucióndeeritrocitosRDWRe<10){
        documento.add(RDWref);
        }
             
        Paragraph RDWref1 = new  Paragraph ("10" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RDWref1.setSpacingBefore((float) -12);
        RDWref1.setIndentationLeft((float) 447);
        RDWref1.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>=10 && ÍndicededistribucióndeeritrocitosRDWRe<=15){
        documento.add(RDWref1);
        } 
          
        Paragraph RDWref2 = new  Paragraph ("10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWref2.setSpacingBefore((float) -12);
        RDWref2.setIndentationLeft((float) 447);
        RDWref2.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>15){
        documento.add(RDWref2);
        }
        
        Paragraph RDWref12 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWref12.setSpacingBefore((float) -12);
        RDWref12.setIndentationLeft((float) 512);
        RDWref12.setSpacingAfter(-3);
        
        if(ÍndicededistribucióndeeritrocitosRDWRe<10){
        documento.add(RDWref12);
        }
             
        Paragraph RDWref13 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        RDWref13.setSpacingBefore((float) -12);
        RDWref13.setIndentationLeft((float) 512);
        RDWref13.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>=10 && ÍndicededistribucióndeeritrocitosRDWRe<=15){
        documento.add(RDWref13);
        } 
          
        Paragraph RDWref14 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        RDWref14.setSpacingBefore((float) -12);
        RDWref14.setIndentationLeft((float) 512);
        RDWref14.setSpacingAfter(-3);
   
        if(ÍndicededistribucióndeeritrocitosRDWRe>15){
        documento.add(RDWref14);
        }
        
        Paragraph elevado62 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK));
        elevado62.setSpacingBefore((float) 2);
        elevado62.setIndentationLeft((float) 393.5);
        elevado62.setSpacingAfter(0);
        
        if(PlaquetasRe<140){
        documento.add(elevado62);
        }
             
        Paragraph elevado621 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.NORMAL, BaseColor.BLACK));
        elevado621.setSpacingBefore((float) 2);
        elevado621.setIndentationLeft((float) 393.5);
        elevado621.setSpacingAfter(0);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(elevado621);
        } 
          
        Paragraph elevado622 = new  Paragraph ("6" , FontFactory.getFont("arial", 7, Font.BOLD, BaseColor.BLACK));
        elevado622.setSpacingBefore((float) 2);
        elevado622.setIndentationLeft((float) 393.5);
        elevado622.setSpacingAfter(0);
   
        if(PlaquetasRe>400){
        documento.add(elevado622);
        }
        
        Paragraph Plaquetas = new  Paragraph ("Plaquetas" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Plaquetas.setSpacingBefore(-11);
        Plaquetas.setIndentationLeft(17);
        Plaquetas.setSpacingAfter(-3);
        
        if(PlaquetasRe<140){
        documento.add(Plaquetas);
        }
             
        Paragraph Plaquetas1 = new  Paragraph ("Plaquetas" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Plaquetas1.setSpacingBefore(-11);
        Plaquetas1.setIndentationLeft(17);
        Plaquetas1.setSpacingAfter(-3);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(Plaquetas1);
        } 
          
        Paragraph Plaquetas2 = new  Paragraph ("Plaquetas" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Plaquetas2.setSpacingBefore(-11);
        Plaquetas2.setIndentationLeft(17);
        Plaquetas2.setSpacingAfter(-3);
   
        if(PlaquetasRe>400){
        documento.add(Plaquetas2);
        }
        
        //Resultado de plaquetas
        Paragraph PlaquetasRD1 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasRD1.setSpacingBefore((float) -12.5);
        PlaquetasRD1.setSpacingAfter(-3);

        if(txt_Plaquetas.getText().contains(".") && PlaquetasRe>0 && PlaquetasRe<10){
        PlaquetasRD1.setIndentationLeft((float) 326);
        documento.add(PlaquetasRD1);
        } else {
        if(PlaquetasRe>=0 && PlaquetasRe<=9) {  
        PlaquetasRD1.setIndentationLeft((float) 330);
        documento.add(PlaquetasRD1);
          }
        }
        
        Paragraph PlaquetasRD2 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasRD2.setSpacingBefore((float) -12.5);
        PlaquetasRD2.setSpacingAfter(-3);
    
        if(txt_Plaquetas.getText().contains(".") && PlaquetasRe>10 && PlaquetasRe<100){
        PlaquetasRD2.setIndentationLeft((float) 324);
        documento.add(PlaquetasRD2);
        } else {
        if(PlaquetasRe>=10 && PlaquetasRe<=99) {  
        PlaquetasRD2.setIndentationLeft((float) 327);
        documento.add(PlaquetasRD2);
          }
        }
        
        Paragraph PlaquetasRD3 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasRD3.setSpacingBefore((float) -12.5);
        PlaquetasRD3.setSpacingAfter(-3);
    
        if(txt_Plaquetas.getText().contains(".") && PlaquetasRe>100 && PlaquetasRe<140){
        PlaquetasRD3.setIndentationLeft((float) 323);
        documento.add(PlaquetasRD3);
        } else {
        if(PlaquetasRe>=100 && PlaquetasRe<=139) {  
        PlaquetasRD3.setIndentationLeft((float) 325);
        documento.add(PlaquetasRD3);
          }
        }
        
        Paragraph PlaquetasRD4 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        PlaquetasRD4.setSpacingBefore((float) -12.5);
        PlaquetasRD4.setSpacingAfter(-3);
    
        if(txt_Plaquetas.getText().contains(".") && PlaquetasRe>140 && PlaquetasRe<400){
        PlaquetasRD4.setIndentationLeft((float) 323);
        documento.add(PlaquetasRD4);
        } else {
        if(PlaquetasRe>=140 && PlaquetasRe<=400) {  
        PlaquetasRD4.setIndentationLeft((float) 325);
        documento.add(PlaquetasRD4);
          }
        }
       
        Paragraph PlaquetasRD5 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasRD5.setSpacingBefore((float) -12.5);
        PlaquetasRD5.setSpacingAfter(-3);
    
        if(txt_Plaquetas.getText().contains(".") && PlaquetasRe>400 && PlaquetasRe<1000){
        PlaquetasRD5.setIndentationLeft((float) 323);
        documento.add(PlaquetasRD5);
        } else {
        if(PlaquetasRe>=401 && PlaquetasRe<=999) {  
        PlaquetasRD5.setIndentationLeft((float) 325);
        documento.add(PlaquetasRD5);
          }
        }
        
        Paragraph PlaquetasRD6 = new  Paragraph (txt_Plaquetas.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasRD6.setSpacingBefore((float) -12.5);
        PlaquetasRD6.setSpacingAfter(-3);
    
        if(PlaquetasRe>1000){
        PlaquetasRD6.setIndentationLeft((float) 322);
        documento.add(PlaquetasRD6);
        } 
        
        //------------------------------------------------------------------------------------------------------------------------>
        
        Paragraph PlaquetasV = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasV.setSpacingBefore((float) -12);
        PlaquetasV.setIndentationLeft(373);
        PlaquetasV.setSpacingAfter(-3);
        
        if(PlaquetasRe<140){
        documento.add(PlaquetasV);
        }
             
        Paragraph PlaquetasV1 = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        PlaquetasV1.setSpacingBefore((float) -12);
        PlaquetasV1.setIndentationLeft(373);
        PlaquetasV1.setSpacingAfter(-3);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(PlaquetasV1);
        } 
          
        Paragraph PlaquetasV2 = new  Paragraph ("X 10" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PlaquetasV2.setSpacingBefore((float) -12);
        PlaquetasV2.setIndentationLeft(373);
        PlaquetasV2.setSpacingAfter(-3);
   
        if(PlaquetasRe>400){
        documento.add(PlaquetasV2);
        }
          
             Paragraph uL22 = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        uL22.setSpacingBefore((float) -12);
        uL22.setIndentationLeft((float) 396.5);
        uL22.setSpacingAfter(-3);
        
        if(PlaquetasRe<140){
        documento.add(uL22);
        }
             
        Paragraph uL23 = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        uL23.setSpacingBefore((float) -12);
        uL23.setIndentationLeft((float) 396.5);
        uL23.setSpacingAfter(-3);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(uL23);
        } 
          
        Paragraph uL24 = new  Paragraph ("/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        uL24.setSpacingBefore((float) -12);
        uL24.setIndentationLeft((float) 396.5);
        uL24.setSpacingAfter(-3);
   
        if(PlaquetasRe>400){
        documento.add(uL24);
        }
        
        Paragraph Plaquetasref = new  Paragraph ("140" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Plaquetasref.setSpacingBefore((float) -12);
        Plaquetasref.setIndentationLeft((float) 445);
        Plaquetasref.setSpacingAfter(-3);
        
        if(PlaquetasRe<140){
        documento.add(Plaquetasref);
        }
             
        Paragraph Plaquetasref1 = new  Paragraph ("140" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Plaquetasref1.setSpacingBefore((float) -12);
        Plaquetasref1.setIndentationLeft((float) 445);
        Plaquetasref1.setSpacingAfter(-3);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(Plaquetasref1);
        } 
          
        Paragraph Plaquetasref2 = new  Paragraph ("140" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Plaquetasref2.setSpacingBefore((float) -12);
        Plaquetasref2.setIndentationLeft((float) 445);
        Plaquetasref2.setSpacingAfter(-3);
   
        if(PlaquetasRe>400){
        documento.add(Plaquetasref2);
        }
        
        Paragraph Plaquetasref12 = new  Paragraph ("400" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Plaquetasref12.setSpacingBefore((float) -12);
        Plaquetasref12.setIndentationLeft((float) 510);
        Plaquetasref12.setSpacingAfter(-3);
        
        if(PlaquetasRe<140){
        documento.add(Plaquetasref12);
        }
             
        Paragraph Plaquetasref13 = new  Paragraph ("400" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Plaquetasref13.setSpacingBefore((float) -12);
        Plaquetasref13.setIndentationLeft((float) 510);
        Plaquetasref13.setSpacingAfter(-3);
   
        if(PlaquetasRe>=140 && PlaquetasRe<=400){
        documento.add(Plaquetasref13);
        } 
          
        Paragraph Plaquetasref14 = new  Paragraph ("400" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Plaquetasref14.setSpacingBefore((float) -12);
        Plaquetasref14.setIndentationLeft((float) 510);
        Plaquetasref14.setSpacingAfter(-3);
   
        if(PlaquetasRe>400){
        documento.add(Plaquetasref14);
        }
        
        Paragraph VPM = new  Paragraph ("Volumen Plaquetario Medio (VPM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPM.setSpacingBefore(2);
        VPM.setIndentationLeft(17);
        VPM.setSpacingAfter(-3);
        
            if(VolumenPlaquetarioMedioVPMRe<6.8){
        documento.add(VPM);
        }
             
        Paragraph VPM1 = new  Paragraph ("Volumen Plaquetario Medio (VPM)" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPM1.setSpacingBefore(2);
        VPM1.setIndentationLeft(17);
        VPM1.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>=6.8 && VolumenPlaquetarioMedioVPMRe<=15){
        documento.add(VPM1);
        } 
          
        Paragraph VPM2 = new  Paragraph ("Volumen Plaquetario Medio (VPM)" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPM2.setSpacingBefore(2);
        VPM2.setIndentationLeft(17);
        VPM2.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>15){
        documento.add(VPM2);
        }
        
        // Volumen Plaquetario Medio VPM
        Paragraph VPMR = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMR.setSpacingBefore((float) -12.5);
        VPMR.setSpacingAfter(-3);
        
        if(txt_VolumenPlaquetarioMedioVPM.getText().contains(".") && VolumenPlaquetarioMedioVPMRe>0 && VolumenPlaquetarioMedioVPMRe<6.8){
        VPMR.setIndentationLeft((float) 326);
        documento.add(VPMR);
        } else {
        if(VolumenPlaquetarioMedioVPMRe>=0 && VolumenPlaquetarioMedioVPMRe<=6) {  
        VPMR.setIndentationLeft((float) 330);
        documento.add(VPMR);
          }
        }
        
        Paragraph VPMR1 = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPMR1.setSpacingBefore((float) -12.5);
        VPMR1.setSpacingAfter(-3);
        
        if(txt_VolumenPlaquetarioMedioVPM.getText().contains(".") && VolumenPlaquetarioMedioVPMRe>6.8 && VolumenPlaquetarioMedioVPMRe<10){
        VPMR1.setIndentationLeft((float) 326);
        documento.add(VPMR1);
        } else {
        if(VolumenPlaquetarioMedioVPMRe>=7 && VolumenPlaquetarioMedioVPMRe<=9) {  
        VPMR1.setIndentationLeft((float) 330);
        documento.add(VPMR1);
          }
        }
        
        Paragraph VPMR2 = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPMR2.setSpacingBefore((float) -12.5);
        VPMR2.setSpacingAfter(-3);
        
        if(txt_VolumenPlaquetarioMedioVPM.getText().contains(".") && VolumenPlaquetarioMedioVPMRe>10 && VolumenPlaquetarioMedioVPMRe<15){
        VPMR2.setIndentationLeft((float) 324);
        documento.add(VPMR2);
        } else {
        if(VolumenPlaquetarioMedioVPMRe>=10 && VolumenPlaquetarioMedioVPMRe<=15) {  
        VPMR2.setIndentationLeft((float) 327);
        documento.add(VPMR2);
          }
        }
        
        Paragraph VPMR3 = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMR3.setSpacingBefore((float) -12.5);
        VPMR3.setSpacingAfter(-3);
        
        if(txt_VolumenPlaquetarioMedioVPM.getText().contains(".") && VolumenPlaquetarioMedioVPMRe>15 && VolumenPlaquetarioMedioVPMRe<100){
        VPMR3.setIndentationLeft((float) 324);
        documento.add(VPMR3);
        } else {
        if(VolumenPlaquetarioMedioVPMRe>=16 && VolumenPlaquetarioMedioVPMRe<=99) {  
        VPMR3.setIndentationLeft((float) 327);
        documento.add(VPMR3);
          }
        }
        
        Paragraph VPMR4 = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMR4.setSpacingBefore((float) -12.5);
        VPMR4.setSpacingAfter(-3);
        
        if(txt_VolumenPlaquetarioMedioVPM.getText().contains(".") && VolumenPlaquetarioMedioVPMRe>100 && VolumenPlaquetarioMedioVPMRe<1000){
        VPMR4.setIndentationLeft((float) 323);
        documento.add(VPMR4);
        } else {
        if(VolumenPlaquetarioMedioVPMRe>=100 && VolumenPlaquetarioMedioVPMRe<=999) {  
        VPMR4.setIndentationLeft((float) 325);
        documento.add(VPMR4);
          }
        }
        
        Paragraph VPMR5 = new  Paragraph (txt_VolumenPlaquetarioMedioVPM.getText() , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMR5.setSpacingBefore((float) -12.5);
        VPMR5.setSpacingAfter(-3);
        
        if(VolumenPlaquetarioMedioVPMRe>1000){
        VPMR5.setIndentationLeft((float) 322);
        documento.add(VPMR5);
        } 
                
        //----------------------------------------------------------------------->
        
        Paragraph VPMV = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMV.setSpacingBefore((float) -12);
        VPMV.setIndentationLeft(386);
        VPMV.setSpacingAfter(-3);
        
        if(VolumenPlaquetarioMedioVPMRe<6.8){
        documento.add(VPMV);
        }
             
        Paragraph VPMV1 = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPMV1.setSpacingBefore((float) -12);
        VPMV1.setIndentationLeft(386);
        VPMV1.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>=6.8 && VolumenPlaquetarioMedioVPMRe<=15){
        documento.add(VPMV1);
        } 
          
        Paragraph VPMV2 = new  Paragraph ("fL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMV2.setSpacingBefore((float) -12);
        VPMV2.setIndentationLeft(386);
        VPMV2.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>15){
        documento.add(VPMV2);
        }
        
        Paragraph VPMref = new  Paragraph ("6.8" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMref.setSpacingBefore((float) -12);
        VPMref.setIndentationLeft((float) 447);
        VPMref.setSpacingAfter(-3);
        
        if(VolumenPlaquetarioMedioVPMRe<6.8){
        documento.add(VPMref);
        }
             
        Paragraph VPMref1 = new  Paragraph ("6.8" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPMref1.setSpacingBefore((float) -12);
        VPMref1.setIndentationLeft((float) 447);
        VPMref1.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>=6.8 && VolumenPlaquetarioMedioVPMRe<=15){
        documento.add(VPMref1);
        } 
          
        Paragraph VPMref2 = new  Paragraph ("6.8" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMref2.setSpacingBefore((float) -12);
        VPMref2.setIndentationLeft((float) 447);
        VPMref2.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>15){
        documento.add(VPMref2);
        }
        
        Paragraph VPMref12 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMref12.setSpacingBefore((float) -12);
        VPMref12.setIndentationLeft((float) 512);
        VPMref12.setSpacingAfter(-3);
        
        if(VolumenPlaquetarioMedioVPMRe<6.8){
        documento.add(VPMref12);
        }
             
        Paragraph VPMref22 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        VPMref22.setSpacingBefore((float) -12);
        VPMref22.setIndentationLeft((float) 512);
        VPMref22.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>=6.8 && VolumenPlaquetarioMedioVPMRe<=15){
        documento.add(VPMref22);
        } 
          
        Paragraph VPMref32 = new  Paragraph ("15" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        VPMref32.setSpacingBefore((float) -12);
        VPMref32.setIndentationLeft((float) 512);
        VPMref32.setSpacingAfter(-3);
   
        if(VolumenPlaquetarioMedioVPMRe>15){
        documento.add(VPMref32);
        }
        
        Paragraph Fórmulablanca = new  Paragraph ("Fórmula blanca:" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Fórmulablanca.setSpacingBefore(10);
        Fórmulablanca.setIndentationLeft(17);
        Fórmulablanca.setSpacingAfter(0);
        documento.add(Fórmulablanca);
        
        Paragraph Absolutos = new  Paragraph ("Absolutos" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Absolutos.setSpacingBefore(-15);
        Absolutos.setIndentationLeft(357);
        Absolutos.setSpacingAfter(-3);
        documento.add(Absolutos);
        
        int LeucocitostotalesTT, NeutrófilosTT, Neutrófilossegmentados1TT, Neutrófilosenbanda1TT, Metamielocitos1TT, Mielocitos1TT, Promielocitos1TT, 
             Blastos1TT, Eosinófilos1TT, Basófilos1TT, Monocitos1TT, Linfocitos1TT;  
        int NeutrófilosTP, Neutrófilossegmentados1TP, Neutrófilosenbanda1TP, Metamielocitos1TP, Mielocitos1TP, Promielocitos1TP, 
             Blastos1TP, Eosinófilos1TP, Basófilos1TP, Monocitos1TP, Linfocitos1TP;
         
        NeutrófilosTP = Integer.parseInt(txt_Neutrófilostotales.getText());
        Neutrófilossegmentados1TP = Integer.parseInt(txt_Neutrófilossegmentados.getText());
        Neutrófilosenbanda1TP = Integer.parseInt(txt_Neutrófilosenbanda.getText());
        Metamielocitos1TP = Integer.parseInt(txt_Metamielocitos.getText());
        Mielocitos1TP = Integer.parseInt(txt_Mielocitos.getText());
        Promielocitos1TP = Integer.parseInt(txt_Promielocitos.getText());
        Blastos1TP = Integer.parseInt(txt_Blastos.getText());
        Eosinófilos1TP = Integer.parseInt(txt_Eosinófilos.getText());
        Basófilos1TP = Integer.parseInt(txt_Basófilos.getText());
        Monocitos1TP = Integer.parseInt(txt_Monocitos.getText());
        Linfocitos1TP = Integer.parseInt(txt_Linfocitos.getText()); 
         
         
        LeucocitostotalesTT = Integer.parseInt(txt_Leucocitostotales1.getText());
        NeutrófilosTT = Integer.parseInt(txt_Neutrófilostotales1.getText());
        Neutrófilossegmentados1TT = Integer.parseInt(txt_Neutrófilossegmentados1.getText());
        Neutrófilosenbanda1TT = Integer.parseInt(txt_Neutrófilosenbanda1.getText());
        Metamielocitos1TT = Integer.parseInt(txt_Metamielocitos1.getText());
        Mielocitos1TT = Integer.parseInt(txt_Mielocitos1.getText());
        Promielocitos1TT = Integer.parseInt(txt_Promielocitos1.getText());
        Blastos1TT = Integer.parseInt(txt_Blastos1.getText());
        Eosinófilos1TT = Integer.parseInt(txt_Eosinófilos1.getText());
        Basófilos1TT = Integer.parseInt(txt_Basófilos1.getText());
        Monocitos1TT = Integer.parseInt(txt_Monocitos1.getText());
        Linfocitos1TT = Integer.parseInt(txt_Linfocitos1.getText());

        Paragraph Leucocitostotales = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Leucocitostotales.setSpacingBefore(3);
        Leucocitostotales.setIndentationLeft(17);
        Leucocitostotales.setSpacingAfter(-3);
        
               if(LeucocitostotalesTT<=9){
        documento.add(Leucocitostotales);
        }
             
        Paragraph Leucocitostotales1 = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Leucocitostotales1.setSpacingBefore(3);
        Leucocitostotales1.setIndentationLeft(17);
        Leucocitostotales1.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=4500 && LeucocitostotalesTT<=13000){
        
        documento.add(Leucocitostotales1);
        } 
          
        Paragraph Leucocitostotales12 = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Leucocitostotales12.setSpacingBefore(3);
        Leucocitostotales12.setIndentationLeft(17);
        Leucocitostotales12.setSpacingAfter(-3);  
   
          if(LeucocitostotalesTT>=10 && LeucocitostotalesTT<4500){
        
        documento.add(Leucocitostotales12);
        } 
        
        Paragraph Leucocitostotales123 = new  Paragraph ("Leucocitos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Leucocitostotales123.setSpacingBefore(3);
        Leucocitostotales123.setIndentationLeft(17);
        Leucocitostotales123.setSpacingAfter(-3);  
   
          if(LeucocitostotalesTT>13000){
        
        documento.add(Leucocitostotales123);
        }   
        
        Paragraph LeucocitostotalesR = new  Paragraph (txt_Leucocitostotales.getText() + " " + "/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesR.setSpacingBefore((float) -12.5);
        LeucocitostotalesR.setIndentationLeft((float) 319);
        LeucocitostotalesR.setSpacingAfter(-3);
        
                  if(LeucocitostotalesTT<=9){
        documento.add(LeucocitostotalesR);
        }
         
          Paragraph LeucocitostotalesR1 = new  Paragraph (txt_Leucocitostotales.getText() + " " + "/uL" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LeucocitostotalesR1.setSpacingBefore((float) -12.5);
        LeucocitostotalesR1.setIndentationLeft((float) 319);
        LeucocitostotalesR1.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=4500 && LeucocitostotalesTT<=13000){
        
        documento.add(LeucocitostotalesR1);
        } 
          
        Paragraph LeucocitostotalesR12 = new  Paragraph (txt_Leucocitostotales.getText() + " " + "/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesR12.setSpacingBefore((float) -12.5);
        LeucocitostotalesR12.setIndentationLeft((float) 319);
        LeucocitostotalesR12.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=10 && LeucocitostotalesTT<4500){
        
        documento.add(LeucocitostotalesR12);
        } 
        
        Paragraph LeucocitostotalesR123 = new  Paragraph (txt_Leucocitostotales.getText() + " " + "/uL" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesR123.setSpacingBefore((float) -12.5);
        LeucocitostotalesR123.setIndentationLeft((float) 319);
        LeucocitostotalesR123.setSpacingAfter(-3); 
   
          if(LeucocitostotalesTT>13000){
        
        documento.add(LeucocitostotalesR123);
        }
                             
        //----------------------------
        
        Paragraph LeucocitostotalesP  = new  Paragraph (txt_Leucocitostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesP.setSpacingBefore((float) -12);
        LeucocitostotalesP.setIndentationLeft(386);
        LeucocitostotalesP.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT<=9){
        
        documento.add(LeucocitostotalesP);
                
        
        }
             
        Paragraph LeucocitostotalesP0  = new  Paragraph (txt_Leucocitostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LeucocitostotalesP0.setSpacingBefore((float) -12);
        LeucocitostotalesP0.setIndentationLeft(380);
        LeucocitostotalesP0.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=4500 && LeucocitostotalesTT<=13000){
        
        documento.add(LeucocitostotalesP0);
        } 
          
          
          Paragraph LeucocitostotalesP2  = new  Paragraph (txt_Leucocitostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesP2.setSpacingBefore((float) -12);
        LeucocitostotalesP2.setIndentationLeft(380);
        LeucocitostotalesP2.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=10 && LeucocitostotalesTT<4500){
        
        documento.add(LeucocitostotalesP2);
        } 
        
           Paragraph LeucocitostotalesP3  = new  Paragraph (txt_Leucocitostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesP3.setSpacingBefore((float) -12);
        LeucocitostotalesP3.setIndentationLeft(380);
        LeucocitostotalesP3.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>13000){
        
        documento.add(LeucocitostotalesP3);
        }   
        
        Paragraph LeucocitostotalesV = new  Paragraph ("4500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV.setSpacingBefore((float) -12);
        LeucocitostotalesV.setIndentationLeft((float) 439);
        LeucocitostotalesV.setSpacingAfter(-3);
        
                if(LeucocitostotalesTT<=9){
        
        documento.add(LeucocitostotalesV);
    
        }
             
        Paragraph LeucocitostotalesV1 = new  Paragraph ("4500" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LeucocitostotalesV1.setSpacingBefore((float) -12);
        LeucocitostotalesV1.setIndentationLeft((float) 439);
        LeucocitostotalesV1.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=4500 && LeucocitostotalesTT<=13000){
        
        documento.add(LeucocitostotalesV1);
        } 
          
          
        Paragraph LeucocitostotalesV12 = new  Paragraph ("4500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV12.setSpacingBefore((float) -12);
        LeucocitostotalesV12.setIndentationLeft((float) 439);
        LeucocitostotalesV12.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=10 && LeucocitostotalesTT<4500){
        
        documento.add(LeucocitostotalesV12);
        } 
        
        Paragraph LeucocitostotalesV123 = new  Paragraph ("4500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV123.setSpacingBefore((float) -12);
        LeucocitostotalesV123.setIndentationLeft((float) 439);
        LeucocitostotalesV123.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>13000){
        
        documento.add(LeucocitostotalesV123);
        }   
        
        Paragraph LeucocitostotalesV2 = new  Paragraph ("13000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV2.setSpacingBefore((float) -12);
        LeucocitostotalesV2.setIndentationLeft((float) 503);
        LeucocitostotalesV2.setSpacingAfter(-3);
        
                        if(LeucocitostotalesTT<=9){
        
        documento.add(LeucocitostotalesV2);
    
        }
             
        Paragraph LeucocitostotalesV21 = new  Paragraph ("13000" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LeucocitostotalesV21.setSpacingBefore((float) -12);
        LeucocitostotalesV21.setIndentationLeft((float) 503);
        LeucocitostotalesV21.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=4500 && LeucocitostotalesTT<=13000){
        
        documento.add(LeucocitostotalesV21);
        } 
            
        Paragraph LeucocitostotalesV212 = new  Paragraph ("13000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV212.setSpacingBefore((float) -12);
        LeucocitostotalesV212.setIndentationLeft((float) 503);
        LeucocitostotalesV212.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>=10 && LeucocitostotalesTT<4500){
        
        documento.add(LeucocitostotalesV212);
        } 
        
        Paragraph LeucocitostotalesV2123 = new  Paragraph ("13000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LeucocitostotalesV2123.setSpacingBefore((float) -12);
        LeucocitostotalesV2123.setIndentationLeft((float) 503);
        LeucocitostotalesV2123.setSpacingAfter(-3);
   
          if(LeucocitostotalesTT>13000){
        
        documento.add(LeucocitostotalesV2123);
        }  
        
        Paragraph NeutrófilosT = new  Paragraph ("Neutrófilos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosT.setSpacingBefore(2);
        NeutrófilosT.setIndentationLeft(17);
        NeutrófilosT.setSpacingAfter(-3);
        
            if(NeutrófilosTT<=9){
        
        documento.add(NeutrófilosT);
                 
        }
             
        Paragraph NeutrófilosT1 = new  Paragraph ("Neutrófilos totales" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosT1.setSpacingBefore(2);
        NeutrófilosT1.setIndentationLeft(17);
        NeutrófilosT1.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000){
        
        documento.add(NeutrófilosT1);
        } 
               
        Paragraph NeutrófilosT2 = new  Paragraph ("Neutrófilos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosT2.setSpacingBefore(2);
        NeutrófilosT2.setIndentationLeft(17);
        NeutrófilosT2.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800){
        
        documento.add(NeutrófilosT2);
        } 
        
        Paragraph NeutrófilosT3 = new  Paragraph ("Neutrófilos totales" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosT3.setSpacingBefore(2);
        NeutrófilosT3.setIndentationLeft(17);
        NeutrófilosT3.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000){
        
        documento.add(NeutrófilosT3);
        }   
        
        Paragraph NeutrófilosTR = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTR.setSpacingBefore((float) -12.5);
        NeutrófilosTR.setIndentationLeft((float) 327);
        NeutrófilosTR.setSpacingAfter(-3);
        
        if(NeutrófilosTT<=9 && NeutrófilosTP<=9){
        
        documento.add(NeutrófilosTR);
                 
        }
             
        Paragraph NeutrófilosTR1 = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosTR1.setSpacingBefore((float) -12.5);
        NeutrófilosTR1.setIndentationLeft((float) 327);
        NeutrófilosTR1.setSpacingAfter(-3);
   
        if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000 && NeutrófilosTP<=9){
        
        documento.add(NeutrófilosTR1);
        } 
               
        Paragraph NeutrófilosTR2 = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTR2.setSpacingBefore((float) -12.5);
        NeutrófilosTR2.setIndentationLeft((float) 327);
        NeutrófilosTR2.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800 && NeutrófilosTP<=9){
        
        documento.add(NeutrófilosTR2);
        } 
        
        Paragraph NeutrófilosTR3 = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTR3.setSpacingBefore((float) -12.5);
        NeutrófilosTR3.setIndentationLeft((float) 327);
        NeutrófilosTR3.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000 && NeutrófilosTP<=9){
        
        documento.add(NeutrófilosTR3);
        } 
        
        Paragraph NeutrófilosTRM = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTRM.setSpacingBefore((float) -12.5);
        NeutrófilosTRM.setIndentationLeft((float) 322);
        NeutrófilosTRM.setSpacingAfter(-3);
        
         if(NeutrófilosTT<=9 && NeutrófilosTP>=10){
        
        documento.add(NeutrófilosTRM);
                 
        }
             
        Paragraph NeutrófilosTR1M = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosTR1M.setSpacingBefore((float) -12.5);
        NeutrófilosTR1M.setIndentationLeft((float) 322);
        NeutrófilosTR1M.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000 && NeutrófilosTP>=10){
        
        documento.add(NeutrófilosTR1M);
        } 
               
        Paragraph NeutrófilosTR2M = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTR2M.setSpacingBefore((float) -12.5);
        NeutrófilosTR2M.setIndentationLeft((float) 322);
        NeutrófilosTR2M.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800 && NeutrófilosTP>=10){
        
        documento.add(NeutrófilosTR2M);
        } 
        
        Paragraph NeutrófilosTR3M = new  Paragraph (txt_Neutrófilostotales.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTR3M.setSpacingBefore((float) -12.5);
        NeutrófilosTR3M.setIndentationLeft((float) 322);
        NeutrófilosTR3M.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000 && NeutrófilosTP>=10){
        
        documento.add(NeutrófilosTR3M);
        }   
        
        Paragraph NeutrófilosTV = new  Paragraph (txt_Neutrófilostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTV.setSpacingBefore((float) -12);
        NeutrófilosTV.setIndentationLeft(386);
        NeutrófilosTV.setSpacingAfter(-3);    
   
          if(NeutrófilosTT<=9){
        
        documento.add(NeutrófilosTV);
                 
        }
             
        Paragraph NeutrófilosTV1 = new  Paragraph (txt_Neutrófilostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosTV1.setSpacingBefore((float) -12);
        NeutrófilosTV1.setIndentationLeft(380);
        NeutrófilosTV1.setSpacingAfter(-3); 
   
          if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000){
        
        documento.add(NeutrófilosTV1);
        } 
               
        Paragraph NeutrófilosTV2 = new  Paragraph (txt_Neutrófilostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTV2.setSpacingBefore((float) -12);
        NeutrófilosTV2.setIndentationLeft(380);
        NeutrófilosTV2.setSpacingAfter(-3); 
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800){
        
        documento.add(NeutrófilosTV2);
        } 
        
        Paragraph NeutrófilosTV3 = new  Paragraph (txt_Neutrófilostotales1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTV3.setSpacingBefore((float) -12);
        NeutrófilosTV3.setIndentationLeft(380);
        NeutrófilosTV3.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000){
        
        documento.add(NeutrófilosTV3);
        }   
        
        Paragraph NeutrófilosTref = new  Paragraph ("1800" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref.setSpacingBefore((float) -12);
        NeutrófilosTref.setIndentationLeft((float) 439);
        NeutrófilosTref.setSpacingAfter(-3);
        
                    if(NeutrófilosTT<=9){
        
        documento.add(NeutrófilosTref);
                 
        }
             
        Paragraph NeutrófilosTref1 = new  Paragraph ("1800" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosTref1.setSpacingBefore((float) -12);
        NeutrófilosTref1.setIndentationLeft((float) 439);
        NeutrófilosTref1.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000){
        
        documento.add(NeutrófilosTref1);
        } 
               
        Paragraph NeutrófilosTref22 = new  Paragraph ("1800" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref22.setSpacingBefore((float) -12);
        NeutrófilosTref22.setIndentationLeft((float) 439);
        NeutrófilosTref22.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800){
        
        documento.add(NeutrófilosTref22);
        } 
        
        Paragraph NeutrófilosTref3 = new  Paragraph ("1800" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref3.setSpacingBefore((float) -12);
        NeutrófilosTref3.setIndentationLeft((float) 439);
        NeutrófilosTref3.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000){
        
        documento.add(NeutrófilosTref3);
        }   
        
        Paragraph NeutrófilosTref2 = new  Paragraph ("8000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref2.setSpacingBefore((float) -12);
        NeutrófilosTref2.setIndentationLeft((float) 508.5);
        NeutrófilosTref2.setSpacingAfter(-3);
        
                            if(NeutrófilosTT<=9){
        documento.add(NeutrófilosTref2);         
        }
             
        Paragraph NeutrófilosTref21 = new  Paragraph ("8000" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosTref21.setSpacingBefore((float) -12);
        NeutrófilosTref21.setIndentationLeft((float) 508.5);
        NeutrófilosTref21.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=1800 && NeutrófilosTT<=8000){
        
        documento.add(NeutrófilosTref21);
        } 
               
        Paragraph NeutrófilosTref212 = new  Paragraph ("8000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref212.setSpacingBefore((float) -12);
        NeutrófilosTref212.setIndentationLeft((float) 508.5);
        NeutrófilosTref212.setSpacingAfter(-3);
   
          if(NeutrófilosTT>=10 && NeutrófilosTT<1800){
        
        documento.add(NeutrófilosTref212);
        } 
        
        Paragraph NeutrófilosTref2123 = new  Paragraph ("8000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosTref2123.setSpacingBefore((float) -12);
        NeutrófilosTref2123.setIndentationLeft((float) 508.5);
        NeutrófilosTref2123.setSpacingAfter(-3);
   
          if(NeutrófilosTT>8000){
        
        documento.add(NeutrófilosTref2123);
        } 
   
        Paragraph NeutrófilosS = new  Paragraph ("Neutrófilos segmentados", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosS.setSpacingBefore(2);
        NeutrófilosS.setIndentationLeft(17);
        NeutrófilosS .setSpacingAfter(-3);
              
          if(Neutrófilossegmentados1TT<=9){
        
        documento.add(NeutrófilosS);
                 
        }
             
        Paragraph NeutrófilosS1 = new  Paragraph ("Neutrófilos segmentados", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosS1.setSpacingBefore(2);
        NeutrófilosS1.setIndentationLeft(17);
        NeutrófilosS1 .setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000){
        
        documento.add(NeutrófilosS1);
        } 
               
        Paragraph NeutrófilosS2 = new  Paragraph ("Neutrófilos segmentados", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosS2.setSpacingBefore(2);
        NeutrófilosS2.setIndentationLeft(17);
        NeutrófilosS2.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700){
        
        documento.add(NeutrófilosS2);
        } 
        
        Paragraph NeutrófilosS3 = new  Paragraph ("Neutrófilos segmentados", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosS3.setSpacingBefore(2);
        NeutrófilosS3.setIndentationLeft(17);
        NeutrófilosS3.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>7000){
        
        documento.add(NeutrófilosS3);
        }   
        
        Paragraph NeutrófilosSR = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSR.setSpacingBefore((float) -12.5);
        NeutrófilosSR.setIndentationLeft((float) 327);
        NeutrófilosSR.setSpacingAfter(-3);
                
          if(Neutrófilossegmentados1TT<=9 && Neutrófilossegmentados1TP<=9){
        
        documento.add(NeutrófilosSR);
                 
        }
             
        Paragraph NeutrófilosSR1 = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosSR1.setSpacingBefore((float) -12.5);
        NeutrófilosSR1.setIndentationLeft((float) 327);
        NeutrófilosSR1.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000 && Neutrófilossegmentados1TP<=9){
        
        documento.add(NeutrófilosSR1);
        } 
               
        Paragraph NeutrófilosSR2 = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSR2.setSpacingBefore((float) -12.5);
        NeutrófilosSR2.setIndentationLeft((float) 327);
        NeutrófilosSR2.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700 && Neutrófilossegmentados1TP<=9){
        
        documento.add(NeutrófilosSR2);
        } 
        
        Paragraph NeutrófilosSR3 = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSR3.setSpacingBefore((float) -12.5);
        NeutrófilosSR3.setIndentationLeft((float) 327);
        NeutrófilosSR3.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>7000 && Neutrófilossegmentados1TP<=9){
        
        documento.add(NeutrófilosSR3);
        }   
        
        Paragraph NeutrófilosSRP = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSRP.setSpacingBefore((float) -12.5);
        NeutrófilosSRP.setIndentationLeft((float) 322);
        NeutrófilosSRP.setSpacingAfter(-3);
                
          if(Neutrófilossegmentados1TT<=9 && Neutrófilossegmentados1TP>=10){
        
        documento.add(NeutrófilosSRP);
                 
        }
             
        Paragraph NeutrófilosSR1P = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosSR1P.setSpacingBefore((float) -12.5);
        NeutrófilosSR1P.setIndentationLeft((float) 322);
        NeutrófilosSR1P.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000 && Neutrófilossegmentados1TP>=10){
        
        documento.add(NeutrófilosSR1P);
        } 
               
        Paragraph NeutrófilosSR2P = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSR2P.setSpacingBefore((float) -12.5);
        NeutrófilosSR2P.setIndentationLeft((float) 322);
        NeutrófilosSR2P.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700 && Neutrófilossegmentados1TP>=10){
        
        documento.add(NeutrófilosSR2P);
        } 
        
        Paragraph NeutrófilosSR3P = new  Paragraph (txt_Neutrófilossegmentados.getText() + "%" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSR3P.setSpacingBefore((float) -12.5);
        NeutrófilosSR3P.setIndentationLeft((float) 322);
        NeutrófilosSR3P.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>7000 && Neutrófilossegmentados1TP>=10){
        
        documento.add(NeutrófilosSR3P);
        }   
        
        Paragraph NeutrófilosSV = new  Paragraph (txt_Neutrófilossegmentados1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSV.setSpacingBefore((float) -12);
        NeutrófilosSV.setIndentationLeft(386);
        NeutrófilosSV.setSpacingAfter(-3);
     
          if(Neutrófilossegmentados1TT<=9){
        
        documento.add(NeutrófilosSV);
                 
        }
             
        Paragraph NeutrófilosSV1 = new  Paragraph (txt_Neutrófilossegmentados1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosSV1.setSpacingBefore((float) -12);
        NeutrófilosSV1.setIndentationLeft(380);
        NeutrófilosSV1.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000){
        
        documento.add(NeutrófilosSV1);
        } 
               
        Paragraph NeutrófilosSV2 = new  Paragraph (txt_Neutrófilossegmentados1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSV2.setSpacingBefore((float) -12);
        NeutrófilosSV2.setIndentationLeft(380);
        NeutrófilosSV2.setSpacingAfter(-3); 
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700){
        
        documento.add(NeutrófilosSV2);
        } 
        
        Paragraph NeutrófilosSV3 = new  Paragraph (txt_Neutrófilossegmentados1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSV3.setSpacingBefore((float) -12);
        NeutrófilosSV3.setIndentationLeft(380);
        NeutrófilosSV3.setSpacingAfter(-3); 
   
          if(Neutrófilossegmentados1TT>7000){
        
        documento.add(NeutrófilosSV3);
        }   
        
        Paragraph NeutrófilosSVref = new  Paragraph ("1700" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSVref.setSpacingBefore((float) -12);
        NeutrófilosSVref.setIndentationLeft((float) 439);
        NeutrófilosSVref.setSpacingAfter(-3);
        
          if(Neutrófilossegmentados1TT<=9){
        
        documento.add(NeutrófilosSVref);
                 
        }
             
        Paragraph NeutrófilosSVref1 = new  Paragraph ("1700" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosSVref1.setSpacingBefore((float) -12);
        NeutrófilosSVref1.setIndentationLeft((float) 439);
        NeutrófilosSVref1.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000){
        
        documento.add(NeutrófilosSVref1);
        } 
               
        Paragraph NeutrófilosSVref2 = new  Paragraph ("1700" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSVref2.setSpacingBefore((float) -12);
        NeutrófilosSVref2.setIndentationLeft((float) 439);
        NeutrófilosSVref2.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700){
        
        documento.add(NeutrófilosSVref2);
        } 
        
        Paragraph NeutrófilosSVref3 = new  Paragraph ("1700" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSVref3.setSpacingBefore((float) -12);
        NeutrófilosSVref3.setIndentationLeft((float) 439);
        NeutrófilosSVref3.setSpacingAfter(-3); 
   
          if(Neutrófilossegmentados1TT>7000){
        
        documento.add(NeutrófilosSVref3);
        }   
        
        Paragraph NeutrófilosSref2 = new  Paragraph ("7000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSref2.setSpacingBefore((float) -12);
        NeutrófilosSref2.setIndentationLeft((float) 508.5);
        NeutrófilosSref2.setSpacingAfter(-3);
         
              if(Neutrófilossegmentados1TT<=9){
        
        documento.add(NeutrófilosSref2);
                 
        }
             
        Paragraph NeutrófilosSref21 = new  Paragraph ("7000" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosSref21.setSpacingBefore((float) -12);
        NeutrófilosSref21.setIndentationLeft((float) 508.5);
        NeutrófilosSref21.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=1700 && Neutrófilossegmentados1TT<=7000){
        
        documento.add(NeutrófilosSref21);
        } 
               
        Paragraph NeutrófilosSref22 = new  Paragraph ("7000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSref22.setSpacingBefore((float) -12);
        NeutrófilosSref22.setIndentationLeft((float) 508.5);
        NeutrófilosSref22.setSpacingAfter(-3);
   
          if(Neutrófilossegmentados1TT>=10 && Neutrófilossegmentados1TT<1700){
        
        documento.add(NeutrófilosSref22);
        } 
        
        Paragraph NeutrófilosSref23 = new  Paragraph ("7000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosSref23.setSpacingBefore((float) -12);
        NeutrófilosSref23.setIndentationLeft((float) 508.5);
        NeutrófilosSref23.setSpacingAfter(-3); 
   
          if(Neutrófilossegmentados1TT>7000){
        
        documento.add(NeutrófilosSref23);
        }   
        
        Paragraph NeutrófilosB = new  Paragraph ("Neutrófilos en banda", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosB.setSpacingBefore(2);
        NeutrófilosB.setIndentationLeft(17);
        NeutrófilosB.setSpacingAfter(-3);
        
                if(Neutrófilosenbanda1TT<=9){
        
        documento.add(NeutrófilosB);
                 
        }
             
        Paragraph NeutrófilosB1 = new  Paragraph ("Neutrófilos en banda", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosB1.setSpacingBefore(2);
        NeutrófilosB1.setIndentationLeft(17);
        NeutrófilosB1.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700){
        
        documento.add(NeutrófilosB1);
        } 
        
        Paragraph NeutrófilosB2 = new  Paragraph ("Neutrófilos en banda", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosB2.setSpacingBefore(2);
        NeutrófilosB2.setIndentationLeft(17);
        NeutrófilosB2.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>700){
        
        documento.add(NeutrófilosB2);
        }  
        
        Paragraph NeutrófilosBR = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBR.setSpacingBefore((float) -12.5);
        NeutrófilosBR.setIndentationLeft((float) 327);
        NeutrófilosBR.setSpacingAfter(-3);
        
        if(Neutrófilosenbanda1TT<=9 && Neutrófilosenbanda1TP<=9){
        
        documento.add(NeutrófilosBR);
                 
        }
             
        Paragraph NeutrófilosBR1 = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBR1.setSpacingBefore((float) -12.5);
        NeutrófilosBR1.setIndentationLeft((float) 327);
        NeutrófilosBR1.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700 && Neutrófilosenbanda1TP<=9){
              
        documento.add(NeutrófilosBR1);
        
        } 
        
        Paragraph NeutrófilosBR2 = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosBR2.setSpacingBefore((float) -12.5);
        NeutrófilosBR2.setIndentationLeft((float) 327);
        NeutrófilosBR2.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>700 && Neutrófilosenbanda1TP<=9){
        
        documento.add(NeutrófilosBR2);
        } 
        
        Paragraph NeutrófilosBRP = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBRP.setSpacingBefore((float) -12.5);
        NeutrófilosBRP.setIndentationLeft((float) 322);
        NeutrófilosBRP.setSpacingAfter(-3);
        
        if(Neutrófilosenbanda1TT<=9 && Neutrófilosenbanda1TP>=10){
        
        documento.add(NeutrófilosBRP);
                 
        }
             
        Paragraph NeutrófilosBR1P = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBR1P.setSpacingBefore((float) -12.5);
        NeutrófilosBR1P.setIndentationLeft((float) 322);
        NeutrófilosBR1P.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700 && Neutrófilosenbanda1TP>=10){
              
        documento.add(NeutrófilosBR1P);
        
        } 
        
        Paragraph NeutrófilosBR2P = new  Paragraph (txt_Neutrófilosenbanda.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosBR2P.setSpacingBefore((float) -12.5);
        NeutrófilosBR2P.setIndentationLeft((float) 322);
        NeutrófilosBR2P.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>700 && Neutrófilosenbanda1TP>=10){
        
        documento.add(NeutrófilosBR2P);
        } 
        
        Paragraph NeutrófilosBV = new  Paragraph (txt_Neutrófilosenbanda1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBV.setSpacingBefore((float) -12);
        NeutrófilosBV.setIndentationLeft(386);
        NeutrófilosBV.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT<=9){
        
        documento.add(NeutrófilosBV);
                 
        }
             
        Paragraph NeutrófilosBV1 = new  Paragraph (txt_Neutrófilosenbanda1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBV1.setSpacingBefore((float) -12);
        NeutrófilosBV1.setIndentationLeft(380);
        NeutrófilosBV1.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700){
        
        documento.add(NeutrófilosBV1);
        } 
        
        Paragraph NeutrófilosBV2 = new  Paragraph (txt_Neutrófilosenbanda1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosBV2.setSpacingBefore((float) -12);
        NeutrófilosBV2.setIndentationLeft(380);
        NeutrófilosBV2.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>700){
        
        documento.add(NeutrófilosBV2);
        }  
        
        Paragraph NeutrófilosBref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBref.setSpacingBefore((float) -12);
        NeutrófilosBref.setIndentationLeft((float) 456);
        NeutrófilosBref.setSpacingAfter(-3);
        
         if(Neutrófilosenbanda1TT<=9){
        
        documento.add(NeutrófilosBref);
                 
        }
             
        Paragraph NeutrófilosBref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBref1.setSpacingBefore((float) -12);
        NeutrófilosBref1.setIndentationLeft((float) 456);
        NeutrófilosBref1.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700){
        
        documento.add(NeutrófilosBref1);
        } 
        
        Paragraph NeutrófilosBref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosBref2.setSpacingBefore((float) -12);
        NeutrófilosBref2.setIndentationLeft((float) 456);
        NeutrófilosBref2.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>700){
        
        documento.add(NeutrófilosBref2);
        }
        
        Paragraph NeutrófilosBref21 = new  Paragraph ("700" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBref21.setSpacingBefore((float) -12);
        NeutrófilosBref21.setIndentationLeft((float) 514);
        NeutrófilosBref21.setSpacingAfter(-3);
        
        if(Neutrófilosenbanda1TT<=9){
        
        documento.add(NeutrófilosBref21);
                 
        }
             
        Paragraph NeutrófilosBref212 = new  Paragraph ("700" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        NeutrófilosBref212.setSpacingBefore((float) -12);
        NeutrófilosBref212.setIndentationLeft((float) 514);
        NeutrófilosBref212.setSpacingAfter(-3);
   
          if(Neutrófilosenbanda1TT>=10 && Neutrófilosenbanda1TT<=700){
        
        documento.add(NeutrófilosBref212);
        } 
        
        Paragraph NeutrófilosBref23 = new  Paragraph ("700" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        NeutrófilosBref23.setSpacingBefore((float) -12);
        NeutrófilosBref23.setIndentationLeft((float) 514);
        NeutrófilosBref23.setSpacingAfter(-3);

          if(Neutrófilosenbanda1TT>700){
        
        documento.add(NeutrófilosBref23);
        }
        
        Paragraph Metamielocitos = new  Paragraph ("Metamielocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Metamielocitos.setSpacingBefore(2);
        Metamielocitos.setIndentationLeft(17);
        Metamielocitos.setSpacingAfter(-3);
        
                 if(Metamielocitos1TT==0){
        
        documento.add(Metamielocitos);
                 
        }
             
        Paragraph Metamielocitos1 = new  Paragraph ("Metamielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitos1.setSpacingBefore(2);
        Metamielocitos1.setIndentationLeft(17);
        Metamielocitos1.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9){
        
        documento.add(Metamielocitos1);
        } 
          
        Paragraph Metamielocitos2 = new  Paragraph ("Metamielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitos2.setSpacingBefore(2);
        Metamielocitos2.setIndentationLeft(17);
        Metamielocitos2.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10){
        
        documento.add(Metamielocitos2);
        }   
        
        Paragraph MetamielocitosR = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MetamielocitosR.setSpacingBefore((float) -12.5);
        MetamielocitosR.setIndentationLeft((float) 327);
        MetamielocitosR.setSpacingAfter(-3);
        
          if(Metamielocitos1TT==0 && Metamielocitos1TP<=9){
        
        documento.add(MetamielocitosR);        
        }
             
        Paragraph MetamielocitosR1 = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosR1.setSpacingBefore((float) -12.5);
        MetamielocitosR1.setIndentationLeft((float) 327);
        MetamielocitosR1.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9 && Metamielocitos1TP<=9){
        
        documento.add(MetamielocitosR1);
        } 
          
        Paragraph MetamielocitosR2 = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosR2.setSpacingBefore((float) -12.5);
        MetamielocitosR2.setIndentationLeft((float) 327);
        MetamielocitosR2.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10 && Metamielocitos1TP<=9){
        
        documento.add(MetamielocitosR2);
        }   
        
        Paragraph MetamielocitosRP = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MetamielocitosRP.setSpacingBefore((float) -12.5);
        MetamielocitosRP.setIndentationLeft((float) 322);
        MetamielocitosRP.setSpacingAfter(-3);
        
                         if(Metamielocitos1TT==0 && Metamielocitos1TP>=10){
        
        documento.add(MetamielocitosRP);        
        }
             
        Paragraph MetamielocitosR1P = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosR1P.setSpacingBefore((float) -12.5);
        MetamielocitosR1P.setIndentationLeft((float) 322);
        MetamielocitosR1P.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9 && Metamielocitos1TP>=10){
        
        documento.add(MetamielocitosR1P);
        } 
          
        Paragraph MetamielocitosR2P = new  Paragraph (txt_Metamielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosR2P.setSpacingBefore((float) -12.5);
        MetamielocitosR2P.setIndentationLeft((float) 322);
        MetamielocitosR2P.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10 && Metamielocitos1TP>=10){
        
        documento.add(MetamielocitosR2P);
        }   
        
               Paragraph MetamielocitosV = new  Paragraph (txt_Metamielocitos1.getText() + " "+ "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MetamielocitosV.setSpacingBefore((float) -12);
        MetamielocitosV.setIndentationLeft(386);
        MetamielocitosV.setSpacingAfter(-3);
             
          if(Metamielocitos1TT==0){
        
        documento.add(MetamielocitosV);
                 
        }
             
        Paragraph MetamielocitosV1 = new  Paragraph (txt_Metamielocitos1.getText() + " "+ "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosV1.setSpacingBefore((float) -12);
        MetamielocitosV1.setIndentationLeft(386);
        MetamielocitosV1.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9){
        
        documento.add(MetamielocitosV1);
        } 
          
        Paragraph MetamielocitosV12 = new  Paragraph (txt_Metamielocitos1.getText() + " "+ "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MetamielocitosV12.setSpacingBefore((float) -12);
        MetamielocitosV12.setIndentationLeft(380);
        MetamielocitosV12.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10){
        
        documento.add(MetamielocitosV12);
        }   
        
             Paragraph Metamielocitosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Metamielocitosref.setSpacingBefore((float) -12);
        Metamielocitosref.setIndentationLeft((float) 456);
        Metamielocitosref.setSpacingAfter(-3);
        
        if(Metamielocitos1TT==0){
        
        documento.add(Metamielocitosref);
                 
        }
             
        Paragraph Metamielocitosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitosref1.setSpacingBefore((float) -12);
        Metamielocitosref1.setIndentationLeft((float) 456);
        Metamielocitosref1.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9){
        
        documento.add(Metamielocitosref1);
        } 
          
        Paragraph Metamielocitosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitosref2.setSpacingBefore((float) -12);
        Metamielocitosref2.setIndentationLeft((float) 456);
        Metamielocitosref2.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10){
        
        documento.add(Metamielocitosref2);
        } 
        
        
        Paragraph Metamielocitosref2P = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Metamielocitosref2P.setSpacingBefore((float) -12);
        Metamielocitosref2P.setIndentationLeft((float) 525.5);
        Metamielocitosref2P.setSpacingAfter(-3);
      
        
               if(Metamielocitos1TT==0){
        
        documento.add(Metamielocitosref2P);
                 
        }
             
        Paragraph Metamielocitosref2P2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitosref2P2.setSpacingBefore((float) -12);
        Metamielocitosref2P2.setIndentationLeft((float) 525.5);
        Metamielocitosref2P2.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=1 && Metamielocitos1TT<=9){
        
        documento.add(Metamielocitosref2P2);
        } 
          
        Paragraph Metamielocitosref2P3 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Metamielocitosref2P3.setSpacingBefore((float) -12);
        Metamielocitosref2P3.setIndentationLeft((float) 525.5);
        Metamielocitosref2P3.setSpacingAfter(-3);
   
          if(Metamielocitos1TT>=10){
        
        documento.add(Metamielocitosref2P3);
        } 
        
        Paragraph Mielocitos = new  Paragraph ("Mielocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Mielocitos.setSpacingBefore(2);
        Mielocitos.setIndentationLeft(17);
        Mielocitos.setSpacingAfter(-3);
        
                    if(Mielocitos1TT==0){
        
        documento.add(Mielocitos);         
        }
             
        Paragraph Mielocitos1 = new  Paragraph ("Mielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitos1.setSpacingBefore(2);
        Mielocitos1.setIndentationLeft(17);
        Mielocitos1.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9){
        
        documento.add(Mielocitos1);
        } 
          
        Paragraph Mielocitos2 = new  Paragraph ("Mielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitos2.setSpacingBefore(2);
        Mielocitos2.setIndentationLeft(17);
        Mielocitos2.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10){
        
        documento.add(Mielocitos2);
        } 
          
        Paragraph MielocitosR = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MielocitosR.setSpacingBefore((float) -12.5);
        MielocitosR.setIndentationLeft((float) 327);
        MielocitosR.setSpacingAfter(-3);
        
                     if(Mielocitos1TT==0 && Mielocitos1TP<=9){
        
        documento.add(MielocitosR);
                 
        }
             
        Paragraph MielocitosR1 = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosR1.setSpacingBefore((float) -12.5);
        MielocitosR1.setIndentationLeft((float) 327);
        MielocitosR1.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9 && Mielocitos1TP<=9){
        
        documento.add(MielocitosR1);
        } 
          
        Paragraph MielocitosR2 = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosR2.setSpacingBefore((float) -12.5);
        MielocitosR2.setIndentationLeft((float) 327);
        MielocitosR2.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10 && Mielocitos1TP<=9){
        
        documento.add(MielocitosR2);
        } 
          
         Paragraph MielocitosRP = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MielocitosRP.setSpacingBefore((float) -12.5);
        MielocitosRP.setIndentationLeft((float) 322);
        MielocitosRP.setSpacingAfter(-3);
        
                     if(Mielocitos1TT==0 && Mielocitos1TP>=10){
        
        documento.add(MielocitosRP);
                 
        }
             
        Paragraph MielocitosR1P = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosR1P.setSpacingBefore((float) -12.5);
        MielocitosR1P.setIndentationLeft((float) 322);
        MielocitosR1P.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9 && Mielocitos1TP>=10){
        
        documento.add(MielocitosR1P);
        } 
          
        Paragraph MielocitosR2P = new  Paragraph (txt_Mielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosR2P.setSpacingBefore((float) -12.5);
        MielocitosR2P.setIndentationLeft((float) 322);
        MielocitosR2P.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10 && Mielocitos1TP>=10){
        
        documento.add(MielocitosR2P);
        }   
          
        
        Paragraph MielocitosV = new  Paragraph (txt_Mielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MielocitosV.setSpacingBefore((float) -12);
        MielocitosV.setIndentationLeft(386);
        MielocitosV.setSpacingAfter(-3);
        
              if(Mielocitos1TT==0){
        
        documento.add(MielocitosV);
                 
        }
             
        Paragraph MielocitosV1 = new  Paragraph (txt_Mielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosV1.setSpacingBefore((float) -12);
        MielocitosV1.setIndentationLeft(386);
        MielocitosV1.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9){
        
        documento.add(MielocitosV1);
        } 
          
        Paragraph MielocitosV12 = new  Paragraph (txt_Mielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MielocitosV12.setSpacingBefore((float) -12);
        MielocitosV12.setIndentationLeft(380);
        MielocitosV12.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10){
        
        documento.add(MielocitosV12);
        } 
        
        Paragraph Mielocitosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Mielocitosref.setSpacingBefore((float) -12);
        Mielocitosref.setIndentationLeft((float) 456);
        Mielocitosref.setSpacingAfter(-3);
        
                    if(Mielocitos1TT==0){
        
        documento.add(Mielocitosref);           
        }
             
        Paragraph Mielocitosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitosref1.setSpacingBefore((float) -12);
        Mielocitosref1.setIndentationLeft((float) 456);
        Mielocitosref1.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9){
        
        documento.add(Mielocitosref1);
        } 
          
        Paragraph Mielocitosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitosref2.setSpacingBefore((float) -12);
        Mielocitosref2.setIndentationLeft((float) 456);
        Mielocitosref2.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10){
        
        documento.add(Mielocitosref2);
        } 
        
        Paragraph Mielocitosref4 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Mielocitosref4.setSpacingBefore((float) -12);
        Mielocitosref4.setIndentationLeft((float) 525.5);
        Mielocitosref4.setSpacingAfter(-3);

                            if(Mielocitos1TT==0){
        
        documento.add(Mielocitosref4);           
        }
             
        Paragraph Mielocitosref5 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitosref5.setSpacingBefore((float) -12);
        Mielocitosref5.setIndentationLeft((float) 525.5);
        Mielocitosref5.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=1 && Mielocitos1TT<=9){
        
        documento.add(Mielocitosref5);
        } 
          
        Paragraph Mielocitosref6 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Mielocitosref6.setSpacingBefore((float) -12);
        Mielocitosref6.setIndentationLeft((float) 525.5);
        Mielocitosref6.setSpacingAfter(-3);
   
          if(Mielocitos1TT>=10){
        
        documento.add(Mielocitosref6);
        }      
        
            Paragraph Promielocitos = new  Paragraph ("Promielocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Promielocitos.setSpacingBefore(2);
        Promielocitos.setIndentationLeft(17);
        Promielocitos.setSpacingAfter(-3);
       
                       if(Promielocitos1TT==0){
        
        documento.add(Promielocitos);            
        }
             
        Paragraph Promielocitos1 = new  Paragraph ("Promielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitos1.setSpacingBefore(2);
        Promielocitos1.setIndentationLeft(17);
        Promielocitos1.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9){
        
        documento.add(Promielocitos1);
        } 
          
        Paragraph Promielocitos2 = new  Paragraph ("Promielocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitos2.setSpacingBefore(2);
        Promielocitos2.setIndentationLeft(17);
        Promielocitos2.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10){
        
        documento.add(Promielocitos2);
        } 
         
        Paragraph PromielocitosR = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        PromielocitosR.setSpacingBefore((float) -12.5);
        PromielocitosR.setIndentationLeft((float) 327);
        PromielocitosR.setSpacingAfter(-3);
        
        if(Promielocitos1TT==0 && Promielocitos1TP<=9){
        
        documento.add(PromielocitosR);            
        }
             
        Paragraph PromielocitosR1 = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosR1.setSpacingBefore((float) -12.5);
        PromielocitosR1.setIndentationLeft((float) 327);
        PromielocitosR1.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9 && Promielocitos1TP<=9){
        
        documento.add(PromielocitosR1);
        } 
          
        Paragraph PromielocitosR2 = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosR2.setSpacingBefore((float) -12.5);
        PromielocitosR2.setIndentationLeft((float) 327);
        PromielocitosR2.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10 && Promielocitos1TP<=9){
        
        documento.add(PromielocitosR2);
        }
          
        Paragraph PromielocitosRP = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        PromielocitosRP.setSpacingBefore((float) -12.5);
        PromielocitosRP.setIndentationLeft((float) 322);
        PromielocitosRP.setSpacingAfter(-3);
        
        if(Promielocitos1TT==0 && Promielocitos1TP>=10){
        
        documento.add(PromielocitosRP);            
        }
             
        Paragraph PromielocitosRP1 = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosRP1.setSpacingBefore((float) -12.5);
        PromielocitosRP1.setIndentationLeft((float) 322);
        PromielocitosRP1.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9 && Promielocitos1TP>=10){
        
        documento.add(PromielocitosRP1);
        } 
          
        Paragraph PromielocitosRP2 = new  Paragraph (txt_Promielocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosRP2.setSpacingBefore((float) -12.5);
        PromielocitosRP2.setIndentationLeft((float) 322);
        PromielocitosRP2.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10 && Promielocitos1TP>=10){
        
        documento.add(PromielocitosRP2);
        }   
        
        Paragraph PromielocitosV = new  Paragraph (txt_Promielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        PromielocitosV.setSpacingBefore((float) -12);
        PromielocitosV.setIndentationLeft(386);
        PromielocitosV.setSpacingAfter(-3);
        
                 if(Promielocitos1TT==0){
        
        documento.add(PromielocitosV);           
        }
             
        Paragraph PromielocitosV1 = new  Paragraph (txt_Promielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosV1.setSpacingBefore((float) -12);
        PromielocitosV1.setIndentationLeft(386);
        PromielocitosV1.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9){
        
        documento.add(PromielocitosV1);
        } 
          
        Paragraph PromielocitosV12 = new  Paragraph (txt_Promielocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        PromielocitosV12.setSpacingBefore((float) -12);
        PromielocitosV12.setIndentationLeft(380);
        PromielocitosV12.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10){
        
        documento.add(PromielocitosV12);
        } 
        
        Paragraph Promielocitosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Promielocitosref.setSpacingBefore((float) -12);
        Promielocitosref.setIndentationLeft((float) 456);
        Promielocitosref.setSpacingAfter(-3);
        
                       if(Promielocitos1TT==0){
        
        documento.add(Promielocitosref);           
        }
             
        Paragraph Promielocitosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitosref1.setSpacingBefore((float) -12);
        Promielocitosref1.setIndentationLeft((float) 456);
        Promielocitosref1.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9){
        
        documento.add(Promielocitosref1);
        } 
          
        Paragraph Promielocitosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitosref2.setSpacingBefore((float) -12);
        Promielocitosref2.setIndentationLeft((float) 456);
        Promielocitosref2.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10){
        
        documento.add(Promielocitosref2);
        } 
        
        Paragraph Promielocitosref3 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Promielocitosref3.setSpacingBefore((float) -12);
        Promielocitosref3.setIndentationLeft((float) 525.5);
        Promielocitosref3.setSpacingAfter(-3);
        
                              if(Promielocitos1TT==0){
        
        documento.add(Promielocitosref3);           
        }
             
        Paragraph Promielocitosref4 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitosref4.setSpacingBefore((float) -12);
        Promielocitosref4.setIndentationLeft((float) 525.5);
        Promielocitosref4.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=1 && Promielocitos1TT<=9){
        
        documento.add(Promielocitosref4);
        } 
          
        Paragraph Promielocitosref5 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Promielocitosref5.setSpacingBefore((float) -12);
        Promielocitosref5.setIndentationLeft((float) 525.5);
        Promielocitosref5.setSpacingAfter(-3);
   
          if(Promielocitos1TT>=10){
        
        documento.add(Promielocitosref5);
        }  
        
        Paragraph Blastos = new  Paragraph ("Blastos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Blastos.setSpacingBefore(2);
        Blastos.setIndentationLeft(17);
        Blastos.setSpacingAfter(-3);
        
                        if(Blastos1TT==0){
        
        documento.add(Blastos);
                 
        }
             
        Paragraph Blastos1 = new  Paragraph ("Blastos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastos1.setSpacingBefore(2);
        Blastos1.setIndentationLeft(17);
        Blastos1.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9){
        
        documento.add(Blastos1);
        } 
          
        Paragraph Blastos2 = new  Paragraph ("Blastos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastos2.setSpacingBefore(2);
        Blastos2.setIndentationLeft(17);
        Blastos2.setSpacingAfter(-3);
   
          if(Blastos1TT>=10){
        
        documento.add(Blastos2);
        }
        
        Paragraph BlastosR = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BlastosR.setSpacingBefore((float) -12.5);
        BlastosR.setIndentationLeft((float) 327);
        BlastosR.setSpacingAfter(-3);
        
        if(Blastos1TT==0 && Blastos1TP<=9){
        
        documento.add(BlastosR);
                 
        }
             
        Paragraph BlastosR1 = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosR1.setSpacingBefore((float) -12.5);
        BlastosR1.setIndentationLeft((float) 327);
        BlastosR1.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9 && Blastos1TP<=9){
        
        documento.add(BlastosR1);
        } 
          
        Paragraph BlastosR2 = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosR2.setSpacingBefore((float) -12.5);
        BlastosR2.setIndentationLeft((float) 327);
        BlastosR2.setSpacingAfter(-3);
   
          if(Blastos1TT>=10 && Blastos1TP<=9){
        
        documento.add(BlastosR2);
        }
          
        Paragraph BlastosR3 = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BlastosR3.setSpacingBefore((float) -12.5);
        BlastosR3.setIndentationLeft((float) 322);
        BlastosR3.setSpacingAfter(-3);
        
                               if(Blastos1TT==0 && Blastos1TP>=10){
        
        documento.add(BlastosR3);
                 
        }
             
        Paragraph BlastosR4 = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosR4.setSpacingBefore((float) -12.5);
        BlastosR4.setIndentationLeft((float) 322);
        BlastosR4.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9 && Blastos1TP>=10){
        
        documento.add(BlastosR4);
        } 
          
        Paragraph BlastosR5 = new  Paragraph (txt_Blastos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosR5.setSpacingBefore((float) -12.5);
        BlastosR5.setIndentationLeft((float) 322);
        BlastosR5.setSpacingAfter(-3);
   
          if(Blastos1TT>=10 && Blastos1TP>=10){
        
        documento.add(BlastosR5);
        }  
          
        
        Paragraph BlastosV = new  Paragraph (txt_Blastos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BlastosV.setSpacingBefore((float) -12);
        BlastosV.setIndentationLeft(386);
        BlastosV.setSpacingAfter(-3);
              
                 if(Blastos1TT==0){
        
        documento.add(BlastosV);
                 
        }
             
        Paragraph BlastosV1 = new  Paragraph (txt_Blastos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosV1.setSpacingBefore((float) -12);
        BlastosV1.setIndentationLeft(386);
        BlastosV1.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9){
        
        documento.add(BlastosV1);
        } 
          
        Paragraph BlastosV12 = new  Paragraph (txt_Blastos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BlastosV12.setSpacingBefore((float) -12);
        BlastosV12.setIndentationLeft(380);
        BlastosV12.setSpacingAfter(-3);
   
          if(Blastos1TT>=10){
        
        documento.add(BlastosV12);
        }
                
        Paragraph Blastosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Blastosref.setSpacingBefore((float) -12);
        Blastosref.setIndentationLeft((float) 456);
        Blastosref.setSpacingAfter(-3);
        
                       if(Blastos1TT==0){
        
        documento.add(Blastosref);       
        }
             
        Paragraph Blastosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastosref2.setSpacingBefore((float) -12);
        Blastosref2.setIndentationLeft((float) 456);
        Blastosref2.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9){
        
        documento.add(Blastosref2);
        } 
          
        Paragraph Blastosref3 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastosref3.setSpacingBefore((float) -12);
        Blastosref3.setIndentationLeft((float) 456);
        Blastosref3.setSpacingAfter(-3);
   
          if(Blastos1TT>=10){
        
        documento.add(Blastosref3);
        }
        
        
        Paragraph Blastosref4 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Blastosref4.setSpacingBefore((float) -12);
        Blastosref4.setIndentationLeft((float) 525.5);
        Blastosref4.setSpacingAfter(-3);
        
                               if(Blastos1TT==0){
        
        documento.add(Blastosref4);       
        }
             
        Paragraph Blastosref5 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastosref5.setSpacingBefore((float) -12);
        Blastosref5.setIndentationLeft((float) 525.5);
        Blastosref5.setSpacingAfter(-3);
   
          if(Blastos1TT>=1 && Blastos1TT<=9){
        
        documento.add(Blastosref5);
        } 
          
        Paragraph Blastosref6 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Blastosref6.setSpacingBefore((float) -12);
        Blastosref6.setIndentationLeft((float) 525.5);
        Blastosref6.setSpacingAfter(-3);
   
          if(Blastos1TT>=10){
        
        documento.add(Blastosref6);
        }
        
        Paragraph Eosinófilos = new  Paragraph ("Eosinófilos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Eosinófilos.setSpacingBefore(2);
        Eosinófilos.setIndentationLeft(17);
        Eosinófilos.setSpacingAfter(-3);
        
        if(Eosinófilos1TT<=9){
        
        documento.add(Eosinófilos);           
        }
             
        Paragraph Eosinófilos1 = new  Paragraph ("Eosinófilos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Eosinófilos1.setSpacingBefore(2);
        Eosinófilos1.setIndentationLeft(17);
        Eosinófilos1.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680){
        
        documento.add(Eosinófilos1);
        } 
        
        Paragraph Eosinófilos2 = new  Paragraph ("Eosinófilos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Eosinófilos2.setSpacingBefore(2);
        Eosinófilos2.setIndentationLeft(17);
        Eosinófilos2.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680){
        
        documento.add(Eosinófilos2);
        } 
        
        Paragraph EosinófilosR = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosR.setSpacingBefore((float) -12.5);
        EosinófilosR.setIndentationLeft((float) 327);
        EosinófilosR.setSpacingAfter(-3);
        
        if(Eosinófilos1TT<=9 && Eosinófilos1TP<=9){
        
        documento.add(EosinófilosR);         
        }
             
        Paragraph EosinófilosR1 = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosR1.setSpacingBefore((float) -12.5);
        EosinófilosR1.setIndentationLeft((float) 327);
        EosinófilosR1.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680 && Eosinófilos1TP<=9){
        
        documento.add(EosinófilosR1);
        } 
        
        Paragraph EosinófilosR2 = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        EosinófilosR2.setSpacingBefore((float) -12.5);
        EosinófilosR2.setIndentationLeft((float) 327);
        EosinófilosR2.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680 && Eosinófilos1TP<=9){
        
        documento.add(EosinófilosR2);
        }
        
        Paragraph EosinófilosRP1 = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosRP1.setSpacingBefore((float) -12.5);
        EosinófilosRP1.setIndentationLeft((float) 322);
        EosinófilosRP1.setSpacingAfter(-3);
        
        if(Eosinófilos1TT<=9 && Eosinófilos1TP>=10){
        
        documento.add(EosinófilosRP1);         
        }
             
        Paragraph EosinófilosRP2 = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosRP2.setSpacingBefore((float) -12.5);
        EosinófilosRP2.setIndentationLeft((float) 322);
        EosinófilosRP2.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680 && Eosinófilos1TP>=10){
        
        documento.add(EosinófilosRP2);
        } 
        
        Paragraph EosinófilosRP3 = new  Paragraph (txt_Eosinófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        EosinófilosRP3.setSpacingBefore((float) -12.5);
        EosinófilosRP3.setIndentationLeft((float) 322);
        EosinófilosRP3.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680 && Eosinófilos1TP>=10){
        
        documento.add(EosinófilosRP3);
        }  
        
        Paragraph EosinófilosV = new  Paragraph (txt_Eosinófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosV.setSpacingBefore((float) -12);
        EosinófilosV.setIndentationLeft(386);
        EosinófilosV.setSpacingAfter(-3);
        
        if(Eosinófilos1TT<=9){
        
        documento.add(EosinófilosV);         
        }
             
        Paragraph EosinófilosV1 = new  Paragraph (txt_Eosinófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosV1.setSpacingBefore((float) -12);
        EosinófilosV1.setIndentationLeft(380);
        EosinófilosV1.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680){
        
        documento.add(EosinófilosV1);
        } 
        
        Paragraph EosinófilosV12 = new  Paragraph (txt_Eosinófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        EosinófilosV12.setSpacingBefore((float) -12);
        EosinófilosV12.setIndentationLeft(380);
        EosinófilosV12.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680){
        
        documento.add(EosinófilosV12);
        } 
        
        Paragraph Eosinófilosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Eosinófilosref.setSpacingBefore((float) -12);
        Eosinófilosref.setIndentationLeft((float) 456);
        Eosinófilosref.setSpacingAfter(-3);
          
                          if(Eosinófilos1TT<=9){
        
        documento.add(Eosinófilosref);         
        }
             
        Paragraph Eosinófilosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Eosinófilosref1.setSpacingBefore((float) -12);
        Eosinófilosref1.setIndentationLeft((float) 456);
        Eosinófilosref1.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680){
        
        documento.add(Eosinófilosref1);
        } 
        
        Paragraph Eosinófilosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Eosinófilosref2.setSpacingBefore((float) -12);
        Eosinófilosref2.setIndentationLeft((float) 456);
        Eosinófilosref2.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680){
        
        documento.add(Eosinófilosref2);
        } 
        
        Paragraph EosinófilosrefP1 = new  Paragraph ("680" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosrefP1.setSpacingBefore((float) -12);
        EosinófilosrefP1.setIndentationLeft((float) 514);
        EosinófilosrefP1.setSpacingAfter(-3);
        
        if(Eosinófilos1TT<=9){
        
        documento.add(EosinófilosrefP1);         
        }
             
        Paragraph EosinófilosrefP2 = new  Paragraph ("680" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        EosinófilosrefP2.setSpacingBefore((float) -12);
        EosinófilosrefP2.setIndentationLeft((float) 514);
        EosinófilosrefP2.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>=10 && Eosinófilos1TT<=680){
        
        documento.add(EosinófilosrefP2);
        } 
        
        Paragraph EosinófilosrefP3 = new  Paragraph ("680" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        EosinófilosrefP3.setSpacingBefore((float) -12);
        EosinófilosrefP3.setIndentationLeft((float) 514);
        EosinófilosrefP3.setSpacingAfter(-3);
   
          if(Eosinófilos1TT>680){
        
        documento.add(EosinófilosrefP3);
        } 
       
        Paragraph Basófilos = new  Paragraph ("Basófilos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Basófilos.setSpacingBefore(2);
        Basófilos.setIndentationLeft(17);
        Basófilos.setSpacingAfter(-3);
        
        if(Basófilos1TT<=9){
        
        documento.add(Basófilos);        
        }
             
        Paragraph Basófilos1 = new  Paragraph ("Basófilos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Basófilos1.setSpacingBefore(2);
        Basófilos1.setIndentationLeft(17);
        Basófilos1.setSpacingAfter(-3);
   
          if(Basófilos1TT>=10 && Basófilos1TT<=100){
        
        documento.add(Basófilos1);
        } 
        
        Paragraph Basófilos2 = new  Paragraph ("Basófilos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Basófilos2.setSpacingBefore(2);
        Basófilos2.setIndentationLeft(17);
        Basófilos2.setSpacingAfter(-3);
   
          if(Basófilos1TT>100){
        
        documento.add(Basófilos2);
        }
        
        Paragraph BasófilosR = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosR.setSpacingBefore((float) -12.5);
        BasófilosR.setIndentationLeft((float) 327);
        BasófilosR.setSpacingAfter(-3);
        
        if(Basófilos1TT<=9 && Basófilos1TP<=9){
        
        documento.add(BasófilosR);        
        }
             
        Paragraph BasófilosR1 = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosR1.setSpacingBefore((float) -12.5);
        BasófilosR1.setIndentationLeft((float) 327);
        BasófilosR1.setSpacingAfter(-3);
   
        if(Basófilos1TT>=10 && Basófilos1TT<=100 && Basófilos1TP<=9){
        
        documento.add(BasófilosR1);
        } 
        
        Paragraph BasófilosR2 = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BasófilosR2.setSpacingBefore((float) -12.5);
        BasófilosR2.setIndentationLeft((float) 327);
        BasófilosR2.setSpacingAfter(-3);
   
        if(Basófilos1TT>100 && Basófilos1TP<=9){
        
        documento.add(BasófilosR2);
        }
          
        Paragraph BasófilosRP1 = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosRP1.setSpacingBefore((float) -12.5);
        BasófilosRP1.setIndentationLeft((float) 322);
        BasófilosRP1.setSpacingAfter(-3);
        
        if(Basófilos1TT<=9 && Basófilos1TP>=10){
        
        documento.add(BasófilosRP1);        
        }
             
        Paragraph BasófilosRP2 = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosRP2.setSpacingBefore((float) -12.5);
        BasófilosRP2.setIndentationLeft((float) 322);
        BasófilosRP2.setSpacingAfter(-3);
   
          if(Basófilos1TT>=10 && Basófilos1TT<=100 && Basófilos1TP>=10){
        
        documento.add(BasófilosRP2);
        } 
        
        Paragraph BasófilosRP3 = new  Paragraph (txt_Basófilos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BasófilosRP3.setSpacingBefore((float) -12.5);
        BasófilosRP3.setIndentationLeft((float) 322);
        BasófilosRP3.setSpacingAfter(-3);
   
          if(Basófilos1TT>100 && Basófilos1TP>=10){
        
        documento.add(BasófilosRP3);
        }  
        
        Paragraph BasófilosV = new  Paragraph (txt_Basófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosV.setSpacingBefore((float) -12);
        BasófilosV.setIndentationLeft(386);
        BasófilosV.setSpacingAfter(-3);
       
        if(Basófilos1TT<=9){
        
        documento.add(BasófilosV);        
        }
             
        Paragraph BasófilosV1 = new  Paragraph (txt_Basófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosV1.setSpacingBefore((float) -12);
        BasófilosV1.setIndentationLeft(380);
        BasófilosV1.setSpacingAfter(-3);
   
          if(Basófilos1TT>=10 && Basófilos1TT<=100){
        
        documento.add(BasófilosV1);
        } 
        
        Paragraph BasófilosV12 = new  Paragraph (txt_Basófilos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BasófilosV12.setSpacingBefore((float) -12);
        BasófilosV12.setIndentationLeft(380);
        BasófilosV12.setSpacingAfter(-3);
   
          if(Basófilos1TT>100){
        
        documento.add(BasófilosV12);
        } 
        
        Paragraph Basófilosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Basófilosref.setSpacingBefore((float) -12);
        Basófilosref.setIndentationLeft((float) 456);
        Basófilosref.setSpacingAfter(-3);
        
               if(Basófilos1TT<=9){
        
        documento.add(Basófilosref);        
        }
             
        Paragraph Basófilosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Basófilosref1.setSpacingBefore((float) -12);
        Basófilosref1.setIndentationLeft((float) 456);
        Basófilosref1.setSpacingAfter(-3);
   
          if(Basófilos1TT>=10 && Basófilos1TT<=100){
        
        documento.add(Basófilosref1);
        } 
        
        Paragraph Basófilosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Basófilosref2.setSpacingBefore((float) -12);
        Basófilosref2.setIndentationLeft((float) 456);
        Basófilosref2.setSpacingAfter(-3);
   
          if(Basófilos1TT>100){
        
        documento.add(Basófilosref2);
        } 
        
        Paragraph BasófilosrefC2 = new  Paragraph ("100" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosrefC2.setSpacingBefore((float) -12);
        BasófilosrefC2.setIndentationLeft((float) 514);
        BasófilosrefC2.setSpacingAfter(-3);
        
                       if(Basófilos1TT<=9){
        
        documento.add(BasófilosrefC2);        
        }
             
        Paragraph BasófilosrefC3 = new  Paragraph ("100" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        BasófilosrefC3.setSpacingBefore((float) -12);
        BasófilosrefC3.setIndentationLeft((float) 514);
        BasófilosrefC3.setSpacingAfter(-3);
   
          if(Basófilos1TT>=10 && Basófilos1TT<=100){
        
        documento.add(BasófilosrefC3);
        } 
        
        Paragraph BasófilosrefC4 = new  Paragraph ("100" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        BasófilosrefC4.setSpacingBefore((float) -12);
        BasófilosrefC4.setIndentationLeft((float) 514);
        BasófilosrefC4.setSpacingAfter(-3);
   
          if(Basófilos1TT>100){
        
        documento.add(BasófilosrefC4);
        } 
        
        Paragraph Monocitos = new  Paragraph ("Monocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Monocitos.setSpacingBefore(2);
        Monocitos.setIndentationLeft(17);
        Monocitos.setSpacingAfter(-3);
        
        if(Monocitos1TT<=9){
        
        documento.add(Monocitos);         
        }
             
        Paragraph Monocitos1 = new  Paragraph ("Monocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Monocitos1.setSpacingBefore(2);
        Monocitos1.setIndentationLeft(17);
        Monocitos1.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000){
        
        documento.add(Monocitos1);
        } 
        
        Paragraph Monocitos2 = new  Paragraph ("Monocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Monocitos2.setSpacingBefore(2);
        Monocitos2.setIndentationLeft(17);
        Monocitos2.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000){
        
        documento.add(Monocitos2);
        } 
        
        Paragraph MonocitosR = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosR.setSpacingBefore((float) -12.5);
        MonocitosR.setIndentationLeft((float) 327);
        MonocitosR.setSpacingAfter(-3);
        
        if(Monocitos1TT<=9 && Monocitos1TP<=9){
        
        documento.add(MonocitosR);
                 
        }
             
        Paragraph MonocitosR1 = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosR1.setSpacingBefore((float) -12.5);
        MonocitosR1.setIndentationLeft((float) 327);
        MonocitosR1.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000 && Monocitos1TP<=9){
        
        documento.add(MonocitosR1);
        } 
        
        Paragraph MonocitosR2 = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MonocitosR2.setSpacingBefore((float) -12.5);
        MonocitosR2.setIndentationLeft((float) 327);
        MonocitosR2.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000 && Monocitos1TP<=9){
        
        documento.add(MonocitosR2);
        }
          
        Paragraph MonocitosRP = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosRP.setSpacingBefore((float) -12.5);
        MonocitosRP.setIndentationLeft((float) 322);
        MonocitosRP.setSpacingAfter(-3);
        
                if(Monocitos1TT<=9 && Monocitos1TP>=10){
        
        documento.add(MonocitosRP);
                 
        }
             
        Paragraph MonocitosRP1 = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosRP1.setSpacingBefore((float) -12.5);
        MonocitosRP1.setIndentationLeft((float) 322);
        MonocitosRP1.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000 && Monocitos1TP>=10){
        
        documento.add(MonocitosRP1);
        } 
        
        Paragraph MonocitosRP2 = new  Paragraph (txt_Monocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MonocitosRP2.setSpacingBefore((float) -12.5);
        MonocitosRP2.setIndentationLeft((float) 322);
        MonocitosRP2.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000 && Monocitos1TP>=10){
        
        documento.add(MonocitosRP2);
        }   
        
        Paragraph MonocitosV = new  Paragraph (txt_Monocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosV.setSpacingBefore((float) -12);
        MonocitosV.setIndentationLeft(386);
        MonocitosV.setSpacingAfter(-3);
        
        if(Monocitos1TT<=9){
        
        documento.add(MonocitosV);
                 
        }
             
        Paragraph MonocitosV1 = new  Paragraph (txt_Monocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosV1.setSpacingBefore((float) -12);
        MonocitosV1.setIndentationLeft(380);
        MonocitosV1.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000){
        
        documento.add(MonocitosV1);
        } 
        
        Paragraph MonocitosV12 = new  Paragraph (txt_Monocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MonocitosV12.setSpacingBefore((float) -12);
        MonocitosV12.setIndentationLeft(380);
        MonocitosV12.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000){
        
        documento.add(MonocitosV12);
        } 
        
        Paragraph Monocitosref = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Monocitosref.setSpacingBefore((float) -12);
        Monocitosref.setIndentationLeft((float) 456);
        Monocitosref.setSpacingAfter(-3);
        
        if(Monocitos1TT<=9){
        
        documento.add(Monocitosref);        
        }
             
        Paragraph Monocitosref1 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Monocitosref1.setSpacingBefore((float) -12);
        Monocitosref1.setIndentationLeft((float) 456);
        Monocitosref1.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000){
        
        documento.add(Monocitosref1);
        } 
        
        Paragraph Monocitosref2 = new  Paragraph ("0" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Monocitosref2.setSpacingBefore((float) -12);
        Monocitosref2.setIndentationLeft((float) 456);
        Monocitosref2.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000){
        
        documento.add(Monocitosref2);
        } 
        
        Paragraph MonocitosrefP2 = new  Paragraph ("1000" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosrefP2.setSpacingBefore((float) -12);
        MonocitosrefP2.setIndentationLeft((float) 508.5);
        MonocitosrefP2.setSpacingAfter(-3);
        
                if(Monocitos1TT<=9){
        
        documento.add(MonocitosrefP2);        
        }
             
        Paragraph MonocitosrefP3 = new  Paragraph ("1000" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        MonocitosrefP3.setSpacingBefore((float) -12);
        MonocitosrefP3.setIndentationLeft((float) 508.5);
        MonocitosrefP3.setSpacingAfter(-3);
   
          if(Monocitos1TT>=10 && Monocitos1TT<=1000){
        
        documento.add(MonocitosrefP3);
        } 
        
        Paragraph MonocitosrefP4 = new  Paragraph ("1000" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        MonocitosrefP4.setSpacingBefore((float) -12);
        MonocitosrefP4.setIndentationLeft((float) 508.5);
        MonocitosrefP4.setSpacingAfter(-3);
   
          if(Monocitos1TT>1000){
        
        documento.add(MonocitosrefP4);
        } 
        
        Paragraph Linfocitos = new  Paragraph ("Linfocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitos.setSpacingBefore(2);
        Linfocitos.setIndentationLeft(17);
        Linfocitos.setSpacingAfter(-3);
        
                         if(Linfocitos1TT<=9){
        
        documento.add(Linfocitos);     
        }
             
        Paragraph Linfocitos1 = new  Paragraph ("Linfocitos", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Linfocitos1.setSpacingBefore(2);
        Linfocitos1.setIndentationLeft(17);
        Linfocitos1.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500){
        
        documento.add(Linfocitos1);
        } 
          
        Paragraph Linfocitos2 = new  Paragraph ("Linfocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitos2.setSpacingBefore(2);
        Linfocitos2.setIndentationLeft(17);
        Linfocitos2.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=10 && Linfocitos1TT<1500){
        
        documento.add(Linfocitos2);
        } 
        
        Paragraph Linfocitos3 = new  Paragraph ("Linfocitos", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitos3.setSpacingBefore(2);
        Linfocitos3.setIndentationLeft(17);
        Linfocitos3.setSpacingAfter(-3);
   
        if(Linfocitos1TT>6500){
        
        documento.add(Linfocitos3);
        }   
        
        Paragraph LinfocitosR = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosR.setSpacingBefore((float) -12.5);
        LinfocitosR.setIndentationLeft((float) 327);
        LinfocitosR.setSpacingAfter(-3);
        
        if(Linfocitos1TT<=9 && Linfocitos1TP<=9){
        
        documento.add(LinfocitosR);     
        }
             
        Paragraph LinfocitosR1 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LinfocitosR1.setSpacingBefore((float) -12.5);
        LinfocitosR1.setIndentationLeft((float) 327);
        LinfocitosR1.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500 && Linfocitos1TP<=9){
        
        documento.add(LinfocitosR1);
        } 
          
        Paragraph LinfocitosR2 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosR2.setSpacingBefore((float) -12.5);
        LinfocitosR2.setIndentationLeft((float) 327);
        LinfocitosR2.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=10 && Linfocitos1TT<1500 && Linfocitos1TP<=9){
        
        documento.add(LinfocitosR2);
        } 
        
        Paragraph LinfocitosR3 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosR3.setSpacingBefore((float) -12.5);
        LinfocitosR3.setIndentationLeft((float) 327);
        LinfocitosR3.setSpacingAfter(-3);
   
        if(Linfocitos1TT>6500 && Linfocitos1TP<=9){
        
        documento.add(LinfocitosR3);
        }
        
        Paragraph LinfocitosRP = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosRP.setSpacingBefore((float) -12.5);
        LinfocitosRP.setIndentationLeft((float) 322);
        LinfocitosRP.setSpacingAfter(-3);
        
        if(Linfocitos1TT<=9 && Linfocitos1TP>=10){
        
        documento.add(LinfocitosRP);     
        }
             
        Paragraph LinfocitosRP1 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LinfocitosRP1.setSpacingBefore((float) -12.5);
        LinfocitosRP1.setIndentationLeft((float) 322);
        LinfocitosRP1.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500 && Linfocitos1TP>=10){
        
        documento.add(LinfocitosRP1);
        } 
          
        Paragraph LinfocitosRP2 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosRP2.setSpacingBefore((float) -12.5);
        LinfocitosRP2.setIndentationLeft((float) 322);
        LinfocitosRP2.setSpacingAfter(-3);
   
        if(Linfocitos1TT>=10 && Linfocitos1TT<1500 && Linfocitos1TP>=10){
        
        documento.add(LinfocitosRP2);
        } 
        
        Paragraph LinfocitosRP3 = new  Paragraph (txt_Linfocitos.getText() + "%", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosRP3.setSpacingBefore((float) -12.5);
        LinfocitosRP3.setIndentationLeft((float) 322);
        LinfocitosRP3.setSpacingAfter(-3);
   
        if(Linfocitos1TT>6500 && Linfocitos1TP>=10){
        
        documento.add(LinfocitosRP3);
        }
        
        Paragraph LinfocitosV = new  Paragraph (txt_Linfocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosV.setSpacingBefore((float) -12);
        LinfocitosV.setIndentationLeft(386);
        LinfocitosV.setSpacingAfter(-3);
      
        if(Linfocitos1TT<=9){
        
        documento.add(LinfocitosV);
               
        }
             
        Paragraph LinfocitosV1 = new  Paragraph (txt_Linfocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LinfocitosV1.setSpacingBefore((float) -12);
        LinfocitosV1.setIndentationLeft(380);
        LinfocitosV1.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500){
        
        documento.add(LinfocitosV1);
        } 
          
          
        Paragraph LinfocitosV12 = new  Paragraph (txt_Linfocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosV12.setSpacingBefore((float) -12);
        LinfocitosV12.setIndentationLeft(380);
        LinfocitosV12.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=10 && Linfocitos1TT<1500){
        
        documento.add(LinfocitosV12);
        } 
        
        Paragraph LinfocitosV123 = new  Paragraph (txt_Linfocitos1.getText() + " " + "/uL", FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosV123.setSpacingBefore((float) -12);
        LinfocitosV123.setIndentationLeft(380);
        LinfocitosV123.setSpacingAfter(-3);
   
          if(Linfocitos1TT>6500){
        
        documento.add(LinfocitosV123);
        }   
        
        Paragraph Linfocitosref = new  Paragraph ("1500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitosref.setSpacingBefore((float) -12);
        Linfocitosref.setIndentationLeft((float) 439);
        Linfocitosref.setSpacingAfter(-3);
        
            if(Linfocitos1TT<=9){
        
        documento.add(Linfocitosref);      
        }
             
        Paragraph Linfocitosref1 = new  Paragraph ("1500" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        Linfocitosref1.setSpacingBefore((float) -12);
        Linfocitosref1.setIndentationLeft((float) 439);
        Linfocitosref1.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500){
        
        documento.add(Linfocitosref1);
        } 
             
        Paragraph Linfocitosref2 = new  Paragraph ("1500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitosref2.setSpacingBefore((float) -12);
        Linfocitosref2.setIndentationLeft((float) 439);
        Linfocitosref2.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=10 && Linfocitos1TT<1500){
        
        documento.add(Linfocitosref2);
        } 
        
        Paragraph Linfocitosref3 = new  Paragraph ("1500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        Linfocitosref3.setSpacingBefore((float) -12);
        Linfocitosref3.setIndentationLeft((float) 439);
        Linfocitosref3.setSpacingAfter(-3);
   
          if(Linfocitos1TT>6500){
        
        documento.add(Linfocitosref3);
        }
        
        Paragraph LinfocitosrefP2 = new  Paragraph ("6500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosrefP2.setSpacingBefore((float) -12);
        LinfocitosrefP2.setIndentationLeft((float) 508.5);
        LinfocitosrefP2.setSpacingAfter(-3);
        
            if(Linfocitos1TT<=9){
        
        documento.add(LinfocitosrefP2);      
        }
             
        Paragraph LinfocitosrefP3 = new  Paragraph ("6500" , FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
        LinfocitosrefP3.setSpacingBefore((float) -12);
        LinfocitosrefP3.setIndentationLeft((float) 508.5);
        LinfocitosrefP3.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=1500 && Linfocitos1TT<=6500){
        
        documento.add(LinfocitosrefP3);
        } 
             
        Paragraph LinfocitosrefP4 = new  Paragraph ("6500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosrefP4.setSpacingBefore((float) -12);
        LinfocitosrefP4.setIndentationLeft((float) 508.5);
        LinfocitosrefP4.setSpacingAfter(-3);
   
          if(Linfocitos1TT>=10 && Linfocitos1TT<1500){
        
        documento.add(LinfocitosrefP4);
        } 
        
        Paragraph LinfocitosrefP5 = new  Paragraph ("6500" , FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLACK));
        LinfocitosrefP5.setSpacingBefore((float) -12);
        LinfocitosrefP5.setIndentationLeft((float) 508.5);
        LinfocitosrefP5.setSpacingAfter(-3);
   
          if(Linfocitos1TT>6500){
        
        documento.add(LinfocitosrefP5);
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

    private void jButton_CalcularValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CalcularValoresActionPerformed
        double MUL, Np,N1,N2,N3,N4,N5,N6,N7,N8, N9, N10, N11;
        double N1uL, N2uL, N3uL, N4uL, N5uL, N6uL, N7uL, N8uL, N9uL, N10uL, N11uL;

        Np = Double.parseDouble(txt_Leucocitostotales.getText());
        BigDecimal bd0 = new BigDecimal(Np).setScale(0, RoundingMode.HALF_DOWN);
        String N0uLS= String.valueOf(bd0);
        txt_Leucocitostotales1.setText(N0uLS);

        MUL = 100;
        Np = Double.parseDouble(txt_Leucocitostotales.getText());
        N1 = Double.parseDouble(txt_Neutrófilostotales.getText());
        N1uL = N1/MUL*Np;
        BigDecimal bd1 = new BigDecimal(N1uL).setScale(0, RoundingMode.HALF_DOWN);
        String N1uLS= String.valueOf(bd1);
        txt_Neutrófilostotales1.setText(N1uLS);

        N2 = Double.parseDouble(txt_Neutrófilossegmentados.getText());
        N2uL = N2/MUL*Np;
        BigDecimal bd2 = new BigDecimal(N2uL).setScale(0, RoundingMode.HALF_DOWN);
        String N2uLS= String.valueOf(bd2);
        txt_Neutrófilossegmentados1.setText(N2uLS);

        N3 = Double.parseDouble(txt_Neutrófilosenbanda.getText());
        N3uL = N3/MUL*Np;
        BigDecimal bd3 = new BigDecimal(N3uL).setScale(0, RoundingMode.HALF_DOWN);
        String N3uLS= String.valueOf(bd3);
        txt_Neutrófilosenbanda1.setText(N3uLS);

        N4 = Double.parseDouble(txt_Metamielocitos.getText());
        N4uL = N4/MUL*Np;
        BigDecimal bd4 = new BigDecimal(N4uL).setScale(0, RoundingMode.HALF_DOWN);
        String N4uLS= String.valueOf(bd4);
        txt_Metamielocitos1.setText(N4uLS);

        N5 = Double.parseDouble(txt_Mielocitos.getText());
        N5uL = N5/MUL*Np;
        BigDecimal bd5 = new BigDecimal(N5uL).setScale(0, RoundingMode.HALF_DOWN);
        String N5uLS= String.valueOf(bd5);
        txt_Mielocitos1.setText(N5uLS);

        N6 = Double.parseDouble(txt_Promielocitos.getText());
        N6uL = N6/MUL*Np;
        BigDecimal bd6 = new BigDecimal(N6uL).setScale(0, RoundingMode.HALF_DOWN);
        String N6uLS= String.valueOf(bd6);
        txt_Promielocitos1.setText(N6uLS);

        N7 = Double.parseDouble(txt_Blastos.getText());
        N7uL = N7/MUL*Np;
        BigDecimal bd7 = new BigDecimal(N7uL).setScale(0, RoundingMode.HALF_DOWN);
        String N7uLS= String.valueOf(bd7);
        txt_Blastos1.setText(N7uLS);

        N8 = Double.parseDouble(txt_Eosinófilos.getText());
        N8uL = N8/MUL*Np;
        BigDecimal bd8 = new BigDecimal(N8uL).setScale(0, RoundingMode.HALF_DOWN);
        String N8uLS= String.valueOf(bd8);
        txt_Eosinófilos1.setText(N8uLS);

        N9 = Double.parseDouble(txt_Basófilos.getText());
        N9uL = N9/MUL*Np;
        BigDecimal bd9 = new BigDecimal(N9uL).setScale(0, RoundingMode.HALF_DOWN);
        String N9uLS= String.valueOf(bd9);
        txt_Basófilos1.setText(N9uLS);

        N10 = Double.parseDouble(txt_Monocitos.getText());
        N10uL = N10/MUL*Np;
        BigDecimal bd10 = new BigDecimal(N10uL).setScale(0, RoundingMode.HALF_DOWN);
        String N10uLS= String.valueOf(bd10);
        txt_Monocitos1.setText(N10uLS);

        N11 = Double.parseDouble(txt_Linfocitos.getText());
        N11uL = N11/MUL*Np;
        BigDecimal bd11 = new BigDecimal(N11uL).setScale(0, RoundingMode.HALF_DOWN);
        String N11uLS= String.valueOf(bd11);
        txt_Linfocitos1.setText(N11uLS);
    }//GEN-LAST:event_jButton_CalcularValoresActionPerformed

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
            java.util.logging.Logger.getLogger(BH6a10años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BH6a10años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BH6a10años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BH6a10años.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BH6a10años().setVisible(true);
            }
        });
    }


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ActualizarDatos;
    private javax.swing.JButton jButton_CalcularValores;
    private javax.swing.JButton jButton_GuardarDatos;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JCheckBox jCheckBox_firma;
    private com.toedter.calendar.JDateChooser jDateChooser_fnacimiento;
    private javax.swing.JLabel jLabe_claveEstudio;
    private javax.swing.JLabel jLabel_Basófilos;
    private javax.swing.JLabel jLabel_Blastos;
    private javax.swing.JLabel jLabel_CHCM;
    private javax.swing.JLabel jLabel_CHCM1;
    private javax.swing.JLabel jLabel_CHCM4;
    private javax.swing.JLabel jLabel_CHCM5;
    private javax.swing.JLabel jLabel_CHCM6;
    private javax.swing.JLabel jLabel_CHCM7;
    private javax.swing.JLabel jLabel_CHCM8;
    private javax.swing.JLabel jLabel_ConcentraciónMedia;
    private javax.swing.JLabel jLabel_Datos;
    private javax.swing.JLabel jLabel_Eosinófilos;
    private javax.swing.JLabel jLabel_Eritrocitos;
    private javax.swing.JLabel jLabel_FórmulaBlanca;
    private javax.swing.JLabel jLabel_Fórmularoja;
    private javax.swing.JLabel jLabel_Hematocrito;
    private javax.swing.JLabel jLabel_Hemoglobina;
    private javax.swing.JLabel jLabel_Leucocitostotales;
    private javax.swing.JLabel jLabel_Linfocitos;
    private javax.swing.JLabel jLabel_Metamielocitos;
    private javax.swing.JLabel jLabel_Mielocitos;
    private javax.swing.JLabel jLabel_Monocitos;
    private javax.swing.JLabel jLabel_Neutrófilosenbanda;
    private javax.swing.JLabel jLabel_Neutrófilossegmentados;
    private javax.swing.JLabel jLabel_Neutrófilostotales;
    private javax.swing.JLabel jLabel_NoFolio;
    private javax.swing.JLabel jLabel_Promielocitos;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_UL;
    private javax.swing.JLabel jLabel_UL1;
    private javax.swing.JLabel jLabel_ValoresdeResultado;
    private javax.swing.JLabel jLabel_VolumenGlobular1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_Wallpaper2;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_deHemoglobinaHCM;
    private javax.swing.JLabel jLabel_edad;
    private javax.swing.JLabel jLabel_empresa;
    private javax.swing.JLabel jLabel_fechadeentrega;
    private javax.swing.JLabel jLabel_guion;
    private javax.swing.JLabel jLabel_guion1;
    private javax.swing.JLabel jLabel_guion10;
    private javax.swing.JLabel jLabel_guion11;
    private javax.swing.JLabel jLabel_guion2;
    private javax.swing.JLabel jLabel_guion3;
    private javax.swing.JLabel jLabel_guion4;
    private javax.swing.JLabel jLabel_guion5;
    private javax.swing.JLabel jLabel_guion6;
    private javax.swing.JLabel jLabel_guion7;
    private javax.swing.JLabel jLabel_guion8;
    private javax.swing.JLabel jLabel_guion9;
    private javax.swing.JLabel jLabel_hora;
    private javax.swing.JLabel jLabel_indicaciones;
    private javax.swing.JLabel jLabel_medico;
    private javax.swing.JLabel jLabel_nombres;
    private javax.swing.JLabel jLabel_porcentaje;
    private javax.swing.JLabel jLabel_porcentaje1;
    private javax.swing.JLabel jLabel_porcentaje10;
    private javax.swing.JLabel jLabel_porcentaje2;
    private javax.swing.JLabel jLabel_porcentaje3;
    private javax.swing.JLabel jLabel_porcentaje4;
    private javax.swing.JLabel jLabel_porcentaje5;
    private javax.swing.JLabel jLabel_porcentaje6;
    private javax.swing.JLabel jLabel_porcentaje7;
    private javax.swing.JLabel jLabel_porcentaje8;
    private javax.swing.JLabel jLabel_porcentaje9;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JLabel jLabel_uL10;
    private javax.swing.JLabel jLabel_uL11;
    private javax.swing.JLabel jLabel_uL12;
    private javax.swing.JLabel jLabel_uL2;
    private javax.swing.JLabel jLabel_uL3;
    private javax.swing.JLabel jLabel_uL4;
    private javax.swing.JLabel jLabel_uL5;
    private javax.swing.JLabel jLabel_uL6;
    private javax.swing.JLabel jLabel_uL7;
    private javax.swing.JLabel jLabel_uL8;
    private javax.swing.JLabel jLabel_uL9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_indicaciones;
    private javax.swing.JTextField txt_Basófilos;
    private javax.swing.JTextField txt_Basófilos1;
    private javax.swing.JTextField txt_Blastos;
    private javax.swing.JTextField txt_Blastos1;
    private javax.swing.JTextField txt_ConcentracióMediadeHemoglobinaHCM;
    private javax.swing.JTextField txt_ConcentraciónMediadeHemoglobinaCorpuscularCHCM;
    private javax.swing.JTextField txt_Eosinófilos;
    private javax.swing.JTextField txt_Eosinófilos1;
    private javax.swing.JTextField txt_Eritrocitos;
    private javax.swing.JTextField txt_Hematocrito;
    private javax.swing.JTextField txt_Hemoglobina;
    private javax.swing.JTextField txt_Leucocitostotales;
    private javax.swing.JTextField txt_Leucocitostotales1;
    private javax.swing.JTextField txt_Linfocitos;
    private javax.swing.JTextField txt_Linfocitos1;
    private javax.swing.JTextField txt_Metamielocitos;
    private javax.swing.JTextField txt_Metamielocitos1;
    private javax.swing.JTextField txt_Mielocitos;
    private javax.swing.JTextField txt_Mielocitos1;
    private javax.swing.JTextField txt_Monocitos;
    private javax.swing.JTextField txt_Monocitos1;
    private javax.swing.JTextField txt_Neutrófilosenbanda;
    private javax.swing.JTextField txt_Neutrófilosenbanda1;
    private javax.swing.JTextField txt_Neutrófilossegmentados;
    private javax.swing.JTextField txt_Neutrófilossegmentados1;
    private javax.swing.JTextField txt_Neutrófilostotales;
    private javax.swing.JTextField txt_Neutrófilostotales1;
    private javax.swing.JTextField txt_NoFolio;
    private javax.swing.JTextField txt_Plaquetas;
    private javax.swing.JTextField txt_Promielocitos;
    private javax.swing.JTextField txt_Promielocitos1;
    private javax.swing.JTextField txt_Reporte;
    private javax.swing.JTextField txt_VolumenGlobularMedioVCM;
    private javax.swing.JTextField txt_VolumenPlaquetarioMedioVPM;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_claveEstudio;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_sexo;
    private javax.swing.JTextField txt_ÍndicededistribucióndeeritrocitosRDW;
    // End of variables declaration//GEN-END:variables
 

}
