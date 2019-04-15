/**
 * 
 */
package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Chapter;
import com.eduardocode.jasonviewer.model.Serie;

/**
 * Repositorio que opera de interfaz transaccional entre las demas capas y
 * el almacenamiento de los capitulos de una serie
 * @author cheetos
 *
 */
public class ChapterRepository implements JVRepository<Chapter> {

	// todos los capitulos  en general
	ArrayList<Chapter> chapters = null;
	
	public ChapterRepository() {
		chapters = new ArrayList<Chapter>();
	}
	
	/**
	 * Devuelve todos los capitulos de una serie determinada
	 * @param serie
	 * @return
	 */
	public ArrayList<Chapter> getAllBySerie(Serie serie){
		return serie.getChapters();
	}
	
	/**
	 * Devuelve la lista completa de todos los capitulos existentes
	 */
	@Override
	public ArrayList<Chapter> getAll() {
		return chapters;
	}

	/**
	 * Devuelve un capitulo existente dado
	 */
	@Override
	public Chapter findByIndex(int index) {
		if(index >= 0 && index < chapters.size()) {
			return chapters.get(index);
		}
		return null;
	}

	@Override
	public int getResourceIndex(Chapter chapter) {
		for(int i = 0;i < chapters.size(); i++) {

			String dbRTitle = chapters.get(i).getTitle();
			String givenRTitle = chapter.getTitle();
			
			if(dbRTitle.equals(givenRTitle)) {
				// retorna el indice de la pelicula dada
				return i;
			}
		}
		// serie no existe
		return -1;
	}

	@Override
	public void insert(Chapter chapter) {
		chapters.add(chapter);
		
	}

	@Override
	public boolean delete(int index) {
		if(index >= 0 && index < chapters.size()) {
			chapters.remove(index);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(int index, Chapter chapter) {
		if(index >= 0 && index < chapters.size()) {
			chapters.set(index, chapter);
			return true;
		} else {
			return false;
		}
	}

}
