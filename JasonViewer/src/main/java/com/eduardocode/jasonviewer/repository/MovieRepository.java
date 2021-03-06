package com.eduardocode.jasonviewer.repository;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Movie;

/**
 * Repositorio encargado de realizar la logica de las operaciones de transaccion
 * con la base de datos de peliculas
 * @author cheetos
 *
 */
public class MovieRepository implements JVRepository<Movie> {
	private ArrayList<Movie> movies = null;
	
	public MovieRepository() {
		this.movies = new ArrayList<Movie>();
		this.initMovieList();
	}
	
	/**
	 * Devuelve todas las peliculas existentes en el repositorio
	 * @return
	 */
	@Override
	public ArrayList<Movie> getAll() {
		return movies;
	}
	
	/**
	 * Metodo que devuelve una pelicula dado su indice en la lista,
	 * caso en que no exista este devuelve nulo
	 * @param index
	 * @return
	 */
	@Override
	public Movie findByIndex(int index) {
		if(index >= 0 && index < movies.size()) {
			//System.out.println("pelicula encontrada es: "+movies.get(index));
			return movies.get(index);
		} else {
			return null;
		}
	}
	
	/**
	 * retorna un entero que sera un indice dada una pelicula que se encuentre
	 * en la lista
	 * @param movie
	 * @return
	 */
	@Override
	public int getResourceIndex(Movie movie) {
		for(int i = 0;i < movies.size(); i++) {

			String dbRTitle = movies.get(i).getTitle();
			String givenRTitle = movie.getTitle();
			
			if(dbRTitle.equals(givenRTitle)) {
				// retorna el indice de la pelicula dada
				return i;
			}
		}
		// pelicula no existente
		return -1;
	}
	
	/**
	 * Insertar una nueva pelicula en el repositorio
	 * @param movie
	 */
	@Override
	public void insert(Movie movie) {
		movies.add(movie);
	}
	
	/**
	 * Elimina una pelicula dada la existencia de un indice que ha sido tomado
	 */
	@Override
	public boolean delete(int index) {
		if((index >= 0) && (index < movies.size())) {
				//System.out.println("pelicula a eliminar(repo) indice:"+index);
				movies.remove(index);
				return true;
		}
		//System.out.println("No se elimmino pelicula");
		return false;
	}
	
	
	
	/**
	 * reemplaza una pelicula por otra en un indice determinado del arreglo
	 * @param index
	 * @param movie
	 * @return
	 */
	@Override
	public boolean update(int index, Movie movie) {
		if(index >= 0 && index < movies.size()) {
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
