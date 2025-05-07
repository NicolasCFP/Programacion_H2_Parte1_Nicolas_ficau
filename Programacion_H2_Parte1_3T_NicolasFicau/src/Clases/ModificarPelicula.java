package Clases;
import java.sql.*;
import java.util.Scanner;

public class ModificarPelicula {
    public static void modificar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID de la película a modificar: ");
        String id = sc.nextLine();

        Connection conn = Conexion.conectar();

        String sql = "SELECT COUNT(*) FROM peliculas WHERE id_pelicula = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            int cantidad = rs.getInt(1);

            if (cantidad > 0) {
                System.out.print("Nuevo título: ");
                String titulo = sc.nextLine();
                System.out.print("Nuevo año de estreno: ");
                int estreno = Integer.parseInt(sc.nextLine());
                System.out.print("Nuevo género: ");
                int id_genero = Integer.parseInt(sc.nextLine());
                System.out.print("Nueva duración en minutos: ");
                int duracion = Integer.parseInt(sc.nextLine());
                System.out.print("Nueva valoración (1-10): ");
                int valoracion = Integer.parseInt(sc.nextLine());

                sql = "UPDATE peliculas SET titulo = ?, estreno = ?, id_genero = ?, duracion = ?, valoracion = ? WHERE id_pelicula = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, titulo);
                ps.setInt(2, estreno);
                ps.setInt(3, id_genero);
                ps.setInt(4, duracion);
                ps.setInt(5, valoracion);
                ps.setString(6, id);
                ps.executeUpdate();

                System.out.println("Película modificada correctamente.");
            } else {
                System.out.println("No existe una película con ese ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
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
