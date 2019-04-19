package com.eduardocode.jasonviewer.view.component;

/**
 * <h1>IFrontComponent</h1>
 * Componente que permite la modularidad y separacion de las opciones visuales
 * y menu de los recursos para el usuario
 * @author cheetos
 *
 * @param <Entity, EntityService>
 */
public interface IFrontComponent<Entity, EntityService> {
	
	/**
	 * Define la posibilidad de implemetar un servicio principal sobre el cual
	 * el componente va a trabajar
	 * @param resourceService
	 */
	public void setService(EntityService resourceService);
	
	/**
	 * Loop principal de la interaccion entre el usuario y los recursos
	 */
	public void interact();
	/**
	 * visualizacion de la lista de todos los recursos existentes
	 */
	void showMenu();
	
	/**
	 * Metodo para desarrollar la logica de la reproduccion del recurso deseado
	 * por el usuario
	 * @param option
	 */
	void showResourcePlayer(int option);
}
