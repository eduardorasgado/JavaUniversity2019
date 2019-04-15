/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * Clase abstracta que representa tres clases hijas: serie, chapter y movie
 * @author cheetos
 *
 */

@Data
public abstract class Watchable {
	private String title;
	private String genre;
	private String director;
	private int duration;
	private short year;
	private boolean viewed;
	
	public Watchable() {
		// default constructor
	}
	
	public Watchable(String title, int duration) {
		this.title = title;
		this.duration = duration;
	}
	
	public Watchable(String title, String genre, String director, int duration, short year) {
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
	}
	
	public String getIsViewed() {
		String isViewed = (viewed) ? "Si" : "No";
		return isViewed;
	}
	
	/**
	 * Permite la implementacion de la simulacion de visualizacion de cada
	 * recurso que herede de la clase Watchable
	 */
	public abstract void playResource();
}
