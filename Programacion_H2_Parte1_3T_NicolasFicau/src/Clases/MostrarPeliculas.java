package Clases;

import java.sql.*;//Lo necesario para conectarse a la base de datos

public class MostrarPeliculas {
    public static void mostrar() {//metodo para mostrar las peliculas
        String sql = "SELECT id_pelicula, titulo, estreno, g.nombre_genero AS genero, duracion, valoracion " +
                     "FROM peliculas JOIN generos g ON peliculas.id_genero = g.id_genero";

        try (Connection conn = Conexion.conectar();//obtiene la conexion 
             Statement stmt = conn.createStatement();//statement para ejecutar la consulta
             ResultSet rs = stmt.executeQuery(sql)) {//ejecuta la consulta y obtiene resultados

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id_pelicula"));//id de la pelicula
                System.out.println("Título: " + rs.getString("titulo"));//titulo
                System.out.println("Estreno: " + rs.getInt("estreno"));//fecha de estreno
                System.out.println("Duración: " + rs.getInt("duracion"));//duracion
                System.out.println("Valoración: " + rs.getInt("valoracion"));//valoracion
                System.out.println("Género: " + rs.getString("genero"));//genero de la pelicula
                System.out.println("------------------------------");//separador para que sea mas estetico
            }

        } catch (SQLException e) {//captura y muestra cualquier error de la base de datos
            System.out.println("Error: " + e.getMessage());
        }
    }
}
