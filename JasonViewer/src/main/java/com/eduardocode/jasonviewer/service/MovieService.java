package com.eduardocode.jasonviewer.service;

import java.util.ArrayList;
import java.util.Date;

import com.eduardocode.jasonviewer.dao.MovieDAO;
import com.eduardocode.jasonviewer.model.Movie;
import com.eduardocode.jasonviewer.repository.MovieRepository;

/**
 * Implementacion de la interfaz watchable para los servicios de las peliculas
 * @author cheetos
 *
 */
public class MovieService extends WatchableService 
							implements IWatchableService<Movie>, MovieDAO {

	private MovieRepository movieRepository;
	
	public MovieService() {
		this.movieRepository = new MovieRepository();
	}
	
	/**
	 * Actualiza los atributos respecto a tiempo y si una pelicula ya fue vista o no
	 * tambien simula la visualizacion de una pelicula mediante el manejo de sleep
	 * dado un indice
	 */
	@Override
	public void playResource(int index) {	
		Movie movieSelected = this.movieRepository.findByIndex(index);
		
		movieSelected.setViewed(true);
		Date dateI = movieSelected.startToSee(new Date());
		this.simulateTimeLapse(2000);
		movieSelected.stopToSee(dateI, new Date());
		
		// intercambiar la pelicula que modificamos por el nuevo elemento
		this.movieRepository.update(index, movieSelected);
	}

	/**
	 * Devuelve todas las peliculas actualmente registradas en la lista del repo
	 * @return
	 */
	@Override
	public ArrayList<Movie> getAll() {
		//return movieRepository.getAll();
		return this.read();
	}

	/**
	 * Encuentra y devuelve una pelicula a partir del indice en el que la pelicula
	 * se encuentre dentro de la lista en el repositorio.
	 * Si la pelicula no existe devuelve nulo
	 */
	@Override
	public Movie findByIndex(int index) {
		// de MovieDAO
		return this.get(index);
	}
	
	/**
	 * Devuelve el indice en la lista de peliculas del repositorio, dada una instancia
	 * existente de pelicula. Si no existe devuelve -1
	 */
	@Override
	public int getResourceIndex(Movie movie) {
		return movieRepository.getResourceIndex(movie);
	}
	
	/**
	 * Elimina una pelicula de la lista del repositorio dado el indice en el que 
	 * se encuentra esta pelicula
	 */
	@Override
	public boolean delete(int index) {
		boolean deleted = movieRepository.delete(index);
		return deleted;
	}

	@Override
	public boolean update(int index, Movie movie) {
		return movieRepository.update(index, movie);
	}
	
}
