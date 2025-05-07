package Clases;
import java.util.Scanner;//Importa la clase scanner
public class Principal {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);//Crea un objeto Scanner para leer desde la consola
		//menu en la pantalla
		System.out.println("----MENU----");
		System.out.println("1 - Ver películas");
		System.out.println("2 - Salir");
		System.out.println("3 - Agregar Pelicula");
		System.out.println("4 - Eliminar Peliculla");
		System.out.println("5 - Modificar Peliculla");
		System.out.println("Seleccione una opcion:");
		int opcion = sc.nextInt();//lee la opcion que ha puesto el usuario
		
		
		if (opcion == 1) {
			MostrarPeliculas.mostrar();//llama al metodo 
		}else if (opcion == 2) {
			System.out.println("¡Adios!");//despedida
			//Nuevas funciones
		}else if (opcion == 3) {
			AgregarPelicula.agregar();
		}else if (opcion == 4) {
			EliminarPelicula.eliminar();
		}else if (opcion == 5) {
			ModificarPelicula.modificar();
		}else {
			System.out.println("Opción no valida");
		}
		
		sc.close();//cierra el scanner
	}
}