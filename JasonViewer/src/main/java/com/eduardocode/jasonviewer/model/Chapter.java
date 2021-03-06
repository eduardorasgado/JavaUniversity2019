/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * <h1>Chapter</h1>
 * Hereda de {@link Movie} en un contexto tecnico mas no logistico o de negocio
 * <p>
 * Representa un capitulo que le pertenece a una serie
 * 
 * @see Watchable
 * @author cheetos
 * @versio 1.1
 * @since 2019
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
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void playResource() {
		// una serie se marca en visto cuando se termina de ver todos los chapters
		// un capitulo se marca como visto
	}
	@Override
	public String toString() {
		return "Chapter [seasonNumber=" + seasonNumber
				+ ", getIsViewed()=" + getIsViewed()
				+ ", getTitle()=" + getTitle() + "]";
	}
	
	
	
}
