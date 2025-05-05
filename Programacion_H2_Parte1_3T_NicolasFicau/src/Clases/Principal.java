package Clases;
import java.util.Scanner;
public class Principal {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----MENU----");
		System.out.println("1 - Ver películas");
		System.out.println("2 - Salir");
		System.out.println("Seleccione una opcion:");
		int opcion = sc.nextInt();
		
		
		if (opcion == 1) {
			MostrarPeliculas.mostrar();
		}else if (opcion == 2) {
			System.out.println("¡Adios!");
		}else {
			System.out.println("Opcion no válida");
		}
		
		sc.close();
	}
}