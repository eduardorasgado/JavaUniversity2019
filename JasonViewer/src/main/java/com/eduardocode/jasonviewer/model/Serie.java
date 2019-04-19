/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.ArrayList;

import lombok.Data;

/**
 * <h1>Serie</h1>
 * Representa un modelo. Hereda de Watchable
 * <p>
 * Representacion de una serie dentro de la aplicacion
 * Una serie posee capitulos
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
 *
 */
@Data
public class Serie extends Watchable {
	
	private int id;
	private int seasonQuantity;
	private ArrayList<Chapter> chapters;

	public Serie() {
		// default constructor
	}
	public Serie(String nombre, String genre, String director, short year) {
		super(nombre, genre, director, year);
	}
	
	@Override
	public void playResource() {
		this.chapters = new ArrayList<Chapter>();		
	}

	@Override
	public String toString() {
		return "Serie [seasonQuantity=" + seasonQuantity + ", getTitle()=" + getTitle()
				+ ", getGenre()=" + getGenre() + ", getDuration()=" + getDuration() 
				+ ", isViewed()=" + getIsViewed() + ", chapters=" + chapters + "]";
	}
	
	
}
