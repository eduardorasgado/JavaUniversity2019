/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import lombok.Data;

/**
 * <h1>Watchable</h1>
 * Clase padre abstracta
 * <p>
 * Clase abstracta que representa tres clases hijas: serie, chapter y movie
 * Contiene el metodo abstracto 
 * {@code playResource()} que es obligatorio implementar en todo aquello que pertenezca
 * a la familia
 * 
 * @author cheetos
 * @version 1.1
 * @since 2019
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
	
	/**
	 * Metodo que devuelve en lenguaje humano, si un objeto que hereda de watchable
	 * ha sido ya visto
	 * @return Devuelve un si o un no en string
	 */
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
