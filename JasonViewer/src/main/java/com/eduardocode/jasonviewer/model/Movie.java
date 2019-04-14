/**
 * 
 */
package com.eduardocode.jasonviewer.model;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	
	public Movie(String title, String genre, String director, int duration, short year) {
		super();
	}
	/**
	 * Metodo que se toma de la clase abstracta watchable
	 * Describe la simulacion de la visualizacion de un recurso
	 */
	@Override
	public void playResource() {
		// TODO Auto-generated method stub
		
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
}
