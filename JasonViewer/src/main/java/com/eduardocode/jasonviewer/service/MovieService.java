package com.eduardocode.jasonviewer.service;

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
	
	public void playResource(int index) {
		//Movie movieSelected = movieRepository 		
	}
}
