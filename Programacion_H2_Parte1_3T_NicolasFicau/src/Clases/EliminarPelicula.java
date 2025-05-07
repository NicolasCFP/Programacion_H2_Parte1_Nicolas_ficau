package Clases;
import java.sql.*;
import java.util.Scanner;

public class EliminarPelicula {
    public static void eliminar() {
        Scanner sc = new Scanner(System.in);

        // Solicitar el ID de la película a eliminar
        System.out.print("ID de la película a eliminar: ");
        String id = sc.nextLine();

        // Conectar a la base de datos
        Connection conn = Conexion.conectar();

        // Consulta para verificar si la película existe
        String sql = "SELECT COUNT(*) FROM peliculas WHERE id_pelicula = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Verificar si la película existe
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int cantidad = rs.getInt(1);

                // Si la película existe, seliminar
                if (cantidad > 0) {
                    // Consulta para eliminar la película
                    sql = "DELETE FROM peliculas WHERE id_pelicula = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, id);
                    ps.executeUpdate();
                    System.out.println("Película eliminada correctamente.");
                } else {
                    // Si no existe, mostramos mensaje
                    System.out.println("No existe una película con ese ID.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar recursos (si son no nulos)
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos: " + e.getMessage());
            }
            sc.close();
        }
    }
}
