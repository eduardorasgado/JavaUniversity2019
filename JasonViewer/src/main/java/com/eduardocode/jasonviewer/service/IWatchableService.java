package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Movie;

/**
 * Interfaz que determina los metodos posibles para los recursos watchables
 * @author cheetos
 *
 */
public interface IWatchableService {
	
	public void playResource(int index);
	
	public ArrayList<?> getAll();
}
