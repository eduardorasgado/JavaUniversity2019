package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.repository.MovieRepository;

/**
 * Implementacion de la interfaz watchable para los servicios de las peliculas
 * @author cheetos
 *
 */
public class MovieService implements IWatchableService {

	private MovieRepository movieRepository;
	
	public MovieService() {
		this.movieRepository = new MovieRepository();
	}
	
	/**
	 * Actualiza los atributos respecto a tiempo y si una pelicula ya fue vista o no
	 * dado un indice
	 */
	public void playResource(int index) {	
		Movie movieSelected = this.movieRepository.findByIndex(index);
		
		movieSelected.setViewed(true);
		Date dateI = movieSelected.startToSee(new Date());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		movieSelected.stopToSee(dateI, new Date());
		
		// intercambiar la pelicula que modificamos por el nuevo elemento
		this.movieRepository.update(index, movieSelected);
	}

	/**
	 * Devuelve todas las peliculas actualmente registradas en la lista del repo
	 * @return
	 */
	public ArrayList<Movie> getAll() {
		return movieRepository.getAll();
	}
	
}
