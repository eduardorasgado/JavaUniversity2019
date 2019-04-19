/**
 * 
 */
package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Serie;
import com.eduardocode.jasonviewer.repository.SerieRepository;
import com.eduardocode.jasonviewer.view.component.reporter.GeneralReporterUIComponent;

/**
 * Servicio para interactuar con el repositorio de la clase Serie
 * @author cheetos
 *
 */
public class SerieService implements IWatchableService<Serie> {

	private SerieRepository serieRepository;
	
	public SerieService() {
		this.serieRepository = new SerieRepository();
	}

	/**
	 * Devuelve todas las series
	 */
	@Override
	public ArrayList<Serie> getAll() {
		return serieRepository.getAll();
	}

	/**
	 * Devuelve el indice de una serie existente en la lista de series
	 * del repositorio de series
	 */
	@Override
	public int getResourceIndex(Serie serie) {
		return serieRepository.getResourceIndex(serie);
	}

	/**
	 * Devuelve una serie dado el indice que se le otorgue
	 * Devuelve una serie o nulo
	 */
	@Override
	public Serie findByIndex(int index) {
		return serieRepository.findByIndex(index);
	}

	/**
	 * Elimina una serie dado el indice de esta serie.
	 * Devuelve un booleano dependiendo si la serie existe o no
	 */
	@Override
	public boolean delete(int index) {
		return serieRepository.delete(index);
	}

	/**
	 * Actualiza un elemento existente de la lista en los repositorios de serie
	 */
	@Override
	public boolean update(int index, Serie serie) {
		return serieRepository.update(index, serie);
	}
	
	/**
	 * Metodo que retorna la cantidad de capitulos vistos de una serie
	 * @see com.eduardocode.jasonviewer.view.component.reporter.GeneralReporterUIComponent
	 * @param serieIndex
	 * @return
	 */
	public int chaptersViewbySerie(int serieIndex) {
		Serie serie = this.serieRepository.findByIndex(serieIndex);
		int totalView = 0;
		for(Chapter chapter : serie.getChapters()) {
			if(chapter.getViewed()) {
				totalView++;
			}
		}
		return totalView;
	}
	

}
