/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * Representa un capitulo que le pertenece a una serie
 * @author cheetos
 *
 */
@Data
public class Chapter extends Movie{
	private int id;
	private int seasonNumber;
	private Serie serie;
	
	public Chapter(String title, int duration) {
		super(title, duration);
	}
	/**
	 * Implementacion y sobreescritura del metodo heredado de Movie para
	 * simular la visualizacion en este caso de un recurso
	 */
	@Override
	public void playResource() {
		super.playResource();
		// una serie se marca en visto cuando se termina de ver todos los chapters
		// un capitulo se marca como visto
	}
	@Override
	public String toString() {
		return "Chapter [seasonNumber=" + seasonNumber + ", serie=" + serie.getTitle() 
				+ ", getIsViewed()=" + getIsViewed()
				+ ", getTitle()=" + getTitle() + "]";
	}
	
	
	
}
