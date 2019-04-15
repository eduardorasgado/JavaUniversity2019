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
public class SerieRepository implements JVRepository<Serie>{
	ArrayList<Serie> series = null;
	
	public SerieRepository() {
		series = new ArrayList<Serie>();
	}
	
	/**
	 * Devuelve todas las series que hay en la lista
	 */
	@Override
	public ArrayList<Serie> getAll() {
		return series;
	}
	
	/**
	 * devuelve una serie dado un indice y solo si este indice es valido
	 * @param index
	 * @return
	 */
	@Override
	public Serie findByIndex(int index) {
		if(index >= 0 && index < series.size()) {
			return series.get(index);
		} else {
			return null;
		}
	}

	@Override
	public int getResourceIndex(Serie serie) {
		for(int i = 0;i < series.size(); i++) {

			String dbRTitle = series.get(i).getTitle();
			String givenRTitle = serie.getTitle();
			
			if(dbRTitle.equals(givenRTitle)) {
				// retorna el indice de la pelicula dada
				return i;
			}
		}
		// serie no existe
		return -1;
	}

	/**
	 * Inserta o crea un nuevo elemento dentro de la lista de series
	 */
	@Override
	public void insert(Serie serie) {
		series.add(serie);
	}

	/**
	 * actualiza en elemento de la lista de series dado el indice y la misma
	 * serie pero con atributos actualizados
	 */
	@Override
	public boolean update(int index, Serie serie) {
		if(index >= 0 && index < series.size()) {
			series.set(index, serie);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un elemento dentro de la serie dado un indice
	 */
	@Override
	public boolean delete(int index) {
		if(index >= 0 && index < series.size()) {
			series.remove(index);
			return true;
		} else {
			return false;
		}
	}
}
