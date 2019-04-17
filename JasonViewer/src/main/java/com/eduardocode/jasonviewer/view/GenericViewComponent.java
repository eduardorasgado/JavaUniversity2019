package com.eduardocode.jasonviewer.view;

import java.util.Scanner;

import lombok.Data;

/**
 * Clase que representa un generico para los componentes de la vista de la aplicacion
 * @author cheetos
 *
 */

@Data
public abstract class GenericViewComponent {
	protected boolean closeApp;
	protected Scanner scanner = null;
	// representa el limite superior para la validacion de la entrada del
	// menu principal
	protected int maxOption;
	
	public GenericViewComponent() {
		scanner = new Scanner(System.in);
		this.closeApp = false;
	}
	/**
	 * Valida la opcion proporcionada por el usuario, asi mismo la devuelve si
	 * esta pasa la validacion
	 * @return
	 */
	protected int getInputAndValidating() {
		while(true) {
			System.out.println("Escriba su opcion: ");
			try {
				int opcion = Integer.valueOf(scanner.nextLine()); // lo que el usuario introduzca en la consola
				if(this.validatingMainMenuInput(opcion)) {
					return opcion;
				} else {
					this.showNotPassedValidationMessage();
				}
			} catch (NumberFormatException e) {
				this.showNotPassedValidationMessage();
			}
		}
	}
	
	/**
	 * valida si la entrada del usuario esta entre los limites numericos permitidos
	 * @param opcion
	 * @return
	 */
	protected boolean validatingMainMenuInput(int opcion) {
		if(opcion >= 0 && opcion <= this.maxOption) {
			return true;
		}
		return false;
	}
	
	/**
	 * Muestra un mensaje de error generico
	 */
	protected void showNotPassedValidationMessage() {
		System.out.println("Selecciona una opcion, tu opcion no es valida");
	}
}
