package Clases;
import java.sql.*;
import java.util.Scanner;

public class AgregarPelicula {
    public static void agregar() {
        Scanner sc = new Scanner(System.in);//Scaner para leet datos desde la consola

        try {
            // Solicitar datos de la película
            System.out.print("ID de la película: ");
            String id = sc.nextLine();
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Año de estreno: ");
            int estreno = sc.nextInt();
            System.out.print("Género: ");
            int id_genero = sc.nextInt();
            System.out.print("Duración en minutos: ");
            int duracion = sc.nextInt();
            System.out.print("Valoración (1-10): ");
            int valoracion = sc.nextInt();

            // Conectar a la base de datos
            Connection conn = Conexion.conectar();

            // Consulta para verificar si la película existe
            String sql = "SELECT COUNT(*) FROM peliculas WHERE id_pelicula = ?";
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                rs.next();  // Para obtener el resultado de la consulta
                int cantidad = rs.getInt(1);

                // Si la película ya existe, no la agregamos
                if (cantidad > 0) {
                    System.out.println("Ya existe una película con ese ID");
                } else {
                    // Si no existe, insertar la nueva película
                    sql = "INSERT INTO peliculas (id_pelicula, titulo, estreno, id_genero, duracion, valoracion) VALUES (?, ?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, id);
                    ps.setString(2, titulo);
                    ps.setInt(3, estreno);
                    ps.setInt(4, id_genero);
                    ps.setInt(5, duracion);
                    ps.setInt(6, valoracion);
                    ps.executeUpdate();
                    System.out.println("Película añadida correctamente.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                // Cerrar recursos
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando recursos: " + e.getMessage());
                }

                // Cerrar el Scanner
                sc.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

