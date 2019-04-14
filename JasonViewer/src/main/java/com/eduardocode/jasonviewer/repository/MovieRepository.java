package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;
import java.util.List;

import com.eduardocode.jasonviewer.model.Movie;

/**
 * Repositorio encargado de realizar la logica de las operaciones de transaccion
 * con la base de datos de peliculas
 * @author cheetos
 *
 */
public class MovieRepository {
	private ArrayList<Movie> movies;
	
	public MovieRepository() {
		this.movies = new ArrayList<Movie>();
		this.initMovieList();
	}
	
	/**
	 * Devuelve todas las peliculas existentes en el repositorio
	 * @return
	 */
	public ArrayList<Movie> getAll() {
		return movies;
	}
	
	/**
	 * Insertar una nueva pelicula en el repositorio
	 * @param movie
	 */
	public void insert(Movie movie) {
		movies.add(movie);
	}
	
	/**
	 * Eliminar una pelicula existente en el repositorio
	 * @param movie
	 * @return
	 */
	public boolean delete(Movie movie) {
		for(Movie m : movies) {
			if(m.equals(movie)) {
				// si la pelicula existe entonces es eliminada
				movies.remove(movie);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * reemplaza una pelicula por otra en un indice determinado del arreglo
	 * @param index
	 * @param movie
	 * @return
	 */
	public boolean update(int index, Movie movie) {
		if(index > 0 && index < movies.size()) {
			movies.set(index, movie);
			return true;
		} else {
			return false;
		}
	}
	
	public void initMovieList() {
		movies.add(new Movie("Moana", "Terror", "Terry Colby", 120, (short) 2017));
    	movies.add(new Movie("Indestructibles", "Accion", "Terry Colby", 130, (short) 2017));
    	movies.add(new Movie("King Kong 2", "Animales", "Steven Spielberg", 210, (short) 2018));
    	movies.add(new Movie("Batman 2", "Heroes", "Patrick M.", 180, (short) 2018));
    	movies.add(new Movie("Captain Marvel", "Aventuras", "Marvel Studios", 140, (short) 2019));
	}
}
