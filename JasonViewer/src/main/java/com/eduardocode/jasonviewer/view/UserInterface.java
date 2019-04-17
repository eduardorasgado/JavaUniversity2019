/**
 * 
 */
package com.eduardocode.jasonviewer.view;

import java.util.Scanner;

import lombok.Data;

/**
 * Clase que representa la interaccion directa con el usuario
 * @author cheetos
 *
 */
@Data
public class UserInterface {
	private Scanner sc = null;
	private boolean closeApp;
	
	public UserInterface() {
		sc = new Scanner(System.in);
		this.closeApp = false;
	}
	
	/**
	 * Muestra la lista de las posibles opciones que tiene el usuario para leer
	 * o ver
	 */
	public void showMenu() {
		System.out.println("\n[WELCOME TO JASON VIEWER]");
        System.out.println("");
        System.out.println("Selecciona la opcion a la que deseas accesar.");
        System.out.println("1. Movies");
        System.out.println("2. Series");
        System.out.println("3. Books");
        System.out.println("4. Magazines");
        System.out.println("5. Report");
        System.out.println("6. Report Today");
        System.out.println("0. Exit");
	}
	
	/**
	 * Valida la opcion proporcionada por el usuario, asi mismo la devuelve si
	 * esta pasa la validacion
	 * @return
	 */
	public int getInputAndValidating() {
		while(true) {
			System.out.println("Escriba su opcion: ");
			try {
				int opcion = Integer.valueOf(sc.nextLine()); // lo que el usuario introduzca en la consola
				return opcion;
			} catch (NumberFormatException e) {
				System.out.println("Selecciona una opcion, tu opcion no es valida");
			}
		}
	}
	
	/**
	 * Loop principal de la aplicacion, se manda a llamar todo aquello que esta
	 * en la primera capa de menus, es decir seleccion de aquellos reproducibles
	 * por el usuario
	 */
	public void applicationLoop() {
		this.showMenu();
		int opcion = this.getInputAndValidating();
		if(opcion == 0) {
			System.out.println("Exelente dia, bye!");
			this.closeApp = true;
		}
	}
}
