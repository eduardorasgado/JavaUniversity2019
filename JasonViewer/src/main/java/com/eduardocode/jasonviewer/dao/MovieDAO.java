package com.eduardocode.jasonviewer.dao;

import java.util.ArrayList;

import com.eduardocode.jasonviewer.model.Movie;

/**
 * <h1>MovieDAO</h1>
 * Interfaz que ofrece un acceso a datos para el modelo de pelicula
 * 
 * <p>
 * 
 * Usaremos interfaces para implementar métodos que se comporten entre familias. 
 * Es decir la relación que va más allá de la herencia entre dos clases.
 * 
 * Usaremos clases abstractas para definir subclases, esta siempre deberá ser 
 * heredada para poder utilizar y sobre escribir métodos de la clase padre.
 * @author Eduardo Rasgado Ruiz
 *
 */
public interface MovieDAO {

	/**
	 * Metodo para introducir una pelicula en la clase que implemente la 
	 * interface movie dao
	 * @param movie
	 * @return
	 */
	default Movie setMovieView(Movie movie) {
		return movie;
	}
	
	/**
	 * Retorna una lista de peliculas
	 * @return
	 */
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		return movies;
	}
	
	// en java 9 en adelante es posible crear metodos private en interfaces
	//private void doSomething();
	
	public static boolean getMovieView() {
		return false;
	}
}
