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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import static ventanas.Estudio.estudio;

/**
 *
 * @author raula
 */
public class RegistrarEstudio extends javax.swing.JFrame {

int IDpaciente_update = 0, IDestudio = 0, IDEst;
String user = "", nom_paciente = "", estudio="", empresa="", NdeFolios="";
private TextAutoCompleter ac;
    
    /**
     * Creates new form RegistrarEstudio
     */
    public RegistrarEstudio() {
        initComponents();
        user = Login.user;
        IDestudio = Informacion_paciente.IDestudio;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        estudio = Estudio.estudio;
        empresa = Informacion_paciente.empresa;
        IDEst = Estudio.IDEst;
        
        txt_empresa.setText(empresa);
        txt_nombredelestudio.setText(estudio);
        
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
        setSize(830, 470);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
            //Carga viral HBV
         
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_clavedelestudio.setText("PHB2"); 
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_diadeentrega.setText("Diez días");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           txt_costo.setText("4175");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HBV")){
           jTextPane_indicaciones.setText("Con EDTA 3 mL.  Enviar congelado en tubo de plástico estéril. ");
        }
        
        //Carga viral HCV
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_clavedelestudio.setText("PHC2");   
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_diadeentrega.setText("Diez días");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           txt_costo.setText("3590");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral HCV")){
           jTextPane_indicaciones.setText("Con EDTA 3 mL.  Enviar congelado en tubo de plástico estéril. ");
        }
        
        //CD4 y CD8
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_clavedelestudio.setText("LINF");   
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_diadeentrega.setText("Tres dias");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           txt_costo.setText("650");
        }
        if(txt_nombredelestudio.getText().equals("CD4 y CD8")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL. (Enviar valor de leucocitos y linfocitos totales).");
        }
        

        
        //Carga viral VIH
         if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_clavedelestudio.setText("PVIH");   
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_diadeentrega.setText("Siete días");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           txt_costo.setText("2290");
        }
        if(txt_nombredelestudio.getText().equals("Carga viral VIH")){
           jTextPane_indicaciones.setText("Con EDTA 3 mL. (Tubo plástico). Separar y congelar.");
        }
        
        
          //FTA-ABS 
         if(txt_nombredelestudio.getText().equals("FTA-ABS")){
           txt_clavedelestudio.setText("ANLU");   
        }
        if(txt_nombredelestudio.getText().equals("FTA-ABS")){
           txt_diadeentrega.setText("Dos días");
        }
        if(txt_nombredelestudio.getText().equals("FTA-ABS")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("FTA-ABS")){
           txt_costo.setText("790");
          
        }
        if(txt_nombredelestudio.getText().equals("FTA-ABS")){
           jTextPane_indicaciones.setText("Con Citrato de Na 2 mL. Separar de inmediato. En tubo de plástico.");
        }
        
        
        //HLA A, B,C DQ, DR (Baja resolución)
         if(txt_nombredelestudio.getText().equals("HLA A, B,C DQ, DR (Baja resolución)")){
           txt_clavedelestudio.setText("ANLU");   
        }
        if(txt_nombredelestudio.getText().equals("HLA A, B,C DQ, DR (Baja resolución)")){
           txt_diadeentrega.setText("Dos días");
        }
        if(txt_nombredelestudio.getText().equals("HLA A, B,C DQ, DR (Baja resolución)")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("HLA A, B,C DQ, DR (Baja resolución)")){
           txt_costo.setText("790");
          
        }
        if(txt_nombredelestudio.getText().equals("HLA A, B,C DQ, DR (Baja resolución)")){
           jTextPane_indicaciones.setText("Con Citrato de Na 2 mL. Separar de inmediato. En tubo de plástico.");
        }
        
     
        //Anticoagulante lúpico
         if(txt_nombredelestudio.getText().equals("Anticoagulante lúpico")){
           txt_clavedelestudio.setText("ANLU");   
        }
        if(txt_nombredelestudio.getText().equals("Anticoagulante lúpico")){
           txt_diadeentrega.setText("Dos días");
        }
        if(txt_nombredelestudio.getText().equals("Anticoagulante lúpico")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Anticoagulante lúpico")){
           txt_costo.setText("790");
          
        }
        if(txt_nombredelestudio.getText().equals("Anticoagulante lúpico")){
           jTextPane_indicaciones.setText("Con Citrato de Na 2 mL. Separar de inmediato. En tubo de plástico.");
        }
        
         //Antígeno de Von Willebrand
         if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           txt_clavedelestudio.setText("ANLU");   
        }
        if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           txt_diadeentrega.setText("Dos días");
        }
        if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           txt_costo.setText("790");
          
        }
        if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           jTextPane_indicaciones.setText("Con Citrato de Na 2 mL. Separar de inmediato. En tubo de plástico.");
        }

         //Antígeno SARS CoV-2
         if(txt_nombredelestudio.getText().equals("Antígeno SARS CoV-2")){
           txt_clavedelestudio.setText("ANLU");   
        }
        if(txt_nombredelestudio.getText().equals("Antígeno SARS CoV-2")){
           txt_diadeentrega.setText("MD");
        }
        if(txt_nombredelestudio.getText().equals("Antígeno SARS CoV-2")){
           txt_tipodeestudio.setText("Nasofaríngea");
        }
        if(txt_nombredelestudio.getText().equals("Antígeno SARS CoV-2")){
           txt_costo.setText("500");
          
        }
        if(txt_nombredelestudio.getText().equals("Antígeno de Von Willebrand")){
           jTextPane_indicaciones.setText("No colocarse cremas, ungüentos o sprays en la nariz antes de la toma de muestra.");
        }
        
         //BH 0 a 1 mes
         if(txt_nombredelestudio.getText().equals("BH 0 a 1 mes")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 0 a 1 mes")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 0 a 1 mes")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 0 a 1 mes")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 0 a 1 mes")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
        
         //BH 2 a 6 meses
         if(txt_nombredelestudio.getText().equals("BH 2 a 6 meses")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 2 a 6 meses")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 2 a 6 meses")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 2 a 6 meses")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 2 a 6 meses")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
        
           //BH 3 a 5 años
         if(txt_nombredelestudio.getText().equals("BH 3 a 5 años")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 3 a 5 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 3 a 5 años")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 3 a 5 años")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 3 a 5 años")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
        
            //BH 6 a 10 años
        if(txt_nombredelestudio.getText().equals("BH 6 a 10 años")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 6 a 10 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 6 a 10 años")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 6 a 10 años")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 6 a 10 años")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
             //BH 7 a 24 meses
        if(txt_nombredelestudio.getText().equals("BH 7 a 24 meses")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 7 a 24 meses")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 7 a 24 meses")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 7 a 24 meses")){
           txt_costo.setText("$120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 7 a 24 meses")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
            //BH 11 a 15 años
        if(txt_nombredelestudio.getText().equals("BH 11 a 15 años")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH 11 a 15 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH 11 a 15 años")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH 11 a 15 años")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH 11 a 15 años")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
              //BH Femenino mas de 16 años
        if(txt_nombredelestudio.getText().equals("BH Femenino mas de 16 años")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH Femenino mas de 16 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH Femenino mas de 16 años")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH Femenino mas de 16 años")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH Femenino mas de 16 años")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
         //BH Masculino mas de 16 años
        if(txt_nombredelestudio.getText().equals("BH Masculino mas de 16 años")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH Masculino mas de 16 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH Masculino mas de 16 años")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH Masculino mas de 16 años")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH Masculino mas de 16 años")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
                   //BH Neonato 0 a 1 día
        if(txt_nombredelestudio.getText().equals("BH Neonato 0 a 1 día")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 0 a 1 día")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 0 a 1 día")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 0 a 1 día")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 0 a 1 día")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
        //BH Neonato 1 a 4 días
        if(txt_nombredelestudio.getText().equals("BH Neonato 1 a 4 días")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 1 a 4 días")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 1 a 4 días")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 1 a 4 días")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 1 a 4 días")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
        //BH Neonato 4 a 7 días
        if(txt_nombredelestudio.getText().equals("BH Neonato 4 a 7 días")){
           txt_clavedelestudio.setText("BHC");   
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 4 a 7 días")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 4 a 7 días")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 4 a 7 días")){
           txt_costo.setText("120");
          
        }
        if(txt_nombredelestudio.getText().equals("BH Neonato 4 a 7 días")){
           jTextPane_indicaciones.setText("Con EDTA 2 mL y frotis.");
        }
        
       
        //Grupo sanguíneo y Rh (Hemaglutinación)
        if(txt_nombredelestudio.getText().equals("Grupo sanguíneo y Rh (Hemaglutinación)")){
           txt_clavedelestudio.setText("GPOA");   
        }
        if(txt_nombredelestudio.getText().equals("Grupo sanguíneo y Rh (Hemaglutinación)")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("Grupo sanguíneo y Rh (Hemaglutinación)")){
           txt_tipodeestudio.setText("Sangre total");
        }
        if(txt_nombredelestudio.getText().equals("Grupo sanguíneo y Rh (Hemaglutinación)")){
           txt_costo.setText("50");
          
        }
        if(txt_nombredelestudio.getText().equals("Grupo sanguíneo y Rh (Hemaglutinación)")){
           jTextPane_indicaciones.setText("Con EDTA 1 mL.");
        }

        //TP y TTP
        if(txt_nombredelestudio.getText().equals("TP y TTP")){
           txt_clavedelestudio.setText("TPRO Y TTP");   
        }
        if(txt_nombredelestudio.getText().equals("TP y TTP")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("TP y TTP")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("TP y TTP")){
           txt_costo.setText("90");
          
        }
        if(txt_nombredelestudio.getText().equals("TP y TTP")){
           jTextPane_indicaciones.setText("Con Citrato de Na en frío 1 mL. (Tubo azul).");
        }
        
            //Dímero D
        if(txt_nombredelestudio.getText().equals("Dímero D")){
           txt_clavedelestudio.setText("DIMD");   
        }
        if(txt_nombredelestudio.getText().equals("Dímero D")){
           txt_diadeentrega.setText("Mismo dia");
        }
        if(txt_nombredelestudio.getText().equals("Dímero D")){
           txt_tipodeestudio.setText("Plasma");
        }
        if(txt_nombredelestudio.getText().equals("Dímero D")){
           txt_costo.setText("450");
        }
        if(txt_nombredelestudio.getText().equals("Dímero D")){
           jTextPane_indicaciones.setText("Con Citrato de Na 2 mL. (Tubo azul).");
        }

        //QS6 19 a 50 años
        if(txt_nombredelestudio.getText().equals("QS6 19 a 50 años")){
           txt_clavedelestudio.setText("QS6");   
        }
        if(txt_nombredelestudio.getText().equals("QS6 19 a 50 años")){
           txt_diadeentrega.setText("Mismo día");
        }
        if(txt_nombredelestudio.getText().equals("QS6 19 a 50 años")){
           txt_tipodeestudio.setText("Suero");
        }
        if(txt_nombredelestudio.getText().equals("QS6 19 a 50 años")){
           txt_costo.setText("360");
          
        }
        if(txt_nombredelestudio.getText().equals("QS6 19 a 50 años")){
           jTextPane_indicaciones.setText("2 mL. Ayuno de 8-12 hrs. Sin contrastes radiológicos 3 días antes.");
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
        jLabel_Empresa = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Registro de estudio");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel_clavedelestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_clavedelestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_clavedelestudio.setText("Clave del estudio:");
        getContentPane().add(jLabel_clavedelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_clavedelestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_clavedelestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_clavedelestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_clavedelestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_clavedelestudio.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
        getContentPane().add(txt_clavedelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 310, -1));

        jLabel_nombredelestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombredelestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombredelestudio.setText("Nombre del estudio:");
        getContentPane().add(jLabel_nombredelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_nombredelestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombredelestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombredelestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombredelestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombredelestudio.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
        getContentPane().add(txt_nombredelestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 310, -1));

        jLabel_diadeentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_diadeentrega.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_diadeentrega.setText("Dia de entrega:");
        getContentPane().add(jLabel_diadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTextPane_indicaciones.setEnabled(false);
        jScrollPane1.setViewportView(jTextPane_indicaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 410, 190));

        jLabel_tipodeestudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_tipodeestudio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tipodeestudio.setText("Tipo de estudio:");
        getContentPane().add(jLabel_tipodeestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_tipodeestudio.setBackground(new java.awt.Color(153, 153, 255));
        txt_tipodeestudio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tipodeestudio.setForeground(new java.awt.Color(255, 255, 255));
        txt_tipodeestudio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipodeestudio.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_tipodeestudio.setEnabled(false);
        getContentPane().add(txt_tipodeestudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 310, -1));

        jLabel_costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_costo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_costo.setText("Costo:");
        getContentPane().add(jLabel_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        txt_costo.setBackground(new java.awt.Color(153, 153, 255));
        txt_costo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_costo.setForeground(new java.awt.Color(255, 255, 255));
        txt_costo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costo.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_costo.setEnabled(false);
        getContentPane().add(txt_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 310, -1));

        jLabel_indicaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_indicaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_indicaciones.setText("Indicaciones:");
        getContentPane().add(jLabel_indicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jButton_Registrar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar.setText("Guardar Estudio");
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
        txt_diadeentrega.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_diadeentrega.setEnabled(false);
        getContentPane().add(txt_diadeentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 310, -1));

        jLabel_Empresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Empresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Empresa.setText("Empresa:");
        getContentPane().add(jLabel_Empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_empresa.setBackground(new java.awt.Color(153, 153, 255));
        txt_empresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_empresa.setForeground(new java.awt.Color(255, 255, 255));
        txt_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_empresa.setBorder(new javax.swing.border.SoftBevelBorder(0));
        txt_empresa.setEnabled(false);
        txt_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empresaActionPerformed(evt);
            }
        });
        txt_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_empresaKeyReleased(evt);
            }
        });
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 310, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombredelestudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombredelestudioActionPerformed

    }//GEN-LAST:event_txt_nombredelestudioActionPerformed

    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarActionPerformed
        
        int validacion = 0;
        String  empresaN,clave_estudio, nombre_estudio, dia_entrega, tipo_muestra, costo_estudio, indicaciones_estudio, estatus, dia_registrado, mes_registrado, annio_registrado; 
      
        empresaN = txt_empresa.getText().trim();
        clave_estudio = txt_clavedelestudio.getText().trim();
        nombre_estudio = txt_nombredelestudio.getText().trim();
        dia_entrega = txt_diadeentrega.getText().trim();
        tipo_muestra = txt_tipodeestudio.getText().trim();
        costo_estudio = txt_costo.getText().trim();
        indicaciones_estudio = jTextPane_indicaciones.getText();
        estatus = "En proceso";
        
        Calendar calendar = Calendar.getInstance();
        
        dia_registrado = Integer.toString(calendar.get(Calendar.DATE));
        java.util.Date d3 = new java.util.Date();
        SimpleDateFormat hourtwenty3 = new SimpleDateFormat("MM");
         
        mes_registrado = hourtwenty3.format(d3);
        annio_registrado = Integer.toString(calendar.get(Calendar.YEAR));
        
        if(empresaN.equals("")){
           txt_empresa.setBackground(Color.red);
           validacion++;
        }
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
   
          
        if (validacion == 0) {
            
            try {
            
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into estudios values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                
                pst.setInt(1, 0);
                pst.setInt(2, IDEst);
                pst.setString(3, empresaN);
                pst.setString(4, clave_estudio);
                pst.setInt(5, IDpaciente_update);
                pst.setString(6, nombre_estudio);
                pst.setString(7, dia_entrega);
                pst.setString(8, indicaciones_estudio);
                pst.setString(9, tipo_muestra);
                pst.setString(10, costo_estudio);
                pst.setString(11, dia_registrado);
                pst.setString(12, mes_registrado);
                pst.setString(13, annio_registrado);
                pst.setString(14, estatus);
                pst.setString(15, user);
                
                pst.executeUpdate();
                cn.close();
                
                txt_empresa.setBackground(Color.green);
                txt_clavedelestudio.setBackground(Color.green);
                txt_nombredelestudio.setBackground(Color.green);
                txt_diadeentrega.setBackground(Color.green);
                txt_tipodeestudio.setBackground(Color.green);
                txt_costo.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                
                this.dispose();
                
                
                
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

    private void txt_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empresaActionPerformed

    private void txt_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empresaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empresaKeyReleased

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
            java.util.logging.Logger.getLogger(RegistrarEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEstudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JLabel jLabel_Empresa;
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
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_nombredelestudio;
    private javax.swing.JTextField txt_tipodeestudio;
    // End of variables declaration//GEN-END:variables
}
