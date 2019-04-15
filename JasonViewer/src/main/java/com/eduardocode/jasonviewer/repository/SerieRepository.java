/**
 * 
 */
package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Serie;

/**
 * Repositorio encargado de gestionar las transacciones entre el servicio de series
 * y los modelos, maneja la gestion de la lista total de series
 * @author cheetos
 *
 */
public class SerieRepository implements JVRepository{
	ArrayList<Serie> series = null;
	
	public SerieRepository() {
		series = new ArrayList<Serie>();
	}
	
	/**
	 * Devuelve todas las series que hay en la lista
	 */
	public ArrayList<Serie> getAll() {
		return series;
	}
	
	/**
	 * devuelve una serie dado un indice y solo si este indice es valido
	 * @param index
	 * @return
	 */
	public Serie findByIndex(int index) {
		if(index > 0 && index < series.size()) {
			return series.get(index);
		} else {
			return null;
		}
	}
}
