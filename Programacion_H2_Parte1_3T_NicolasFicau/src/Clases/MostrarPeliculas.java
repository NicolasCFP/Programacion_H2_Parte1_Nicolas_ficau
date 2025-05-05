package Clases;

import java.sql.*;

public class MostrarPeliculas {
    public static void mostrar() {
        String sql = "SELECT id_pelicula, titulo, estreno, g.nombre_genero AS genero, duracion, valoracion " +
                     "FROM peliculas JOIN generos g ON peliculas.id_genero = g.id_genero";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id_pelicula"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Estreno: " + rs.getInt("estreno"));
                System.out.println("Duración: " + rs.getInt("duracion"));
                System.out.println("Valoración: " + rs.getInt("valoracion"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
