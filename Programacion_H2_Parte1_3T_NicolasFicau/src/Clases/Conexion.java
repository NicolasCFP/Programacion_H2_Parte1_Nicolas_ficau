package Clases;
import java.sql.*;
public class Conexion {
    public static Connection conectar() {
        String URL = "jdbc:mysql://localhost:3307/cine_nicolasficau";
        String USUARIO = "root";
        String CONTRASENA = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}