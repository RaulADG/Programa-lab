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



/**
 *
 * @author raula
 */
public class Informacion_paciente extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();

    
    public static String empresa = "", edad = "";
    int IDpaciente_update = 0;
    public static int IDestudio = 0;
    String user = "";

    /**
     * Creates new form Informacion_paciente
     */
    public Informacion_paciente() {
        initComponents();
 
        user = Login.user;
        IDpaciente_update = GestionarPacientes.IDpaciente_update;
        
        
        setSize(1421, 633);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
 
        
        try {
          
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
             "select * from pacientes where id_paciente = '" + IDpaciente_update + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                setTitle("Información del paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente") + " - Sesión de " + user);
                jLabel_Titulo.setText("Información del paciente " + rs.getString("nombre_paciente") + " " + rs.getString("apellido_paciente"));
                
                txt_idpaciente.setText(rs.getString("id_paciente"));
                txt_empresa.setText(rs.getString("empresa_paciente"));
                txt_nombre.setText(rs.getString("nombre_paciente"));
                txt_apellido.setText(rs.getString("apellido_paciente"));
                txt_edad.setText(rs.getString("edad_paciente"));
                jDateChooser_fnacimiento.setDate(rs.getDate("fnacimiento_paciente")); 
                cmb_sexo.setSelectedItem(rs.getString("sexo_paciente"));
                txt_mail.setText(rs.getString("mail_paciente"));
                txt_telefono.setText(rs.getString("tel_paciente"));
                txt_direccion.setText(rs.getString("dir_paciente"));
                txt_nombremedico.setText(rs.getString("nombredelmedico_paciente"));
                txt_telefonom.setText(rs.getString("telefonodelmedico_paciente"));
                txt_mailmedico.setText(rs.getString("maildelmedico_paciente"));
                txt_facturar.setText(rs.getString("facturar_paciente"));
                txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));
               
                
            }
            cn.close();
             
        } catch (SQLException e) {
            System.err.println("Error al cargar usuario." + e);
            JOptionPane.showMessageDialog(
                null, "¡¡ERROR al cargar!!, contacte al administrador");
        }
        
        try {
           Connection cn2 = Conexion.conectar();
            PreparedStatement pst2;
            pst2 = cn2.prepareStatement("select * from facturacion where id_paciente = '" + IDpaciente_update + "'");
            ResultSet rs2 = pst2.executeQuery();
        
             if (rs2.next()){
                
                txt_RFC.setText(rs2.getString("RFC_facturacion"));
                txt_razonsocial.setText(rs2.getString("razonsocial_facturacion"));
                cmb_CFDI.setSelectedItem(rs2.getString("usodeCFDI_facturacion"));
                cmb_metodoPago.setSelectedItem(rs2.getString("metododepago_paciente"));
                txt_montototal.setText(rs2.getString("montototal_paciente"));
                txt_mailfacturacion.setText(rs2.getString("email_facturacion"));
                
                
                
            }
            cn2.close();
  
        } catch (SQLException e) {
             System.err.println("Error al cargar usuario." + e);
            JOptionPane.showMessageDialog(
                null, "¡¡ERROR al cargar!!, contacte al administrador");
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
        jLabel_IDdelpaciente = new javax.swing.JLabel();
        jLabel_empresa = new javax.swing.JLabel();
        jLabel_nombres = new javax.swing.JLabel();
        jLabel_apellidos = new javax.swing.JLabel();
        jLabel_edad = new javax.swing.JLabel();
        jLabel_fechadenacimiento = new javax.swing.JLabel();
        jLabel_sexo = new javax.swing.JLabel();
        jLabel_mail = new javax.swing.JLabel();
        jLabel_tel = new javax.swing.JLabel();
        jLabel_dir = new javax.swing.JLabel();
        jLabel_telmedico = new javax.swing.JLabel();
        jLabel_telefonodelmedico = new javax.swing.JLabel();
        jLabel_correodelmedico = new javax.swing.JLabel();
        jLabel_facturar = new javax.swing.JLabel();
        jLabel_Datosdefacturacion = new javax.swing.JLabel();
        jLabel_RFC = new javax.swing.JLabel();
        jLabel_razonsocial = new javax.swing.JLabel();
        jLabel_usoCFDI = new javax.swing.JLabel();
        jLabel_metododepago = new javax.swing.JLabel();
        jLabel_montototal = new javax.swing.JLabel();
        jLabel_emailfacturacion = new javax.swing.JLabel();
        jLabel_modificadopor = new javax.swing.JLabel();
        txt_idpaciente = new javax.swing.JTextField();
        txt_empresa = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_edad = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_nombremedico = new javax.swing.JTextField();
        txt_telefonom = new javax.swing.JTextField();
        txt_mailmedico = new javax.swing.JTextField();
        txt_facturar = new javax.swing.JTextField();
        txt_RFC = new javax.swing.JTextField();
        txt_razonsocial = new javax.swing.JTextField();
        txt_montototal = new javax.swing.JTextField();
        txt_mailfacturacion = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jDateChooser_fnacimiento = new com.toedter.calendar.JDateChooser();
        cmb_sexo = new javax.swing.JComboBox<>();
        cmb_CFDI = new javax.swing.JComboBox<>();
        cmb_metodoPago = new javax.swing.JComboBox<>();
        jButton_Estudios = new javax.swing.JButton();
        jButton_Estudios1 = new javax.swing.JButton();
        jLabel_Wallpaper2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del Paciente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel_IDdelpaciente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_IDdelpaciente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDdelpaciente.setText("ID del paciente:");
        getContentPane().add(jLabel_IDdelpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel_empresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_empresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_empresa.setText("Empresa:");
        getContentPane().add(jLabel_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel_nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombres.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombres.setText("Nombre(s):");
        getContentPane().add(jLabel_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        jLabel_apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_apellidos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_apellidos.setText("Apellidos:");
        getContentPane().add(jLabel_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jLabel_edad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_edad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_edad.setText("Edad:");
        getContentPane().add(jLabel_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jLabel_fechadenacimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fechadenacimiento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechadenacimiento.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel_fechadenacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        jLabel_sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_sexo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_sexo.setText("Sexo:");
        getContentPane().add(jLabel_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jLabel_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_mail.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mail.setText("Em@il:");
        getContentPane().add(jLabel_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jLabel_tel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_tel.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tel.setText("Teléfono:");
        getContentPane().add(jLabel_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel_dir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_dir.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_dir.setText("Dirrección:");
        getContentPane().add(jLabel_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel_telmedico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telmedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telmedico.setText("Médico solicitante:");
        getContentPane().add(jLabel_telmedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jLabel_telefonodelmedico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefonodelmedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefonodelmedico.setText("Teléfono del médico:");
        getContentPane().add(jLabel_telefonodelmedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        jLabel_correodelmedico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_correodelmedico.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_correodelmedico.setText("Correo del médico:");
        getContentPane().add(jLabel_correodelmedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        jLabel_facturar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_facturar.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_facturar.setText("Facturar:");
        getContentPane().add(jLabel_facturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, -1));

        jLabel_Datosdefacturacion.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel_Datosdefacturacion.setText("Datos de facturación");
        getContentPane().add(jLabel_Datosdefacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, -1, -1));

        jLabel_RFC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_RFC.setText("RFC");
        getContentPane().add(jLabel_RFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        jLabel_razonsocial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_razonsocial.setText("Razón social:");
        getContentPane().add(jLabel_razonsocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, -1));

        jLabel_usoCFDI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_usoCFDI.setText("Uso de CFDI:");
        getContentPane().add(jLabel_usoCFDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, -1, -1));

        jLabel_metododepago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_metododepago.setText("Método de pago:");
        getContentPane().add(jLabel_metododepago, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        jLabel_montototal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_montototal.setText("Monto Total:");
        getContentPane().add(jLabel_montototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, -1, -1));

        jLabel_emailfacturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_emailfacturacion.setText("Em@il facturación:");
        getContentPane().add(jLabel_emailfacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, -1, -1));

        jLabel_modificadopor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_modificadopor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_modificadopor.setText("Ultima modificación por:");
        getContentPane().add(jLabel_modificadopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        txt_idpaciente.setBackground(new java.awt.Color(153, 153, 255));
        txt_idpaciente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_idpaciente.setForeground(new java.awt.Color(255, 255, 255));
        txt_idpaciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idpaciente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idpaciente.setEnabled(false);
        txt_idpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpacienteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 270, -1));

        txt_empresa.setBackground(new java.awt.Color(153, 153, 255));
        txt_empresa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_empresa.setForeground(new java.awt.Color(255, 255, 255));
        txt_empresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_empresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 270, -1));

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
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 270, -1));

        txt_apellido.setBackground(new java.awt.Color(153, 153, 255));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 270, -1));

        txt_edad.setBackground(new java.awt.Color(153, 153, 255));
        txt_edad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(255, 255, 255));
        txt_edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_edad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 270, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 330, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 330, -1));

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 330, -1));

        txt_nombremedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombremedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombremedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombremedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombremedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombremedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 330, -1));

        txt_telefonom.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefonom.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefonom.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefonom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefonom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefonom, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 330, -1));

        txt_mailmedico.setBackground(new java.awt.Color(153, 153, 255));
        txt_mailmedico.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mailmedico.setForeground(new java.awt.Color(255, 255, 255));
        txt_mailmedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mailmedico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mailmedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 330, -1));

        txt_facturar.setBackground(new java.awt.Color(153, 153, 255));
        txt_facturar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_facturar.setForeground(new java.awt.Color(255, 255, 255));
        txt_facturar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_facturar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_facturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 210, -1));

        txt_RFC.setBackground(new java.awt.Color(153, 153, 255));
        txt_RFC.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_RFC.setForeground(new java.awt.Color(255, 255, 255));
        txt_RFC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RFC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_RFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 450, -1));

        txt_razonsocial.setBackground(new java.awt.Color(153, 153, 255));
        txt_razonsocial.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_razonsocial.setForeground(new java.awt.Color(255, 255, 255));
        txt_razonsocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_razonsocial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_razonsocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 450, -1));

        txt_montototal.setBackground(new java.awt.Color(153, 153, 255));
        txt_montototal.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_montototal.setForeground(new java.awt.Color(255, 255, 255));
        txt_montototal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_montototal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_montototal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montototalKeyTyped(evt);
            }
        });
        getContentPane().add(txt_montototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 450, -1));

        txt_mailfacturacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_mailfacturacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mailfacturacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_mailfacturacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mailfacturacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_mailfacturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mailfacturacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_mailfacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 450, -1));

        txt_ultimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimaModificacion.setEnabled(false);
        txt_ultimaModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ultimaModificacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 230, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Paciente");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 190, 35));
        getContentPane().add(jDateChooser_fnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 270, 25));

        cmb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        getContentPane().add(cmb_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 270, 25));

        cmb_CFDI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "P01 Por definir.", "D01 Honorarios médicos, dentales y gastos hospitalarios.", "D02 Gastos médicos por incapacidad o discapacidad.", "D03 Gastos funerales.", "D04 Donativos.", "D05 Intereses reales efectivamente pagados por créditos hipotecarios (casa habitación).", "D06 Aportaciones voluntarias al SAR.", "D07 Primas por seguros de gastos médicos.", "D08 Gastos de transportación escolar obligatoria.", "D09 Depósitos en cuentas para el ahorro, primas que tengan como base planes de pensiones.", "D10 Pagos por servicios educativos (colegiaturas).", "G01 Adquisición de mercancias.", "G02 Devoluciones, descuentos o bonificaciones.", "G03 Gastos en general.", "I01 Construcciones.", "I02 Mobiliario y equipo de oficina por inversiones.", "I03 Equipo de transporte.", "I04 Equipo de computo y accesorios.", "I05 Dados, troqueles, moldes, matrices y herramental.", "I06 Comunicaciones telefónicas.", "I07 Comunicaciones satelitales.", "I08 Otra maquinaria y equipo." }));
        getContentPane().add(cmb_CFDI, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, 25));

        cmb_metodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Efectivo", "Transferencia", "Depósito", "Tarjeta de Crédito/Débito" }));
        getContentPane().add(cmb_metodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 210, 25));

        jButton_Estudios.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Estudios.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Estudios.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Estudios.setText("Estudios");
        jButton_Estudios.setBorder(null);
        jButton_Estudios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EstudiosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Estudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 510, 190, 35));

        jButton_Estudios1.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Estudios1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Estudios1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Estudios1.setText("Recibo");
        jButton_Estudios1.setBorder(null);
        jButton_Estudios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Estudios1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Estudios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 510, 190, 35));

        jLabel_Wallpaper2.setBackground(new java.awt.Color(204, 204, 0));
        jLabel_Wallpaper2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel_Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo2.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 620, 420));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoUni.png"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montototalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montototalKeyTyped
        // TODO add your handling code here:
     

    }//GEN-LAST:event_txt_montototalKeyTyped

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        
     int validacion = 0;
     SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
     String empresa, nombre_paciente, apellido_paciente, edad, fnacimiento, sexo, mail, telefono, direccion, nombre_medico, telefono_medico, mail_medico, facturar, RFC, razonSocial, CFDI, metododePago, montoTotal, mailfacturacion ;
                 
     empresa = txt_empresa.getText().trim();
     nombre_paciente = txt_nombre.getText().trim();
     apellido_paciente = txt_apellido.getText().trim();
     edad = txt_edad.getText().trim();
     fnacimiento = dFormat.format(jDateChooser_fnacimiento.getDate());
     sexo = cmb_sexo.getSelectedItem().toString();
     mail = txt_mail.getText().trim();
     telefono = txt_telefono.getText().trim();
     direccion = txt_direccion.getText().trim();
     nombre_medico = txt_nombremedico.getText().trim();
     telefono_medico = txt_telefonom.getText().trim();
     mail_medico = txt_mailmedico.getText().trim();
     facturar = txt_facturar.getText().trim();
     RFC = txt_RFC.getText().trim();
     razonSocial = txt_razonsocial.getText().trim();
     CFDI = cmb_CFDI.getSelectedItem().toString();
     metododePago = cmb_metodoPago.getSelectedItem().toString();
     montoTotal = txt_montototal.getText().trim();
     mailfacturacion = txt_mailfacturacion.getText().trim();
     
     if(empresa.equals("")) {
       txt_empresa.setBackground(Color.red);
       validacion++;
     }
     if(nombre_paciente.equals("")) {
       txt_nombre.setBackground(Color.red);
       validacion++;
     }
     if(apellido_paciente.equals("")) {
       txt_apellido.setBackground(Color.red);
       validacion++;
     }
     if(edad.equals("")) {
       txt_edad.setBackground(Color.red);
       validacion++;
     }
     if(mail.equals("")) {
       txt_mail.setBackground(Color.red);
       validacion++;
     }
     if(telefono.equals("")) {
       txt_telefono.setBackground(Color.red);
       validacion++;
     }
     if(direccion.equals("")) {
       txt_direccion.setBackground(Color.red);
       validacion++;
     }
     if(nombre_medico.equals("")) {
       txt_nombremedico.setBackground(Color.red);
       validacion++;
     }
     if(telefono_medico.equals("")) {
       txt_telefonom.setBackground(Color.red);
       validacion++;
     }
     if(mail_medico.equals("")) {
       txt_mailmedico.setBackground(Color.red);
       validacion++;
     }
      if(facturar.equals("")) {
       txt_facturar.setBackground(Color.red);
       validacion++;
     }
      if(RFC.equals("")) {
       txt_RFC.setBackground(Color.red);
       validacion++;
     }
      if(razonSocial.equals("")) {
       txt_razonsocial.setBackground(Color.red);
       validacion++;
     }
      if(montoTotal.equals("")) {
       txt_montototal.setBackground(Color.red);
       validacion++;
     }
      if(mailfacturacion.equals("")) {
       txt_mailfacturacion.setBackground(Color.red);
       validacion++;
     } 
        
      if (validacion == 0) {
      
        try {
        
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update pacientes set empresa_paciente=?, nombre_paciente=?, apellido_paciente=?, edad_paciente=?, fnacimiento_paciente=?, sexo_paciente=?, mail_paciente=?, tel_paciente=?, dir_paciente=?, nombredelmedico_paciente=?, telefonodelmedico_paciente=?, maildelmedico_paciente=?, facturar_paciente=?, ultima_modificacion=?"
                   + "where id_paciente = '" + IDpaciente_update + "'");
            
            
            pst.setString(1, empresa);
            pst.setString(2, nombre_paciente);
            pst.setString(3, apellido_paciente);
            pst.setString(4, edad);
            pst.setString(5, fnacimiento);
            pst.setString(6, sexo);
            pst.setString(7, mail);
            pst.setString(8, telefono);
            pst.setString(9, direccion);
            pst.setString(10, nombre_medico);
            pst.setString(11, telefono_medico);
            pst.setString(12, mail_medico);
            pst.setString(13, facturar);
            pst.setString(14, user);
            
            pst.executeUpdate();
            cn.close();
            

            
        } catch (SQLException e) {
          System.err.println("Error en actualizar paciente." + e);
          JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar paciente!!, contacte al programador.");
        }  
        
                try {
        
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "update facturacion set RFC_facturacion=?, razonsocial_facturacion=?, usodeCFDI_facturacion=?, metododepago_paciente=?, montototal_paciente=?, email_facturacion=?"
                   + "where id_paciente = '" + IDpaciente_update + "'");
            
            pst2.setString(1, RFC);
            pst2.setString(2, razonSocial);
            pst2.setString(3, CFDI);
            pst2.setString(4, metododePago);
            pst2.setString(5, montoTotal);
            pst2.setString(6, mailfacturacion);
            
            pst2.executeUpdate();
            cn2.close();
            
            Limpiar();
            
            txt_idpaciente.setBackground(Color.green);
            txt_empresa.setBackground(Color.green);
            txt_nombre.setBackground(Color.green);
            txt_apellido.setBackground(Color.green);
            txt_edad.setBackground(Color.green);
            txt_mail.setBackground(Color.green);
            txt_telefono.setBackground(Color.green);
            txt_direccion.setBackground(Color.green);
            txt_nombremedico.setBackground(Color.green);
            txt_telefonom.setBackground(Color.green);
            txt_mailmedico.setBackground(Color.green);
            txt_facturar.setBackground(Color.green);
            txt_ultimaModificacion.setBackground(Color.green);
            txt_RFC.setBackground(Color.green);
            txt_razonsocial.setBackground(Color.green);
            txt_montototal.setBackground(Color.green);
            txt_mailfacturacion.setBackground(Color.green);
            
            JOptionPane.showMessageDialog(null, "Actualización correcta.");
            this.dispose();
            
        } catch (SQLException e) {
          System.err.println("Error en actualizar paciente." + e);
          JOptionPane.showMessageDialog(null, "¡¡ERROR al actualizar paciente!!, contacte al programador.");
        } 
          
      } else {
        JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
      }
      
      
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void txt_mailfacturacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailfacturacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mailfacturacionKeyTyped

    private void txt_ultimaModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ultimaModificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ultimaModificacionActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_idpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idpacienteActionPerformed

    private void jButton_EstudiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EstudiosActionPerformed
        Estudio_paciente Estudio_Paciente = new Estudio_paciente();
        Estudio_Paciente.setVisible(true);
        empresa = txt_empresa.getText().trim();

    }//GEN-LAST:event_jButton_EstudiosActionPerformed

    private void jButton_Estudios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Estudios1ActionPerformed
       RegistrodeRecibos registrodeRecibos = new RegistrodeRecibos();
       registrodeRecibos.setVisible(true);
    }//GEN-LAST:event_jButton_Estudios1ActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_paciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_CFDI;
    private javax.swing.JComboBox<String> cmb_metodoPago;
    private javax.swing.JComboBox<String> cmb_sexo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Estudios;
    private javax.swing.JButton jButton_Estudios1;
    private com.toedter.calendar.JDateChooser jDateChooser_fnacimiento;
    private javax.swing.JLabel jLabel_Datosdefacturacion;
    private javax.swing.JLabel jLabel_IDdelpaciente;
    private javax.swing.JLabel jLabel_RFC;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_Wallpaper2;
    private javax.swing.JLabel jLabel_apellidos;
    private javax.swing.JLabel jLabel_correodelmedico;
    private javax.swing.JLabel jLabel_dir;
    private javax.swing.JLabel jLabel_edad;
    private javax.swing.JLabel jLabel_emailfacturacion;
    private javax.swing.JLabel jLabel_empresa;
    private javax.swing.JLabel jLabel_facturar;
    private javax.swing.JLabel jLabel_fechadenacimiento;
    private javax.swing.JLabel jLabel_mail;
    private javax.swing.JLabel jLabel_metododepago;
    private javax.swing.JLabel jLabel_modificadopor;
    private javax.swing.JLabel jLabel_montototal;
    private javax.swing.JLabel jLabel_nombres;
    private javax.swing.JLabel jLabel_razonsocial;
    private javax.swing.JLabel jLabel_sexo;
    private javax.swing.JLabel jLabel_tel;
    private javax.swing.JLabel jLabel_telefonodelmedico;
    private javax.swing.JLabel jLabel_telmedico;
    private javax.swing.JLabel jLabel_usoCFDI;
    private javax.swing.JTextField txt_RFC;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_facturar;
    private javax.swing.JTextField txt_idpaciente;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_mailfacturacion;
    private javax.swing.JTextField txt_mailmedico;
    private javax.swing.JTextField txt_montototal;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombremedico;
    private javax.swing.JTextField txt_razonsocial;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_telefonom;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables

 
   public void Limpiar() {
   
   txt_idpaciente.setText("");
   txt_empresa.setText("");
   txt_nombre.setText("");
   txt_apellido.setText("");
   txt_edad.setText("");
   txt_mail.setText("");
   txt_telefono.setText("");
   txt_direccion.setText("");
   txt_nombremedico.setText("");
   txt_telefonom.setText("");
   txt_mailmedico.setText("");
   txt_facturar.setText("");
   txt_ultimaModificacion.setText("");        
   txt_RFC.setText("");
   txt_razonsocial.setText("");
   txt_montototal.setText("");
   txt_mailfacturacion.setText("");
   }

}
