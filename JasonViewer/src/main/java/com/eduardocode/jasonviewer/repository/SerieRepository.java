/**
 * 
 */
package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
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

	/**
	 * Devuelve el indice de una serie dada una instancia de serie que
	 * existe en la lista de series
	 */
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
	
	/**
	 * Agrega  elementos a la lista que de series
	 */
	public void initSerieList() {
		this.series.add(new Serie("Vikingos", "Historia", "History Chanel", (short) 2016));
		this.series.add(new Serie("The walking Dead", "Terror", "Pedro Perez", (short) 2012));
		this.series.add(new Serie("Nuestro Planeta", "Documental", "Netflix", (short) 2019));
		this.series.add(new Serie("Spartacus", "Epocas Antiguas", "Netflix", (short) 2017));
		this.series.add(new Serie("Yu gi oh", "Anime", "Takihiro Matzumoto", (short) 2005));
		
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		for(int i =0; i < series.size();i++) {
			Chapter chapter = new Chapter("Capitulo "+(i+1), 40);
			chapters.add(chapter);
		}
		
		for(int i =0; i < series.size();i++) {
			Serie serie = series.get(i);
			// cada uno con 4 temporadas
			serie.setSeasonQuantity(4);
			// incluir los capitulos para cada uno
			serie.setChapters(chapters);
			// guardar la serie en el lugar de la lista que le corresponde
			series.set(i, serie);
		}
	}
}
