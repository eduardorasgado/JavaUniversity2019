package com.eduardocode.jasonviewer.view.component;

/**
 * Componente que permite la modularidad y separacion de las opciones visuales
 * y menu de los recursos para el usuario
 * @author cheetos
 *
 * @param <T>
 */
public interface IFrontComponent<T> {
	/**
	 * visualizacion de la lista de todos los recursos existentes
	 */
	public void showMenu();
	
}
