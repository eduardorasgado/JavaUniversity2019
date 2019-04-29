package com.eduardocode.jasonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eduardocode.jasonviewer.db.IDBConnection;
import com.eduardocode.jasonviewer.model.Movie;

import static com.eduardocode.jasonviewer.db.MovieMap.*;

/**
 * <h1>MovieDAO</h1>
 * Interfaz que ofrece un acceso a datos para el modelo de pelicula
 * 
 * <p>
 * 
 * Usaremos interfaces para implementar métodos que se comporten entre familias. 
 * Es decir la relación que va más allá de la herencia entre dos clases.
 * 
 * Enfocado a acciones:
 * 	Drawable
 * 	Runnable
 * 	Callable
 * 	Visualizable
 * 
 * Usaremos clases abstractas para definir subclases, esta siempre deberá ser 
 * heredada para poder utilizar y sobre escribir métodos de la clase padre.
 * 
 * Enfocado a objetos:
 * 	Film
 * 	Persona
 * 	Empleado
 * 	Figure
 * 	Publication
 * 
 * Recomendaciones al hacer abstracciones:
 * 	Enfocarse en crear interfaces y no en la implementacion
 * 	Esto es:
 * 		Crear buenas abstracciones
 * 		Comportamiento común
 * 		Declaración de métodos
 * 
 * @author Eduardo Rasgado Ruiz
 *
 */
public interface MovieDAO extends IDBConnection {

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
		
		String query = "SELECT * FROM "+TMOVIE+";";
		
		// creando una conexion a la base de datos con la funcion de la clase
		// IDBConnection
		try(Connection connection= this.connectToDB()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				// revisando fila por fila de los datos traidos de la db
				// llenando el arreglo de peliculas con los datos de la busqueda
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE),
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR))
						);
				movie.setId(
							Integer.valueOf(rs.getString(TMOVIE_ID))
						);
				
				movies.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	// en java 9 en adelante es posible crear metodos private en interfaces
	//private void doSomething();
	
	public static boolean getMovieView() {
		return false;
	}
}
