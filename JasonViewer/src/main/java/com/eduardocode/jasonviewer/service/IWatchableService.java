package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

/**
 * Interfaz que determina los metodos posibles para los recursos watchables
 * @author cheetos
 *
 */
public interface IWatchableService<T> {
	
	public void playResource(int index);
	
	public ArrayList<T> getAll();
	
	// TODO: Implementacion de los metodos crud aqui
}
