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
	private ArrayList<Serie> seriesList = null;
	
	public SerieRepository() {
		this.seriesList = new ArrayList<Serie>();
		this.initSerieList();
	}
	
	/**
	 * Devuelve todas las series que hay en la lista
	 */
	@Override
	public ArrayList<Serie> getAll() {
		return this.seriesList;
	}
	
	/**
	 * devuelve una serie dado un indice y solo si este indice es valido
	 * @param index
	 * @return
	 */
	@Override
	public Serie findByIndex(int index) {
		if(index >= 0 && index < seriesList.size()) {
			return seriesList.get(index);
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
		for(int i = 0;i < seriesList.size(); i++) {

			String dbRTitle = seriesList.get(i).getTitle();
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
		seriesList.add(serie);
	}

	/**
	 * actualiza en elemento de la lista de series dado el indice y la misma
	 * serie pero con atributos actualizados
	 */
	@Override
	public boolean update(int index, Serie serie) {
		if(index >= 0 && index < seriesList.size()) {
			seriesList.set(index, serie);
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
		if(index >= 0 && index < seriesList.size()) {
			seriesList.remove(index);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Agrega  elementos a la lista que de series
	 */
	public void initSerieList() {
		this.seriesList.add(new Serie("Vikingos", "Historia", "History Chanel", (short) 2016));
		this.seriesList.add(new Serie("The walking Dead", "Terror", "Pedro Perez", (short) 2012));
		this.seriesList.add(new Serie("Nuestro Planeta", "Documental", "Netflix", (short) 2019));
		this.seriesList.add(new Serie("Spartacus", "Epocas Antiguas", "Netflix", (short) 2017));
		this.seriesList.add(new Serie("Yu gi oh", "Anime", "Takihiro Matzumoto", (short) 2005));
		
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		int season = 1;
		int indexSerie = 0;
		for(int i =1; i <= 100;i++) {
			if(season == 5) {
				// reiniciando el flag para la temporada de los chapters
				season = 1;
			}
			
			Chapter chapter = new Chapter("Capitulo "+(i), 40);
			chapter.setSeasonNumber(season);
			Serie dummySerie = new Serie();
			dummySerie.setTitle(this.seriesList.get(indexSerie).getTitle());
			chapter.setSerie(dummySerie);
			
			chapters.add(chapter);
			if(i % 5 == 0) {
				// cada 5 capitulos se asigna una temporada
				// en total hay 4 temporadas
				season++;
				
			}
			if(i % 20 == 0) {
				indexSerie++;
			}
		}
		
		for(int i =0; i < this.seriesList.size();i++) {
			//System.out.println("index: "+i);
			Serie serie = this.seriesList.get(i);
			// cada uno con 4 temporadas
			serie.setSeasonQuantity(4);
			ArrayList<Chapter> cs = 
					new ArrayList<Chapter>(chapters.subList( (0+(i*20)), (20+(i*20)) ));
			
			serie.setChapters(cs);
			// guardar la serie en el lugar de la lista que le corresponde
			this.seriesList.set(i, serie);
		}
	}
}
