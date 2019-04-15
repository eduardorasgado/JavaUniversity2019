/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;

/**
 * Representacion de una pelicula en la aplicacion
 * @author cheetos
 *
 */
@Data
public class Movie extends Watchable implements IPlayable {

	private int id;
	private int timeViewed;
	
	
	public Movie() {
		// default constructor
	}
	
	/**
	 * Contructor para la herencia de Chapter
	 * @param title
	 * @param duration
	 */
	public Movie(String title, int duration) {
		super(title, duration);
	}
	
	/**
	 * Constructor para la creacion de Movie
	 * @param title
	 * @param genre
	 * @param director
	 * @param duration
	 * @param year
	 */
	public Movie(String title, String genre, String director, int duration, short year) {
		super(title, genre, director, duration, year);
	}
	/**
	 * Metodo que se toma de la clase abstracta watchable
	 * Describe la simulacion de la visualizacion de un recurso
	 */
	@Override
	public void playResource() {
		/*metodo de demostracion de una implementacion de metodo abstracto
		* dada una clase abstracta, este metodo se implementa realmente en
		* el servicio de las peliculas
		**/
	}

	/**
	 * Metodos que vienen de Interface Playable
	 * Determina y toma registro del momento en que se comienza a ver una pelicula
	 */
	public Date startToSee(Date dateI) {
		// just a checking
        return dateI;
	}

	/**
	 * Toma registro del momento en que se termina una pelicula para
	 * determinar el tiempo que tomo verse, asi pone valor a time Viewed
	 */
	public void stopToSee(Date dateI, Date dateF) {
		int result = (dateF.getTime() > dateI.getTime())
                ? ((int)(dateF.getTime() - dateI.getTime()) / 1000) : 0;

        this.setTimeViewed(result);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", timeViewed=" + timeViewed + ", getTitle()=" + getTitle() + "]";
	}
	
	
}
