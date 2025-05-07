package Clases;
import java.sql.*;
public class Conexion { //Conexion con la base de datos
    public static Connection conectar() {
        String URL = "jdbc:mysql://localhost:3307/cine_nicolasficau";
        String USUARIO = "root";
        String CONTRASENA = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Carga el driver de MySQL

            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error de conexión: " + e.getMessage());// Muestra mensaje de error si falla
            return null;// Retorna null si no se puede conectar
        }
    }
}