/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;
import lombok.Getter;

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
	
	public Watchable(String title, String genre, String director, short year) {
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.year = year;
	}
	
	public Watchable(String title, String genre, String director, int duration, short year) {
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.year = year;
	}
	
	public String getIsViewed() {
		return (this.viewed) ? "Si" : "No";
	}
	
	public boolean getViewed() {
		return this.viewed;
	}
	
	/**
	 * Permite la implementacion de la simulacion de visualizacion de cada
	 * recurso que herede de la clase Watchable
	 */
	public abstract void playResource();
}
