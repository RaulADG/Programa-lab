package clases;
import java.sql.*;

public class Conexion {
    //Conexión Local
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://laboratoriosbiosalud.com.mx:3306/bd_ds", "nrb96im9uenp1", "aoAifcMP3{%a");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local " + e);
        }
        return (null);
    }
}

